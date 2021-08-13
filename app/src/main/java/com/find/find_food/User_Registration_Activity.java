package com.find.find_food;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.find.find_food.Add_Item.Manager_Activity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class User_Registration_Activity extends AppCompatActivity {
    TextInputEditText username, email, password;
    FirebaseAuth firebaseAuth;
    Button registrationBTN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user__registration_);
        username = findViewById(R.id.userIT);
        email = findViewById(R.id.emailIT);
        password = findViewById(R.id.itemPasswordIT);
        registrationBTN = findViewById(R.id.registrationBTN);
        firebaseAuth = FirebaseAuth.getInstance();


        registrationBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Username = username.getText().toString().trim();
                String Email = email.getText().toString().trim();
                String Password = password.getText().toString().trim();

                if (TextUtils.isEmpty(Email)) {
                    email.setError("Email is required");
                    return;
                }
                if (TextUtils.isEmpty(Username)) {
                    username.setError("Username is required");
                    return;
                }
                if (Password.length() < 6) {
                    password.setError("Password should not be less than 6");
                    return;
                }

                firebaseAuth.createUserWithEmailAndPassword(Email, Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(User_Registration_Activity.this, "Registration Complete", Toast.LENGTH_SHORT).show();
                            finish();
                        } else {
                            Toast.makeText(User_Registration_Activity.this, "Failed!" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }

                    }
                });

            }
        });


    }

    public void Manager(View view) {

        startActivity(new Intent(User_Registration_Activity.this, Manager_Activity.class));

    }


}