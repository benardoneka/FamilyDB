package com.example.familydb;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {


    public DatabaseHelper(Context context) {
        super(context, "child.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE tbl_family (id INTEGER PRIMARY KEY AUTOINCREMENT, fName TEXT, mName TEXT, cName TEXT, cAge TEXT, mobile TEXT, comment TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS tbl_family");
        onCreate(db);

    }

    public long addChildData(Child c) {

        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("fName", c.getnFather());
        cv.put("mName", c.getnMother());
        cv.put("cName", c.getnChild());
        cv.put("cAge", c.getChildAge());
        cv.put("mobile", c.getMobile());
        cv.put("comment", c.getCaseR());

        return db.insert("tbl_family", null, cv);
    }

    public ArrayList<Child> getAllChildren(){

        ArrayList<Child> children = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM tbl_family", null);

        if (cursor.moveToFirst()){
            do {
                int id = cursor.getInt(0);
                String fName = cursor.getString(1);
                String mName = cursor.getString(2);
                String cName = cursor.getString(3);
                String childAge = cursor.getString(4);
                String mobile = cursor.getString(5);
                String caseR = cursor.getString(6);

                Child c = new Child(id, fName, mName, cName, childAge, mobile, caseR);

                children.add(c);

            }while (cursor.moveToNext());
        }


        return children;
    }

    public int UpdateChild(Child c) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put("fName", c.getnFather());
        cv.put("mName", c.getnMother());
        cv.put("cName", c.getnChild());
        cv.put("cAge", c.getChildAge());
        cv.put("mobile", c.getMobile());
        cv.put("comment", c.getCaseR());

        return db.update("tbl_family", cv, "id=?", new String[]{String.valueOf(c.getId())});

    }

    public int deleteChild(int id) {
        SQLiteDatabase db = getWritableDatabase();
        return db.delete("tbl_family", "id=?", new String[]{String.valueOf(id)});

    }
}
