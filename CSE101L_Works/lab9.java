package Laboratuar.src;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.Date;

public class lab9 {

    public static File createFile(String filename){
        File file  = null;
        do{     
     try{
         file = new File(filename);

         if (file.exists()){
         System.out.printf("file %s already exists last modified on %s",file, new Date(file.lastModified()));
         return file ;}

        file.createNewFile();
        System.out.printf("File %s created successfully",file.getName());

    } catch(IOException e) {
       System.out.printf("ERROR: could not create file %s",file.getName());
       System.out.print(e.getMessage());
    } 
    }while(!file.exists());

    return file ;
    }

    public static void main(String[] args) {
     File file =createFile("text.txt");
     String currentDirectory ="abc"; //file.getAbsolutePath().replace(file.getName());
     System.out.print(currentDirectory);
}
}