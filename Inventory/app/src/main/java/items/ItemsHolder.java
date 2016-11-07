package items;

import android.icu.text.DateFormat;

/**
 * Created by saturn on 07.11.2016.
 */

public class ItemsHolder implements SimpleObjectItem
{

}

class DebugTool implements SimpleObjectItem
{
    //No additional fields
}

class TV  implements SimpleObjectItem
{
    //No additional fields
}

class STB  implements SimpleObjectItem
{
    String ReceiverCAID     = null;
    String Secure           = null;
    String serviceProvider  = null;
}

class RCU implements SimpleObjectItem
{
    //No additional fields
}

class Smartcard  implements SimpleObjectItem
{
    String serialNumber = null;
    String serviceProvider = null;
}

class StorageDrive  implements SimpleObjectItem
{
    String storageType = null; // “External HDD”, “Internal HDD”, “Flash drive” and “Mobile rack” values
    long capacity = 0;
    String interfaces = null; //“USB”, “mini-USB”, “eSATA”, “SATA” and “IDE” values
}

class TestEquipment  implements SimpleObjectItem
{
    String type = null;
    DateFormat calibrationDate = null;
}

class Cable  implements SimpleObjectItem
{
   String title = null;
   double length = 0.0;
}

class Adapter implements SimpleObjectItem
{
    String title = null;
}

class VideoCaptureCard implements SimpleObjectItem
{
    //No additional fields
}

class SAGE implements SimpleObjectItem
{
    //No additional fields
}

class TransformerStepDown implements SimpleObjectItem
{
    //No additional fields
}

class TransformerIsolation implements SimpleObjectItem
{
    //No additional fields
}

class NetworkEquipment implements SimpleObjectItem
{
    //No additional fields
}

class FrontPanel implements SimpleObjectItem
{
    //No additional fields
    String title = null;
}

class Headphones implements SimpleObjectItem
{
    boolean hasMicrophone = false;
}

class IRReceiver implements SimpleObjectItem
{
    //No additional fields
}

class CD implements SimpleObjectItem
{
    //No additional fields
}

class Microphone implements SimpleObjectItem
{
    //No additional fields
}

class StreamingEquipment implements SimpleObjectItem
{
    //No additional fields
}

class PSU implements SimpleObjectItem
{
    String title = null;
    String socketType = null; //“UK, “US” and “Europe”
    int inputCurrent = 0;
    int outputCurrent = 0;
}

class RedRat implements SimpleObjectItem
{
    //No additional fields
}

class USBhub implements SimpleObjectItem
{
    //No additional fields
}

class SMARTBox implements SimpleObjectItem
{
    //No additional fields
}

class SmartcardReader implements SimpleObjectItem
{
    //No additional fields
}

class WebCamera implements SimpleObjectItem
{
    //No additional fields
}