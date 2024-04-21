
public class HW03_20220808025 {

    public static void main(String[] args) {


    }

}

class Author{
    private String name;
    private String surname;
    private  String mail;


    public Author(String name, String surname, String mail){
        setMail(mail);
        setSurname(surname);
        setName(name);

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getMail() {
        return mail;
    }
}

class Book {
    private  String isbn;
    private  String title;
    private  Author author;
    private  double price;

    public Book (String isbn, String title, Author author, double price){
        setAuthor(author);
        setIsbn(isbn);
        setPrice(price);
        setTitle(title);

    }
    public Book (String isbn, String title, Author author){
        setAuthor(author);
        setIsbn(isbn);
        setPrice(15.25);
        setTitle(title);

    }
    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public Author getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }

    public String getIsbn() {
        return isbn;
    }



    public void setPrice(double price) {
        this.price = price;
    }
}

class EBook extends  Book {
    private  String downloadUrl;
    private  double sizeMb;
    public EBook(String isbn, String title, Author author, double price, String downloadUrl,double sizeMb){
        super(isbn, title, author, price);
        this.setSizeMb(sizeMb);
        this.setDownloadUrl(downloadUrl);
    }
    public EBook(String isbn, String title, Author author, String downloadUrl,double sizeMb){
        super(isbn, title, author);
        this.setSizeMb(sizeMb);
        this.setDownloadUrl(downloadUrl);
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    public void setSizeMb(double sizeMb) {
        this.sizeMb = sizeMb;
    }

    public double getSizeMb() {
        return sizeMb;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

}
class PaperBook extends Book {
    private int shippingWeight;
    private  boolean inStock;

    public PaperBook(String isbn, String title, Author author, double price, int shippingWeight, boolean inStock){
        super(isbn, title, author, price);
        setShippingWeight(shippingWeight);
        setInStock(inStock);
    }
    public PaperBook(String isbn, String title, Author author, boolean inStock){
        super(isbn, title, author);
        setShippingWeight((int)(Math.random()*10+5));
        setInStock(inStock);
    }

    public int getShippingWeight() {
        return shippingWeight;
    }
    public boolean getInStock() {
        return inStock;
    }

    public void setShippingWeight(int shippingWeight) {
        this.shippingWeight = shippingWeight;
    }

    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }
}