package com.find.find_food.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.find.find_food.Confirmation.Confirmation_Activity;
import com.find.find_food.List.Item_List;
import com.find.find_food.R;

import java.util.List;

public class Item_Adaper extends RecyclerView.Adapter<Item_Adaper.Item_Custom_ViewHolder> {
    Context context;
    List<Item_List> item_list;

    public Item_Adaper(Context context, List<Item_List> item_list) {
        this.context = context;
        this.item_list = item_list;
    }

    @NonNull
    @Override
    public Item_Custom_ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.row_info_layout, parent, false);
        return new Item_Custom_ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Item_Custom_ViewHolder holder, int position) {
        String url = "http://projecttech.xyz/Find_Food/upload/";
        Item_List itemList = item_list.get(position);

        holder.item_name.setText(itemList.getItem_name());
        holder.item_price.setText(itemList.getItem_price());
        Glide.with(context).load(url + itemList.getItem_photoname()).into(holder.item_image);

        holder.increaseBTN.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {

                int count = 0;
                try {

                    count = Integer.parseInt(holder.itemCountTV.getText().toString());
                    count++;

                } catch (Exception e) {
                    count = 0;
                }
                holder.itemCountTV.setText(String.valueOf(count));

            }
        });
        holder.decreaseBTN.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {


                int count = 0;
                try {

                    count = Integer.parseInt(holder.itemCountTV.getText().toString());
                    count--;
                } catch (Exception e) {
                    count = 0;
                }
                if (count > 0)

                    holder.itemCountTV.setText(String.valueOf(count));


            }
        });

        holder.addCartBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, Confirmation_Activity.class);
                intent.putExtra("item_name", itemList.getItem_name());
                intent.putExtra("item_price", itemList.getItem_price());
                intent.putExtra("item_photo", itemList.getItem_photoname());
                intent.putExtra("item_count",holder.itemCountTV.getText().toString());
                context.startActivity(intent);


            }
        });


    }

    @Override
    public int getItemCount() {
        return item_list.size();
    }

    class Item_Custom_ViewHolder extends RecyclerView.ViewHolder {
        ImageView item_image;
        TextView item_name, item_price, itemCountTV;
        Button addCartBTN;
        ImageButton increaseBTN, decreaseBTN;

        public Item_Custom_ViewHolder(@NonNull View itemView) {
            super(itemView);

            item_image = itemView.findViewById(R.id.imageBanner);
            item_name = itemView.findViewById(R.id.itemName);
            item_price = itemView.findViewById(R.id.itemPrice);
            addCartBTN = itemView.findViewById(R.id.addCartBTN);
            increaseBTN = itemView.findViewById(R.id.increaseBTN);
            decreaseBTN = itemView.findViewById(R.id.decreaseBTN);
            itemCountTV = itemView.findViewById(R.id.itemCountTV);


        }
    }


}
