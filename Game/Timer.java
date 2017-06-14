import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Object that times the amount of time played
 * 
 * @author Charles Wang and Victor Huang
 * @version June 2017
 */
public class Timer extends Actor
{
    private int count = 0; //Counts the number of 1/60 seconds
    /**
     * Act - do whatever the Timer wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        count++; //Adds one every time act is gone through
        if (count == 60){ //FPS is 60 for act
            ZeeWeeld.time += 1; //Increases the time by one second
            count = 0; //Resets the count
            
            //Displays the time played
            //Puts 0's before the minutes and seconds if there are less than 10 minutes 
            //and/or when there is less than 10 seconds in the current minute
            if(ZeeWeeld.time/60 < 10){ //Checks if time is less than 10 minutes
                if(ZeeWeeld.time%60 < 10){ //Checks if there are less than 10 seconds in the current minute
                    ((ZeeWeeld)getWorld()).gameTime.setValue("Time: 0" + ZeeWeeld.time/60 + ":0" + ZeeWeeld.time%60);
                }
                else{
                    ((ZeeWeeld)getWorld()).gameTime.setValue("Time: 0" + ZeeWeeld.time/60 + ":" + ZeeWeeld.time%60);
                }
            }
            else{
                if(ZeeWeeld.time%60 < 10){ //Checks if there are less than 10 seconds in the current minute
                    ((ZeeWeeld)getWorld()).gameTime.setValue("Time: " + ZeeWeeld.time/60 + ":0" + ZeeWeeld.time%60);
                }
                else{
                    ((ZeeWeeld)getWorld()).gameTime.setValue("Time: " + ZeeWeeld.time/60 + ":" + ZeeWeeld.time%60); 
                }
            }
        }
    }    
}
