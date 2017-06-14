import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Image allowed for mouse click to link to menu screen
 * 
 * @author Charles Wang and Victor Huang
 * @version June 2017
 */
public class backMenuOne extends Actor
{
    /**
     * Act - do whatever the backMenuOne wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (Greenfoot.mouseClicked(this)){ //if mouseclicked
            Greenfoot.setWorld(new menu()); //sets it to the menu world

            if (ZeeWeeld.level == 9 && ZeeWeeld.gameWin){ //resets the game if level 6 was reached and player has gone through the winScreen
                ZeeWeeld.level = 0; 
                ZeeWeeld.time = 0;
                ZeeWeeld.deaths = 0;
                ZeeWeeld.trollingTrue = false;
                ZeeWeeld.gameWin = false;
            }
        }
    }    
}
