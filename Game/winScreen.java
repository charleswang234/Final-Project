import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Screen that displays the the amount of time taken to finish the game and the number of deaths. 
 * 
 * @author Charles Wang and Victor Huang
 * @version June 2017
 */
public class winScreen extends World
{
    /**
     * Constructor for objects of class winScreen.
     * 
     */
    public winScreen()
    {    
        super(840, 600, 1); 
        prepare();
    }
    
    public void prepare(){
        addObject(new backMenuOne(),605,480); //allows access back to the menu world
        ZeeWeeld.gameWin = true; //allows game to restart
    }
}
