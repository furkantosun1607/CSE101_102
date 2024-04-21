import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Assignment3_TestYourProgram {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter your student number: ");
            String id = scanner.nextLine();
            String filename = "Assignment3_" + id + ".java";

            ProcessBuilder compileProcessBuilder = new ProcessBuilder("javac", filename);
            compileProcessBuilder.redirectErrorStream(true);
            Process compileProcess = compileProcessBuilder.start();
            int compileExitCode = compileProcess.waitFor();

            if (compileExitCode != 0) {
                System.out.println("ERROR: Something is wrong in your java program or filename.");
            } else {
                System.out.println("Your program seems to compile and your filename is correct.");

                String compileMeFilename = "Assignment3_CompileMe.java";
                try (PrintWriter out = new PrintWriter(compileMeFilename)) {
                    out.println("public class Assignment3_CompileMe { ");
                    out.println("   public static void main(String[] args) {");
                    out.println("      String s;");
                    out.println("      boolean b;");
                    out.println("      double d;");
                    out.println("      int i;");
                    out.println("      i = Assignment3_" + id + ".menu(new java.util.Scanner(\"0\\n\"), new String[]{\"one\"});");
                    out.println("      Assignment3_" + id + ".formatCategoryName(new String[]{\"one\"});");
                    out.println("      Assignment3_" + id + ".calculateGrade(new String[]{}, new int[]{0}, new int[]{10, 10});");
                    out.println("   }");
                    out.println("}");
                }

                ProcessBuilder compileMeProcessBuilder = new ProcessBuilder("javac", compileMeFilename);
                compileMeProcessBuilder.redirectErrorStream(true);
                Process compileMeProcess = compileMeProcessBuilder.start();
                int compileMeExitCode = compileMeProcess.waitFor();

                if (compileMeExitCode != 0) {
                    System.out.println("ERROR: Something is wrong in your java program or method names.");
                } else {
                    System.out.println("Your program seems to have correct method names.");
                }

                // Delete the generated files
                new File(compileMeFilename).delete();
                new File("Assignment3_CompileMe.class").delete();
            }
        } catch (IOException | InterruptedException e) {
            System.out.println("ERROR: Something is wrong in your java program or filename.");
            e.printStackTrace();
        }
    }
}
