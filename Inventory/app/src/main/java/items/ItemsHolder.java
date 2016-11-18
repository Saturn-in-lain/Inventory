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
    public ArrayList<String> subMainCategory = null;
    public ArrayList<String> subCategory     = null;
    public ArrayList<String> ItemFields      = null;

    public ItemsHolder()
    {
        subMainCategory = new ArrayList<String>();
        subCategory     = new ArrayList<String>();

        subMainCategory.add("Equipment");
        subMainCategory.add("Books");
        initSubCategoryList();
    }

    public void initSubCategoryList()
    {
        subCategory.clear();
        subCategory.add("DebugTool");               //#0
        subCategory.add("TV");                      //#1
        subCategory.add("STB");                     //#2
        subCategory.add("RCU");                     //#3
        subCategory.add("Smartcard");               //#4
        subCategory.add("StorageDrive");            //#5
        subCategory.add("TestEquipment");           //#6
        subCategory.add("Cable");                   //#7
        subCategory.add("Adapter");                 //#8
        subCategory.add("VideoCaptureCard");        //#9
        subCategory.add("SAGE");                    //#10
        subCategory.add("TransformerStepDown");     //#11
        subCategory.add("TransformerIsolation");    //#12
        subCategory.add("NetworkEquipment");        //#13
        subCategory.add("FrontPanel");              //#14
        subCategory.add("Headphones");              //#15
        subCategory.add("IRReceiver");              //#16
        subCategory.add("CD");                      //#17
        subCategory.add("Microphone");              //#18
        subCategory.add("StreamingEquipment");      //#19
        subCategory.add("PSU");                     //#20
        subCategory.add("RedRat");                  //#21
        subCategory.add("USBhub");                  //#22
        subCategory.add("SMARTBox");                //#23
        subCategory.add("SmartcardReader");         //#24
        subCategory.add("WebCamera");               //#25
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

    public ArrayList<String> getItemFieldsList(int subCategory)
    {
        ItemFields = SimpleObjectItem.getCommonFieldsList();
        ArrayList<String> unionList = new ArrayList<String>(ItemFields);

        Log.i("getBaseList","subCategory position:" + subCategory);
        Log.i("ItemFields","ItemFields:" + ItemFields);
        Log.i("unionList","unionList:" + unionList);

        //###########################################################################################
        // This code is stub variant, because Java is not so smart as Python to create objects
        // freely. In such case I have to make code straight for now. Architecture of this
        // will be definitly reworked.
        //###########################################################################################
         ArrayList<String> unionFields = null;
         switch(subCategory)
         {
             case 0:
                 DebugTool obj1 = new DebugTool();
                 unionFields = obj1.getUniqueItemFields();
                 break;
             case 1:
                 TV obj2 = new TV();
                 unionFields =  obj2.getUniqueItemFields();
                 break;
             case 2:
                 STB obj3 = new STB();
                 unionFields = obj3.getUniqueItemFields();
                 break;
             case 3:
                 RCU obj4 = new RCU();
                 unionFields = obj4.getUniqueItemFields();
                 break;
             case 4:
                 Smartcard obj5 = new Smartcard();
                 unionFields = obj5.getUniqueItemFields();
                 break;
             case 5:
                 StorageDrive obj6 = new StorageDrive();
                 unionFields = obj6.getUniqueItemFields();
                 break;
             case 6:
                 TestEquipment obj7 = new TestEquipment ();
                 obj7.getUniqueItemFields();
                 break;
             case 7:
                 Cable obj8 = new Cable();
                 unionFields = obj8.getUniqueItemFields();
                 break;
             case 8:
                 Adapter obj9 = new Adapter();
                 unionFields = obj9.getUniqueItemFields();
                 break;
             case 9:
                 VideoCaptureCard obj10 = new VideoCaptureCard();
                 unionFields = obj10.getUniqueItemFields();
                 break;
             case 10:
                 SAGE obj11 = new SAGE();
                 unionFields = obj11.getUniqueItemFields();
                 break;
             case 11:
                 TransformerStepDown obj12 = new TransformerStepDown();
                 unionFields = obj12.getUniqueItemFields();
                 break;
             case 12:
                TransformerIsolation obj13 = new TransformerIsolation();
                unionFields = obj13.getUniqueItemFields();
                break;
             case 13:
                NetworkEquipment obj14 = new NetworkEquipment();
                unionFields = obj14.getUniqueItemFields();
                break;
             case 14:
                FrontPanel obj15 = new FrontPanel();
                unionFields = obj15.getUniqueItemFields();
                break;
             case 15:
                 Headphones obj16 = new Headphones();
                 unionFields = obj16.getUniqueItemFields();
                 break;
             case 16:
                 IRReceiver obj17 = new IRReceiver();
                 unionFields = obj17.getUniqueItemFields();
                 break;
             case 17:
                CD obj18 = new CD();
                 unionFields =  obj18.getUniqueItemFields();
                break;
             case 18:
                 Microphone obj19 = new Microphone ();
                 unionFields =  obj19.getUniqueItemFields();
                break;
             case 19:
                StreamingEquipment obj20 = new StreamingEquipment();
                 unionFields = obj20.getUniqueItemFields();
                break;
             case 20:
                 PSU obj21 = new PSU();
                 unionFields = obj21.getUniqueItemFields();
                 break;
             case 21:
                 RedRat obj22 = new RedRat();
                 unionFields = obj22.getUniqueItemFields();
                 break;
             case 22:
                 USBhub obj23 = new USBhub();
                 unionFields = obj23.getUniqueItemFields();
                 break;
             case 23:
                 SMARTBox obj24 = new SMARTBox();
                 unionFields = obj24.getUniqueItemFields();
                break;
             case 24:
                 SmartcardReader obj25 = new SmartcardReader();
                 unionFields = obj25.getUniqueItemFields();
                 break;
             case 25:
                 WebCamera obj26 = new WebCamera();
                 unionFields = obj26.getUniqueItemFields();
                 break;
             default:
                 Log.i("switch","default:");
                 break;
         }
        //###########################################################################################
        if (unionFields != null)
        {
            unionList.addAll(unionFields);
        }
        Log.i("getBaseList","getCommonFieldsList:" +unionList.toString());
        return unionList;
    }
}

/* ------------------------------------------------------------------------------------------------
*  ALL small classes are present here
* -------------------------------------------------------------------------------------------------
* */

class STB extends SimpleObjectItem implements GlobalItemAPI
{
    String ReceiverCAID     = null;
    String Secure           = null;
    String serviceProvider  = null;

    public STB()
    {
        Fields.clear();
        Fields.add("Receiver CAID");
        Fields.add("Secure");
        Fields.add("Service Provider");
    }

    public ArrayList<String> getUniqueItemFields()
    {
        return Fields;
    }

}

class Smartcard  extends SimpleObjectItem implements GlobalItemAPI
{
    String serialNumber     = null;
    String serviceProvider  = null;

    public Smartcard()
    {
        Fields.clear();
        Fields.add("Serial Number");
        Fields.add("Service Provider");
    }

    public ArrayList<String> getUniqueItemFields()
    {
        return Fields;
    }

}

class StorageDrive  extends SimpleObjectItem implements GlobalItemAPI
{
    String storageType = HARDDRIVES.EXTERNAL.toString();
    String interfaces = INTERFACES.USB.toString();
    long capacity = 0;

    public StorageDrive()
    {
        Fields.clear();
        Fields.add("Storage Type");
        Fields.add("Interfaces");
        Fields.add("Capacity");
    }

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

    public ArrayList<String> getUniqueItemFields()
    {
        return Fields;
    }
}

class TestEquipment  extends SimpleObjectItem implements GlobalItemAPI
{
    String type          = null;
    Date calibrationDate = null;

    public TestEquipment()
    {
        Fields.clear();
        Fields.add("Type");
        Fields.add("Calibration Date");
    }

    public ArrayList<String> getUniqueItemFields()
    {
        return Fields;
    }
}

class Cable  extends SimpleObjectItem implements GlobalItemAPI
{
   String title     = null;
   double length    = 0.0;

    public Cable()
    {
        Fields.clear();
        Fields.add("Title");
        Fields.add("Length");
    }

    public ArrayList<String> getUniqueItemFields()
    {
        return Fields;
    }
}

class Adapter extends SimpleObjectItem implements GlobalItemAPI
{
    String title = null;

    public Adapter()
    {
        Fields.add("Title");
    }
    public ArrayList<String> getUniqueItemFields()
    {
        return Fields;
    }
}

class PSU extends SimpleObjectItem implements GlobalItemAPI
{
    String title = null;
    String socketType = SOKETTYPE.ENGLISH.toString();
    int inputCurrent = 0;
    int outputCurrent = 0;

    public PSU()
    {
        Fields.clear();
        Fields.add("Title");
        Fields.add("Socket type");
        Fields.add("Input carrent");
        Fields.add("Output carrent");
    }

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

    public ArrayList<String> getUniqueItemFields()
    {
        return Fields;
    }

}

class FrontPanel extends SimpleObjectItem implements GlobalItemAPI
{
    String title = null;
    public FrontPanel()
    {
        Fields.clear();
        Fields.add("Title");
    }
    public ArrayList<String> getUniqueItemFields()
    {
        return Fields;
    }
}

class Headphones extends SimpleObjectItem implements GlobalItemAPI
{
    boolean hasMicrophone = false;
    public Headphones()
    {
        Fields.clear();
        Fields.add("Headphone");
    }
    public ArrayList<String> getUniqueItemFields()
    {
        return Fields;
    }
}

class DebugTool extends SimpleObjectItem implements GlobalItemAPI
{
    //No additional fields
    public ArrayList<String> getUniqueItemFields()
    {
        return Fields;
    }
}

class TV  extends SimpleObjectItem implements GlobalItemAPI
{
    //No additional fields
    public ArrayList<String> getUniqueItemFields()
    {
        return Fields;
    }
}

class RCU extends SimpleObjectItem implements GlobalItemAPI
{
    //No additional fields
    public ArrayList<String> getUniqueItemFields()
    {
        return Fields;
    }
}

class VideoCaptureCard extends SimpleObjectItem implements GlobalItemAPI
{
    //No additional fields
    public ArrayList<String> getUniqueItemFields()
    {
        return Fields;
    }
}

class SAGE extends SimpleObjectItem implements GlobalItemAPI
{
    //No additional fields
    public ArrayList<String> getUniqueItemFields()
    {
        return Fields;
    }
}

class TransformerStepDown extends SimpleObjectItem implements GlobalItemAPI
{
    //No additional fields
    public ArrayList<String> getUniqueItemFields()
    {
        return Fields;
    }
}

class TransformerIsolation extends SimpleObjectItem implements GlobalItemAPI
{
    //No additional fields
    public ArrayList<String> getUniqueItemFields()
    {
        return Fields;
    }
}

class NetworkEquipment extends SimpleObjectItem implements GlobalItemAPI
{
    //No additional fields
    public ArrayList<String> getUniqueItemFields()
    {
        return Fields;
    }
}

class IRReceiver extends SimpleObjectItem implements GlobalItemAPI
{
    //No additional fields
    public ArrayList<String> getUniqueItemFields()
    {
        return Fields;
    }
}

class CD extends SimpleObjectItem implements GlobalItemAPI
{
    //No additional fields
    public ArrayList<String> getUniqueItemFields()
    {
        return Fields;
    }
}

class Microphone extends SimpleObjectItem implements GlobalItemAPI
{
    //No additional fields
    public ArrayList<String> getUniqueItemFields()
    {
        return Fields;
    }
}

class StreamingEquipment extends SimpleObjectItem implements GlobalItemAPI
{
    //No additional fields
    public ArrayList<String> getUniqueItemFields()
    {
        return Fields;
    }
}

class RedRat extends SimpleObjectItem implements GlobalItemAPI
{
    //No additional fields
    public ArrayList<String> getUniqueItemFields()
    {
        return Fields;
    }
}

class USBhub extends SimpleObjectItem implements GlobalItemAPI
{
    //No additional fields
    public ArrayList<String> getUniqueItemFields()
    {
        return Fields;
    }
}

class SMARTBox extends SimpleObjectItem implements GlobalItemAPI
{
    //No additional fields
    public ArrayList<String> getUniqueItemFields()
    {
        return Fields;
    }
}

class SmartcardReader extends SimpleObjectItem implements GlobalItemAPI
{
    //No additional fields
    public ArrayList<String> getUniqueItemFields()
    {
        return Fields;
    }
}

class WebCamera extends SimpleObjectItem implements GlobalItemAPI
{
    //No additional fields
     public ArrayList<String> getUniqueItemFields()
    {
        return Fields;
    }
}