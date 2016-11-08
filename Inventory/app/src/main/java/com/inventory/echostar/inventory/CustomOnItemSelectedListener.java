package com.inventory.echostar.inventory;

/**
 * Created by stas.savinov on 11/8/2016.
 * https://www.simplifiedcoding.net/android-spinner-example-to-load-json-using-volley/
 */

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Toast;

public class CustomOnItemSelectedListener implements OnItemSelectedListener
{

    public void onItemSelected(AdapterView<?> parent, View view, int pos,long id)
    {
        Toast.makeText(parent.getContext(),
                "OnItemSelectedListener : " + parent.getItemAtPosition(pos).toString(),
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0)
    {
        // TODO Auto-generated method stub
    }

}