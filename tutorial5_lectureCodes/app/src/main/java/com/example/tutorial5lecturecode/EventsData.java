package com.example.tutorial5lecturecode;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static android.provider.UserDictionary.Words._ID;
import static com.example.tutorial5lecturecode.Constants.TABLE_NAME;
import static com.example.tutorial5lecturecode.Constants.TIME;
import static com.example.tutorial5lecturecode.Constants.TITLE;

public class EventsData extends SQLiteOpenHelper {

    private static final String DATABASE_NAME =
            "events.db";
    private static final int DATABASE_VERSION = 1;


    /* Create a helper object for the Events database */
    public EventsData(Context ctx) {
        super(ctx, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + " ("
                + _ID
                + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + TIME + " INTEGER,"
                + TITLE + " TEXT NOT NULL);");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db,
                          int oldVersion,
                          int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
