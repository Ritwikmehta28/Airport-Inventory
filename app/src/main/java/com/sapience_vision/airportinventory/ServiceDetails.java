package com.sapience_vision.airportinventory;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import static com.sapience_vision.airportinventory.AddNewEquip.QRInstall;
import static com.sapience_vision.airportinventory.Detailsblock.QRID;


public class ServiceDetails extends AppCompatActivity {

    Button Servicedata;
    Button button1;
    ListView ListViewItem;
    DatabaseReference DATA;
    List<QRDATAS> qrList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_details);
        Servicedata = (Button) findViewById(R.id.Servicedata);
        ListViewItem = (ListView) findViewById(R.id.ListViewItem);
        DATA= FirebaseDatabase.getInstance().getReference();
        button1 = (Button)findViewById(R.id.addnewR1);
        qrList = new ArrayList<>();

        Servicedata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(ServiceDetails.this, ServiceUpdate.class);
                startActivity(intent1);

            }
        });


      button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(ServiceDetails.this,MainActivity.class);
                startActivity(intent2);

            }
        });
    }
        @Override
        protected void onStart() {
            super.onStart();

            DATA.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    qrList.clear();

                    for(DataSnapshot serviceSnapshot:dataSnapshot.getChildren()){
                        QRDATAS QRdatas= new QRDATAS();
                        QRdatas.setPersonM(dataSnapshot.child(QRID).child("Service details").getValue(QRDATAS.class).getPersonM().toString());
                        QRdatas.setMaintainname(dataSnapshot.child(QRID).child("Service details").getValue(QRDATAS.class).getMaintainname().toString());
                        QRdatas.setDetails1(dataSnapshot.child(QRID).child("Service details").getValue(QRDATAS.class).getDetails1().toString());
                        QRdatas.setDetails2(dataSnapshot.child(QRID).child("Service details").getValue(QRDATAS.class).getDetails2().toString());

                        qrList.add(QRdatas);
                    }

                    qrlist adapter = new qrlist(ServiceDetails.this, qrList);
                    ListViewItem.setAdapter(adapter);
                }
                @Override
                public void onCancelled(DatabaseError databaseError){

                }
            });};
    }





