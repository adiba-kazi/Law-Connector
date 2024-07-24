package com.example.lawassistant2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Uregister extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uregister);
        DBLawyer db;
        EditText e1, e2, e3;
        Button b = findViewById(R.id.button8);

        e1 = findViewById(R.id.editTextText9);
        e2 = findViewById(R.id.editTextText10);
        e3 = findViewById(R.id.editTextText11);

        db=new DBLawyer(Uregister.this);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id= e1.getText().toString();
                String name=e2.getText().toString();
                String ct=e3.getText().toString();

                if(name.isEmpty() || ct.isEmpty())
                {
                    Toast.makeText(Uregister.this,"Please enters all data", Toast.LENGTH_SHORT).show();
                }
                else {
                    long result=db.insertUser(name,ct);
                    if(result !=-1)
                    {
                        Toast.makeText(Uregister.this,"Data has been Inserted", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(Uregister.this,"Error Inserting data", Toast.LENGTH_SHORT).show();
                    }
                    e1.setText("");
                    e2.setText("");
                    e3.setText("");
                }
            }
        });
    }
}