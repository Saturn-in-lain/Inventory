package com.inventory.echostar.inventory.login;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.inventory.echostar.inventory.main.MainActivity;
import com.inventory.echostar.inventory.R;


import android.support.annotation.NonNull;

import static android.widget.Toast.LENGTH_SHORT;

public class LoginActivity extends AppCompatActivity implements LoginView
{
    private LoginPresenter presenter = null;
    private EditText edtTxtUserName;
    private EditText edtTxtPassword;
    private CheckBox chkbxRememberMe;
    private Button btnLogging;
    private View mProgressView;
    private View mLoginFormView;

    /**
     * @Function: onCreate
     * @params: Bundle
     */
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        presenter = new LoginPresenter(this);

        edtTxtUserName  = (EditText) findViewById(R.id.edtxtName);
        edtTxtPassword  = (EditText) findViewById(R.id.edtxtPassword);
        chkbxRememberMe = (CheckBox) findViewById(R.id.chBxRememberMe);
        btnLogging      = (Button) findViewById(R.id.btnLogging);

        chkbxRememberMe.setChecked(presenter.getCheckBoxFromMemory());
        if (chkbxRememberMe.isChecked())
        {
            edtTxtUserName.setText(presenter.getUsernameFromMemory());
            edtTxtPassword.setText(presenter.getPwdFromMemory());
        }
        this.getBaseContext();
    }
    /**
     * @Function: onPause - Override method
     * @params: None
     */
    @Override
    public void onPause()
    {
        super.onPause();
        presenter.onPause();
    }

    /**
     * @Function: getProgressView
     * @params: None
     */
    @Override
    public View getProgressView()
    {
        mProgressView = (View)findViewById(R.id.login_progress);
        return mProgressView;
    }

    /**
     * @Function: getLogingForm - Override method
     * @params: None
     */
    @Override
    public View getLogingForm()
    {
        mLoginFormView = (View) findViewById(R.id.login_form);
        return mLoginFormView;
    }

    /**
     * onRestoreInstanceState - Override method
     */
    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState)
    {
        super.onRestoreInstanceState(savedInstanceState);
    }

    /**
     * @Function: onSaveInstanceState - Override method
     * @params: Bundle
     */
    @Override
    protected void onSaveInstanceState(Bundle outState)
    {
        super.onSaveInstanceState(outState);
    }

    /**
     * @Function: onLoginClicked - Override method
     * @params: View
     */
    public void onLoginClicked(View view)
    {
        presenter.onLoginClicked();
    }

    /**
     * @Function: onRememberMeClicked - Override method
     * @params: View
     */
    public void onRememberMeClicked(View view)
    {
        presenter.onRememberMeClicked();
    }

    /**
     * @Function: getUsername - Override method
     * @params: None
     */
    @Override
    public String getUsername()
    {
        return edtTxtUserName.getText().toString();
    }

    /**
     * @Function: getCheckBoxState - Override method
     * @params: None
     */
    @Override
    public boolean getCheckBoxState()
    {
        return chkbxRememberMe.isChecked();
    }

    /**
     * @Function: showUsernameError - Override method
     * @params: int Id
     */
    @Override
    public void showUsernameError(int resId) {
        edtTxtUserName.setError(getString(resId));
    }

    /**
     * @Function: getPassword - Override method
     * @params: None
     */
    @Override
    public String getPassword() {
        return edtTxtPassword.getText().toString();
    }

    /**
     * @Function: showPasswordError - Override method
     * @params: None
     */
    @Override
    public void showPasswordError(int resId) {
        edtTxtPassword.setError(getString(resId));
    }

    /**
     * @Function: startMainActivity - Override method
     * @params: None
     */
    @Override
    public void startMainActivity()
    {
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        LoginActivity.this.startActivity(intent);
    }

    /**
     * @Function: startMainActivityWithIntent - Override method
     * @params: None
     */
    @Override
    public void startMainActivityWithIntent(Intent intent)
    {
        LoginActivity.this.startActivity(intent);
    }


    /**
     * @Function: showLoginError - Override method
     * @params: int Id
     */
    @Override
    public void showLoginError(int resId)
    {
        Toast.makeText(this, getString(resId), LENGTH_SHORT).show();
    }

    /**
     * @Function: getLoginViewContext - Override method
     * @params: None
     */
    @Override
    public Context getLoginViewContext()
    {
        return getApplicationContext();
    }


    /**
     * @Function: AlertDialogShow
     * @param String
     */
    @Override
    public AlertDialog.Builder getAlertDialog()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        return builder;
    }
}

