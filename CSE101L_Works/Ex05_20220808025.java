package Laboratuar.src;

import java.util.Scanner;
public class Ex05_20220808025 {

    public static void main(String[] args) {
        nPrimes(5);
        double a= computePI(0);
        System.out.println(a);

    }


    // ex one
    public static double computePI(int n) {
        double pi = 0;
        if (n == 0) {
            return pi = 3;
        }
        for (int i = 0; i <= n; i++) {
            pi += ((Math.pow(-1, (i + 1)) / ((2 * i) - 1)));
        }
        pi = Math.abs(4*(1 - pi));

        return pi;

    }


    // ex two
    public static int factorial(int number) {
        int result = 1;
        for (int i = 1; i <= number; i++) {
            result *= i;
        }
        System.out.println(result);
        return result;
    }

    // ex 3a
    public static boolean isPrime(int numberprime) {
        if (numberprime < 2) {
            return false;
        }
        for (int i = 2; i <= numberprime / 2; i++) {
            if (numberprime % i == 0) {
                return false;
            }
        }
        return true;
    }

    // ex 3b
    public static int nPrimes(int numberOfPrimes) {
        int count = 0;
        int number = 2;
        do {
            if (isPrime(number)) {
                count++;
                System.out.println(number);
            }
            number++;
        }
        while (count < numberOfPrimes);
        return number;
    }


    // ex four


    public static boolean isPerfect(int number) {
        int sum = 1;
        for (int i = 2; i <= number / 2; i++) {
            if (number % i == 0) {
                sum += i;
                if (i != number / i) {
                    sum += number / i;
                }
            }
        }

        return sum == number;
    }

    public static void nPerfectNumbers(int n) {

        int count = 0;
        int number = 2;

        do {
            if (isPerfect(number)) {
                System.out.println(number);
                count++;
            }
            number++;
        } while (count < n);
    }


    // ex 5

    public static double displayStatics(int n){
        Scanner scanner = new Scanner(System.in);
        double a = 0; double sum=0; double dizi=0;
        double mean=0; double deviation;
        double c=0;
        for (int i = 0; i < n; i++) {
            System.out.println("Enter the data:");
            a = scanner.nextDouble();
            sum += a;
            dizi *=a;
            c+=dizi;

        }
            mean= sum/n;
            deviation=Math.sqrt((c-(sum*sum/n))/n-1);
        System.out.println("Mean is: "+mean);
        System.out.println("Deviation is: "+ deviation);
        return sum/n;
        }


    }






