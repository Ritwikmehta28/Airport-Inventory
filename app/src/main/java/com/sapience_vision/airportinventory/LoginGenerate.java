package com.sapience_vision.airportinventory;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginGenerate extends AppCompatActivity {
    EditText logins;
    EditText passwords;
    Button loginBscan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_generate);
        logins = (EditText)findViewById(R.id.loginScan);
        passwords = (EditText)findViewById(R.id.passGen);
        loginBscan = ( Button)findViewById(R.id.loginBGen);


        loginBscan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(logins.getText().toString().equals("admin")&&passwords.getText().toString().equals("admin")) {
                    Intent intent = new Intent(LoginGenerate.this, AddNewEquip.class);
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(LoginGenerate.this, "Incorrect LoginId or Password . Contact Managemenet", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
