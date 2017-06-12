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
        else if (((ZeeWeeld)getWorld()).level == 2){
            setImage ("blue block.jpg");
        }
        else if (((ZeeWeeld)getWorld()).level == 3){
            setImage ("yellow block.jpg");
        }
        else if (((ZeeWeeld)getWorld()).level == 4){
            setImage ("magenta block.jpg");
        }
        else if (((ZeeWeeld)getWorld()).level == 5){
            setImage ("red block.jpg");
        }
        else if (((ZeeWeeld)getWorld()).level == 6){
            setImage ("cyan block.jpg");
        }
    }
}
