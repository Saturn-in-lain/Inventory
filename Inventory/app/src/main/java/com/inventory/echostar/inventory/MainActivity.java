package com.inventory.echostar.inventory;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        String username = intent.getStringExtra("username");
        TextView txtWelcomeMsg = (TextView) findViewById(R.id.txtMainActivityHello);

        String message = username + " welcome to inventory tool";
        txtWelcomeMsg.setText(message);
    }
}
