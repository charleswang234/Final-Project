import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.HashMap;
/**
 * Super Class of all of the levels for This is the Only Level Reboot
 * 
 * @author Charles Wang and Victor Huang
 * @version June 2017
 */
public class ZeeWeeld extends World
{
    static int level = 0; //Level of the world
    static int time = 0; //Amount of time played
    static int deaths = 0; //Counts the number of deaths
    Label gameTime = new Label("Time: " + time  /60 + ":" + time%60, 40); //Displays the amount of time played onto the screen using labels
    Label deathCount = new Label("Deaths: " + deaths, 20); //Displays the amount of deaths onto the screen using labels
    door door = new door(); //Creates an instance of door
    doorUnlock unlockDoor = new doorUnlock(); //Creates an instance of doorUnlock

    Timer timeCount = new Timer(); //Creates an instance of Timer

    static HashMap<Integer,String> levelColour = new HashMap<Integer,String>(); //HashMap used to set the colour of the blocks based on the level of the game

    /**
     * Constructor for objects of class ZeeWeeld.
     * 
     */
    public ZeeWeeld(int num)
    {    
        super(840, 600, 1, true); 
        level = num;
        levelInitializer();
    }

    /**These 2D arrays map out the objects in the game. 
     * Values of 1 indicate that there is a hitbox in the spot in the world.
     * The world is laid out on a 28 * 16 grid.
     * The first 2D array maps out the up and down platform/unit collision boxes.
     * The second 2D array maps out the left and right platform/unit collision boxes.
     */
    int [][] upMap = {
            {0,0,0,0,0,0,1,1,1,0,1,1,1,0,0,0,1,1,1,1,0,1,1,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,1,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0},
            {0,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,1,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,1,1,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,0},
            {0,0,0,0,0,0,0,0,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        };
    int [][] leftMap = {
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0,0,0,1,0,0,1,0,0,0,0},
            {0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0},
            {0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,1,0,0},
            {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,1,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0},
            {0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,1,0,0,0,1,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0},
            {0,0,0,1,0,0,0,0,0,0,0,0,0,1,0,1,0,0,0,0,0,0,0,0,1,0,0,0},
            {0,0,0,1,0,0,0,0,0,0,0,0,0,1,0,1,0,0,1,0,1,0,0,0,0,0,0,1},
            {0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,1,0,0,0,0,0,0,1},
            {0,0,0,1,0,0,0,0,0,0,0,0,1,0,0,1,0,0,1,0,0,0,0,0,0,0,0,0},

        };
    int [][] spikeMap = {
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,4,4,4,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,4,4,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,3,0},
            {0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,3,0},
            {0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,3,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,3,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,0,0,0,0,0,0},
            {0,0,0,0,2,2,2,2,0,0,0,0,0,0,0,0,2,2,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        };

    /**
     * Method to set the colour of the block based on the level of the game
     */
    public void levelInitializer(){
        levelColour.put(1,"green block.jpg");
        levelColour.put(2,"blue block.jpg");
        levelColour.put(3,"yellow block.jpg");
        levelColour.put(4,"magenta block.jpg");
        levelColour.put(5,"red block.jpg");
        levelColour.put(6,"cyan block.jpg");
    }
    
    public void prepare(){
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
