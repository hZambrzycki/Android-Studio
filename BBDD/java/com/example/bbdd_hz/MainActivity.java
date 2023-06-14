package com.example.bbdd_hz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText et_codigo, et_nombre, et_calidad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_codigo = findViewById(R.id.et_codigo);
        et_nombre = findViewById(R.id.et_nombre);
        et_calidad = findViewById(R.id.et_calidad);
    }
    public void Registrar (View view){
        SQLiteBase admin = new SQLiteBase(this,"registro",null,1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        String codigo = et_codigo.getText().toString();
        String nombre = et_nombre.getText().toString();
        String calidad = et_calidad.getText().toString();

        if(!codigo.isEmpty() && !nombre.isEmpty() && !calidad.isEmpty()){
            ContentValues registro = new ContentValues();
            registro.put("codigo",codigo);
            registro.put("nombre",nombre);
            registro.put("calidad",calidad);

            BaseDeDatos.insert("registro",null,registro);

            BaseDeDatos.close();
            et_codigo.setText("");
            et_nombre.setText("");
            et_calidad.setText("");
            Toast.makeText(this, "INTRODUCIDO", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "RELLENA TODO", Toast.LENGTH_SHORT).show();
        }
    }
    public void Buscar(View view){
        SQLiteBase admin = new SQLiteBase(this,"registro",null,1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();
        String codigo = et_codigo.getText().toString();

        if(!codigo.isEmpty()){
            Cursor cursor = BaseDeDatos.rawQuery
                            ("SELECT nombre,calidad FROM registro WHERE codigo="+codigo,null);
            if(cursor.moveToFirst()){
                et_nombre.setText(cursor.getString(0));
                et_calidad.setText(cursor.getString(1));
                BaseDeDatos.close();
            }else{
                Toast.makeText(this, "NO EXISTE ", Toast.LENGTH_SHORT).show();
                BaseDeDatos.close();
            }
        }else{
            Toast.makeText(this, "INTRODUCE EL CODIGO", Toast.LENGTH_SHORT).show();
        }
    }
    public void Eliminar(View view){
        SQLiteBase admin = new SQLiteBase(this,"registro",null, 1);

        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        String codigo = et_codigo.getText().toString();

        if(!codigo.isEmpty()){
            int cantidad = BaseDeDatos.delete("registro","codigo="+codigo,null);
            BaseDeDatos.close();
            et_codigo.setText("");
            et_nombre.setText("");
            et_calidad.setText("");
            if(cantidad > 0 ){
                Toast.makeText(this, "BORRADO EXITOSAMENTE", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this, "NO EXISTE", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(this, "INTRODUCE EL CODIGO", Toast.LENGTH_SHORT).show();
        }
    }
}