package com.example.transportmainapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Passenger_Activity extends AppCompatActivity implements View.OnClickListener {
    @Override
     protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_commuter);

        Button route1 = findViewById(R.id.route1);
        route1.setOnClickListener(this);

        Button route2 = findViewById(R.id.route2);
        route2.setOnClickListener(this);

        Button route3 = findViewById(R.id.route3);
        route3.setOnClickListener(this);

        Button route4 = findViewById(R.id.route4);
        route4.setOnClickListener(this);

        Button back = findViewById(R.id.pass_back_1);
        route4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.route1:
                startActivity(new Intent(Passenger_Activity.this, Pickup1.class));
                break;
            case R.id.route2:
                startActivity(new Intent(Passenger_Activity.this, Pickup2.class));
            break;
            case R.id.route3:
                startActivity(new Intent(Passenger_Activity.this, Pickup3.class));
                break;
            case R.id.route4:
                startActivity(new Intent(Passenger_Activity.this, Pickup4.class));
                break;
            case R.id.pass_back_1:
                startActivity(new Intent(Passenger_Activity.this, ProfileActivity.class));
                break;
            default :
                break;
        }
    }
}
