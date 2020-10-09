package com.maktab.digitallibrary.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.maktab.digitallibrary.mainPage.Structure;

import java.util.ArrayList;

public class DatabaseAccess {
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase db;
    private static DatabaseAccess instance;
    Cursor c = null;
    public static ArrayList<Structure> flowerList = new ArrayList<Structure>();
    public static ArrayList<Structure> treeList = new ArrayList<Structure>();
    public static ArrayList<Structure> favoriteList = new ArrayList<Structure>();

    private DatabaseAccess(Context context) {
        this.openHelper = new DatabaseOpenHelper(context);
    }

    public static DatabaseAccess getInstance(Context context) {
        if (instance == null) {
            instance = new DatabaseAccess(context);
        }

        return instance;
    }

    public void open() {
        this.db = openHelper.getWritableDatabase();

    }

    public void close() {
        if (db != null) {
            this.db.close();
        }
    }

    public ArrayList<Structure> getFlower() {
        c = db.rawQuery("select * from main where subject='flower'", null);
        //StringBuffer buffer = new StringBuffer();
        while (c.moveToNext()) {
            String title = c.getString(c.getColumnIndex("title"));
            String content = c.getString(c.getColumnIndex("content"));
            String more = c.getString(c.getColumnIndex("more"));
            String imgAddress = c.getString(c.getColumnIndex("img_adrs"));
            int id = c.getInt(c.getColumnIndex("id"));

            Structure struct = new Structure(title, content, more, imgAddress, id);
            struct.setTitle(title);
            struct.setContent(content);
            struct.setMore(more);
            struct.setImgAddress(imgAddress);
            struct.setId(id);
            flowerList.add(struct);
        }
        return flowerList;
    }

    public ArrayList<Structure> getTree() {
        c = db.rawQuery("select * from main where subject='tree'", null);

        while (c.moveToNext()) {
            String title = c.getString(c.getColumnIndex("title"));
            String content = c.getString(c.getColumnIndex("content"));
            String more = c.getString(c.getColumnIndex("more"));
            String imgAddress = c.getString(c.getColumnIndex("img_adrs"));
            int id = c.getInt(c.getColumnIndex("id"));

            Structure struct = new Structure(title, content, more, imgAddress, id);
            struct.setTitle(title);
            struct.setContent(content);
            struct.setMore(more);
            struct.setImgAddress(imgAddress);
            struct.setId(id);
            treeList.add(struct);
        }
        return treeList;
    }

    public ArrayList<Structure> getFav() {
        c = db.rawQuery("select * from main where fav=1", null);

        while (c.moveToNext()) {
            String title = c.getString(c.getColumnIndex("title"));
            String content = c.getString(c.getColumnIndex("content"));
            String more = c.getString(c.getColumnIndex("more"));
            String imgAddress = c.getString(c.getColumnIndex("img_adrs"));
            int id = c.getInt(c.getColumnIndex("id"));

            Structure struct = new Structure(title, content, more, imgAddress, id);
            struct.setTitle(title);
            struct.setContent(content);
            struct.setMore(more);
            struct.setImgAddress(imgAddress);
            struct.setId(id);
            favoriteList.add(struct);
        }
        return favoriteList;
    }



}


