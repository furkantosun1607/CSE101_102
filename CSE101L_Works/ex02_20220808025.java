import java.util.Scanner;

public class ex02_20220808025 {
    public static void main(String[] args) {
       //exercise one
        Scanner scanner = new Scanner(System.in);
        System.out.println(" Enter a number:");
        int a = scanner.nextInt();
        int b = a % 10;
        int c = a - b;
        int d = c % 100;
        int e = d / 10;

        System.out.println("|"+e+"|");

        // exercise two

        System.out.println("Enter the number of minutes" +
                " you used the charging system ");
        int mn = scanner.nextInt();
        double pma = 50./60;
        if (mn<=60){
            int ra = 60-mn;
            double ss = ra * pma;
            System.out.println("the amount you need to pay: 50 liras");
            System.out.println(" The overpaid amount is:"+ ss );
        }
        else {
        int ph = mn / 60 + 1;
        int tt = ph * 50;
        int fgs = 60 - (mn % 60);
        double fgf = fgs * pma;
        System.out.println("the amount you need to pay:"+ tt);
        System.out.println(" The overpaid amount is:"+ fgf );

        }

        // exercise 3
        System.out.println(" Enter number of the trial:");
        int k = scanner.nextInt();
        double g=Math.pow( 1-1.0/6 , k-1);
        double vb = g * (1.0/6);
        System.out.println("The probability of rolling the first 4 on trial "+
         k + " is " + vb +" . " );
    }
    }

