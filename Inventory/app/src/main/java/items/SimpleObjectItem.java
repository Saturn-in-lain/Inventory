package items;

//import android.icu.text.DateFormat;
import java.util.Date;

/**
 * Created by saturn on 07.11.2016.
 */

public interface SimpleObjectItem
{
    String manufacturer = null;
    String model        = null;
    String creator      = null;
    String version      = null;
    Date modificationDate = null;
    String owner        = null;
    String serialNumber = null;
    String barcode      = null;
    String location     = null;
    String state        = null;             //Dropdown box with “Normal”, “Broken” and “Lost” values
    Date guaranteeExpiration = null;
    String office       = "Kharkov";
    String accountingInventoryCode = null;
    String comments     = null;

    /**
     * @Function:
     * @param
     */
}
