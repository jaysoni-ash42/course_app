package com.example.navigationdrawer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.example.navigationdrawer.fragment.Course;
import com.example.navigationdrawer.fragment.Invitefriends;
import com.example.navigationdrawer.fragment.Contactus;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    List<String> Horzizontal_list = new ArrayList<String>();

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       init();
    }

    private void init() {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        navigationView = findViewById(R.id.navigationdrawer);
        drawerLayout = findViewById(R.id.drawertool);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                navigate(item);
                return true;
            }
        });

    }

    private void navigate(MenuItem item) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = manager.beginTransaction();

                switch (item.getItemId()) {
                    case R.id.nav_Course:
                            Course Course = new Course();
                            fragmentTransaction.replace(R.id.framelayout, Course);
                            fragmentTransaction.commitAllowingStateLoss();
                            toolbar.setTitle("Course");
                            drawerLayout.closeDrawer(GravityCompat.START);
                            break;
                    case R.id.nav_invite:
                        Invitefriends invite=new Invitefriends();
                        fragmentTransaction.replace(R.id.framelayout, invite);
                        fragmentTransaction.commitAllowingStateLoss();
                        toolbar.setTitle("Invite Friends");
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.nav_contact:
                        Contactus contact = new Contactus();
                        fragmentTransaction.replace(R.id.framelayout, contact);
                        fragmentTransaction.commitAllowingStateLoss();
                        toolbar.setTitle("Contact Us");
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                }
    }



}