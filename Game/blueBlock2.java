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
        setImage (((ZeeWeeld)getWorld()).levelColour.get(((ZeeWeeld)getWorld()).level));
    }   
}
