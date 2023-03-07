package com.souhardya.hotelmetaparse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class AclassActivity extends AppCompatActivity {
        Button plus;
        Button minus;
        TextView number;
        int num =0;
        String numb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aclass);
        number = findViewById(R.id.number);
        Intent intent2 = getIntent();
        plus = findViewById(R.id.plus);
        minus = findViewById(R.id.minus);

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (num < 6) {
                    num += 1;
                    numb = Integer.toString(num);
                    number.setText(numb);
                } else {
                    Toast.makeText(AclassActivity.this, "You can book only upto 6 Rooms", Toast.LENGTH_SHORT).show();
                }
            }
        });
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(num==0){
                    num=0;
                    numb = Integer.toString(num);
                    number.setText(numb);
                }
                else {
                    num -= 1;
                    numb = Integer.toString(num);
                    number.setText(numb);
                }
            }
        });
    }
}