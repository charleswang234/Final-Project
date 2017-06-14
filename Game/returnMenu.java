import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Image allowed for mouse click to link to menu screen while in game
 * 
 * @author Charles Wang and Victor Huang
 * @version June 2017
 */
public class returnMenu extends Actor
{
    /**
     * Act - do whatever the returnMenu wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (Greenfoot.mouseClicked(this)){
            Greenfoot.setWorld(new menu()); //Sets the world the the menu world
        }
    }    
}
