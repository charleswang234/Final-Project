import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class newGame here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class newGame extends Actor
{
    /**
     * Act - do whatever the newGame wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (Greenfoot.mouseClicked(this)){
            ZeeWeeld.deaths = 0;
            ZeeWeeld.time = 0;
            Greenfoot.setWorld(new levelOne());
        }
    }    
}
