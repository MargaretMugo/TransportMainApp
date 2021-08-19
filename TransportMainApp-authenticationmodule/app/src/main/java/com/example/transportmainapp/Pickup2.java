package com.example.transportmainapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Pickup2 extends AppCompatActivity {
    TextView receiver1_msg;
    TextView receiver2_msg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pickup2);

        receiver1_msg = (TextView)findViewById(R.id.received_value1_id);
        receiver2_msg = (TextView)findViewById(R.id.received_value2_id);

        // create the get Intent object
        Intent intent = getIntent();

        // receive the value by getStringExtra() method
        // and key must be same which is send by first activity
        String str1 = intent.getStringExtra("message_key");
        String str2 = intent.getStringExtra("message_key");
        // display the string into textView
            receiver1_msg.setText(str1);
        receiver2_msg.setText(str2);

    }
}