package com.sapience_vision.airportinventory;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddNewEquip extends AppCompatActivity {

    EditText editTextId;
    EditText editTextDet;
    EditText editTextInst;
    EditText editTextPers;
    EditText editTextSpec;
   public static DatabaseReference QRInstall;
    Button additem;
    Button generateB;
    public static String Productkey;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_equip);

         editTextId=(EditText) findViewById(R.id.editTextId);
         generateB = (Button) findViewById(R.id.generateQR);
         editTextDet=(EditText) findViewById(R.id.editTextDetail);
         editTextInst=(EditText) findViewById(R.id.editTextInstall);
         editTextPers=(EditText) findViewById(R.id.editTextPerson);
         editTextSpec=(EditText) findViewById(R.id.editTextSpecification);
         QRInstall= FirebaseDatabase.getInstance().getReference();
         Productkey=QRInstall.push().getKey();
         QRGenPage.id= Productkey;
         additem=(Button)findViewById(R.id.addItem);

        final String ID =editTextId.getText().toString();
        final String details =editTextDet.getText().toString();
        final String installation =editTextInst.getText().toString();
        final String person =editTextPers.getText().toString();
        final String specification =editTextSpec.getText().toString();



         additem.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                  String ID =editTextId.getText().toString();
                  String details =editTextDet.getText().toString();
                  String installation =editTextInst.getText().toString();
                 String person =editTextPers.getText().toString();
                  String specification =editTextSpec.getText().toString();



                 QRDATAI data = new QRDATAI();
                     data.SetInstallationData(ID, details, installation, person, specification);
                     QRInstall.child(Productkey).child("Installation details").setValue(data);
                     Toast.makeText(AddNewEquip.this, "Added Item to Database.", Toast.LENGTH_SHORT).show();
                 }

         });

         generateB.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Intent intent = new Intent(AddNewEquip.this,QRGenPage.class);
                 startActivity(intent);
             }
         });

    }
}
