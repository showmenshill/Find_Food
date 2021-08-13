package com.find.find_food;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    TextInputEditText EmailIT, PasswordIT;
    FirebaseAuth firebaseAuth;
    Button loginBTN;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EmailIT = findViewById(R.id.emailIT);
        PasswordIT = findViewById(R.id.itemPasswordIT);
        loginBTN = findViewById(R.id.submitItemBTN);


        loginBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = EmailIT.getText().toString().trim();
                String password = PasswordIT.getText().toString().trim();
                firebaseAuth = firebaseAuth.getInstance();

                if (TextUtils.isEmpty(email)) {
                    EmailIT.setError("Email is required");
                    return;
                }
                if (password.length() < 6) {
                    PasswordIT.setError("Password should not be less than 6");
                    return;
                }

                //authenticate the user:

                firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            startActivity(new Intent(MainActivity.this, Home_Page_Activity.class));
                            Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Toast.makeText(MainActivity.this, "Login Failed! "+task.getException().getMessage(), Toast.LENGTH_SHORT).show();

                        }
                    }
                });

            }
        });

    }
    public void UserRegistration(View view) {
        startActivity(new Intent(MainActivity.this, User_Registration_Activity.class));
    }

}