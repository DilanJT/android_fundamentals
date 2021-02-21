package com.example.listviewdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        ListView myListView = (ListView) findViewById(R.id.myListView);
//
//        //the best way to add values to a list is from using an array list
//
//        ArrayList<String> myFamily = new ArrayList<>();
//        myFamily.add("Nick");
//        myFamily.add("Sarah");
//        myFamily.add("John");
//        myFamily.add("Fido");
//
//        //here we a telling to the array adapter to take the myfamily array to make a simple list type of view
//        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, myFamily);
//
//        myListView.setAdapter(arrayAdapter);
//
//        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
//
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Log.i("Person selected: ", myFamily.get(position));
//            }
//        });

        ListView myListView = (ListView) findViewById(R.id.myListView);

        ArrayList<String> myFriends = new ArrayList<>();
        myFriends.add("Pahan");
        myFriends.add("Chryshel");
        myFriends.add("Nazhim");
        myFriends.add("Piyo");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, myFriends);
        myListView.setAdapter(arrayAdapter);

        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "Person: " + myFriends.get(position), Toast.LENGTH_SHORT).show();
            }
        });

    }
}