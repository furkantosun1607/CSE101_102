import java.util.ArrayList;

public class Lab06_20220808025 {

    public static void main(String[] args) {


    }


}

interface Colorablee {
    public static final int BLUE=255;
    public static final int RED=255;
    public static final int GREEN=255;



    int getRed();




}
interface Electric {
   void  chargeBattery(int currentbattery);




}
interface Combusition{
    void refuel();



}
interface Rentable{
    Rentable rentOut(Gallery gallery);
    void returnVehicle(Gallery gallery);

}
interface Diesel extends Combusition, Rentable {
    void cleanDieselFilter();



}
abstract class  Vehicl{
    private String model;
    private int year;

    public Vehicl(String model, int year){
        setModel(model);
        setYear(year);

    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public String getModel() {
        return model;
    }
    abstract public void startEngine();

    @Override
    public String toString() {
        return this.getClass().getSimpleName()+ " model: "+model+" year: "+year;
    }
}

abstract class Aircraft extends Vehicl{
    public Aircraft(String model, int year){
        super(model,year);
    }
    abstract public void fly();


}
abstract class Ship extends Vehicl{
    public Ship(String model, int year){
        super(model,year);
    }
    abstract public void sail();


}
abstract class Cars extends Vehicl implements Comparable<Cars>{
    private int horsepower;

    public Cars(String model, int year, int horsepower){
        super(model, year);
        setHorsepower(horsepower);
    }

    public void setHorsepower(int horsepower) {
        this.horsepower = horsepower;
    }

    @Override
    public int compareTo(Cars o) {
        return this.getHorsepower() - o.getHorsepower();
    }
   abstract public void drive();

    public int getHorsepower() {
        return horsepower;
    }
}

class Tesla extends Cars implements Electric,Rentable{
    private int currentbattery;
    public Tesla(String model, int year, int horsepower){
        super(model, year, horsepower);

    }

    @Override
    public void startEngine() {
        System.out.println("started to engine of" +this.getClass().getSimpleName());
    }

    public int getCurrentbattery() {
        return currentbattery;
    }

    public void drive() {
        System.out.println("driving"+this+toString()+"with"+getHorsepower());
    }

    @Override
    public void chargeBattery(int currentbattery) {

    }

    @Override
    public Rentable rentOut(Gallery gallery) {
        return null;
    }

    @Override
    public void returnVehicle(Gallery gallery) {

    }

    @Override
    public int getHorsepower() {
        return super.getHorsepower();
    }

    @Override
    public int compareTo(Cars o) {
        return this.getHorsepower()-o.getHorsepower();
    }

}
class Ford extends Cars implements Combusition{
    Ford(String model,int year, int horsepower){
        super(model, year, horsepower);
    }
    @Override
    public void startEngine() {
        System.out.println("started to engine of" +this.getClass().getSimpleName());
    }

    @Override
    public void refuel() {

    }

    public void drive() {
        System.out.println("driving"+this+toString()+"with"+getHorsepower());
    }


    @Override
    public int getHorsepower() {
        return super.getHorsepower();
    }

    @Override
    public int compareTo(Cars o) {
        return this.getHorsepower()-o.getHorsepower();
    }


}
class Mercedes extends Cars implements Electric,Diesel{
    private int currentbattery;
    public Mercedes(String model, int year, int horsepower){
        super(model, year, horsepower);

    }

    @Override
    public void cleanDieselFilter() {

    }

    @Override
    public void refuel() {

    }

    @Override
    public void startEngine() {
        System.out.println("started to engine of" +this.getClass().getSimpleName());
    }

    public int getCurrentbattery() {
        return currentbattery;
    }

    public void drive() {
        System.out.println("driving"+this+toString()+"with"+getHorsepower());
    }

    @Override
    public void chargeBattery(int currentbattery) {

    }

    @Override
    public Rentable rentOut(Gallery gallery) {
        return null;
    }

    @Override
    public void returnVehicle(Gallery gallery) {

    }

    @Override
    public int getHorsepower() {
        return super.getHorsepower();
    }

    @Override
    public int compareTo(Cars o) {
        return this.getHorsepower()-o.getHorsepower();
    }

}

class Gallery{
    private ArrayList<Combusition> combustionCars;
    private ArrayList<Electric> electricCARS;

    public Gallery(){

        combustionCars=new ArrayList<>();
        electricCARS=new ArrayList<>();

    }
    public void addCar(Cars car){
    if(car instanceof Combusition){
        combustionCars.add((Combusition) car);
    }
    if(car instanceof Electric){
        electricCARS.add((Electric)car );
    }


    }
    public void addCombusitionCar(Combusition car){
        this.combustionCars.add(car);


    }

    public void addElectricCar(Electric car){
        this.electricCARS.add(car);


    }
    public void displayRentableCars(){
        ArrayList<Rentable> rentables = new ArrayList<>();
        for (Combusition car:combustionCars) {
            if(car instanceof Rentable){
              rentables.add((Rentable) car);
            }

        }
        for (Electric car:electricCARS) {
            if(car instanceof Rentable){
                rentables.add((Rentable) car);
            }

        }


    }


}


