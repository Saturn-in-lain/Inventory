package items;

//import android.icu.text.DateFormat;
import java.util.Date;

/**
 * Created by saturn on 07.11.2016.
 */

public class ItemsHolder extends SimpleObjectItem
{
    //No additional fields
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
    String storageType = null; // “External HDD”, “Internal HDD”, “Flash drive” and “Mobile rack” values
    long capacity = 0;
    String interfaces = null; //“USB”, “mini-USB”, “eSATA”, “SATA” and “IDE” values
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
    String socketType = null; //“UK, “US” and “Europe”
    int inputCurrent = 0;
    int outputCurrent = 0;
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