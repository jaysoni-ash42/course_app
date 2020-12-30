package com.example.navigationdrawer.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.navigationdrawer.Horizontal_recyclerview;
import com.example.navigationdrawer.R;

import java.util.ArrayList;
import java.util.List;

public class Horizontal_adapter extends RecyclerView.Adapter<Horizontal_adapter.Horizontal_viewholder> {
    View view;
    List<String> horizontallist ;
    Horizontal_recyclerview horizontal_recyclerview;

    public Horizontal_adapter(List<String> horizontallist, Horizontal_recyclerview value) {
        this.horizontallist = horizontallist;
        this.horizontal_recyclerview = value;
    }

    @NonNull
    @Override
    public Horizontal_viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        view = inflater.inflate(R.layout.layout_horizontal_recycler_view, parent, false);
        return (new Horizontal_viewholder(view));
    }

    @Override
    public void onBindViewHolder(@NonNull Horizontal_viewholder holder, int position) {
        holder.textView.setText(horizontallist.get(position));

    }

    @Override
    public int getItemCount() {
        return horizontallist.size();
    }


    public class Horizontal_viewholder extends RecyclerView.ViewHolder {
        TextView textView;

        public Horizontal_viewholder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textview);
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    horizontal_recyclerview.onclick(getAdapterPosition());
                }
            });
        }
    }
}
