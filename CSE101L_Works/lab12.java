package Laboratuar.src;

public class lab12 {
    public static void main(String[] args) {
    }

    public static int factorial(int n) {

        if (n <= 1) {
            return 1;
        }

        return n * factorial(n - 1);
    }
    public static int fact(int n){
        int a=0;
        while(n>0){
            a = n*(n-1);
            n--;
            
        }
        return a;
    }

    public static int fibonacci(int n, int[] memo) { //hatırlamalı fibonacci u notation azalıyo baya

        if (n <= 1) {
            return n;
        }
        if (memo[n] != 0) {
            return memo[n];}
            memo[n] = fibonacci(n - 1, memo) + fibonacci(n - 2, memo);
            return memo[n];

    }
        public static int iterfibonacci(int n){
            if (n<=1)
                return n;

            int fib =1;
            int fibPrev =1;

            for (int i = 2; i <= n; i++) {
                int temp = fib;
                fib+= fibPrev;
                fibPrev = temp;
            }
            return fib;
        }



    public static int sumOfArray(int[] arr, int n){
        if(n==0)
            return arr[n];

        return arr[n]+sumOfArray(arr,n-1);


    }


    public static boolean isPalindrome(String str, int start, int end){
        if(start>=end)
            return true;
        if (str.charAt(start)==str.charAt(end))
            return false;
        return isPalindrome(str, ++start,--end);
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



}
