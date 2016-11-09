package com.inventory.echostar.inventory;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by saturn on 09.11.2016.
 */
//http://stackoverflow.com/questions/15832335/android-custom-row-item-for-listview
public class ListAdapter extends BaseAdapter
{

    Context context;
    List<String> data = null;

    private static LayoutInflater inflater = null;

    public ListAdapter(Context context, List<String> data)
    {
        // TODO Auto-generated constructor stub
        this.context = context;
        this.data = data;
        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount()
    {
        // TODO Auto-generated method stub
        return data.size();
    }

    @Override
    public Object getItem(int position)
    {
        // TODO Auto-generated method stub
        return data.get(position);
    }

    @Override
    public long getItemId(int position)
    {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        // TODO Auto-generated method stub
        String model = data.get(position);
        View vi = convertView;
        if (vi == null)
            vi = inflater.inflate(R.layout.row, null);
        TextView text = (TextView) vi.findViewById(R.id.text);
        text.setText(model);
        return vi;
    }
    
    public void onItemClick(AdapterView<?> parent, View view, int position, long id)
    {
        //TODO Stub-function
        Log.i("Item","\n<<<<<<onClick>>>>\n");
    }
}