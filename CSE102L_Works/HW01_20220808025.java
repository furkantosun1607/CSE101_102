public class HW01_20220808025 {

    public static void main(String[] args) {
        Fan fan1= new Fan();
        System.out.println(fan1.toString()+" "+fan1.isOn());
        fan1.change();
        System.out.println(fan1.toString()+" "+fan1.isOn());
        Fan fan2 = new Fan(16.598,"Red");
        System.out.println(fan2.toString()+" "+fan2.isOn());
        fan2.setSpeed(3);
        System.out.println(fan2.toString()+" "+fan2.isOn());
        fan2.change();
        fan2.setSpeed(3);
        System.out.println(fan2.toString()+" "+fan2.isOn());
        Stock stock1 = new Stock("tprs","tÜprAş");
        System.out.println(stock1.toString());
    }




}
class Stock {
    private String symbol;
    private String name;
    private double previousClosingPrice;
    private  double currentPrice;

    public Stock(String symbol, String name){
        this.symbol=symbol.toUpperCase();
        String firstletter = "" +
                name.charAt(0);
        this.name = firstletter.toUpperCase() +
                name.toLowerCase().substring(1);
    }

    public String getSymbol() {
        return symbol;
    }

    public String getName() {
        return name;
    }

    public double getPreviousClosingPrice() {
        return previousClosingPrice;
    }

    public double getCurrentPrice() {
        return currentPrice;
    }

    public void setPreviousClosingPrice(double previousClosingPrice) {
        if(previousClosingPrice<0){
            System.out.println("ERROR: Closing price cannot be negative");
        }
        else
        {this.previousClosingPrice = previousClosingPrice;}
    }

    public void setCurrentPrice(double currentPrice) {
        if(currentPrice<0){
            System.out.println("ERROR: Current price cannot be negative");
        }
        else{
        this.currentPrice = currentPrice;}
    }
    public double getChangePercent(){
        if(previousClosingPrice<0){return 0;}
        else {
        return ((currentPrice-previousClosingPrice)/previousClosingPrice)*100; }
    }

    @Override
    public String toString() {
        return "[" + symbol + "] - "+" [" + name + "]"+": " +" ["+ currentPrice+"]";
    }
}

class Fan {
    private static int SLOW=1;
    private static int MEDIUM=2;
    private static int FAST=3;
    private int speed;
    private boolean on;
    private double radius;
    private String color;

    public Fan(){
    speed=SLOW;
    on=false;
    radius=5;
    color="Blue";
    }
    public  Fan(double radius, String color){
        this();
        this.radius=radius;
        this.color=color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public void setSpeed(int speed) {
        if(on==true){
        this.speed = speed;}
    }

    public double getRadius() {
        return radius;
    }

    public int getSpeed() {
        return speed;
    }

    public String getColor() {
        return color;
    }
    public boolean isOn(){
        return on;
    }
    public void change(){
        this.on=!on;
    }

    public String toString() {
        if (on) {
            return String.format("Speed: %d, Radius %.2f, Color: %s", speed, radius, color);
        } else {
            return "Fan is off";
        }
    }
}
