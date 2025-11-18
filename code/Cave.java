/**
 * Class represents caves in the game.
 *
 * @author Mark Osborne
 * @version ver1.0.0
 */

public class Cave extends GameLocation
{

    final private static int    NOWHERE_IDENTITY = -1;
    final private static String NOWHERE_LOCATION = "Nowhere";

    public static Cave nowhere = new Cave(
        NOWHERE_IDENTITY,
        NOWHERE_LOCATION,
        Labyrinth.BLOCKED_IDENTITY,
        Labyrinth.BLOCKED_IDENTITY,
        Labyrinth.BLOCKED_IDENTITY,
        Labyrinth.BLOCKED_IDENTITY
        );

   /**
     * Non-Default constructor creates the object of the class Cave.
     *
     * @param caveIdentity    Accepts the identity of the cave as an integer.
     * @param caveName        Accepts the name of the cave as a string.
     * @param northIdentity   Accepts the identity of the northern exit as an int.
     * @param southIdentity   Accepts the identity of the southern exit as an int.
     * @param eastIdentity    Accepts the identity of the eastern exit as an int.
     * @param westIdentity    Accepts the identity of the western exit as an int.
     */
    public Cave(int caveIdentity, String caveName, int northIdentity, 
        int southIdentity, int eastIdentity, int westIdentity)
    {
        super(caveIdentity, caveName, northIdentity, southIdentity, 
            eastIdentity,westIdentity);
    }

}

