package com.example.naim.tourguide;

import android.app.LauncherActivity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.telecom.Call;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.DocumentSnapshot;
import com.squareup.picasso.Picasso;

public class MyAdapter extends FirestoreRecyclerAdapter<Res,MyAdapter.MyHolder> {

    private OnItemClickListener listener;

    public MyAdapter(@NonNull FirestoreRecyclerOptions<Res> options) {
        super(options);

    }

    @Override
    protected void onBindViewHolder(@NonNull final MyHolder holder, final int position, @NonNull Res model) {

        holder.name.setText(model.getName());
        holder.desc.setText(model.getDesc());
        Picasso.get().load(model.getImage()).into(holder.img);

    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_list,
                viewGroup,false);
        return new MyHolder(v);
    }

    class MyHolder extends RecyclerView.ViewHolder{

        public TextView name;
        public TextView details_desc,location;
        public TextView desc;
        public ImageView img;
        public RelativeLayout relativeLayout;


        public MyHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.res_name);
            desc=itemView.findViewById(R.id.res_des);
            img=itemView.findViewById(R.id.imageView);
            details_desc = itemView.findViewById(R.id.detail_desc);
            location = itemView.findViewById(R.id.detail_desc);


            relativeLayout = itemView.findViewById(R.id.itemlayout);

            relativeLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();

                    if(position != RecyclerView.NO_POSITION && listener !=null)
                    {
                        listener.OnItemClick(getSnapshots().getSnapshot(position),position);
                    }
                }
            });
        }
    }

    public interface OnItemClickListener{
        void OnItemClick(DocumentSnapshot documentSnapshot,int position);
    }
    public void setOnItemClickListener(OnItemClickListener listener){
        this.listener=listener;
    }
}
