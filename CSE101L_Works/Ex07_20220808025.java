

public class Ex07_20220808025 {

    public static void main(String[] args) {
       // Question 1
        int[][] array2D = generateArray2D(4, 4, 0, 10);
        display2D(array2D);
        int diagonalSum = sumDiagonal(array2D);
        System.out.println("Sum of the diagonal for the given 2D array is: " + diagonalSum);


        // Question 2
        int[][] employees = generateArray2D(8, 7, 4, 9);
        display2D(employees);
        int[] workingHours = employeeWorkingHours(employees);
        display2D(employees);
        display(workingHours);


        // Question 3
        int[][] matrixA = generateArray2D(3, 2, 1, 10);
        int[][] matrixB = generateArray2D(2, 3, 1, 10);
        display2D(matrixA);
        display2D(matrixB);

        int[][] productMatrix = matmul(matrixA, matrixB);
        display2D(productMatrix);


        // Question 4
        int[][] pointsss = generateArray2D(5, 2, -3, 3);
        display2D(pointsss);
        int[] closestPoints = getClosestPoints(pointsss, 1);
        System.out.println("Indexes of points with the closest distance");
        display(closestPoints);


        // Question 5
        char[][] charArray2D = headsNtails(16);
        display2D(charArray2D);


    }

    // Question 1: Sum the major diagonal in a matrix
    public static int sumDiagonal(int[][] array2D) {

        int sumofdiagonels=0;
        for (int i = 0; i < array2D.length; i++) {
            sumofdiagonels+=array2D[i][i];

        }
        return sumofdiagonels;

    }

    // Question 2: Compute the weekly hours for each employee <<<
    public static int[] employeeWorkingHours(int[][] employees) {
        /*
         * Suppose the weekly hours for all employees are stored in a
         * two-dimensional array. Each row records an employee's seven
         * day work hours with seven columns. Write a method that sorts the
         * employee's according to their sum of working hours for an enteire week
         * in decreasing order. Finally returns the sum of working hours for each
         * employee (sort both returned array and given employees array)
         * 
         * Args:
         *      employees (int[8][7]) : the array of employees. Each row contains
         *      the employee's seven day work hours.
         * 
         * Returns:
         *      int[8] : the array of sum working hours for each employee in decreasing order.
         */

        // Your code goes here...
        int a=0;
        for (int i = 0; i < employees[a].length; i++) {

            selectionSort(employees[a]);
            a++;
        }
        int sumhours =0;
        int[] workhours_eachone = new int[employees.length];
        for (int i = 0; i <employees.length ; i++) {


            for (int j = 0; j < employees[0].length; j++) {
                sumhours += employees[i][j];

            }
            workhours_eachone[i] = sumhours;
        }
        for (int i = workhours_eachone.length; i >1; i--) {
            workhours_eachone[i-1]-=workhours_eachone[i-2];
        }
        selectionSort(workhours_eachone);

        return workhours_eachone;




    }

    // Question 3: multiply two matrices
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

    // Question 4: All closest pairs of points <<<
   public static int[] getClosestPoints(int[][] points, int pointIndex) {
        /*
         * Write a method that returns the array indices of the closest points to the given
         * point index. if m number of points share the same minimum distance to
         * given point index, then your array will have all of those points
         * 
         * Args:
         *      points (int[n][d]) : array of n points in d dimensional space
         *      pointIndex (int) : index of a point from points array that we will search for closest m points
         * 
         * Returns:
         *      (int[m]) : array of point indices that share the same minimum distance to given point
         */

        // Your code goes here...
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







    // Calculates the euclidean distance between two points in d dimensional space
   public static double distance(int[] pointA, int[] pointB) {
        /*
         * Helper method for calculating distance between given two points
         * 
         * Args:
         *      pointA (int[d]) : a point in d-dimensional space
         *      pointB (int[d]) : a point in d-dimensional space
         * 
         * Returns:
         *      (double): distance between given two points UP TO 1 DECIMAL PLACE (see round method bellow)
         */

        // Your code goes here...
        double distance =0;
       for (int i = 0; i < pointA.length; i++) {
           distance += Math.pow(pointA[i]-pointB[i],2);

       }
        return round(Math.sqrt(distance),1);

  }

    // Question 5: Nine heads and tails <<<
   public static char[][] headsNtails(int number) {
        /*
         * Nine coins are placed in a 3-by-3 matrix with some face up and
         * some face down. You can represent the state of the coins using a 
         * 3-by-3 matrix with values 0 (heads) and 1 (tails). Here are some examples:
         *      0 0 0       1 0 1       1 0 0
         *   A: 0 1 0    B: 0 0 1   C:  1 1 1
         *      0 0 0       1 0 0       1 1 0
         * 
         *  Each state can also be represented using a binary number: For example,
         *  the preceding A, B and C matrices correspond to the numbers
         *      A: 0 0 0 0 1 0 0 0 0
         *      B: 1 0 1 0 0 1 1 0 0
         *      C: 1 0 0 1 1 1 1 1 0
         * 
         *  There are a total of 512 posibilities, so you can use
         *  decimal numbers 0, 1, 2, ..., 511 to represent all states of the matrix.
         *      for A: number == 10
         *      for B: number == 332
         *      for C: number == 318
         * 
         * Write a program that accepts a number and returns the corresponding matrix with
         * the characters H and T
         * 
         *      if the number == 7;
         *      then the binary of 7 == 0 0 0 0 0 0 1 1 1;
         *      so in matrix format it will be;
         *              0 0 0
         *              0 0 0
         *              1 1 1
         * 
         *      finally we can represent it with coins like;
         *              H H H
         *              H H H
         *              T T T
         * 
         * Args:
         *      number (int): the number to represent with the characters H and T in matrix format
         * 
         * Returns:
         *      (char[3][3]): the corresponding matrix representation of given number with coins
         */
        
        // Your code goes here...
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



    /////////////// HELPER METHODS ////////////////////////////

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void display(int[] array) {
        for (int i : array) {
            System.out.printf("%d\t", i);
        }
        System.out.println();
    }
    public static void display(double[] array) {
        for (double i : array) {
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

    public static void display2D(int[][] array2D) {
        for (int[] row : array2D) {
            display(row);
        }
        System.out.println("--------------------------");
    }
    public static void display2D(double[][] array2D) {
        for (double[] row : array2D) {
            display(row);
        }
        System.out.println("--------------------------");
    }


    public static void display2D(char[][] array2D) {
        for (char[] row : array2D) {
            display(row);
        }
        System.out.println("--------------------------");
    }

    public static int[][] generateArray2D(int m, int n, int start, int end) {
        int[][] array2D = new int[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                array2D[i][j] = random(start, end);
            }
        }

        return array2D;
    }

    public static int random(int start, int end) {
        return start + (int) (Math.random() * (end - start + 1));
    }
    public static double random(double start, double end) {
        return start + (int) (Math.random() * (end - start + 1));
    }

    public static double round(double value, int places) {
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
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

    public static double[][] generateArray2D(int m, int n, double start, double end) {
        double[][] array2D = new double[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                array2D[i][j] = random(start, end);
            }
        }

        return array2D;
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

}}