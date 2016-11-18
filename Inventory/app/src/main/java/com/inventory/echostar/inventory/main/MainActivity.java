package com.inventory.echostar.inventory.main;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.inventory.echostar.inventory.R;
import com.inventory.echostar.inventory.login.LoginActivity;

public class MainActivity extends AppCompatActivity implements MainView
{
    private MainPresenter presenter = null;

    private Button ZxingScanButton = null;
    private Button ZBarScanButton  = null;
    private Button SearchButton    = null;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        String username = intent.getStringExtra("username");
        String role = intent.getStringExtra("role");

        TextView txtWelcomeMsg = (TextView) findViewById(R.id.txtMainActivityHello);
        TextView txtInstructionsMsg = (TextView) findViewById(R.id.txtInstructions);

        String message = username + " welcome to inventory tool. Your role is: " + role;
        txtWelcomeMsg.setText(message);

        ZxingScanButton = (Button) findViewById(R.id.btnZxingScan);
        ZBarScanButton = (Button) findViewById(R.id.btnZbarScan);
        SearchButton = (Button) findViewById(R.id.btnSearchInDatabase);

        presenter = new MainPresenter(this);

    }

    /**
     * @Function: onClickZxingScan - Override method
     * @params: View
     */
    public void onClickZxingScan(View view)
    {
        presenter.onClickZxingScan();
    }

    /**
     * @Function: onClickBarScan - Override method
     * @params: View
     */
    public void onClickBarScan(View view)
    {
        presenter.onClickBarScan();
    }

    /**
     * @Function: onClickSearch - Override method
     * @params: View
     */
    public void onClickSearch(View view)
    {
        presenter.onClickSearch();
    }

    /**
     * @Function: onRequestPermissionsResult - Override method
     * @params: View
     */
    @Override
    public void onRequestPermissionsResult(int requestCode,  String permissions[], int[] grantResults)
    {
        presenter.onPermissionsResult(requestCode, permissions, grantResults);
    }

    /**
     * @Function: startActivityWithIntent - Override method
     * @params: None
     */
    @Override
    public void startActivityWithIntent(Intent intent)
    {
        MainActivity.this.startActivity(intent);
    }

    /**
     * @Function: getActivity - Override method
     * @params: None
     */
    @Override
    public Activity getActivity()
    {
        return MainActivity.this.getActivity();
    }

    /**
     * @Function: getMainContext - Override method
     * @params: None
     */
    @Override
    public Context getMainContext()
    {
        return MainActivity.this.getApplicationContext();
    }
}
