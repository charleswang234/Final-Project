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
        addObject(blueblock1,15,405);

        blueBlock blueblock2 = new blueBlock();
        addObject(blueblock2,45,405);

        blueBlock blueblock3 = new blueBlock();
        addObject(blueblock3,75,405);

        blueBlock blueblock4 = new blueBlock();
        addObject(blueblock4,105,405);

        blueBlock blueblock5 = new blueBlock();
        addObject(blueblock5,135,405);

        blueBlock blueblock6 = new blueBlock();
        addObject(blueblock6,165,405);

        blueBlock blueblock7 = new blueBlock();
        addObject(blueblock7,195,405);

        blueBlock blueblock8 = new blueBlock();
        addObject(blueblock8,225,405);

        blueBlock blueblock9 = new blueBlock();
        addObject(blueblock9,255,405);

        blueBlock blueblock10 = new blueBlock();
        addObject(blueblock10,285,405);

        blueBlock blueblock11 = new blueBlock();
        addObject(blueblock11,315,405);

        blueBlock blueblock12 = new blueBlock();
        addObject(blueblock12,345,405);

        blueBlock blueblock13 = new blueBlock();
        addObject(blueblock13,375,405);

        blueBlock blueblock14 = new blueBlock();
        addObject(blueblock14,405,405);

        blueBlock blueblock15 = new blueBlock();
        addObject(blueblock15,435,405);

        blueBlock blueblock16 = new blueBlock();
        addObject(blueblock16,465,405);

        blueBlock blueblock17 = new blueBlock();
        addObject(blueblock17,495,405);

        blueBlock blueblock18 = new blueBlock();
        addObject(blueblock18,525,405);

        blueBlock blueblock19 = new blueBlock();
        addObject(blueblock19,555,405);

        blueBlock blueblock20 = new blueBlock();
        addObject(blueblock20,585,405);

        blueBlock blueblock21 = new blueBlock();
        addObject(blueblock21,615,405);

        blueBlock blueblock22 = new blueBlock();
        addObject(blueblock22,645,405);

        blueBlock blueblock23 = new blueBlock();
        addObject(blueblock23,675,405);

        blueBlock blueblock24 = new blueBlock();
        addObject(blueblock24,705,405);

        blueBlock blueblock25 = new blueBlock();
        addObject(blueblock25,735,405);

        blueBlock blueblock26 = new blueBlock();
        addObject(blueblock26,765,405);

        blueBlock blueblock27 = new blueBlock();
        addObject(blueblock27,795,405);

        blueBlock blueblock28 = new blueBlock();
        addObject(blueblock28,825,405);

        main main = new main();
        addObject(main,409,210);
        main.setLocation(360,231);

        blueBlock blueblock29 = new blueBlock();
        addObject(blueblock29,705,375);
        blueBlock2 blueblock31 = new blueBlock2();
        addObject(blueblock31,705,375);
        blueBlock blueblock30 = new blueBlock();
        addObject(blueblock30,75,375);
    }
}
