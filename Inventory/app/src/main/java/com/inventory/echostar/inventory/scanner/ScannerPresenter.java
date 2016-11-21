package com.inventory.echostar.inventory.scanner;

import android.content.Intent;
import android.view.View;

import database_manager.DatabaseItemEmulator;
import database_manager.ItemDescription;


/**
 * Created by stas.savinov on 11/21/2016.
 */

public class ScannerPresenter
{
    private ScannerView view;

    /**
     * @Constructor: ScannerPresenter
     */
    public ScannerPresenter(ScannerView view)
    {
        this.view = view;
    }

    /**
     * @Function: searchItemByBarcode
     * @param intent
     * @param search_string
     */
    public void searchItemByBarcode(Intent intent, String search_string)
    {
        DatabaseItemEmulator database = new DatabaseItemEmulator(view.getThis());
        database.initializeDefaultItemDataBase();
        ItemDescription items = database.getSearchedItem(search_string);

        if (items != null)
        {
            intent.putExtra("Model",        items.model);
            intent.putExtra("Manufacturer", items.manufacturer);
            intent.putExtra("Creator",      items.creator);
            intent.putExtra("Version",          items.version);
            intent.putExtra("ModificationDate", items.modificationDate);
            intent.putExtra("Owner",            items.owner);
            intent.putExtra("SerialNumber",     items.serialNumber);
            intent.putExtra("Barcode",          items.barcode);
            intent.putExtra("Location",         items.location);
            intent.putExtra("State",            items.state);
            intent.putExtra("Office",                   items.office);
            intent.putExtra("GuaranteeExpiration",      items.guaranteeExpiration);
            intent.putExtra("AccountingInventoryCode",  items.accountingInventoryCode);
            intent.putExtra("Comments",                 items.comments);
            view.getThis().startActivity(intent);
        }
        else
        {
            view.showMessageDialog("Contents = " + search_string);
        }
    }

}
