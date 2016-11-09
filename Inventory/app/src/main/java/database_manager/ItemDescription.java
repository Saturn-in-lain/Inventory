package database_manager;

import java.util.Date;

import items.SimpleObjectItem;

/**
 * Created by saturn on 08.11.2016.
 */

public class ItemDescription extends SimpleObjectItem
{
    // Idea is to create constructor for all possible items in case app will not only get, but
    // also create and edit items.

    public ItemDescription(String mod, String manufacturer, String creator, String version,
                                String modificationDate, String owner, String serialNumber,
                                String barcode, String location, String state, String guaranteeExpiration,
                                String office, String accountingInventoryCode, String comments)
    {

        initializeData(mod, manufacturer, creator, version, modificationDate,  owner,  serialNumber,
                 barcode,  location,  state,  guaranteeExpiration, office,  accountingInventoryCode,
                comments);
    }
}
