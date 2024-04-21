
public class Ex06_20220808025 {

    public static void main(String[] args) {
        boolean[] a= new boolean[100];





        // Question 1

        int[] students = new int[10];
        for (int i = 0; i < students.length; i++) {
            students[i] = random(0, 100);
        }

        System.out.println("Scores of students:");
        display(students);

        char[] grades = grade(students);

        System.out.println("Grades of students are:");
        display(grades);


        // Question 2

        int[] numbers = new int[8];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random(0, 10);
        }
        display(numbers);
        System.out.println("Average of numbers is: " + average(numbers));

        double[] doubleNumbers = new double[8];
        for (int i = 0; i < doubleNumbers.length; i++) {
            doubleNumbers[i] = random(-0.5, 0.5);
        }
        display(doubleNumbers);
        System.out.println("Average of numbers is: " + average(doubleNumbers));


        // Question 3

        int[] numbersd = new int[10];
        for (int i = 0; i < numbersd.length; i++) {
            numbersd[i] = random(0, 10, 1, 3, 5, 7, 9);
        }
        System.out.println("Generated numbers are: ");
        display(numbersd);


        // Question 4

        int[] numberss = new int[10];
        for (int i = 0; i < numberss.length; i++) {
            numberss[i] = random(0, 10, 0, 1, 3, 5, 7, 9);
        }
        System.out.println("Generated numbers with duplicate values are: ");
        display(numberss);
        int[] nonDuplicateNumbers = eliminateDuplicates(numberss);
        
        System.out.println("Non duplicate numbers");
        display(nonDuplicateNumbers);


        // Question 5

        int[] numbersq = new int[10];
        for (int i = 0; i < numbersq.length; i++) {
            numbersq[i] = i;
        }
        System.out.println("---------------------------------------");
        System.out.println("is array in sorted order: " + isSorted(numbersq));
        display(numbersq);

        shuffle(numbersq);

        System.out.println("is array in sorted order: " + isSorted(numbersq));
        display(numbersq);
        System.out.println("----------------------------------------");


        // Question 6

        int n = 100;
        boolean[] lockers = new boolean[n];
        int[] openLockers = lockers(lockers);

        System.out.println("Open lockers are:");
        display(openLockers);

        System.out.println("for n == 100, open locker amount should be 10: open locker amount: " + openLockers.length);

        n = 1000;
        lockers = new boolean[n];
        openLockers = lockers(lockers);

        System.out.println("for n == 1000, open locker amount should be 31, open locker amount: " + openLockers.length);

    }

    // Question 1: Assign grades
    public static char[] grade(int[] students) {

        int max =finding_max(students);
        char[] statuss = new char[students.length];
        for (int i = 0; i < students.length ; i++) {


            if (students[i] >= max-10) {
                statuss[i] = 'A';
            } else if (students[i] >= max-20) {
                statuss[i] = 'B';
            } else if (students[i] >= max-30) {
                statuss[i] = 'C';
            } else if (students[i] >= max-40) {
                statuss[i] = 'D';
            }
            else { statuss[i]='F';
            }
        }
        return  statuss;
    }


    public static int getMax(int[] array) {
        int max = array[0];

        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }

        return max;

    }


    public static int average(int[] array) {
        int total = 0;
        for (int i = 0; i < array.length; i++) {
            total += array[i];

        }
        int average = total / (array.length);
        return average;
    }


    public static double average(double[] array) {
        double total = 0;
        for (int i = 0; i < array.length; i++) {
            total += array[i];

        }
        double average = total / (array.length);
        return average;

    }


    public static int random(int start, int end, int... exclude) {
        int randomNum;
        boolean is_excluded;

        do {
            randomNum = (int) (Math.random() * (end - start + 1)) + start;
            is_excluded = false;

            for (int i = 0; i < exclude.length; i++) {
                if (randomNum == exclude[i]) {
                    is_excluded = true;
                    break;
                }
            }
        } while (is_excluded);

        return randomNum;


    }

    // Question 4: Eliminate duplicates
    public static int[] eliminateDuplicates(int[] array) {
        selectionSort(array);
        int j = 0;
        int count = 0;
        int[] temp = new int[array.length];
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] != array[i + 1]) {
                temp[j] = array[i];
                j++;
            } else count++;
        }
        temp[j++] = array[array.length - 1];
        int[] new_array = new int[array.length - count];
        for (int i = 0; i < new_array.length; i++) {
            new_array[i] = temp[i];
        }
        return new_array;
    }


    // Question 5: Sorted?
    public static boolean isSorted(int[] array) {

        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                return false;
            }
        }
        if (array[array.length - 1] < array[array.length - 2]) {
            return false;
        } else return true;

    }

    // shuffle the array randomly
    public static void shuffle(int[] array) {
        for (int i = 0; i < array.length ; i++) {
            swap(array,random(0, array.length-1),random(0, array.length-1));
        }


    }

    // Question 6: Locker puzzle
    public static int[] lockers(boolean[] locker) {

        int[] lockers = new int[locker.length];
        for (int i = 0; i < lockers.length; i++) {
            lockers[i] = i + 1;
        }
        int [] bolensayisi = new int[locker.length];
        for (int i = 0; i < locker.length; i++) {

            bolensayisi[i]=findingbolen(lockers[i]);

        }
        int[] openedlockers = new int[locker.length];

        int opened=0;
        for (int i = 0; i < bolensayisi.length; i++) {
            if(bolensayisi[i]%2!=0){openedlockers[opened]=i; opened++; }

        }
        for (int i = 0; i < openedlockers.length; i++) {
            openedlockers[i]++;

        }
        int[] real_openedlockers= new int[opened];
        for (int i = 0; i < opened; i++) {
            real_openedlockers[i]=openedlockers[i];

        }


        return real_openedlockers;
    }

    ////////////////////// HELPER FUNCTIONS //////////////////////

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void display(double[] array) {
        for (double i : array) {
            System.out.printf("%.1f\t", i);
        }
        System.out.println();
    }

    public static void display(int[] array) {
        for (int i : array) {
            System.out.printf("%d\t", i);
        }
        System.out.println();
    }

    public static void display(char[] array) {
        for (int i : array) {
            System.out.printf("%c\t", i);
        }
        System.out.println();
    }

    public static int random(int start, int end) {
        return start + (int) (Math.random() * (end - start + 1));
    }

    public static double random(double start, double end) {
        return start + Math.random() * (end - start + 1);
    }

    public static double round(double value, int places) {
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }

    public static int[] selectionSort(int[] array) {


        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;


            for (int j = i + 1; j < array.length; j++) {
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
        public static int findingbolen(int a){
            int count =0;
            for (int i = 1; i <= a; i++) {

                if(a%i==0){
                    count++;
                }

            }
            return count;


        }
    public static int finding_max(int[] array) {

        int max = array[0];

        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }

        return max;
    }


    }
