import java.util.ArrayList;

/**
 * Class which stores the structure and location of the game's labyrinth.
 *
 * @author Mark Osborne
 * @version ver1.0.0
 */
public class Labyrinth
{
    final public static int    BLOCKED_IDENTITY = 0;
    final private static String BLOCKED_STRING = "BLOCKED!";

    final private static int    MTAPI_IDENTITY = 100;
    final private static String MTAPI_NAME = "Mount Api where the Java Wizard lives";

    private ArrayList<GameLocation> locations;
    private GameLocation blockedLocation;
    private GameLocation mountApi;

    /**
     * Default constructor which creates the object of the class Labyrinth.
     *
     */
    public Labyrinth()
    {
        locations = new ArrayList<GameLocation>();
        blockedLocation = new Cave (BLOCKED_IDENTITY,
        BLOCKED_STRING,
        BLOCKED_IDENTITY,BLOCKED_IDENTITY,
        BLOCKED_IDENTITY,BLOCKED_IDENTITY );
        locations.add(blockedLocation);
        mountApi = new MountApi(0, null, 0, 0, 0, 0);
        this.loadFromFile("labyrinth.txt");
    }

    /**
     * Method to find available entries to a game location
     *
     * @param   toLocation  The location to find the entries for 
     *                 as GameLocation.
     * @return   A list of locations that have access to toLocation 
     *           as a string.
     */
    public ArrayList<String> getAvailableEntries(GameLocation toLocation)
    {
        ArrayList<String> entries = new ArrayList<String>();

        for (GameLocation gameLocation : locations)
        {
            if (gameLocation.getNorthIdentity() == toLocation.getLocationIdentity() )
            {
                String newEntry = getLocationDescriptionByIdentity
                    (gameLocation.getLocationIdentity()) + " (Location "+
                    gameLocation.getLocationIdentity() +")";
                if (entries.indexOf(newEntry) == -1)
                {
                    entries.add (newEntry);
                }
            }

            if (gameLocation.getSouthIdentity() == toLocation.getLocationIdentity() )
            {
                String newEntry = getLocationDescriptionByIdentity
                    (gameLocation.getLocationIdentity()) + " (Location "+
                    gameLocation.getLocationIdentity() +")";
                if (entries.indexOf(newEntry) == -1)
                {
                    entries.add(newEntry);
                }
            }

            if (gameLocation.getEastIdentity() == toLocation.getLocationIdentity() )
            {
                String newEntry = getLocationDescriptionByIdentity
                    (gameLocation.getLocationIdentity()) + " (Location "+
                    gameLocation.getLocationIdentity() +")";
                if (entries.indexOf(newEntry) == -1)
                {
                    entries.add (newEntry);
                }
            }

            if (gameLocation.getWestIdentity() == toLocation.getLocationIdentity() )
            {
                String newEntry = getLocationDescriptionByIdentity
                    (gameLocation.getLocationIdentity()) + " (Location "+
                    gameLocation.getLocationIdentity() +")";
                if (entries.indexOf(newEntry) == -1)
                {
                    entries.add (newEntry);
                }
            }
        }
        return entries;
    }

    /**
     * Method to find available exits from a game location
     *
     * @param   toLocation  The location to find the exits 
     *                 as GameLocation.
     * @return   A list of locations that have exits from toLocation 
     *           as a string.
     */
    public ArrayList<String> getAvailableExits(GameLocation gameLocation)
    {
        ArrayList<String> exits = new ArrayList<String>();

        if (gameLocation.getNorthIdentity() != BLOCKED_IDENTITY )
        {
            String newExit = getLocationDescriptionByIdentity
                (gameLocation.getNorthIdentity()) + " (Location "+
                gameLocation.getNorthIdentity() +")";
            if (exits.indexOf(newExit) == -1)
            {
                exits.add (newExit);
            }
        }

        if (gameLocation.getSouthIdentity() != BLOCKED_IDENTITY )
        {
            String newExit = getLocationDescriptionByIdentity
                (gameLocation.getSouthIdentity()) + " (Location "+
                gameLocation.getSouthIdentity() +")";
            if (exits.indexOf(newExit) == -1)
            {
                exits.add (newExit);
            }
        }

        if (gameLocation.getEastIdentity() != BLOCKED_IDENTITY )
        {
            String newExit = getLocationDescriptionByIdentity
                (gameLocation.getEastIdentity()) + " (Location "+
                gameLocation.getEastIdentity() +")";
            if (exits.indexOf(newExit) == -1)
            {
                exits.add (newExit);
            }
        }

        if (gameLocation.getWestIdentity() != BLOCKED_IDENTITY )
        {
            String newExit = getLocationDescriptionByIdentity
                (gameLocation.getWestIdentity()) + " (Location "+
                gameLocation.getWestIdentity() +")";
            if (exits.indexOf(newExit) == -1)
            {
                exits.add (newExit);
            }
        }

        return exits;
    }

    /**
     * Method to return first cave of the Labyrinth
     *
     * @return          The location of the first cave as a GameLocation.
     */
   public GameLocation getFirstCave()
    {
        // cover if identity 1 doesn't exist?
        return getLocationByIdentity(1);
    }

    /**
     * Method to get a game location based on its identity.
     *
     * @param   locationIdentity  The identity of the game location 
     *                  as an integer.
     * @return          The game location of an identity as a GameLocation.
     */
    private GameLocation getLocationByIdentity(int locationIdentity)
    {
        for (GameLocation location:this.locations)
        {
            if (location.getLocationIdentity() == locationIdentity)
            {
                return location;
            }
        }
        return Cave.nowhere;
    }

    /**
     * Method to get a game location based on its name.
     *
     * @param   locationName  The identity of the game location 
     *                  as an string.
     * @return          The game location of an identity as a GameLocation.
     */
    public GameLocation getLocationByName(String locationName)
    {
        // do checks to prevent errors?
        // remove direction prompt
        int bracket = locationName.indexOf("(");
        if (bracket != -1)
            locationName = locationName.substring(0,bracket-1);
        for (GameLocation location:this.locations)
        {
            if (location.getLocationName().equals(locationName))
            {
                return location;
            }
        }
        return Cave.nowhere;
    }


    /**
     * Method to get game location based on identity.
     *
     * @param   locationIdentity  The identity of the game location as integer.
     * @return          The name of the location as a string.
     */
    private String getLocationDescriptionByIdentity(int locationIdentity)
    {
        for (GameLocation location:this.locations)
        {
            if (location.getLocationIdentity() == locationIdentity)
            {
                return location.getLocationName();// + " (" + locationIdentity+ ")";
            }
        }
        return "Unknown";
    }

    /**
     * Method to return available exits as menu options.
     *
     * @param   location  The game location to find the exits from 
     *                    as GameLocation.
     * @return          The available exits in menu options as an
     *                  array of strings.
     */
    public String[] getMenuOptionsAvailableExits(GameLocation location)
    {
        ArrayList<String> availableExits = getAvailableExits(location);
        int numberExits = availableExits.size();
        String[] exits = new String[numberExits];
        for (int index = 0; index < numberExits ; index++)
        {
            exits[index] = availableExits.get(index);
        }
        return exits;
    }

    /**
     * Accessor Method to return the game location of Mount Api.
     *
     * @return          The game location of MountApi as a GameLocation.
     */
    public GameLocation getMountApi()
    {
        return mountApi;
    }


    /**
     * Method to load the labyrinth from a file.
     *
     * @param   fileName  The name of the file as a string.
     */
    private void loadFromFile(String fileName)
    {
        FileOperations fileOperations = new FileOperations();
        String labyrinth = fileOperations.readFromFile(fileName);
        String locations[] = labyrinth.split("\n");
        for (String locationString:locations)
        {
            if (!locationString.isEmpty())
            {
                String data[] = locationString.split(",");
                int identityHere = Integer.parseInt(data[0]);
                int identityNorth = Integer.parseInt(data[1]);
                int identityEast = Integer.parseInt(data[2]);
                int identitySouth = Integer.parseInt(data[3]);
                int identityWest = Integer.parseInt(data[4]);

                if (identityHere == MTAPI_IDENTITY)
                {
                    mountApi = new MountApi(MTAPI_IDENTITY,
                        MTAPI_NAME,identityNorth, identitySouth,
                        identityEast, identityWest);
                    this.locations.add(mountApi);
                    }
                else
                {
                    String caveName = Namer.getNewLocationName();
                    GameLocation cave = new Cave(identityHere, caveName, identityNorth, identitySouth,
                        identityEast, identityWest);
                    this.locations.add(cave);
                }
            }
        }
    }
}
