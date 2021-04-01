package com.example.tutorial_08;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class CustomListView extends AppCompatActivity {

    ListView coursesList;
    SharedPreferences sp;
    SparseBooleanArray checked;

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

        final ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_multiple_choice, list);
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




        //saveArrayPref(getApplicationContext(), "courseList", checked);
    }

    public void saveArrayPref(Context context, String prefKey, SparseBooleanArray intDict) {
        SharedPreferences prefs = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        JSONArray json = new JSONArray();
        StringBuffer data = new StringBuffer().append("[");
        for(int i = 0; i < intDict.size(); i++) {
            data.append("{")
                    .append("\"key\": ")
                    .append(intDict.keyAt(i)).append(",")
                    .append("\"value\": ")
                    .append(intDict.valueAt(i))
                    .append("},");
        }
        data.append("]");
        editor.putString(prefKey, intDict.size() == 0 ? null : data.toString());
        editor.commit();
    }

    public SparseBooleanArray getArrayPref(Context context, String prefKey) {
        SharedPreferences prefs = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        String json = prefs.getString(prefKey, null);
        SparseBooleanArray intDict = new SparseBooleanArray();
        if (json != null) {
            try {
                JSONArray jsonArray = new JSONArray(json);
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject item = jsonArray.getJSONObject(i);
                    intDict.put(item.getInt("key"), item.getBoolean("value"));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return intDict;
    }

    @Override
    public void finish() {
        //saveArrayPref(getApplicationContext(), "courseList", checked);
        super.finish();
    }
}