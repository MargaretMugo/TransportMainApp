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

        Button route1 = findViewById(R.id.book_pickup);
        route1.setOnClickListener(this);

        Button route2 = findViewById(R.id.view_trips);
        route2.setOnClickListener(this);

        Button back = findViewById(R.id.pass_back_1);
        back.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.book_pickup:
                startActivity(new Intent(Passenger_Activity.this, Pickup1.class));
                break;
            case R.id.view_trips:
                startActivity(new Intent(Passenger_Activity.this, Pickup2.class));
            break;
            case R.id.pass_back_1:
                startActivity(new Intent(Passenger_Activity.this, ProfileActivity.class));
                break;
            default :
                break;
        }
    }
}
