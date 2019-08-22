package csvconvertor;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/** Class creates a HTML output file from a given table (2D array)
 *
 * @author adam.hraban
 */

public class HtmlOutput
{   
    /**
    Constructor accepts String [][] as a parameter. Creates HTML file to a location
    specified in fileLocation variable. HTML contains a table displaying units sold + market share for hard coded vendors
    in period defined in period variable.  
    */
    
    HtmlOutput(String[][] tab, String fileLocation)
    {
        // variables for units sold by given vendor
        float ibm;
        float dell;
        float hp;
        float total;
        
        String period = "2010 Q3";
        
        
        //calculate units
        ibm = this.calculateVendorPeriod(tab, "ibm", period);
        dell = this.calculateVendorPeriod(tab, "dell", period);
        hp = this.calculateVendorPeriod(tab, "hp", period);
        total = this.calculateTotalUnitsPeriod(tab, period);
        
        
        //prepare html output
        File file = new File (fileLocation);
        String head = "<!DOCTYPE html><html><head><style>table, th, td {  border: 1px solid black;}</style></head><body>";
        String row1 =  "<table >  <tr> " + "   <th>Vendor</th>    <th>Units</th>    <th>Share</th>  </tr> ";
        String row2 = " <tr>    <td>IBM</td>    <td>"+ibm+"</td>    <td>" +(ibm*100/total) +  "%</td>  </tr> ";
        String row3 = " <tr>    <td>Dell</td>    <td>"+dell+"</td>    <td>" +(dell*100/total) +  "%</td>  </tr> ";
        String row4 = " <tr>    <td>HP</td>    <td>"+hp +"</td>    <td>" +(hp*100/total) +  "%</td>  </tr> ";
        String row5 = " <tr>    <td>Rest</td>    <td>"+(total - hp - dell - ibm) +"</td>    <td>" +((total - hp - dell - ibm)*100/total) +  "%</td>  </tr> ";
        String row6 = " <tr>    <td>Total</td>    <td>"+total +"</td>    <td>" +(total*100/total) +  "%</td>  </tr> ";
        String end = "</table> ";

        
        //write html to file
        String html = head + row1 + row2 + row3 + row4 + row5 + row6 + end;
        try
        {
            BufferedWriter bf = new BufferedWriter(new FileWriter(file));
            bf.write(html);
            bf.close();
        }   
            catch (IOException e) 
        {
            e.printStackTrace();
        }
        System.out.println("HTML file created: " + fileLocation);
    }
    
   
        /** calculate total units for a given vendor + period
        * @param tab table to be processed
        * @param vendor    vendor name (eg."Dell")
        * @param period    eg. "2010 Q4"
        * @return     number of units sold
        */
        public float calculateVendorPeriod(String [][] tab,String vendor, String period)
        {
            int r = tab.length; // number of rows
            float units = 0;
            for (int i=0; i<r;i++)
            {
                if (tab[i][2].equalsIgnoreCase(vendor)&&tab[i][1].equalsIgnoreCase(period))
                {
                    units += Double.parseDouble(tab[i][3]);
                }
            }
            return units;
        }
        
        /** calculate total units for a given period
        * @param tab       table to be processed
        * @param period   eg. "2010 Q4"
        * @return  number of units sold
        */
        public float calculateTotalUnitsPeriod(String [][] tab,String period)
        {
            int r = tab.length; // number of rows
            float units = 0;
            for (int i=0; i<r;i++)
            {
                if (tab[i][1].equalsIgnoreCase(period))
                {
                    units += Double.parseDouble(tab[i][3]);
                }
            }
            return units;
        }
}
