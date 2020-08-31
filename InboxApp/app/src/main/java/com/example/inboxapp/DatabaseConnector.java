package com.example.inboxapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseConnector extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "WorkflowTest1.db";
    public static final String TABLE = "message_table";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "GÖNDEREN";
    public static final String COL_3 = "ALICI";
    public static final String COL_4 = "KONU";
    public static final String COL_5 = "İLETİ";

    public DatabaseConnector(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE +" (ID INTEGER PRIMARY KEY AUTOINCREMENT,GÖNDEREN TEXT,ALICI TEXT,KONU TEXT,İLETİ TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE);
        onCreate(db);
    }

    public boolean insertData(String alıcı, String konu, String ileti){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, "berkay@user.com");
        contentValues.put(COL_3, alıcı);
        contentValues.put(COL_4, konu);
        contentValues.put(COL_5, ileti);
        long result = db.insert(TABLE, null, contentValues);
        if(result == -1){
            return false;
        }else
            return true;
    }

    public Cursor getAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from " + TABLE, null);
        return res;
    }
}
