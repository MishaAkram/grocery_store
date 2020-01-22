package com.aac.project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class Vegetable extends Items {
    ListView list;
    String[] vegetableitems ={
            "capsicum",
            "cauliflower",
            "chillies",
            "garlic",
            "ginger",
            "lemon",
            "lettuce",
            "onion",
            "peas",
            "potato",
            "spinach",
            "tomato"

    };
    Integer[] imageId ={
            R.drawable.capsicum,
            R.drawable.cauliflower,
            R.drawable.chilies,
            R.drawable.garlic,
            R.drawable.ginger,
            R.drawable.lemon,
            R.drawable.lettuce,
            R.drawable.onion,
            R.drawable.peas,
            R.drawable.potato,
            R.drawable.spinach,
            R.drawable.tomato,
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vegetables);
        ItemsList adapter = new ItemsList(Vegetable.this, vegetableitems, imageId);
        list = (ListView) findViewById(R.id.list);
        list.setAdapter(adapter);

        final Intent potato=new Intent(this,Potato.class);
        final Intent capsicum=new Intent(this,Capsicum.class);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                if (vegetableitems[position].equals("potato")){
                    startActivity(potato);}
                if (vegetableitems[position].equals("capsicum")){
                    startActivity(capsicum);}


            }
        });




    }
}

