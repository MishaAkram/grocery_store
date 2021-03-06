package com.aac.project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class BakeryItems extends Items {
    ListView list;
    String[] BakeryItems = {
            "Rusk","Bread", "Egg", "Biscuits", "Cupcakes","Butter"
    };
    Integer[] imageId = {
            R.drawable.rusk,
            R.drawable.bread,
            R.drawable.egg,
            R.drawable.bicuits,
            R.drawable.cupcakes,
            R.drawable.butter

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bakery);
        ItemsList adapter = new
                ItemsList(BakeryItems.this, BakeryItems, imageId);
        list = (ListView) findViewById(R.id.list);
        list.setAdapter(adapter);
        final Intent rusk=new Intent(this,Rusk.class);
        final Intent bread=new Intent(this,Bread.class);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                if (BakeryItems[position].equals("Rusk")){
                    startActivity(rusk);}
                if (BakeryItems[position].equals("Bread")){
                    startActivity(bread);}

            }
        });
        }
}

