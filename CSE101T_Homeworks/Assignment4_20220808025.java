package Homework.src;

import java.io.*;
import java.util.Scanner;

public class Assignment4_20220808025 {
    public static void main(String[] args) throws IOException {

        if (args.length == 1) {
            processFiles(args[0]);
        } else if (args.length == 4) {
            processFiles(args[0], args[1], args[2], args[3]);
        } else {

            System.err.println("ERROR :Invalid argument's number or type");

        }
    }

    public static void processFiles(String baseFilename) throws IOException {
        String courseDetailsFilename =baseFilename+  "_CourseDetails.txt";
        String studentScoresFilename =baseFilename+ "_StudentScores.txt";
        String studentGradesFilename =baseFilename+  "_StudentGrades.txt";
        String errorsLogFilename =baseFilename+ "_Errors.log";



        // readCategoryInformation

        int countofcategories=countCategory(courseDetailsFilename);
        String[] categories=new String[countofcategories];
        int[] quantity=new int[countofcategories];
        int[] weight=new int[countofcategories];

        getCategory(categories,quantity,weight,courseDetailsFilename);

        //initialization
        int weight_max=finding_max(weight);
        int weight_min=finding_min(weight);
        int weight_total=total_of_array(weight);
        int quantity_min=finding_min(quantity);

        // WeightErrors
        if(weight_min<0||weight_max>100){
            String err="ERROR: Course details - invalid weight - must be 0 between 100 ";
        errorWriter(errorsLogFilename,err);
        } else if (weight_total!=100) {
            String err="ERROR: Course details - invalid weight - does not sum to 100 ";
            errorWriter(errorsLogFilename,err);
            }
        // QuantityErrors
        else if (quantity_min<0) { String err="ERROR: Course details - invalid quantity - must be 0 or positive";
            errorWriter(errorsLogFilename,err);
        } else {


            // readStudentInformation

            int countofstudents = countCategory(studentScoresFilename);
            String[] names = new String[countofstudents];
            double[][] scores = new double[names.length][countrow(studentScoresFilename)];

            readStudentInformation(names, scores, studentScoresFilename);

            // ScoresErrors
            for (int i = 0; i < names.length; i++) {
                for (int j = 0; j < scores[i].length; j++) {
                    double currentScore = scores[i][j];
                    if (currentScore < 0.0 || currentScore > 100.0) {
                       String  err = "ERROR: Student " + names[i] + " - cannot calculate due to invalid grade entered";
                        errorWriter(errorsLogFilename, err);
                    }}}

            // calculateStudentGrades
            double[] grades = calculateGrades(names, scores, quantity, weight);


            // printingStudentGrades
            writeGrades(names, grades, studentGradesFilename, errorsLogFilename);


        }
    }
    public static void processFiles(String arg1, String arg2, String arg3, String arg4) throws IOException {
        String courseDetailsFilename = arg1 + ".txt";
        String studentScoresFilename = arg2 + ".txt";
        String studentGradesFilename = arg3 + ".txt";
        String errorsLogFilename = arg4 + ".log";


            // readCategoryInformation
            int countofcategories=countCategory(courseDetailsFilename);
            String[] categories=new String[countofcategories];
            int[] quantity=new int[countofcategories];
            int[] weight=new int[countofcategories];

            getCategory(categories,quantity,weight,courseDetailsFilename);
        //initialization
        int weight_max=finding_max(weight);
        int weight_min=finding_min(weight);
        int weight_total=total_of_array(weight);
        int quantity_min=finding_min(quantity);

        // WeightErrors
        if(weight_min<0||weight_max>100){
            String err="ERROR: Course details - invalid weight - must be 0 between 100 ";
            errorWriter(errorsLogFilename,err);
        } else if (weight_total!=100) {
            String err="ERROR: Course details - invalid weight - does not sum to 100 ";
            errorWriter(errorsLogFilename,err);
        }
        // QuantityErrors
        else if (quantity_min<0) { String err="ERROR: Course details - invalid quantity - must be 0 or positive";
            errorWriter(errorsLogFilename,err);
        } else {

            // readStudentInformation
            int countofstudents=countCategory(studentScoresFilename);
            String[]names = new String[countofstudents];
            double[][]scores = new double[names.length][countrow(studentScoresFilename)];

            readStudentInformation(names,scores,studentScoresFilename);
            // scoresErrors
            for (int i = 0; i < names.length; i++) {
                for (int j = 0; j < scores[i].length; j++) {
                    double currentScore = scores[i][j];
                    if (currentScore < 0.0 || currentScore > 100.0) {
                        String  err = "ERROR: Student " + names[i] + " - cannot calculate due to invalid grade entered";
                        errorWriter(errorsLogFilename, err);
                    }}}

            //calculate grades
            double  [] grades = calculateGrades(names,scores,quantity,weight);

            // printing to file
            writeGrades(names,grades,studentGradesFilename,errorsLogFilename);
        } }




    public static int countCategory(String filename) throws FileNotFoundException {
        File file = new File(filename);
        Scanner input = new Scanner(file);
        int count = 0;

        // Read data from file
        while (input.hasNextLine()) {
            // Her satırı okuyor, ama şu anda okunan veriye bir şey yapmıyor.
            String line = input.nextLine();

            count++;
        }

        input.close();
        return count;
    }

    public static int countrow(String row) {
        // Boşluklara göre satırı böler ve kelime sayısını döndürür.
        String[] things_inrow = row.split("\\s+");
        return things_inrow.length-1;
    }

    public static void getCategory(String[] category,int[] quantity, int[] weight, String filename)throws FileNotFoundException{
        File file = new File(filename);
        Scanner input = new Scanner(file);
        int i=0;
        while(input.hasNext()){
            category[i]= input.next();
            quantity[i]=input.nextInt();
            weight[i]=input.nextInt();
            i++;
        }
        input.close();
    }
    public static void readStudentInformation(String[]names,double[][]scores,String filename) throws IOException {

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            String[] parts;
            int f = 0;
            while ((line = br.readLine()) != null) {

                // Satırdaki boşluklara göre ayırarak ismi ve puanları al
                parts = line.split("\\s+");

                // İsimleri bir diziye ekle
                names[f] = parts[0];


                // Puanları bir diziye ekle
                scores[f] = new double[parts.length - 1];
                for (int i = 1; i < parts.length ; i++) {
                    scores[f][i - 1] = Double.parseDouble(parts[i]);
                }
                f++;
            }


        }
    }

    public static double[] calculateGrades(String[] names, double[][] scores, int[] quantities, int[] weights) {
        int numberOfStudents = names.length;
        double[] averages = new double[numberOfStudents];

        for (int i = 0; i < numberOfStudents; i++) {
            double total = 0;

            int score_index = 0;
            for (int j = 0; j < quantities.length; j++) {
                double categoryTotal = 0;

                for (int k = 0; k < quantities[j]; k++) {
                    categoryTotal += scores[i][score_index++];
                }

                double categoryAverage = categoryTotal / quantities[j];
                total += categoryAverage * weights[j] / 100.0;
            }

            averages[i] = total;
        }

        return averages;
    }





    public static void writeGrades(String[] studentNames, double[] grades, String studentGradesFilename, String errorLogFilename) throws IOException {
        BufferedWriter studentGradesWriter = new BufferedWriter(new FileWriter(studentGradesFilename));


        for (int i = 0; i < studentNames.length; i++) {
            String name = studentNames[i];
            double grade = grades[i];

            // Not bilgilerini hesapla (harf notu, GPA, durum)
            String letterGrade = calculateLetterGrade(grade);
            double gpa = calculateGPA(grade);
            String status = calculateStatus(grade);

            // Bilgileri dosyaya yaz
            String line = name + " " + String.format("%.2f", grade) + " " + letterGrade + " " + String.format("%.2f", gpa) + " " + status;
            studentGradesWriter.write(line);
            studentGradesWriter.newLine();
        }
        studentGradesWriter.close();

    }
    public static void errorWriter(String errorLogFilename, String message) throws IOException {
        BufferedWriter errorWriter = new BufferedWriter(new FileWriter(errorLogFilename,true));
        errorWriter.write(message);
        errorWriter.write("\n");
        errorWriter.close();
    }


    public static String calculateLetterGrade(double grade) {
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

        return grade_letter;
    }

    public static double calculateGPA(double grade) {
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
        return gpa_points;
    }

    public static String calculateStatus(double grade) {
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
    public static int finding_max(int[] array) {

        int max = array[0];

        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }

        return max;
    }
    public static double finding_max(double[] array) {

        double max = array[0];

        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }

        return max;
    }

    public static int finding_min(int[] array) {

        int min = array[0];

        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }

        return min;
    }

    public static double finding_min(double[] array) {

        double min = array[0];

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


    }