package com.aac.project;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;
public class Capsicum extends Vegetable{


        CartDataBase dbhelper;
        Button buy;
        String capsicum;
        Integer price;
        Integer calculatedprice;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.capsicum);

            capsicum="Capsicum";
            price=60;
           // calculatedprice =price * 5;
            dbhelper=new CartDataBase(this);
            buy=findViewById(R.id.buyapple);
            buy.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dbhelper.insertitem(capsicum,price,price);
                }
            });
        }
    }

