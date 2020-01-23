package com.aac.project;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ShowCart extends MainActivity {
    CartDataBase MyDBHelper;
    ListView list;
    ArrayList Cartitem =new ArrayList();



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.items);
        ShowCartlist adapter = new ShowCartlist(ShowCart.this,Cartitem);
        list=(ListView)findViewById(R.id.list);
        list.setAdapter(adapter);

        list=findViewById(R.id.list);
        list.setAdapter(adapter);
        MyDBHelper = new CartDataBase(this); // instance of databasehelper function/constructor
        //public void viewall();
            Cursor res = MyDBHelper.getAllData();
            if (res.getCount() == 0) {
                showMessage("Error", "No Data");
                return;
            }
        while (res.moveToNext()) {
            StringBuilder builder=new StringBuilder();
              //  buffer1.append(" Id:").append(res.getString(0)).append("\n");
              //buffer1.append("Name :").append(res.getString(1));
               // buffer.append("Price:").append(res.getString(2)).append("\n");
            builder.append(res.getString(1));
            builder.append("                      ");
            builder.append(res.getString(3));
              Cartitem.add(builder);
            }

        }
        public void showMessage(String title,String message){
            AlertDialog.Builder builder=new AlertDialog.Builder(this);
            builder.setCancelable(true);
            builder.setTitle(title);
            builder.setMessage(message);
            builder.show();


        }
}
