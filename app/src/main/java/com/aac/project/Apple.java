package com.aac.project;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Apple extends Fruits {

    CartDataBase dbhelper;
    Button buy;
    String apple;
    Integer price;
    Integer calculatedprice;
    int quantity;
    String quan;
    EditText txt;
    TextView txte;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.apple);
        txt=(EditText) findViewById(R.id.editText3);
        quan=txt.getText().toString();
        txte= findViewById(R.id.textView4);
        txte.setText(quan);
        //String q=txt.getText().toString();
        //quantity=Integer.parseInt(quan);
        //int quantity=Integer.parseInt(quan);

        apple="Apple";
        price=80;
        calculatedprice =price * 3;

        dbhelper=new CartDataBase(this);
        buy=findViewById(R.id.buyapple);
        buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbhelper.insertitem(apple,price,calculatedprice);
            }
        });
    }

}