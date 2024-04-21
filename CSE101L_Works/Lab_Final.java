package Laboratuar.src;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Lab_Final {
    public static void main(String[] args) {
        System.out.println(addDigits(12345));      // Çıktı: 10
        System.out.println(addDigits(20200106));  // Çıktı: 11
    }

    public static int addDigits(int n) {
        // Temel durum: Eğer n bir basamaklı bir sayı ise, n'yi döndür.
        if (n < 10) {
            return n;
        } else {
            // Rekürsif çağrı: n'in son basamağını topla.
            return n % 10 + addDigits(n / 10);
        }
    }



    public static int[] ddecimaltobinary(int n){
        int[] abc= new int[9];

        for (int i =8; i >= 0; i--) {

            abc[i] = n%2;
            n=n/2;
        }

        return abc;
    }


    public static int binarytodecimal(int[]array){

        double n=0;
        int exponential=array.length-1;
        for (int i = 0; i <= array.length-1; i++) {
            if(array[exponential]!=0){
                n+=Math.pow(2,i);
            }
           exponential--;
        }


    return (int)n;
    }





    // Converts the given decimal number to a binary represented with an array <<< # Sınav
    public static int[] decimalToBinary(int number) {

        int[] binaryArray = new int[9]; // 9 bitlik bir dizi

        int index = binaryArray.length - 1;
        while (number > 0 && index >= 0) {
            binaryArray[index] = number % 2; // 2'ye bölümünden kalan
            number = number / 2; // 2'ye bölme işlemi
            index--;
        }

        return binaryArray;
    }

    public static int[] decimalToBinaryRecursive(int number, int index) {
        if (number > 0 && index >= 0) {
            int[] binaryArray = decimalToBinaryRecursive(number / 2, index - 1);
            binaryArray[index] = number % 2;
            return binaryArray;
        } else {
            return new int[9];
        }
    }

    // public static int binarySearch() FİNALDE ÇIKARRRRR !!

    public static int binarySearch(int[] array, int key) {
        int low = 0;
        int high = array.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (array[mid] == key) {
                return mid; // Key found, return the index
            } else if (array[mid] < key) {
                low = mid + 1; // Search in the right half
            } else {
                high = mid - 1; // Search in the left half
            }
        }

        return -1; // Key not found
    }





    public static int fibonacci(int n, int[] memo) { //hatırlamalı fibonacci u notation azalıyo baya

        if (n <= 1) {return n;}

        if (memo[n] != 0) {return memo[n];}

        memo[n] = fibonacci(n - 1, memo) + fibonacci(n - 2, memo);
        return memo[n];

    }


    public static int recursive_power(int base, int exponential){
        if(exponential<1){return 1;}
        else{ return base*recursive_power(base,exponential-1);


        }
    }

    // Question 5: Nine heads and tails <<<
    public static char[][] headsNtails(int number) {

        int[] binary_array = decimalToBinary(number);
        int[][] matrix_array = new int[3][3]; int a=0;
        for (int i = 0; i < matrix_array.length; i++) {
            for (int j = 0; j < 3; j++) {
                matrix_array[i][j] = binary_array[a];
                a++;
            }
        }
        char[][] matrix_char = new char[3][3];
        for (int i = 0; i < matrix_array.length; i++) {
            for (int j = 0; j < 3; j++) {
                if(matrix_array[i][j]==0){
                    matrix_char[i][j] ='H';
                }
                else{
                    matrix_char[i][j] ='T';
                }


            }

        }
        return matrix_char;
    }



        // kosegen toplamı
    public static int sumDiagonal(int[][] array2D) {

        int sumofdiagonels=0;
        for (int i = 0; i < array2D.length; i++) {
            sumofdiagonels+=array2D[i][i];

        }
        return sumofdiagonels;

    }


    // matris carpımı
    public static int[][] matmul(int[][] matrixA, int[][] matrixB) {

        int[][] result = new int[matrixA.length][matrixB[0].length];

        for (int i = 0; i < matrixA.length; i++) {
            for (int j = 0; j < matrixB[0].length; j++) {
                int temp = 0;

                for (int k = 0; k < matrixA[0].length; k++) {
                    temp += matrixA[i][k] * matrixB[k][j];
                }

                result[i][j] = temp;
            }
        }

        return result;
    }
    public static void sortsarray(int[] a, String[] b) {

        int n = a.length;

        for (int i = 0; i < n - 1; i++) {
            int maxIndex = i;

            // Find the index of the maximum element in the remaining unsorted part
            for (int j = i + 1; j < n; j++) {
                if (a[j] > a[maxIndex]) {
                    maxIndex = j;
                }
            }

            // Swap the maximum element with the first element in the unsorted part
            swap(a, i, maxIndex);
            swap(b, i, maxIndex);
        }
    }
    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    public static void swap(String[] array, int i, int j) {
        String temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static int[] getClosestPoints(int[][] points, int pointIndex) {

        double minDistance = Double.MAX_VALUE;
        int returning_arraysize = 0;

        for (int i = 0; i < points.length; i++) {
            if (i != pointIndex) {
                double distance = distance(points[pointIndex], points[i]);
                if (distance < minDistance) {
                    minDistance = distance;
                    returning_arraysize = 1;
                } else if (distance == minDistance) {

                    returning_arraysize++;
                }
            }
        }

        int[] closestIndices = new int[returning_arraysize];
        int indicies = 0;
        for (int i = 0; i < points.length; i++) {
            if (i != pointIndex) {
                double dist = distance(points[pointIndex], points[i]);
                if (dist == minDistance) {
                    closestIndices[indicies++] = i;
                }
            }
        }

        return closestIndices;
    }

    public static double distance(int[] pointA, int[] pointB) {

        double distance =0;
        for (int i = 0; i < pointA.length; i++) {
            distance += Math.pow(pointA[i]-pointB[i],2);

        }
        return round(Math.sqrt(distance),1);

    }
    public static double round(double value, int places) {
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }

    static char random(char start, char end) {
        return (char)((int)start + Math.random() * ((int)end - (int)start + 1));
    }

    static int random(String length){
        return length.length();
    }

    static  String random(int length){
        String s = "";
        for (int i = 0; i < length; i++) {
            s += random('a','t');

        }
        return s;
    }

    static int random(int a, int b, int c) {
        int number = random();
        if (number == a || number == b || number ==c)
            number = random();
        return number;

    }
    public static int random(){
        int value = (int)(Math.random()*(10));
        return value; }

    public static char[] grade (int[] scores){
        int max = getMax(scores);
        char[] grades = new char[scores.length];
        char[] letterGrades = {'A','B','C','D','E'};
        for (int i = 0; i < grades.length; i++) {
            int index = (max-scores[i]+1)/10;
            if (index>= letterGrades.length)
                index = letterGrades.length-1;
            grades[i] = letterGrades[index];

        }
        return grades;
    }



    public static int getMax(int[] scores){
        int max = Integer.MIN_VALUE;
        for (int i: scores) {

            if (max<i)
                max=i;

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
    public static int findMinIndex(double[] array) {


        int minIndex = 0;

        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[minIndex]) {
                minIndex = i;
            }
        }

        return minIndex;

    }




    public static int[] selectionSort(int[] array) {
        int n = array.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;


            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }


            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }

        return array;
    }
    public static double[] selectionSort(double[] array) {
        int n = array.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;


            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }


            double temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }

        return array;
    }




    public static int countlinefile(String filename) {
        File file = new File(filename);
        Scanner input = null;
        try {
            input = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException");
        }
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

    public static int countrowfile(String filename) {
        File file = new File(filename);
        Scanner input = null;
        try {
            input = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("File could not found");
        }
        int count = 0;

        // Read data from file
        while (input.hasNextLine()) {
            // Her satırı okuyor, ama şu anda okunan veriye bir şey yapmıyor.
            String line = input.nextLine();
            count =countrow(line);

        }

        input.close();
        return count;
    }

    public static int countrow(String row) {
        // Boşluklara göre satırı böler ve kelime sayısını döndürür. //  \\'nın yanında neyi kullanırsan ona göre böler.
        String[] things_inrow = row.split("\\s+");
        return things_inrow.length;
    }
    public static void booker(String filename){
        File file=new File(filename);
        int countline=countlinefile(filename);
        try {
            Scanner scanner= new Scanner(file);
            int i=0;
            String[] books= new String[countline];
            String[] writers= new String[countline];
            String[] prices= new String[countline];
            String[] types= new String[countline];
            while(scanner.hasNext()){
                String line= scanner.nextLine();
                String[] box=line.split("\\|");
                books[i]=box[0];
                writers[i]=box[1];
                prices[i]=box[2];
                types[i]=box[3];
                i++;
            }
            double[] price = new double[types.length];
            for (int j = 0; j < types.length; j++) {
                price[j]=Double.parseDouble(prices[j]);
            }
            for (int j = 0; j < types.length; j++) {
                if("Programming".equals(types[j])){price[j]=(2*price[j]);}
            }
            PrintWriter writer = new PrintWriter(file);
            for (int j = 0; j < types.length; j++) {
                writer.write(books[j]+" "+writers[j]+" "+prices[j]+" "+types[j]);
            }







        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }






    }












}
