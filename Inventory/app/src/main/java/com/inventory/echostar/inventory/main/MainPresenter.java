package com.inventory.echostar.inventory.main;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.widget.Toast;

import com.inventory.echostar.inventory.scanner.FullScannerActivity;
import com.inventory.echostar.inventory.search.SearchActivity;
import com.inventory.echostar.inventory.scanner.SimpleZbarScannerActivity;

/**
 * Created by stas.savinov on 11/18/2016.
 */

public class MainPresenter
{
    private MainView view;
    private Context  ctx;
    private final String LOG  = "Main Activity";

    private static final int ZXING_CAMERA_PERMISSION = 1;
    private Class<?> mClss;

    /**
     * @Constructor: LoginPresenter
     * @param
     */
    public MainPresenter(MainView view)
    {
        this.view = view;
        this.ctx = view.getMainContext();
    }


    /**
     * @Function: onClickZxingScan - Override method
     * @params:
     */
    public void onClickZxingScan()
    {
        launchActivity(FullScannerActivity.class);
    }

    /**
     * @Function: onClickBarScan - Override method
     * @params:
     */
    public void onClickBarScan()
    {
        launchActivity(SimpleZbarScannerActivity.class);
    }

    /**
     * @Function: onClickSearch - Override method
     * @params:
     */
    public void onClickSearch()
    {
        launchActivity(SearchActivity.class);
    }

    /**
     * @Function: launchActivity - Override method
     * @params: Class
     */
    public void launchActivity(Class<?> clss)
    {
        if (ContextCompat.checkSelfPermission(ctx, Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED)
        {
            mClss = clss;
            ActivityCompat.requestPermissions(view.getActivity(),
                    new String[]{Manifest.permission.CAMERA}, ZXING_CAMERA_PERMISSION);
        }
        else
        {
            Intent intent = new Intent(ctx, clss);
            view.startActivityWithIntent(intent);
        }
    }

    /**
     * @Function: onPermissionsResult
     * @params:
     */
    public void onPermissionsResult(int requestCode,  String permissions[], int[] grantResults)
    {
        switch (requestCode)
        {
            case ZXING_CAMERA_PERMISSION:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
                {
                    if(mClss != null)
                    {
                        Intent intent = new Intent(this.ctx, mClss);
                        view.startActivityWithIntent(intent);
                    }
                }
                else
                {
                    Toast.makeText(this.ctx,
                            "Please grant camera permission to use the QR Scanner",
                            Toast.LENGTH_SHORT).show();
                }
                return;
        }
    }
}
