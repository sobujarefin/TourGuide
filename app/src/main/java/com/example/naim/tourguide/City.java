package com.example.naim.tourguide;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class City extends AppCompatActivity {
    private android.support.v7.widget.Toolbar maint;
    Button restur,hotel,place,hospital,emergency;
    String city;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city);
        maint=findViewById(R.id.maintoolbar);
        setSupportActionBar(maint);

        if(getIntent() !=null)
        {
            city = getIntent().getStringExtra("city");
            setTitle(city);
        }
        restur=findViewById(R.id.btn_res);
        restur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent resintent = new Intent(City.this,Resturent.class);
                resintent.putExtra("rest",city+" - Restaurant");
                startActivity(resintent);

            }
        });

        hotel = findViewById(R.id.btn_hot);
        hotel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent hotintent = new Intent(City.this,Hotel.class);
                hotintent.putExtra("hotel",city+" - Hotel");
                startActivity(hotintent);
            }
        });


        place = findViewById(R.id.btn_place);
        place.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent placeintent = new Intent(City.this,Place.class);
                placeintent.putExtra("place",city+" - Visiting Place");
                startActivity(placeintent);
            }
        });

        hospital = findViewById(R.id.btn_hos);
        hospital.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent hospitalintent = new Intent(City.this,Hospital.class);
                hospitalintent.putExtra("hospital",city+" - Hospital");
                startActivity(hospitalintent);
            }
        });

        emergency = findViewById(R.id.btn_seq);
        emergency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent emergencyintent = new Intent(City.this,Emergency.class);
                emergencyintent.putExtra("emergency",city+" - Emergency");
                startActivity(emergencyintent);
            }
        });
    }
}
