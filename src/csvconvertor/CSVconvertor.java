package csvconvertor;

/** Main class used to process other classes
 *
 * @author adam.hraban
 */
public class CSVconvertor {

    public static void main(String[] args) 
    {   
        
        //a) load the file, create a table
        TableMaker table = new TableMaker();
        String[][] tabulka = table.createTable();
        
        //b) return units sold + market share for a vendor in a specified period
        VendorPeriod vendor = new VendorPeriod(tabulka,"Dell","2010 Q4");
        System.out.println();

        //c) show relevant row numbers for a vendor
        RowVendor rowVen = new RowVendor(tabulka,"Dell");
        System.out.println();
        
        //d)sort table alphabetically based on vendors name (columns reasorted for easier reading)
        System.out.println("Sort alphabetically: ");
        SortRowsVendor sortVendor = new SortRowsVendor(tabulka);
        System.out.println();
        
         //e)sort table alphabetically based on units sold 
        System.out.println("Sort based on units sold: ");
        SortRowsUnits sortUnits = new SortRowsUnits(tabulka);
        System.out.println();
        
        //f)convert table to to HTML - change String variable to a "local folder\fileName.html"
        HtmlOutput html = new HtmlOutput(tabulka,"C:\\Users\\adam.hraban\\Documents\\test.html");
        System.out.println();
        
    }
    
}
