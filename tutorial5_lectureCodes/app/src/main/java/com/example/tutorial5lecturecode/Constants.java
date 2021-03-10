package com.example.tutorial5lecturecode;

import android.provider.BaseColumns;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public interface Constants extends BaseColumns {

    public static final String TABLE_NAME = "events" ;
    // Columns in the Events database
    public static final String TIME = "time" ;
    public static final String TITLE = "title" ;


}
