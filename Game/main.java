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
    private int speedRight = 5;
    private int speedLeft = -5;
    private int changeX;
    private int changeY;

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
        Actor blocks = getOneIntersectingObject(blueBlock.class);

        if (blocks != null){
            //fall = false; //testing IN PROGRESS
            if (getX() + 24 < blocks.getX()){
                speedRight = 0;
                changeX = blocks.getX() - 29;

            }else if (getX() - 24 > blocks.getX()){
                speedLeft = 0;
                changeX = blocks.getX() + 29;
            }else if (speedLeft == 10){

            }else if (speedLeft == 10){

            }
        }else{
            //fall = true; //testing IN PROGRESS
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
        int count = 0;
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
