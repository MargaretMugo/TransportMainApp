package com.example.transportmainapp;

import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Pickup3 extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pickup3);

        Button route3_pickup1 = findViewById(R.id.route3_pickup1);
        route3_pickup1.setOnClickListener(this);
        Button route3_pickup2 = findViewById(R.id.route3_pickup2);
        route3_pickup2.setOnClickListener(this);
        Button route3_pickup3 = findViewById(R.id.route3_pickup3);
        route3_pickup3.setOnClickListener(this);
        Button route3_pickup4 = findViewById(R.id.route3_pickup4);
        route3_pickup4.setOnClickListener(this);
        Button route3_pickup5 = findViewById(R.id.route3_pickup5);
        route3_pickup5.setOnClickListener(this);
        Button route3_pickup6 = findViewById(R.id.route3_pickup6);
        route3_pickup6.setOnClickListener(this);
        Button route3_pickup7 = findViewById(R.id.route3_pickup7);
        route3_pickup7.setOnClickListener(this);
        Button route3_pickup8 = findViewById(R.id.route3_pickup8);
        route3_pickup8.setOnClickListener(this);
        Button route3_pickup9 = findViewById(R.id.route3_pickup9);
        route3_pickup9.setOnClickListener(this);
        Button back = findViewById(R.id.pass_back_4);
        back.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.route3_pickup1:
                startActivity(new Intent(Pickup3.this, Dropoff.class));
                break;
            case R.id.route3_pickup2:
                startActivity(new Intent(Pickup3.this, Dropoff.class));
                break;
            case R.id.route3_pickup3:
                startActivity(new Intent(Pickup3.this, Dropoff.class));
                break;
            case R.id.route3_pickup4:
                startActivity(new Intent(Pickup3.this, Dropoff.class));
                break;
            case R.id.route3_pickup5:
                startActivity(new Intent(Pickup3.this, Dropoff.class));
                break;
            case R.id.route3_pickup6:
                startActivity(new Intent(Pickup3.this, Dropoff.class));
                break;
            case R.id.route3_pickup7:
                startActivity(new Intent(Pickup3.this, Dropoff.class));
                break;
            case R.id.route3_pickup8:
                startActivity(new Intent(Pickup3.this, Dropoff.class));
                break;
            case R.id.route3_pickup9:
                startActivity(new Intent(Pickup3.this, Dropoff.class));
                break;
            case R.id.pass_back_4:
                startActivity(new Intent(Pickup3.this, Passenger_Activity.class));
                break;
        }
    }
}

