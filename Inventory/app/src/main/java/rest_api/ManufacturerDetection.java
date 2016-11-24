package rest_api;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import rest_api.location.LocationObject;
import rest_api.manufacturers.ManufacturersObject;

/**
 * Created by stas.savinov on 11/24/2016.
 */

public class ManufacturerDetection
{
    public ArrayList<ManufacturersObject> ManufacturersList;

    public String defaultResponse = "[\n" +
            "  {\n" +
            "    \"approved\": true,\n" +
            "    \"name\": \"EchoStar\",\n" +
            "    \"id\": \"c5ec86c2-d136-46d8-a040-af2137db076d\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"approved\": true,\n" +
            "    \"name\": \"Samsung\",\n" +
            "    \"id\": \"45253537-617e-4245-aed4-cd63fe023abf\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"approved\": true,\n" +
            "    \"name\": \"Apple\",\n" +
            "    \"id\": \"9b656d01-6d2d-4992-815d-5009d0f8bafa\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"approved\": true,\n" +
            "    \"name\": \"MSI\",\n" +
            "    \"id\": \"6d9eff9f-d8de-4f4f-b950-fc022c69fdb9\"\n" +
            "  }\n" +
            "]";

    public ManufacturerDetection()
    {
        ManufacturersList = new ArrayList<ManufacturersObject>();
    }

    public void GetManufacturerList()
    {
        try {
            JSONArray arr = new JSONArray(defaultResponse);

            for (int i = 0; i < arr.length(); i++)
            {
                ManufacturersObject manufacturersObject = new ManufacturersObject();

                JSONObject arr_element = arr.getJSONObject(i);

                manufacturersObject.setApproved(arr_element.getBoolean("approved"));
                manufacturersObject.setId(arr_element.getString("id"));
                manufacturersObject.setName(arr_element.getString("name"));

                ManufacturersList.add(manufacturersObject);
            }
        }
        catch (JSONException e)
        {
            Log.e("ItemsDetection", "Unexpected JSON exception", e);
        }

        //TODO: Only for test purpose
        for (int i = 0; i < ManufacturersList.size(); i++) {
            Log.i("ManufacturerDetection", "F:[ManufacturersList]: " + ManufacturersList.get(i).getName());
        }

    }
}
