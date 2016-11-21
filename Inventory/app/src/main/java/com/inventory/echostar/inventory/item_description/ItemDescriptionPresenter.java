package com.inventory.echostar.inventory.item_description;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;

import database_manager.DatabaseItemEmulator;

/**
 * Created by stas.savinov on 11/21/2016.
 */

public class ItemDescriptionPresenter
{
    private ItemDescriptionView view;

    public ItemDescriptionPresenter(ItemDescriptionView view)
    {
        this.view = view;
    }

    /**
     * @Function: savePhotoOfItem
     * @params: Bitmap
     * @Note: TODO Save actual photo to database
     */
    void savePhotoOfItem(Bitmap imageBitmap)
    {
        DatabaseItemEmulator database = new DatabaseItemEmulator(view.getThis());
        database.setImageOfModel(imageBitmap, "Model1");
        database.typeAllDataBaseCredentials();
    }

    /**
     * @Function: savePhotoOfItem
     * @params:
     * @Note:
     */
    void setItemDataFromIntent(Intent intent)
    {
        view.setActivityDataInfo("Model",intent.getStringExtra("Model"));
        view.setActivityDataInfo("Manufacturer",intent.getStringExtra("Manufacturer"));
        view.setActivityDataInfo("Creator",intent.getStringExtra("Creator"));
        view.setActivityDataInfo("Version",intent.getStringExtra("v"));
        view.setActivityDataInfo("ModificationDate",intent.getStringExtra("ModificationDate"));
        view.setActivityDataInfo("Owner",intent.getStringExtra("Owner"));
        view.setActivityDataInfo("SerialNumber",intent.getStringExtra("SerialNumber"));
        view.setActivityDataInfo("Barcode",intent.getStringExtra("Barcode"));
        view.setActivityDataInfo("Location",intent.getStringExtra("Location"));
        view.setActivityDataInfo("State",intent.getStringExtra("State"));
        view.setActivityDataInfo("GuaranteeExpiration",intent.getStringExtra("GuaranteeExpiration"));
        view.setActivityDataInfo("AccountingInventoryCode",intent.getStringExtra("AccountingInventoryCode"));
        view.setActivityDataInfo("Comments",intent.getStringExtra("Comments"));
        view.setActivityDataInfo("Office",intent.getStringExtra("Office"));
    }
}
