import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Quiz01_20220808025 {

    public static void main(String[] args) {




    }

}

interface Item extends Comparable<Item> {
    double getPrice();
    String getName();

}

interface  PaymentMethod {
    boolean pay(List<Item> cart);

}
interface Colorable {
    void paint(String color);




}
abstract  class Product implements  Item {
    private String name;
    private  double price;

    public  Product (String name, double price){
        setPrice(price);
        setName(name);




    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
     if (price>0){
        this.price = price; }
     else  throw new InvalidPriceException(price);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }
}

class Tax implements  Item {
    private double taxRate;
    private  Item item;

    public  Tax(int taxRate, Item item){
        setTaxRate(taxRate);
        setItem(item);

    }

    @Override
    public int compareTo(Item o) {
        return Double.compare(this.item.getPrice(),o.getPrice());
    }

    public void setItem(Item item) {
        this.item = item;
    }

    @Override
    public String getName() {
        return null;
    }


    public void setTaxRate(double taxRate) {
        if(taxRate>0 && taxRate<100)
            this.taxRate = taxRate;
        else  throw  new RuntimeException();
    }

    @Override
    public double getPrice() {
       double  vergiliprice=this.item.getPrice()+this.item.getPrice()*taxRate/100;
        return vergiliprice;
    }

}
class  Discount implements  Item {
    private double percent;
    private  Item item;

    public Discount(int percent, Item item){
        setPercent(percent);
        setItem(item);


    }

    @Override
    public int compareTo(Item o) {
        return 0;
    }

    @Override
    public String getName() {
        return null;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public void setPercent(double percent) {
        if(percent>0 && percent<1)
            this.percent = percent;
        else  throw  new RuntimeException();
    }

    @Override
    public double getPrice() {
        return this.item.getPrice()-this.item.getPrice()*(this.percent/100);
    }
}

class CreditCard implements  PaymentMethod {
    private  long cardNumber;
    private  String holderName;
    private Date expirationDate;
    private int cvv;

    public CreditCard (long cardNumber, String holderName, Date expirationDate, int cvv)throws CreditCardException{
    setCvv(cvv);
    setCardNumber(cardNumber);
    setExpirationDate(expirationDate);
    setHolderName(holderName);

    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public void setCardNumber(long cardNumber) {
        if(cardNumber>999999999999999L &&cardNumber<10000000000000000L)
            this.cardNumber = cardNumber;
        else throw new CreditCardException(cardNumber);
    }

    public void setCvv(int cvv) {
        if (cvv>99 && cvv< 1000)
            this.cvv = cvv;
        else throw new CreditCardException(cvv);
    }

    @Override
    public boolean pay(List<Item> cart) {
        double totalprice=0;
        for (int i = 0; i < cart.size(); i++) {
            totalprice+=cart.get(i).getPrice()+(4/100)*cart.get(i).getPrice();
        }
        System.out.println(this.getClass().getSimpleName()+"Paid "+totalprice+" with"+this.getClass().getSimpleName() +" "+ this.holderName );
        cart =new ArrayList<>();


        return false;
    }
}
class PayPal implements  PaymentMethod {
    private String username;
    private  String password;

    public  PayPal(String username, String password){
        setPassword(password);
        setUsername(username);
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean pay(List<Item> cart) {
        double totalprice=0;
        for (int i = 0; i < cart.size(); i++) {
            totalprice+=cart.get(i).getPrice()+(6/100)*cart.get(i).getPrice();
        }
        System.out.println(this.getClass().getSimpleName()+"Paid "+totalprice+" with"+this.getClass().getSimpleName() +" "+ this.username );
        cart =new ArrayList<>();


        return false;

    }

}
class Customeree {
    private String name;
    private PaymentMethod paymentMethod;
    private  List<Item> cart;

    public Customeree(String name){
        setName(name);
        this.cart=new ArrayList<>();

    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
    public  boolean addItem(Item item) {
        if ( item instanceof Colorable && item.getPrice() >500){

            this.cart.add(item);


        }
        this.cart.add(item);

    return  false;
    }
    public boolean removeItem(Item item){
        this.cart.remove(item);
        return false;
    }

    public boolean purchase(){
    this.paymentMethod.pay(this.cart);
    return  false;

    }
    public void display(){
        cart.sort(Item::compareTo);
        for (int i = 0; i < cart.size(); i++) {
            System.out.println(cart.get(i).getPrice() +" - "+cart.get(i).getName());
        }




    }





}


class CreditCardException extends IllegalArgumentException {
    private long cardNumber;
    private  int cvv;

    public CreditCardException(long cardNumber){
        super("ERROR: Invalid card number "+ cardNumber);
        this.cardNumber=cardNumber;
    }
    public CreditCardException(int  cvv){
        super("ERROR: Invalid CVV "+ cvv);
        this.cvv=cvv;
    }

    public int getCvv() {
        return cvv;
    }

    public long getCardNumber() {
        return cardNumber;
    }



}

class InvalidPriceException extends RuntimeException {

    private double price;

    public InvalidPriceException(double price){
        super(" “ERROR: Invalid price: "+price);
        this.price=price;

    }


}







































