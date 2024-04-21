import java.util.ArrayList;

public class lab8 {

    public static void main(String[] args) {



      /*  String name1 = "CCCCC";
        String name2 = "DDDDD";
        String name3 = "OOOOO";
        String name4 = "UUUUU";
        String name5 = "EEEEE";

        String[] names = new String[10];
        names[0]=name1;
        names[2]=name2; */







    }

    public static void swap(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;

    }

    public static void display(int[] array){

        for (int i : array) {
            System.out.printf("%d\t", i );

        }
        System.out.println();

        }


    public static void display(double[] array){

        for (double v : array) {
            System.out.println(v);

        }

    }


    public static void display(String[] array){

        for (String s : array) {
            System.out.println(s);

        }

    }


    public static int random(int start, int end){

        return start + (int)(Math.random()*(end-start));

    }

    public static double round(double number, int places){

      //  (double)((int)(number* Math.pow(10,places))
        return places;
    }

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









    }





