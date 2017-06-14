import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.HashMap;
/**
 * Actor class for the main character of the game. Includes object collision and movement as well as some removing/adding objects.
 * 
 * @author Charles Wang and Victor Huang
 * @version June 2017
 */
public class main extends Actor
{

    //Game character is 30 X 30

    private int speedUpDown = 0; //Speed that the character falls or rises at
    private boolean fall = false; //Checks if character is falling 
    private int speedRight = 5; //Speed of moving right
    private int speedLeft = -5; //Speed of moving left
    private int changeX; //Changing getX() indirectly first
    private int changeY; //Changing getY() indirectly first
    private boolean jumping = false; //Checks if touching block from top so main character can jump

    //changing variables depending on the level
    private int speed; //changing speed
    private int collisionSetX; //changing object collision
    private int numberOfJumps; //changing the number of jumps

    public main(){
        //changes variables depending on the level of the game
        if (ZeeWeeld.level == 1){ //normal level
            speed = 5;
            collisionSetX = 24;
            numberOfJumps = 2;
        }
        else if (ZeeWeeld.level == 2){ //can only jump once in this level
            speed = 8;
            collisionSetX = 21;
            numberOfJumps = 1;
        }else if (ZeeWeeld.level == 3){ //inverse controls in this level
            speed = -5;
            collisionSetX = 24;
            numberOfJumps = 2;
        }else if (ZeeWeeld.level == 4){ //white screen for this level
            speed = 5;
            collisionSetX = 24;
            numberOfJumps = 2;
        }else if (ZeeWeeld.level == 5){ //Need to go to credits screen level
            speed = 5;
            collisionSetX = 24;
            numberOfJumps = 2;
        }else if (ZeeWeeld.level == 6){ //typing game in this level 
            speed = 5;
            collisionSetX = 24;
            numberOfJumps = 2;
        }

    }

    /**
     * Act - do whatever the main wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        copy();
        objectCollision();
        doorCollision();    
        move();
        fall(); 
        jump(); 
        setLocation(changeX, changeY);
        spikeCollision();
        doorUnlockCollision();
        belowDeath();
        endPipeCollision();
    }    

    /**
     * Allows main character to move left and right
     */
    private void move(){
        if (Greenfoot.isKeyDown("right")){
            changeX += speedRight;
        }
        if (Greenfoot.isKeyDown("left")){
            changeX += speedLeft;
        }
    }

    /**
     * object collision with blocks
     */
    private void objectCollision(){
        Actor blocksUpDown = getOneIntersectingObject(blueBlock.class); //Intersecting on top or bottom
        Actor blocksLeftRight = getOneIntersectingObject(blueBlock2.class); //Intersecting on left and right side

        if (blocksUpDown != null){
            if (changeX + 30 > blocksUpDown.getX() && changeX - 30 < blocksUpDown.getX() && changeY + 18 < blocksUpDown.getY()){
                fall = false;
                changeY = blocksUpDown.getY() - 29;
                jumping = true;
            }else if (changeX + 29 > blocksUpDown.getX() && changeX - 29 < blocksUpDown.getX()){
                changeY = blocksUpDown.getY() + 29;
                speedUpDown = 0;
                fall = true;
            }
        }else{
            fall = true;
            jumping = false;
        }

        if (blocksLeftRight != null){
            if (changeX + collisionSetX < blocksLeftRight.getX() && changeY + 28 >= blocksLeftRight.getY() && changeY - 28 <= blocksLeftRight.getY()){
                if (ZeeWeeld.level == 3){ //movement is inversed and collision is inversed for level three
                    speedLeft = 0;
                }else{
                    speedRight = 0;
                }
                changeX = blocksLeftRight.getX() - 29;
            }else if (changeX - collisionSetX > blocksLeftRight.getX() && changeY + 28 >= blocksLeftRight.getY() && changeY - 28 <= blocksLeftRight.getY()){
                if (ZeeWeeld.level == 3){ //movement is inversed and collision is inversed for level three
                    speedRight = 0;
                }else{
                    speedLeft = 0;
                }
                changeX = blocksLeftRight.getX() + 29;
            }else{
                speedRight = speed;
                speedLeft = -speed;
            }
        }else{
            speedRight = speed;
            speedLeft = -speed;
        }
    }

    /**
     * Object collision with spikes 
     */
    private void spikeCollision(){
        Actor spikeBot = getOneIntersectingObject(botSpike.class); //Bottom spike
        Actor spikeRight = getOneIntersectingObject(rightSpike.class); //Right spike
        Actor spikeTop = getOneIntersectingObject(topSpike.class); //Top spike
        Actor spikeLeft = getOneIntersectingObject(leftSpike.class); //Left spike
        if (spikeBot != null || spikeRight != null || spikeTop != null || spikeLeft != null){
            setLocation(135,135); //Respawns the character at the start pipe
            ZeeWeeld.deaths += 1; //Increases the death count after death
            ((ZeeWeeld)getWorld()).deathCount.setValue("Deaths: " + ZeeWeeld.deaths); //Updates death count
            ((ZeeWeeld)getWorld()).addObject(new deadMain(),changeX,changeY); // Replaces character with a dead body
            ((ZeeWeeld)getWorld()).addObject(((ZeeWeeld)getWorld()).door,735,390);  //Readds the door 
            ((ZeeWeeld)getWorld()).unlockDoor.getImage().setTransparency(255);//Sets the button to opaque
            if (ZeeWeeld.level == 2){ //resets and allows the character to jump once if it is level 2
                numberOfJumps = 1;
            }else if (ZeeWeeld.level == 4){ //Resets and makes the door tranparent again
                ((ZeeWeeld)getWorld()).door.getImage().setTransparency(0);//Sets the door to transparent
            }
        }
    }   

    /**
     * If character accidentally falls below given area. Character will respawn at start pipe
     */
    private void belowDeath(){
        if (changeY > 465){
            Actor unlockDoor = getOneIntersectingObject(doorUnlock.class);
            setLocation(135,135); //Respawns the character at the start pipe
            ZeeWeeld.deaths += 1; //Increases the death count after death
            ((ZeeWeeld)getWorld()).deathCount.setValue("Deaths: " + ZeeWeeld.deaths); //Updates death count
            ((ZeeWeeld)getWorld()).addObject(((ZeeWeeld)getWorld()).door,735,390); //Readds the door 
            ((ZeeWeeld)getWorld()).unlockDoor.getImage().setTransparency(255);//Sets the button to opaque
            if (ZeeWeeld.level == 2){ //resets and allows the character to jump once if it is level 2
                numberOfJumps = 1;
            }else if (ZeeWeeld.level == 4){ //Resets and makes the door tranparent again
                ((ZeeWeeld)getWorld()).door.getImage().setTransparency(0);//Sets the door to transparent
            }
        }
    }

    /**
     * Collision for unlocking door
     */
    private void doorUnlockCollision(){
        Actor unlockDoor = getOneIntersectingObject(doorUnlock.class); //Button needed to be pressed

        if (unlockDoor != null){ //If touching the button
            ((ZeeWeeld)getWorld()).unlockDoor.getImage().setTransparency(0); ////Sets the button to transparent
            if (ZeeWeeld.level != 5){
                ((ZeeWeeld)getWorld()).removeObject(((ZeeWeeld)getWorld()).door); //removes the door
            }
        }
        if (ZeeWeeld.level == 5 && ZeeWeeld.trollingTrue){ //removes the door if the condition is met (credits page was used properly)
            ((ZeeWeeld)getWorld()).removeObject(((ZeeWeeld)getWorld()).door); //removes the door
        }
    }   

    /**
     * Collision with the door, not allowing the character to reach its final destination
     */
    private void doorCollision(){
        Actor door = getOneIntersectingObject(door.class); //the door
        if (door != null){
            if (changeX + collisionSetX < door.getX() && changeY + 58 >= door.getY() && changeY - 58 <= door.getY()){
                speedRight = 0;
                changeX = door.getX() - 29;
            }
        }
    }

    /**
     * Collision with the end pipe, sets a new level if possible
     * If last world is reached, sets the winScreen instead
     */
    private void endPipeCollision(){
        Actor endPipe = getOneIntersectingObject(endPipe.class); //when touching the endpipe
        if (endPipe != null && changeX > endPipe.getX()){
            if (ZeeWeeld.level == 1){
                Greenfoot.setWorld(new levelTwo()); //Sets the level 2 world
            }else if (ZeeWeeld.level == 2){
                Greenfoot.setWorld(new levelThree()); //Sets the level 3 world
            }else if (ZeeWeeld.level == 3){
                Greenfoot.setWorld(new levelFour()); //Sets the level 4 world
            }else if (ZeeWeeld.level == 4){
                Greenfoot.setWorld(new levelFive()); //Sets the level 5 world
            }else if (ZeeWeeld.level == 5){
                Greenfoot.setWorld(new levelSix()); //Sets the level 6 world
            }else if (ZeeWeeld.level == 6){
                Greenfoot.setWorld(new winScreen()); //Sets the winScreen world
            }
        }
    }

    /**
     * Method to change the coordinates of the main character indirectly
     * and then applying it directly in act
     */
    private void copy(){
        changeX = getX();
        changeY = getY();
    }

    /**
     * Falling method for the character
     */
    private void fall(){ 
        if (fall){
            if (speedUpDown < 10){ //max speed of 10 units per act 
                speedUpDown++; 
            }
        }else {
            speedUpDown = 0;
        }
        changeY += speedUpDown; //changes y value depending on the up down speed
    }

    /**
     * Create jump and jump delay and can only jump when on the block touching the block
     */
    private void jump(){
        if (jumping && Greenfoot.isKeyDown("up") && (numberOfJumps == 2 || numberOfJumps == 1)){ //if numberOfJumps is 2, character will have infinite jumps
            speedUpDown = -15; //jump speed
            fall = true; //allows the character to fall
            changeY += speedUpDown;
            if (numberOfJumps == 1){ //if number of jumps is 1, character will not be able to jump again 
                numberOfJumps = 0;
            }
        }
    }

}
