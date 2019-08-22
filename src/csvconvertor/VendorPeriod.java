package csvconvertor;

/** Class calculates units sold by a vendor during given period + prints the output
 *
 * @author adam.hraban
 */
public class VendorPeriod 
{
    VendorPeriod(String[][]tab,String vendor,String period)
    {
        this.findVendorPeriod(tab, vendor, period);
    }
    
     /** Method calculates units sold by a vendor during given period, total units sold in given period,
     * calculates market share + prints the output
     *
     * @param tab table to be processed
     * @param vendor vendor name (eg. "Dell"]
     * @param period eg. "2010 Q4"
     */
    public void findVendorPeriod(String[][] tab, String vendor,String period)
    {
        int r = tab.length; // number of rows
        int c = tab[0].length; // number of columns
        double sum = 0;  // total units sold
        double sumPeriod = 0;  // total units sold in given period
        double unitsSoldVendor = 0;  //units sold by specific vendor
        double sumVendor = 0;  //units sold by specific vendor
        float share = 0; //market share of a vendor

        
        //total units sold in all periods - not used yet
        for (int i=1; i<r;i++)
        {
            sum += Double.parseDouble(tab[i][3]); 
        }
        
        
        //total units sold  in a given period
        for (int i=0; i<r;i++)
        {
            if (tab[i][1].equalsIgnoreCase(period))
            {
                sumPeriod += Double.parseDouble(tab[i][3]);
            }
        }
        
        //total units sold  for a given vendor - not used yet
        for (int i=0; i<r;i++)
        {
            if (tab[i][2].equalsIgnoreCase(vendor))
            {
                sumVendor += Double.parseDouble(tab[i][3]);
            }
        }

        // calculate total units for a given vendor + period
        for (int i=0; i<r;i++)
        {
            if (tab[i][2].equalsIgnoreCase(vendor)&&tab[i][1].equalsIgnoreCase(period))
            {
                unitsSoldVendor += Double.parseDouble(tab[i][3]);
            }
        }
        
        // print the output for the vendor and period - sold units + marketshare 
        System.out.println("Vendor " + vendor + " during period: " + period + " ");
        System.out.println("sold "  + unitsSoldVendor + " units");
        System.out.println("this means: " + ((unitsSoldVendor / sumPeriod) * 100) + " % market share" );
    }
}
