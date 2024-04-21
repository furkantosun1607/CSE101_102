import java.util.Scanner;
public class Ex04_20220808025 {
    public static void main(String[] args) {

        // EX1

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the center point of circle: ");
        double xcenter = scanner.nextDouble();
        double ycenter = scanner.nextDouble();
        System.out.println("Enter the point on circle's edge: ");
        double x1 = scanner.nextDouble();
        double y1 = scanner.nextDouble();
        double radius = Math.sqrt((xcenter - x1) * (xcenter - x1) + (y1 - ycenter) * (y1 - ycenter));
        double area = radius * radius * Math.PI;
        double circumference = 2 * Math.PI * radius;
        System.out.println("The circumference of the circle is: " + circumference);
        System.out.println("The area of the circle is: " + area);

        // EX2

        System.out.println("Enter the fullname: ");
        scanner.nextLine();
        String fullname = scanner.nextLine();
        char space = ' ';
        String[] dividedname = fullname.split(String.valueOf(space),2);
        String name = dividedname[0];
        String surname = dividedname[1];
        System.out.println(surname +","+name);





        // EX 3


        System.out.print("Enter the day number (1-7): ");
        int daynumber = scanner.nextInt();
        String dayname = switch (daynumber) {
            case 1 -> "Monday";
            case 2 -> "Tuesday";
            case 3 -> "Wednesday";
            case 4 -> "Tuesday";
            case 5 -> "Friday";
            case 6 -> "Saturday";
            case 7 -> "Sunday";
            default -> "Invalid number";
        };

        System.out.println("Day: " + dayname);


        // EX4

        System.out.print("Enter the first city name: ");
        String city1 = scanner.next();
        System.out.print("Enter the first city name: ");
        String city2 = scanner.next();
        System.out.print("Enter the first city name: ");
        String city3 = scanner.next();
        String abd;
        if (city1.compareTo(city2) > 0) {
            abd = city1;
            city1 = city2;
            city2 = abd;
        }
        if (city2.compareTo(city3) > 0) {
            abd = city2;
            city2 = city3;
            city3 = abd;
        }
        if (city1.compareTo(city2) > 0) {
            abd = city1;
            city1= city2;
            city2 = abd;
        }


        System.out.println("The cities:");
        System.out.println(city1);
        System.out.println(city2);
        System.out.println(city3);





        // EX5

            System.out.print("Enter the height of triangle: ");
            double height = scanner.nextDouble();
            System.out.print("Enter the base of triangle: ");
            double base = scanner.nextDouble();
            double areatriangle = 0.5 * base * height;
            System.out.printf("Area of the circle: %.3f", areatriangle);


        }
    }



