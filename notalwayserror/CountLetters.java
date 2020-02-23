package notalwayserror;

import java.util.Scanner;
public class CountLetters
{
    static char errorVar;
    public static void main(String[] args)
    {
        int[] counts = new int[26];
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter a single word (letters only, please): ");
        String word = scan.nextLine();

        word = word.toUpperCase();
        
        try {
            for (int i = 0; i<word.length(); i++){
                counts[word.charAt(i)-'A']++;
                errorVar = word.charAt(i+1);
            }
        }
        catch (Exception e){
            e.printStackTrace();
            System.out.println ("Not a letter");
            System.out.println("Out of bound : " + errorVar);
        }
        

        System.out.println();
        for (int i=0; i < counts.length; i++)
            if (counts [i] != 0)
            System.out.println((char)(i +'A') + ": " + counts[i]);
    }
}