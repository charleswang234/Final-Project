import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Level 1 for This is the Only Level Reboot
 * 
 * @author Charles Wang and Victor Huang
 * @version June 2017
 */
public class levelOne extends ZeeWeeld
{
    /**
     * Constructor for objects of class levelOne.
     * 
     */
    public levelOne()
    {    
        super(1); 
        prepare();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        addObject(timeCount,135,135);
        //The up and down hitboxes
        for (int i = 0; i < upMap.length;i++){
            for (int j = 0; j < upMap[i].length;j++){
                if (upMap[i][j] == 1){
                    addObject(new blueBlock(),j*30 + 15,i*30 + 15);
                }
            }
        }

        //The left and right hitboxes
        for (int i = 0; i < leftMap.length;i++){
            for (int j = 0; j < leftMap[i].length;j++){
                if (leftMap[i][j] == 1){
                    addObject(new blueBlock2(),j*30 + 15,i*30 + 15);
                }
            }
        }

        //Spikes
        for (int i = 0; i < spikeMap.length;i++){
            for (int j = 0; j < spikeMap[i].length;j++){
                if (spikeMap[i][j] == 1){
                    addObject(new leftSpike(),j*30 + 15,i*30 + 15);
                }
                else if (spikeMap[i][j] == 2){
                    addObject(new botSpike(),j*30 + 15,i*30 + 15);
                }
                else if (spikeMap[i][j] == 3){
                    addObject(new rightSpike(),j*30 + 15,i*30 + 15);
                }
                else if (spikeMap[i][j] == 4){
                    addObject(new topSpike(),j*30 + 15,i*30 + 15);
                }
            }
        }

        addObject(new buttonPressed(),435,195);
        addObject(unlockDoor,435,195);
        addObject(new main(),135,155);
        addObject(new startPipe(),135,135);
        addObject(new endPipe(),795,405);
        addObject(door,735,390);
        addObject(gameTime,700,550);
    }
}
