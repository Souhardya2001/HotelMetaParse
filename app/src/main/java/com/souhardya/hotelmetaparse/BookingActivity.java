package com.souhardya.hotelmetaparse;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class BookingActivity extends AppCompatActivity {
            CalendarView calenderview;
            TextView todaydate;
            Button button;
            Button button1;
            Button button2;
            String data;
            TextView text;
            TextView text1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);
        todaydate = findViewById(R.id.todaydate);
        calenderview =  findViewById(R.id.calendarView);
        Intent intent1 = getIntent();
        button = findViewById(R.id.button3);
        button1 = findViewById(R.id.button4);
        button2 = findViewById(R.id.button7);
        Intent intent2 = new Intent(this, AclassActivity.class);
        Intent intent3 = new Intent(this , ExclassActivity.class);
        Intent intent4 = new Intent(this , NormalclassActivity.class);
        text = findViewById(R.id.textdata);
        text1 = findViewById(R.id.text1);
        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calenderview.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
                    @Override
                    public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int day) {
                        String date = (day)+"/"+(month+1)+"/"+year;
                        text1.setText(date);
//                        data = date;
                    }
                });
            }
        });
       calenderview.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
           @Override
           public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int day) {
               String date = (day)+"/"+(month+1)+"/"+year;
               todaydate.setText(date);
               data = date;
           }
       });
       button.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               if(data==null){
                   Toast.makeText(BookingActivity.this, "Select a date to continue", Toast.LENGTH_SHORT).show();
               }
               else {

                    startActivity(intent2);
               }
           }
       });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(data==null){
                    Toast.makeText(BookingActivity.this, "Select a date to continue", Toast.LENGTH_SHORT).show();
                }
                else {

                    startActivity(intent3);
                }
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(data==null){
                    Toast.makeText(BookingActivity.this, "Select a date to continue", Toast.LENGTH_SHORT).show();
                }
                else {

                    startActivity(intent4);
                }
            }
        });
    }


}