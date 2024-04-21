import javax.naming.InsufficientResourcesException;
import java.util.ArrayList;

public class Lab04_20220808025 {
    public static void main(String[] args) throws AccountException, InvalidAmountException {
        Account acc= new Account(10);
        UserAccount user=new UserAccount("furkan");
        user.deactiveAccount();
        BankAccount bankaccount= new BankAccount(acc,5,500);

        try {
            System.out.println(
                    "account is active ;"+ user.isActive()
            );
        }catch (AccountNotFoundException e){
            System.out.println("hesap bulunamadı");
        }




        try{
            setAccount(-5);
        }

        catch (AccountException e){
            System.out.println(e.getMessage());
            System.out.println("naber");
        }
        finally {
            System.out.println("aa");
        }
    }

    public static void getAccount(int id) throws AccountException{
        if(id<0){throw new AccountException(new Account(5));}
        else {

        }

    }
    public static void setAccount(int id) throws AccountException {
        if(id!=5) throw new AccountException(new Account(5));


    }


}



class AccountException extends Exception{
    private Account account;

    public AccountException(Account account){
        this.account=account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Account getAccount() {
        return account;
    }
}

class InvalidOperationException extends RuntimeException {
    private UserAccount user;

    InvalidOperationException(UserAccount user){
       this.user=user;
    }


}

class Account {
    int id =5;
    public Account (int id){
        setId(id);
    }

    public void setId(int id) {
        this.id = id;
    }
}

class UserAccount{
    private String userName;
    private  int id;
    private boolean active;
    private ArrayList<BankAccount> bankAccount;


    public UserAccount(String userName){
        setUserName(userName);
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isActive() throws AccountNotFoundException {
        System.out.println("aCOOUNT is active");
        return active;
    }

    public boolean setActive(int id) {
        for (BankAccount bankaccounts: bankAccount) {
            if(bankaccounts.getId()==id) return bankaccounts.isActive();
        }
        return false;
    }

    public  void deactiveAccount() throws AccountException,InvalidAmountException{
        if(!active){new AccountException(new Account(5));}


    }

    @Override
    public String toString() {
        return String.format("Account: \n\t id: %d \n\t usename "+id+userName+active);
    }
}
class BankAccount{
    private int id;
    private  boolean active;
    private double balance;
    private Account account;

    public BankAccount(Account account, int id, double balance) throws InvalidAmountException{
        setId(id);
        setAccount(account);
        setBalance(balance);
        try {

        }catch (RuntimeException e){
            this.balance=0;
        }

    }
    public void withdraw(double amount)throws InvalidAmountException{
        if(amount>this.balance)
            throw new InsufficentFundsException(amount);

    }

    public void setBalance(double balance) {
        if(balance<0)
        this.balance = balance;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isActive() {
        return active;
    }
}
class AccountNotFoundException extends Exception{
    private int id;
    AccountNotFoundException(int id){
        this.id=id;
    }
}

class InvalidAmountException extends Exception {
    private double amount;

    InvalidAmountException(double amount){
        this.amount=amount;
    }


}
class InsufficentFundsException extends InvalidAmountException {
    InsufficentFundsException(double amount){
        super(amount);

    }


}














































