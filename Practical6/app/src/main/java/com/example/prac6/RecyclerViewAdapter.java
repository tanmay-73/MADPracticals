package com.example.prac6;

import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.recyclerview>
{
    private String[] data;
    private String[] data2;

    public RecyclerViewAdapter(String[] data,String[] data2){

        this.data=data;
        this.data2=data2;
    }
    @NonNull
    @Override
    public recyclerview onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.activity_design,parent,false);
        return new recyclerview(view);
    }

    @Override
    public void onBindViewHolder(@NonNull recyclerview holder, int position) {
        String name=data[position];
        String add=data2[position];
        holder.name1.setText(name);
        holder.add1.setText(add);
    }

    @Override
    public int getItemCount()
    {
        return data.length;
    }

    public class recyclerview extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView name1;
        TextView add1;
        public recyclerview(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.imageView);
            name1=itemView.findViewById(R.id.name1);
            add1=itemView.findViewById(R.id.add1);
        }
    }
}
