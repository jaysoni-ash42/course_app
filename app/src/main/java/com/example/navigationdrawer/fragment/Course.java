package com.example.navigationdrawer.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.navigationdrawer.Details_course;
import com.example.navigationdrawer.Horizontal_recyclerview;
import com.example.navigationdrawer.R;
import com.example.navigationdrawer.adapter.Horizontal_adapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Course extends Fragment {
    List<String> courses = new ArrayList<>();
    RecyclerView recyclerView;
    Horizontal_adapter horizontalAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.layout_course, container, false);
        init(v);
        return (v);
    }

    private void init(View v) {
        recyclerView = v.findViewById(R.id.recycler_view);
        getData();
        horizontalAdapter = new Horizontal_adapter(courses, new Horizontal_recyclerview() {
            @Override
            public void onclick(int position) {
                Intent courseplay = new Intent(getActivity(), Details_course.class);
                String value = courses.get(position);
                if (value.equals("Java for beginner")) {
                    courseplay.putExtra("course", "Java for beginner");
                } else if (value.equals("Soft Skills")) {
                    courseplay.putExtra("course", "Soft Skill");
                } else if (value.equals("introduction to machine learning with python")) {
                    courseplay.putExtra("course", "introduction to machine learning with python");
                } else if (value.equals("Nodejs,mongodb and express backend scripting")) {
                    courseplay.putExtra("course", "Nodejs,mongodb and express backend scripting");
                }
                startActivity(courseplay);
            }
        });
        recyclerView.setAdapter(horizontalAdapter);
    }

    private void getData() {
        courses.add("Java for beginner");
        courses.add("Soft Skills");
        courses.add("introduction to machine learning with python");
        courses.add("Nodejs,mongodb and express backend scripting");
    }
}
