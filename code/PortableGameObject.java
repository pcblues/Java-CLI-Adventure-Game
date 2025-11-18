/**
 * Abstract Class which holds a game object that can be 
 * carried by a character
 *
 * @author Mark Osborne
 * @version ver1.0.0
 */

// this is a note for video: more carryable objects may be developed later
// hence the inheritance via an abstract class
public abstract class PortableGameObject
{

    private Creature heldBy;
    private String description; 
    private int changedHandsCount;
    private Creature lastHeldBy;

    /**
     * Default constructor which creates the object of the class PortableGameObject,
     * but cannot be called directly.
     *
     */
    public PortableGameObject()
    {
       
    }
    
    /**
     * Accessor Method to get the number of times the object changed hands.
     *
     * @return          The number of times the object changed hands
     *                  as an integer.
     */    
    public int getChangedHandsCount()
    {
        return changedHandsCount;
    }

    /**
     * Accessor Method to get the descripton of the object.
     *
     * @return          The descripton of the object as a string.
     */    
    public String getDescription()
    {
        return description;
    }

    /**
     * Accessor Method to get holder of the object.
     *
     * @return          The holder of the object as a Creature.
     */    
    public Creature getHeldBy()
    {
        return heldBy;
    }

    /**
     * Accessor Method to get last holder of the object.
     *
     * @return          The last holder of the object as a Creature.
     */    
    public Creature getLastHeldBy()
    {
        return lastHeldBy;
    }

    /**
     * Mutator Method to set the number of times the object has changed hands.
     *
     * @param   changedHandsCount    The number of times the object changed 
     *                               hands as integer.
     */
    public void setChangedHandsCount(int changedHandsCount)
    {
        this.changedHandsCount = changedHandsCount;
    }

    /**
     * Mutator Method to change description of object 
     *
     * @param   description   The description of the object as a string.
     */
    public void setDescription(String description)
    {
        this.description = description;
    }

    /**
     * Mutator Method to change who a game object is held by.
     *
     * @param   holdingIt  The creature not holding the object as a Creature.
     */
    public void setHeldBy(Creature holdingIt)
    {
        if (holdingIt != heldBy)
        {
            changedHandsCount++;
            lastHeldBy = heldBy;
            heldBy = holdingIt;
        }
    }

}
