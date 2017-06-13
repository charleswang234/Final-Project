import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class credits here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
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
        addObject(new backMenuOne(),630,460);
        addObject(new troll(), 204,325);
    }
}
