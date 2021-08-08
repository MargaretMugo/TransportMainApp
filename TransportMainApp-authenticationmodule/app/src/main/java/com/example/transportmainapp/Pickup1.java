package com.example.transportmainapp;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Pickup1 extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pickup1);
        Button route1_pickup1 = findViewById(R.id.route1_pickup1);
        route1_pickup1.setOnClickListener(this);

        Button route1_pickup2 = findViewById(R.id.route1_pickup2);
        route1_pickup2.setOnClickListener(this);

        Button route1_pickup3 = findViewById(R.id.route1_pickup3);
        route1_pickup3.setOnClickListener(this);

        Button route1_pickup4 = findViewById(R.id.route1_pickup4);
        route1_pickup4.setOnClickListener(this);

        Button route1_pickup5 = findViewById(R.id.route1_pickup5);
        route1_pickup5.setOnClickListener(this);

        Button route1_pickup6 = findViewById(R.id.route1_pickup6);
        route1_pickup6.setOnClickListener(this);

        Button back = findViewById(R.id.pass_back_2);
        back.setOnClickListener(this);

    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.route1_pickup1:
                startActivity(new Intent(Pickup1.this, Dropoff.class));
                break;
            case R.id.route1_pickup2:
                startActivity(new Intent(Pickup1.this, Dropoff.class));
                break;
            case R.id.route1_pickup3:
                startActivity(new Intent(Pickup1.this, Dropoff.class));
                break;
            case R.id.route1_pickup4:
                startActivity(new Intent(Pickup1.this, Dropoff.class));
                break;
            case R.id.route1_pickup5:
                startActivity(new Intent(Pickup1.this, Dropoff.class));
                break;
            case R.id.route1_pickup6:
                startActivity(new Intent(Pickup1.this, Dropoff.class));
                break;
            case R.id.pass_back_2:
                startActivity(new Intent(Pickup1.this, Passenger_Activity.class));
                break;
            default:
                break;
        }

    }
}
