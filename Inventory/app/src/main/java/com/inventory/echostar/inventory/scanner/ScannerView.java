package com.inventory.echostar.inventory.scanner;

import android.content.Context;
import android.content.Intent;

/**
 * Created by stas.savinov on 11/21/2016.
 */

public interface ScannerView
{
    Context getThis();

    void showMessageDialog(String message);
}
