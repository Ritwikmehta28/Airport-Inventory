package com.sapience_vision.airportinventory;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class ScanOrId extends AppCompatActivity  {
    Button buttonScan;
    EditText textid;
    Button buttonsearch;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan_or_id);

        buttonScan = (Button) findViewById(R.id.scanEq);
        //buttonsearch = (Button) findViewById(R.id.searchEq);
        //textid = (EditText) findViewById(R.id.enterId);


        buttonScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ScanOrId.this,Scanning.class);
                startActivity(intent);


            }
        });
    }
}










