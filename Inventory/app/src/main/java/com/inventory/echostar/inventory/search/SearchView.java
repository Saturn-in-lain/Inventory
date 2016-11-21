package com.inventory.echostar.inventory.search;

import android.content.Context;
import android.content.Intent;
import android.widget.Spinner;

/**
 * Created by stas.savinov on 11/18/2016.
 */

public interface SearchView
{

    void startSearchResultActivityWithIntent(Intent intent);

    Context getSearchViewContext();

    Context getThis();

    Spinner getGlobalCategory();

    Spinner getItemsCategory();

    Spinner getItemFields();
}
