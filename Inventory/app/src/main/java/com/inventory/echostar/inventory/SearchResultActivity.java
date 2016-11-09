package com.inventory.echostar.inventory;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import database_manager.DatabaseItemEmulator;


public class SearchResultActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result);

        DatabaseItemEmulator database = new DatabaseItemEmulator(this);
        database.initializeDefaultItemDataBase();
        database.typeAllDataBaseCredentials();

    }
}
