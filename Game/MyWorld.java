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
        addObject(blueblock1,15,415);

        blueBlock blueblock2 = new blueBlock();
        addObject(blueblock2,45,415);

        blueBlock blueblock3 = new blueBlock();
        addObject(blueblock3,75,415);

        blueBlock blueblock4 = new blueBlock();
        addObject(blueblock4,105,415);

        blueBlock blueblock5 = new blueBlock();
        addObject(blueblock5,135,415);

        blueBlock blueblock6 = new blueBlock();
        addObject(blueblock6,165,415);

        blueBlock blueblock7 = new blueBlock();
        addObject(blueblock7,195,415);

        blueBlock blueblock8 = new blueBlock();
        addObject(blueblock8,225,415);

        blueBlock blueblock9 = new blueBlock();
        addObject(blueblock9,255,415);

        blueBlock blueblock10 = new blueBlock();
        addObject(blueblock10,285,415);

        blueBlock blueblock11 = new blueBlock();
        addObject(blueblock11,315,415);

        blueBlock blueblock12 = new blueBlock();
        addObject(blueblock12,345,415);

        blueBlock blueblock13 = new blueBlock();
        addObject(blueblock13,375,415);

        blueBlock blueblock14 = new blueBlock();
        addObject(blueblock14,405,415);

        blueBlock blueblock15 = new blueBlock();
        addObject(blueblock15,435,415);

        blueBlock blueblock16 = new blueBlock();
        addObject(blueblock16,465,415);

        blueBlock blueblock17 = new blueBlock();
        addObject(blueblock17,495,415);

        blueBlock blueblock18 = new blueBlock();
        addObject(blueblock18,525,415);

        blueBlock blueblock19 = new blueBlock();
        addObject(blueblock19,555,415);

        blueBlock blueblock20 = new blueBlock();
        addObject(blueblock20,585,415);

        blueBlock blueblock21 = new blueBlock();
        addObject(blueblock21,615,415);

        blueBlock blueblock22 = new blueBlock();
        addObject(blueblock22,645,415);

        blueBlock blueblock23 = new blueBlock();
        addObject(blueblock23,675,415);

        blueBlock blueblock24 = new blueBlock();
        addObject(blueblock24,705,415);

        blueBlock blueblock25 = new blueBlock();
        addObject(blueblock25,735,415);

        blueBlock blueblock26 = new blueBlock();
        addObject(blueblock26,765,415);

        blueBlock blueblock27 = new blueBlock();
        addObject(blueblock27,795,415);

        blueBlock blueblock28 = new blueBlock();
        addObject(blueblock28,825,415);

        main main = new main();
        addObject(main,409,210);
        main.setLocation(360,231);

        main main2 = new main();
        addObject(main2,494,253);
        main main3 = new main();
        addObject(main3,642,194);
        main main4 = new main();
        addObject(main4,683,244);
        main main5 = new main();
        addObject(main5,302,187);
        main main6 = new main();
        addObject(main6,172,261);
        blueBlock blueblock29 = new blueBlock();
        addObject(blueblock29,581,393);
        blueblock29.setLocation(585,385);
    }
}
