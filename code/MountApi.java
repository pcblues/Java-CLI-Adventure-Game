/**
 * Inherited Class which stores the location of Mount Api
 *
 * @author Mark Osborne
 * @version ver1.0.0
 */

public class MountApi extends GameLocation
{

    /**
     * Non-Default constructor creates the object of the class MountApi.
     *
     * @param locationIdentity    Accepts the identity of the location as an integer.
     * @param locationName        Accepts the name of the location as a string.
     * @param northIdentity       Accepts the identity of the northern exit as an int.
     * @param southIdentity       Accepts the identity of the southern exit as an int.
     * @param eastIdentity        Accepts the identity of the eastern exit as an int.
     * @param westIdentity        Accepts the identity of the western exit as an int.
     */
    public MountApi(int locationIdentity,String locationName,int northIdentity,
        int southIdentity, int eastIdentity, int westIdentity)
    {
        super(locationIdentity, locationName, northIdentity,
        southIdentity, eastIdentity, westIdentity);
    }

}
