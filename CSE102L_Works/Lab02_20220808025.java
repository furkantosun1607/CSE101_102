public class Lab02_20220808025 {
    public static void main(String[] args) {
      /*  Rectangle rect=new Rectangle(3,5);
        Rectangle rect2= new Rectangle(4,5);
        System.out.printf("Rectangle area %.2f, perimeter %.2f", rect.getArea(), rect.getPerimeter()); */



        String carColor="Red";
        String carModel="Tesla S";
        boolean isCarOn=false;
        int carSpeed=0;
        int carAcceleration=5;
        Cares newCar= new Cares(carColor,carModel,carAcceleration);
        Cares car2=new Cares("Toyota","Blue",8);
        newCar.start();
        newCar.accelerate();
        newCar.accelerate(3);
        newCar.accelerate();
        newCar.accelerate();
        newCar.stop();

    }
    public static  double getArea(double length, double width){
        return length*width;
    }




}

class Rectangle {
    private double length;
    private double width;

    public Rectangle(double length, double width){
        this.length=length;
        this.width=width;
    }

    public void setLength(double length) throws IllegalAccessException {
        if(length>0) {this.length = length;}
        else throw new IllegalAccessException("ERROR : ILLEGAL ARGUMENT");
    }

    public void setWidth(double width) throws IllegalAccessException {
        if(width>0) {this.length = width;}
        else throw new IllegalAccessException("ERROR : ILLEGAL ARGUMENT");
    }
    public double getArea(){
        return width*length;
    }
    public double getPerimeter() {
        return 2*(width+length);

    }

    @Override
    public String toString() {
        return String.format("Rectangle, length: %.2f,width: %.2f    \n", length,width);
    }
}


class Cares {
    private String model;
    private String color;
    private int speed;
    private boolean isOn;
    private int acceleration;

    public Cares(String model, String color){
        this.model=model;
        this.color=color;
        setAcceleration(5);
    }
    public Cares(String model, String color, int acceleration){
        this(model, color);
        setAcceleration(acceleration);
    }
    public void setAcceleration(int acceleration) {
        this.acceleration = acceleration;
    }
    public void start(){
        if(!isOn){isOn=!isOn; System.out.printf("%s %s is starting \n", model,color); }
        else System.out.printf("Car is already started");
    }
    public void stop(){
        if(isOn){isOn=!isOn; speed-=speed; System.out.printf("%s %s is stopped \n", model,color);}
        else System.out.println("CAR IS ALREADY STOPPED");
    }
    public void accelerate(){
        if(isOn){speed+=acceleration;
            System.out.printf("%s %s have the speed %d \n", model,color,speed);}
        else System.out.println("Car is not running");
    }

    public void accelerate(int acceleration){
        setAcceleration(acceleration);
        accelerate();


    }

    @Override
    public String toString() {
        String str1=String.format("%s %s ", model,color);
        String str2= String.format("is running and has speed of %d \n", speed);
        return isOn ? str2:str1;
    }
}
class Persone{
    private String name;





}
class wallet{
    private String color;
    private int amount;

    public wallet(String color){
        this.color=color;
    }
    public wallet(String color, int amount){
        this(color);
        this.amount=amount;
    }

    public String getColor() {
        return color;
    }

    public int getAmount() {
        return amount;
    }
    public void addAmount(){

    }
}
class brain{

}



