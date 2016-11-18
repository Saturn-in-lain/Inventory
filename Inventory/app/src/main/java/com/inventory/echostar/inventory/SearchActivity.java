package com.inventory.echostar.inventory;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

import items.ItemsHolder;

public class SearchActivity extends AppCompatActivity
{
    private final String LOG = "Search Activity";
    private Spinner spnrGlobalCategory  = null;
    private Spinner spnrItemsCategory   = null;
    private Spinner sprItemField        = null;
    private EditText edtxtSearchField   = null;
    private Button btnSearchInDatabase  = null;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);


        edtxtSearchField    = (EditText) findViewById(R.id.edtxtSearchField);
        btnSearchInDatabase = (Button)findViewById(R.id.btnSearchInDatabase);

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
        //##########################################################################################
        spnrItemsCategory = (Spinner) findViewById(R.id.sprItemCategory);
        spnrItemsCategory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id)
            {
                Object item = parent.getItemAtPosition(pos);
                String GlobalCategory = parent.getItemAtPosition(pos).toString();
                Log.i(LOG,"F:[spnrItemsCategory] selected item>> " + parent.getSelectedItem());

                //TODO: Here we will add item fields
                addItemsOnItemFields(pos);

            }
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        //##########################################################################################
        sprItemField        = (Spinner) findViewById(R.id.sprItemField);
        sprItemField.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id)
            {
                Object item = parent.getItemAtPosition(pos);
                String GlobalCategory = parent.getItemAtPosition(pos).toString();
                Log.i(LOG,"F:[sprItemField] selected item>> " + parent.getSelectedItem()
                        + " position: " + pos);

            }
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        //##########################################################################################

        addItemsOnCategory();
        addItemsOnSubCategory(0);

        //##########################################################################################

        btnSearchInDatabase.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(SearchActivity.this, SearchResultActivity.class);
                SearchActivity.this.startActivity(intent);
            }
        });
    }

    private void addItemsOnCategory()
    {
        ArrayList<String> Category = new ArrayList<String>();
        Category.add("Equipment");
        Category.add("Books");
        ItemsHolder info = new ItemsHolder();

        spnrGlobalCategory.setAdapter(new ArrayAdapter<String>(this,
                                        android.R.layout.simple_spinner_dropdown_item,
                                        info.getBaseList()));
    }

    private void addItemsOnSubCategory(int position)
    {
        ItemsHolder info = new ItemsHolder();
        spnrItemsCategory.setAdapter(new ArrayAdapter<String>(this,
                                                android.R.layout.simple_spinner_dropdown_item,
                                                info.getSubcategoryList()));
    }

    //
    private void addItemsOnItemFields(int position)
    {
        ItemsHolder info = new ItemsHolder();
        sprItemField.setAdapter(new ArrayAdapter<String>(this,
                                                android.R.layout.simple_spinner_dropdown_item,
                                                info.getItemFieldsList(position)));
    }
}
