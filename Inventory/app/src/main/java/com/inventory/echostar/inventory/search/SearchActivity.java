package com.inventory.echostar.inventory.search;

import android.content.Context;
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
import com.inventory.echostar.inventory.R;


import items.ItemsHolder;

public class SearchActivity extends AppCompatActivity implements SearchView
{
    private SearchPresenter   presenter = null;
    private Spinner spnrGlobalCategory  = null;
    private Spinner spnrItemsCategory   = null;
    private Spinner sprItemField        = null;
    private EditText edtxtSearchField   = null;
    //private Button btnSearchInDatabase  = null;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        edtxtSearchField    = (EditText) findViewById(R.id.edtxtSearchField);
        //btnSearchInDatabase = (Button)findViewById(R.id.btnSearchInDatabase);

        spnrGlobalCategory = (Spinner) findViewById(R.id.sprGlobalCategory);
        spnrItemsCategory  = (Spinner) findViewById(R.id.sprItemCategory);
        sprItemField       = (Spinner) findViewById(R.id.sprItemField);

        presenter = new SearchPresenter(this);

        //##########################################################################################

        spnrGlobalCategory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id)
            {
                //Object item = parent.getItemAtPosition(pos);
                //String GlobalCategory = parent.getItemAtPosition(pos).toString();
                presenter.setCategory(parent.getSelectedItem().toString());
            }
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        //##########################################################################################

        spnrItemsCategory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id)
            {
                presenter.setSubCategory(parent.getSelectedItem().toString());
                presenter.PopulateItemsFieldList(pos);
            }
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        //##########################################################################################

        sprItemField.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id)
            {
                presenter.setItemFields(parent.getSelectedItem().toString());
            }
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        //##########################################################################################

        presenter.PopulateGlobalCategoryList();
        presenter.PopulateSubCategoryList();
    }


//##################################################################################################
    /**
     * @Function: onClickSearchInDatabase - Override method
     * @params: View
     */
    public void onClickSearchInDatabase(View view)
    {
        presenter.setSearchField(edtxtSearchField.getText().toString());
        presenter.ClickSearch();
    }

    /**
     * @Function: startMainActivityWithIntent - Override method
     * @params: None
     */
    @Override
    public void startSearchResultActivityWithIntent(Intent intent)
    {
        SearchActivity.this.startActivity(intent);
    }

    /**
     * @Function: getLoginViewContext - Override method
     * @params: None
     */
    @Override
    public Context getSearchViewContext()
    {
        return getApplicationContext();
    }

    /**
     * @Function: getGlobalCategory - Override method
     * @params: None
     */
    @Override
    public Spinner getGlobalCategory()
    {
        return spnrGlobalCategory;
    }

    /**
     * @Function: getItemsCategory - Override method
     * @params: None
     */
    @Override
    public Spinner getItemsCategory()
    {
        return spnrItemsCategory;
    }

    /**
     * @Function: getItemFields - Override method
     * @params: None
     */
    @Override
    public Spinner getItemFields()
    {
        return sprItemField;
    }

    /**
     * @Function: getThis - Override method
     * @params: None
     */
    @Override
    public Context getThis()
    {
        return this;
    }

}
