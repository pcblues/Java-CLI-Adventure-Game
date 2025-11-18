/**
 * Class which is used to test game classes
 *
 * @author Mark Osborne
 * @version ver1.0.0
 */

public class GameTester
{

    private FellowshipCreature fellowshipCreature;

    /**
     * Default constructor which creates the object of the class GameTester.
     *
     */
    public GameTester()
    {
        
    }

    /**
    * This is the main method which begins the testing execution
    * @param    args    An array of string passed in as command line parameters
    */
    public static void main (String args[])
    {
        System.out.println("GAME TESTER\n");
        GameTester gameTest = new GameTester();
        gameTest.runGameTests();
    }

    /**
    * Method starts the run of the game tests.
    */
    private void runGameTests()
    {
        System.out.println("\nGAME TESTS FOR FELLOWSHIPCREATURE/CREATURE CLASS");
        System.out.println("\nTest 1: Create FellowshipCreature with default constructor.");
        FellowshipCreature fellowshipCreature = new FellowshipCreature();
        System.out.println("isAlive: " + fellowshipCreature.getIsAlive());
        System.out.println("damagePoints: " + fellowshipCreature.getIsDamagePoints());
        System.out.println("power: " + fellowshipCreature.getPower());
        System.out.println("type: " + fellowshipCreature.getIsAlive());
        System.out.println("hasSpecialWeapon: " + fellowshipCreature.());

        System.out.println("\nTest 2a");
        System.out.println("\nTest 2b");
        System.out.println("\nTest 3");
        System.out.println("\nTest 4");
        System.out.println("\nTest 5");
        System.out.println("\nTest 6");
        System.out.println("\nTest 7");
        System.out.println("\nTest 8");
        System.out.println("\nTest 9a");
        System.out.println("\nTest 9b");
        System.out.println("\nTest 10a");
        System.out.println("\nTest 10b");
        System.out.println("\nTest 11a");
        System.out.println("\nTest 11b");
        System.out.println("\nTest 12a");
        System.out.println("\nTest 12b");
        System.out.println("\nTest 13a");
        System.out.println("\nTest 13b");
        System.out.println("\nTest 14a");
        System.out.println("\nTest 14b");
        System.out.println("\nTest 15");

    }


}
