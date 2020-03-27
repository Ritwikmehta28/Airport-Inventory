package com.sapience_vision.airportinventory;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import static com.sapience_vision.airportinventory.Detailsblock.QRID;

public class ServiceUpdate extends AppCompatActivity {

    EditText DateMaintain;
    EditText ServicePerson;
    EditText Details;
    EditText Others;
    Button Updatedata; 
    DatabaseReference OLA;
    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_update);


        DateMaintain=(EditText)findViewById(R.id.DateMaintain);
        Details=(EditText)findViewById(R.id.Details);
        Others=(EditText)findViewById(R.id.Others);
        ServicePerson=(EditText)findViewById(R.id.ServicePerson);
        Updatedata=(Button)findViewById(R.id.Updatedata);
        OLA= FirebaseDatabase.getInstance().getReference();
        Updatedata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                String Datemaintain=DateMaintain.getText().toString();
                String Serviceperson=ServicePerson.getText().toString();
                String Detail=Details.getText().toString();
                String Other=Others.getText().toString();
                QRDATAS system=new QRDATAS(Datemaintain,Serviceperson,Detail,Other);
                OLA.child(QRID).child("Service details").setValue(system);
                Intent intent = new Intent(ServiceUpdate.this,ServiceDetails.class);
                startActivity(intent);

            }
        });
    }

}





