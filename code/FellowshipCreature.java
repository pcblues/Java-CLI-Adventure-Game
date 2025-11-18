/**
 * Class which stores a creature of the Fellowship.
 *
 * @author Mark Osborne
 * @version ver1.0.0
 */

public class FellowshipCreature extends Creature
{

    final private static String TYPE_NOBODY = "Nobody";
    final private static String CREATURE_NAME_NOBODY = "Nobody";

    public final static FellowshipCreature nobody = new FellowshipCreature(
        CREATURE_NAME_NOBODY,
        TYPE_NOBODY);
    private boolean hasSpecialWeapon;

    /**
     * Default constructor which creates an object of the class FellowshipCreature.
     *
     */
    public FellowshipCreature()
    {
        super();
        setName(CREATURE_NAME_NOBODY);
        setType(TYPE_NOBODY);
        this.setHasSpecialWeapon(this.getType() == GameConstants.TYPE_HOBBIT ||
            this.getType() == GameConstants.TYPE_ELF);
    }

    /**
     * Non-Default constructor which creates an object of the class FellowshipCreature.
     *
     * @param   name  The name of the Fellowship creature as a string.
     *
     * @param   type   The type of the Fellowship creature as a string.
     *
     */
    public FellowshipCreature(String name, String type)
    {
        super(name, type);
        this.hasSpecialWeapon = (
            type == GameConstants.TYPE_HOBBIT ||
            type == GameConstants.TYPE_ELF);
    }

    /**
     * Accessor Method to return if a Fellowship creature has a special weapon.
     *
     * @return          Whether the Fellowship creature has a special weapon
     *                  as a boolean.
     */
    public boolean getHasSpecialWeapon()
    {
        return this.hasSpecialWeapon;
    }

     /**
     * Mutator Method to set whether a Fellowship creature has a special weapon.
     *
     * @param   gotIt  Whether a Fellowship creature has a special weapon as boolean.
     *
     * @return          Whether the Fellowship creature has a special weapon
     *                  as a boolean.
     */
   public void setHasSpecialWeapon(boolean gotIt)
    {
        this.hasSpecialWeapon = gotIt;
    }

}
