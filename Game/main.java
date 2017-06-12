import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class main here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class main extends Actor
{

    //game character is 30 X 30 and every block is 30 by  

    private int speedUpDown = 0; //IN PROGRESS
    private boolean fall = false; //IN PROGRESS
    private int speedRight = 5; //speed of moving right
    private int speedLeft = -5; //speed of moving left
    private int changeX; //changing getX() indirectly first
    private int changeY; //changing getY() indirectly first
    private boolean jumping = false; //checks if touching block from top so main character can jump

    /**
     * Act - do whatever the main wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        copy();

        objectCollision();
        move();

        fall(); 
        jump(); 
        setLocation(changeX, changeY);
        spikeCollision();
        doorUnlockCollision();
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
        Actor blocksUpDown = getOneIntersectingObject(blueBlock.class);
        Actor blocksLeftRight = getOneIntersectingObject(blueBlock2.class);

        if (blocksUpDown != null){
            if (changeX + 30 > blocksUpDown.getX() && changeX - 30 < blocksUpDown.getX() && changeY + 18 < blocksUpDown.getY()){
                fall = false;
                changeY = blocksUpDown.getY() - 29;
                jumping = true;
            }else if (changeX + 25 > blocksUpDown.getX() && changeX - 25 < blocksUpDown.getX()){
                changeY = blocksUpDown.getY() + 29;
                speedUpDown = 0;
                fall = true;
            }
        }else{
            fall = true;
            jumping = false;
        }

        if (blocksLeftRight != null){
            if (changeX + 24 < blocksLeftRight.getX() && changeY + 28 >= blocksLeftRight.getY() && changeY - 28 <= blocksLeftRight.getY()){
                speedRight = 0;
                changeX = blocksLeftRight.getX() - 29;
            }else if (changeX - 24 > blocksLeftRight.getX() && changeY + 28 >= blocksLeftRight.getY() && changeY - 28 <= blocksLeftRight.getY()){
                speedLeft = 0;
                changeX = blocksLeftRight.getX() + 29;
            }else{
                speedRight = 5;
                speedLeft = -5;
            }
        }else{
            speedRight = 5;
            speedLeft = -5;
        }
    }

    private void spikeCollision(){
        Actor spikeBot = getOneIntersectingObject(botSpike.class);
        Actor spikeRight = getOneIntersectingObject(rightSpike.class);
        Actor spikeTop = getOneIntersectingObject(topSpike.class);
        Actor spikeLeft = getOneIntersectingObject(leftSpike.class);

        if (spikeBot != null || spikeRight != null || spikeTop != null || spikeLeft != null){
            setLocation(135,135);
        }
    }   

    /**
     * Collision for unlocking door
     */
    private void doorUnlockCollision(){
        Actor unlockDoor = getOneIntersectingObject(doorUnlock.class);
        if (unlockDoor != null && speedUpDown > 0){
            ((MyWorld)getWorld()).removeObject(((MyWorld)getWorld()).door);
            
        }
    }   

    /**
     * Method to change the coordinates of the main character indirectly
     * and then apply it directly at the very end of act
     */
    private void copy(){
        changeX = getX();
        changeY = getY();
    }

    /**
     * Falling method  IN PROGRESS
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
     * create jump and jump delay and can only jump when on the block
     * touching the block, unable to moving certain areas
     */
    private void jump(){
        if (jumping && Greenfoot.isKeyDown("up")){
            speedUpDown = -15;
            fall = true;
            changeY += speedUpDown;
        }
    }

}
