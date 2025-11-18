/**
 * Class which heads the game Fellowship of Code 
 *
 * @author Mark Osborne
 * @version ver1.0.0
 */

public class FellowshipOfCode
{

    private GameRunner gameRunner;

    /**
     * Default constructor which creates the object of the class FellowshipOfCode.
     *
     */
    public FellowshipOfCode()
    {
        this.gameRunner = new GameRunner();
    }

    /**
     * This is the main method which begins the program execution.
     * @param    args    An array of strings passed in as command line parameters
     */
    public static void main (String[] args) 
    {
        // prototype everything here?
        FellowshipOfCode fellowshipOfCode = new FellowshipOfCode();
        fellowshipOfCode.startGame();
    }

    /**
     * Method to start the game.
     *
     */
    private void startGame()
    {
        this.gameRunner.runGame();
    }

}
