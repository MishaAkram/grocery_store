package com.aac.project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class Items extends MainActivity {
    //ItemDataBase dbhelper;

    ListView list;
    String[] GroceryItems = {
            "Fruits","Vegetables","Meat","Bakery Items"
    } ;
    Integer[] imageId = {R.drawable.fruits, R.drawable.vegetables, R.drawable.meat, R.drawable.bakery };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.items);
      //  dbhelper=new ItemDataBase(this);
        ItemsList adapter = new ItemsList(Items.this,GroceryItems, imageId);
        list=(ListView)findViewById(R.id.list);
        list.setAdapter(adapter);
        final Intent fruit=new Intent(this,Fruits.class);
        final Intent vege=new Intent(this,Vegetable.class);
        final Intent meat=new Intent(this,Meats.class);
        final Intent bakery=new Intent(this,BakeryItems.class);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                if (GroceryItems[position].equals("Fruits"))
                    startActivity(fruit);
                if (GroceryItems[position].equals("Vegetables"))
                    startActivity(vege);
                if (GroceryItems[position].equals("Meat"))
                    startActivity(meat);
                if (GroceryItems[position].equals("Bakery Items"))
                    startActivity(bakery);
            }
        });

    }
}
