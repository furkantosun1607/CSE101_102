package Laboratuar.src;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex08_20220808025 {
    /*
     * Change the X's in the both file name and class' name to your own
     * student number and submit your file to the assignment given through
     * Teams.
     */


    public static void main(String[] args) {
        String first_method = "first_method.log";
        String datafile = "PokeStats 1.txt";
        String furkan = "Furkan Enes Tosun.txt";
        String a="dostya.log";
        readSortPokeStats(datafile,furkan);
        readFilterPokeStats(furkan);
    }



    // Question 1: Log unspecified number of integers
    public static void intLogger(String filename) {
        try (Scanner scanner = new Scanner(System.in);
             PrintWriter writer = new PrintWriter((filename))) {

            while (true) {
                System.out.print("Enter an integer (Enter: 0 to exit): ");
                try {
                    int userInput = scanner.nextInt();
                    if (userInput == 0) {
                        break;
                    }
                    writer.println(userInput);
                } catch (InputMismatchException e) {
                    String none_int= "non-integer-input";
                    writer.println(none_int);
                    scanner.nextLine();
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException: File is not found.");
        }
    }

    // Question 2: Read Integers from the Log File.
    public static int[] intReader(String filename) {

        int[] int_ones = new int[10]; //assume that
        int count = 0;

        try (Scanner sc = new Scanner(new File(filename))) {
            while (sc.hasNext()) {
                try {
                    int nextInt = sc.nextInt();
                    if (count == int_ones.length) {
                        // Diziyi aktar ve genişlet
                        int[] int_twos = new int[int_ones.length * 2];
                        for (int i = 0; i < int_ones.length; i++) {
                            int_twos[i] = int_ones[i];
                        }
                        int_ones = int_twos;
                    }
                    int_ones[count++] = nextInt;
                } catch (InputMismatchException e) {
                    // none int jump
                    sc.nextLine();
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException: Log file is not found.");
        }

        // aktar ve kısalt
        int[] result = new int[count];
        for (int i = 0; i < count; i++) {
            result[i] = int_ones[i];
        }
        return result;
    }





    // Question 3: Replace Specific Numbers in the Log File
    public static void replaceNumbers(String filename, String logfile, int oldNum, int newNum) {

        try (Scanner fileScanner = new Scanner(new File(filename))) {
            String updatedContent = "";

            while (fileScanner.hasNext()) {
                String line = fileScanner.nextLine();
                int lineNumber;
                try {
                    lineNumber = Integer.parseInt(line.trim());
                } catch (NumberFormatException e) {
                    continue;
                }

                if (lineNumber == oldNum) {
                    updatedContent += newNum + "\n";
                } else {
                    updatedContent += line + "\n";
                }
            }

            try (PrintWriter writer = new PrintWriter(new File(logfile))) {
                writer.print(updatedContent);
            }
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException: Log file not found.");
        }
    }


    public static void readSortPokeStats(String datafile, String sortedfile) {


         int count_pokemons=countPokemon(datafile)-1;
         int stats_count = countrowfile(datafile)-3;
         String[] names = new String[count_pokemons];
         int[][] stats_pokemons= new int[names.length][stats_count];
         readPokemonInformation(names,stats_pokemons,datafile);
         int[] total_stats = new int[names.length];
        for (int i = 0; i <count_pokemons ; i++) {

            for (int j = 0; j < stats_count; j++) {
                total_stats[i]+=stats_pokemons[i][j];

            }

        }
        String [] lines = new String[count_pokemons];
        for (int i = 0; i < count_pokemons; i++) {
            lines[i]=names[i];
            for (int j = 0; j < stats_count; j++) {
                lines[i] +=" "+stats_pokemons[i][j];
            }
        }
        sortsarray(total_stats,lines);
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(sortedfile));
        } catch (IOException e) {
            System.out.println("IOException");
        }



            String first_line ="Name Type1 Type2 HP Attack Defense Sp.Atk Sp.Def Speed";
        try {
            writer.write(first_line);
            writer.newLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // Bilgileri dosyaya yaz
            try {  for (int i = 0; i+1 < lines.length; i++) {
                writer.write(lines[i]);
                writer.newLine();}
                writer.write(lines[lines.length-1]);

            } catch (IOException e) {
                System.out.println("IOException");
            }
            try {
                writer.newLine();
            } catch (IOException e) {
                System.out.println("IOException");

            }

        try {
            writer.close();
        } catch (IOException e) {
            System.out.println("IOException");
        }


    }

    // Question 5: Read and Filter Pokémon Stats Data by Type
    public static String[] readFilterPokeType(String filename, String poketype) {


        int count_pokemons = countPokemon(filename) - 1;
        String[] names = new String[count_pokemons];
        String[] types= new String[count_pokemons];
        String[] types1= new String[count_pokemons];
        String[] returnin_array;
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            br.readLine(); // ilk satırı okuyup boş geçmek için
            String line;
            int f = 0;
            int abc = 0;

            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\s+");

                // İsimleri ve türleri bir diziye ekle
                names[f] = parts[0];
                types[f] = parts[1];
                types1[f] = parts[2];


                // Eğer poketype içeriyorsa abc'yi artır
                if (types1[f].contains(poketype)||types[f].contains(poketype)) {
                    abc++;
                }
                f++;
            }

            // Yeni dizi boyutunu belirle
            returnin_array = new String[abc];

            // names dizisini filtrele ve returnin_array'e ata
            int index = 0;
            for (int i = 0; i < names.length; i++) {
                if (types1[i].contains(poketype)||types[i].contains(poketype)) {
                    returnin_array[index++] = names[i];
                }
            }
            return returnin_array;
        } catch (FileNotFoundException e) {
            System.out.println("FilenotFoundException");
        } catch (IOException e) {
            System.out.println("FilenotFoundException");
        }

        // Hata durumunda veya eğer hiç eşleşme yoksa boş dizi döndür
        return new String[0];}


    public static void readFilterPokeStats(String filename) {

        int count_pokemons=countPokemon(filename)-1;
        int stats_count = countrowfile(filename)-3;
        String[] names = new String[count_pokemons];
        int[][] stats_pokemons= new int[names.length][stats_count];
        readPokemonInformation(names,stats_pokemons,filename);
        int[] speeds=new int[names.length];
        for (int i = 0; i <count_pokemons ; i++) {
            speeds[i]=stats_pokemons[i][5];
        }
        String [] lines = new String[count_pokemons];
        for (int i = 0; i < count_pokemons; i++) {
            lines[i]=names[i];
            for (int j = 0; j < stats_count; j++) {
                lines[i] +=" "+stats_pokemons[i][j]+" ";
            }
        }

        sortsarray(speeds,lines);
        for (int i = 0; i < 5; i++) {
            System.out.println(lines[i]);
        }




    }

    /////////////// HELPER METHODS ////////////////////////////

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

    public static void display2D(int[][] array2D) {
        for (int[] row : array2D) {
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

    public static double round(double value, int places) {
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }

    public static void readPokemonInformation(String[]names,int[][]scores,String filename)  {

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line1=br.readLine(); // ilk satırı okuyup boş geçmek için
            String line;
            String[] parts;
            int f = 0;
            while ((line = br.readLine()) != null) {

                // Satırdaki boşluklara göre ayırarak pokemonları ve türlerini al
                parts = line.split("\\s+");

                // İsimleri ve türleri bir diziye ekle
                names[f] = parts[0]+" "+parts[1]+" "+parts[2];


                // Puanları bir diziye ekle
                scores[f] = new int[parts.length - 3];
                for (int i = 3; i < parts.length ; i++) {
                    scores[f][i - 3] = Integer.parseInt(parts[i]);
                }
                f++;
            }


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.out.println("IOException");
        }
    }


    public static int countPokemon(String filename) {
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
            count =countrow(line)+1;

        }

        input.close();
        return count;
    }

    public static int countrow(String row) {
        // Boşluklara göre satırı böler ve kelime sayısını döndürür.
        String[] things_inrow = row.split("\\s+");
        return things_inrow.length-1;
    }
    public static void sortsarray(int[] a, String[] b) {
        // Check if the lengths of the arrays are the same
        if (a.length != b.length) {
            throw new IllegalArgumentException("Arrays must have the same length");
        }

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



}