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

        fall(); //IN PROGRESS 
        jump();	
        setLocation(changeX, changeY);
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
        Actor blocksLeftRight = getOneIntersectingObject(blueBlock.class);
        Actor blocksUpDown = getOneIntersectingObject(blueBlock.class);
        if (blocksUpDown != null){
            if (changeX + 30 > blocksUpDown.getX() && changeX - 30 < blocksUpDown.getX() && changeY + 19 < blocksUpDown.getY()){
                fall = false;
                changeY = blocksUpDown.getY() - 29;
                jumping = true;
            }
        }else{
            fall = true;
            jumping = false;
        }

        if (blocksLeftRight != null){
            if (changeX + 23 < blocksLeftRight.getX() && changeY + 28 >= blocksLeftRight.getY() && changeY - 28 <= blocksLeftRight.getY()){
                speedRight = 0;
                changeX = blocksLeftRight.getX() - 29;

            }else if (changeX - 23 > blocksLeftRight.getX() && changeY + 28 >= blocksLeftRight.getY() && changeY - 28 <= blocksLeftRight.getY()){
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

    private void jump(){
        if (jumping && Greenfoot.isKeyDown("up")){
            speedUpDown = -15;
            fall = true;
            changeY += speedUpDown;
        }
    }

    /**
     * create jump and jump delay nd can only jump when on the block
     * touching the block, unable to moving certain areas
     */
}
