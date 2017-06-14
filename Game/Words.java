import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

/**
 * The words class is used to put words into a list and randomizes them.
 * 
 * @author Charles Wang and Victor Huang
 * @version June 2017
 */
public class Words extends Actor
{
    private ArrayList<String> nounsAdjVerbs = new ArrayList<String>(); //Arraylist for holding all words
    private final int queueSize = 2000; //Restricts the size of the word queue
    private int number = 0; //Holds the index value of the ArrayList
    public Queue<String> wordQueue = new Queue<String>(); //Holds all the randomly selected words that the player will type
    Random r = new Random();
    
    /**
     * Reads and puts all the words from the text files into an ArrayList when an instance of words is created.
     */
    public Words(){
        Reader read = new Reader();
        Scanner r = read.getScanner("nouns.txt");
        String str = "";
        while (r.hasNext()){ //puts all nouns into Arraylist
            str = r.nextLine();
            nounsAdjVerbs.add(str);
        }       

        r = read.getScanner("adjectives.txt");
        while (r.hasNext()){ //puts all adjectives into Arraylist
            str = r.nextLine();
            nounsAdjVerbs.add(str);
        }   

        r = read.getScanner("verbs.txt");   
        while (r.hasNextLine()){ //puts all verbs into Arraylist
            str = r.nextLine();
            nounsAdjVerbs.add(str);
        }   
    }

    /**
     * Randomly selects words and puts them into a queue;
     */
    public void randomWords(){
        for(int i = 0; i < queueSize; i++){
            number = r.nextInt(nounsAdjVerbs.size()); //Randomly generates a index value
            wordQueue.enqueue(nounsAdjVerbs.get(number)); //Adds a word from the Arraylist to the queue
        }
    }
}
