import java.util.Date;

public class HW02_20220808025 {


    public static void main(String[] args) {

    }

}


class Ticket {
    private City from;
    private City to;
    private Date date;
    private  int seat;


    public Ticket(City from, City to, Date date, int seat){
        setDate(date);
        setSeat(seat);
        setFrom(from);
        setTo(to);

    }
    public Ticket(City from, City to, int seat){
        Date tomorrow=new Date(System.currentTimeMillis() + 24 * 60 * 60 * 1000);
        setDate(tomorrow);
        setSeat(seat);
        setFrom(from);
        setTo(to);

    }


    public void setFrom(City from) {
        this.from = from;
    }

    public void setTo(City to) {
        this.to = to;
    }

    public City getFrom() {
        return from;
    }

    public City getTo() {
        return to;
    }

    public Date getDate() {
        return date;
    }

    public int getSeat() {
        return seat;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

}

class City {
    private String postalCode;
    private String name;

    public City(String postalCode, String name){
        setName(name);
        setPostalCode(postalCode);


    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getName() {
        return name;
    }

    public String getPostalCode() {
        return postalCode;
    }
}


class Person33 { // classNAME HATALI !!!!!!!!!!!!!!!

   private String name;
   private String surname;
   private String phoneNumber;

   public Person33 (String name,String surname, String phoneNumber){ //cons hatalı
       setName(name);
       setSurname(surname);
       setPhoneNumber(phoneNumber);


   }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getSurname() {
        return surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}