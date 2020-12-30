package com.example.navigationdrawer.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.navigationdrawer.Horizontal_recyclerview;
import com.example.navigationdrawer.R;
import com.example.navigationdrawer.model.Course;

import java.util.ArrayList;
import java.util.List;

public class Vertical_adapter extends RecyclerView.Adapter<Vertical_adapter.Vertical_viewholder> {
    View view;
    List<Course> course;


    public Vertical_adapter(List<Course> course) {
        this.course = course;

    }

    @NonNull
    @Override
    public Vertical_viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        view = inflater.inflate(R.layout.layout_list, parent, false);
        return (new Vertical_viewholder(view));
    }

    @Override
    public void onBindViewHolder(@NonNull Vertical_viewholder holder, int position) {
        holder.textView.setText(course.get(position).getName());
    }

    @Override
    public int getItemCount() {
        if (course.size() <= 0) {
            return 0;
        }
        return course.size();
    }



    public class Vertical_viewholder extends RecyclerView.ViewHolder {
        TextView textView;
        View view;

        public Vertical_viewholder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.list_text);
            view = itemView.findViewById(R.id.verticaldivider);
        }
    }
}
