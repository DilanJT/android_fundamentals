package com.example.tutorial_08;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class DisplayFriends extends AppCompatActivity {

    String[] values;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_friends);

        final ListView listView = (ListView) findViewById(R.id.friendsList);
        values = new String[] { "Pahan", "Steve", "Sai", "Sheruni", "Sandunika", "Pamudu", "Manoj"};

        final ArrayList<String> list = new ArrayList<>();
        for(int i = 0; i < values.length; ++i){
            list.add(values[i]);
        }

        final ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(DisplayFriends.this, values[position], Toast.LENGTH_SHORT).show();
            }
        });
    }
}