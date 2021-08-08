package com.example.transportmainapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Pickup2 extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pickup2);

        Button route2_pickup1 = findViewById(R.id.route2_pickup1);
        route2_pickup1.setOnClickListener(this);

        Button route2_pickup2 = findViewById(R.id.route2_pickup2);
        route2_pickup2.setOnClickListener(this);

        Button route2_pickup3 = findViewById(R.id.route2_pickup3);
        route2_pickup3.setOnClickListener(this);

        Button route2_pickup4 = findViewById(R.id.route2_pickup4);
        route2_pickup4.setOnClickListener(this);

        Button route2_pickup5 = findViewById(R.id.route2_pickup5);
        route2_pickup5.setOnClickListener(this);

        Button route2_pickup6 = findViewById(R.id.route2_pickup6);
        route2_pickup6.setOnClickListener(this);

        Button back = findViewById(R.id.pass_back_3);
        back.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.route2_pickup1:
                startActivity(new Intent(Pickup2.this, Dropoff.class));
                break;
            case R.id.route2_pickup2:
                startActivity(new Intent(Pickup2.this, Dropoff.class));
                break;
            case R.id.route2_pickup3:
                startActivity(new Intent(Pickup2.this, Dropoff.class));
                break;
            case R.id.route2_pickup4:
                startActivity(new Intent(Pickup2.this, Dropoff.class));
                break;
            case R.id.route2_pickup5:
                startActivity(new Intent(Pickup2.this, Dropoff.class));
                break;
            case R.id.route2_pickup6:
                startActivity(new Intent(Pickup2.this, Dropoff.class));
                break;
            case R.id.pass_back_3:
                startActivity(new Intent(Pickup2.this, Passenger_Activity.class));
                break;
            default:
                break;
        }

    }
}