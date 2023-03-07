package com.souhardya.hotelmetaparse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void openActivity(View v){
                Intent intent = new Intent(this ,LoginActivity.class);
                startActivity(intent);
    }
    public void secondActivity(View V){
        Intent intent = new Intent(this , SignupActivity.class);
        startActivity(intent);
    }
}