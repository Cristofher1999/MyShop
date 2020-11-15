package com.example.myshop;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class AdminSQLiteOpenHelper extends SQLiteOpenHelper {

    public AdminSQLiteOpenHelper(Context context) {
        super(context, "Database.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table usuarios( email text primary key, password text, username text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    db.execSQL("drop table if exists usuarios");
    }

    public boolean insert(String email, String username, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("email", email);
        contentValues.put("password",password);
        contentValues.put("username",username);
        long ins = db.insert("usuarios", null, contentValues);
        if (ins==-1) return false;
        else return true;
    }

    public boolean checkmail(String email){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from usuarios where email=?", new String[]{email});
        if (cursor.getCount()>0) return false;
        else return true;
    }
}
