import java.util.ArrayList;

/**
 * Class which store the parts of the game and handle the 
 * interaction between them.
 *
 * @author Mark Osborne
 * @version ver1.0.0
 */


public class GameParts
{
    final private static int KILLED_BY_SPECIAL_WEAPON = 100;

    private Fellowship fellowship;
    private Enemies enemies;
    private Labyrinth labyrinth;
    private int gameMoves;
    private FloppyDisk floppyDisk;
    private Wizard wizard;

    /**
     * Default constructor which creates the object of the class GameParts.
     *
     */
    public GameParts()
    {
        fellowship = new Fellowship();
        enemies = new Enemies();
        labyrinth = new Labyrinth();
        gameMoves = 0;
        floppyDisk = new FloppyDisk();
        wizard = new Wizard();
    }

    /**
     * Method to add a new creature to the Fellowship.
     *
     * @param   name    The name of the new creature as a string.
     * @param   type    The type of the new creature as a string.
     */
    public void addFellowshipCreature(String name, String type)
    {
            fellowship.addFellowshipCreature(name,type);
    }

    /**
     * Method to determine if cave contains any alive enemy creature.
     *
     * @param   cave    The location to be checked for an enemy creature 
     *                  as a GameLocation.
     * @return          If the cave contains an alive 
     *                  enemy creature as a boolean.
     */
    public boolean caveHasAliveEnemyCreature(GameLocation cave)
    {   EnemyCreature enemyCreature = enemies.getEnemyCreatureAtLocation(cave);
        if (enemyCreature != EnemyCreature.nobody && enemyCreature.getIsAlive())
            return true;
        else   
            return false;
    }

    /**
     * Method to determine if cave contains any dead enemy creature.
     *
     * @param   cave    The location to be checked for an enemy creature 
     *                  as a GameLocation.
     * @return          If the cave contains a dead 
     *                  enemy creature as a boolean.
     */
    public boolean caveHasDeadEnemyCreature(GameLocation cave)
    {  EnemyCreature enemyCreature = enemies.getEnemyCreatureAtLocation(cave);
        if (enemyCreature != EnemyCreature.nobody && !enemyCreature.getIsAlive())
            return true;
        else   
            return false;
    }

    /**
     * Method to determine if game has been won.
     *
     * @return          If the game has been won as a boolean.
     */
    public boolean checkGameWon()
    {
        // does wizard have the disk
        return floppyDisk.getHeldBy() == wizard;
    }

    /**
     * Method to determine if current cave contains any alive enemy creature.
     *
     * @return          If the current cave contains an alive 
     *                  enemy creature as a boolean.
     */
    public boolean currentCaveHasAliveEnemyCreature()
    {
        return caveHasAliveEnemyCreature(fellowship.getGameLocation());
    }

    /**
     * Method to determine if the current cave contains any dead enemy creature.
     *
     * @return          If the cave contains a dead  
     *                  enemy creature as a boolean.
     */
    public boolean currentCaveHasDeadEnemyCreature()
    {
        return caveHasDeadEnemyCreature(fellowship.getGameLocation());
    }

    /**
     * Method to determine if current cave contains no enemy creature.
     *
     * @return          If the cave contains no enemy creature as a boolean.
     */
    public boolean currentCaveHasNoEnemyCreature()
    {
        return !caveHasAliveEnemyCreature(fellowship.getGameLocation()) && 
            !caveHasDeadEnemyCreature(fellowship.getGameLocation());
    }

    /**
     * Method to return list of alive Fellowship creatures.
     *
     * @return          List of alive Fellowship creatures as a string.
     */
    public String displayAliveFellowshipCreatures()
    {
        return fellowship.displayAliveFellowshipCreatures();
    }

    /**
     * Method to display willing fighter in the current location.
     *
     * @return          Details of willing fighter, if any, as a string.
     */
    public String displayFighter()
    {
        String enemyCreatureFullName = enemies.getEnemyCreatureAtLocation(
            fellowship.getGameLocation()).getFullName();
        if (enemyCreatureFullName != EnemyCreature.nobody.getFullName())
        {
             int enemyCreaturePowerPoints = enemies.getEnemyCreatureAtLocation(
            fellowship.getGameLocation()).getPower();

            return enemyCreatureFullName + " will fight The Fellowship. (" +
                enemyCreaturePowerPoints + " power points)\n";
        }
        return "There is no-one to fight.\n";
    }

    /**
     * Method to determine result of a fight.
     *
     * @param   goodGuy The Fellowship creature as a FellowshipCreature.
     *
     * @param   badGuy The enemy creature as an EnemyCreature.
     *
     * @param   useSpecialWeapon Whether a special weapon is being used
     *          in the fight.
     *
     * @return  The results of the fight as a string.
     *
     */
    private String doFight(FellowshipCreature goodGuy, EnemyCreature badGuy,
        boolean usingSpecialWeapon)
    {
        String result = badGuy.getFullName() + " is fighting " + 
            goodGuy.getFullName() + "\n\n";
        String diskStealResult = "";
        int badGuyWinChance = 0;

        if (badGuy.getPower() >= goodGuy.getPower() + 4)
            badGuyWinChance = 90;
        else
            if (badGuy.getPower() >= goodGuy.getPower() + 3)
                badGuyWinChance = 80;
        else
            if (badGuy.getPower() >= goodGuy.getPower() + 2)
                badGuyWinChance = 70;
        else
            if (badGuy.getPower() >= goodGuy.getPower() + 1)
                badGuyWinChance = 60;
        else
            if (badGuy.getPower() == goodGuy.getPower())
                badGuyWinChance = 50;
        else
            if (badGuy.getPower() <= goodGuy.getPower() - 1)
                badGuyWinChance = 40;
        else
            if (badGuy.getPower() <= goodGuy.getPower() - 2)
                badGuyWinChance = 30;
        else
            if (badGuy.getPower() <= goodGuy.getPower() - 3)
                badGuyWinChance = 20;
        else
            if (badGuy.getPower() <= goodGuy.getPower() - 4)
                badGuyWinChance = 10;

        result += "Rolling a 100-sided die: " + badGuy.getFullName() + " needs " +
            badGuyWinChance + "\n   or under to win (unless a special weapon is used\n"+
            "   in which case they are boned.)\n";
        int fightRoll = 1 + (int)(Math.random() * 100);
        result += "Rolled " + fightRoll +"\n";

        if (usingSpecialWeapon) 
        {
            badGuy.setDamagePoints(goodGuy.getDamagePoints() + 
                KILLED_BY_SPECIAL_WEAPON);
            result += "But " +goodGuy.getFullName() + " destroyed " +
                badGuy.getFullName() + " with their special weapon anyway.\n";
            fellowship.incrementFightsWon();
            diskStealResult = processDiskSteal(goodGuy, badGuy, goodGuy);
        }
        else if (fightRoll > badGuyWinChance)
        {
            result += goodGuy.getFullName() + " won the fight.\n";
            fellowship.incrementFightsWon();
            diskStealResult = processDiskSteal(goodGuy, badGuy, goodGuy);

            goodGuy.setDamagePoints(goodGuy.getDamagePoints()+1);
            badGuy.setDamagePoints(badGuy.getDamagePoints()+4);
        }
        else
        {
            goodGuy.setDamagePoints(goodGuy.getDamagePoints()+4);
            badGuy.setDamagePoints(badGuy.getDamagePoints()+1);
            
            result += badGuy.getFullName() + " won the fight.\n";
            fellowship.incrementFightsLost();
            diskStealResult = processDiskSteal(goodGuy, badGuy, badGuy);
        }
        result += badGuy.getFullName() + " has " + badGuy.getDamagePoints() +
            " damage point" ;
        if (badGuy.getDamagePoints() == 1)
            result += ".\n";
        else
            result += "s.\n";
        result += enemies.checkEnemyCreatureDeath(badGuy);

        result += goodGuy.getFullName() + " has " + 
            goodGuy.getDamagePoints() + " damage point" ;
        if (goodGuy.getDamagePoints() == 1)
            result += ".\n";
        else
            result += "s.\n";
        result += diskStealResult;
        result += fellowship.checkFellowshipDeath(goodGuy);
        // but winner died so give to anyone else in the fellowship
        if (floppyDisk.getHeldBy().getIsAlive() == false)
        {
            if (fellowship.fellowshipAlive())
            {
                result += "However " + floppyDisk.getHeldBy().getFullName() +
                    " died in the fight.\n";
                    floppyDisk.setHeldBy(fellowship.getAliveFellowshipCreatures().get(0));
                result += "So " + floppyDisk.getHeldBy().getFullName() +
                    " took the floppy disk.\n";
            }
        }
        return result;
    }

    /**
     * Method to determine if the Fellowship has any alive creatures.
     *
     * @return          Whether the Fellowship has any alive creatures
     *                  as a boolean.
     */
    public boolean fellowshipAlive()
    {
        return fellowship.fellowshipAlive();
    }

    /**
     * Method to determine if Fellowship holds the floppy disk
     *
     * @return          If the Fellowship holds the floppy disk
     *                  as a boolean.
     */
    public boolean fellowshipHasFloppyDisk()
    {
        for (Creature fellowshipCreature:fellowship.getAliveFellowshipCreatures())
        {
            if (floppyDisk.getHeldBy() == fellowshipCreature)
                return true;
        }
        return false;
    }

    /**
     * Method to execute fight between Fellowship creature and enemy creature
     *  in the same location.
     *
     * @param   fighterFullName The full name of the Fellowship creature as a 
     *                  string.
     * @param   useSpecialWeapon Whether to use a special weapon for this fight
     *                  as a boolean.
     * @return          Result of the fight as a string.
     */
    public String fightEnemyCreature(String fighterFullName, boolean useSpecialWeapon)
    {
        FellowshipCreature fightingFellowshipCreature =
            fellowship.getFellowshipCreatureByFullName(fighterFullName);
        EnemyCreature enemyCreature =
            enemies.getEnemyCreatureAtLocation(fellowship.getGameLocation());
        return doFight(fightingFellowshipCreature, enemyCreature, useSpecialWeapon);
    }

    /**
     * Method to create list of alive Fellowship creatures.
     *
     * @return          List of alive Fellowship creatures as an ArrayList.
     */
    public ArrayList<String> getAliveFellowshipCreatureNames()
    {
        return fellowship.getAliveFellowshipCreatureNames();
    }

    /**
     * Method to create list of the Fellowship's cave exits.
     *
     * @return          List of available exits as string array 
     *                  of menu options.
     */
    public String[] getAvailableExitsAsMenuOptions()
    {
        return labyrinth.getMenuOptionsAvailableExits
            (fellowship.getGameLocation());
    }

    /**
     * Method to display name of Fellowship's current location
     *
     * @return          Fellowship's current location as string.
     */
    public String getCurrentFellowshipLocationName()
    {
        return fellowship.getFellowshipLocationNameWithIdentity();
    }


    /**
     * Method to display current summary of game before moving to next location.
     *
     * @return          Game's current summary as a string.
     */
    public String getCurrentSummary(GameLocation nextGameLocation)
    {
        String summary = "Current Summary...\n\n";

        // visited caves, creature in the Cave, damage points, is holding the code
        summary += "Visited Caves:\n";
        for (GameLocation gameLocation:fellowship.getVisitedCaves())
        {   
            summary += "\t" + gameLocation.getLocationNameWithIdentity() +"\n";
            EnemyCreature enemyCreature = enemies.getEnemyCreatureAtLocation(gameLocation);
            if (enemyCreature == EnemyCreature.nobody)
            {
                summary += "\t\tNo enemy creature is here... YET!\n";
            }
            else 
            {
                summary += "\t\t" + enemyCreature.getFullName() + " is here.\n";
                if (enemyCreature.getIsAlive())
                {
                    summary += "\t\t" + enemyCreature.getFullName() + " is alive with " + 
                        enemyCreature.getDamagePoints() + " damage point";
                    if (enemyCreature.getDamagePoints() == 1)
                        summary += ".\n";
                    else 
                        summary += "\n";
                }
                else
                {
                    summary += "\t\t" + enemyCreature.getFullName() + " is dead.\n";
                }
                if (floppyDisk.getHeldBy() == enemyCreature)
                {
                    summary += "\t\t" + enemyCreature.getFullName() + " has the floppy disk.\n";
                }
            }
            // every location can be accessed, so no test for empty list required
            summary += "\t\tAccess From:\n";
            for (String entry:labyrinth.getAvailableEntries(gameLocation))
            {
                summary += "\t\t\t" + entry + "\n";
            }
            summary += "\t\tExits:\n";
            for (String exit:labyrinth.getAvailableExits(gameLocation))
            {
                summary += "\t\t\t" + exit + "\n";
            }
        }
        // display location
        summary += "\nThe Fellowship is at " + 
            fellowship.getFellowshipLocationNameWithIdentity() + "\n";
        summary += "The Fellowship will be moving to " +
            nextGameLocation.getLocationNameWithIdentity() + " as:\n";
        // display alive fellowship creatures 
        summary += fellowship.displayAliveFellowshipCreatures();
        if (fellowshipHasFloppyDisk())
            summary += "\n\t" + getDiskHolderFullName() +
            " has the floppy disk.\n";
        else
            summary += "\n\t" + getDiskHolderFullName() +
            " has the floppy disk at " + getDiskHolderLocation()  + ".\n";
        return summary;
    }


    /**
     * Method to display full name of creature currently holding the 
     *     floppy disk.
     *
     * @return          Full name of creature currently holding the 
     *     floppy disk as a string.
     */
    public String getDiskHolderFullName()
    {
        return floppyDisk.getHeldBy().getFullName();
    }

    /**
     * Method to display the location of the current floppy disk holder.
     *
     * @return          The location of the current floppy disk holder
     *                  as a string.
     */
    public String getDiskHolderLocation()
    {
        Creature diskHolder = floppyDisk.getHeldBy();
        if (fellowship.isFellowshipCreature(diskHolder))
        {
            return fellowship.getFellowshipLocationNameWithIdentity();
        }
        else
        {
            EnemyCreature enemyCreature = enemies.getEnemyCreatureByFullName(diskHolder.getFullName());
            return enemyCreature.getGameLocation().getLocationNameWithIdentity();
        }
    }

    /**
     * Method to display final summary of the game.
     *
     * @return          Final summary of the game as a string.
     */
    public String getFinalSummary()
    {
        String summary = "Final Summary...\n\n";
        
        // outcome of quest
        if (checkGameWon())
            {
                summary += "The quest succeeded.\n";
                summary +=floppyDisk.getLastHeldBy().getFullName() +
                " gave the floppy disk to the Java Wizard.\n";
            }
        else 
            summary += "The quest failed.\n";

        // number of caves visited
        summary += "The Fellowship visited " +
            fellowship.getVisitedCaves().size() + " unique caves.\n";

        summary += "They did this in " + gameMoves + 
            " moves (counting entering the first cave)\n";

        // number of times code changed hands
        summary += "The floppy disk changed hands " + 
        floppyDisk.getChangedHandsCount() +
            " times, including the Hobbit taking it for the first time.\n";

        // creatures killed
        summary += "These creatures died:\n";
        for (Creature creature: fellowship.getDeadFellowshipCreatures())
        {
            summary += "\t" + creature.getFullName() + "\n";
        }
        for (Creature creature: enemies.getDeadEnemyCreatures())
        {
            summary += "\t" + creature.getFullName() + "\n";
        }
        
        // fellowship fight success rate (fights won * 100 / total fights)
        int successRate = fellowship.getFightsWon() * 100 / 
            (fellowship.getFightsWon() + fellowship.getFightsLost());
        summary += "\nFellowship Success Rate: " + successRate;

        return summary;
    }

    /**
     * Method to display alive Fellowship creatures as menu options.
     *
     * @return          alive Fellowship creatures as menu options
     *                  as a string.
     */
    public String[] getMenuOptionsAliveFellowship()
    {
        return fellowship.getMenuOptionsAliveFellowship();
    }

    /**
     * Method to give floppy disk to the Hobbit at game start.
     *
     */
    public void giveFloppyDiskToHobbit()
    {
        floppyDisk.setHeldBy(fellowship.getHobbit());
    }
     
    /**
     * Method to give floppy disk to the Wizard at game end.
     *
     */
    public void giveFloppyDiskToWizard()
    {
        floppyDisk.setHeldBy(wizard);
    }
    
    /**
     * Method to determine whether a Fellowship creature has a special weapon
     *
     * @param   fullName  The full name of the Fellowship creature.
     *
     * @return          Whether the Fellowship creature has a special weapon
     *                  as a boolean.
     */
    public boolean hasSpecialWeapon(String fullName)
    {
        return fellowship.hasSpecialWeapon(fullName);
    }

    /**
     * Method to heal Fellowship
     *
     * @return          Status of Fellowship after healing as string.
     */
    public String healFellowship()
    {
        fellowship.healFellowship();
        return "Healing has occurred.\n" +
        fellowship.displayHealth();
    }

    /**
     * Method to increment number of game moves.
     *
     */
    public void incrementGameMoves()
    {
        gameMoves++;
    }

    /**
     * Method to determine whether Fellowship is at Mount Api
     *
     * @return          Whether Fellowship is at Mount Api as a boolean.
     */
    public boolean isFellowshipAtMountApi()
    {
        return (fellowship.getGameLocation() == labyrinth.getMountApi());
    }

    /**
     * Method to handle movement of Fellowship to its next location.
     *
     * @param   nextLocationName   The name of the next location as a string.
     * @return          Result of game move and current game summary as string.
     */
    public String moveFellowshipToLocation(String nextLocationName)
    {
        fellowship.addVisitedCave(fellowship.getGameLocation());
        GameLocation nextLocation = labyrinth.getLocationByName(nextLocationName);
        String currentSummary = getCurrentSummary(nextLocation);
        fellowship.enterGameLocation(nextLocation);
        return currentSummary;
    }

    /**
     * Method to move Fellowship to last location after failed Mount Api visit.
     *
     * @return          Result of move to last location as string.
     */
    public String moveToLastLocation()
    {
        String result = "The Fellowship returned to the its last location.\n\n";
        result += moveFellowshipToLocation(fellowship.getLastLocation().getLocationName());
        return result;
    }

    /**
     * Method to process the stealing of a disk from one creature to another.
     *
     * @param   goodGuy The Fellowship creature as a Creature.
     *
     * @param   badGuy The enemy creature as a Creature.
     *
     * @param   winner The winner of a fight between the two as a Creature.
     *
     * @return          The current situation with the floppy disk as a string.
     */
    private String processDiskSteal(Creature goodGuy, Creature badGuy, Creature winner)
    {
        if ((winner == goodGuy && floppyDisk.getHeldBy() == badGuy) ||
            (winner == badGuy && fellowshipHasFloppyDisk()) &&
            winner.getIsAlive())
        {
                floppyDisk.setHeldBy(winner);
                return floppyDisk.getHeldBy().getFullName() +
                    " now has the floppy disk.\n";
        }
        if (fellowshipHasFloppyDisk())
            return "\n\t" + getDiskHolderFullName() +
            " has the floppy disk.\n";
        else
            return "\n\t" + getDiskHolderFullName() +
            " has the floppy disk at " + getDiskHolderLocation()  + ".\n";
    }

    /**
     * Method to place Fellowship in the labyrinth's first cave.
     *
     * @return          Result of the placement as a string.
     */
    public String putFellowshipInFirstCave()
    {
        fellowship.enterGameLocation(labyrinth.getFirstCave());
        return "The Fellowship will be starting at " + 
            fellowship.getFellowshipLocationNameWithIdentity() + "\n";
    }

    /**
     * Method to remove special weapon from Fellowship creature.
     *
     * @param   fullName    The full name of the Fellowship creature 
     *                      as a string.
     */
    public void removeSpecialWeapon(String fullName) 
    {
        FellowshipCreature fellowshipCreature;
        fellowshipCreature = fellowship.getFellowshipCreatureByFullName(fullName);
        fellowshipCreature.setHasSpecialWeapon(false);
    }

    /**
     * Method to determine if new enemy creature is created.
     *
     * @return          Result of enemy creature creation as string.
     */
    public String rollToCreateEnemyCreature()
    {
        return enemies.rollToCreateEnemyCreature(fellowship.getGameLocation()) + " created.";
    }
 
}
