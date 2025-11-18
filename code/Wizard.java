/**
 * Class which holds the Wizard creature.
 *
 * @author Mark Osborne
 * @version ver1.0.0
 */

public class Wizard extends Creature
{
    final private static String TYPE_WIZARD = "Wizard";
    final private static String CREATURE_NAME_WIZARD = "Java Wizard";

    /**
     * Default constructor which creates the object of the class Wizard.
     *
     */
    public Wizard()
    {
        super(CREATURE_NAME_WIZARD, TYPE_WIZARD);
    }
    
}
