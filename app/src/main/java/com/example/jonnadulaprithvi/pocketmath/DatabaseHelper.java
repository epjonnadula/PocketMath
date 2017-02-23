package com.example.jonnadulaprithvi.pocketmath;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Eshwar Prithvi on 16-Aug-16.
 */
public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String database_name="pocketmath.db";
    public static final String history_table="history_table";
    public static final String terms_condition="terms_condition";


    public DatabaseHelper(Context context) {
        super(context, database_name, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
                "create table history_table " +
                        "(date text,time text,unit1 text , input text,unit2 text,result text)"
        );

        db.execSQL(
                "create table terms_condition " +
                        "(value int)"
        );

        ContentValues contentValues = new ContentValues();
        contentValues.put("value", "0");
        db.insert(terms_condition, null, contentValues);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+history_table);

        db.execSQL("DROP TABLE IF EXISTS " + terms_condition);


                onCreate(db);
    }
    public boolean insertHistory (String date,String time,String unit1, String input, String unit2,String result)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("date", date);
        contentValues.put("time", time);
        contentValues.put("unit1", unit1);
        contentValues.put("input", input);
        contentValues.put("unit2", unit2);
        contentValues.put("result", result);

        long a=db.insert(history_table, null, contentValues);
        if(a == -1)
            return false;
        else
            return true;
    }




    public Cursor getHistory()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        String[] allColumns = new String[]{"date","time","unit1","input","unit2","result"};
        Cursor c = db.query(history_table, allColumns, null, null, null, null, null);
        if (c != null) {
            c.moveToFirst();
        }
        return c;

    }



    public void clearHistory()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("delete from "+history_table);
    }






    public void updateValue(int value)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("UPDATE terms_condition SET value = "+value);
    }
    public int getValue()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        String[] allColumns = new String[]{"value"};
        Cursor c = db.query(terms_condition, allColumns, null, null, null, null, null);
        if (c != null) {
            c.moveToFirst();

        }
        return Integer.parseInt(c.getString(0));

    }
}
