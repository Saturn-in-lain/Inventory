package com.inventory.echostar.inventory;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import database_manager.DatabaseOpenHelper;
import database_manager.UserCredentials;

public class LoginActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText edtTxtUserName = (EditText) findViewById(R.id.edtxtName);
        final EditText edtTxtPassword = (EditText) findViewById(R.id.edtxtPassword);
        final CheckBox chkbxRememberMe = (CheckBox) findViewById(R.id.chBxRememberMe);
        final Button btnLogging = (Button) findViewById(R.id.btnLogging);

        btnLogging.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String username = edtTxtUserName.getText().toString();
                final String password = edtTxtPassword.getText().toString();

                //online variant
                if (isNetworkAvailable()) {
                    ConnectToRemoteAuthorizationServer(username, password);
                }
                else {
                    //offline variant
                    if (ConnectToLocalAuthorizatioinDatabase(username, password)) {
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        intent.putExtra("username", username + "(offline)");
                        LoginActivity.this.startActivity(intent);
                    }
                    else
                    {
                        AlertDialogShow();
                    }
                }
            }
        });
    }

    /**
     * isNetworkAvailable
     * @param
     */
    private boolean isNetworkAvailable()
    {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    /**
     * AlertDialogShow
     * @param
     */
    private void AlertDialogShow()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
        builder.setMessage("Login Failed")
                .setNegativeButton("Retry", null)
                .create()
                .show();
    }

    /**
     * ConnectToRemoteAuthorizationServer
     * @param username
     * @param password
     */
    private void ConnectToRemoteAuthorizationServer(String username, String password)
    {
        final String Username = username;
        final String Password = password;

        Response.Listener<String> responseListener = new Response.Listener<String>()
        {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonResponse = new JSONObject(response);
                    boolean success = jsonResponse.getBoolean("success");

                    if (success)
                    {
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        intent.putExtra("username", Username);
                        LoginActivity.this.startActivity(intent);
                    }
                    else
                    {
                        Log.d("Inventory",jsonResponse.toString());
                        AlertDialogShow();

                        // Here we will connect to local database in ordrer to perform tests
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };

        LoggingRequest loginRequest = new LoggingRequest(username, password, responseListener);
        RequestQueue queue = Volley.newRequestQueue(LoginActivity.this);
        queue.add(loginRequest);
    }

    /**
     * ConnectToLocalAuthorizatioinDatabase
     * @param username
     * @param password
     */
    private boolean ConnectToLocalAuthorizatioinDatabase(String username, String password)
    {
        boolean retValue = false;
        DatabaseOpenHelper database = new DatabaseOpenHelper(this);

        database.initializeDefaultDataBase();

        UserCredentials user = database.getCredentialsByName(username,password);
        if (null != user)
        {
            if (username.equals(user.getName()) && password.equals(user.getPassword()))
            {
                retValue = true;
            }
            else
            {
                Log.i("Inventory user:", "\nCOMPARE FAILED!!!!");
                Log.i("Inventory DB user:", user.getName());
                Log.i("Inventory DB pwd:", user.getPassword());
                Log.i("Inventory user:", username);
                Log.i("Inventory pwd:", password);
            }
        }
        else
        {
            Log.e("Inventory","Usr is null");
        }
        return retValue;
    }

}
