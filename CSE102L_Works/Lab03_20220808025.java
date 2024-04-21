import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class Lab03_20220808025 {
    public static void main(String[] args) {
        Car car= new Car("BMW","M4",2004,true,6,true);
        Vehicle truck= new Truck("SCODA","Q3",2008,true,1,true);
        car.run();
        truck.run();
        Vehicle[] parkinglot= new Vehicle[]{truck,car};
        for (Vehicle vehicle:parkinglot) {
            vehicle.run();
        }
        for (int i = 0; i < parkinglot.length; i++) {
            parkinglot[i].run();
        }

    }

}

abstract class Vehicle {
    private String brand;
    private  String model;
    private int year;
    private boolean isRented;

    public Vehicle(String brand, String model, int year, boolean isRented){
        setBrand(brand);
        setModel(model);
        setYear(year);
        setRented(isRented);
    }

    public boolean isRented() {
        return isRented;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public String getBrand() {
        return brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setRented(boolean rented) {
        isRented = rented;
    }

    public void setYear(int year) {
        this.year = year;
    }
    public abstract  void run();



}
 class Car extends Vehicle {
    private int passenger_capacity;
    private boolean automatic_transmission;

    public Car(String brand, String model, int year, boolean is_rented,int passenger_capacity, boolean automatic_transmission){
        super(brand,model,year,is_rented);
        setAutomatic_transmission(automatic_transmission);
        setPassenger_capacity(passenger_capacity);
    }


    public int getPassenger_capacity() {
        return passenger_capacity;
    }

    public void setAutomatic_transmission(boolean automatic_transmission) {
        this.automatic_transmission = automatic_transmission;
    }

    public void setPassenger_capacity(int passenger_capacity) {
        this.passenger_capacity = passenger_capacity;
    }
    public boolean isAutomatic_transmission(){
        return automatic_transmission;
    }
    public void run(){
        System.out.println("Car is running");
    }


}
 class Truck extends Vehicle{
    private int loadCapacity;
    private boolean fourWheelDrive;

    public Truck(String brand, String model, int year, boolean is_rented,int loadCapacity,boolean fourWheelDrive){
        super(brand,model,year,is_rented);
        setLoadCapacity(loadCapacity);
        setFourWheelDrive(fourWheelDrive);
    }
    public boolean isFourWheelDrive(){
        return fourWheelDrive;
    }


    public void setLoadCapacity(int loadCapacity) {
        this.loadCapacity = loadCapacity;
    }

    public void setFourWheelDrive(boolean fourWheelDrive) {
        this.fourWheelDrive = fourWheelDrive;
    }

    public int getLoadCapacity() {
        return loadCapacity;
    }

     @Override
     public void run() {
         System.out.println("Truck is running");
     }
 }
 class Motorcycle extends Vehicle{
    private int engineVolume;
    private boolean hasABS;
    public  Motorcycle(String brand, String model, int year, boolean isRented, int engineVolume, boolean hasABS){
        super(brand,model,year,isRented);
        setEngineVolume(engineVolume);
        setHasABS(hasABS);
    }


     public void setEngineVolume(int engineVolume) {
         this.engineVolume = engineVolume;

     }

     public void setHasABS(boolean hasABS) {
         this.hasABS = hasABS;
     }

     @Override
     public void run() {
         System.out.println("motorcycle run");
     }
 }







 class Customer{
    private String firstName;
    private  String lastName;
    private  int  IDnumber;
    private ArrayList<Vehicle> rentedVehicles;
    private  ArrayList<RentalContrats> rentalContrats;
    public Customer(String firstName, String lastName){
        setFirstName(firstName);
        setLastName(lastName);
        setIDnumber();
        rentedVehicles= new ArrayList<Vehicle>();
        rentalContrats=new ArrayList<RentalContrats>();
    }

     public void setFirstName(String firstName) {
         this.firstName = firstName;
     }

     public void setIDnumber() {
        Random rnd= new Random();
        IDnumber=rnd.nextInt(1000,9999);
     }

     public void setLastName(String lastName) {
         this.lastName = lastName;
     }

     public ArrayList<RentalContrats> getRentalContrats() {
         return rentalContrats;
     }

     public ArrayList<Vehicle> getRentedVehicles() {
         return rentedVehicles;
     }

     public String getFirstName() {
         return firstName;
     }

     public int  getIDnumber() {
         return IDnumber;
     }

     public String getLastName() {
         return lastName;
     }
     public void rent(Vehicle v, Date startDate, Date endDate){
        rentedVehicles.add(v);
        rentalContrats.add(new RentalContrats(this,v,startDate,endDate));
        rentalContrats.get(rentalContrats.size()-1);


     }
     public Vehicle turnIn(RentalContrats contract){

        Vehicle v= contract.getRentedVehicle();
        rentedVehicles.remove(v);
        rentalContrats.remove(this);
        return v;
     }


 }
 class RentalContrats {
     private Customer customer;
     private Vehicle rentedVehicle;
     private Date startDate;
     private Date endDate;

     public RentalContrats(Customer customer, Vehicle rentedVehicle, Date startDate, Date endDate){
        setCustomer(customer);
        setEndDate(endDate);
        setRentedVehicle(rentedVehicle);
        setStartDate(startDate);
     }

     public void setCustomer(Customer customer) {
         this.customer = customer;
     }

     public void setEndDate(Date endDate) {
         this.endDate = endDate;
     }

     public void setRentedVehicle(Vehicle rentedVehicle) {
         this.rentedVehicle = rentedVehicle;
     }

     public void setStartDate(Date startDate) {
         this.startDate = startDate;
     }

     public Customer getCustomer() {
         return customer;
     }

     public Date getEndDate() {
         return endDate;
     }

     public Date getStartDate() {
         return startDate;
     }

     public Vehicle getRentedVehicle() {
         return rentedVehicle;
     }
     public  Date rentalPeriod(){

         return new Date(endDate.getTime()-startDate.getTime());

     }
 }
