package com.inventory.echostar.inventory.login;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.ScrollView;

/**
 * Created by stas.savinov on 11/16/2016.
 */

public interface LoginView
{
    String getUsername();

    void showUsernameError(int resId);

    String getPassword();

    void showPasswordError(int resId);

    void startMainActivity();

    void showLoginError(int resId);

    Context getLoginViewContext();

    boolean getCheckBoxState();

    void onPause();

    void startMainActivityWithIntent(Intent intent);

    View getProgressView();

    View getLogingForm();

    AlertDialog.Builder getAlertDialog();

    Context getThis();

    SharedPreferences returnSharedPreferences();

    SharedPreferences.Editor returnSharedPreferencesEditor();
}
