package com.example.transportmainapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class PassengerActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passenger);

        Intent intent = getIntent();

        TextView route1 = findViewById(R.id.route1);
        TextView route2 = findViewById(R.id.route2);
        TextView route3 = findViewById(R.id.route3);
        TextView route4 = findViewById(R.id.route4);
        Button back = findViewById(R.id.pass_back_1);

        route1.setOnClickListener(this);
        route2.setOnClickListener(this);
        route3.setOnClickListener(this);
        route4.setOnClickListener(this);
        back.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.route1:
                startActivity(new Intent(PassengerActivity.this, Pickup1.class));
                break;
            case R.id.route2:
                startActivity(new Intent(PassengerActivity.this, Pickup2.class));
                break;
            case R.id.route3:
                startActivity(new Intent(PassengerActivity.this, Pickup3.class));
                break;
            case R.id.route4:
                startActivity(new Intent(PassengerActivity.this, Pickup4.class));
                break;
            case R.id.pass_back_1:
                startActivity(new Intent(PassengerActivity.this, ProfileActivity.class));
                break;
        }
    }
}
