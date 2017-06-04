import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class main here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class main extends Actor
{
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

            if (getX() + 24 < blocks.getX()){
                speedRight = 0;
                changeX = blocks.getX() - 29;
                
            }else if (getX() - 24 > blocks.getX()){
                speedLeft = 0;
                changeX = blocks.getX() + 29;
            }
        }else{
            speedRight = 5;
            speedLeft = -5;
        }

    }
    
    private void copy(){
        changeX = getX();
        changeY = getY();
    }
    /**
     * create jump and jump delay nd can only jump when on the block
     * touching the block, unable to moving certain areas
     */
}
