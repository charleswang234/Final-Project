import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Allows the sound to be turned on and off
 * 
 * @author Charles Wang and Victor Huang
 * @version June 2017
 */
public class toggleSound extends Actor
{
    /**
     * Act - do whatever the toggleSound wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (Greenfoot.mouseClicked(this)){
            if (ZeeWeeld.music.isPlaying()){ //Checks if music is playing
                ZeeWeeld.music.pause(); //pauses the music
            }
            else{
                ZeeWeeld.music.playLoop(); //resumes the music
            }
        }    
    }
}
