package com.example.andoroiddevportfolio;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.WindowCompat;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WindowCompat.setDecorFitsSystemWindows(getWindow(), true);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(R.string.app_name);
        }

        RecyclerView list = findViewById(R.id.recycler_view_projects);

        Project[] projects = {
                new Project("Getting started app", "My very first project 'Hello world app",R.drawable.getting_started),
                new Project("Vin Quote", "Making simple change to the layout",R.drawable.quote),
                new Project("BMI Calculator", "A real life working BMI calculator calculates BMI base on age and gender height and body weight",R.drawable.calculator),
                new Project("Inches Convertor", "Working app to convert inches to meters",R.drawable.tape),
                new Project("The hungry Dev", "A restaurant menu app, learning about Listview and Scrollview, activities and classes",R.drawable
                        .hungry_developer)
        };

        ProjectsAdapter adapter = new ProjectsAdapter(projects);

        list.setAdapter(adapter);

    }

}