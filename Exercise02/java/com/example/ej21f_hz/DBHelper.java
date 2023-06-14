package com.example.ej21f_hz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context) {
        super(context, "usuarios.db", null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("create Table Usuarios(nombre TEXT primary key, tlf TEXT, fechaNacimiento TEXT)");
    }
    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int ii) {
        DB.execSQL("drop Table if exists Usuarios");
    }
    public Boolean insertarUsuario(String nombre, String tlf, String fechaNacimiento)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("nombre", nombre);
        contentValues.put("tlf", tlf);
        contentValues.put("fechaNacimiento", fechaNacimiento);


        long result=DB.insert("Usuarios", null, contentValues);
        if(result==-1){
            return false;
        }else{
            return true;
        }
    }
    public Boolean actualizarUsuario(String nombre, String tlf, String fechaNacimiento)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("tlf", tlf);
        contentValues.put("fechaNacimiento", fechaNacimiento);
        Cursor cursor = DB.rawQuery("Select * from Usuarios where nombre = ?", new String[]{nombre});
        if (cursor.getCount() > 0) {
            long result = DB.update("Usuarios", contentValues, "nombre=?", new String[]{nombre});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }
    public Boolean eliminarUsuario (String nombre)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from Usuarios where nombre = ?", new String[]{nombre});
        if (cursor.getCount() > 0) {
            long result = DB.delete("Usuarios", "nombre=?", new String[]{nombre});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }
    public Cursor usuarios ()
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from Usuarios", null);
        return cursor;
    }
}