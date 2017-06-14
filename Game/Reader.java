import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Scanner;
import java.io.InputStream;
/**
 * A reader to read through files.
 * 
 * @author Charles Wang and Victor Huang
 * @version June 2017
 */

public class Reader 
{
    /**
     * Opens a text file inside the package folder and returns a scanner to read it. Works for text files inside jar files.
     * 
     * @param filename The name of the text file to read from
     * @return A Scanner object that you can use to read the contents of the text file.
     */
    public Scanner getScanner(String filename){
        InputStream myFile = getClass().getResourceAsStream(filename);
        if(myFile != null){
            return new Scanner(myFile);
        }
        return null;
    }
}