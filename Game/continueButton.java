import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Allows player to continue the game if they have played before and did not finish the game
 * 
 * @author Charles Wang and Victor Huang
 * @version June 2017
 */
public class continueButton extends Actor
{
    /**
     * Act - do whatever the continueButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        //sets the level depending on the level last played
        if (Greenfoot.mouseClicked(this)){
            if(ZeeWeeld.level == 1){
                Greenfoot.setWorld(new levelOne());
            }else if (ZeeWeeld.level == 2){
                Greenfoot.setWorld(new levelTwo());
            }else if (ZeeWeeld.level == 3){
                Greenfoot.setWorld(new levelThree());
            }else if (ZeeWeeld.level == 4){
                Greenfoot.setWorld(new levelFour());
            }else if (ZeeWeeld.level == 5){
                Greenfoot.setWorld(new levelFive());
            }else if (ZeeWeeld.level == 6){
                Greenfoot.setWorld(new levelSix());
            }
        }
    }    
}
