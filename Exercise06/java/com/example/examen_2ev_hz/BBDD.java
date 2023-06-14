package com.example.examen_2ev_hz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class BBDD extends SQLiteOpenHelper {

    public BBDD(@Nullable Context context) {
        super(context, "libros", null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("CREATE TABLE libros(id INTEGER PRIMARY KEY, titulo STRING, autor STRING)");
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    }
    public void InsertarLibro(Libro libro) {
        ContentValues cv = new ContentValues();
        SQLiteDatabase db = this.getWritableDatabase();

        cv.put("id", libro.getId());
        cv.put("titulo", libro.getNombre());
        cv.put("autor", libro.getAutor());

        db.insert("libros", null, cv);
        db.close();
    }
    public Cursor visualizarLibros() {
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery("Select * from libros", null);

        return cursor;
    }
}
