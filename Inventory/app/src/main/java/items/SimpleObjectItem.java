package items;

//import android.icu.text.DateFormat;
import android.util.Log;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.Date;

/**
 * Created by saturn on 07.11.2016.
 */

public class SimpleObjectItem
{
    private static ArrayList<String> commonFields = null;

    public String model                   = null;
    public String manufacturer            = null;
    public String creator                 = null;
    public String version                 = null;
    public String modificationDate        = null;
    public String owner                   = null;
    public String serialNumber            = null;
    public String barcode                 = null;
    public String location                = null;
    public String state                   = null;
    public String guaranteeExpiration     = null;
    public String office                  = "Kharkov";
    public String accountingInventoryCode = null;
    public String comments                = null;
    public String image                   = null;

    //public ArrayList<String> commonFields = new ArrayList<String>();

    enum STATE_TYPE_STRUCTURE
    {
        NORMAL  ("Normal",0),
        BROKEN  ("Broken",1),
        LOST    ("Lost",  2);

        private String    sParameterName;
        private int       iParameterId;

        private STATE_TYPE_STRUCTURE(String toString, int id)
        {
            this.sParameterName = toString;
            this.iParameterId   = id;
        }
        public String getParameterString()
        {
            return this.sParameterName;
        }
    }

    public void initializeData(String model, String manufacturer, String creator, String version,
                               String modificationDate, String owner, String serialNumber,
                               String barcode, String location, String state, String guaranteeExpiration,
                               String office, String accountingInventoryCode, String comments)
    {
        this.model                   = model;
        this.manufacturer            = manufacturer;
        this.creator                 = creator;
        this.version                 = version;
        this.modificationDate        = modificationDate;
        this.owner                   = owner;
        this.serialNumber            = serialNumber;
        this.barcode                 = barcode;
        this.location                = location;
        this.state                   = STATE_TYPE_STRUCTURE.NORMAL.getParameterString();                //TODO HARDCODE
        this.guaranteeExpiration     = guaranteeExpiration;
        this.office                  = "Kharkov";                                                       //TODO HARDCODE
        this.accountingInventoryCode = accountingInventoryCode;
        this.comments                = comments;
    }

    /**
     * toString - Debug method to type all fields of this class
     *
     */
    public String toString()
    {
        String retValue = null;
        retValue = "Model: "                    + model                 +"\n"+
                    "Manufacturer: "            + manufacturer          +"\n"+
                    "Creator: "                 + creator               +"\n"+
                    "Version: "                 + version               +"\n"+
                    "ModificationDate: "        + modificationDate      +"\n"+
                    "Owner: "                   + owner                 +"\n"+
                    "SerialNumber: "            + serialNumber          +"\n"+
                    "Barcode: "                 + barcode               +"\n"+
                    "Location: "                + location              +"\n"+
                    "State: "                   + state                 +"\n"+
                    "GuaranteeExpiration: "     + guaranteeExpiration   +"\n"+
                    "Office: "                  + office                +"\n"+
                    "AccountingInventoryCode: " + accountingInventoryCode+"\n"+
                    "Comments: "                + comments              +"\n";
        return retValue;
    }

    /**
     * getCommonFieldsList - Return string list with basic fields
     */
    public static ArrayList<String> getCommonFieldsList()
    {
        commonFields = new ArrayList<String>();
        commonFields.add("Model");
        commonFields.add("Manufacturer");
        commonFields.add("Creator");
        commonFields.add("Version");
        commonFields.add("ModificationDate");
        commonFields.add("Owner");
        commonFields.add("SerialNumber");
        commonFields.add("Barcode");
        commonFields.add("Location");
        commonFields.add("State");
        commonFields.add("GuaranteeExpiration");
        commonFields.add("Office");
        commonFields.add("AccountingInventoryCode");
        commonFields.add("Comments");
        return commonFields;
    }
}
