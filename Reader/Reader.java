
/**
 * Counts the total number of characters, sentences, and words in a bunch of files.
 * 
 * Justin Liang
 * 1/27/09
 */
import java.io.*;
import java.util.*;
public class Reader
{
    public static String file = "";
    public static int sentenceCount = 0;
    public static int wordCount = 0;
    public static int charCount = 0;
    
    /**
     * Runs the program.
     */
    public static void main(String[] args) throws FileNotFoundException, IOException
    {
        Scanner input = new Scanner(System.in);
        Reader fileCounter = new Reader();
        boolean fileFound = true;
        
        while(fileFound)
        {
            System.out.println("Please enter the file name:");
            file = input.next();
            fileCounter.countChar();
            fileCounter.countSentence();
            fileCounter.countWord();
        }
    }
    
    /**
     * Counts the total characters of all the files the user inputed.
     */
    public void countChar() throws FileNotFoundException, IOException
    {
        try
        {
            FileReader reader = new FileReader(file);
            Scanner in = new Scanner(reader);
            while(reader.read() != -1)
            {   
                charCount++;
            }
            in.close();
        }
        
        catch(FileNotFoundException exception)
        {
            System.out.println("The number of characters are: " +charCount);
        }
        
        catch(IOException exception)
        {
            System.out.println("The number of characters are: " +charCount);
        }
    }
    
    /**
     * Counts the total sentences of all the files the user inputed.
     */
    public void countSentence() throws FileNotFoundException, IOException
    {
        try
        {
            FileReader reader = new FileReader(file);
            Scanner in = new Scanner(reader);
            while(in.hasNext())
            {
                String word = in.next();
                for(int i = 0; i < word.length(); i++)
                {
                    String currentChar = word.charAt(i) + "";
                    if(currentChar.equals(".") || currentChar.equals("?") || currentChar.equals("!"))
                        sentenceCount++;
                }
            }
            in.close();
        }
        
        catch(FileNotFoundException exception)
        {
            System.out.println("The number of sentences are: " +sentenceCount);
        }
        catch(IOException exception)
        {
            System.out.println("The number of sentences are: " +sentenceCount);
        }
    }
    
    /**
     * Counts the total words of all the files the user inputed.
     */
    public void countWord() throws FileNotFoundException, IOException
    {
        try
        {
            FileReader reader = new FileReader(file);
            Scanner in = new Scanner(reader);
            while(in.hasNext())
            {
                String word = in.next();
                wordCount++;
            }
            in.close();
        }
        
        catch(FileNotFoundException exception)
        {
            System.out.println("The number of words are: " +wordCount);
        }
        catch(IOException exception)
        {
            System.out.println("The number of words are: " +wordCount);
        }
    }
}