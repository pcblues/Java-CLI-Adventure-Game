/**
 * Class which stores an enemy creature.
 *
 * @author Mark Osborne
 * @version ver1.0.0
 */
public class EnemyCreature extends Creature
{
    final private static String TYPE_NOBODY = "Nobody";
    final private static String CREATURE_NAME_NOBODY = "Nobody";

    public final static EnemyCreature nobody = new EnemyCreature(
        TYPE_NOBODY,
        CREATURE_NAME_NOBODY);

    private GameLocation gameLocation;

    /**
     * Non-Default constructor which creates the object of the class EnemyCreature.
     *
     * @param   type   The type of the Fellowship creature as a string.
     *
     * @param   gameLocation  The location of the enemy creature as a GameLocation.
     *
     *
     */
    public EnemyCreature(String type, GameLocation gameLocation)
    {
        super(type);
        this.gameLocation = gameLocation;
        this.setName(Namer.getNewCreatureName(type));
    }

    /**
     * Non-Default constructor which creates the object of the class EnemyCreature.
     *
     * @param   name  The name of the enemy creature as a string.
     * 
     * @param   type   The type of the Fellowship creature as a string.
     */
    public EnemyCreature(String name, String type)
    {
        super(name, type);
    }


    /**
     * Accessor Method to return the location of an enemy creature.
     *
     * @return          The location of an enemy creature as a GameLocation.
     */
    public GameLocation getGameLocation()
    {
        return gameLocation;
    }

}
