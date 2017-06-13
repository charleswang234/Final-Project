import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class howToPlay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
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
        addObject(new backMenuOne(),420,470);
    }
}