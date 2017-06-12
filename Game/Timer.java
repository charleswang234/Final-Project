import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Timer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Timer extends Actor
{
    int count = 0;
    /**
     * Act - do whatever the Timer wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        count++;
        if (count == 60){
            ((ZeeWeeld)getWorld()).time += 1;
            count = 0;
            ((ZeeWeeld)getWorld()).gameTime.setValue("Time: " + ((ZeeWeeld)getWorld()).time/60 + ":" + ((ZeeWeeld)getWorld()).time%60);
        }
    }    
}
