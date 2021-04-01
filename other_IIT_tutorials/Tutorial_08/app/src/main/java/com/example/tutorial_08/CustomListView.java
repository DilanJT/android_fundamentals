package com.example.tutorial_08;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CustomListView extends AppCompatActivity {

    ListView coursesList;
    SharedPreferences sp;
    SparseBooleanArray checked;
    ArrayAdapter adapter;
    private static final String PREF_KEY= "coursesList";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_list_view);

        coursesList = (ListView) findViewById(R.id.coursesList);

        String[] modules = {"Mobile Application Development", "Machine Learning",
                "Client Server", "iOS Programming", "Java Programming",
                "Python Programming"};

        //sp = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);

        final ArrayList<String> list = new ArrayList<>();
        for(int i = 0; i < modules.length; ++i){
            list.add(modules[i]);
        }



        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_multiple_choice, list);

        coursesList.setAdapter(adapter);

//        System.out.println("hello there");
//        SparseBooleanArray existingChecked = getArrayPref(getApplicationContext(), "courseList");
//
//        checked = coursesList.getCheckedItemPositions();
//
//        if( existingChecked != null) {
//            for (int i = 0; i < coursesList.getAdapter().getCount(); i++) {
//                if (existingChecked.keyAt(i) == i) {
//                    checked.setValueAt(i, true);
//                }
//            }
//        }

        loadData();
        checked = coursesList.getCheckedItemPositions();

        //saveArrayPref(getApplicationContext(), "courseList", checked);

        coursesList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                    if(coursesList.isItemChecked(position)){
//                        coursesList.setItemChecked(position, false);
//                    }else {
//                        coursesList.setItemChecked(position, true);
//                    }

            }
        });

    }

    public void saveArrayPref(Context context, String prefKey, SparseBooleanArray intDict) {
        SharedPreferences prefs = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
//        JSONArray json = new JSONArray();
//        StringBuffer data = new StringBuffer().append("[");
        for(int i = 0; i < intDict.size(); i++) {
//            data.append("{")
//                    .append("\"key\": ")
//                    .append(intDict.keyAt(i)).append(",")
//                    .append("\"value\": ")
//                    .append(intDict.valueAt(i))
//                    .append("},");

            editor.putBoolean(String.valueOf(intDict.keyAt(i)), intDict.valueAt(i));
        }
//        data.append("]");
//        editor.putString(prefKey, intDict.size() == 0 ? null : data.toString());
        editor.apply();
        editor.commit();
    }

    public SparseBooleanArray getArrayPref(Context context, String prefKey) {
        SharedPreferences prefs = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        SparseBooleanArray intDict = new SparseBooleanArray();
        if(prefs != null) {
//            String json = prefs.getString(prefKey, null);
//
//            if (json != null) {
//                try {
//                    JSONArray jsonArray = new JSONArray(json);
//                    for (int i = 0; i < jsonArray.length(); i++) {
//                        JSONObject item = jsonArray.getJSONObject(i);
//                        intDict.put(item.getInt("key"), item.getBoolean("value"));
//                    }
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//            }
            Map<String, ?> keys = prefs.getAll();
            for(Map.Entry<String, ?> entry : keys.entrySet()) {
                intDict.put(Integer.parseInt(entry.getKey()), Boolean.parseBoolean(entry.getValue().toString()));
            }
        }
        return intDict;
    }

    @Override
    public void finish() {
        Log.d(PREF_KEY, "onPause");
        //saveArrayPref(getApplicationContext(), "courseList", checked);
        super.finish();
    }

    public void savedata(View view) {

        SharedPreferences prefs = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.clear();
        editor.apply();
        editor.commit();
//        SparseBooleanArray savedArray = getArrayPref(getApplicationContext(), PREF_KEY);
//        System.out.println(savedArray.size());
//        if(savedArray != null) {
//            for (int i = 0; i < coursesList.getCount(); i++) {
//                for(int j = 0; j < savedArray.size(); j++) {
//                    if (savedArray.keyAt(j) == i) {
//                        editor.remove(Integer.toString(i));
//                        editor.apply();
//                    }
//                }
//            }
//        }
//        editor.commit();

        checked = coursesList.getCheckedItemPositions();
        saveArrayPref(getApplicationContext(), PREF_KEY, checked);
    }

    public void loadData() {
        //SharedPreferences prefs = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);

        SparseBooleanArray savedArray = getArrayPref(getApplicationContext(), PREF_KEY);
        for (int i = 0; i < savedArray.size(); i++) {
            System.out.println("key: " + savedArray.keyAt(i)+ "value : " + savedArray.valueAt(i));
        }
        System.out.println(savedArray.size());
        if(savedArray != null) {
            for (int i = 0; i < coursesList.getCount(); i++) {
                for(int j = 0; j < savedArray.size(); j++) {
                    if (savedArray.keyAt(j) == i) {
                        coursesList.setItemChecked(i, savedArray.valueAt(j));
                    }
                }
            }
        }
    }

    @Override
    protected void onPause() {
        Log.d(PREF_KEY, "onPause");
        super.onPause();
        checked = coursesList.getCheckedItemPositions();
        for (int i = 0; i < checked.size(); i++) {
            System.out.println("key: " + checked.keyAt(i)+ "value : " + checked.valueAt(i));
        }
        System.out.println(coursesList.getCount());
        saveArrayPref(getApplicationContext(), PREF_KEY, checked);
    }

    @Override
    protected void onResume() {
        Log.d(PREF_KEY, "onResume");
        super.onResume();
        loadData();
    }
}