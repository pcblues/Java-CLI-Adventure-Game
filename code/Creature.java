/**
 * Abstract Class which contains a creature used within the game.
 *
 * @author Mark Osborne
 * @version ver1.0.0
 */

public abstract class Creature
{
    final private static int MAX_DAMAGE_POINTS = 10;

    private int damagePoints;
    private boolean isAlive;
    private String name;
    private String type;
    private int power;

    /**
     * Default constructor which creates the object of the class Creature.
     *
     */
    public Creature()
    {
        this.isAlive = true;
        this.damagePoints = 0;
        this.power = 0;
    }


    /**
    * Non-Default constructor which creates the object of the class Creature.
    * @param    type    The type of a creature passed in as a string.
    */
    public Creature(String type)
    {
        this.type = type;
        this.isAlive = true;
        this.damagePoints = 0;
        this.power = this.getPowerOfType();
    }

    /**
    * Non-Default constructor which creates the object of the class Creature.
    * @param    name    The name of a creature passed in as a string.
    * @param    type    The type of a creature passed in as a string.
    */
    public Creature(String name, String type)
    {
        this.name = name;
        this.type = type;
        this.isAlive = true;
        this.damagePoints = 0;
        this.power = this.getPowerOfType();
    }

    /**
     * Accessor method to get the creature's damage points.
     *
     * @return              The creature's damage points return as an int.
     */
    public int getDamagePoints()
    {
        return this.damagePoints;
    }

    /**
     * Method to get the full name of the creature.
     *
     * @return              The creature's full name as a string.
     */
    public String getFullName()
    {
        // check for where this is done without method
        return this.name + " the " + this.type;
    }

    /**
     * Method to get the alive status of the creature.
     *
     * @return              The creature's alive status as a boolean.
     */
    public boolean getIsAlive()
    {
        return this.isAlive;
    }
    
    /**
     * Accessor Method to get the name of the creature.
     *
     * @return              The creature's name as a string.
     */
    public String getName()
    {
        return this.name;
    }

    /**
     * Accessor Method to get the power points of the creature.
     *
     * @return              The creature's power points as an integer.
     */
    public int getPower()
    {
        return this.power;
    }

    /**
     * Private Method to determine the power of a creature based on its type.
     *
     * @return              The creature's power points as an integer.
     */
    private int getPowerOfType()
    {
        switch(this.type)
        {
            case GameConstants.TYPE_ORC:
                return GameConstants.POWER_ORC;
            case GameConstants.TYPE_TROLL:
                return GameConstants.POWER_TROLL;
            case GameConstants.TYPE_GOBLIN:
                return GameConstants.POWER_GOBLIN;
            case GameConstants.TYPE_HOBBIT:
                return GameConstants.POWER_HOBBIT;
            case GameConstants.TYPE_ELF:
                return GameConstants.POWER_ELF;
            case GameConstants.TYPE_DWARF:
                return GameConstants.POWER_DWARF;
            default:
                return 0;
        }
    }

    /**
     * Accessor Method to get the type of the creature.
     *
     * @return              The creature's type as a string.
     */
    public String getType()
    {
        return this.type;
    }

    /**
     * Mutator Method to set the damage points of the creature.
     *
     * @param   damagePoints    The damage done to the creature as an integer.
     */
    public void setDamagePoints(int damagePoints)
    {
        this.damagePoints = damagePoints;
    }

    /**
     * Mutator Method to set the alive status of the creature.
     *
     * @param   isAlive    The live status of the creature as a boolean.
     */
    public void setIsAlive(boolean isAlive)
    {
        this.isAlive = isAlive;
    }

    /**
     * Mutator Method to set the name of the creature.
     *
     * @param   name    The name of the creature as a string.
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Mutator Method to set the name of the creature.
     *
     * @param   name    The name of the creature as a string.
     */
    public void setType(String type)
    {
        this.type = type;
    }

 
}
