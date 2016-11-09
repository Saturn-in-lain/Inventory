package com.inventory.echostar.inventory;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

import database_manager.DatabaseItemEmulator;

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

        List<String> models = database.getAllModelNames();

        listview = (ListView) findViewById(R.id.lstViewFoundItems);
        listview.setAdapter(new ListAdapter(this, models));
     }
}
