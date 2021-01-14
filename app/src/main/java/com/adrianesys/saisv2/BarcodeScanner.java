package com.adrianesys.saisv2;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.inputmethod.InputMethodManager;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class BarcodeScanner extends Activity implements ZXingScannerView.ResultHandler  {

    int CAMERA_PERMISSION=0;
    ZXingScannerView scannerView;
    InputMethodManager imm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        scannerView = new ZXingScannerView(this);
        setContentView(scannerView);


    }
    @Override
    public void handleResult(Result result) {
        InsertStock.itemBarcode.setText(result.getText());
        ShowSoftKeys();
        onBackPressed();
    }

    @Override
    protected void onPause() {
        super.onPause();
        ShowSoftKeys();
        scannerView.stopCamera();
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        if(ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CAMERA) !=
                PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA},CAMERA_PERMISSION);
        }

        scannerView.setResultHandler(this);
        scannerView.startCamera();
    }
    private void ShowSoftKeys(){
        final InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        assert imm != null;
       // imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);
       // imm.showSoftInput(MainStockin.StockinResult,inputMethodManager.SHOW_FORCED);
    }

}
