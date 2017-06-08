import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Main world for Raft Battles
 * 
 * @author Charles Wang
 * @version June 2017
 */
public class MyWorld extends World
{
    int [][] upMap = {
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
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
        //line 1: up down hitbox

        blueBlock upOne9 = new blueBlock();
        addObject(upOne9,255,465);

        blueBlock upOne10 = new blueBlock();
        addObject(upOne10,285,465);

        blueBlock upOne11 = new blueBlock();
        addObject(upOne11,315,465);

        blueBlock upOne12 = new blueBlock();
        addObject(upOne12,345,465);

        //line 2: up-down hitbox

        blueBlock upTwo22 = new blueBlock();
        addObject(upTwo22,645,435);

        blueBlock upTwo23 = new blueBlock();
        addObject(upTwo23,675,435);

        blueBlock upTwo24 = new blueBlock();
        addObject(upTwo24,705,435);

        blueBlock upTwo25 = new blueBlock();
        addObject(upTwo25,735,435);

        blueBlock upTwo26 = new blueBlock();
        addObject(upTwo26,765,435);
        
        blueBlock upTwo27 = new blueBlock();
        addObject(upTwo27,795,435);
        
        //line 2: left-right hitbox

        blueBlock2 leftTwo13 = new blueBlock2();
        addObject(leftTwo13,375,435);
        
        //To Be Sorted
        startPipe pipe1 = new startPipe();
        addObject(pipe1,135,135);

        endPipe pipe2 = new endPipe();
        addObject(pipe2,795,405);

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
        
        leftSpike lSpike1 = new leftSpike();
        addObject(lSpike1,45,195);
        
        leftSpike lSpike2 = new leftSpike();
        addObject(lSpike2,45,225);
        
        leftSpike lSpike3 = new leftSpike();
        addObject(lSpike3,45,255);
        
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
        
        doorUnlock button = new doorUnlock();
        addObject(button,435,195);

        door door = new door();
        addObject(door,735,390);

        main main = new main();
        addObject(main,409,210);
        main.setLocation(360,231);
    }
}
