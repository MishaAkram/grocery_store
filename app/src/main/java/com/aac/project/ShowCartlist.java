package com.aac.project;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.aac.project.R;

import java.util.ArrayList;

public class ShowCartlist extends ArrayAdapter<String>{

    private final Activity context;
    private ArrayList web ;
    public ShowCartlist(Activity context,
                        ArrayList web) {
        super(context, R.layout.cart_list, web);
        this.context = context;
        this.web = web;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView= inflater.inflate(R.layout.cart_list, null, true);
        TextView txtTitle = (TextView) rowView.findViewById(R.id.txt);


        txtTitle.setText( web.get(position).toString());

        return rowView;
    }}

