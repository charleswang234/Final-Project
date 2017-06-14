import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Level 6 for This is the Only Level Reboot
 * 
 * @author Charles Wang and Victor Huang
 * @version June 2017
 */
public class levelSix extends ZeeWeeld
{
    private int correct = 0; //integer for counting the number of correct words typed
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
        panic();//Checks if the panic button was pressed

        key = Greenfoot.getKey();//Checks the last key pressed

        //Gets the word you need to type and the word you have currently typed
        word1 = currentWord.getLabel();
        word2 = playerInput.getLabel();

        //Runs the correct word method after typing in the full word
        if(word2.equals(word1)){
            correct += 1; //increases correct by one
            correct(); //runs the correct mothod
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
            //Ensures that character does not die when trying to use the arrow keys
            else if (key.equals("left") || key.equals("right") || key.equals("up") || key.equals("down")){
            }
            else{
                deaths += 1; //Increases death by one if wrong letter typed
                correct = 0; //Restarts the number of correct words
                deathCount.setValue("Deaths: " + deaths);//Updates death count
                character.setLocation(135,255); //Respawns the character at the start location of the screen
                addObject(door,735,390);  //Readds the door 
                unlockDoor.getImage().setTransparency(255);//Sets the button to opaque
            }
        }
    }

    /**
     * Moves the non-player controlled character across the screen. Depending on the number of consecutive words typed correctly without
     * any mistakes, the character will be placed at specific locations, while slowly getting closer to the destination
     */
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
            unlockDoor.getImage().setTransparency(0); //Sets the button to be transparent
            removeObject(door); //Removes the door 
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
            Greenfoot.setWorld(new levelSeven());
        }

        //Procedure to get a new word
        String oldWord = currentWord.getLabel();
        words.wordQueue.enqueue(oldWord); //Puts the word back into the queue
        currentWord.setValue(words.wordQueue.dequeue()); //Gets a new word
        playerInput.setValue(""); //Clears the user input
        count = 0; //restarts the number of letters typed
    }
    
    /**
     * If player clicks the panic button. Character will respawn at start pipe
     */
    private void panic(){
        if (Greenfoot.mouseClicked(restart)){
            deaths += 1; //Increases death by one if wrong letter typed
            correct = 0; //Restarts the number of correct words
            deathCount.setValue("Deaths: " + deaths);//Updates death count
            character.setLocation(135,255); //Respawns the character at the start location of the screen
            addObject(door,735,390);  //Readds the door 
            unlockDoor.getImage().setTransparency(255);//Sets the button to opaque
        }
    }
}