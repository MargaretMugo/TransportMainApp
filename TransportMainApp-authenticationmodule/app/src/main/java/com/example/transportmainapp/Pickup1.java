package com.example.transportmainapp;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

import androidx.appcompat.app.AppCompatActivity;

public class Pickup1 extends AppCompatActivity implements View.OnClickListener {
    EditText date, edit_drop, edit_pickup;
    DatePickerDialog datePickerDialog;
    Spinner spinner1, spinner2, spinner3;
    Button schedule_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pickup1);
        addListenerOnSpinnerItemSelection();
        schedule_button = (Button) findViewById(R.id.schedule_button);
        schedule_button.setOnClickListener(this);
        edit_drop = (EditText) findViewById(R.id.edit_drop);
        edit_pickup = (EditText) findViewById(R.id.edit_pickup);
        date = (EditText) findViewById(R.id.date);
        date.setOnClickListener(this);
    }

            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.date:
                final Calendar c = Calendar.getInstance();
                int mYear = c.get(Calendar.YEAR); // current year
                int mMonth = c.get(Calendar.MONTH); // current month
                int mDay = c.get(Calendar.DAY_OF_MONTH); // current day
                // date picker dialog
                datePickerDialog = new DatePickerDialog(Pickup1.this,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                // set day of month , month and year value in the edit text
                                date.setText(dayOfMonth + "/"
                                        + (monthOfYear + 1) + "/" + year);

                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();
                break;
                case R.id.schedule_button:
                    String string1 = edit_pickup.getText().toString();
                    String str2 = edit_drop.getText().toString();

                    Intent intent = new Intent(getApplicationContext(), BookActivity.class);
                    intent.putExtra("message_key", string1);
                    intent.putExtra("message_key", str2);
                    startActivity(intent);
                    break;
            }
        }
    public void addListenerOnSpinnerItemSelection() {
        spinner1 = (Spinner) findViewById(R.id.spinner1);
        spinner1.setOnItemSelectedListener(new CustomOnItemSelectedListener());

        spinner2 = (Spinner) findViewById(R.id.spinner2);
        spinner2.setOnItemSelectedListener(new CustomOnItemSelectedListener());

        spinner3 = (Spinner) findViewById(R.id.spinner3);
        spinner3.setOnItemSelectedListener(new CustomOnItemSelectedListener());
    }

    }

