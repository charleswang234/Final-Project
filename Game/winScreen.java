import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Screen that displays the the amount of time taken to finish the game and the number of deaths. 
 * 
 * @author Charles Wang and Victor Huang
 * @version June 2017
 */
public class winScreen extends World
{
    Label gameTime = new Label(ZeeWeeld.time/60 + ":" + ZeeWeeld.time%60, 45); //Label for the amount of time player took to beat the game
    Label deathCount = new Label(ZeeWeeld.deaths, 45); //Label for the amount of deaths the player had
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
        addObject(gameTime,180,400); // adds the time the player took to beat the game
        addObject(deathCount,180,450); // adds the time the player took to beat the game
        ZeeWeeld.gameWin = true; //allows game to restart
    }
}
