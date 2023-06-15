package com.example.rss_hz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "rss.db";
    private static final String DB_TABLE = "tabla_rss";

    //columnas
    private static final String ID = "ID";
    private static final String NAME = "NAME";
    private static final String URL = "URL";
    private static final String DESCRIPCION = "DESCRIPCION";
    private static final String IMAGENES = "img";

    private static final String CREATE_TABLE = "CREATE TABLE " + DB_TABLE+ " (" +
            ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            NAME + " TEXT, " +
            URL + " TEXT, " +
            DESCRIPCION + " TEXT, "+
            IMAGENES + " INTEGER " + ")";
    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        onCreate(sqLiteDatabase);
    }

    public boolean insertData(String name, String url, String descripcion, int imagenes) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(NAME, name);
        contentValues.put(URL, url);
        contentValues.put(DESCRIPCION, descripcion);
        contentValues.put(IMAGENES, imagenes);

        long result = db.insert(DB_TABLE, null, contentValues);

        return result != -1;

    }
    public Cursor viewData() {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM " + DB_TABLE;
        Cursor cursor = db.rawQuery(query, null);

        return cursor;
    }
}