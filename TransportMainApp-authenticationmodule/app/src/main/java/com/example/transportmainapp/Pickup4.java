package com.example.transportmainapp;

import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Pickup4 extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pickup4);
        Button route4_pickup1 = findViewById(R.id.route4_pickup1);
        route4_pickup1.setOnClickListener(this);
        Button route4_pickup2 = findViewById(R.id.route4_pickup2);
        route4_pickup2.setOnClickListener(this);
        Button route4_pickup3 = findViewById(R.id.route4_pickup3);
        route4_pickup3.setOnClickListener(this);
        Button route4_pickup4 = findViewById(R.id.route4_pickup4);
        route4_pickup4.setOnClickListener(this);
        Button route4_pickup5 = findViewById(R.id.route4_pickup5);
        route4_pickup5.setOnClickListener(this);
        Button back = findViewById(R.id.pass_back_5);
        back.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.route4_pickup1:
                startActivity(new Intent(Pickup4.this, Dropoff.class));
                break;
            case R.id.route4_pickup2:
                startActivity(new Intent(Pickup4.this, Dropoff.class));
                break;
            case R.id.route4_pickup3:
                startActivity(new Intent(Pickup4.this, Dropoff.class));
                break;
            case R.id.route4_pickup4:
                startActivity(new Intent(Pickup4.this, Dropoff.class));
                break;
            case R.id.route4_pickup5:
                startActivity(new Intent(Pickup4.this, Dropoff.class));
                break;
            case R.id.pass_back_5:
                startActivity(new Intent(Pickup4.this, Passenger_Activity.class));
                break;
        }
    }
}