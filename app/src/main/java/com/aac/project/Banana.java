package com.aac.project;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class Banana extends Fruits {
    CartDataBase dbhelper;
    Button buy;
    String name;
    Integer price;
    Integer calculatedprice;

    int checkprice;
    EditText txt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.banana);


        int n = Integer.valueOf(txt.getText().toString());



        name = "Banana";
        price = 30;

//calculatedprice=price*n;

        dbhelper = new CartDataBase(this);


        buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbhelper.insertitem(name, price, price);
            }
        });
    }

}
