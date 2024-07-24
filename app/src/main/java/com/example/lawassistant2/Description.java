package com.example.lawassistant2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Description extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);
        DBLawyer db;
        EditText e1, e2;
        db = new DBLawyer(this);
        Button b;
        e1 = findViewById(R.id.editLocation);
        e2 = findViewById(R.id.editCaseType);
        b = findViewById(R.id.btnSearch);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String location = e1.getText().toString();
                String caseType = e2.getText().toString();


                Cursor cursor = db.getLawyers(caseType, location);


                if (cursor.moveToFirst()) {
                    do {
                        // Retrieve data from the cursor
                        @SuppressLint("Range") String lawyerName = cursor.getString(cursor.getColumnIndex(DBLawyer.l_name));
                        @SuppressLint("Range") String lawyerContact = cursor.getString(cursor.getColumnIndex(DBLawyer.l_contact));
                        @SuppressLint("Range") String lawyerExperience = cursor.getString(cursor.getColumnIndex(DBLawyer.l_experience));
                        @SuppressLint("Range") String oa = cursor.getString(cursor.getColumnIndex(DBLawyer.l_officeadd));
                        @SuppressLint("Range") String ot = cursor.getString(cursor.getColumnIndex(DBLawyer.l_officetime));
                        @SuppressLint("Range") String ct = cursor.getString(cursor.getColumnIndex(DBLawyer.l_casetype));

                        String result = "Name: " + lawyerName + "\nContact: " + lawyerContact + "\nExperience: " + lawyerExperience +"\nOffice Address: " + oa
                                +"\nOffice Time "+ot +"\nCase Type "+ct;
                        Intent intent = new Intent(Description.this, Final.class);
                        intent.putExtra("resultData", result);
                        startActivity(intent);

                    } while (cursor.moveToNext());
                } else {

                    Toast.makeText(Description.this, "No lawyers found for the given case type and location", Toast.LENGTH_SHORT).show();
                }
                cursor.close();
            }
        });
    }
}