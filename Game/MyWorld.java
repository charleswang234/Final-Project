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
        //line 1: up down hitbox

        blueBlock blueblock1 = new blueBlock();
        addObject(blueblock1,15,465);

        blueBlock blueblock2 = new blueBlock();
        addObject(blueblock2,45,465);

        blueBlock blueblock3 = new blueBlock();
        addObject(blueblock3,75,465);

        blueBlock blueblock4 = new blueBlock();
        addObject(blueblock4,105,465);

        blueBlock blueblock5 = new blueBlock();
        addObject(blueblock5,135,465);

        blueBlock blueblock6 = new blueBlock();
        addObject(blueblock6,165,465);

        blueBlock blueblock7 = new blueBlock();
        addObject(blueblock7,195,465);

        blueBlock blueblock8 = new blueBlock();
        addObject(blueblock8,225,465);

        blueBlock blueblock9 = new blueBlock();
        addObject(blueblock9,255,465);

        blueBlock blueblock10 = new blueBlock();
        addObject(blueblock10,285,465);

        blueBlock blueblock11 = new blueBlock();
        addObject(blueblock11,315,465);

        blueBlock blueblock12 = new blueBlock();
        addObject(blueblock12,345,465);

        blueBlock blueblock13 = new blueBlock();
        addObject(blueblock13,375,465);

        blueBlock blueblock14 = new blueBlock();
        addObject(blueblock14,405,465);

        blueBlock blueblock15 = new blueBlock();
        addObject(blueblock15,435,465);

        blueBlock blueblock16 = new blueBlock();
        addObject(blueblock16,465,465);

        blueBlock blueblock17 = new blueBlock();
        addObject(blueblock17,495,465);

        blueBlock blueblock18 = new blueBlock();
        addObject(blueblock18,525,465);

        blueBlock blueblock19 = new blueBlock();
        addObject(blueblock19,555,465);

        blueBlock blueblock20 = new blueBlock();
        addObject(blueblock20,585,465);

        blueBlock blueblock21 = new blueBlock();
        addObject(blueblock21,615,465);

        blueBlock blueblock22 = new blueBlock();
        addObject(blueblock22,645,465);

        blueBlock blueblock23 = new blueBlock();
        addObject(blueblock23,675,465);

        blueBlock blueblock24 = new blueBlock();
        addObject(blueblock24,705,465);

        blueBlock blueblock25 = new blueBlock();
        addObject(blueblock25,735,465);

        blueBlock blueblock26 = new blueBlock();
        addObject(blueblock26,765,465);

        blueBlock blueblock27 = new blueBlock();
        addObject(blueblock27,795,465);

        blueBlock blueblock28 = new blueBlock();
        addObject(blueblock28,825,465);

        //line 1: left-right hitbox

        //line 2: up-down hitbox
        blueBlock blueblock29 = new blueBlock();
        addObject(blueblock29,15,435);

        blueBlock blueblock30 = new blueBlock();
        addObject(blueblock30,45,435);

        blueBlock blueblock31 = new blueBlock();
        addObject(blueblock31,75,435);

        blueBlock blueblock32 = new blueBlock();
        addObject(blueblock32,645,435);
        
        blueBlock blueblock33 = new blueBlock();
        addObject(blueblock33,675,435);
        
        blueBlock blueblock34 = new blueBlock();
        addObject(blueblock34,705,435);
        
        blueBlock blueblock35 = new blueBlock();
        addObject(blueblock35,735,435);
        
        blueBlock blueblock36 = new blueBlock();
        addObject(blueblock36,765,435);
        
        blueBlock blueblock37 = new blueBlock();
        addObject(blueblock37,795,435);
        
        blueBlock blueblock38 = new blueBlock();
        addObject(blueblock38,825,435);

        
        
        //line 2: left-right hitbox
        
        blueBlock2 blueblockb1 = new blueBlock2();
        addObject(blueblockb1,105,435);

        blueBlock2 blueblockb2 = new blueBlock2();
        addObject(blueblockb2,375,435);

        blueBlock2 blueblockb3 = new blueBlock2();
        addObject(blueblockb3,405,435);

        blueBlock2 blueblockb4 = new blueBlock2();
        addObject(blueblockb4,435,435);

        blueBlock2 blueblockb5 = new blueBlock2();
        addObject(blueblockb5,465,435);

        blueBlock2 blueblockb8 = new blueBlock2();
        addObject(blueblockb8,555,435);

        blueBlock2 blueblockb9 = new blueBlock2();
        addObject(blueblockb9,585,435);

        blueBlock2 blueblockb10 = new blueBlock2();
        addObject(blueblockb10,615,435);


       
        
        
        
        
        
        
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

    }
}
