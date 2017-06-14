import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Image allowed for mouse click to link to credits screen
 * 
 * @author Charles Wang and Victor Huang
 * @version June 2017
 */
public class creditsButton extends Actor
{
    /**
     * Act - do whatever the credits wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (Greenfoot.mouseClicked(this)){ 
            Greenfoot.setWorld(new credits()); //Sets the world the the credits world
        }
    }    
}
