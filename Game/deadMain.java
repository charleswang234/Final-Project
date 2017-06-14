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
        deathTime = ZeeWeeld.time; //sets the death time to the current amount of time played
    }

    /**
     * Method that will remove the dead body after a specified time
     */
    public void act(){
        if (ZeeWeeld.time >= deathTime + 4){ //If past a given time (4 seconds), this object will be removed
            ((ZeeWeeld)getWorld()).removeObject(this);
        }
        if (this.getImage().getTransparency() > 2){ //Slowly decreases the transparency of the object until it is transparent
            this.getImage().setTransparency(this.getImage().getTransparency() - 2);
        }
    }
}