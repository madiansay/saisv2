package com.adrianesys.saisv2;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.View;

import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";


    FloatingActionButton fab;

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    ArrayList<String>samplestocks;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_inventory);
        fab = findViewById(R.id.fab);

        samplestocks = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            samplestocks.add("Item " + i);
        }

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new StocksAdapter(samplestocks);
        recyclerView.setAdapter(adapter);



        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, InsertStock.class));
            }
        });
    }

}