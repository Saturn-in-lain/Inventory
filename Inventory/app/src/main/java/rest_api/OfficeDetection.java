package rest_api;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import rest_api.models.ModelsObject;
import rest_api.offices.OfficesObject;

/**
 * Created by stas.savinov on 11/24/2016.
 */

public class OfficeDetection
{
    public ArrayList<OfficesObject> OfficeList;

    public OfficeDetection()
    {
        OfficeList = new ArrayList<OfficesObject>();
    }

    public String defaultResponse = "[\n" +
            "  {\n" +
            "    \"name\": \"Kharkiv\",\n" +
            "    \"id\": \"56b987f4-3b59-4d6e-89cd-32e5543fdbda\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\": \"Bangalore\",\n" +
            "    \"id\": \"3489c1fe-5596-481b-a11e-b5eb579e8d93\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\": \"Denver\",\n" +
            "    \"id\": \"4d6416c5-1b66-41f5-9255-6e1cc7c49bb0\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\": \"Equip in Ilch house\",\n" +
            "    \"id\": \"957b0493-2d1d-49b8-ac65-70c75133ee11\"\n" +
            "  }\n" +
            "]";

    public void GetOfficeList()
    {
        try {
            JSONArray arr = new JSONArray(defaultResponse);

            for (int i = 0; i < arr.length(); i++)
            {
                OfficesObject modelObject = new OfficesObject();

                JSONObject arr_element = arr.getJSONObject(i);
                modelObject.setId(arr_element.getString("id"));
                modelObject.setName(arr_element.getString("name"));
                OfficeList.add(modelObject);
            }
        }
        catch (JSONException e)
        {
            Log.e("ItemsDetection", "Unexpected JSON exception", e);
        }

        //TODO: Only for test purpose
        for (int i = 0; i < OfficeList.size(); i++) {
            Log.i("OfficeDetection", "F:[GetOfficeList]: " + OfficeList.get(i).getName());
        }
    }

}
