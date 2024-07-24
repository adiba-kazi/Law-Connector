package com.example.lawassistant2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class Final extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);
        String resultData = getIntent().getStringExtra("resultData");

        // Log the received data (check in Logcat)
        Log.d("ResultActivity", "Received data: " + resultData);

        // Display the data in a TextView or any other view
        TextView resultTextView = findViewById(R.id.resultTextView);
        resultTextView.setText(resultData);
    }
}