package items;

import java.util.ArrayList;

/**
 * Created by stas.savinov on 11/11/2016.
 */

public interface GlobalItemAPI
{
    ArrayList<String> Fields = new ArrayList<String>();

    ArrayList<String> getUniqueItemFields();
}
