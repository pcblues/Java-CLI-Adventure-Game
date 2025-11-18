import java.util.ArrayList;

/**
 * Class which stores the Fellowship and the Fellowship Members
 *   and their location and location history.
 *
 * @author Mark Osborne
 * @version ver1.0.0
 */

public class Fellowship
{

    private ArrayList<FellowshipCreature> aliveFellowshipCreatures;
    private ArrayList<FellowshipCreature> deadFellowshipCreatures;
    private GameLocation gameLocation;
    private GameLocation lastLocation;
    private int fightsWon;
    private int fightsLost;
    private ArrayList<GameLocation> visitedCaves;

    /**
     * Default constructor which creates the object of the class Fellowship.
     *
     */
    public Fellowship()
    {
        aliveFellowshipCreatures = new ArrayList<FellowshipCreature>();
        deadFellowshipCreatures = new ArrayList<FellowshipCreature>();
        gameLocation = Cave.nowhere;
        lastLocation = Cave.nowhere;
        fightsWon = 0;
        fightsLost = 0;
        visitedCaves = new ArrayList<GameLocation>();
    }

    /**
     * Method to add if cave contains any alive enemy creature.
     *
     * @param   type    The type of the Fellowship creature.
     * @param   name    The name of the Fellowship creature.
     */
    public void addFellowshipCreature(String type, String name)
    {
        FellowshipCreature newFellowshipCreature =
            new FellowshipCreature(type, name);
        this.aliveFellowshipCreatures.add(newFellowshipCreature);
    }

    /**
     * Method to add unique caves to list of visited caves.
     *
     * @param   gameLocation  The location of a visited location.
     */
    public void addVisitedCave(GameLocation gameLocation)
    {
        // only add if not in list, move count handles all moves.
        if (visitedCaves.indexOf(gameLocation) == -1)
            visitedCaves.add(gameLocation);
    }

    /**
     * Method to check whether Fellowship creature is alive
     *
     * @param   thisCreature  The Fellowship creature to have 
     *                  their vitality checked as a FellowshipCreature. 
     * @return          The aliveness of the Fellowship creature 
     *                  as a boolean.
     */
    public String checkFellowshipDeath(FellowshipCreature thisCreature)
    {
        String result = "";
        if (thisCreature.getDamagePoints() >= 10)
        {
            thisCreature.setIsAlive(false);
            result += thisCreature.getFullName() + " is dead.\n";
            deadFellowshipCreatures.add(thisCreature);
            aliveFellowshipCreatures.remove(thisCreature);
        }
        return result;
    }

    /**
     * Method to display a list of Fellowship creatures and their health.
     *
     * @return          The health of the alive Fellowship creatures 
     *                  as a string.
     */
    public String displayAliveFellowshipCreatures()
    {
        String output = "";
        for (Creature fellowshipCreature:aliveFellowshipCreatures)
        {
            output += "\t" + fellowshipCreature.getFullName() + " (" +
                fellowshipCreature.getDamagePoints() + " damage points)\n";
        }
        return output;
    }

    /**
     * Method to display a list of the Fellowship with their full names.
     *
     * @return          Alive Fellowship creatures as a string.
     */
    public String displayFellowship()
    {
        String output = "The Fellowship consists of:\n";
        String fellowshipList = "";
        if (!this.aliveFellowshipCreatures.isEmpty())
        {
            for (Creature fellowshipCreature:this.aliveFellowshipCreatures)
            {
                fellowshipList += "\t" + fellowshipCreature.getFullName();
            }
        }
        if (fellowshipList == "")
            fellowshipList = "Nobody?!";
        output += "\n" + fellowshipList;
        return output;
    }

    /**
        * Method to display the health of the Fellowship.
        * @return          The health of the Fellowship as a string.
        */
    public String displayHealth()
    {
        String output = "This is the health of the Fellowship:\n";
        String fellowshipList = "";
        if (!this.aliveFellowshipCreatures.isEmpty())
        {
            for (Creature fellowshipCreature:this.aliveFellowshipCreatures)
            {
                fellowshipList += "\t" + fellowshipCreature.getFullName() + 
                    " has " + fellowshipCreature.getDamagePoints() + " damage point";
                if (fellowshipCreature.getDamagePoints() == 1 )
                    fellowshipList += ".\n";
                else
                    fellowshipList += "s.\n";
            }
        }
        if (fellowshipList == "")
            fellowshipList = "Nobody?!";
        output += fellowshipList;
        return output;
    }
 
    /**
     * Method to set Fellowship in a certain game location.
     *
     * @param   thisCave  The cave to place the Fellowship as a GameLocation.
     *
     */
    public void enterGameLocation(GameLocation thisCave)
    {
        this.lastLocation = gameLocation;
        this.gameLocation = thisCave;
    }

    /**
     * Method to check whether any Fellowship creatures are alive
     *
     * @return          Whether any Fellowship creatures are alive as a boolean.
     */
    public boolean fellowshipAlive()
    {
        return !aliveFellowshipCreatures.isEmpty();
    }

    /**
     * Method to handle death of a Fellowship creature.
     *
     * @param   fellowshipCreature    The dead Fellowship creature 
     *                              as FellowshipCreature
     */
    public void fellowshipCreatureDies(FellowshipCreature fellowshipCreature)
    {
        // move to dead list from alive list
        deadFellowshipCreatures.add(fellowshipCreature);
        aliveFellowshipCreatures.remove(fellowshipCreature);
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
        FellowshipCreature fellowshipCreature;
        fellowshipCreature = this.getFellowshipCreatureByFullName(fullName);
        return fellowshipCreature.getHasSpecialWeapon();
    }

    /**
     * Method to get list of names of alive Fellowship Creatures.
     *
     * @return          List of alive Fellowship Creatures as ArrayList.
     */
    public ArrayList<String> getAliveFellowshipCreatureNames()
    {
        ArrayList<String> aliveFellowshipCreatureNames = new ArrayList<String>();
        for (Creature aliveFellowshipCreature:aliveFellowshipCreatures)
            {
                aliveFellowshipCreatureNames.add(aliveFellowshipCreature.getFullName());
            }
        return aliveFellowshipCreatureNames;
    }

    /**
     * Accessor Method to retrieve alive Fellowship creatures.
     *
     * @return          Alive Fellowship creatures as ArrayList.
     */
    public ArrayList<FellowshipCreature> getAliveFellowshipCreatures()
    {
        return this.aliveFellowshipCreatures;
    }

    /**
     * Accessor Method to retrieve alive Fellowship creatures.
     *
     * @return          Alive Fellowship creatures as ArrayList.
     */
    public ArrayList<FellowshipCreature> getDeadFellowshipCreatures()
    {
        return this.deadFellowshipCreatures;
    }

    /**
     * Method to retrieve a Fellowship creature by their full name.
     *
     * @param   fullName    The full name of the Fellowship creature.
     * @return          The found creature as a FellowshipCreature.
     */
    public FellowshipCreature getFellowshipCreatureByFullName(String fullName)
    {
        for (FellowshipCreature fellowshipCreature:this.aliveFellowshipCreatures)
        {
            if (fellowshipCreature.getFullName().equals(fullName))
                return fellowshipCreature;
        }
        return FellowshipCreature.nobody;
    }

    /**
     * Method to get name of location of the Fellowship with its identity.
     *
     * @return          Name of the location of the Fellowship with 
     *                  its identity.
     */
    public String getFellowshipLocationNameWithIdentity()
    {   
        return gameLocation.getLocationNameWithIdentity();
    }

    /**
     * Accessor Method to return number of fights won.
     *
     * @return          Number of fights won as integer.
     */
    public int getFightsWon()
    {
        return fightsWon;
    }

    /**
     * Accessor Method to return number of fights lost.
     *
     * @return          Number of fights lost as integer.
     */
    public int getFightsLost()
    {
        return fightsLost;
    }

    /**
     * Accessor Method to return Fellowship location.
     *
     * @return          Fellowship location as GameLocation.
     */
    public GameLocation getGameLocation()
    {
        return this.gameLocation;
    }

    /**
     * Method to return Fellowship member who is a Hobbit
     *
     * @return          Fellowship member who is a Hobbit as Creature.
     */
    public Creature getHobbit()
    {
        for (FellowshipCreature fellowshipCreature:this.aliveFellowshipCreatures)
        {
            if (fellowshipCreature.getType() == GameConstants.TYPE_HOBBIT)
                return fellowshipCreature;
        }

        // this is overkill, because the method is only used to give the 
        // floppy disk to the hobbit at the start of the game
        // when he is very much alive.
        for (FellowshipCreature fellowshipCreature:this.deadFellowshipCreatures)
        {
            if (fellowshipCreature.getType() == GameConstants.TYPE_HOBBIT)
                return fellowshipCreature;
        }
        return FellowshipCreature.nobody;
    }

    /**
     * Method to return last location of Fellowship
     *
     * @return          Last location of Fellowship as GameLocation.
     */
    public GameLocation getLastLocation()
    {
        return lastLocation;
    }

    /**
     * Method to return meny array of alive Fellowship creatures.
     *
     * @return          List of alive Fellowship creatures with their 
     *                  status as a string array.
     */
    public String[] getMenuOptionsAliveFellowship()
    {
        String[] result = new String[aliveFellowshipCreatures.size()];
        for (int index = 0; index < aliveFellowshipCreatures.size(); index++)
        {
            result[index] = aliveFellowshipCreatures.get(index).getFullName()+
                " (" +  aliveFellowshipCreatures.get(index).getPower() +
                " power points";
            if (aliveFellowshipCreatures.get(index).getHasSpecialWeapon())
                result[index] += ", special weapon";
            result[index] += ")";
        }
        return result;
    }

    /**
     * Method to calculate success rate of Fellowship
     *
     * @return          Success rate of Fellowship as integer.
     */
    public int getSuccessRate()
    {
        return 100 * fightsWon / (fightsLost+fightsWon);
    }

    /**
     * Accessor Method to return list of visited caves.
     *
     * @return          Visited caves and ArrayList.
     */
    public ArrayList<GameLocation> getVisitedCaves()
    {
        return visitedCaves;
    }


    /**
     * Method to apply healing to Fellowship.
     *
     */
    public void healFellowship()
    {
        for (Creature fellowshipCreature:this.aliveFellowshipCreatures)
        {
            if (fellowshipCreature.getDamagePoints() > 0)
                fellowshipCreature.setDamagePoints(fellowshipCreature.getDamagePoints()-1);
        }
    }

    /**
     * Method to increment number of fights won by Fellowship.
     */
    public void incrementFightsWon()
    {
        fightsWon++;
    }

    /**
     * Method to increment number of fights lost by Fellowship.
     */
    public void incrementFightsLost()
    {
        fightsLost++;
    }

    /**
     * Method to determine if creature is a Fellowship Creature
     *
     * @param   creature    Creature being investigated as a Creature.
     * @return          Whether the creature is in the Fellowship as a boolean.
     */
    public boolean isFellowshipCreature(Creature creature)
    {
        for (Creature fellowshipCreature:this.aliveFellowshipCreatures)
        {
            if (fellowshipCreature.getName().equals(creature.getName()))
                return true;
        }

        for (Creature fellowshipCreature:this.deadFellowshipCreatures)
        {
            if (fellowshipCreature.getName().equals(creature.getName()))
                return true;
        }
        return false;
    }

}
