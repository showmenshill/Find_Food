package com.find.find_food.Confirmation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.find.find_food.R;

public class Confirmation_Activity extends AppCompatActivity {
    TextView item_name, item_price, item_quantity, total_amount;
    ImageView foodPreview;
    EditText locationET;
    String name, price, quantity, photo_name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation_);
        item_name = findViewById(R.id.itemNameTV);
        item_price = findViewById(R.id.priceTV);
        item_quantity = findViewById(R.id.quantityTV);
        total_amount = findViewById(R.id.totalPriceTV);
        foodPreview = findViewById(R.id.foodPreviewIV);


        Intent intent = getIntent();
        name = intent.getStringExtra("item_name");
        price = intent.getStringExtra("item_price");
        quantity = intent.getStringExtra("item_count");
        photo_name = intent.getStringExtra("item_photo");

        String url = "http://projecttech.xyz/Find_Food/upload/";
        Glide.with(this).load(url + photo_name).into(foodPreview);
        item_name.setText(name);
        item_price.setText(price);
        item_quantity.setText(quantity);

        total_amount.setText(String.valueOf(Integer.parseInt(quantity)*Integer.parseInt(price)));


    }

    public void OrderBTN(View view) {

      startActivity(new Intent(Confirmation_Activity.this, User_Details_Activity.class));
    }
}