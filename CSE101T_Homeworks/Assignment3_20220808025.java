import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Assignment3_20220808025 {

    public static void main(String[] args) {

        // TESTING THE calculateGrade Method
        String[] category = {"quiz", "hOmEwORk", "miDterm eXam", "finaL ExAm"};
        int[] quantity = {4, 3, 1, 1};
        int[] weight = {10, 20, 30, 40};

        calculateGrade(category, quantity, weight);
    }

    public static void calculateGrade(String[] categories, int[] quantity, int[] weight) {
        // Checking if the sizes are the same
        if (categories.length != quantity.length || categories.length != weight.length) {
            System.out.println("ERROR: Array lengths are not all the same");
        } // Checking if the min value of quantity is < 0
        else if(finding_min(quantity)<0){
            System.out.println(" ERROR: Invalid quantity entered ");
        } // Checking if the total value of weights are > 100 xor min value <0
        else if(total_of_array(weight)>100 || finding_min(weight) <0) {
            System.out.println(" ERROR: Invalid weight entered ");
        }

        else {
            Scanner scanner = new Scanner(System.in);
            formatCategoryName(categories);

            // array for menu method
            String[] main_options = new String[3];
            main_options[0] = " Enter all grades";
            main_options[1] = " Display grade information";
            main_options[2] = " Change a single grade";


            int sumofquantities =total_of_array(quantity);

            // initializing category averages
            double cat1_average = 0;
            double cat2_average = 0;
            double cat3_average = 0;
            double cat4_average = 0;
            double overall_grade = 0;
            // initializing sum of categories scores
            int cat1total=0; int cat2total=0; int cat3total=0; int cat4total=0;

            // making array with using every single grade
            int[] current_points= new int[sumofquantities];

            int choice; int inchoice = 0; // initializing choice
            do {
                 choice = menu(scanner, main_options);

                switch (choice) {
                    case -1:
                        System.out.println("Thanks for using our system."+
                                "Have a nice day"); break; //pressing Q
                    case 0:
                        int points;
                        int abc=0;
                        for (int i = 0; i < categories.length; i++) {
                            points = 0; double current_point=0;
                            for (int j = 1; j <= quantity[i]; j++) {

                                System.out.print("Please enter grade for " +
                                        categories[i] + " " + j + ">>");
                                points = scanner.nextInt();
                                current_points[abc] = points;
                                abc++;

                            }
                        }


                        for (int i = 0; i < quantity[0]; i++) {
                            cat1total += current_points[i];

                        }

                        for (int i = 0; i < quantity[1]; i++) {
                            cat2total += current_points[quantity[0]+i];


                        }

                        for (int i = 0; i < quantity[2]; i++) {
                            cat3total += current_points[quantity[0]+quantity[1]+i];


                        }

                        for (int i = 0; i < quantity[3]; i++) {
                            cat4total += current_points[quantity[0]+quantity[1]+quantity[2]+i];


                        }

                        cat1_average = (double) cat1total / quantity[0];
                        cat2_average = (double) cat2total / quantity[1];
                        cat3_average = (double) cat3total / quantity[2];
                        cat4_average = (double) cat4total / quantity[3];

                        overall_grade = cat1_average * weight[0] / 100 +
                                cat2_average * weight[1] / 100 +
                                cat3_average * weight[2] / 100 +
                                cat4_average * weight[3] / 100;

                        scanner.nextLine();
                        break;
                    case 1:
                        System.out.println(categories[0] + " - " + cat1_average);
                        System.out.println(categories[1] + " - " + cat2_average);
                        System.out.println(categories[2] + " - " + cat3_average);
                        System.out.println(categories[3] + " - " + cat4_average);
                        System.out.println(" ");
                        System.out.println("Overall Grade - " + overall_grade);
                        System.out.println("Grade Letter - " + gradeLetter(overall_grade));
                        System.out.println("GPA points - " + gpaPoints(overall_grade));
                        System.out.println("Status - " + status(overall_grade));
                        System.out.println(" ");
                        break;
                    case 2:
                        System.out.println("Please enter the category: ");
                         inchoice= menu(scanner,categories);
                        int edit_request;
                        switch (inchoice){
                            case -1:
                                System.out.println("Thanks for using our system."+
                                        "Have a nice day"); break;

                            case 0:
                                System.out.println("Please enter which "+ categories[0]+
                                        " you would like to change "+"(1-"+quantity[0]+")");
                                 edit_request= scanner.nextInt();
                                scanner.nextLine();
                                if(edit_request>quantity[0]||edit_request<=0){
                                    System.out.println("Invalid Choice"); break;
                                }
                                else {
                                System.out.println("The current value of "+categories[0]+" "+
                                        edit_request+" is : "+current_points[edit_request-1]);
                                System.out.println("Please enter the new grade value >> ");
                                current_points[edit_request-1]= scanner.nextInt();
                                scanner.nextLine();
                                 cat1total=0;  cat2total=0;  cat3total=0;  cat4total=0;
                                for (int i = 0; i < quantity[0]; i++) {
                                    cat1total += current_points[i];

                                }

                                for (int i = 0; i < quantity[1]; i++) {
                                    cat2total += current_points[quantity[0]+i];


                                }

                                for (int i = 0; i < quantity[2]; i++) {
                                    cat3total += current_points[quantity[0]+quantity[1]+i];


                                }

                                for (int i = 0; i < quantity[3]; i++) {
                                    cat4total += current_points[quantity[0]+quantity[1]+quantity[2]+i];


                                }

                                cat1_average = (double) cat1total / quantity[0];
                                cat2_average = (double) cat2total / quantity[1];
                                cat3_average = (double) cat3total / quantity[2];
                                cat4_average = (double) cat4total / quantity[3];

                                overall_grade = cat1_average * weight[0] / 100 +
                                        cat2_average * weight[1] / 100 +
                                        cat3_average * weight[2] / 100 +
                                        cat4_average * weight[3] / 100;
                            break;}
                            case 1:
                                System.out.println("Please enter which "+ categories[1]+
                                        " you would like to change "+"(1-"+quantity[1]+")");
                                 edit_request= scanner.nextInt();
                                 scanner.nextLine();
                                if(edit_request>quantity[1]||edit_request<=0){
                                    System.out.println("Invalid Choice"); break;
                                }
                                System.out.println("The current value of "+categories[1]+" "+
                                        edit_request+" is : "+current_points[quantity[0]+edit_request-1]);
                                System.out.println("Please enter the new grade value >> ");
                                current_points[quantity[0]+(edit_request)-1]= scanner.nextInt();
                                scanner.nextLine();
                                cat1total=0;  cat2total=0;  cat3total=0;  cat4total=0;
                                for (int i = 0; i < quantity[0]; i++) {
                                    cat1total += current_points[i];

                                }

                                for (int i = 0; i < quantity[1]; i++) {
                                    cat2total += current_points[quantity[0]+i];


                                }

                                for (int i = 0; i < quantity[2]; i++) {
                                    cat3total += current_points[quantity[0]+quantity[1]+i];


                                }

                                for (int i = 0; i < quantity[3]; i++) {
                                    cat4total += current_points[quantity[0]+quantity[1]+quantity[2]+i];


                                }

                                cat1_average = (double) cat1total / quantity[0];
                                cat2_average = (double) cat2total / quantity[1];
                                cat3_average = (double) cat3total / quantity[2];
                                cat4_average = (double) cat4total / quantity[3];

                                overall_grade = cat1_average * weight[0] / 100 +
                                        cat2_average * weight[1] / 100 +
                                        cat3_average * weight[2] / 100 +
                                        cat4_average * weight[3] / 100; break;


                            case 2: System.out.println("Please enter which "+ categories[2]+
                                    " you would like to change "+"(1-"+quantity[2]+")");
                                edit_request= scanner.nextInt();
                                scanner.nextLine();
                                if(edit_request>quantity[2]||edit_request<=0){
                                    System.out.println("Invalid Choice"); break;
                                }
                                System.out.println("The current value of "+categories[2]+" "+
                                        edit_request+" is : "+current_points[quantity[0]+quantity[1]+edit_request-1]);
                                System.out.println("Please enter the new grade value >> ");
                                current_points[quantity[0]+quantity[1]+(edit_request)-1]= scanner.nextInt();
                                scanner.nextLine();
                                cat1total=0;  cat2total=0;  cat3total=0;  cat4total=0;
                                for (int i = 0; i < quantity[0]; i++) {
                                    cat1total += current_points[i];

                                }

                                for (int i = 0; i < quantity[1]; i++) {
                                    cat2total += current_points[quantity[0]+i];


                                }

                                for (int i = 0; i < quantity[2]; i++) {
                                    cat3total += current_points[quantity[0]+quantity[1]+i];


                                }

                                for (int i = 0; i < quantity[3]; i++) {
                                    cat4total += current_points[quantity[0]+quantity[1]+quantity[2]+i];


                                }

                                cat1_average = (double) cat1total / quantity[0];
                                cat2_average = (double) cat2total / quantity[1];
                                cat3_average = (double) cat3total / quantity[2];
                                cat4_average = (double) cat4total / quantity[3];

                                overall_grade = cat1_average * weight[0] / 100 +
                                        cat2_average * weight[1] / 100 +
                                        cat3_average * weight[2] / 100 +
                                        cat4_average * weight[3] / 100; break;

                            case 3: System.out.println("Please enter which "+ categories[3]+
                                    " you would like to change "+"(1-"+quantity[3]+")");
                                edit_request= scanner.nextInt();
                                scanner.nextLine();
                                if(edit_request>quantity[3]||edit_request<=0){
                                    System.out.println("Invalid Choice"); break;
                                }
                                System.out.println("The current value of "+categories[3]+" "+
                                        edit_request+" is : "+current_points[quantity[0]+quantity[1]+quantity[2]+edit_request-1]);
                                System.out.println("Please enter the new grade value >> ");
                                current_points[quantity[0]+quantity[1]+quantity[2]+(edit_request)-1]= scanner.nextInt();
                                scanner.nextLine();
                                cat1total=0;  cat2total=0;  cat3total=0;  cat4total=0;
                                for (int i = 0; i < quantity[0]; i++) {
                                    cat1total += current_points[i];

                                }

                                for (int i = 0; i < quantity[1]; i++) {
                                    cat2total += current_points[quantity[0]+i];


                                }

                                for (int i = 0; i < quantity[2]; i++) {
                                    cat3total += current_points[quantity[0]+quantity[1]+i];


                                }

                                for (int i = 0; i < quantity[3]; i++) {
                                    cat4total += current_points[quantity[0]+quantity[1]+quantity[2]+i];


                                }

                                cat1_average = (double) cat1total / quantity[0];
                                cat2_average = (double) cat2total / quantity[1];
                                cat3_average = (double) cat3total / quantity[2];
                                cat4_average = (double) cat4total / quantity[3];

                                overall_grade = cat1_average * weight[0] / 100 +
                                        cat2_average * weight[1] / 100 +
                                        cat3_average * weight[2] / 100 +
                                        cat4_average * weight[3] / 100;
                                break;
                            default:
                                System.out.println(" ");
                                System.out.println("Invalid Choice" );
                                System.out.println(" ");



                        }





                        break;
                    default:
                        System.out.println("  ");
                        System.out.println(" Invalid choice. ");
                        System.out.println("  ");

                }
            } while (choice != -1 && inchoice !=-1 );
        }
    }

    public static int menu(Scanner scanner, String[] main_options) {

        System.out.println("Please enter a choice below: ");
        for (int i = 0; i < main_options.length; i++) {
            System.out.println(i+"-"+main_options[i]);
        }
        System.out.println(" Q - to quit");
        String userRequest = scanner.nextLine();

        char userChoice = userRequest.charAt(0);

        if(userChoice == 'Q' || userChoice == 'q') {return -1;}

        else{int returningvalue = Integer.parseInt(userRequest);

            return  returningvalue;}
        


        }

    public static void formatCategoryName(String[] names) {
        for (int i = 0; i < names.length ; i++) {
            String firstletter = "" +
                    names[i].charAt(0);
            names[i] = firstletter.toUpperCase() +
                    names[i].toLowerCase().substring(1);
        }



    }


    public static String gradeLetter(double grade) {
        String grade_letter;


        if (grade >= 87.5) { grade_letter = "AA";}
        else if (grade >= 80.5) { grade_letter= "BA";}
        else if (grade >= 73.5) { grade_letter= "BB";}
        else if (grade >= 66.5) { grade_letter= "CB";}
        else if (grade >= 59.5) { grade_letter= "CC";}
        else if (grade >= 52.5) { grade_letter= "DC";}
        else if (grade >= 45.5) { grade_letter= "DD";}
        else if (grade >= 34.5) { grade_letter= "FD";}
        else if (grade >= 0) { grade_letter= "FF";}
        else { grade_letter ="invalid value";}

        return grade_letter; }


    public static double gpaPoints(double grade) {
        double gpa_points;
        if (grade >= 87.5) { gpa_points = 4.0;}
        else if (grade >= 80.5) { gpa_points= 3.5;}
        else if (grade >= 73.5) { gpa_points= 3.0;}
        else if (grade >= 66.5) { gpa_points= 2.5;}
        else if (grade >= 59.5) { gpa_points= 2.0;}
        else if (grade >= 52.5) { gpa_points= 1.5;}
        else if (grade >= 45.5) { gpa_points= 1.0;}
        else if (grade >= 34.5) { gpa_points= 0.5;}
        else if (grade >= 0) { gpa_points= 0.0;}
        else { gpa_points = 999;}
        return gpa_points; }


    public static String status(double grade) {
        String statuss;
        if (grade >= 87.5) { statuss = "passed";}
        else if (grade >= 80.5) { statuss= "passed";}
        else if (grade >= 73.5) { statuss= "passed";}
        else if (grade >= 66.5) { statuss= "passed";}
        else if (grade >= 59.5) { statuss= "passed";}
        else if (grade >= 52.5) { statuss=  "conditionally passed";}
        else if (grade >= 45.5) { statuss= "conditionally passed";}
        else if (grade >= 34.5) { statuss= "failed";}
        else if (grade >= 0) { statuss= "failed";}
        else { statuss = "invalid value";}
        return statuss; }

    public static int finding_min(int[] array) {

        int min = array[0];

        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }

        return min;
    }

    public static int total_of_array(int[] array) {
        int total = 0;

        for (int j : array) {
            total += j;
        }

        return total;
    }

    public static int countScores(String filename) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String row;
            int countofscores = 0;
            while ((row = br.readLine()) != null) {
                // Her satır için countrow fonksiyonunu çağır ve sonucu topla
                countofscores += countrow(row);
            }
            return countofscores;
        }
    }

    public static int countrow(String row) {
        // Boşluklara göre satırı böler ve kelime sayısını döndürür
        String[] thingsinrow = row.split("\\s+");
        return thingsinrow.length;
    }


}
