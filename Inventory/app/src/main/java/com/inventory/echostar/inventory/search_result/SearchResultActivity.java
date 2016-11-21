package com.inventory.echostar.inventory.search_result;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.inventory.echostar.inventory.R;


public class SearchResultActivity extends AppCompatActivity implements SearchResultView
{
    private ListView listview;
    private SearchResultPresenter presenter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result);

        listview = (ListView) findViewById(R.id.lstViewFoundItems);
        presenter = new SearchResultPresenter(this);
        presenter.setSearchResultList();

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
//                Intent intent = new Intent(SearchResultActivity.this, ItemDescriptionActivity.class);
                Intent intent = presenter.openItemDescriptionActivity(position);
                SearchResultActivity.this.startActivity(intent);
            }
        });

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

    /**
     * @Function: getSearchResultListView
     * @params: None
     */
    @Override
    public ListView getSearchResultListView()
    {
        return listview;
    }
}

