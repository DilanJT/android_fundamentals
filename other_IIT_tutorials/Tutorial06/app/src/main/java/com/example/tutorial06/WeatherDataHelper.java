package com.example.tutorial06;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import static android.provider.BaseColumns._ID;
import static com.example.tutorial06.Constants.CITY;
import static com.example.tutorial06.Constants.DESC_WEATHER;
import static com.example.tutorial06.Constants.MAIN_WEATHER;
import static com.example.tutorial06.Constants.TABLE_NAME;
import static com.example.tutorial06.Constants.TEMPERATURE;

public class WeatherDataHelper  extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "weather_history.db";
    private static final int DATABASE_VERSION = 1;

    //helper object for the employees database
    public WeatherDataHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + " ("
                + _ID
                + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + CITY + " TEXT NOT NULL,"
                + TEMPERATURE + " TEXT,"
                + MAIN_WEATHER + " INTEGER,"
                + DESC_WEATHER + " TEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void addWeatherDetail(Weather weather){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(CITY, weather.getCityName());
        values.put(TEMPERATURE, weather.getCityTemperature());
        values.put(MAIN_WEATHER, weather.getMainDayStatus());
        values.put(DESC_WEATHER, weather.getDescDayStatus());

        db.insertOrThrow(TABLE_NAME, null, values);
        db.close();
    }

    public List<Weather> getAllWeatherDetails(){
        List<Weather> weatherList = new ArrayList<>();

        String select = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(select, null);

        if(cursor.moveToFirst()){
            do{
                Weather weather = new Weather();
                weather.setWeatherID(Integer.parseInt(cursor.getString(0)));
                weather.setCityName(cursor.getString(1));
                weather.setCityTemperature(Double.parseDouble(cursor.getString(2)));
                weather.setMainDayStatus(cursor.getString(3));
                weather.setDescDayStatus(cursor.getString(4));

                weatherList.add(weather);
            }while (cursor.moveToNext());
        }

        return weatherList;
    }
}
