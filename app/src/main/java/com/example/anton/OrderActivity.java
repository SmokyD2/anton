package com.example.anton;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class OrderActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_order);

        setTitle ("Your Order");


        Intent orderIntent = getIntent ();
        String userName = orderIntent.getStringExtra("userNameForIntent");
        String goodsName =  orderIntent.getStringExtra("goodsName");
        int quantity = orderIntent.getIntExtra ("quantity",0);
        double price = orderIntent.getDoubleExtra ("price",0);
        double orderPrice = orderIntent.getIntExtra ("orderPrice",0);


        TextView orderTextView = findViewById (R.id.orderTextView);
        orderTextView.setText("Customer Name: " + userName  + "\n" + "Goods Name:"+  goodsName + "\n" + "Quantity:"+ quantity +"\n" + "Price:"+ price  + "\n" + "Order Price:" + orderPrice);
    }
}