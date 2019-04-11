package com.dateandtime;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {
    private TextView tvdate, tvtime;
    String date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvdate = findViewById(R.id.tvdate);
        tvtime = findViewById(R.id.tvtime);

        tvdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadDatePicker();
            }
        });

        tvtime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadTime();
            }
        });

    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        String monthname = "";

        switch (month) {
            case 0:
                monthname = "January";
                break;
            case 1:
                monthname = "Febuary";
                break;
            case 2:
                monthname = "March";
                break;
            case 3:
                monthname = "April";
                break;
            case 4:
                monthname = "May";
                break;
            case 5:
                monthname = "June";
                break;
            case 6:
                monthname = "July";
                break;
            case 7:
                monthname = "August";
                break;
            case 8:
                monthname = "September";
                break;
            case 9:
                monthname = "October";
                break;
            case 10:
                monthname = "November";
                break;
            case 11:
                monthname = "December";
                break;

        }

        date = "Month/Day/Year:" + monthname + "/" + dayOfMonth + "/" + year;
        tvdate.setText(date);
    }

    private void loadDatePicker() {
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, this, year, month, day);
        datePickerDialog.show();

    }
    private void loadTime() {
        final Calendar c = Calendar.getInstance();
        final int hour = c.get(Calendar.HOUR);
        int minute = c.get(Calendar.MINUTE);
        int second = c.get(Calendar.SECOND);

        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

                tvtime.setText("Time is:" + hourOfDay + ":" + minute);
            }
        }, hour, minute, false);
        timePickerDialog.show();
    }
}
