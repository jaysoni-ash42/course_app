package com.example.navigationdrawer;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.navigationdrawer.adapter.Vertical_adapter;
import com.example.navigationdrawer.model.Course;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Details_course extends YouTubeBaseActivity {
    YouTubePlayerView youTubePlayerView;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef;
    List<Course> courseList = new ArrayList<>();
    List<String> list = new ArrayList<>();
    RecyclerView recyclerView;
    Vertical_adapter vertical_adapter;
    ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_course);
        String course = getIntent().getStringExtra("course");
        youTubePlayerView = findViewById(R.id.youtubeplayer);
        progressBar=findViewById(R.id.progress_circular);
        myRef = database.getReference().child(course);
        recyclerView = findViewById(R.id.listrecyclerview);
        if(list.size()<=0)
        {
            progressBar.setVisibility(View.VISIBLE);
        }
        getData();
    }

    public void setAdapter() {
        vertical_adapter = new Vertical_adapter(courseList);
        recyclerView.setAdapter(vertical_adapter);
        YouTubePlayer.OnInitializedListener onInitializedListener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.loadVideos(list);
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
                Toast.makeText(Details_course.this, "Something went wrong", Toast.LENGTH_SHORT).show();
            }
        };
        youTubePlayerView.initialize(getString(R.string.youtube_api_key), onInitializedListener);

    }

    private void getData() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                myRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        for (DataSnapshot shot : snapshot.getChildren()) {
                            Course course1 = shot.getValue(Course.class);
                            courseList.add(course1);
                            list.add(course1.getLink());
                        }
                        if(list.size() > 0) {
                            setAdapter();
                            progressBar.setVisibility(View.GONE);
                        }
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Toast.makeText(getBaseContext(), "Something went wrong", Toast.LENGTH_SHORT).show();
                        progressBar.setVisibility(View.GONE);
                    }
                });
            }
        }).start();
    }


}