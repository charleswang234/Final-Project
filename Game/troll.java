import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class troll here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class troll extends Actor
{
    /**
     * Act - do whatever the troll wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (Greenfoot.mouseClicked(this)){
            if (ZeeWeeld.level == 5){
                ZeeWeeld.trollingTrue = true;
                Greenfoot.setWorld(new menu());
            }
        }
    }    
}
