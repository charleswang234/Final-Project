import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Actor for the dead body of the character
 * 
 * @author Charles Wang and Victor Huang
 * @version June 2017
 */
public class deadMain extends Actor
{   

    private int deathTime = 0; //Instance variable that measures how long the dead body will remain
    public deadMain(){
        deathTime = ((ZeeWeeld)getWorld()).time; //sets the death time to the current amount of time played
    }

    /**
     * Method that will remove the dead body after a specified time
     */
    public void act(){
        if (((ZeeWeeld)getWorld()).time >= deathTime + 4){
            ((ZeeWeeld)getWorld()).removeObject(this);
        }
        if (this.getImage().getTransparency() > 2){
            this.getImage().setTransparency(this.getImage().getTransparency() - 2);
        }
    }
}