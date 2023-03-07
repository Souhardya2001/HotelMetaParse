package com.souhardya.hotelmetaparse;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;

public class SignupActivity extends AppCompatActivity {
    static final int RC_SIGN_IN =100 ;
    EditText username;
        EditText password;
        EditText cnfpass;
        Button Signup;
//        GoogleSignInClient mGoogleSignInClient;
//        String personname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        Intent intent = getIntent();
        username = findViewById(R.id.username1);
        password = findViewById(R.id.password1);
        Signup = findViewById(R.id.Signup);
        cnfpass = findViewById(R.id.cnfpass);

//        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
//                .requestEmail()
//                .build();
//        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
//        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);
//        SignInButton signInButton = findViewById(R.id.sign_in_button);
//        signInButton.setSize(SignInButton.SIZE_STANDARD);
        DBHelper DB = new DBHelper(this);

        Signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = username.getText().toString();
                String pass = password.getText().toString();
                String repass = cnfpass.getText().toString();
                if (name.equals("") || pass.equals("") || repass.equals(""))
                    Toast.makeText(SignupActivity.this, "Please Enter the Credentials", Toast.LENGTH_SHORT).show();
                else if (pass.equals(repass)) {
                    Boolean checkuser = DB.checkusername(name);
                    if (checkuser == false) {
                        Boolean insert = DB.inserting(name, pass);
                        if (insert == true) {
                            Toast.makeText(SignupActivity.this, "Profile created Succesfully", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }

        });
//        signInButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                signIn();
//            }
//        });
//    }
//        private void signIn() {
//            Intent signInIntent = mGoogleSignInClient.getSignInIntent();
//            startActivityForResult(signInIntent, RC_SIGN_IN);
//        }
//    @Override
//    public void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//
//        // Result returned from launching the Intent from GoogleSignInClient.getSignInIntent(...);
//        if (requestCode == RC_SIGN_IN) {
//            // The Task returned from this call is always completed, no need to attach
//            // a listener.
//            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
//            handleSignInResult(task);
//        }
//    }
//    private void handleSignInResult(Task<GoogleSignInAccount> completedTask) {
//        try {
//            GoogleSignInAccount account = completedTask.getResult(ApiException.class);
//            GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(this);
//            if (acct != null) {
//                String personName = acct.getDisplayName();
//                personname = personName;
//                String personGivenName = acct.getGivenName();
//                String personFamilyName = acct.getFamilyName();
//                String personEmail = acct.getEmail();
//                String personId = acct.getId();
//                Uri personPhoto = acct.getPhotoUrl();
//                Toast.makeText(this, "User Email : "+personEmail, Toast.LENGTH_SHORT).show();
//            }
//
//            // Signed in successfully, show authenticated UI.
//            Intent intent4 = new Intent(this , MainActivity2.class);
//            intent4.putExtra("MESSAGENAME",personname);
//
//        startActivity(intent4);
//        } catch (ApiException e) {
//            // The ApiException status code indicates the detailed failure reason.
//            // Please refer to the GoogleSignInStatusCodes class reference for more information.
//            Log.w(TAG, "signInResult:failed code=" + e.getStatusCode());
//           ;
//        }
    }
}