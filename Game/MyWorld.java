import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Main world for Raft Battles
 * 
 * @author Charles Wang
 * @version June 2017
 */
public class MyWorld extends World
{

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
        blueBlock blueblock1 = new blueBlock();
        addObject(blueblock1,15,525);

        blueBlock blueblock2 = new blueBlock();
        addObject(blueblock2,45,525);

        blueBlock blueblock3 = new blueBlock();
        addObject(blueblock3,75,525);

        blueBlock blueblock4 = new blueBlock();
        addObject(blueblock4,105,525);

        blueBlock blueblock5 = new blueBlock();
        addObject(blueblock5,135,525);

        blueBlock blueblock6 = new blueBlock();
        addObject(blueblock6,165,525);

        blueBlock blueblock7 = new blueBlock();
        addObject(blueblock7,195,525);

        blueBlock blueblock8 = new blueBlock();
        addObject(blueblock8,225,525);

        blueBlock blueblock9 = new blueBlock();
        addObject(blueblock9,255,525);

        blueBlock blueblock10 = new blueBlock();
        addObject(blueblock10,285,525);

        blueBlock blueblock11 = new blueBlock();
        addObject(blueblock11,315,525);

        blueBlock blueblock12 = new blueBlock();
        addObject(blueblock12,345,525);

        blueBlock blueblock13 = new blueBlock();
        addObject(blueblock13,375,525);

        blueBlock blueblock14 = new blueBlock();
        addObject(blueblock14,405,525);

        blueBlock blueblock15 = new blueBlock();
        addObject(blueblock15,435,525);

        blueBlock blueblock16 = new blueBlock();
        addObject(blueblock16,465,525);

        blueBlock blueblock17 = new blueBlock();
        addObject(blueblock17,495,525);

        blueBlock blueblock18 = new blueBlock();
        addObject(blueblock18,525,525);

        blueBlock blueblock19 = new blueBlock();
        addObject(blueblock19,555,525);

        blueBlock blueblock20 = new blueBlock();
        addObject(blueblock20,585,525);

        blueBlock blueblock21 = new blueBlock();
        addObject(blueblock21,615,525);

        blueBlock blueblock22 = new blueBlock();
        addObject(blueblock22,645,525);

        blueBlock blueblock23 = new blueBlock();
        addObject(blueblock23,675,525);

        blueBlock blueblock24 = new blueBlock();
        addObject(blueblock24,705,525);

        blueBlock blueblock25 = new blueBlock();
        addObject(blueblock25,735,525);

        blueBlock blueblock26 = new blueBlock();
        addObject(blueblock26,765,525);

        blueBlock blueblock27 = new blueBlock();
        addObject(blueblock27,795,525);

        blueBlock blueblock28 = new blueBlock();
        addObject(blueblock28,825,525);

        blueBlock blueblock29 = new blueBlock();
        addObject(blueblock29,705,495);

        blueBlock2 blueblock31 = new blueBlock2();
        addObject(blueblock31,705,495);

        blueBlock2 blueblock32 = new blueBlock2();
        addObject(blueblock32,645,495);

        blueBlock blueblock33 = new blueBlock();
        addObject(blueblock33,645,495);

        startPipe pipe1 = new startPipe();
        addObject(pipe1,135,135);

        endPipe pipe2 = new endPipe();
        addObject(pipe2,795,405);

        botSpike spike1 = new botSpike();
        addObject(spike1,135,435);

        botSpike spike2 = new botSpike();
        addObject(spike2,165,435);

        botSpike spike3 = new botSpike();
        addObject(spike3,195,435);

        botSpike spike4 = new botSpike();
        addObject(spike4,225,435);

        doorUnlock button = new doorUnlock();
        addObject(button,435,195);

        door door = new door();
        addObject(door,735,390);

        main main = new main();
        addObject(main,409,210);
        main.setLocation(360,231);

        blueBlock blueblock34 = new blueBlock();
        addObject(blueblock34,477,300);
        
        blueBlock2 blueblock35 = new blueBlock2();
        addObject(blueblock35,477,300);
    }
}
