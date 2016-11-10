package items;

//import android.icu.text.DateFormat;
import android.util.Log;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by saturn on 07.11.2016.
 */

public class ItemsHolder extends SimpleObjectItem
{
    public ArrayList<String> subMainCategory= null;
    public ArrayList<String> subCategory    = null;
    public ArrayList<String> commonFields   = null;

    public ItemsHolder()
    {
        subMainCategory = new ArrayList<String>();
        subCategory = new ArrayList<String>();
        commonFields = new ArrayList<String>();

        subMainCategory.add("Equipment");
        subMainCategory.add("Books");

        subCategory.add("DebugTool");
        subCategory.add("TV");
        subCategory.add("STB");
        subCategory.add("RCU");
        subCategory.add("Smartcard");
        subCategory.add("StorageDrive");
        subCategory.add("TestEquipment");
        subCategory.add("Cable");
        subCategory.add("Adapter");
        subCategory.add("VideoCaptureCard");
        subCategory.add("SAGE");
        subCategory.add("TransformerStepDown");
        subCategory.add("TransformerIsolation");
        subCategory.add("NetworkEquipment");
        subCategory.add("FrontPanel");
        subCategory.add("Headphones");
        subCategory.add("IRReceiver");
        subCategory.add("CD");
        subCategory.add("Microphone");
        subCategory.add("StreamingEquipment");
        subCategory.add("PSU");
        subCategory.add("RedRat");
        subCategory.add("USBhub");
        subCategory.add("SMARTBox");
        subCategory.add("SmartcardReader");
        subCategory.add("WebCamera");


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
    }

    public ArrayList<String> getBaseList()
    {
        Log.i("getBaseList","subMainCategory:" +subMainCategory.toString());
        return subMainCategory;
    }

    public ArrayList<String> getSubcategoryList()
    {
        Log.i("getBaseList","getSubcategoryList:" +subCategory.toString());
        return subCategory;
    }

    public ArrayList<String> getCommonFieldsList()
    {
        return commonFields;
    }

}
class DebugTool extends SimpleObjectItem
{
    //No additional fields
}

class TV  extends SimpleObjectItem
{
    //No additional fields
}

class STB  extends SimpleObjectItem
{
    String ReceiverCAID     = null;
    String Secure           = null;
    String serviceProvider  = null;
}

class RCU extends SimpleObjectItem
{
    //No additional fields
}

class Smartcard  extends SimpleObjectItem
{
    String serialNumber = null;
    String serviceProvider = null;
}

class StorageDrive  extends SimpleObjectItem
{
    String storageType = HARDDRIVES.EXTERNAL.toString();
    String interfaces = INTERFACES.USB.toString();
    long capacity = 0;

    enum HARDDRIVES
    {
        EXTERNAL ("External HDD",0),
        INTERNAL ("Internal HDD",1),
        FLASH    ("Flash drive", 2),
        MOBILE   ("Mobile rack", 3);

        private String    sParameterName;
        private int       iParameterId;

        private HARDDRIVES(String toString, int id)
        {
            this.sParameterName = toString;
            this.iParameterId   = id;
        }
        public String getParameterString()
        {
            return this.sParameterName;
        }
    }

    enum INTERFACES
    {
        USB      ("USB",0),
        miniUSB  ("mini-USB",1),
        eSATA    ("eSATA", 2),
        SATA     ("SATA", 3),
        IDE      ("IDE", 3);

        private String    sParameterName;
        private int       iParameterId;

        private INTERFACES(String toString, int id)
        {
            this.sParameterName = toString;
            this.iParameterId   = id;
        }
        public String getParameterString()
        {
            return this.sParameterName;
        }
    }
}

class TestEquipment  extends SimpleObjectItem
{
    String type = null;
    Date calibrationDate = null;
}

class Cable  extends SimpleObjectItem
{
   String title = null;
   double length = 0.0;
}

class Adapter extends SimpleObjectItem
{
    String title = null;
}

class VideoCaptureCard extends SimpleObjectItem
{
    //No additional fields
}

class SAGE extends SimpleObjectItem
{
    //No additional fields
}

class TransformerStepDown extends SimpleObjectItem
{
    //No additional fields
}

class TransformerIsolation extends SimpleObjectItem
{
    //No additional fields
}

class NetworkEquipment extends SimpleObjectItem
{
    //No additional fields
}

class FrontPanel extends SimpleObjectItem
{
    //No additional fields
    String title = null;
}

class Headphones extends SimpleObjectItem
{
    boolean hasMicrophone = false;
}

class IRReceiver extends SimpleObjectItem
{
    //No additional fields
}

class CD extends SimpleObjectItem
{
    //No additional fields
}

class Microphone extends SimpleObjectItem
{
    //No additional fields
}

class StreamingEquipment extends SimpleObjectItem
{
    //No additional fields
}

class PSU extends SimpleObjectItem
{
    String title = null;
    String socketType = SOKETTYPE.ENGLISH.toString();
    int inputCurrent = 0;
    int outputCurrent = 0;

    enum SOKETTYPE
    {
        ENGLISH  ("UK",0),
        USA      ("US",1),
        EUROPE   ("Europe", 2);

        private String    sParameterName;
        private int       iParameterId;

        private SOKETTYPE(String toString, int id)
        {
            this.sParameterName = toString;
            this.iParameterId   = id;
        }
        public String getParameterString()
        {
            return this.sParameterName;
        }
    }

}

class RedRat extends SimpleObjectItem
{
    //No additional fields
}

class USBhub extends SimpleObjectItem
{
    //No additional fields
}

class SMARTBox extends SimpleObjectItem
{
    //No additional fields
}

class SmartcardReader extends SimpleObjectItem
{
    //No additional fields
}

class WebCamera extends SimpleObjectItem
{
    //No additional fields
}