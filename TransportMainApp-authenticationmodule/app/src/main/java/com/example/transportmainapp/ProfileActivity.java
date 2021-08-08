package com.example.transportmainapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Button logout = findViewById(R.id.signOut);
        Button driver_button = findViewById(R.id.driver_button_id);
        Button passenger_button = findViewById(R.id.passenger_button_id);

        logout.setOnClickListener(this);
        driver_button.setOnClickListener(this);
        passenger_button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.signOut:
                startActivity(new Intent(ProfileActivity.this, MainActivity.class));
                break;
            case R.id.driver_button_id:
                startActivity(new Intent(ProfileActivity.this, DriverActivity.class));
                break;
            case R.id.passenger_button_id:
                startActivity(new Intent(ProfileActivity.this, Passenger_Activity.class));
                break;
        }
    }

}