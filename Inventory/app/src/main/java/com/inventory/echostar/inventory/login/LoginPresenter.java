package com.inventory.echostar.inventory.login;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Build;
import android.util.Log;
import android.view.View;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.inventory.echostar.inventory.main.MainActivity;
import com.inventory.echostar.inventory.R;

import org.json.JSONException;
import org.json.JSONObject;

import database_manager.DatabaseOpenHelper;
import database_manager.UserCredentials;

/**
 * Created by stas.savinov on 11/16/2016.
 */

public class LoginPresenter
{
    private LoginView      view;
    private LoggingRequest service;
    private Context        ctx;

    private View m_ProgressView;
    private View m_LoginFormView;

    private UserLoginTask mAuthTask;
    private DatabaseOpenHelper database = null;

    private SharedPreferences settings;
    private SharedPreferences.Editor prefsEditor;

    private final String PreferenceName = "EchostarInventory";
    private final String LogingString   = "Login";
    private final String PasswordString = "Password";
    private final String RememberString = "RememberMe";
    private final String LOG            = "Login Activity";
    private String Role = null;

    /**
     * @Constructor: LoginPresenter
     * @param
     */
    public LoginPresenter(LoginView view)
    {
        this.view = view;
        this.database = new DatabaseOpenHelper(view.getLoginViewContext());
        this.ctx = view.getLoginViewContext();

        m_ProgressView = view.getProgressView();
        m_LoginFormView = view.getLogingForm();

        this.settings = view.returnSharedPreferences();                                                 //this.ctx.getSharedPreferences(PreferenceName, 0);
        this.prefsEditor = view.returnSharedPreferencesEditor();                                        //this.settings.edit();
    }

    /**
     * @Function: onPause
     * @param
     */
    void onPause()
    {
        if (this.view.getCheckBoxState())
        {
            this.prefsEditor.putString(LogingString,view.getUsername());
            this.prefsEditor.putString(PasswordString,view.getPassword());
            this.prefsEditor.commit();
            Log.i(LOG,"\n onPause get data User: " + this.settings.getString(LogingString,"None") +
                    " Pwd: " + this.settings.getString(PasswordString,""));
        }
    }

    /**
     * @Function: getUsernameFromMemory
     * @param
     */
    public String getUsernameFromMemory()
    {
        String UserName = null;
        if(null != this.settings) {
            UserName = this.settings.getString(LogingString, "None");
        }
        return UserName;
    }

    /**
     * @Function: getPwdFromMemory
     * @param
     */
    public String getPwdFromMemory()
    {
        String Pwd = null;
        if(null != this.settings)
        {
            Pwd = this.settings.getString(PasswordString,"");
        }
        return Pwd;
    }

    /**
     * @Function: getCheckBoxFromMemory
     * @param
     */
    public boolean getCheckBoxFromMemory()
    {
        boolean chk = false;
        if(null != this.settings)
        {
            chk = this.settings.getBoolean(RememberString, false);
        }
        return chk;
    }

    /**
     * @Function: onRememberMeClicked
     * @param
     */
    public void onRememberMeClicked()
    {
        if (this.view.getCheckBoxState())
        {
            prefsEditor.putBoolean(RememberString, true);
            prefsEditor.putString(LogingString,this.view.getUsername());
            prefsEditor.putString(PasswordString,this.view.getPassword());
            prefsEditor.commit();
        }
        else
        {
            prefsEditor.clear();
            prefsEditor.commit();
        }
    }

    /**
     * @Function: onLoginClicked
     * @param
     */
    public void onLoginClicked() {
        String username = this.view.getUsername();
        if (username.isEmpty()) {
            this.view.showUsernameError(R.string.username_error);
            return;
        }
        String password = this.view.getPassword();
        if (password.isEmpty()) {
            this.view.showPasswordError(R.string.password_error);
            return;
        }

        if (isNetworkAvailable()) {
            showProgress(true);
            mAuthTask = new UserLoginTask(username, password);
            mAuthTask.execute((Void) null);
        } else {

            database.initializeDefaultDataBase();

            if (ConnectToLocalAuthorizatioinDatabase(username, password, database)) {
                Intent intent = new Intent(view.getLoginViewContext(), MainActivity.class);
                intent.putExtra("username", username + "(offline)");
                intent.putExtra("role", Role);
                view.startMainActivityWithIntent(intent);
            } else {

                view.getAlertDialog().setMessage("Connection error")
                        .setNegativeButton("Retry", null)
                        .create()
                        .show();
            }
        }
    }

    /**
     * @Function: isNetworkAvailable
     * @param:
     */
    private boolean isNetworkAvailable()
    {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) view.getLoginViewContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    /**
     * ConnectToRemoteAuthorizationServer
     * @param username
     * @param password
     */
    public void ConnectToRemoteAuthorizationServer(String username, String password)
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
                        Intent intent = new Intent(view.getLoginViewContext(), MainActivity.class);
                        intent.putExtra("username", Username);
                        view.startMainActivityWithIntent(intent);
                    }
                    else
                    {
                        Log.d("Inventory",jsonResponse.toString());
                        view.getAlertDialog().setMessage("Logon failed")
                                .setNegativeButton("Retry", null)
                                .create()
                                .show();
                    }

                } catch (JSONException e)
                {
                    Log.e("responseListener ERROR: ",response);
                    //TODO: Here we also should return popup "Authorization failed"
                    e.printStackTrace();
                }
            }
        };

        LoggingRequest loginRequest = new LoggingRequest(username, password, responseListener);
        RequestQueue queue = Volley.newRequestQueue(view.getLoginViewContext());
        queue.add(loginRequest);
    }

    /**
     * ConnectToLocalAuthorizatioinDatabase
     * @param username
     * @param password
     */
    public boolean ConnectToLocalAuthorizatioinDatabase(String username, String password, DatabaseOpenHelper database)
    {
        boolean retValue = false;

        database.initializeDefaultDataBase();

        UserCredentials user = database.getCredentialsByName(username,password);
        if (null != user)
        {
            if (username.equals(user.getName()) && password.equals(user.getPassword()))
            {
                Role = user.getRole();
                retValue = true;
            }
            else
            {
                Log.i("Inventory user:", "\nCOMPARE FAILED!!!!");
                Log.i("Inventory DB user:", user.getName());
                Log.i("Inventory DB pwd:", user.getPassword());
                Log.i("Inventory DB pwd:", user.getRole());
                Log.i("Inventory user:", username);
                Log.i("Inventory pwd:", password);
            }
        }
        else
        {
            Log.e("Inventory","User is non authorized!");
        }
        return retValue;
    }

    /**
     * @Function: showProgress
     * @param boolean set status
     *
     */
    private void showProgress(final boolean show)
    {
        // On Honeycomb MR2 we have the ViewPropertyAnimator APIs, which allow
        // for very easy animations. If available, use these APIs to fade-in
        // the progress spinner.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2)
        {
            int shortAnimTime = view.getLoginViewContext().getResources().getInteger(android.R.integer.config_shortAnimTime);

            m_LoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
            m_LoginFormView.animate().setDuration(shortAnimTime).alpha(
                    show ? 0 : 1).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    m_LoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
                }
            });


            m_ProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
            m_ProgressView.animate().setDuration(shortAnimTime).alpha(
                    show ? 1 : 0).setListener(
                    new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    m_ProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
                }
            });
        }
        else
        {
            // The ViewPropertyAnimator APIs are not available, so simply show
            // and hide the relevant UI components.
            m_ProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
            m_LoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
        }
    }


    /**
     * Represents an asynchronous login/registration task used to authenticate
     * the user.
     */
    public class UserLoginTask extends AsyncTask<Void, Void, Boolean>
    {

        private final String username;
        private final String password;

        UserLoginTask(String iUsername, String iPassword) {
            username = iUsername;
            password = iPassword;
        }

        @Override
        protected Boolean doInBackground(Void... params) {
            // TODO: attempt authentication against a network service.

            try
            {
                Thread.sleep(2000);
                ConnectToRemoteAuthorizationServer(username,password);
            }
            catch (InterruptedException e)
            {
                return false;
            }
            return true;
        }

        @Override
        protected void onPostExecute(final Boolean success)
        {
            mAuthTask = null;
            showProgress(false);

            if (success)
            {
                view.startMainActivity();
            }
            else
            {
                view.getAlertDialog().setMessage("F:[onPostExecute] >> Incorect pwd")
                        .setNegativeButton("Retry", null)
                        .create()
                        .show();
            }
        }

        @Override
        protected void onCancelled()
        {
            mAuthTask = null;
            showProgress(false);
        }
    }
}
