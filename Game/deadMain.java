import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class deadMain here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class deadMain extends Actor
{   
    private int deathTime = 0;
    public deadMain(){
        deathTime = ((ZeeWeeld)getWorld()).time;
    }

    public void act(){
        if (((ZeeWeeld)getWorld()).time >= deathTime + 2){
            ((ZeeWeeld)getWorld()).removeObject(this);
        }
    }
}