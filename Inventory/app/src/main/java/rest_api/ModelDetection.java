package rest_api;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import rest_api.manufacturers.ManufacturersObject;
import rest_api.models.ModelsObject;

/**
 * Created by stas.savinov on 11/24/2016.
 */

public class ModelDetection
{
    public ArrayList<ModelsObject> ModelsList;

    public ModelDetection()
    {
        ModelsList = new ArrayList<ModelsObject>();
    }

    public String defaultResponse = "[\n" +
            "  {\n" +
            "    \"approved\": true,\n" +
            "    \"name\": \"iPhone 6\",\n" +
            "    \"id\": \"91b87c49-4fea-437c-9eab-2dadb9f35fd6\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"approved\": true,\n" +
            "    \"name\": \"iPhone 6S\",\n" +
            "    \"id\": \"dfe0bc96-7846-4fc7-b268-4bc8cc8698ad\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"approved\": true,\n" +
            "    \"name\": \"iPhone 7\",\n" +
            "    \"id\": \"28c4c4dd-a9cb-42c3-841d-85b3e6bd49eb\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"approved\": true,\n" +
            "    \"name\": \"Galaxy 7\",\n" +
            "    \"id\": \"6b91ce05-8a2c-48e5-bf63-93840411de4c\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"approved\": true,\n" +
            "    \"name\": \"Galaxy 7 Edge\",\n" +
            "    \"id\": \"d865bc2d-7f0f-48ca-9c0d-31b212a83d8d\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"approved\": true,\n" +
            "    \"name\": \"Galaxy Note 7\",\n" +
            "    \"id\": \"3746f20f-6314-40c9-9265-8ee6591f0022\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"approved\": true,\n" +
            "    \"name\": \"Google Pixel\",\n" +
            "    \"id\": \"82391478-3dfa-4c2d-9630-6be2cca6f1fd\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"approved\": true,\n" +
            "    \"name\": \"iPhone 6S Plus\",\n" +
            "    \"id\": \"c93df312-44eb-4fea-b2e3-16678e65dd0f\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"approved\": true,\n" +
            "    \"name\": \"XiP913\",\n" +
            "    \"id\": \"8aadf383-78bb-4428-a47e-0afcd63c9731\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"approved\": true,\n" +
            "    \"name\": \"\\\\\\\\ясчячс\",\n" +
            "    \"id\": \"3ab676f2-e5e2-429f-9888-ba2f9a668553\"\n" +
            "  }\n" +
            "]";

    public void GetModelList()
    {
        try {
            JSONArray arr = new JSONArray(defaultResponse);

            for (int i = 0; i < arr.length(); i++)
            {
                ModelsObject modelObject = new ModelsObject();

                JSONObject arr_element = arr.getJSONObject(i);

                modelObject.setApproved(arr_element.getBoolean("approved"));
                modelObject.setId(arr_element.getString("id"));
                modelObject.setName(arr_element.getString("name"));

                ModelsList.add(modelObject);
            }
        }
        catch (JSONException e)
        {
            Log.e("ItemsDetection", "Unexpected JSON exception", e);
        }

        //TODO: Only for test purpose
        for (int i = 0; i < ModelsList.size(); i++) {
            Log.i("ModelDetection", "F:[GetModelList]: " + ModelsList.get(i).getName());
        }
    }

}
