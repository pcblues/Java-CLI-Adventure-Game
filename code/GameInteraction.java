/**
 * Interface which provides required methods to provide input and output 
 * for the game.
 *
 * @author Mark Osborne
 * @version ver1.0.0
 */

interface GameInteraction
{

    public void displayOutput(String output);
    public void promptToContinue(String prompt);
    public String promptName();
    public int promptPickANumber(String prompt,int maxNum);
    public int promptSelectItemNumber(String prompt, String[] items);
    public String promptSelectItemName(String prompt, String[] items);
    public boolean promptYesNo(String prompt);

}
