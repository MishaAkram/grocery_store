package com.aac.project;

import android.content.Intent;
import android.content.SearchRecentSuggestionsProvider;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Fruits extends Items {
    ListView list;
    String[] FruitsItems = {"Apple","Banana", "Mango", "Grapes", "Orange","Strawberry","Watermelon"};
    Integer[] imageId = {R.drawable.apple,R.drawable.banana,R.drawable.mango,R.drawable.grapes,R.drawable.orange,R.drawable.strawberry,R.drawable.watermelon};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fruits);

        ItemsList adapter = new ItemsList(Fruits.this, FruitsItems, imageId);
        list = (ListView) findViewById(R.id.list);
        list.setAdapter(adapter);

        final Intent apple=new Intent(this,Apple.class);
        final Intent banana=new Intent(this,Banana.class);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                if (FruitsItems[position].equals("Apple")){
                    startActivity(apple);}
                if (FruitsItems[position].equals("Banana")){
                    startActivity(banana);}
            }
        });

    }
}

