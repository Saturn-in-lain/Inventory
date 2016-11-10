package com.inventory.echostar.inventory;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

import database_manager.DatabaseItemEmulator;
import database_manager.ItemDescription;

//http://stackoverflow.com/questions/15832335/android-custom-row-item-for-listview
//http://www.viralandroid.com/2016/04/start-new-activity-from-android-listview-onitem-clicked.html
public class SearchResultActivity extends AppCompatActivity
{
    ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result);

        DatabaseItemEmulator database = new DatabaseItemEmulator(this);
        database.initializeDefaultItemDataBase();
        database.typeAllDataBaseCredentials();

        final List<String> models = database.getAllModelNames();

        final  List<ItemDescription> items = database.getAllDataBaseItems();


        listview = (ListView) findViewById(R.id.lstViewFoundItems);
        listview.setAdapter(new ListAdapter(this, models));

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                Log.i("SearchResultActivity","models.get(position): " + models.get(position));
                Intent intent = new Intent(SearchResultActivity.this, ItemDescriptionActivity.class);
                //###########################################################################
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
                //###########################################################################




                //###########################################################################
                SearchResultActivity.this.startActivity(intent);
            }
        });

    }
}

