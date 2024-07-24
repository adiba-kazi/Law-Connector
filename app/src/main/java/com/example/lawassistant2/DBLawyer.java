package com.example.lawassistant2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBLawyer extends SQLiteOpenHelper {
    public static final String db_name = "project";
    public static final int db_version = 1;
    public static final String table_name = "Lawyer";
    public static final String l_id = "lid";
    public static final String l_name = "lname";
    public static final String l_casetype = "lcasetype";
    public static final String l_location = "location";
    public static final String l_contact = "lcontact";
    public static final String l_experience = "lexp";
    public static final String l_officeadd = "oadd";
    public static final String l_officetime = "otime";
    public static final String table_name2 = "User";
    public static final String u_id = "uid";
    public static final String u_name = "uname";
    public static final String u_contact = "ucontact";

    public DBLawyer(Context context) {
        super(context, db_name, null, db_version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + table_name + "(" + l_id + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + l_name + " TEXT, " + l_casetype + " TEXT, " + l_location + " TEXT, " + l_contact + " TEXT, "
                + l_experience + " TEXT, " + l_officeadd + " TEXT, " + l_officetime + " TEXT)";
        db.execSQL(query);
        String query1 = "CREATE TABLE " + table_name2 + "(" + u_id + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + u_name + " TEXT, " + u_contact + " TEXT)";
        db.execSQL(query1);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + table_name);
        db.execSQL("DROP TABLE IF EXISTS " + table_name2);
        onCreate(db);
    }

    public long insertLawyer(String lname, String lcasetype, String location, String lcontact, String lexp, String oadd, String otime) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(l_name, lname);
        values.put(l_casetype, lcasetype);
        values.put(l_location, location);
        values.put(l_contact, lcontact);
        values.put(l_experience, lexp);
        values.put(l_officeadd, oadd);
        values.put(l_officetime, otime);

        long newRowId = db.insert(table_name, null, values);
        db.close();
        return newRowId;
    }


    public boolean verifyLogin(String lname, String lcontact) {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] columns = {l_name, l_contact};
        String selection = l_name + "=? AND " + l_contact + "=?";
        String[] selectionArgs = {lname, lcontact};

        Cursor cursor = db.query(table_name, columns, selection, selectionArgs, null, null, null);

        boolean result = cursor.moveToFirst();
        cursor.close();
        db.close();
        return result;
    }
    public Cursor getLawyers(String caseType, String location) {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] columns = {l_name, l_casetype, l_location, l_contact, l_experience, l_officeadd, l_officetime};
        String selection = l_casetype + "=? AND " + l_location + "=?";
        String[] selectionArgs = {caseType, location};

        return db.query(table_name, columns, selection, selectionArgs, null, null, null);
    }

    public long insertUser(String uname, String ucontact) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(u_name, uname);
        values.put(u_contact, ucontact);

        long newRowId = db.insert(table_name2, null, values);
        //db.close();
        return newRowId;
    }
    public boolean verifyLogin1(String uname, String ucontact) {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] columns = {u_name, u_contact};
        String selection = u_name + "=? AND " + u_contact + "=?";
        String[] selectionArgs = {uname, ucontact};

        Cursor cursor = db.query(table_name2, columns, selection, selectionArgs, null, null, null);

        boolean result = cursor.moveToFirst();
        cursor.close();
        db.close();
        return result;
    }

}

