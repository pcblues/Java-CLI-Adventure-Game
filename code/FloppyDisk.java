/**
 * Class which stores the Floppy Disk
 *
 * @author Mark Osborne
 * @version ver1.0.0
 */

public class FloppyDisk extends PortableGameObject
{
    final private static String DISK_NAME = "floppy disk with a secret code stored on it";

    /**
     * Default constructor which creates the object of the class FloppyDisk.
     *
     */
    public FloppyDisk()
    {
        setDescription(DISK_NAME);
        setHeldBy(FellowshipCreature.nobody);
        setChangedHandsCount(0);
    }

}
