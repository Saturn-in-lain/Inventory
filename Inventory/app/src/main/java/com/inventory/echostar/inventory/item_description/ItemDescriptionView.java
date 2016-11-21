package com.inventory.echostar.inventory.item_description;

import android.content.Context;
import android.graphics.Bitmap;

/**
 * Created by stas.savinov on 11/21/2016.
 */

public interface ItemDescriptionView
{
    Context getThis();

    void setActivityDataInfo(String field, String data);

}
