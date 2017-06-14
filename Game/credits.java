import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * World needed to complete level 5 for This is the Only Level Reboot. Also gives credit to significant people
 * 
 * @author Charples Wang and Victor Huang
 * @version June 2017
 */
public class credits extends World
{
    /**
     * Constructor for objects of class credits.
     * 
     */
    public credits()
    {    
        super(840, 600, 1); 
        prepare();
    }
    
    public void prepare(){
        addObject(new backMenuOne(),630,460); //allows access back to the menu world
        addObject(new troll(), 204,325); //object needed to click to complete level 5
    }
}
