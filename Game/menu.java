import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Menu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class menu extends World
{
    /**
     * Constructor for objects of class Menu.
     * 
     */
    public menu()
    {    
        super(840, 600, 1);
        prepare();
    }
    
    public void prepare(){
        addObject(new newGame(),675,170);
        addObject(new continueButton(),675,260);
        addObject(new howToPlayButton(),675,350);
        addObject(new creditsButton(),675,440);
        
        //Resets the game's variables
        ZeeWeeld.level = 0;
        ZeeWeeld.deaths = 0;
        ZeeWeeld.time = 0;
    }
}
