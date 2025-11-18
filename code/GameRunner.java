/**
 * Class which runs the game Fellowship of Code
 *
 * @author Mark Osborne
 * @version ver1.0.0
 */

public class GameRunner
{
    final private static int MAX_FELLOWSHIP_SIZE = 4;
    final private static String GAME_WELCOME = "Welcome Adventurer!";
    final private static String GAME_NAME =
        "\n\np       |--------~~~~~~~~=======ooooOoooo=======~~~~~~~~--------\\\n"+
        "|>======| Fellowship of Code - A Java Adventure in Middle Earth  >\n"+
        "b       |--------~~~~~~~~=======ooooOoooo=======~~~~~~~~--------/";
    final private static String GAME_LOCATION = "labyrinth in Middle Earth";
    final private static String GAME_DESCRIPTION =
        "A group of creatures - known as the Fellowship - must\n"+
        "traverse a labyrinth in Middle Earth in order to deliver a secret\n"+
        "code stored on a floppy disk to a Java Wizard on Mount Api.\n\n"+
        "The group must protect the secret code from being stolen by any\n"+
        "evil creatures they encounter on their way.\n\n"+
        "If the secret code is stolen, the Fellowship must retrieve the\n"+
        "floppy disk in order to give it to the Java Wizard.";
    final private static String GAME_INSTRUCTIONS =
        "During the game, you will be asked to make decisions by selecting\n"+
        "an option from a list.\n\n"+
        "Make your choices by entering the number of the option and\n"+
        "pressing ENTER.\n\n"+
        "At the start of the game you will be prompted to enter the \n"+
        "size of the Fellowship group (1-4) and the names of your adventurers.\n"+
        "Enter their names and press ENTER when prompted.";


    private GameInteraction gameInteraction;
    private GameParts gameParts;

    /**
     * Default constructor which creates the object of the class GameRunner.
     *
     */
    public GameRunner()
    {
        gameParts = new GameParts();
        gameInteraction = new TextDisplay();
    }

    /**
     * Method to run the action when the Fellowship is in a cave.
     *
     */
    public void caveAction()
    {
        gameParts.incrementGameMoves();
        if (gameParts.isFellowshipAtMountApi())
        {
            if (gameParts.fellowshipHasFloppyDisk())
            {
                gameParts.giveFloppyDiskToWizard();
                fellowshipSucceeded();
            }
            else
            {
                gameInteraction.promptToContinue("The Fellowship arrived at Mount Api without the Floppy Disk!\n"+
                    "They need to retrieve it from " + gameParts.getDiskHolderFullName() + 
                    " who is in the " + gameParts.getDiskHolderLocation());
               
                gameInteraction.displayOutput(gameParts.moveToLastLocation());

            }
        }
        if (!gameParts.isFellowshipAtMountApi())
        {
            gameInteraction.displayOutput("The Fellowship is now at " +
                gameParts.getCurrentFellowshipLocationName());
            if (gameParts.currentCaveHasNoEnemyCreature())
            {
                gameInteraction.displayOutput("\nRolling to create enemy creature.");
                gameInteraction.displayOutput(gameParts.rollToCreateEnemyCreature());
            }
        
            if (gameParts.currentCaveHasAliveEnemyCreature())
            {
                fightEnemyCreature();
            }
            else
                gameInteraction.displayOutput(gameParts.healFellowship());
        }
    }

    /**
     * Method to let the user create a new Fellowship
     */
    public void createFellowship()
    {
        int numCreatures = gameInteraction.promptPickANumber
            ("How many creatures will be in the Fellowship?",
            MAX_FELLOWSHIP_SIZE);
        gameInteraction.displayOutput("The leader of the group will be a "+
        GameConstants.TYPE_HOBBIT);
        boolean uniqueName = false;
        String hobbitName = "";
        do
        {
            hobbitName = gameInteraction.promptName();
            if (hobbitName.isEmpty()) 
            {
                hobbitName = Namer.getNewCreatureName(GameConstants.TYPE_HOBBIT);
                gameInteraction.displayOutput("No name entered. His name will be " + hobbitName +".\n");
            }
            if (Namer.checkNameUsed(hobbitName))
                gameInteraction.displayOutput("Name has been used. Please choose another.");
            else    
                uniqueName = true;
        } while (!uniqueName);
        gameParts.addFellowshipCreature(hobbitName,GameConstants.TYPE_HOBBIT);

        for (int index = 2; index <= numCreatures; index++)
        {
            String creatureType = 
                gameInteraction.promptSelectItemName(
                "What type will the next creature be?",new String[] 
                    {GameConstants.TYPE_ELF, GameConstants.TYPE_DWARF});
            uniqueName = false;    
            String creatureName = "";
            do
            {
                creatureName =  gameInteraction.promptName();
    
                if (creatureName.isEmpty()) 
                {
                    creatureName = Namer.getNewCreatureName(creatureType);
                    gameInteraction.displayOutput("No name entered. His name will be " +
                        creatureName + ".\n");
                }
                if (Namer.checkNameUsed(creatureName))
                    gameInteraction.displayOutput("Name has been used. Please choose another.");
                else    
                    uniqueName = true;
            } while (!uniqueName);
            gameParts.addFellowshipCreature(creatureName, creatureType);
        }
        gameInteraction.promptToContinue("");
    }

    /**
     * Method to display the welcome and the instructions.
     */
    private void displayWelcomeAndInstructions()
    {
        String welcomeAndInstructions =
            GAME_NAME+"\n\n"+
            GAME_WELCOME+"\n\n"+
            GAME_DESCRIPTION+"\n\n"+
            GAME_INSTRUCTIONS+"\n\n";
        gameInteraction.promptToContinue(welcomeAndInstructions);
    }

    /**
     * Method to end the game with associated summaries and file saving.
     */
    private void endGame()
    {
        FileOperations fileOperations = new FileOperations();

        String finalSummary = gameParts.getFinalSummary();
        gameInteraction.displayOutput(finalSummary);
        fileOperations.saveToFile(GameConstants.SUMMARY_FILE_NAME,finalSummary);

        gameInteraction.displayOutput("\nGame Over");
    }

    /**
     * Method to display that the Fellowship succeeded in their quest.
     */
    private void fellowshipSucceeded()
    {
        String intro = "They did it! They reached Mount Api with the disk with\n" +
            "the code on it and handed it to the Java Wizard. Middle Earth is Saved!\n";
            gameInteraction.displayOutput(intro);
    }

    /**
     * Method for an enemy creature to fight a Fellowship creature.
     */
    private void fightEnemyCreature()
    {
        // X will fight you
        String thisFight = gameParts.displayFighter();
        gameInteraction.displayOutput(thisFight);
        
        // choose fighter
        String fighterFullName = "";
        if (gameParts.getAliveFellowshipCreatureNames().size() == 1)
        {
            fighterFullName = gameParts.getAliveFellowshipCreatureNames().get(0);
            gameInteraction.displayOutput("Only " +
                fighterFullName + " is available to fight.");;
        }
        else
        {
            fighterFullName = gameInteraction.promptSelectItemName(
                "Select a fighter:",gameParts.getMenuOptionsAliveFellowship());
        }
        
        // offer special weapon
        boolean useSpecialWeapon = false;
        boolean offerSpecialWeapon = gameParts.hasSpecialWeapon(fighterFullName);
        if (offerSpecialWeapon)
        {
            useSpecialWeapon = gameInteraction.promptYesNo(
                "Use special weapon?");
            if (useSpecialWeapon)
                gameParts.removeSpecialWeapon(fighterFullName);

        }
        String outcome = gameParts.fightEnemyCreature(fighterFullName, 
            useSpecialWeapon);
        gameInteraction.promptToContinue(outcome);
    }

    /**
     * Method to more the Fellowship to another cave.
     */
    private void moveFellowship()
    {
        // display exits
        String nextLocationName = gameInteraction.promptSelectItemName(
            "Where would the Fellowship like to move?",gameParts.getAvailableExitsAsMenuOptions());
        gameInteraction.displayOutput( gameParts.moveFellowshipToLocation(nextLocationName));
    }

    /**
     * Method to run the whole game.
     */
    public void runGame()
    {   
        displayWelcomeAndInstructions();
        gameInteraction.displayOutput("LET'S PLAY!");
        createFellowship();
        gameParts.giveFloppyDiskToHobbit();
        gameInteraction.displayOutput(gameParts.putFellowshipInFirstCave());
        gameInteraction.displayOutput(gameParts.displayAliveFellowshipCreatures());
        caveAction();
        while (gameParts.fellowshipAlive() && !gameParts.checkGameWon())
        {
            moveFellowship();
            caveAction();
        }
        endGame();
    }

}
