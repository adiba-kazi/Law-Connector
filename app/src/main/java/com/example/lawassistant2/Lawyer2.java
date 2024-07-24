package com.example.lawassistant2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Lawyer2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lawyer2);
        Button b1,b2;
        b1=findViewById(R.id.button3);
        b2=findViewById(R.id.button4);
        Toast.makeText(Lawyer2.this,"If you have already have account then login otherwise signin",Toast.LENGTH_LONG).show();
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Lawyer2.this, Lregister.class);
                startActivity(intent);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Lawyer2.this, llogin.class);
                startActivity(intent);
            }
        });
    }
}