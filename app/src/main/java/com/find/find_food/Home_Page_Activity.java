package com.find.find_food;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.find.find_food.Adapter.Item_Adaper;
import com.find.find_food.List.Item_List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Home_Page_Activity extends AppCompatActivity {
    RecyclerView recyclerView;
    List<Item_List> item_list;
    Item_Adaper item_adaper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home__page_);
        recyclerView = findViewById(R.id.recyclerView);
        item_list = new ArrayList<>();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        loadData();


    }

    private void loadData() {

        String url = "http://projecttech.xyz/Find_Food/get_all_data.php";
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray jsonArray = jsonObject.getJSONArray("result");
                    for (int i = 0 ; i<jsonArray.length(); i++){
                        JSONObject data = jsonArray.getJSONObject(i);
                        item_list.add(new Item_List(data.getInt("id"),
                                data.getString("item_name"),
                                data.getString("item_price"),
                                data.getString("item_photo_name")));
                        item_adaper = new Item_Adaper(Home_Page_Activity.this, item_list);
                        recyclerView.setAdapter(item_adaper);

                    }



                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(stringRequest);
    }
}