package com.adrianesys.saisv2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Scanner;

public class InsertStock extends AppCompatActivity {

    private static final String TAG = "InsertStock";
    Scanner scanner = new Scanner(System.in);
    Button openScanner,btnSave;
    EditText getitemname,getprice,getQyt;
    public static TextView itemBarcode;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_stock);

        itemBarcode = findViewById(R.id.insert_barcode);
        openScanner = findViewById(R.id.btn_open_scanner);
        btnSave = findViewById(R.id.btn_insert_save);

        getitemname = findViewById(R.id.insert_itemname);
        getQyt = findViewById(R.id.insert_Qty);
        getprice = findViewById(R.id.insert_price);

        openScanner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),BarcodeScanner.class));
            }
        });
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: itemname: " + getitemname.getText().toString());
                Log.d(TAG, "onClick: barcode: " + itemBarcode.getText().toString());
            }
        });
    }

}