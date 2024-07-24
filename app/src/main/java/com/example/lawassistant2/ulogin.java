package com.example.lawassistant2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ulogin extends AppCompatActivity {
    DBLawyer db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ulogin);

        EditText e1, e2;
        e1 = findViewById(R.id.editTextText12);
        e2 = findViewById(R.id.editTextText13);
        Button b = findViewById(R.id.button9);

        db = new DBLawyer(this);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uname = e1.getText().toString().trim();
                String ucontact = e2.getText().toString().trim();
                if (uname.equals("") || ucontact.equals(""))
                    Toast.makeText(ulogin.this, "All fields are mandatory", Toast.LENGTH_SHORT).show();
                else {
                    Boolean checkCredentials = db.verifyLogin1(uname, ucontact);
                    if (checkCredentials == true) {
                        Toast.makeText(ulogin.this, "Login Successfully!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), Description.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(ulogin.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
