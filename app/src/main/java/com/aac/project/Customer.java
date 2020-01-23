package com.aac.project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Customer extends AppCompatActivity {

    EditText e1,e2,e3;
    Button btn;
    CartDataBase MyDBHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customer);
        MyDBHelper = new CartDataBase(this);

        e1=findViewById(R.id.editText4);
        e2=findViewById(R.id.editText5);
        e3=findViewById(R.id.editText6);



        btn=findViewById(R.id.button2);
        final Intent intent=new Intent(this,Items.class);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name =e1.getText().toString();
                String phone =e2.getText().toString();
                String address =e3.getText().toString();
                MyDBHelper.insertdata(name,phone,address);

                startActivity(intent);
            }
        });


    }
}
