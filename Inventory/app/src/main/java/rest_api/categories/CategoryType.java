package rest_api.categories;

import java.util.ArrayList;

/**
 * Created by stas.savinov on 11/23/2016.
 */

public class CategoryType
{
    private String type;

    public String getType() { return this.type; }

    public void setType(String type) { this.type = type; }

    private String collection;

    public String getCollection() { return this.collection; }

    public void setCollection(String collection) { this.collection = collection; }

    private String field;

    public String getField() { return this.field; }

    public void setField(String field) { this.field = field; }

    private ArrayList<String> items;

    public ArrayList<String> getItems() { return this.items; }

    public void setItems(ArrayList<String> items) { this.items = items; }
}
