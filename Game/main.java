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
        if (((ZeeWeeld)getWorld()).level == 1){
            speed = 5;
            collisionSetX = 24;
            numberOfJumps = 2;
        }
        else if (((ZeeWeeld)getWorld()).level == 2){
            speed = 8;
            collisionSetX = 21;
            numberOfJumps = 1;
        }else if (((ZeeWeeld)
            getWorld()).level == 3){
            speed = -5;
            collisionSetX = 24;
            numberOfJumps = 2;
        }else if (((ZeeWeeld)getWorld()).level == 4){
            speed = 5;
            collisionSetX = 24;
            numberOfJumps = 2;
        }else if (((ZeeWeeld)getWorld()).level == 5){
            speed = 5;
            collisionSetX = 24;
            numberOfJumps = 2;
        }else if (((ZeeWeeld)getWorld()).level == 6){
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
                if (((ZeeWeeld)getWorld()).level == 3){
                    speedLeft = 0;
                }else{
                    speedRight = 0;
                }
                changeX = blocksLeftRight.getX() - 29;
            }else if (changeX - collisionSetX > blocksLeftRight.getX() && changeY + 28 >= blocksLeftRight.getY() && changeY - 28 <= blocksLeftRight.getY()){
                if (((ZeeWeeld)getWorld()).level == 3){
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
            ((ZeeWeeld)getWorld()).deaths += 1; //Increases the death count after death
            ((ZeeWeeld)getWorld()).addObject(new deadMain(),changeX,changeY); // Replaces character with a dead body
            ((ZeeWeeld)getWorld()).addObject(((ZeeWeeld)getWorld()).door,735,390); //Readds the door 
            ((ZeeWeeld)getWorld()).addObject(((ZeeWeeld)getWorld()).unlockDoor,435,195); //Readds the button
            if (((ZeeWeeld)getWorld()).level == 2){
                numberOfJumps = 1;
            }
        }
    }   

    /**
     * If character accidentally falls below given area. Character will respawn at start pipe
     */
    private void belowDeath(){
        if (changeY > 465){
            Actor unlockDoor = getOneIntersectingObject(doorUnlock.class);
            setLocation(135,135);
            ((ZeeWeeld)getWorld()).deaths += 1; //Increases the death count after death
            ((ZeeWeeld)getWorld()).addObject(((ZeeWeeld)getWorld()).door,735,390); //Readds the door 
            ((ZeeWeeld)getWorld()).addObject(((ZeeWeeld)getWorld()).unlockDoor,435,195); //Readds the button

            if (((ZeeWeeld)getWorld()).level == 2){
                numberOfJumps = 1;
            }
        }
    }

    /**
     * Collision for unlocking door
     */
    private void doorUnlockCollision(){
        Actor unlockDoor = getOneIntersectingObject(doorUnlock.class);
        Actor buttonPressed = getOneIntersectingObject(buttonPressed.class);
        if (unlockDoor != null){
            ((ZeeWeeld)getWorld()).removeObject(((ZeeWeeld)getWorld()).door); //Removes the button
            ((ZeeWeeld)getWorld()).removeObject(((ZeeWeeld)getWorld()).unlockDoor); //removes the door
        }
    }   

    /**
     * Collision with the door, not allowing the character to reach its final destination
     */
    private void doorCollision(){
        Actor door = getOneIntersectingObject(door.class);
        if (door != null){
            if (changeX + collisionSetX < door.getX() && changeY + 58 >= door.getY() && changeY - 58 <= door.getY()){
                speedRight = 0;
                changeX = door.getX() - 29;
            }
        }
    }

    /**
     * Collision with the end pipe, sets a new world if possible
     */
    private void endPipeCollision(){
        Actor endPipe = getOneIntersectingObject(endPipe.class);
        if (endPipe != null && changeX + 0 > endPipe.getX()){
            if (((ZeeWeeld)getWorld()).level == 1){
                Greenfoot.setWorld(new levelTwo());
            }else if (((ZeeWeeld)getWorld()).level == 2){
                Greenfoot.setWorld(new levelThree());
            }else if (((ZeeWeeld)getWorld()).level == 3){
                Greenfoot.setWorld(new levelFour());
            }else if (((ZeeWeeld)getWorld()).level == 4){
                Greenfoot.setWorld(new levelFive());
            }else if (((ZeeWeeld)getWorld()).level == 5){
                Greenfoot.setWorld(new levelSix());
            }
        }
    }

    /**
     * Method to change the coordinates of the main character indirectly
     * and then apply it directly in act
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
            if (speedUpDown < 10){
                speedUpDown++; 
            }
        }else {
            speedUpDown = 0;
        }
        changeY += speedUpDown;
    }

    /**
     * Create jump and jump delay and can only jump when on the block touching the block
     */
    private void jump(){
        if (jumping && Greenfoot.isKeyDown("up") && (numberOfJumps == 2 || numberOfJumps == 1)){
            speedUpDown = -15;
            fall = true;
            changeY += speedUpDown;
            if (numberOfJumps == 1){
                numberOfJumps = 0;
            }
        }
    }

}
