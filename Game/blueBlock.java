import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Block used for up and down character collisions
 * 
 * @author Charles Wang and Victor Huang
 * @version June 2017
 */
public class blueBlock extends Actor
{
    /**
     * Sets colour of the block based on the level of the game
     * There are 6 levels in total
     */
    public blueBlock(){
            setImage (((ZeeWeeld)getWorld()).levelColour.get(((ZeeWeeld)getWorld()).level));
    }
}
