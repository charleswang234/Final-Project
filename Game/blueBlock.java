import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class blueBlock here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class blueBlock extends Actor
{
    public blueBlock(){
        if (((ZeeWeeld)getWorld()).level == 1){
            setImage ("green block.jpg");
        }
    }
}
