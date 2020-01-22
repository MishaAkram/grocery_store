package com.aac.project;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Banana extends Fruits {
    CartDataBase dbhelper;
    Button buy;
    String name;
    Integer price;
    Integer calculatedprice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.banana);


        name="Banana";
        price=30;
        calculatedprice =price * 5;

        dbhelper=new CartDataBase(this);

        buy=findViewById(R.id.buybanana);
        buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbhelper.insertitem(name,price,calculatedprice);
            }
        });
    }
}
