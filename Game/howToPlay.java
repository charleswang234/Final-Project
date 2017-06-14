import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Displays the instruction for This is the Only Level Reboot
 * 
 * @author Charles Wang and Victor Huang
 * @version June 2017
 */
public class howToPlay extends World
{
    /**
     * Constructor for objects of class howToPlay.
     * 
     */
    public howToPlay()
    {    
        super(840, 600, 1);
        prepare();
    }
    
    public void prepare(){
        addObject(new backMenuOne(),420,470); //allows access back to the menu world
    }
}