package com.example.transportmainapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class BookActivity extends AppCompatActivity implements View.OnClickListener {
    TextView receiver1_msg;
    TextView receiver2_msg;
    RadioGroup radioGroup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        receiver1_msg = (TextView)findViewById(R.id.pickup_value);
        receiver2_msg = (TextView)findViewById(R.id.drop_value);
        radioGroup = (RadioGroup)findViewById(R.id.groupradio);

        Button payment = findViewById(R.id.payment_btn);
        payment.setOnClickListener(this);

        radioGroup.clearCheck();

        // create the get Intent object
        Intent intent = getIntent();

        // receive the value by getStringExtra() method
        // and key must be same which is send by first activity
        String string1 = intent.getStringExtra("message_key");
        String str2 = intent.getStringExtra("message_key");
        // display the string into textView
        receiver1_msg.setText(string1);
        receiver2_msg.setText(str2);

        radioGroup.setOnCheckedChangeListener(
                new RadioGroup
                        .OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup group,
                                                 int checkedId)
                    {

                        // Get the selected Radio Button
                        RadioButton
                                radioButton
                                = (RadioButton)group
                                .findViewById(checkedId);
                    }
                });
                }
    @Override
    public void onClick(View v){
        switch (v.getId()) {
            case R.id.payment_btn:
                startActivity(new Intent(BookActivity.this, MpesaActivity.class));
                break;
            default:
                break;
        }
    }
    }
