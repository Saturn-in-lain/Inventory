package rest_api.categories;

import java.util.ArrayList;

/**
 * Created by stas.savinov on 11/23/2016.
 */

public class CategoryObject
{
    private String pic;

    public String getPic() { return this.pic; }

    public void setPic(String pic) { this.pic = pic; }

    private ArrayList<CategoryField> fields;

    public ArrayList<CategoryField> getFields() { return this.fields; }

    public void setFields(ArrayList<CategoryField> fields) { this.fields = fields; }

    private String name;

    public String getName() { return this.name; }

    public void setName(String name) { this.name = name; }

    private String id;

    public String getId() { return this.id; }

    public void setId(String id) { this.id = id; }
}
