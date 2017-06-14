import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Start screen for the game and screen used to access most of the other worlds. 
 * Allows player to go to the howToPlay and credits world. Also allows player to either continue their game or create a new game
 * 
 * @author Charles Wang and Victor Huang
 * @version June 2017
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
        addObject(new newGame(),675,170);  //Image to allow a new game to be created
        addObject(new continueButton(),675,260); //Image to allow the game to be continued
        addObject(new howToPlayButton(),675,350); //Image to access to the howToPlay world
        addObject(new creditsButton(),675,440); //Image to access the credits world
        ZeeWeeld.music.setVolume(88); //sets the music volume
        ZeeWeeld.music.playLoop(); //loops the music
    }
}