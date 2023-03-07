package com.souhardya.hotelmetaparse;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.auth.api.identity.SignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

public class MainActivity2 extends AppCompatActivity {
            TextView textview;
            Button bookbutton;
            Button signout;
            GoogleSignInClient mGoogleSignInClient;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        textview = findViewById(R.id.textView5);
//        Intent intent = getIntent();
//        String nameText = intent.getStringExtra("USERNAME");
//        textview.setText("Hi "+nameText);
        Intent intent = getIntent();
        String nameText;
        nameText = intent.getStringExtra("MESSAGENAME");


            textview.setText("Hi "+nameText);



        bookbutton = findViewById(R.id.bookbutton);
        signout = findViewById(R.id.signout);
        Intent intent1 = new Intent(this,BookingActivity.class);
        bookbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               startActivity(intent1);
            }
        });
        signout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signOut();
            }
        });


    }
    private void signOut() {

        mGoogleSignInClient.signOut()
                .addOnCompleteListener(this, new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        // ...
                    }
                });
    }
    private void revokeAccess() {
        mGoogleSignInClient.revokeAccess()
                .addOnCompleteListener(this, new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        // ...
                    }
                });
    }


}