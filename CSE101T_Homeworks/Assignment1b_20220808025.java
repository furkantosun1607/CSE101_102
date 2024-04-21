import java.util.Scanner;

public class Assignment1b_20220808025 {
    public static void main(String[] args)
    {
        System.out.println("20220808025 - Furkan Tosun - 1st year student ");
        System.out.println(" Please enter the grading weight" +
                "(percentages) for the following categories: ");
        Scanner scanner = new Scanner(System.in);
        System.out.println( "Quizzes:" );
        /* p =  percantage of
           q = quizzes    m = midterm exam
           h = homeworks   f = final exam
         */
        int pq = scanner.nextInt();
        if (pq < 0 || pq > 100)
        {
            System.out.print( "ERROR: Invalid value entered");
            System.out.println("(must be 0 between 100)");
        }
        else {
        System.out.println( "Homework:" );
        double ph = scanner.nextInt();
        if (ph < 0 || ph > 100)
        {
            System.out.print( "ERROR: Invalid value entered");
            System.out.println("(must be 0 between 100)");
        }
        else {
        System.out.println( "Midterm Exam:" );
        double pm = scanner.nextInt();
        if (pm < 0 || pm > 100) {
            System.out.print( "ERROR: Invalid value entered");
            System.out.println("(must be 0 between 100)");
            }
        else {

        System.out.println( "Final Exam:" );
        double pf = scanner.nextInt();
        if (pf < 0 || pf > 100) {
            System.out.print( "ERROR: Invalid value entered");
            System.out.println("(must be 0 between 100)");
            }

         else if (pq + pf + ph + pm != 100){
            System.out.print("The sum of the percentages: ");
            System.out.println(" must be 100");
            }
         else {
        System.out.println("Please enter the what Furkan Tosun earned for each category");
        System.out.println( "Quizzes:" );
        double  q  = scanner.nextInt();
        if (q < 0 || q > 100) {
            System.out.print( "ERROR: Invalid value entered");
            System.out.println("(must be 0 between 100)");
            }
        else {
        System.out.println( "Homework:" );
        double h = scanner.nextInt();
        if (h < 0 || h > 100) {
            System.out.print( "ERROR: Invalid value entered");
            System.out.println("(must be 0 between 100)");
            }
        else {
        System.out.println( "Midterm Exam:" );
        double m = scanner.nextInt();
        if (m < 0 || m > 100) {
            System.out.print( "ERROR: Invalid value entered");
            System.out.println("(must be 0 between 100)");
            }
        else {


        System.out.println( "Final Exam:" );
        double f = scanner.nextInt();
        if (f < 0 || f >100) {
            System.out.print( "ERROR: Invalid value entered");
            System.out.println("(must be 0 between 100)");
            }
        else {
        double result = (pq * q)/100 + (ph * h)/100 +
                (pm * m)/100 + (pf * f)/100;
        if (result>=88){
        System.out.println( "Furkan Tosun passed CSE 101 with a score of " + result +
                ", GPA points of 4.0, and a grade letter of AA");
        }
         else if (result>=81){
            System.out.println( "Furkan Tosun passed CSE 101 with a score of "
                    +result+", GPA points of 3.5, and a grade letter of BA");
        }
         else if (result>=74){
            System.out.println( "Furkan Tosun passed CSE 101 with a score of "
                    +result+", GPA points of 3.0, and a grade letter of BB");
        }
            else if (result>=67){
                System.out.println( "Furkan Tosun passed CSE 101 with a score of "
                        +result+", GPA points of 2.5, and a grade letter of CB");
            }
         else if (result>=60){
            System.out.println( "Furkan Tosun passed CSE 101 with a score of "
                    + result +", GPA points of 2.0, and a grade letter of CC");
        }
         else if (result>=53){
            System.out.println( "Furkan Tosun conditionally passed CSE 101 with a score of "
                    +result+ ", GPA points of 1.5, and a grade letter of DC");
        }
         else if (result>=46){
            System.out.println( "Furkan Tosun conditionally passed CSE 101 with a score of "
                    +result+ ", GPA points of 1.0, and a grade letter of DD");
        }
         else if (result>=35){
            System.out.println( "Furkan Tosun did not pass CSE 101 with a score of "
                    +result+ ", GPA points of 0.5, and a grade letter of FD");
        }
        else if  (result>=0){
            System.out.println( "Furkan Tosun did not pass CSE 101 with a score of "
                    + result + ", GPA points of 0.0, and a grade letter of FF");
        }
        }
        }
}
}
}
}
}
        }
    }
}