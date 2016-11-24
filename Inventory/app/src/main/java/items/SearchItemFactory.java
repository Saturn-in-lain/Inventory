package items;

import android.content.Context;

import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by stas.savinov on 11/14/2016.
 */

class SearchItem implements SearchItemInterface
{
    private String nameOfThesubCategoty = null;
    private String SelectedSearchField  = null;
    private String UserSearchField      = null;

    /**
     * Constructor
     *
     */
    public SearchItem()
    {

    }

    /**
     * Constructor
     *
     */
    public SearchItem(String subCategory)
    {
        nameOfThesubCategoty = subCategory;
    }

    /**
     * @Function: setSearchedField
     * @Descriprion:
     * @param: String searchData
     */
    public void setSearchedField(String searchData)
    {
        SelectedSearchField = searchData;
    }

    /**
     * @Function: setUserSearchField
     * @Descriprion:
     * @param: String searchData
     */
    public void setUserSearchField(String searchData)
    {
        UserSearchField = searchData;
    }

    /**
     * @Function: performSearch
     * @Descriprion:
     * @param:
     */
    public boolean performSearch(Context ctx)
    {
        boolean retVal    = true;
        String  url_addon = null;

        RESTRequests request = new RESTRequests(ctx);
        JSONObject jsonRequest = null;

        if (SelectedSearchField == "Manufacturer")
        {
            url_addon = "/manufacturers";
        }
        else if(SelectedSearchField == "Locations")
        {
            url_addon = "/locations";
        }
        else if(SelectedSearchField == "Offices")
        {
            url_addon = "/offices";
        }
        else if(SelectedSearchField == "Service providers")
        {
            url_addon = "/service-providers";
        }
        else if(SelectedSearchField == "Models")
        {
            url_addon = "/models";
        }
        else if(SelectedSearchField == "Creator")
        {
            url_addon = "/creator";
        }
        else if(SelectedSearchField == "Owner")
        {
            url_addon = "/owner";
        }
        else if(SelectedSearchField == "Serial Number")
        {
            url_addon = "/serial-number";
        }
        else if(SelectedSearchField == "Barcode")
        {
            url_addon = "/barcode";
        }
        else if(SelectedSearchField == "AccountingInventoryCode")
        {
            url_addon = "/accounting-inventory-code";
        }
        else
        {
            // Nothing to do
        }

        // Here we will add some additional path
//        if (null != SelectedSearchField)
//        {
//            url_addon = url_addon + SelectedSearchField;
//        }

        String response = request.GETRequestSend(ctx, url_addon, jsonRequest);
        return retVal;
    }


    /**
     * @Function: getItemFieldsList
     * @Descriprion:
     * @param: ArrayList String
     */
    public ArrayList<String> getSubCategoriesList(Context ctx)
    {

        RESTRequests request = new RESTRequests(ctx);
        JSONObject jsonRequest = null;

        String url_addon = "categories";
        String response = request.GETRequestSend(ctx, url_addon, jsonRequest);

        //Here we should fill Fields.
        //Fields.add() iterable

        return Fields;
    }
}

/**
 * @class: SearchItemFactory
 * @Descriprion: Experimental Architecture
 * @param:
 */
public class SearchItemFactory
{

    public SearchItem getItemFiled(String itemType)
    {
        if(itemType == null)
        {
            return null;
        }
        if (itemType == "All")
        { return new SearchItem("All");}
        if (itemType == "DebugTool") 
            { return new SearchItem("DebugTool");}
        if (itemType == "TV")
            { return new SearchItem("TV");}
        if (itemType == "STB")
            { return new SearchItem("STB");}
        if (itemType == "RCU")
            { return new SearchItem("RCU");}
        if (itemType == "Smartcard")
            { return new SearchItem("Smartcard");}
        if (itemType ==  "StorageDrive")
            { return new SearchItem("StorageDrive");}
        if (itemType ==  "TestEquipment")
            { return new SearchItem("TestEquipment");}
        if (itemType ==  "Cable")
            { return new SearchItem("Cable");}
        if (itemType ==  "Adapter")
            { return new SearchItem("Adapter");}
        if (itemType ==  "VideoCaptureCard")
            { return new SearchItem("VideoCaptureCard");}
        if (itemType ==  "SAGE")
            { return new SearchItem("SAGE");}
        if (itemType ==  "TransformerStepDown")
            { return new SearchItem("TransformerStepDown");}
        if (itemType ==  "TransformerIsolation")
            { return new SearchItem("TransformerIsolation");}
        if (itemType ==  "NetworkEquipment")
            { return new SearchItem("NetworkEquipment");}
        if (itemType ==  "FrontPanel")
            { return new SearchItem("FrontPanel");}
        if (itemType ==  "Headphones")
            { return new SearchItem("Headphones");}
        if (itemType ==  "IRReceiver")
            { return new SearchItem("IRReceiver");}
        if (itemType ==  "CD")
            { return new SearchItem("CD");}
        if (itemType ==  "Microphone")
            { return new SearchItem("Microphone");}
        if (itemType ==  "StreamingEquipment")
            { return new SearchItem("StreamingEquipment");}
        if (itemType ==  "PSU")
            { return new SearchItem("PSU");}
        if (itemType ==  "RedRat")
            { return new SearchItem("RedRat");}
        if (itemType ==  "USBhub")
            { return new SearchItem("USBhub");}
        if (itemType ==  "SMARTBox")
            { return new SearchItem("SMARTBox");}
        if (itemType ==  "SmartcardReader")
            { return new SearchItem("SmartcardReader");}
        if (itemType ==  "WebCamera")
            { return new SearchItem("WebCamera");}
        return null;
    }
}
