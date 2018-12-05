package com.example.naim.tourguide;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.squareup.picasso.Picasso;

public class Details extends AppCompatActivity {
    private android.support.v7.widget.Toolbar maint;
    TextView desc,loc;
    public String Name,Detail_Desc,image,location;
    public ImageView Image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        maint =  findViewById(R.id.maintoolbar);
        setSupportActionBar(maint);

        desc = findViewById(R.id.desc);
        Image = findViewById(R.id.loadimage);
        loc = findViewById(R.id.location);

        if (getIntent() != null) {

            Name = getIntent().getStringExtra("name");
            Detail_Desc = getIntent().getStringExtra("details_desc");
            image = getIntent().getStringExtra("image");
            location =getIntent().getStringExtra("location");

            setTitle(Name);
            desc.setText(Detail_Desc);
            loc.setText(location);
            Picasso.get().load(image).into(Image);
        }
    }

}
