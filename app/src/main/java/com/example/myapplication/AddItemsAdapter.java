package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AddItemsAdapter extends RecyclerView.Adapter<AddItemsAdapter.AddItemsViewHolder> {

    ArrayList<Item> list;
    public AddItemsAdapter(ArrayList<Item> list){
        this.list = list;
    }

    @NonNull
    @Override
    public AddItemsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.add_items,parent,false);
        return new AddItemsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AddItemsViewHolder holder, int position) {
        Item currentItem = list.get(position);
        holder.time.setText(currentItem.getTime());
        holder.title.setText(currentItem.getTitle());
        holder.desc.setText(currentItem.getDesc());
        holder.date.setText(currentItem.getDate());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class AddItemsViewHolder extends RecyclerView.ViewHolder{

        TextView title,desc,date,time;
        public AddItemsViewHolder(@NonNull View itemView) {
            super(itemView);

            title=itemView.findViewById(R.id.tvTitle);
            desc=itemView.findViewById(R.id.tvDesc);
            time=itemView.findViewById(R.id.tvTime);
            date=itemView.findViewById(R.id.tvDate);
        }
    }
}
