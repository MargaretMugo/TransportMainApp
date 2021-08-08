package com.example.transportmainapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;


public class PickTime extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pickuptime);
        Button pickuptime1 = findViewById(R.id.pickuptime1);
        pickuptime1.setOnClickListener(this);
        Button pickuptime2 = findViewById(R.id.pickuptime2);
        pickuptime2.setOnClickListener(this);
        Button pickuptime3 = findViewById(R.id.pickuptime3);
        pickuptime3.setOnClickListener(this);
        Button pickuptime4 = findViewById(R.id.pickuptime4);
        pickuptime4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.pickuptime1:
                startActivity(new Intent(PickTime.this, BookActivity.class));
                break;
            case R.id.pickuptime2:
                startActivity(new Intent(PickTime.this, BookActivity.class));
                break;
            case R.id.pickuptime3:
                startActivity(new Intent(PickTime.this, BookActivity.class));
                break;
            case R.id.pickuptime4:
                startActivity(new Intent(PickTime.this, BookActivity.class));
                break;
        }
    }
}