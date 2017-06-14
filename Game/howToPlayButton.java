import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Image allowed for mouse click to link to howToPlay screen
 * 
 * @author Charles Wang and Victor Huang
 * @version June 2017
 */
public class howToPlayButton extends Actor
{
    /**
     * Act - do whatever the howToPlayButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (Greenfoot.mouseClicked(this)){ //if mouseclicked
            Greenfoot.setWorld(new howToPlay()); //sets it to the howToPlay world
        }
    }
}
