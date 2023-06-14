package com.example.registroempleados;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.CheckBox;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DB extends SQLiteOpenHelper {
    private final static String  DB_NAME = "empleados";
    private final static String DB_SQL = "CREATE TABLE empleados(id INTEGER PRIMARY KEY, nya STRING, telefono INTEGER, correo STRING,departamento TEXT, responsable BOOLEAN   )";
    private final static int DB_VERSION =1;

    private SQLiteDatabase db;

    public DB(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DB_SQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }



    public void Insertar(Empleado e){
        ContentValues cv = new ContentValues();
        cv.put("id",e.getId());
        cv.put("nya",e.getNya());
        cv.put("telefono",e.getTelefono());
        cv.put("correo",e.getCorreo());
        cv.put("departamento",e.getDepartamento());
        cv.put("responsable",e.getResponsable());
        db.insert("empleados",null, cv);
        System.out.println("USUARIO INTRODUCIDO:" +e);
        db.close();
    }


    //VISUALIZAR DATOS
    public ArrayList<Empleado>recuperarEmpleados(){
        ArrayList<Empleado> lista = new ArrayList<>();
        Cursor cursor = db.rawQuery("SELECT * FROM EMPLEADOS",null);
        while(cursor.moveToNext()) {
            int id = cursor.getInt(0);
            String nya = cursor.getString(1);
            int telefono = cursor.getInt(2);
            String correo = cursor.getString(3);
            String departamento = cursor.getString(4);
            int responsable = cursor.getInt(5);

            if (responsable == 1) {
                Boolean r = true;
                Empleado empleado = new Empleado(id, nya, telefono, correo, departamento, r);
                lista.add(empleado);
            }

            else if (responsable == 2) {
                Boolean r = false;
                Empleado empleado = new Empleado(id, nya, telefono, correo, departamento, r);
                lista.add(empleado);
            }
        }
        cursor.close();
        return lista;
    }

    public void eliminar(int id){
        db.delete("empleados","id="+id,null);
        db.close();
    }

    public void actualizar (Empleado e){
        ContentValues cv = new ContentValues();
        cv.put("id",e.getId());
        cv.put("nya",e.getNya());
        cv.put("telefono",e.getTelefono());
        cv.put("correo",e.getCorreo());
        cv.put("departamento",e.getDepartamento());
        cv.put("responsable",e.getResponsable());

        db.update("empleados",cv,"id="+e.getId(),null);
        System.out.println("EMPLEADO ACTUALIZADO " + e);
        db.close();
    }


}
