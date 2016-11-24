package rest_api;

import android.content.Context;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import items.RESTRequests;
import rest_api.categories.CategoryField;
import rest_api.categories.CategoryObject;
import rest_api.categories.CategoryType;

/**
 * Created by stas.savinov on 11/23/2016.
 * http://androiddocs.ru/parsing-json-poluchaem-i-razbiraem-json-s-vneshnego-resursa/
 */

public class ItemsDetection
{

    /**
     * @Constructor:
     * @Description: This class will retrieve information about categories and all
     * fields for it.
     */

    public ArrayList<CategoryObject> CategoryObjectList;

    public ItemsDetection()
    {
        CategoryObjectList = new ArrayList<CategoryObject>();
    }


    /**
     * @Function: getSubCategoriesList
     * @Descriprion:
     * @param: ArrayList String
     */
    public ArrayList<String> getSubCategoriesList(Context ctx)
    {
        ArrayList<String> returnSubCategoryList = new ArrayList<String>();

        //RESTRequests request     = new RESTRequests(ctx);
        //JSONObject   jsonRequest = null;
        //String       url_addon   = "categories";
        //String response = request.GETRequestSend(ctx, url_addon, jsonRequest);

        //Mocking request while no connection to local server currently possible.
        //------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        String response = "[{\"pic\":\"00000000-0000-0000-0000-000000000000\",\"fields\":[{\"order\":1,\"caption\":\"Manufacturer\",\"fieldName\":\"manufacturer\",\"type\":{\"$type\":\"ApprovableLookupFieldType\",\"collection\":\"manufacturers\",\"field\":\"name\"}},{\"order\":2,\"caption\":\"Model\",\"fieldName\":\"model\",\"type\":{\"$type\":\"ApprovableLookupFieldType\",\"collection\":\"models\",\"field\":\"name\"}},{\"order\":3,\"caption\":\"Receiver CA ID\",\"fieldName\":\"receiverId\",\"type\":{\"$type\":\"StringFieldType\"}},{\"order\":4,\"caption\":\"Secure\",\"fieldName\":\"secure\",\"type\":{\"$type\":\"BooleanFieldType\"}}],\"name\":\"STB\",\"id\":\"bb8de681-3af9-48fb-9325-03d3a369cd9b\"}," +
                           "{\"pic\":\"00000000-0000-0000-0000-000000000000\",\"fields\":[{\"order\":1,\"caption\":\"Manufacturer\",\"fieldName\":\"manufacturer\",\"type\":{\"$type\":\"ApprovableLookupFieldType\",\"collection\":\"manufacturers\",\"field\":\"name\"}},{\"order\":2,\"caption\":\"Model\",\"fieldName\":\"model\",\"type\":{\"$type\":\"ApprovableLookupFieldType\",\"collection\":\"models\",\"field\":\"name\"}}],\"name\":\"Debug tools\",\"id\":\"4f31437d-8645-4acb-9d6c-ba0b9aca530b\"}," +
                           "{\"pic\":\"00000000-0000-0000-0000-000000000000\",\"fields\":[{\"order\":1,\"caption\":\"Manufacturer\",\"fieldName\":\"manufacturer\",\"type\":{\"$type\":\"ApprovableLookupFieldType\",\"collection\":\"manufacturers\",\"field\":\"name\"}},{\"order\":2,\"caption\":\"Model\",\"fieldName\":\"model\",\"type\":{\"$type\":\"ApprovableLookupFieldType\",\"collection\":\"models\",\"field\":\"name\"}}],\"name\":\"TV\",\"id\":\"8160e0fd-b3d5-47d0-b7b4-f7e78dadb379\"}," +
                           "{\"pic\":\"00000000-0000-0000-0000-000000000000\",\"fields\":[{\"order\":1,\"caption\":\"Manufacturer\",\"fieldName\":\"manufacturer\",\"type\":{\"$type\":\"ApprovableLookupFieldType\",\"collection\":\"manufacturers\",\"field\":\"name\"}},{\"order\":2,\"caption\":\"Model\",\"fieldName\":\"model\",\"type\":{\"$type\":\"ApprovableLookupFieldType\",\"collection\":\"models\",\"field\":\"name\"}}],\"name\":\"RCU\",\"id\":\"bacdb615-1f2e-43fa-aed1-59fb49812895\"}," +
                           "{\"pic\":\"00000000-0000-0000-0000-000000000000\",\"fields\":[{\"order\":1,\"caption\":\"Serial number\",\"fieldName\":\"serial\",\"type\":{\"$type\":\"StringFieldType\"}},{\"order\":2,\"caption\":\"Service provider\",\"fieldName\":\"serviceProvider\",\"type\":{\"$type\":\"EditableLookupFieldType\",\"collection\":\"serviceProviders\",\"field\":\"name\"}}],\"name\":\"Smartcard\",\"id\":\"99e30bae-7074-4bf6-a1af-3ea3c6175d26\"}," +
                           "{\"pic\":\"00000000-0000-0000-0000-000000000000\",\"fields\":[{\"order\":1,\"caption\":\"Manufacturer\",\"fieldName\":\"manufacturer\",\"type\":{\"$type\":\"ApprovableLookupFieldType\",\"collection\":\"manufacturers\",\"field\":\"name\"}},{\"order\":2,\"caption\":\"Model\",\"fieldName\":\"model\",\"type\":{\"$type\":\"ApprovableLookupFieldType\",\"collection\":\"models\",\"field\":\"name\"}},{\"order\":3,\"caption\":\"Storage type\",\"fieldName\":\"type\",\"type\":{\"$type\":\"CheckBoxArrayFieldType\",\"items\":[\"External HDD\",\"Internal HDD\",\"Flash drive\",\"Mobile rack\"]}},{\"order\":4,\"caption\":\"Capacity (GB)\",\"fieldName\":\"capacity\",\"type\":{\"$type\":\"IntFieldType\"}},{\"order\":5,\"caption\":\"Interfaces\",\"fieldName\":\"interfaces\",\"type\":{\"$type\":\"CheckBoxArrayFieldType\",\"items\":[\"USB\",\"mini-USB\",\"eSATA\",\"SATA\",\"IDE\"]}}],\"name\":\"Storage drive\",\"id\":\"d789b0cd-e85f-47f1-9ec3-8adae1aa1033\"}," +
                           "{\"pic\":\"00000000-0000-0000-0000-000000000000\",\"fields\":[{\"order\":1,\"caption\":\"Manufacturer\",\"fieldName\":\"manufacturer\",\"type\":{\"$type\":\"ApprovableLookupFieldType\",\"collection\":\"manufacturers\",\"field\":\"name\"}},{\"order\":2,\"caption\":\"Model\",\"fieldName\":\"model\",\"type\":{\"$type\":\"ApprovableLookupFieldType\",\"collection\":\"models\",\"field\":\"name\"}},{\"order\":3,\"caption\":\"Type\",\"fieldName\":\"type\",\"type\":{\"$type\":\"EditableLookupFieldType\",\"collection\":\"testEquipmentType\",\"field\":\"name\"}}],\"name\":\"Test equipment\",\"id\":\"a309e557-d762-4986-a90a-7670ea2dbf24\"}," +
                           "{\"pic\":\"00000000-0000-0000-0000-000000000000\",\"fields\":[{\"order\":1,\"caption\":\"Title\",\"fieldName\":\"title\",\"type\":{\"$type\":\"StringFieldType\"}},{\"order\":2,\"caption\":\"Length (m)\",\"fieldName\":\"length\",\"type\":{\"$type\":\"FloatFieldType\"}}],\"name\":\"Cable\",\"id\":\"62d3bb6e-6b47-4dd1-90e6-3ad1cd3a0de2\"}," +
                           "{\"pic\":\"00000000-0000-0000-0000-000000000000\",\"fields\":[{\"order\":1,\"caption\":\"Title\",\"fieldName\":\"title\",\"type\":{\"$type\":\"StringFieldType\"}}],\"name\":\"Adapter\",\"id\":\"17713198-29da-4479-bd74-0c709cb40915\"}," +
                           "{\"pic\":\"00000000-0000-0000-0000-000000000000\",\"fields\":[{\"order\":1,\"caption\":\"Manufacturer\",\"fieldName\":\"manufacturer\",\"type\":{\"$type\":\"ApprovableLookupFieldType\",\"collection\":\"manufacturers\",\"field\":\"name\"}},{\"order\":2,\"caption\":\"Model\",\"fieldName\":\"model\",\"type\":{\"$type\":\"ApprovableLookupFieldType\",\"collection\":\"models\",\"field\":\"name\"}}],\"name\":\"Video capture card\",\"id\":\"fe0a0ceb-afce-45c9-ac2a-757e2bbe35cb\"}," +
                           "{\"pic\":\"00000000-0000-0000-0000-000000000000\",\"fields\":[{\"order\":1,\"caption\":\"Title\",\"fieldName\":\"title\",\"type\":{\"$type\":\"StringFieldType\"}}],\"name\":\"SAGE\",\"id\":\"c45d5a69-8d7d-4c7c-b302-30a24502a420\"}," +
                           "{\"pic\":\"00000000-0000-0000-0000-000000000000\",\"fields\":[{\"order\":1,\"caption\":\"Manufacturer\",\"fieldName\":\"manufacturer\",\"type\":{\"$type\":\"ApprovableLookupFieldType\",\"collection\":\"manufacturers\",\"field\":\"name\"}},{\"order\":2,\"caption\":\"Model\",\"fieldName\":\"model\",\"type\":{\"$type\":\"ApprovableLookupFieldType\",\"collection\":\"models\",\"field\":\"name\"}},{\"order\":3,\"caption\":\"Input voltage\",\"fieldName\":\"input\",\"type\":{\"$type\":\"IntFieldType\"}},{\"order\":4,\"caption\":\"Output voltage\",\"fieldName\":\"output\",\"type\":{\"$type\":\"IntFieldType\"}}],\"name\":\"Transformer step-down\",\"id\":\"bf354183-93e3-498d-a604-1c97b2a9503c\"}," +
                           "{\"pic\":\"00000000-0000-0000-0000-000000000000\",\"fields\":[{\"order\":1,\"caption\":\"Manufacturer\",\"fieldName\":\"manufacturer\",\"type\":{\"$type\":\"ApprovableLookupFieldType\",\"collection\":\"manufacturers\",\"field\":\"name\"}},{\"order\":2,\"caption\":\"Model\",\"fieldName\":\"model\",\"type\":{\"$type\":\"ApprovableLookupFieldType\",\"collection\":\"models\",\"field\":\"name\"}}],\"name\":\"Transformer isolation\",\"id\":\"2027b2c0-7ced-4779-b6a2-614403b42fcd\"}," +
                           "{\"pic\":\"00000000-0000-0000-0000-000000000000\",\"fields\":[{\"order\":1,\"caption\":\"Manufacturer\",\"fieldName\":\"manufacturer\",\"type\":{\"$type\":\"ApprovableLookupFieldType\",\"collection\":\"manufacturers\",\"field\":\"name\"}},{\"order\":2,\"caption\":\"Model\",\"fieldName\":\"model\",\"type\":{\"$type\":\"ApprovableLookupFieldType\",\"collection\":\"models\",\"field\":\"name\"}}],\"name\":\"Network equipment\",\"id\":\"b2338f55-1d77-45e6-bb0c-2526ba75d849\"}," +
                           "{\"pic\":\"00000000-0000-0000-0000-000000000000\",\"fields\":[{\"order\":1,\"caption\":\"Title\",\"fieldName\":\"title\",\"type\":{\"$type\":\"StringFieldType\"}}],\"name\":\"Front panel\",\"id\":\"ba64d559-3de6-498c-99b1-08e9d77052f9\"},{\"pic\":\"00000000-0000-0000-0000-000000000000\",\"fields\":[{\"order\":1,\"caption\":\"Manufacturer\",\"fieldName\":\"manufacturer\",\"type\":{\"$type\":\"ApprovableLookupFieldType\",\"collection\":\"manufacturers\",\"field\":\"name\"}},{\"order\":2,\"caption\":\"Model\",\"fieldName\":\"model\",\"type\":{\"$type\":\"ApprovableLookupFieldType\",\"collection\":\"models\",\"field\":\"name\"}},{\"order\":3,\"caption\":\"Has microphone\",\"fieldName\":\"microphone\",\"type\":{\"$type\":\"BooleanFieldType\"}}],\"name\":\"Headphones\",\"id\":\"1bfd582a-a1aa-4342-9ffd-b11b79a28f46\"}," +
                           "{\"pic\":\"00000000-0000-0000-0000-000000000000\",\"fields\":[{\"order\":1,\"caption\":\"Manufacturer\",\"fieldName\":\"manufacturer\",\"type\":{\"$type\":\"ApprovableLookupFieldType\",\"collection\":\"manufacturers\",\"field\":\"name\"}},{\"order\":2,\"caption\":\"Model\",\"fieldName\":\"model\",\"type\":{\"$type\":\"ApprovableLookupFieldType\",\"collection\":\"models\",\"field\":\"name\"}}],\"name\":\"IR Receiver\",\"id\":\"e7b0a1b0-37bf-4c10-a18c-3a59fbe8d925\"}," +
                           "{\"pic\":\"00000000-0000-0000-0000-000000000000\",\"fields\":[{\"order\":1,\"caption\":\"Title\",\"fieldName\":\"title\",\"type\":{\"$type\":\"StringFieldType\"}}],\"name\":\"CD\",\"id\":\"62aacfa6-4397-48ea-b1c1-0fffefe19497\"}," +
                           "{\"pic\":\"00000000-0000-0000-0000-000000000000\",\"fields\":[{\"order\":1,\"caption\":\"Manufacturer\",\"fieldName\":\"manufacturer\",\"type\":{\"$type\":\"ApprovableLookupFieldType\",\"collection\":\"manufacturers\",\"field\":\"name\"}},{\"order\":2,\"caption\":\"Model\",\"fieldName\":\"model\",\"type\":{\"$type\":\"ApprovableLookupFieldType\",\"collection\":\"models\",\"field\":\"name\"}}],\"name\":\"Microphone\",\"id\":\"8cbd884e-0fcb-4d3f-96ce-cd11b5d7f7b6\"}," +
                           "{\"pic\":\"00000000-0000-0000-0000-000000000000\",\"fields\":[{\"order\":1,\"caption\":\"Title\",\"fieldName\":\"title\",\"type\":{\"$type\":\"StringFieldType\"}}],\"name\":\"Streaming equipment\",\"id\":\"4d4a7d30-4e02-40cd-95ad-77aa1a74c171\"}," +
                           "{\"pic\":\"00000000-0000-0000-0000-000000000000\",\"fields\":[{\"order\":1,\"caption\":\"Title\",\"fieldName\":\"title\",\"type\":{\"$type\":\"StringFieldType\"}},{\"order\":2,\"caption\":\"Socket type\",\"fieldName\":\"socket\",\"type\":{\"$type\":\"DropDownFieldType\",\"items\":[\"UK\",\"US\",\"Europe\"]}},{\"order\":3,\"caption\":\"Input voltage\",\"fieldName\":\"input\",\"type\":{\"$type\":\"IntFieldType\"}},{\"order\":4,\"caption\":\"Output voltage\",\"fieldName\":\"output\",\"type\":{\"$type\":\"IntFieldType\"}}],\"name\":\"PSU\",\"id\":\"bc43d00b-8260-4d7b-89be-7035fde57998\"}," +
                           "{\"pic\":\"00000000-0000-0000-0000-000000000000\",\"fields\":[{\"order\":1,\"caption\":\"Title\",\"fieldName\":\"title\",\"type\":{\"$type\":\"StringFieldType\"}}],\"name\":\"Red Rat\",\"id\":\"6976c0f4-fa9f-4a69-9977-5f046549d6ea\"},{\"pic\":\"00000000-0000-0000-0000-000000000000\",\"fields\":[{\"order\":1,\"caption\":\"Manufacturer\",\"fieldName\":\"manufacturer\",\"type\":{\"$type\":\"ApprovableLookupFieldType\",\"collection\":\"manufacturers\",\"field\":\"name\"}},{\"order\":2,\"caption\":\"Model\",\"fieldName\":\"model\",\"type\":{\"$type\":\"ApprovableLookupFieldType\",\"collection\":\"models\",\"field\":\"name\"}}],\"name\":\"USB hub\",\"id\":\"4d9beb0b-0d10-4402-9811-8cbd62a39623\"}," +
                           "{\"pic\":\"00000000-0000-0000-0000-000000000000\",\"fields\":[{\"order\":1,\"caption\":\"Title\",\"fieldName\":\"title\",\"type\":{\"$type\":\"StringFieldType\"}}],\"name\":\"SMART Box\",\"id\":\"5080a76d-726b-4a28-8f11-203441488a7e\"},{\"pic\":\"00000000-0000-0000-0000-000000000000\",\"fields\":[{\"order\":1,\"caption\":\"Manufacturer\",\"fieldName\":\"manufacturer\",\"type\":{\"$type\":\"ApprovableLookupFieldType\",\"collection\":\"manufacturers\",\"field\":\"name\"}},{\"order\":2,\"caption\":\"Model\",\"fieldName\":\"model\",\"type\":{\"$type\":\"ApprovableLookupFieldType\",\"collection\":\"models\",\"field\":\"name\"}}],\"name\":\"Smartcard reader\",\"id\":\"5443d210-ef34-457c-b433-c595acc2d021\"}," +
                           "{\"pic\":\"00000000-0000-0000-0000-000000000000\",\"fields\":[{\"order\":1,\"caption\":\"Manufacturer\",\"fieldName\":\"manufacturer\",\"type\":{\"$type\":\"ApprovableLookupFieldType\",\"collection\":\"manufacturers\",\"field\":\"name\"}},{\"order\":2,\"caption\":\"Model\",\"fieldName\":\"model\",\"type\":{\"$type\":\"ApprovableLookupFieldType\",\"collection\":\"models\",\"field\":\"name\"}}],\"name\":\"Web camera\",\"id\":\"2f7ebbba-2fa4-4de7-9655-1d307ecb25ce\"}]";
        //------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

        try
        {
            JSONArray arr = new JSONArray(response);


            for (int i = 0; i < arr.length(); i++)
            {
                CategoryObject category = new CategoryObject();

                JSONObject arr_element = arr.getJSONObject(i);
                category.setPic(arr_element.getString("pic"));
                category.setId(arr_element.getString("id"));
                category.setName(arr_element.getString("name"));

                ArrayList<CategoryField> category_fields = new ArrayList<CategoryField>();

                JSONArray fields = arr_element.getJSONArray("fields");
                for (int j = 0; j < fields.length(); j++)
                {
                    CategoryField field = new CategoryField();
                    JSONObject fields_element = fields.getJSONObject(j);
                    field.setOrder(fields_element.getInt("order"));
                    field.setCaption(fields_element.getString("caption"));
                    field.setFieldName(fields_element.getString("fieldName"));

                    CategoryType type = new CategoryType();
                    JSONObject fields_element_type = fields_element.getJSONObject("type");

                    type.setType(fields_element_type.getString("$type"));
                    if (type.getType() == "ApprovableLookupFieldType")
                    {
                        type.setCollection(fields_element_type.getString("collection"));
                        type.setField(fields_element_type.getString("field"));
                    }
                    else if(type.getType() == "CheckBoxArrayFieldType")
                    {
                        ArrayList<String> items = new ArrayList<String>();
                        JSONArray type_items = fields_element_type.getJSONArray("items");
                        for (int k = 0; k < type_items.length(); k++)
                        {
                            items.add(type_items.getString(k));
                        }
                        type.setItems(items);
                    }
                    else if(type.getType() == "EditableLookupFieldType")
                    {
                        type.setCollection(fields_element_type.getString("collection"));
                        type.setField(fields_element_type.getString("field"));
                    }
                    else if(type.getType() == "IntFieldType")
                    {
                        // pass
                    }
                    else if(type.getType() == "BooleanFieldType")
                    {
                        // pass
                    }
                    else if(type.getType() == "StringFieldType")
                    {
                        // pass
                    }
                    category_fields.add(field);
                }

                category.setFields(category_fields);
                CategoryObjectList.add(category);
            }
        }
        catch (JSONException e)
        {
            Log.e("ItemsDetection", "Unexpected JSON exception", e);
        }

        //Here we should fill Fields.
        for (int i=0; i <CategoryObjectList.size(); i++)
        {
            returnSubCategoryList.add(CategoryObjectList.get(i).getName());
            //Log.i("getSubCategoriesList", "F:[getSubCategoriesList]: " + CategoryObjectList.get(i).getName());
        }
        return returnSubCategoryList;
    }


    /**
     * @Function: getSubCategoryFieldsList
     * @Descriprion:
     * @param: ArrayList String
     */
    public ArrayList<String> getSubCategoryFieldsList(int position)
    {
        ArrayList<String> SubCategoryFieldsList = new ArrayList<String>();


        ArrayList<CategoryField> element = CategoryObjectList.get(position).getFields();

        for (int i=0; i <element.size(); i++)
        {
            SubCategoryFieldsList.add(element.get(i).getCaption());
            //Log.i("getSubCategoryFieldsList", "F[getSubCategoryFieldsList]: " + element.get(i).getCaption());
        }

        return SubCategoryFieldsList;
    }
}
