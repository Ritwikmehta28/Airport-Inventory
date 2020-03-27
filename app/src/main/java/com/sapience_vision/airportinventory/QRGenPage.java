package com.sapience_vision.airportinventory;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

import java.io.File;
import java.io.FileOutputStream;

public class QRGenPage extends AppCompatActivity {

    Button button;
    Button button1;
    Button button2;
    Button button3;
    //private static final String TAG = "MainActivity";
    private ImageView barcode;
    public static String id;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrgen_page);

        button = (Button) findViewById(R.id.downloadQR);
        button1 = (Button) findViewById(R.id.addAnotherItem);
        button2 = (Button) findViewById(R.id.gotoMain);
        button3 = (Button) findViewById(R.id.generateQR1);


        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                barcode = findViewById(R.id.bar_code);

                String data_in_code = id;
                MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
                try {
                    BitMatrix bitMatrix = multiFormatWriter.encode(data_in_code, BarcodeFormat.QR_CODE, 300, 300);
                    BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
                    Bitmap bitmap = barcodeEncoder.createBitmap((bitMatrix));
                    barcode.setImageBitmap(bitmap);
                    Toast.makeText(QRGenPage.this, "QR Generated", Toast.LENGTH_SHORT).show();


                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shareQRcode();
                Toast.makeText(QRGenPage.this, "Saved the QRCODE!", Toast.LENGTH_SHORT).show();



            }

        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(QRGenPage.this,AddNewEquip.class);
                startActivity(intent);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(QRGenPage.this,MainActivity.class);
                startActivity(intent);
            }
        });

    }

    private void shareQRcode() {
        final String id1 = id;
        barcode.setDrawingCacheEnabled(true);
        Bitmap bitmap = barcode.getDrawingCache();
        File file = new File(Environment.getExternalStorageDirectory(),"bar_code"+id1+".jpg");

        try{
            file.createNewFile();
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.JPEG,100,fileOutputStream);
            fileOutputStream.close();

            Intent intent = new Intent(Intent.ACTION_SEND);
            if(Build.VERSION.SDK_INT>Build.VERSION_CODES.N){
                intent.setFlags(Intent.FLAG_GRANT_PERSISTABLE_URI_PERMISSION);
                intent.putExtra(Intent.EXTRA_STREAM, FileProvider.getUriForFile(QRGenPage.this,"com.sapience_vision.airportinventory",file));
            }
            else{
                intent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(file));
            }
            intent.setType("image/*");
            startActivity(intent);
        }
        catch(Exception e){
            e.printStackTrace();

        }

    }
}





