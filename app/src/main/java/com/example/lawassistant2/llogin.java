package com.example.lawassistant2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class llogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_llogin);
        DBLawyer db;
        db = new DBLawyer(this);

        EditText e1 = findViewById(R.id.username1);
        EditText e2 = findViewById(R.id.password1);
        Button b = findViewById(R.id.btnlogin);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = e1.getText().toString();
                String contact = e2.getText().toString();

                Log.d("llogin", "Username: " + username);
                Log.d("llogin", "Contact: " + contact);

                if (db.verifyLogin(username, contact)) {
                    Toast.makeText(llogin.this, "Login Successful!", Toast.LENGTH_SHORT).show();
                    Cursor cursor = db.getLawyers(username, contact);

                    if (cursor.moveToFirst()) {
                        @SuppressLint("Range") String lawyerName = cursor.getString(cursor.getColumnIndex(DBLawyer.l_name));
                        @SuppressLint("Range") String lawyerContact = cursor.getString(cursor.getColumnIndex(DBLawyer.l_contact));
                        @SuppressLint("Range") String lawyerExperience = cursor.getString(cursor.getColumnIndex(DBLawyer.l_experience));
                        @SuppressLint("Range") String oa = cursor.getString(cursor.getColumnIndex(DBLawyer.l_officeadd));
                        @SuppressLint("Range") String ot = cursor.getString(cursor.getColumnIndex(DBLawyer.l_officetime));
                        @SuppressLint("Range") String ct = cursor.getString(cursor.getColumnIndex(DBLawyer.l_casetype));

                        String result = "Name: " + lawyerName + "\nContact: " + lawyerContact +
                                "\nExperience: " + lawyerExperience + "\nOffice Address: " + oa +
                                "\nOffice Time " + ot + "\nCase Type " + ct;

                        Intent intent = new Intent(llogin.this, Final2.class);
                        intent.putExtra("resultData", result);
                        startActivity(intent);  // Move this line inside the if block
                    }
                    cursor.close();
                } else {
                    Toast.makeText(llogin.this, "Login Failed!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}