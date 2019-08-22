
package csvconvertor;

import com.opencsv.CSVReader;
import java.io.FileReader;
import java.util.ArrayList;

/** Class creates a 2D array (table) from a given CSV file
 *
 * @author adam.hraban
 */
public class TableMaker {

    TableMaker()
    {

    }
        
    /** Method creates a table (2D array) from a hard coded file location ("data.csv")
     * 
     *
     * @return table
     */
    public String[][] createTable()    
    {        
        CSVReader reader= null;
        ArrayList <String> table = new ArrayList<>();
        int k = 0;
        
        try
        {
            //reader =  new CSVReader(new FileReader ("C:\\Users\\adam.hraban\\Documents\\- OTHER\\data.csv"),',');
            reader =  new CSVReader(new FileReader ("data.csv"),',');
            String [] nextLine;
            while ((nextLine=reader.readNext()) != null)
            {
                for (String token : nextLine)
                {
                    table.add(token);
                }
            }
        }
        catch (Exception e)
        {
             System.out.println(e);
        }
        
        
        // populate 2D array
        int c = 4; //number of columns
        int r = table.size() / c; // number of rows
        
        String[][] tab = new String[r][c];
        
        for (int i=0; i<r;i++)
        {
            for (int j=0;j<c;j++)
            {
                tab[i][j]=table.get(k);
                k++;
            }
        }
        return tab;
    }
    
    /** Method displays whole table
     *
     * @param tab table to be displayed
     */
        public void displayTable(String[][] tab )
        {
            int r = tab.length;
            int c = tab[0].length;
            
            for (int i=0; i<r;i++)
            {
                for (int j=0;j<c;j++)
                {
                    System.out.print(tab[i][j] + " | ");
                }
                System.out.println();
            }
        }
    }








