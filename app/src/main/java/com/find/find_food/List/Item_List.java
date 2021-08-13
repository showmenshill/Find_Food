package com.find.find_food.List;

public class Item_List {
    int id;
    String item_name, item_price, item_photoname;

    public Item_List(int id, String item_name, String item_price, String item_photoname) {
        this.id = id;
        this.item_name = item_name;
        this.item_price = item_price;
        this.item_photoname = item_photoname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public String getItem_price() {
        return item_price;
    }

    public void setItem_price(String item_price) {
        this.item_price = item_price;
    }

    public String getItem_photoname() {
        return item_photoname;
    }

    public void setItem_photoname(String item_photoname) {
        this.item_photoname = item_photoname;
    }
}
