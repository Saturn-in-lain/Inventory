package rest_api;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import rest_api.offices.OfficesObject;
import rest_api.statuses.StatusesObject;

/**
 * Created by stas.savinov on 11/24/2016.
 */

public class StatusDetection
{
    public ArrayList<StatusesObject> StatusList;

    public StatusDetection()
    {
        StatusList = new ArrayList<StatusesObject>();
    }

    public String defaultResponse = "[\n" +
            "  {\n" +
            "    \"name\": \"Broken\",\n" +
            "    \"id\": \"690f5ae3-954c-405d-9d87-ae563d436535\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\": \"Normal\",\n" +
            "    \"id\": \"e5a47b8a-f19b-43e5-b0ab-4db56166c155\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\": \"Fixed\",\n" +
            "    \"id\": \"b71fc27b-a605-4c1d-b0da-71b1653d8579\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\": \"Lost\",\n" +
            "    \"id\": \"a01dcb5e-2b34-41e1-821b-a4bd5e96a8fb\"\n" +
            "  }\n" +
            "]\n";

    public void GetStatusList()
    {
        try {
            JSONArray arr = new JSONArray(defaultResponse);

            for (int i = 0; i < arr.length(); i++)
            {
                StatusesObject statusObject = new StatusesObject();

                JSONObject arr_element = arr.getJSONObject(i);
                statusObject.setId(arr_element.getString("id"));
                statusObject.setName(arr_element.getString("name"));

                StatusList.add(statusObject);
            }
        }
        catch (JSONException e)
        {
            Log.e("ItemsDetection", "Unexpected JSON exception", e);
        }

        //TODO: Only for test purpose
        for (int i = 0; i < StatusList.size(); i++) {
            Log.i("StatusDetection", "F:[GetStatusList]: " + StatusList.get(i).getName());
        }
    }
}
