/**
 * Abstract Class which represents a game location.
 *
 * @author Mark Osborne
 * @version ver1.0.0
 */

public abstract class GameLocation
{
    private int locationIdentity;
    private String locationName;
    private int northIdentity;
    private int southIdentity;
    private int eastIdentity;
    private int westIdentity;

    /**
     * Default constructor creates an object of the class GameLocation.
     *
     */
    private GameLocation()
    {
    }

   /**
     * Non-Default constructor creates an object of the class GameLocation.
     *
     * @param caveIdentity    Accepts the identity of the cave as an integer.
     * @param caveName        Accepts the name of the cave as a string.
     * @param northIdentity   Accepts the identity of the northern exit as an int.
     * @param southIdentity   Accepts the identity of the southern exit as an int.
     * @param eastIdentity    Accepts the identity of the eastern exit as an int.
     * @param westIdentity    Accepts the identity of the western exit as an int.
     */
     public GameLocation(int locationIdentity,String locationName, int northIdentity, 
        int southIdentity, int eastIdentity, int westIdentity)
    {
        this.northIdentity = northIdentity;
        this.southIdentity = southIdentity;
        this.eastIdentity = eastIdentity;
        this.westIdentity = westIdentity;

        this.locationIdentity = locationIdentity;
        this.locationName = locationName;
    }

    /**
     * Accessor Method to return the identity of the East exit.
     *
     * @return          The East exit of the game location as an integer.
     */
     public int getEastIdentity()
    {
        return this.eastIdentity;
    }

     /**
     * Accessor Method to return the identity of the game location.
     *
     * @return          The identity of the game location as an integer.
     */
    public int getLocationIdentity()
    {
        return this.locationIdentity;
    }

     /**
     * Accessor Method to return the name of the game location.
     *
     * @return          The name of the game location as a string.
     */
    public String getLocationName()
    {
        return this.locationName;
    }

     /**
     * Method to return the name of the game location with its identity.
     *
     * @return          The game location with its identity as a string.
     */
    public String getLocationNameWithIdentity()
    {
        return this.locationName + " (Location " + locationIdentity +")";
    }

    /**
     * Accessor Method to return the identity of the North exit.
     *
     * @return          The North exit of the game location as an integer.
     */
    public int getNorthIdentity()
    {
        return this.northIdentity;
    }

    /**
     * Accessor Method to return the identity of the South exit.
     *
     * @return          The South exit of the game location as an integer.
     */
    public int getSouthIdentity()
    {
        return this.southIdentity;
    }

    /**
     * Accessor Method to return the identity of the West exit.
     *
     * @return          The West exit of the game location as an integer.
     */
    public int getWestIdentity()
    {
        return this.westIdentity;
    }

}
