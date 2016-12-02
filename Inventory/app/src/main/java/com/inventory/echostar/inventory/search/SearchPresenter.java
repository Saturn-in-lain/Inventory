package com.inventory.echostar.inventory.search;

import android.content.Context;
import android.content.Intent;
import android.widget.ArrayAdapter;
import com.inventory.echostar.inventory.search_result.SearchResultActivity;
import java.util.ArrayList;
import items.ItemsHolder;
import rest_api.EquipmentDetection;
import rest_api.ItemsDetection;
import rest_api.LocationDetection;
import rest_api.ManufacturerDetection;
import rest_api.ModelDetection;
import rest_api.OfficeDetection;
import rest_api.StatusDetection;

/**
 * Created by stas.savinov on 11/18/2016.
 */

public class SearchPresenter
{

    private SearchView view;
    private Context ctx;

    public String Category;
    public String SubCategory;
    public String ItemsField;
    public String SearchField;

    public ItemsDetection search;

    private final String LOG = "Search Activity";

    /**
     * @Constructor: SearchPresenter
     * @param
     */
    public SearchPresenter(SearchView view)
    {
        this.view = view;
        this.ctx = view.getSearchViewContext();

        this.search = new ItemsDetection();

    }

    /**
     * @Function: ClickSearch
     * @params:
     */
    public void ClickSearch()
    {

        //######################################################################3
        //TODO Remove after test
        EquipmentDetection eq = new EquipmentDetection();
        eq.GetEquipmentList();

        LocationDetection loc = new LocationDetection();
        loc.GetLocationList();

        ManufacturerDetection man = new ManufacturerDetection();
        man.GetManufacturerList();

        ModelDetection model = new ModelDetection();
        model.GetModelList();

        OfficeDetection office = new OfficeDetection();
        office.GetOfficeList();

        StatusDetection status = new StatusDetection();
        status.GetStatusList();

        //######################################################################3

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
        //ItemsHolder info = new ItemsHolder();
        //info.getSubcategoryList()

        ArrayList<String> subCategory = this.search.getSubCategoriesList(view.getThis());

        view.getItemsCategory().setAdapter(new ArrayAdapter<String>(view.getThis(),
                                           android.R.layout.simple_spinner_dropdown_item,
                                           subCategory));
    }

    /**
     * @Function: PopulateItemsFieldList
     * @params: int
     */
    public void PopulateItemsFieldList(int position)
    {
        //ItemsHolder info = new ItemsHolder();
        //info.getItemFieldsList(position)

        ArrayList<String> subCategory = this.search.getSubCategoryFieldsList(position);

        view.getItemFields().setAdapter(new ArrayAdapter<String>(view.getThis(),
                                        android.R.layout.simple_spinner_dropdown_item,
                                        subCategory));

    }

    /**
     * @Function:
     * @params: String
     */
    public void setCategory(String data)
    {
        this.Category = data;
        //Log.i(LOG,"F:[setCategory] selected item>> " + data);
    }

    /**
     * @Function:
     * @params: String
     */
    public void setSubCategory(String data)
    {
        this.SubCategory = data;
        //Log.i(LOG,"F:[setSubCategory] selected item>> " + data);
    }

    /**
     * @Function:
     * @params: String
     */
    public void setItemFields(String data)
    {
        this.ItemsField = data;
        //Log.i(LOG,"F:[setItemFields] selected item>> " + data);
    }

    /**
     * @Function:
     * @params: String
     */
    public void setSearchField(String data)
    {
        this.SearchField = data;
        //Log.i(LOG,"F:[setSearchField] selected item>> " + data);
    }

}
