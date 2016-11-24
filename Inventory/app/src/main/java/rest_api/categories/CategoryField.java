package rest_api.categories;

/**
 * Created by stas.savinov on 11/23/2016.
 */

public class CategoryField
{
    private int order;

    public int getOrder() { return this.order; }

    public void setOrder(int order) { this.order = order; }

    private String caption;

    public String getCaption() { return this.caption; }

    public void setCaption(String caption) { this.caption = caption; }

    private String fieldName;

    public String getFieldName() { return this.fieldName; }

    public void setFieldName(String fieldName) { this.fieldName = fieldName; }

    private CategoryType type;

    public CategoryType getType() { return this.type; }

    public void setType(CategoryType type) { this.type = type; }
}
