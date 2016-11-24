package rest_api;

import android.util.Log;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import rest_api.location.LocationObject;

/**
 * Created by stas.savinov on 11/24/2016.
 */

public class LocationDetection
{
    public ArrayList<LocationObject> LocationList;

    public String defaultResponse = "[\n" +
            "  {\n" +
            "    \"name\": \"Lab 10\",\n" +
            "    \"id\": \"72dd3e6b-7fc5-40d5-b7a8-4537eff7c485\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\": \"Lab 8\",\n" +
            "    \"id\": \"37d9443f-9585-4bda-a857-252d16f72f26\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\": \"Lab 16\",\n" +
            "    \"id\": \"1269c9de-a71f-4585-8db6-ecec9ac27482\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\": \"Lab 27\",\n" +
            "    \"id\": \"3b3d6e8c-07ef-4e17-9826-defff9900e79\"\n" +
            "  }\n" +
            "]";

    public LocationDetection()
    {
        LocationList = new ArrayList<LocationObject>();
    }

    public void GetLocationList()
    {
        try {
            JSONArray arr = new JSONArray(defaultResponse);

            for (int i = 0; i < arr.length(); i++)
            {
                LocationObject locationObject = new LocationObject();

                JSONObject arr_element = arr.getJSONObject(i);

                locationObject.setName(arr_element.getString("name"));
                locationObject.setId(arr_element.getString("id"));

                LocationList.add(locationObject);
            }
        }
        catch (JSONException e)
        {
            Log.e("ItemsDetection", "Unexpected JSON exception", e);
        }

        //TODO: Only for test purpose
        for (int i = 0; i < LocationList.size(); i++) {
            Log.i("LocationDetection", "F:[LocationList]: " + LocationList.get(i).getName());
        }

    }
}