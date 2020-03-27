package com.sapience_vision.airportinventory;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class Scanning extends AppCompatActivity implements ZXingScannerView.ResultHandler{

    ZXingScannerView ScannerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ScannerView = new ZXingScannerView(this);
        setContentView(ScannerView);}

        @Override
        public void handleResult(Result result)
        {
            Detailsblock.QRID=result.getText().toString();
            Intent intent=new Intent(Scanning.this,Detailsblock.class);
            startActivity(intent);
        }
        @Override
        protected void onPause() {
            super.onPause();
            ScannerView.stopCamera();
        }
        @Override
        protected void onResume() {
            super.onResume();
            ScannerView.setResultHandler(this);
            ScannerView.startCamera();
        }

    }

