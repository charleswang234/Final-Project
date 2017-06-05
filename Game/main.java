import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class main here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class main extends Actor
{
    private int speedUpDown = 0; //IN PROGRESS
    private boolean fall = false; //IN PROGRESS
    private int speedRight = 5; //speed of moving right
    private int speedLeft = -5; //speed of moving left
    private int changeX; //changing getX() indirectly first
    private int changeY; //changing getY() indirectly first
    private boolean touchingBlock = false; //checks if touching block from top so main character can jump

    /**
     * Act - do whatever the main wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        copy();
        objectCollision();
        move();
        //fall(); //IN PROGRESS
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

        if (blocksLeftRight != null){
            if (getX() + 24 < blocksLeftRight.getX()){
                speedRight = 0;
                changeX = blocksLeftRight.getX() - 29;

            }else if (getX() - 24 > blocksLeftRight.getX()){
                speedLeft = 0;
                changeX = blocksLeftRight.getX() + 29;
            }
        }else{
            speedRight = 5;
            speedLeft = -5;
        }

        Actor blocksUpDown = getOneIntersectingObject(blueBlock.class);
        if (blocksUpDown != null){
            
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
            if (speedUpDown <= 10 ){
                speedUpDown++; 
            }
        }else if (!fall) {
            speedUpDown = 0;
        }
        changeY += speedUpDown;
    }

    /**
     * create jump and jump delay nd can only jump when on the block
     * touching the block, unable to moving certain areas
     */
}
