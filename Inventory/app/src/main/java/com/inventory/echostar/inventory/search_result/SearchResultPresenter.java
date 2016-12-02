package com.inventory.echostar.inventory.search_result;

import android.content.Intent;
import android.util.Log;

import com.inventory.echostar.inventory.item_description.ItemDescriptionActivity;

import java.util.List;

import database_manager.DatabaseItemEmulator;
import database_manager.ItemDescription;

/**
 * Created by stas.savinov on 11/21/2016.
 * http://stackoverflow.com/questions/15832335/android-custom-row-item-for-listview
 * http://www.viralandroid.com/2016/04/start-new-activity-from-android-listview-onitem-clicked.html
 */

public class SearchResultPresenter
{
    private SearchResultView view;
    private final String LOG = "Search Result Activity";

    private List<String>          models = null;
    private List<ItemDescription> items  = null;

    /**
     * @Construct: SearchResultPresenter
     */
    public SearchResultPresenter(SearchResultView view)
    {
        this.view = view;
    }

    /**
     * @Function: openItemDescriptionActivity - Override method
     * @params: None
     */
    public Intent openItemDescriptionActivity(int position)
    {
        Log.i(LOG,"F:[setSeaopenItemDescriptionActivityrchResultList] This is works!");

        Intent intent = new Intent(view.getThis(), ItemDescriptionActivity.class);
        intent.putExtra("Model",            items.get(position).model);
        intent.putExtra("Manufacturer",     items.get(position).manufacturer);
        intent.putExtra("Creator",          items.get(position).creator);
        intent.putExtra("Version",          items.get(position).version);
        intent.putExtra("ModificationDate", items.get(position).modificationDate);
        intent.putExtra("Owner",            items.get(position).owner);
        intent.putExtra("SerialNumber",     items.get(position).serialNumber);
        intent.putExtra("Barcode",          items.get(position).barcode);
        intent.putExtra("Location",         items.get(position).location);
        intent.putExtra("State",            items.get(position).state);
        intent.putExtra("Office",            items.get(position).office);
        intent.putExtra("GuaranteeExpiration",      items.get(position).guaranteeExpiration);
        intent.putExtra("AccountingInventoryCode",  items.get(position).accountingInventoryCode);
        intent.putExtra("Comments",                 items.get(position).comments);

        return intent;
    }

    /**
     * @Function: setSearchResultList - Override method
     * @params: None
     */
    public void setSearchResultList()
    {
        DatabaseItemEmulator database = new DatabaseItemEmulator(view.getThis());
        database.initializeDefaultItemDataBase();
        //database.typeAllDataBaseCredentials();
        Log.i(LOG,"F:[setSearchResultList] This is works!");

        this.models = database.getAllModelNames();
        this.items = database.getAllDataBaseItems();

        view.getSearchResultListView().setAdapter(new ListAdapter(view.getThis(), models));

    }
}
