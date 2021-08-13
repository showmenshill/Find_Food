package com.find.find_food.Add_Item;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.find.find_food.R;
import com.google.android.material.textfield.TextInputEditText;

public class Manager_Activity extends AppCompatActivity {
    TextInputEditText username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager_);
        username = findViewById(R.id.emailIT);
        password = findViewById(R.id.itemPasswordIT);
    }

    public void Login(View view) {
        String Username = username.getText().toString();
        String Password = password.getText().toString();

        if (Username.isEmpty()||Password.isEmpty()){
            Toast.makeText(this, "Input username and password!", Toast.LENGTH_SHORT).show();
        }
        if(!Username.contains("Admin") && !Password.contains("12345")){
            Toast.makeText(this, "Invalid Username or Password", Toast.LENGTH_SHORT).show();
        }
        if (Username.contains("Admin") && Password.contains("12345")){
            startActivity(new Intent(Manager_Activity.this, Item_Add_Activity.class));
            Toast.makeText(this, "Logged In", Toast.LENGTH_SHORT).show();
        }

    }
}