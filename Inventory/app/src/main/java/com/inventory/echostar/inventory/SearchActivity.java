package com.inventory.echostar.inventory;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity
{
    private final String LOG = "Search Activity";
    private Spinner spnrGlobalCategory = null;
    private Spinner spnrItemsCategory = null;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        //##########################################################################################

        spnrGlobalCategory = (Spinner) findViewById(R.id.sprGlobalCategory);
        spnrGlobalCategory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id)
            {
                Object item = parent.getItemAtPosition(pos);
                String GlobalCategory = parent.getItemAtPosition(pos).toString();
                Log.i(LOG,"F:[spnrGlobalCategory] selected item>> " + parent.getSelectedItem());
            }
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        spnrItemsCategory = (Spinner) findViewById(R.id.sprItemCategory);
        spnrItemsCategory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id)
            {
                Object item = parent.getItemAtPosition(pos);
                String GlobalCategory = parent.getItemAtPosition(pos).toString();
                Log.i(LOG,"F:[spnrItemsCategory] selected item>> " + parent.getSelectedItem());
            }
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        //##########################################################################################
        addItemsOnCategory();
        addItemsOnSubCategory(0);
        //##########################################################################################
    }

    private void addItemsOnCategory()
    {
        ArrayList<String> Category = new ArrayList<String>();
        Category.add("Equipment");
        Category.add("Books");

        spnrGlobalCategory.setAdapter(new ArrayAdapter<String>(this,
                                        android.R.layout.simple_spinner_dropdown_item,
                                        Category));
    }

    private void addItemsOnSubCategory(int position)
    {
        ArrayList<String> subCategory = new ArrayList<String>();
        subCategory.add("1");
        subCategory.add("2");
        subCategory.add("3");
        subCategory.add("4");

        spnrItemsCategory.setAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_dropdown_item,
                subCategory));
    }

}
