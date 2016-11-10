package com.inventory.echostar.inventory;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.ImageView;

import database_manager.DatabaseItemEmulator;

public class ItemDescriptionActivity extends AppCompatActivity
{
    static final int REQUEST_IMAGE_CAPTURE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_description);
        //Log.e("ItemDescriptionActivity","data: " + data);
        Intent intent = getIntent();

        TextView txtInfo = (TextView) findViewById(R.id.txtModelInfo);
        txtInfo.setText(intent.getStringExtra("Model"));

        TextView txtInfo1 = (TextView) findViewById(R.id.txtManufacturerInfo);
        txtInfo1.setText(intent.getStringExtra("Manufacturer"));

        TextView txtInfo2 = (TextView) findViewById(R.id.txtCreatorInfo);
        txtInfo2.setText(intent.getStringExtra("Creator"));

        TextView txtInfo3 = (TextView) findViewById(R.id.txtVersionInfo);
        txtInfo3.setText(intent.getStringExtra("Version"));

        TextView txtInfo4 = (TextView) findViewById(R.id.txtModificationDateInfo);
        txtInfo4.setText(intent.getStringExtra("ModificationDate"));

        TextView txtInfo5 = (TextView) findViewById(R.id.txtOwnerInfo);
        txtInfo5.setText(intent.getStringExtra("Owner"));

        TextView txtInfo6 = (TextView) findViewById(R.id.txtSerialNumberInfo);
        txtInfo6.setText(intent.getStringExtra("SerialNumber"));

        TextView txtInfo7 = (TextView) findViewById(R.id.txtbarcodeInfo);
        txtInfo7.setText(intent.getStringExtra("Barcode"));

        TextView txtInfo8 = (TextView) findViewById(R.id.txtLocationInfo);
        txtInfo8.setText(intent.getStringExtra("Location"));

        TextView txtInfo13 = (TextView) findViewById(R.id.txtOfficeInfo);
        txtInfo13.setText(intent.getStringExtra("Office"));

        TextView txtInfo9 = (TextView) findViewById(R.id.txtStateInfo);
        txtInfo9.setText(intent.getStringExtra("State"));

        TextView txtInfo10 = (TextView) findViewById(R.id.txtGuaranteeExpirationInfo);
        txtInfo10.setText(intent.getStringExtra("GuaranteeExpiration"));

        TextView txtInfo11 = (TextView) findViewById(R.id.txtAccountingInventoryCodeInfo);
        txtInfo11.setText(intent.getStringExtra("AccountingInventoryCode"));

        TextView txtInfo12 = (TextView) findViewById(R.id.txtCommentsInfo);
        txtInfo12.setText(intent.getStringExtra("Comments"));


        ImageView itemImage = (ImageView) findViewById(R.id.imgItemPhoto);
        itemImage.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                takePhotoOfItem();
            }
        });
    }

    /**
     * takePhotoOfItem
     * @param
     */
    public void takePhotoOfItem()
    {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null)
        {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }

    public void savePhotoOfItem(Bitmap imageBitmap)
    {
        //TODO Add to database photo
        DatabaseItemEmulator database = new DatabaseItemEmulator(this);
        database.setImageOfModel(imageBitmap, "Model1");
        database.typeAllDataBaseCredentials();
    }


    /**
     * onActivityResult Override method
     * @param
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK)
        {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");

            ImageView itemImage = (ImageView) findViewById(R.id.imgItemPhoto);
            itemImage.setImageBitmap(imageBitmap);

            savePhotoOfItem(imageBitmap);
        }
    }
}
