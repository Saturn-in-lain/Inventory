package com.inventory.echostar.inventory.item_description;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.ImageView;

import com.inventory.echostar.inventory.R;


public class ItemDescriptionActivity extends AppCompatActivity implements ItemDescriptionView
{
    static final int REQUEST_IMAGE_CAPTURE = 1;
    private ItemDescriptionPresenter presenter = null;
    private TextView txtInfo;
    private TextView txtInfo1;
    private TextView txtInfo2;
    private TextView txtInfo3;
    private TextView txtInfo4;
    private TextView txtInfo5;
    private TextView txtInfo6;
    private TextView txtInfo7;
    private TextView txtInfo8;
    private TextView txtInfo9;
    private TextView txtInfo10;
    private TextView txtInfo11;
    private TextView txtInfo12;
    private TextView txtInfo13;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_description);
        Intent intent = getIntent();

        txtInfo   = (TextView) findViewById(R.id.txtModelInfo);
        txtInfo1  = (TextView) findViewById(R.id.txtManufacturerInfo);
        txtInfo2  = (TextView) findViewById(R.id.txtCreatorInfo);
        txtInfo3  = (TextView) findViewById(R.id.txtVersionInfo);
        txtInfo4  = (TextView) findViewById(R.id.txtModificationDateInfo);
        txtInfo5  = (TextView) findViewById(R.id.txtOwnerInfo);
        txtInfo6  = (TextView) findViewById(R.id.txtSerialNumberInfo);
        txtInfo7  = (TextView) findViewById(R.id.txtbarcodeInfo);
        txtInfo8  = (TextView) findViewById(R.id.txtLocationInfo);
        txtInfo9  = (TextView) findViewById(R.id.txtStateInfo);
        txtInfo10 = (TextView) findViewById(R.id.txtGuaranteeExpirationInfo);
        txtInfo11 = (TextView) findViewById(R.id.txtAccountingInventoryCodeInfo);
        txtInfo12 = (TextView) findViewById(R.id.txtCommentsInfo);
        txtInfo13 = (TextView) findViewById(R.id.txtOfficeInfo);

        presenter = new ItemDescriptionPresenter(this);
        presenter.setItemDataFromIntent(intent);

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
     * setActivityDataInfo
     * @param data
     */
    @Override
    public void setActivityDataInfo(String field, String data)
    {
        switch(field)
        {
            case "Model":
                txtInfo.setText(data);
                break;
            case "Manufacturer":
                txtInfo1.setText(data);
                break;
            case "Creator":
                txtInfo2.setText(data);
                break;
            case "Version":
                txtInfo3.setText(data);
                break;
            case "ModificationDate":
                txtInfo4.setText(data);
                break;
            case "Owner":
                txtInfo5.setText(data);
                break;
            case "SerialNumber":
                txtInfo6.setText(data);
                break;
            case "Barcode":
                txtInfo7.setText(data);
                break;
            case "Location":
                txtInfo8.setText(data);
                break;
            case "State":
                txtInfo9.setText(data);
                break;
            case "GuaranteeExpiration":
                txtInfo10.setText(data);
                break;
            case "AccountingInventoryCode":
                txtInfo11.setText(data);
                break;
            case "Comments":
                txtInfo12.setText(data);
                break;
            case "Office":
                txtInfo13.setText(data);
                break;
            default:
                break;
        }
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

            presenter.savePhotoOfItem(imageBitmap);
        }
    }

    /**
     * @Function: getThis - Override method
     * @params: None
     */
    @Override
    public Context getThis()
    {
        return this;
    }
}
