package com.example.naim.tourguide;


import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;

public class Resturent extends AppCompatActivity {
    private android.support.v7.widget.Toolbar maint;

    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CollectionReference resRef;
    String rest;

    private MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resturent);

        maint =  findViewById(R.id.maintoolbar);
        setSupportActionBar(maint);
        if (getIntent() != null) {
            rest = getIntent().getStringExtra("rest");
            setTitle(rest);
        }
        resRef=db.collection(rest);
        setUpRecyclerView();

    }

    private void setUpRecyclerView() {
        com.google.firebase.firestore.Query query = resRef.orderBy("id", com.google.firebase.firestore.Query.Direction.ASCENDING);
        FirestoreRecyclerOptions<Res> options = new FirestoreRecyclerOptions.Builder<Res>()
                .setQuery(query,Res.class)
                .build();

        adapter = new MyAdapter(options);

        RecyclerView recyclerView = findViewById(R.id.myrecycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new MyAdapter.OnItemClickListener() {
            @Override
            public void OnItemClick(DocumentSnapshot documentSnapshot, int position) {
                Res res = documentSnapshot.toObject(Res.class);
                String Name = res.getName();
                String Image = res.getImage();

                String details_desc = res.getDetails_desc();
                String location = res.getLocation();

                Intent detailintent = new Intent(Resturent.this,Details.class);

                detailintent.putExtra("name",Name);
                detailintent.putExtra("image",Image);
                detailintent.putExtra("details_desc",details_desc);
                detailintent.putExtra("location",location);
                startActivity(detailintent);
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }
}