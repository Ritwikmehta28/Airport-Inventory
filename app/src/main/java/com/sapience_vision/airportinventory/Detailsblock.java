package com.sapience_vision.airportinventory;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Detailsblock extends AppCompatActivity {

    TextView ProductID;
    TextView Details;
    TextView Installation;
    TextView PersonI;
    TextView Specification;
    DatabaseReference DATA;
    DatabaseReference Check;
    Button button;
    Button button1;

    public static String QRID;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailsblock);

        ProductID = (TextView) findViewById(R.id.ProductID);
        Details = (TextView) findViewById(R.id.Details);
        Installation = (TextView) findViewById(R.id.Installation);
        PersonI = (TextView) findViewById(R.id.PersonI);
        Specification = (TextView) findViewById(R.id.Specification);
        DATA = FirebaseDatabase.getInstance().getReference();

        button = (Button) findViewById(R.id.MORE);
        button1 = (Button) findViewById(R.id.addnewR);

        button.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View v) {

                                          if (QRID == null) {
                                              Toast.makeText(Detailsblock.this, "No DATA", Toast.LENGTH_SHORT).show();
                                          } else {
                                              Check = FirebaseDatabase.getInstance().getReference(QRID).child("Service Details");
                                              String check = Check.push().getKey();
                                              if (check == null) {
                                                  Toast.makeText(Detailsblock.this, "No SERVICE DATA", Toast.LENGTH_SHORT).show();
                                              } else
                                                  {
                                                  Intent intent = new Intent(Detailsblock.this, ServiceDetails.class);
                                                  startActivity(intent);
                                                  }
                                          }
                                      }

                                      ;
                                  }
        );

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Detailsblock.this, ServiceUpdate.class);
                startActivity(intent);
            }
        });
    }



    @Override
    protected void onStart() {
        super.onStart();
        DATA.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {
              for(DataSnapshot Installsnapshot: dataSnapshot.getChildren())
              {
                  QRDATAI system=new QRDATAI();
                  system.setID(dataSnapshot.child(QRID).child("Installation details").getValue(QRDATAI.class).getID());
                  system.setDetails(dataSnapshot.child(QRID).child("Installation details").getValue(QRDATAI.class).getDetails());
                  system.setInstallation(dataSnapshot.child(QRID).child("Installation details").getValue(QRDATAI.class).getInstallation());
                  system.setPerson(dataSnapshot.child(QRID).child("Installation details").getValue(QRDATAI.class).getPerson());
                  system.setSpecification(dataSnapshot.child(QRID).child("Installation details").getValue(QRDATAI.class).getSpecification());
                  ProductID.setText(system.getID());
                  Details.setText(system.getDetails());
                  Installation.setText(system.getInstallation());
                  PersonI.setText(system.getPerson());
                  Specification.setText(system.getSpecification());
              }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }


        });
    }
}
