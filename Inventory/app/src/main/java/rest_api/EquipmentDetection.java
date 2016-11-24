package rest_api;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Date;

import rest_api.categories.CategoryField;
import rest_api.categories.CategoryObject;
import rest_api.categories.CategoryType;
import rest_api.equipment.EquipmentObject;

/**
 * Created by stas.savinov on 11/24/2016.
 */

public class EquipmentDetection
{
    public ArrayList<EquipmentObject> EquipmentObjectList = null;

    public EquipmentDetection()
    {
        EquipmentObjectList = new  ArrayList<EquipmentObject>();
    }

    public String defaultResponse = "[\n" +
        "        {\n" +
        "        \"category\": \"bb8de681-3af9-48fb-9325-03d3a369cd9b\",\n" +
        "        \"owner\": \"00000000-0000-0000-0000-000000000000\",\n" +
        "        \"location\": \"37d9443f-9585-4bda-a857-252d16f72f26\",\n" +
        "        \"office\": \"56b987f4-3b59-4d6e-89cd-32e5543fdbda\",\n" +
        "        \"creator\": \"00000000-0000-0000-0000-000000000000\",\n" +
        "        \"version\": 2147483647,\n" +
        "        \"serial\": \"123\",\n" +
        "        \"bar\": \"123\",\n" +
        "        \"accountingCode\": 123,\n" +
        "        \"comment\": \"Something should be in here\",\n" +
        "        \"modified\": \"2016-11-17T15:34:41.141Z\",\n" +
        "        \"state\": \"a01dcb5e-2b34-41e1-821b-a4bd5e96a8fb\",\n" +
        "        \"guaranteeExpiration\": \"0001-01-01T00:00:00Z\",\n" +
        "        \"parent\": \"23ea9950-a045-4a9c-a488-50bec66e2ff8\",\n" +
        "        \"id\": \"23ea9950-a045-4a9c-a488-50bec66e2ff8\",\n" +
        "        \"secure\": true,\n" +
        "        \"model\": \"8aadf383-78bb-4428-a47e-0afcd63c9731\",\n" +
        "        \"manufacturer\": \"c5ec86c2-d136-46d8-a040-af2137db076d\",\n" +
        "        \"receiverId\": \"159357\"\n" +
        "        },\n" +
        "        {\n" +
        "        \"category\": \"bb8de681-3af9-48fb-9325-03d3a369cd9b\",\n" +
        "        \"owner\": \"00000000-0000-0000-0000-000000000000\",\n" +
        "        \"location\": \"37d9443f-9585-4bda-a857-252d16f72f26\",\n" +
        "        \"office\": \"56b987f4-3b59-4d6e-89cd-32e5543fdbda\",\n" +
        "        \"creator\": \"00000000-0000-0000-0000-000000000000\",\n" +
        "        \"version\": 2147483647,\n" +
        "        \"serial\": \"123\",\n" +
        "        \"bar\": \"123\",\n" +
        "        \"accountingCode\": 123,\n" +
        "        \"comment\": \"Something should be in here\",\n" +
        "        \"modified\": \"2016-11-22T11:08:20.129Z\",\n" +
        "        \"state\": \"a01dcb5e-2b34-41e1-821b-a4bd5e96a8fb\",\n" +
        "        \"guaranteeExpiration\": \"0001-01-01T00:00:00Z\",\n" +
        "        \"parent\": \"7aad4fa9-8a78-4305-be22-de15e4ba4fad\",\n" +
        "        \"id\": \"7aad4fa9-8a78-4305-be22-de15e4ba4fad\",\n" +
        "        \"secure\": true,\n" +
        "        \"model\": \"8aadf383-78bb-4428-a47e-0afcd63c9731\",\n" +
        "        \"manufacturer\": \"c5ec86c2-d136-46d8-a040-af2137db076d\",\n" +
        "        \"receiverId\": \"159357\"\n" +
        "        },\n" +
        "        {\n" +
        "        \"category\": \"bb8de681-3af9-48fb-9325-03d3a369cd9b\",\n" +
        "        \"owner\": \"00000000-0000-0000-0000-000000000000\",\n" +
        "        \"location\": \"37d9443f-9585-4bda-a857-252d16f72f26\",\n" +
        "        \"office\": \"56b987f4-3b59-4d6e-89cd-32e5543fdbda\",\n" +
        "        \"creator\": \"00000000-0000-0000-0000-000000000000\",\n" +
        "        \"version\": 2147483647,\n" +
        "        \"serial\": \"123\",\n" +
        "        \"bar\": \"123\",\n" +
        "        \"accountingCode\": 123,\n" +
        "        \"comment\": \"Something should be in here\",\n" +
        "        \"modified\": \"2016-11-22T11:08:24.789Z\",\n" +
        "        \"state\": \"a01dcb5e-2b34-41e1-821b-a4bd5e96a8fb\",\n" +
        "        \"guaranteeExpiration\": \"0001-01-01T00:00:00Z\",\n" +
        "        \"parent\": \"9fbd18cb-52a0-4d8d-b53e-ec70042e7942\",\n" +
        "        \"id\": \"9fbd18cb-52a0-4d8d-b53e-ec70042e7942\",\n" +
        "        \"secure\": true,\n" +
        "        \"model\": \"8aadf383-78bb-4428-a47e-0afcd63c9731\",\n" +
        "        \"manufacturer\": \"c5ec86c2-d136-46d8-a040-af2137db076d\",\n" +
        "        \"receiverId\": \"159357\"\n" +
        "        },\n" +
        "        {\n" +
        "        \"category\": \"bb8de681-3af9-48fb-9325-03d3a369cd9b\",\n" +
        "        \"owner\": \"00000000-0000-0000-0000-000000000000\",\n" +
        "        \"location\": \"37d9443f-9585-4bda-a857-252d16f72f26\",\n" +
        "        \"office\": \"56b987f4-3b59-4d6e-89cd-32e5543fdbda\",\n" +
        "        \"creator\": \"00000000-0000-0000-0000-000000000000\",\n" +
        "        \"version\": 2147483647,\n" +
        "        \"serial\": \"123\",\n" +
        "        \"bar\": \"123\",\n" +
        "        \"accountingCode\": 124,\n" +
        "        \"comment\": \"Something should be in here\",\n" +
        "        \"modified\": \"2016-11-22T11:28:01.724Z\",\n" +
        "        \"state\": \"a01dcb5e-2b34-41e1-821b-a4bd5e96a8fb\",\n" +
        "        \"guaranteeExpiration\": \"0001-01-01T00:00:00Z\",\n" +
        "        \"parent\": \"8f17ca1e-a0fa-4326-9347-f17e4605d218\",\n" +
        "        \"id\": \"8f17ca1e-a0fa-4326-9347-f17e4605d218\",\n" +
        "        \"secure\": false,\n" +
        "        \"model\": \"8aadf383-78bb-4428-a47e-0afcd63c9731\",\n" +
        "        \"manufacturer\": \"c5ec86c2-d136-46d8-a040-af2137db076d\",\n" +
        "        \"receiverId\": \"159358\"\n" +
        "        },\n" +
        "        {\n" +
        "        \"category\": \"bb8de681-3af9-48fb-9325-03d3a369cd9b\",\n" +
        "        \"owner\": \"00000000-0000-0000-0000-000000000000\",\n" +
        "        \"location\": \"37d9443f-9585-4bda-a857-252d16f72f26\",\n" +
        "        \"office\": \"56b987f4-3b59-4d6e-89cd-32e5543fdbda\",\n" +
        "        \"creator\": \"00000000-0000-0000-0000-000000000000\",\n" +
        "        \"version\": 2147483647,\n" +
        "        \"serial\": \"123\",\n" +
        "        \"bar\": \"123\",\n" +
        "        \"accountingCode\": 124,\n" +
        "        \"comment\": \"Something should be in here\",\n" +
        "        \"modified\": \"2016-11-22T11:28:18.756Z\",\n" +
        "        \"state\": \"a01dcb5e-2b34-41e1-821b-a4bd5e96a8fb\",\n" +
        "        \"guaranteeExpiration\": \"0001-01-01T00:00:00Z\",\n" +
        "        \"parent\": \"5e8ea0df-9436-47a8-83ab-b706d9318998\",\n" +
        "        \"id\": \"5e8ea0df-9436-47a8-83ab-b706d9318998\",\n" +
        "        \"secure\": false,\n" +
        "        \"model\": \"8aadf383-78bb-4428-a47e-0afcd63c9731\",\n" +
        "        \"manufacturer\": \"c5ec86c2-d136-46d8-a040-af2137db076d\",\n" +
        "        \"receiverId\": \"159358\"\n" +
        "        }\n" +
        "        ]";

    public void GetEquipmentList()
    {
        try
        {
            JSONArray arr = new JSONArray(defaultResponse);


            for (int i = 0; i < arr.length(); i++)
            {
                EquipmentObject equimpentObject = new EquipmentObject();

                JSONObject arr_element = arr.getJSONObject(i);

                equimpentObject.setCategory(arr_element.getString("category"));
                equimpentObject.setOwner(arr_element.getString("owner"));
                equimpentObject.setLocation((arr_element.getString("location")));
                equimpentObject.setOffice((arr_element.getString("office")));
                equimpentObject.setCreator((arr_element.getString("creator")));
                equimpentObject.setVersion((arr_element.getInt("version")));
                equimpentObject.setSerial((arr_element.getString("serial")));
                equimpentObject.setBar((arr_element.getString("bar")));
                equimpentObject.setAccountingCode((arr_element.getInt("accountingCode")));
                equimpentObject.setComment((arr_element.getString("comment")));

                String date1 = (arr_element.getString("modified"));
                Date modifyDate = new Date();
                //equimpentObject.setModified(modifyDate);

                String date2 = (arr_element.getString("guaranteeExpiration"));
                Date guaranty = new Date();
                //equimpentObject.setGuaranteeExpiration();

                equimpentObject.setState((arr_element.getString("state")));
                equimpentObject.setParent((arr_element.getString("parent")));
                equimpentObject.setId((arr_element.getString("id")));
                equimpentObject.setSecure((arr_element.getBoolean("secure")));
                equimpentObject.setModel((arr_element.getString("model")));
                equimpentObject.setManufacturer((arr_element.getString("manufacturer")));
                equimpentObject.setReceiverId((arr_element.getString("receiverId")));

                EquipmentObjectList.add(equimpentObject);
            }
        }
        catch (JSONException e)
        {
            Log.e("ItemsDetection", "Unexpected JSON exception", e);
        }

        //TODO: Only for test purpose
        for (int i=0; i <EquipmentObjectList.size(); i++)
        {
            Log.i("EquipmentDetection", "F:[GetEquipmentList]: " + EquipmentObjectList.get(i).getComment());
        }


    }


}
