package com.example.hackathon.CompletedQuestion;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.hackathon.AnsActivity;
import com.example.hackathon.AskActivity;
import com.example.hackathon.R;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class CompletedQuestionView extends AppCompatActivity {
    Toolbar toolbar;
    DrawerLayout drawerLayout;

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    CompletedQuestionAdapter adapter;
    List<CompletedQuestion> questionList = new ArrayList<CompletedQuestion>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.drawer_layout);

        CompletedQuestion Q1 = new CompletedQuestion("yjsb", "yes");
        questionList.add(Q1);

        recyclerView = findViewById(R.id.completed_ques_view);

        layoutManager = new LinearLayoutManager(this);  //A RecyclerView.LayoutManager implementation which provides similar functionality to ListView.
        recyclerView.setLayoutManager(layoutManager);   // Also StaggeredGridLayoutManager and GridLayoutManager or a custom Layout manager

        adapter = new CompletedQuestionAdapter(this);
        recyclerView.setAdapter(adapter);

        adapter.setData(questionList);

        // toolbar
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        // navigation menu
        drawerLayout = findViewById(R.id.drawerLayout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.nav_open, R.string.nav_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.navigationView);
        navigationView.setNavigationItemSelectedListener(new myNavListener());
    }

    class myNavListener implements NavigationView.OnNavigationItemSelectedListener {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            int id = item.getItemId();

            if(id == R.id.AQ){
                Intent intent = new Intent(CompletedQuestionView.this, AskActivity.class);
                startActivity(intent);
            }
            else if(id == R.id.VQ){
                Intent intent = new Intent(CompletedQuestionView.this, AnsActivity.class);
                startActivity(intent);
            }

            return true;
        }
    }
}