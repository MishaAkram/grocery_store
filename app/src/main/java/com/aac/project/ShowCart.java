package com.aac.project;

import android.database.Cursor;
import android.os.Bundle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class ShowCart extends AppCompatActivity {
    CartDataBase MyDBHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        //setContentView(R.layout.showcart);
        MyDBHelper = new CartDataBase(this); // instance of databasehelper function/constructor
        //public void viewall();
            Cursor res = MyDBHelper.getAllData();
            if (res.getCount() == 0) {
                showMessage("Error", "No Data");
                return;
            }

            StringBuffer buffer;
        buffer = new StringBuffer();
        while (res.moveToNext()) {
                buffer.append(" Id:").append(res.getString(0)).append("\n");
                buffer.append("Name :").append(res.getString(1)).append("\n");
                buffer.append("Price:").append(res.getString(2)).append("\n");

            }
           // showMessage("Data", buffer.toString());
        }




        public void showMessage(String title,String message){
            AlertDialog.Builder builder=new AlertDialog.Builder(this);
            builder.setCancelable(true);
            builder.setTitle(title);
            builder.setMessage(message);
            builder.show();


        }
}
