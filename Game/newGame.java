import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Image allowed for mouse click to start a new game 
 * 
 * @author Charles Wang and Victor Huang
 * @version June 2017
 */
public class newGame extends Actor
{
    /**
     * Act - do whatever the newGame wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        //If clicked
        if (Greenfoot.mouseClicked(this)){
            ZeeWeeld.deaths = 0; //Resets the number of deaths
            ZeeWeeld.time = 0; //Resets the time played
            ZeeWeeld.trollingTrue = false; //Resets the level 4 credits clicker 
            Greenfoot.setWorld(new levelOne()); //changes the world to level one 
        }
    }    
}
