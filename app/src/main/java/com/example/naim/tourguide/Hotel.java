package com.example.naim.tourguide;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class Hotel extends AppCompatActivity {

    private android.support.v7.widget.Toolbar maint;

    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CollectionReference hotelRef;
    String hotel;

    private MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel);

        maint =  findViewById(R.id.maintoolbar);
        setSupportActionBar(maint);
        if (getIntent() != null) {
            hotel = getIntent().getStringExtra("hotel");
            setTitle(hotel);
        }
        hotelRef=db.collection(hotel);
        setUpRecyclerView();
    }

    private void setUpRecyclerView() {
        com.google.firebase.firestore.Query query = hotelRef.orderBy("id", com.google.firebase.firestore.Query.Direction.ASCENDING);
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

                Intent detailintent = new Intent(Hotel.this,Details.class);

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
