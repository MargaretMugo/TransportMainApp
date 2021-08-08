package com.example.transportmainapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;


public class Dropoff extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dropoff);
        Button route_drop1 = findViewById(R.id.route_drop1);
        route_drop1.setOnClickListener(this);
        Button route_drop2 = findViewById(R.id.route_drop2);
        route_drop2.setOnClickListener(this);
        Button route_drop3 = findViewById(R.id.route_drop3);
        route_drop3.setOnClickListener(this);
        Button route_drop4 = findViewById(R.id.route_drop4);
        route_drop4.setOnClickListener(this);
        Button back = findViewById(R.id.pass_back_6);
        back.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.route_drop1:
                startActivity(new Intent(Dropoff.this, PickTime.class));
                break;
            case R.id.route_drop2:
                startActivity(new Intent(Dropoff.this, PickTime.class));
                break;
            case R.id.route_drop3:
                startActivity(new Intent(Dropoff.this, PickTime.class));
                break;
            case R.id.route_drop4:
                startActivity(new Intent(Dropoff.this, PickTime.class));
                break;
            case R.id.pass_back_6:
                startActivity(new Intent(Dropoff.this, Passenger_Activity.class));
                break;
        }
    }
}