import java.util.ArrayList;
import java.util.Arrays;

/**
 * Class which manages available location and character names
 * For orc names see @see https://neoencyclopedia.fandom.com/wiki/List_of_Middle-earth_Orcs
 * For other creature names see @see https://www.writtenwithlove.com.au/blogs/written-with-love-the-journal/100-most-popular-baby-boy-names-for-2024-in-australia 
 * For cave names see  * @see https://www.merriam-webster.com/thesaurus/doom 
 *
 * @author Mark Osborne
 * @version ver1.0.0
 */
public class Namer
{

    private static final ArrayList<String> orcNameList = 
        new ArrayList<String>(Arrays.asList("Boldog", "Azog",
        "Balcmeg","JJ","Bolg","Golfimbul","Gorbag","Gorgol","Lagduf",
        "Lugdush","Lurtz","Muzgash","Orcobal","Othrod","Radbug",
        "Shagrat","Snaga","Ufthak"));

    
    private static final ArrayList<String> otherNameList = 
        new ArrayList<String>(Arrays.asList(    
    "Oliver", "Noah", "Crushar", "Jack", "William", "Leo", "Lucas", "Thomas", "Henry",
    "James", "Liam", "Alexander", "Mason", "Ethan", "Benjamin", "Charlie",
    "Samuel", "Max", "Archie", "Isaac", "Oscar", "Elijah",
    "Levi", "Theodore", "Hunter", "Finn", "Jackson", "Jacob", "Angus",
    "Cooper", "Daniel", "Hudson", "Xavier", "Sebastian", "Patrick", "George",
    "Lachlan", "Edward", "Harrison", "Caleb", "David", "Michael", "Mitchell",
    "Aidan", "Gabriel", "Jaxon", "Nicholas", "Logan", "Eli", "Luca", "Dylan",
    "Riley", "Tyler", "Matthew", "Nate", "Wyatt", "Lincoln", "Dominic",
    "Toby", "Zachary"));

    private static final ArrayList<String> locationNameList = 
        new ArrayList<String>(Arrays.asList(    
    "Demise", "Death", "Fate", "Passing", "Dissolution", "Grave", "The End",
    "Expiration", "Deceasing", "Curtains", "Passage", "Destruction",
    "Expiry", "Quietus", "Fatality", "Ending", "Annihilation", "Ruin",
    "Extermination", "Slaughter", "Killing", "Massacre"));

    private static final ArrayList<String> usedNames = new ArrayList<String>();


   /**
     * Default constructor creates the object of the class Namer.
     */    
    private Namer()
    {

    }
   
    /**
     * Static Method to check if name has been used, or add to used name list.
     *
     * @param   name   Name to be used as string.
     *
     * @return          Whether name has been used as boolean.
     */
    public static boolean checkNameUsed(String name)
    {
        if (usedNames.indexOf(name) > -1)
            return true;
        else
        {
            usedNames.add(name);
            return false;
        }
    }

    /**
     * Static Method to choose new creature name based on type.
     *
     * @param   creatureType  The type of the creature as a string.
     *
     * @return      The name of the new creature as a string.
     */
    public static String getNewCreatureName(String creatureType)
    {
        ArrayList<String> listToUse = otherNameList;
        if (creatureType == GameConstants.TYPE_ORC && !orcNameList.isEmpty())
        {
            listToUse = orcNameList;
        }
        return retrieveNewName(listToUse);
    }

    /**
     * Method to generate a new location name.
     *
     * @return          The name of the new location as a string.
     */
    public static String getNewLocationName()
    {
        return "The Cave of " + retrieveNewName(locationNameList);
    }

     /**
     * Method to retrieve a random name from a list of names.
     *
     * @param   nameList  A list of names as an ArrayList.
     *
     * @return          Tje selected name as a string.
     */
    private static String retrieveNewName(ArrayList<String> nameList)
    {
        String result = "Nom";
        int index;
        if (!nameList.isEmpty())
        {
             index = (int)(Math.random() * nameList.size());
             result = nameList.remove(index);
        }
        return result;
    }

}
