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

    int count = 0; //Tracks the number of letters typed so far
    Words words = new Words(); //Creates a words class
    Label currentWord = new Label("",50);//The word to be typed
    Label playerInput = new Label("",50);//Displays what the player is typing
    String key; //Tracks last key pressed
    String word1; //Tracks value of currentWord
    String word2; //Tracks value of playerInput

    Label gameTime = new Label("Time: " + time/60 + ":" + time%60, 40); //Label for the amount of time played
    Label deathCount = new Label("Deaths: " + deaths, 20); //Label for the amount of deaths
    door door = new door(); //Creates an instance of the door class
    doorUnlock unlockDoor = new doorUnlock(); //Creates an instance of the doorUnlock class
    whiteBackground backgroundWhite = new whiteBackground(); //Creates an instance of the whiteBackground class
    Timer timeCount = new Timer(); //Creates an instance of Timer
    main2 character = new main2(); //Creates an instance of the main2 class needed for level 6
    returnMenu menuReturn = new returnMenu(); //Creates an instance of the returnMenu class
    panicButton restart = new panicButton(); //Creates an instance of the panic button used to restart the level
    toggleSound musicOnOff = new toggleSound(); //Creates an instance of the music on/off button 

    static HashMap<Integer,String> levelColour = new HashMap<Integer,String>(); //HashMap used to set the colour of the blocks based on the level of the game

    static boolean trollingTrue = false; //Boolean to check if trolling class is pressed, to pass level 5
    static boolean gameWin = false; //Boolean to check if player won the game and was brought to the winScreen

    static GreenfootSound music = new GreenfootSound("Snare Bounce Polka.wav"); //Music for the game

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
     * The third 2D array maps out all the spikes on the map.
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
        levelColour.put(7,"green block.jpg");
        levelColour.put(8,"blue block.jpg");
        levelColour.put(9,"yellow block.jpg");
    }

    public void prepare(){        
        addObject(timeCount,135,135); //sets the timer to be behind other objects so it is not seen

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

        addObject(new buttonPressed(),435,195); //what the button looks like after it is pressed by the character
        addObject(unlockDoor,435,195); //Unpressed button 

        if (!(level == 9)){
            addObject(door,735,390); //Adds the door 
        }

        if (level == 4){
            addObject(backgroundWhite,420,240); //Adds a white background if level 4
        }
        if(level == 6){
            addObject(character,135,255); //Adds an unmovable character if level 6
            addObject(words,135,135); //Adds words greenfoot image
            addObject(currentWord,420,90); //Adds the current word onto the screen
            addObject(playerInput,420,270); //Adds the player's input onto the screen
            words.randomWords(); //Queuing up all the words that the player will type
            currentWord.setValue(words.wordQueue.dequeue()); //Taking the first word from the queue
        }
        else{
            addObject(new main(),135,155); //Adds a movable character onto the screen for other levels
        }

        addObject(new startPipe(),135,135); //Adds the start pipe onto the screen
        addObject(new endPipe(),795,405); //Adds the end pipe onto the screen
        addObject(gameTime,700,525); //Adds the game time onto the screen
        addObject(deathCount,700,550); //Adds the death count onto the screen

        addObject(menuReturn,90, 585); //Adds the return menu button onto the screen
        addObject(restart,240, 585); //Adds the panic button onto the screen
        addObject(musicOnOff,390, 585); //Adds the music on/off button onto the screen

        //Sets the inital time
        if(ZeeWeeld.time/60 < 10){ //Checks if time is less than 10 minutes
            if(ZeeWeeld.time%60 < 10){ //Checks if there are less than 10 seconds in the current minute
                gameTime.setValue("Time: 0" + ZeeWeeld.time/60 + ":0" + ZeeWeeld.time%60);
            }
            else{
                gameTime.setValue("Time: 0" + ZeeWeeld.time/60 + ":" + ZeeWeeld.time%60);
            }
        }
        else{
            if(ZeeWeeld.time%60 < 10){ //Checks if there are less than 10 seconds in the current minute
                gameTime.setValue("Time: " + ZeeWeeld.time/60 + ":0" + ZeeWeeld.time%60);
            }
            else{
                gameTime.setValue("Time: " + ZeeWeeld.time/60 + ":" + ZeeWeeld.time%60); 
            }
        }
    }
}