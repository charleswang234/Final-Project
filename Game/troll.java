import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Object needed to be clicked to pass level 5 for This is the Only Level Reboot
 * 
 * @author Charles Wang and Victor Huang
 * @version June 2017
 */
public class troll extends Actor
{
    /**
     * Act - do whatever the troll wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (Greenfoot.mouseClicked(this)){ //If object is mouse clicked
            if (ZeeWeeld.level == 5){ //Only works if level is currently 5
                ZeeWeeld.trollingTrue = true; //Allows the door to be removed
                Greenfoot.setWorld(new menu()); //Returns player to menu screen to know that the button has worked
            }
        }
    }    
}
