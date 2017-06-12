import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Level 1 for This is the Only Level Reboot
 * 
 * @author Charles Wang and Victor Huang
 * @version June 2017
 */
public class MyWorld extends ZeeWeeld
{
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
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

        addObject(new buttonPressed(),435,195);
        addObject(unlockDoor,435,195);

        //Other objects
        for (int i = 0; i < miscMap.length;i++){
            for (int j = 0; j < miscMap[i].length;j++){
                if (miscMap[i][j] == 1){
                    addObject(new leftSpike(),j*30 + 15,i*30 + 15);
                }
                else if (miscMap[i][j] == 2){
                    addObject(new botSpike(),j*30 + 15,i*30 + 15);
                }
                else if (miscMap[i][j] == 3){
                    addObject(new rightSpike(),j*30 + 15,i*30 + 15);
                }
                else if (miscMap[i][j] == 4){
                    addObject(new topSpike(),j*30 + 15,i*30 + 15);
                }
                else if (miscMap[i][j] == 5){
                    addObject(new endPipe(),j*30 + 15,i*30 + 15);
                }
                else if (miscMap[i][j] == 7){ 
                    addObject(new main(),135,155);
                }

                else if (miscMap[i][j] == 8){ 
                    addObject(new startPipe(),135,135);
                }

            }
        }
        addObject(door,735,390);
        addObject(gameTime,700,550);

    }

}
