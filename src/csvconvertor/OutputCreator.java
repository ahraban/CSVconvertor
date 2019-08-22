

package csvconvertor;

/** Class exports a given table (2d array) to format selected by user (*.XLS + *.CSV available)
 *
 * @author adam.hraban
 */
public class OutputCreator 
{
 
    /**
    Constructor accepts a table, then converts it to to output file defined by user
    * 
    */
    
    OutputCreator()
    {
        
    }
    
    OutputCreator (String[][] tab, String filePath, String fileName, String fileFormat)
    {
        this.convertFile(tab, filePath, fileName, fileFormat);
    }
    
    /** Method converts table to a file based on provided parameters.
     * As of now its possible to convert table either to *.XLS or *.CSV format.
     * Output = new file created
     * 
     * @param tab table to be converted into file
     * @param filePath folder destination for a new file
     * @param fileName name for a new file (eg. "NewFile")
     * @param fileFormat format for a new file, XLS, CSV implemented so far (eg. "CSV")
     * 
     * 
     */
    public void convertFile(String[][] tab, String filePath, String fileName, String fileFormat)
    {
        
    }
}

