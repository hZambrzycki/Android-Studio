package com.example.preparandoexamenfinalandroid3;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DB extends SQLiteOpenHelper {
    public DB(@Nullable Context context) {
        super(context, "objetos", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("create TABLE objetos(id INTEGER PRIMARY KEY, nombre STRING, tlf INTEGER, email STRING, departamento TEXT, encargado BOOLEAN)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    }

    public void Insertar(Empleado e) {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put("id", e.getId());
        cv.put("nombre", e.getNombre());
        cv.put("tlf", e.getTelefono());
        cv.put("email", e.getCorreo());
        cv.put("departamento", e.getDepartamento());
        cv.put("encargado", e.getResponsable());

        database.insert("objetos", null, cv);
        database.close();


    }

    public Cursor visualizar() {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from objetos", null);
        return cursor;
    }

    public void Eliminar() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("objetos", null, null);
    }

    public void VisualizarPorId(String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from objetos where id = ?", new String[]{id});
if (cursor.getCount() > 0) {
    db.up
}
    }
}