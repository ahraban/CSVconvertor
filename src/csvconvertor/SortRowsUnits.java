
package csvconvertor;

/** 
 * Class sorts a table based on units sold + prints the output
 * @author adam.hraban
 */
public class SortRowsUnits 
{   
    /**
    *Constructor accepts a table, then the table is assorted based on units sold
    *Output = updated table is printed
    */
    SortRowsUnits(String[][] tab)
    {
        String [][] temp = {{"0","1","2","3"}}; //holder for row to be swapped
        int r = tab.length; // number of rows
        int c = tab[0].length; // number of columns
        int z;
        double e;
        double f;
         
        // bubble sort
        tab[0][3]="0"; //to ensure table header stay at top ("Units" changed to "0")
        for(z=0;z<r;z++)
        {
            for (int i = 1;i<r-1;i++)
            {   
                e=Double.parseDouble(tab[i][3]);
                f=Double.parseDouble(tab[i+1][3]);

                // "<" = ascenting order, ">" = descenting order -- change table header value too: "Units"
                if (f>e)
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
        tab[0][3]="Units"; //to put back correct name of column
       
       //print the output
       for (int i = 0;i<r;i++)
       {
           for (int j = 0;j<=3;j++)
           {
                System.out.print(tab[i][j] + " | ");
           }
           System.out.println();
       }
    }
}