import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Level 6 for This is the Only Level Reboot
 * 
 * @author Charles Wang and Victor Huang
 * @version June 2017
 */
public class levelSix extends ZeeWeeld
{
    private int correct = 0;
    /**
     * Constructor for objects of class levelSix.
     * 
     */
    public levelSix()
    {
        super(6);
        prepare();
    }

    public void act(){
        key = Greenfoot.getKey();//Checks the last key pressed

        //Gets the word you need to type and the word you have currently typed
        word1 = currentWord.getLabel();
        word2 = playerInput.getLabel();

        //Runs the correct word method after typing in the full word
        if(word2.equals(word1)){
            correct += 1;
            correct();
        }

        //Code to check if the letter you typed in is the correct letter
        if(key != null){
            if (key.equals(word1.substring(count,count+1))){
                playerInput.setValue(playerInput.getLabel() + key); //Updates the word the player has typed
                count++; //Updates the amount of letters typed so far
            }else if (Greenfoot.isKeyDown("space") && word1.substring(count,count+1).equals(" ")){
                playerInput.setValue(playerInput.getLabel() + " "); //Updates the word the player has typed
                count++; //Updates the amount of letters typed so far
            }
            //Ensures that score is not deducted for moving Mario or when you restart the game
            else if (key.equals("left") || key.equals("right") || key.equals("up") || key.equals("down")){
            }
            else{
                deaths += 1;
                correct = 0;
                deathCount.setValue("Deaths: " + deaths);//Updates death count
                character.setLocation(135,255);
            }
        }
    }

    public void correct(){
        if (correct == 1){
            character.setLocation(195,165);
        }
        else if (correct == 2){
            character.setLocation(285,285);
        }
        else if (correct == 3){
            character.setLocation(375,135);
        }
        else if (correct == 4){
            character.setLocation(435,195);
        }
        else if (correct == 5){
            character.setLocation(585,225);
        }
        else if (correct == 6){
            character.setLocation(675,315);
        }
        else if (correct == 7){
            character.setLocation(705,405);
        }
        else if (correct == 8){
            Greenfoot.setWorld(new winScreen());
        }
        //Procedure to get a new word
        String oldWord = currentWord.getLabel();
        words.wordQueue.enqueue(oldWord); //Puts the word back into the queue
        currentWord.setValue(words.wordQueue.dequeue()); //Gets a new word
        playerInput.setValue(""); //Clears the user input
        deathCount.setValue("Deaths: " + deaths);//Updates death count
        count = 0;
    }
}