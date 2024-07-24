package com.example.lawassistant2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Lregister extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DBLawyer db;
        setContentView(R.layout.activity_lregister);
        TextView t;
        EditText e1,e2,e3,e4,e5,e6,e7,e8;
        Button b;
        e1=findViewById(R.id.editTextText8);//id
        e2=findViewById(R.id.editTextText); //name
        e3=findViewById(R.id.editTextText2); //case type
        e4=findViewById(R.id.editTextText3); //location
        e5=findViewById(R.id.editTextText4); //contact
        e6=findViewById(R.id.editTextText5); //experience
        e7=findViewById(R.id.editTextText6); //office address
        e8=findViewById(R.id.editTextText7); //office time
        b=findViewById(R.id.button5); //save
        db=new DBLawyer(Lregister.this);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //String id= e1.getText().toString();
                String name=e2.getText().toString();
                String ct=e3.getText().toString();
                String loc=e4.getText().toString();
                String con=e5.getText().toString();
                String exp=e6.getText().toString();
                String oadd=e7.getText().toString();
                String otime=e8.getText().toString();
                if(name.isEmpty() || ct.isEmpty() || loc.isEmpty() || con.isEmpty() || exp.isEmpty() || oadd.isEmpty() || otime.isEmpty())
                {
                    Toast.makeText(Lregister.this,"Please enters all data", Toast.LENGTH_SHORT).show();
                }
                else {
                    long result=db.insertLawyer(name,ct,loc,con,exp,oadd,otime);
                    if(result !=-1)
                    {
                        Toast.makeText(Lregister.this,"Data has been Inserted", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(Lregister.this,"Error Inserting data", Toast.LENGTH_SHORT).show();
                    }
                    //e1.setText("");
                    e2.setText("");
                    e3.setText("");
                    e4.setText("");
                    e5.setText("");
                    e6.setText("");
                    e7.setText("");
                    e8.setText("");
                }
            }
        });
    }
}