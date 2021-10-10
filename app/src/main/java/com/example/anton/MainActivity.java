package com.example.anton;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    int quantity=0;
    Spinner spinner;
    ArrayList spinnerArrayList;
    ArrayAdapter spinnerAdapter;

    HashMap goodsMap;
    String goodsName;
    double price;
    EditText userNameEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);

        userNameEditText = findViewById (R.id.mameEditText);


        spinner = findViewById (R.id.spinner);
        spinner.setOnItemSelectedListener (this);
        spinnerArrayList = new ArrayList();

        spinnerArrayList.add ("Guitar");
        spinnerArrayList.add ("Drums");
        spinnerArrayList.add ("KeyBoard");

        spinnerAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item,spinnerArrayList);
        spinnerAdapter.setDropDownViewResource (android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter (spinnerAdapter);

        goodsMap = new HashMap ();
        goodsMap.put ("Guitar",500.0);
        goodsMap.put ("Drums",1500.0);
        goodsMap.put ("KeyBoard",10500.0);

    }
    public  void  increaseQuantity(View View){
        quantity = quantity + 1;
        TextView quantityTextView = findViewById (R.id.quantityTextView);
        quantityTextView.setText ("" + quantity);
        TextView priceTextView = findViewById (R.id.priceTextView);
        priceTextView.setText("" + quantity * price);
    }

    public void decreaseQuantity(View view) {
        quantity = quantity - 1;
        if(quantity < 0){
         quantity =0;
        }
        TextView quantityTextView = findViewById (R.id.quantityTextView);
        quantityTextView.setText ("" + quantity);
        TextView priceTextView = findViewById (R.id.priceTextView);
        priceTextView.setText("" + quantity * price);
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        goodsName = spinner.getSelectedItem ().toString ();
        price = (double)goodsMap.get (goodsName);
        TextView priceTextView = findViewById (R.id.priceTextView);
        priceTextView.setText("" + quantity * price);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void AddToCart(View view) {

        Order order = new Order ();

        order.userName = userNameEditText.getText().toString ();


        order.goodsName = goodsName;


        order.quantity =  quantity;

        order.price = price;

        order.orderPrice = quantity * price;


        Intent orderIntent = new Intent (MainActivity.this, OrderActivity.class);
        orderIntent.putExtra("userNameForIntent",order.userName);
        orderIntent.putExtra("goodsName",order.goodsName);
        orderIntent.putExtra("quantity",order.quantity);
        orderIntent.putExtra("price",order.price);
        orderIntent.putExtra("orderPrice",order.orderPrice);



        startActivity (orderIntent);


    }
}