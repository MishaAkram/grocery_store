package com.aac.project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class Meats extends Items {
    ListView list;
    String[] MeatItems = {
            "Chicken","Mutton", "Beaf", "Fish", "Prawns"
    };
    Integer[] imageId = {
            R.drawable.chicken,
            R.drawable.mutton,
            R.drawable.beef,
            R.drawable.fish,
            R.drawable.prawns,

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.meat);
        ItemsList adapter = new
                ItemsList(Meats.this, MeatItems, imageId);
        list = (ListView) findViewById(R.id.list);
        list.setAdapter(adapter);

        final Intent mutton=new Intent(this,Mutton.class);
        final Intent chicken=new Intent(this,Chicken.class);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                if (MeatItems[position].equals("Chicken")){
                    startActivity(chicken);}
                if (MeatItems[position].equals("Mutton")){
                    startActivity(mutton);
                }


            }
        });

    }
}
