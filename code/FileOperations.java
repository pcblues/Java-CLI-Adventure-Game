import java.io.FileWriter;
import java.io.FileReader;
import java.util.Scanner;

/**
 * Class which executes file operations.
 *
 * @author Mark Osborne
 * @version ver1.0.0
 */

public class FileOperations
{

    /**
     * Default constructor which creates the object of the class FileOperations.
     *
     */
    public FileOperations()
    {
    }

    /**
     * Method to read from a file.
     *
     * @param   fileName  The file to read as string.
     *
     * @return          Contents of file as string.
     * @see https://edstem.org/au/courses/20522/lessons/70091/slides/467346 
     */
    public String readFromFile(String fileName)
    {
        String fileContents = "";

        try
        {
            FileReader fileReader = new FileReader(fileName);
            try
            {
                Scanner fileInput = new Scanner(fileReader);
                while (fileInput.hasNextLine())
                {
                    fileContents = fileContents + "\n" + fileInput.nextLine();
                }
            }
            finally
            {
                try
                {
                    fileReader.close();
                }
                catch (Exception e)
                {
                    System.out.println("Error closing '"+fileName+"'");
                }
            }
        }
        catch (Exception e)
        {
            System.out.println("Error reading from '"+fileName+"'");
        }
        return fileContents;
    }

    /**
     * Method to save to a file.
     *
     * @param   fileName  The file to save to as string.
     *
     * @param   fileContents  The contents to save to the file as a string.
     *
     * @see https://edstem.org/au/courses/20522/lessons/70091/slides/467346 
     */
    public void saveToFile(String fileName, String fileContents)
    {
        try
        {
            FileWriter fileWriter = new FileWriter(fileName);
            try
            {
                fileWriter.write(fileContents);
            }
            finally
            {
                try
                {
                    fileWriter.close();
                }
                catch (Exception e)
                {
                    System.out.println("Error closing '"+ fileName +"'");
                }
            }
        }
        catch(Exception e)
        {
            System.out.println("Error writing to '"+ fileName +"'");
        }
    }

}
