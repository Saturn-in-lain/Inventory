package com.inventory.echostar.inventory.main;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

/**
 * Created by stas.savinov on 11/18/2016.
 */

public interface MainView
{
    void startActivityWithIntent(Intent intent);

    Activity getActivity();

    Context getMainContext();
}
