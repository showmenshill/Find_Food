package com.find.find_food.Add_Item;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.find.find_food.R;
import com.google.android.material.textfield.TextInputEditText;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Item_Add_Activity extends AppCompatActivity {
    Bitmap bitmap;
    ImageView bannerView;
    TextInputEditText item_name, item_price;
    String name, price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item__add_);
        bannerView = findViewById(R.id.banner);
        item_name = findViewById(R.id.emailIT);
        item_price = findViewById(R.id.itemPasswordIT);
    }

    public void SubmitItem(View view) {
         name = item_name.getText().toString();
         price = item_price.getText().toString();

        if (name.isEmpty()||price.isEmpty()){
            Toast.makeText(this, "Please fill up the fields first", Toast.LENGTH_SHORT).show();
        }
        else{
            insertData();
        }


    }

    private void insertData() {
        Random random = new Random();
        int image_name = random.nextInt(1000);

        String url = "http://projecttech.xyz/Find_Food/insert_info.php";
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Toast.makeText(Item_Add_Activity.this, "Upload Successfully", Toast.LENGTH_SHORT).show();
                item_name.getText().clear();
                item_price.getText().clear();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Item_Add_Activity.this, "Failed to upload ", Toast.LENGTH_SHORT).show();

            }
        }){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> stringStringMap = new HashMap<>();

                stringStringMap.put("item_name",name);
                stringStringMap.put("item_price",price);
                stringStringMap.put("item_photo_name",name+image_name+".jpg");
                stringStringMap.put("dp", ImageToString(bitmap));


                return stringStringMap;
            }

        };

        requestQueue.add(stringRequest);



    }

    public void ChooseImage(View view) {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent,"Choose Image File"),1);
    }

    //overriding the image view to set selected picture on it

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode ==1 && resultCode == RESULT_OK && data!= null && data.getData() != null){
            Uri path = data.getData();

            try {
                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(),path);
                bannerView.setImageBitmap(bitmap);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    protected String ImageToString(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 90, byteArrayOutputStream);
        byte[] imageToByte = byteArrayOutputStream.toByteArray();
        return Base64.encodeToString(imageToByte, Base64.DEFAULT);
    }
}