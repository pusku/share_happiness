package com.rajon.sharehappiness;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Data {
    SQLiteOpenHelper openHelper;
    SQLiteDatabase db;
    public void InsertData(String title, String type, String details, String location) {

        ContentValues values = new ContentValues();
        values.put(SQLiteDBHelper.COLUMN_TITLE,title);
        values.put(SQLiteDBHelper.COLUMN_TYPE,type);
        values.put(SQLiteDBHelper.COLUMN_DETAILS,details);
        values.put(SQLiteDBHelper.COLUMN_LOCATION,location);
        long id = db.insert(SQLiteDBHelper.TABLE_NAME1,null,values);
    }
}
