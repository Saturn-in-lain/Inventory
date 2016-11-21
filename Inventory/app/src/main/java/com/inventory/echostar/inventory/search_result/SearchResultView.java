package com.inventory.echostar.inventory.search_result;

import android.content.Context;
import android.widget.ListView;

/**
 * Created by stas.savinov on 11/21/2016.
 */

public interface SearchResultView
{
    Context getThis();

    ListView getSearchResultListView();


}
