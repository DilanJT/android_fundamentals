package com.example.tutorial06;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class WeatherActivity extends AppCompatActivity {

    ListView listView;
    List<String> weatherList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        listView = (ListView) findViewById(R.id.weatherListView);
        weatherList = new ArrayList<>();

        getAllWeatherDetails();

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, weatherList);
        listView.setAdapter(adapter);


    }

    public void getAllWeatherDetails(){
        WeatherDataHelper db = new WeatherDataHelper(this);
        List<Weather> tempwWeatherLists = db.getAllWeatherDetails();

        for(Weather w : tempwWeatherLists){
            String log =w.getWeatherID() + ", CITY:" + w.getCityName() + ", Temp:" + w.getCityTemperature() +
                    ", status:"+ w.getMainDayStatus() + ", status description:" + w.getDescDayStatus();
            weatherList.add(log);
        }
    }
}