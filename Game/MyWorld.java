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
        super(840, 600, 1, false); 

        prepare();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {

        blueBlock blueblock1 = new blueBlock();
        addObject(blueblock1,15,15);

        blueBlock blueblock2 = new blueBlock();
        addObject(blueblock2,45,15);

        blueBlock blueblock3 = new blueBlock();
        addObject(blueblock3,75,15);

        blueBlock blueblock4 = new blueBlock();
        addObject(blueblock4,105,15);

        blueBlock blueblock5 = new blueBlock();
        addObject(blueblock5,135,15);

        blueBlock blueblock6 = new blueBlock();
        addObject(blueblock6,165,15);

        blueBlock blueblock7 = new blueBlock();
        addObject(blueblock7,195,15);

        blueBlock blueblock8 = new blueBlock();
        addObject(blueblock8,225,15);

        blueBlock blueblock9 = new blueBlock();
        addObject(blueblock9,255,15);

        blueBlock blueblock10 = new blueBlock();
        addObject(blueblock10,285,15);

        blueBlock blueblock11 = new blueBlock();
        addObject(blueblock11,315,15);

        blueBlock blueblock12 = new blueBlock();
        addObject(blueblock12,345,15);

        blueBlock blueblock13 = new blueBlock();
        addObject(blueblock13,375,15);

        blueBlock blueblock14 = new blueBlock();
        addObject(blueblock14,405,15);

        blueBlock blueblock15 = new blueBlock();
        addObject(blueblock15,435,15);

        blueBlock blueblock16 = new blueBlock();
        addObject(blueblock16,465,15);

        blueBlock blueblock17 = new blueBlock();
        addObject(blueblock17,495,15);

        blueBlock blueblock18 = new blueBlock();
        addObject(blueblock18,525,15);

        blueBlock blueblock19 = new blueBlock();
        addObject(blueblock19,555,15);

        blueBlock blueblock20 = new blueBlock();
        addObject(blueblock20,585,15);

        blueBlock blueblock21 = new blueBlock();
        addObject(blueblock21,615,15);

        blueBlock blueblock22 = new blueBlock();
        addObject(blueblock22,645,15);

        blueBlock blueblock23 = new blueBlock();
        addObject(blueblock23,675,15);

        blueBlock blueblock24 = new blueBlock();
        addObject(blueblock24,705,15);

        blueBlock blueblock25 = new blueBlock();
        addObject(blueblock25,735,15);

        blueBlock blueblock26 = new blueBlock();
        addObject(blueblock26,765,15);

        blueBlock blueblock27 = new blueBlock();
        addObject(blueblock27,795,15);

        blueBlock blueblock28 = new blueBlock();
        addObject(blueblock28,825,15);

        main main = new main();
        addObject(main,409,210);
        main.setLocation(360,231);

        blueBlock blueblock29 = new blueBlock();
        addObject(blueblock29,500,230);
        blueBlock blueblock30 = new blueBlock();
        addObject(blueblock30,245,231);
        blueBlock blueblock31 = new blueBlock();
        addObject(blueblock31,362,578);
    }
}
