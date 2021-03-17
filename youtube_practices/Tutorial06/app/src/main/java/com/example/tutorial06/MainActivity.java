package com.example.tutorial06;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    String key = "91883c9aeec7ccb4b9383492de6d86e8";
    String city = "London";
    String url = "https://api.openweathermap.org/data/2.5/weather?q="+ city+ ",uk&appid="+ key;

    EditText cityInput;
    TextView temperatureTextView;
    TextView mainWeather;
    TextView textDescription;
    TextView weatherCity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cityInput = (EditText) findViewById(R.id.locationEditText);
        temperatureTextView = (TextView) findViewById(R.id.temperatureTextView);
        mainWeather = (TextView) findViewById(R.id.mainWeather);
        textDescription = (TextView) findViewById(R.id.descriptionWeather);
        weatherCity = (TextView) findViewById(R.id.weatherCity);

        weatherCity.setText("Weather: " + city);
        loadWeatherData();
    }


    public void fetchData(View view) {

        if(!cityInput.getText().toString().isEmpty()) {
            city = cityInput.getText().toString();
            url = "https://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + key;
        }

        weatherCity.setText("Weather: " + city);
        loadWeatherData();
    }

    public void loadWeatherData(){
        DownloadWeather downloadWeather = new DownloadWeather();

        try{
            String result = "-";
            result = downloadWeather.execute(url).get();
            JSONObject jsonObject = new JSONObject(result);
            JSONObject jsonMain = jsonObject.getJSONObject("main");
            String stringTemp = jsonMain.getString("temp");

            JSONArray jsonWeather = jsonObject.getJSONArray("weather");
            JSONObject jsonWeatherZero = jsonWeather.getJSONObject(0);
            String stringMainDay = jsonWeatherZero.getString("main");
            String stringDescDay = jsonWeatherZero.getString("description");

            temperatureTextView.setText(stringTemp);
            mainWeather.setText(stringMainDay);
            textDescription.setText(stringDescDay);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void onHistoryPressed(View view) {
        Intent intent = new Intent(this, WeatherActivity.class);
        startActivity(intent);
    }

    public void onSave(View view) {
        WeatherDataHelper db = new WeatherDataHelper(this);
        db.addWeatherDetail(new Weather(
                city,
                Double.parseDouble(temperatureTextView.getText().toString()),
                mainWeather.getText().toString(),
                textDescription.getText().toString()
        ));
        Toast.makeText(this, "Successfully saved a record", Toast.LENGTH_SHORT).show();
    }
}