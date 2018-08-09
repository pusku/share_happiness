package com.rajon.sharehappiness;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLiteDBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "info.db";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_NAME = "profile";
    public static final String COLUMN_ID =  "userid";
    public static final String COLUMN_FULLNAME =  "fullname";
    public static final String COLUMN_EMAIL =  "email";
    public static final String COLUMN_PASSWORD =  "password";
    public static final String COLUMN_MOBILE =  "mobile";

    public static final String TABLE_NAME1 = "foods";
    public static final String COLUMN_FOOD_ID =  "food_id";
    public static final String COLUMN_TITLE =  "title";
    public static final String COLUMN_TYPE =  "type";
    public static final String COLUMN_DETAILS =  "details";
    public static final String COLUMN_LOCATION =  "location";
    public static final String COLUMN_STATUS =  "status";
    public static final String COLUMN_VOLUNTEER_ID =  "volunteer_id";

    private static final String CREATE_TABLE_PROFILE =
            "CREATE TABLE " + TABLE_NAME + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_FULLNAME + " TEXT, "+
                    COLUMN_EMAIL + " TEXT, " +
                    COLUMN_PASSWORD + " TEXT, " +
                    COLUMN_MOBILE + " TEXT " + ")";
    private static final String CREATE_TABLE_FOODS =
            "CREATE TABLE " + TABLE_NAME1 + " (" +
                    COLUMN_FOOD_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_TITLE + " TEXT, "+
                    COLUMN_TYPE + " TEXT, " +
                    COLUMN_DETAILS + " TEXT, " +
                    COLUMN_STATUS + " TEXT" + ")";

    //modified constructor
    public SQLiteDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE_PROFILE);
        sqLiteDatabase.execSQL(CREATE_TABLE_FOODS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME1);
        onCreate(sqLiteDatabase);
    }

   }