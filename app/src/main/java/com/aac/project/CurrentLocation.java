package com.aac.project;


import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import static com.aac.project.R.layout.currentlocation;

public class CurrentLocation extends AppCompatActivity {
   TextView display;

    double latitude = 0;
    double longitude = 0;
    String a;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(currentlocation);
        a=getMyCityName();
        display=findViewById(R.id.textView5);

        display.setText(a);
    }


        public String getMyCityName(){

        String myCityName = "";
        Geocoder geocoder = new Geocoder(CurrentLocation.this, Locale.getDefault());

            try {
                List<Address> addresses;
                addresses = geocoder.getFromLocation(latitude, longitude, 1);
                //String adr = addresses.get(0).getAddressLine(0);
                myCityName = addresses.get(0).getPremises();
            } catch (IOException e) {
                e.printStackTrace();

            }
         return myCityName;}

}