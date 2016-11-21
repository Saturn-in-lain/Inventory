package com.inventory.echostar.inventory.search;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.ArrayAdapter;
import com.inventory.echostar.inventory.search_result.SearchResultActivity;
import items.ItemsHolder;

/**
 * Created by stas.savinov on 11/18/2016.
 */

public class SearchPresenter
{

    private SearchView view;
    private Context    ctx;

    private String Category;
    private String SubCategory;
    private String ItemsField;
    private String SearchField;

    private final String LOG = "Search Activity";

    /**
     * @Constructor: SearchPresenter
     * @param
     */
    public SearchPresenter(SearchView view)
    {
        this.view = view;
        this.ctx = view.getSearchViewContext();
    }

    /**
     * @Function: ClickSearch
     * @params:
     */
    public void ClickSearch()
    {
        Intent intent = new Intent(view.getSearchViewContext(), SearchResultActivity.class);
        view.startSearchResultActivityWithIntent(intent);
    }

    /**
     * @Function: PopulateGlobalCategoryList
     * @params:
     */
    public void PopulateGlobalCategoryList()
    {
        ItemsHolder info = new ItemsHolder();
        view.getGlobalCategory().setAdapter(new ArrayAdapter<String>(view.getThis(),
                                android.R.layout.simple_spinner_dropdown_item,
                                info.getBaseList()));
    }

    /**
     * @Function: PopulateSubCategoryList
     * @params:
     */
    public void PopulateSubCategoryList()
    {
        ItemsHolder info = new ItemsHolder();
        view.getItemsCategory().setAdapter(new ArrayAdapter<String>(view.getThis(),
                                           android.R.layout.simple_spinner_dropdown_item,
                                           info.getSubcategoryList()));
    }

    /**
     * @Function: PopulateItemsFieldList
     * @params: int
     */
    public void PopulateItemsFieldList(int position)
    {
        ItemsHolder info = new ItemsHolder();
        view.getItemFields().setAdapter(new ArrayAdapter<String>(view.getThis(),
                                        android.R.layout.simple_spinner_dropdown_item,
                                        info.getItemFieldsList(position)));
    }

    /**
     * @Function:
     * @params: String
     */
    public void setCategory(String data)
    {
        this.Category = data;
        Log.i(LOG,"F:[setCategory] selected item>> " + data);
    }

    /**
     * @Function:
     * @params: String
     */
    public void setSubCategory(String data)
    {
        this.SubCategory = data;
        Log.i(LOG,"F:[setSubCategory] selected item>> " + data);
    }

    /**
     * @Function:
     * @params: String
     */
    public void setItemFields(String data)
    {
        this.ItemsField = data;
        Log.i(LOG,"F:[setItemFields] selected item>> " + data);
    }

    /**
     * @Function:
     * @params: String
     */
    public void setSearchField(String data)
    {
        this.SearchField = data;
        Log.i(LOG,"F:[setSearchField] selected item>> " + data);
    }

}
