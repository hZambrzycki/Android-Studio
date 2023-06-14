package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class DB extends SQLiteOpenHelper {


    public DB(@Nullable Context context) {
        super(context, "objetos", null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("create TABLE objetos(id " +
                "INTEGER PRIMARY KEY, nombre STRING, " +
                "tlf INTEGER, email STRING, departamento TEXT, " +
                "encargado BOOLEAN)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    }

    public void Insertar(Empleado e)
    {
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
    public void InsertarManual(int id, String nombre, int telefono, String correo, String departamento, Boolean responsable) {
        ContentValues cv = new ContentValues();
        cv.put("id", id);
        cv.put("nombre", nombre);
        cv.put("telefono", telefono);
        cv.put("correo", correo);
        cv.put("departamento", departamento);
        cv.put("responsable", responsable);

        SQLiteDatabase DB = this.getWritableDatabase();

        DB.insert("objetos", null, cv);
        DB.close();
    }
    public Cursor empleados ()
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from objetos", null);
        return cursor;
    }
    public Cursor empleadosID (String id)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from objetos where id = ?", new String[]{id});
        return cursor;
    }
    public void EliminarUsuario(String id) {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from objetos where id =?",new String[]{id});
        if (cursor.getCount()>0) {
            DB.delete("objetos", "id=?", new String[]{id});
        }
    }
    public void ActualizarUsuario(Empleado e) {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("id", e.getId());
        cv.put("nombre",e.getNombre());
        cv.put("telefono", e.getTelefono());
        cv.put("correo", e.getCorreo());
        cv.put("departamento", e.getDepartamento());
        cv.put("responsable", e.getResponsable());

        Cursor cursor = DB.rawQuery("Select * from objetos where id =?", new String[]{String.valueOf(e.getId())});
        if (cursor.getCount()>0) {
            DB.update("objetos", cv, "id=?", new String[]{String.valueOf(e.getId())});
        }
    }
}
