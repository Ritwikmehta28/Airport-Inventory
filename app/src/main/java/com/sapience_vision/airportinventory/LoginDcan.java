package com.sapience_vision.airportinventory;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginDcan extends AppCompatActivity {
    EditText logins;
    EditText passwords;
    Button loginBscan1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_dcan);

        logins = (EditText)findViewById(R.id.loginScan);
        passwords = (EditText)findViewById(R.id.passScan);
        loginBscan1 = ( Button)findViewById(R.id.loginBscan);


        loginBscan1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (logins.getText().toString().equals("admin") && passwords.getText().toString().equals("admin")) {
                    Intent intent = new Intent(LoginDcan.this, ScanOrId.class);
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(LoginDcan.this, "Incorrect LoginId or Password . Contact Managemenet", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
