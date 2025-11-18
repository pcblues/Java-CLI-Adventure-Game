import java.util.Scanner;

/**
 * Class which implements GameInteraction to provide user interaction.
 *
 * @author Mark Osborne
 * @version ver1.0.0
 */

public class TextDisplay implements GameInteraction
{
    final private static int YES = 1;
    final private static int NO = 2;
    final private static int NOT_YESNO = 3;

    private Scanner console; 

    /**
     * Default constructor which creates the object of the class TextDisplay.
     *
     */
    public TextDisplay()
    {
        this.console = new Scanner(System.in);
    }

   /**
     * Method to display output to the user.
     *
     * @param   output   The output to display as a string.
     */
     public void displayOutput(String output)
    {
        System.out.println(output);
    }

   /**
     * Method to prompt user for input.
     *
     * @param   prompt  The user prompt as a string.
     * @return          The entry made by the user as a string.
     */
     private String getInput(String prompt)
    {
        System.out.println(prompt);
        String input = console.nextLine();
        return input;
    }

    /**
     * Method to check if number is within a valid range.
     *
     * @param   stringNumber  The number to validate as a string.
     * @return          The validity of the number as a boolean.
     */
    private boolean isValidNumber(String stringNumber, int maxNum)
    {
        int result = 0;
        try 
        {
            result = Integer.parseInt(stringNumber);
        }
        catch (RuntimeException runTimeException)
        {
            result = 0;
        }
        if (stringNumber.isEmpty())
            stringNumber = "Entering nothing";
        if (result<1 || result>maxNum)
        {
            System.out.println(stringNumber + " is not a valid selection.\n");
            return false;
        }
        else
        {
            return true;
        }
    }

   /**
     * Method to prompt user for a name.
     *
     * @return          The entry of the user as a string.
     */
     public String promptName()
    {
        return this.getInput("Enter character's name:");
    }

    /**
     * Method to prompt user to pick a number.
     *
     * @param   prompt  The prompt displayed to the user as a string.
     * @param   maxNum  The maximum number the user can choose as an integer.
     * @return          An integer response as an integer.
     */
    public int promptPickANumber(String prompt,int maxNum)
    {    
        String selection = "";
        System.out.println(prompt);
        do 
        {
            selection = this.getInput("(Enter a number from 1 - " +
                maxNum + " and press ENTER.)");
        } while (!isValidNumber(selection, maxNum));
        return Integer.parseInt(selection);
    }
    
    /**
     * Method to prompt user to select a name from a list.
     *
     * @param   prompt  The prompt displayed to the user as a string.
     * @param   items  The items displayed to the user to choose from.
     * @return          The name of the user's selection as an string.
     */
    public String promptSelectItemName(String prompt, String[] items)
    {
        String itemList = "";
        String selection = "";
        for (int item = 0; item < items.length; item++)
        {   
            itemList += "\t" + String.valueOf(item+1) +
                ". "+items[item]+"\n";
        }
        do 
        {
            selection = this.getInput(prompt+"\n"+itemList);
        } while (!isValidNumber(selection,items.length));
        String result = items[Integer.parseInt(selection)-1];
        // remove item information from result (e.g. " (5 damage points)")
        if (result.indexOf(" (") != -1)
        {
            result = result.substring(0, result.indexOf(" ("));
        }
        return result;
    }

    /**
     * Method to prompt user to select a number from a list.
     *
     * @param   prompt  The prompt displayed to the user as a string.
     * @param   items  The items displayed to the user to choose from.
     * @return          The number of the user's selection as an integer.
     */
    public int promptSelectItemNumber(String prompt, String[] items)
    {
        String itemList = "";
        String selection = "";
        for (int item = 0; item < items.length; item++)
        {   
            itemList += "\t"+String.valueOf(item+1)+". "+items[item]+"\n";
        }
        do 
        {
            selection = this.getInput(prompt+"\n\n"+itemList);
        } while (!isValidNumber(selection,items.length));
        return Integer.parseInt(selection);
    }

    /**
     * Method to prompt user to continue.
     *
     * @param   prompt  The user prompt as string.
     */
    public void promptToContinue(String prompt)
    {
        System.out.println(prompt);
        this.getInput("Press ENTER to continue...");
    }

    /**
     * Method to prompt user for Yes/No answer.
     *
     * @param   prompt  The user prompt as string.
     * @return          The choice as a boolean.
     */
    public boolean promptYesNo(String prompt)
    {
        String selection = "";
        System.out.println(prompt);
        do
        {
            selection = this.getInput("(Enter Y for Yes or N for No" +
                " and press ENTER.)");
        } while (returnValidYesNo(selection) == NOT_YESNO);
        return (returnValidYesNo(selection) == YES);
    }


    /**
     * Method to return valid yes/no selection by user.
     *
     * @param   stringEntry  The user's entry.
     * @return          An integer response of YES, NO, YESNO.
     */
    private int returnValidYesNo(String stringEntry)
    {
        // allows flexible case when entering y, Y, n or N.
        if (!stringEntry.isEmpty())
        {
            if (stringEntry.charAt(0) == 'y' ||
                stringEntry.charAt(0) == 'Y' ||
                stringEntry.charAt(0) == 'n' ||
                stringEntry.charAt(0) == 'N'
                )
            {
                if (stringEntry.charAt(0) == 'y' ||
                    stringEntry.charAt(0) == 'Y')
                    return YES;
                else
                    return NO;
            }
            else
            {
                System.out.println(stringEntry + " is not a valid selection.\n");
                return NOT_YESNO;
            }
        }
        else
        {
            System.out.println("Entering nothing is not valid.\n");
            return NOT_YESNO;
        }
    }

}
