package scanner;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;

import com.google.zxing.Result;
import me.dm7.barcodescanner.zxing.ZXingScannerView;

import com.inventory.echostar.inventory.R;

public class SimpleScannerActivity extends Activity implements ZXingScannerView.ResultHandler
{
    private ZXingScannerView mScannerView;
    private static String LOG = "SimpleScannerActivity";

    /**
     * @Function: onCreate
     * @Description:
     * @params:
     */
    @Override
    public void onCreate(Bundle state) {
        super.onCreate(state);
        setContentView(R.layout.activity_simple_scanner);

        ViewGroup contentFrame = (ViewGroup) findViewById(R.id.content_frame);

        mScannerView = new ZXingScannerView(this);
        contentFrame.addView(mScannerView);
    }

    /**
     * @Function: onResume
     * @Description:
     * @params:
     */
    @Override
    public void onResume() {
        super.onResume();
        mScannerView.setResultHandler(this); // Register ourselves as a handler for scan results.
        mScannerView.startCamera();          // Start camera on resume
    }

    /**
     * @Function: onPause
     * @Description:
     * @params:
     */
    @Override
    public void onPause() {
        super.onPause();
        mScannerView.stopCamera();           // Stop camera on pause
    }

    /**
     * @Function:  handleResult
     * @Description:
     * @params: rawResult - Result
     */
    @Override
    public void handleResult(Result rawResult)
    {
        // Do something with the result here
        Log.v(LOG, rawResult.getText());                        // Prints scan results
        Log.v(LOG, rawResult.getBarcodeFormat().toString());    // Prints the scan format (qrcode, pdf417 etc.)
        // If you would like to resume scanning, call this method below:
        mScannerView.resumeCameraPreview(this);
    }
}