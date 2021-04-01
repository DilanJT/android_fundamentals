package com.example.tutorial_08;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class CustomListView2 extends AppCompatActivity {

    ListView listView;
    Button saveButton;

    public static final String SHARED_PREFS = "sharedPrefs";
    ArrayList<String> savedList = new ArrayList<>();
    ArrayList<Course> arrayOfCourses = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_list_view2);

        listView = findViewById(R.id.listview);
        saveButton = findViewById(R.id.save_button);

        String[] modules = {"Mobile Application Development", "Machine Learning",
                "Client Server", "iOS Programming", "Java Programming",
                "Python Programming"};

        for(int i = 0; i < modules.length; i++) {
            arrayOfCourses.add(new Course(modules[i], false));
        }

        generateStringArrayList();

        loadData();

        // create the adapter to convert the array to views
        CourseAdapter adapter = new CourseAdapter(this, arrayOfCourses);

        // Attach the adapter to a listview
        listView.setAdapter(adapter);



    }

    public void generateStringArrayList() {
        for(int i = 0; i < arrayOfCourses.size(); i++) {
            String save = arrayOfCourses.get(i).name + i;
            savedList.add(save);
        }
    }

    public void savedata(View view) {

        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        for(int m = 0; m < arrayOfCourses.size(); m++) {
            editor.putBoolean(savedList.get(m), arrayOfCourses.get(m).isSaved);
        }

        editor.apply();
        Toast.makeText(this, "State saved", Toast.LENGTH_SHORT).show();
    }

    public void loadData() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);

        for(int m = 0; m < arrayOfCourses.size(); m++) {
            arrayOfCourses.get(m).isSaved = sharedPreferences.getBoolean(savedList.get(m), false);
        }
    }
}