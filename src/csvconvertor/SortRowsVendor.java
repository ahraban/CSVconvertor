

package csvconvertor;

/**
 *  Class sorts a table based on vendors alphabetical order + prints the output
 *  
 * @author adam.hraban
 */
public class SortRowsVendor 
{   
    /**
     *  Constructor accepts a table, then the table is assorted based on vendors alphabetical order
     *  Output = updated table is printed (column order is changed to make the output more visible)
    */
    
    SortRowsVendor(String[][] tab)
    {
        String [][] temp = {{"0","1","2","3"}}; //holder for row to be swapped
        int r = tab.length; // number of rows
        int c = tab[0].length; // number of columns
        int z;
        
        //bubble sort
        tab[0][2]="AAA"; //to ensure table header stay at top ("Vendor" changed to "AAA")
        for(z=0;z<=r;z++)
        {
            for (int i = 0;i<r-1;i++)
            {   
                // "<" = ascenting order, ">" = descenting order
                if (tab[i][2].compareToIgnoreCase(tab[i+1][2])>0)
                {
                    for (int j = 0;j<=3;j++)
                    {
                        temp[0][j]=tab[i][j]; 
                        tab[i][j]=tab[i+1][j];
                        tab[i+1][j]=temp[0][j];
                    }
                }
            }
        }
        tab[0][2]="Vendor"; //to put back correct name of column
       
       //print the output + change column order to make vendor based ordering more visible
       for (int i = 0;i<r;i++)
       {
           System.out.print(tab[i][2] + " | ");
           System.out.print(tab[i][1]+ " | ");
           System.out.print(tab[i][3]+ " | ");
           System.out.print(tab[i][0]+ " | ");
           System.out.println();
       }
    }
}
