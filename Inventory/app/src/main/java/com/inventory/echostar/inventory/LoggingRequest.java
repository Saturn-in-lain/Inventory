package com.inventory.echostar.inventory;

import android.util.Log;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;


public class LoggingRequest extends StringRequest
{
    private static final String LOGIN_REQUEST_URL = "http://echostarinventory.000webhostapp.com/Login.php";
    private Map<String, String> params;

    public LoggingRequest(String username, String password, Response.Listener<String> listener)
    {
        super(Method.POST, LOGIN_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("username", username);
        params.put("password", password);

        Log.i("Inventory",username);
        Log.i("Inventory","Password: " + password.toString());
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
