package csvconvertor;

/** Class prints a list of rows relevant for a given vendor
 *
 * @author adam.hraban
 */
public class RowVendor 
{
    /**
    *Constructor accepts table + vendor name
    *Output is a console printed list of rows relevant for given vendor
    */
    
    RowVendor(String[][] tab, String vendor)
    {
        int r = tab.length;
        System.out.print("Vendor " + vendor + " records are in rows: ");
        
        //run through array -> return row index + print it
        for (int i=0; i<r;i++)
        {
            if (tab[i][2].equalsIgnoreCase(vendor))
            {
                System.out.print((i+1) + ", ");
            }
        }
        System.out.println();
    }
    
}
