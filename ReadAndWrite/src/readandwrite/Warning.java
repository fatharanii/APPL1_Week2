package readandwrite;
import java.util.Scanner;
import java.io.*;
public class Warning
{
    // --------------------------------------------------------------------
    // Reads student data (name, semester hours, quality points) from a
    // text file, computes the GPA, then writes data to another file
    // if the student is placed on academic warning.
    // --------------------------------------------------------------------
    public static void main (String[] args)
    {
        int creditHrs; // number of semester hours earned
        double qualityPts; // number of quality points earned
        double gpa; // grade point (quality point) average
        String line, name, inputName = "students.dat";
        String outputName = "warning.dat";
        File studentsFile = new File("D:\\Coolyeah Fucking Hell\\4\\Dokumen\\APPL\\Student.dat");
        File warningFile = new File("D:\\Coolyeah Fucking Hell\\4\\Dokumen\\APPL\\Warning.dat");
        try
        {
            Scanner scan = new Scanner(studentsFile);
            PrintWriter outFile = new PrintWriter(warningFile);
            
            // Print a header to the output file
            outFile.println ();
            outFile.println ("Students on Academic Warning");
            outFile.println ();
            // Process the input file, one token at a time
            while (scan.hasNext())
            {
                name = scan.next();
                creditHrs = scan.nextInt();
                qualityPts = scan.nextDouble();
                line = name + " " + creditHrs + " " + qualityPts;
            // determine if the student is on warning. If so,
            // write the student data to the output file.
                if ((qualityPts/creditHrs<1.5)&&(creditHrs<30)){
                   outFile.println(line);
                }
                else if ((qualityPts/creditHrs<1.75)&&(creditHrs<60)){
                    outFile.println(line);
                }
                else if (qualityPts/creditHrs<2){
                    outFile.println(line);
                }
            }
            // Close output file
            outFile.close();
        }
        catch (FileNotFoundException exception)
        {
        System.out.println ("The file " + inputName + " was not found.");
        }
        catch (IOException exception)
        {
        System.out.println (exception);
        }
        catch (NumberFormatException e)
        {
        System.out.println ("Format error in input file: " + e);
        }
    }
}
