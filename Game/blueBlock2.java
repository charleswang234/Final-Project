import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Block used for left and right character collisions
 * 
 * @author Charles Wang and Victor Huang
 * @version June 2017
 */
public class blueBlock2 extends Actor
{
    /**
     * Sets colour of the block based on the level of the game
     * There are 6 levels in total
     */
    public blueBlock2(){
        if (((ZeeWeeld)getWorld()).level == 1){
            setImage ("green block.jpg");
        }
        else if (((ZeeWeeld)getWorld()).level == 2){
            setImage ("blue block.jpg");
        }
        else if (((ZeeWeeld)getWorld()).level == 3){
            setImage ("yellow block.jpg");
        }
        else if (((ZeeWeeld)getWorld()).level == 4){
            setImage ("magenta block.jpg");
        }
        else if (((ZeeWeeld)getWorld()).level == 5){
            setImage ("red block.jpg");
        }
        else if (((ZeeWeeld)getWorld()).level == 6){
            setImage ("cyan block.jpg");
        }
    }   
}
