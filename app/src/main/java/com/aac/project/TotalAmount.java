package com.aac.project;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;



public class TotalAmount extends AppCompatActivity {
    CartDataBase MyDBHelper;
    TextView txt;
    Button btn;

     int total;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.total_amount);
    txt= findViewById(R.id.textView3);

    btn=findViewById(R.id.button);

        MyDBHelper = new CartDataBase(this);
        Cursor res = MyDBHelper.getAllData();
        if (res.getCount() == 0) {
            return;
        }
          total = 0;
        while (res.moveToNext()) {
            total+=res.getInt(3);
            }
        String s=String.valueOf(total);
        txt.setText(s);
        final Intent totali=new Intent(this,CurrentLocation.class);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            startActivity(totali);
            }
        });

    }








    }

