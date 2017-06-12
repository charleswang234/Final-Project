import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Main world for Only Level Reboot
 * 
 * @author Charles Wang and Victor Huang
 * @version June 2017
 */
public class MyWorld extends World
{
    
        door door = new door();
    /**These 2D arrays map out the platforms in the game. 
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
            {0,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0},
            {0,0,0,0,1,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,1,1,1,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,0},
            {0,0,0,0,0,0,0,0,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
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
            {0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0},
            {0,0,0,0,1,0,0,0,1,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0},
            {0,0,0,1,0,0,0,0,0,0,0,0,0,1,0,1,0,0,0,0,0,0,0,0,1,0,0,0},
            {0,0,0,1,0,0,0,0,0,0,0,0,0,1,0,1,0,0,1,0,0,0,0,0,0,0,0,1},
            {0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,1,0,0,1,0,1,0,0,0,0,0,0,1},
            {0,0,0,1,0,0,0,0,0,0,0,0,1,0,0,1,0,0,1,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        };

    int [][] miscMap = {

            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,4,4,4,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,4,4,0,0,0},
            {0,0,0,0,6,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,1,0,0,0,0,0,0,0,0,0,0,0,0,7,0,0,0,0,0,0,0,0,0,0,0,3,0},
            {0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,3,0},
            {0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,3,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,3,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,0,0,0,0,5,0},
            {0,0,0,0,2,2,2,2,0,0,0,0,0,0,0,0,2,2,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        };
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(840, 600, 1, true); 
        prepare();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
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
                else if (miscMap[i][j] == 6){
                    addObject(new startPipe(),j*30 + 15,i*30 + 15);
                }
                else if (miscMap[i][j] == 7){
                    addObject(new doorUnlock(),j*30 + 15,i*30 + 15);
                }
            }
        }

        //Spikes        
        botSpike bSpikeTwo5 = new botSpike();
        addObject(bSpikeTwo5,135,435);

        botSpike bSpikeTwo6 = new botSpike();
        addObject(bSpikeTwo6,165,435);

        botSpike bSpikeTwo7 = new botSpike();
        addObject(bSpikeTwo7,195,435);

        botSpike bSpikeTwo8 = new botSpike();
        addObject(bSpikeTwo8,225,435);

        botSpike bSpikeTwo17 = new botSpike();
        addObject(bSpikeTwo17,495,435);

        botSpike bSpikeTwo18 = new botSpike();
        addObject(bSpikeTwo18,525,435);

        botSpike bSpikeThree22 = new botSpike();
        addObject(bSpikeThree22,645,405);

        leftSpike lSpikeEight1 = new leftSpike();
        addObject(lSpikeEight1,45,195);

        leftSpike lSpikeNine1 = new leftSpike();
        addObject(lSpikeNine1,45,225);

        leftSpike lSpikeTen1 = new leftSpike();
        addObject(lSpikeTen1,45,255);

        rightSpike rSpikeSeven27 = new rightSpike();
        addObject(rSpikeSeven27,795,285);

        rightSpike rSpikeEight27 = new rightSpike();
        addObject(rSpikeEight27,795,255);

        rightSpike rSpikeNine27 = new rightSpike();
        addObject(rSpikeNine27,795,225);

        rightSpike rSpikeTen27 = new rightSpike();
        addObject(rSpikeTen27,795,195);

        topSpike tSpikeFifteen14 = new topSpike();
        addObject(tSpikeFifteen14,405,45);

        topSpike tSpikeFifteen15 = new topSpike();
        addObject(tSpikeFifteen15,435,45);

        topSpike tSpikeFifteen16 = new topSpike();
        addObject(tSpikeFifteen16,465,45);

        topSpike tSpikeThirteen24 = new topSpike();
        addObject(tSpikeThirteen24,705,105);

        topSpike tSpikeThirteen25 = new topSpike();
        addObject(tSpikeThirteen25,735,105);

        //Door and door controls        
        doorUnlock button = new doorUnlock();
        addObject(button,435,195);

        addObject(door,735,390);

        //Character
        main main = new main();
        addObject(main,409,210);
        main.setLocation(360,231);

        //Pipes        
        startPipe pipe1 = new startPipe();
        addObject(pipe1,135,135);

        endPipe pipe2 = new endPipe();
        addObject(pipe2,795,405);
    }



}
