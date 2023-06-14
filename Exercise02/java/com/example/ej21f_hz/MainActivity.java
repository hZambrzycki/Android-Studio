package com.example.ej21f_hz;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText nombre, tlf, fecha_nacimiento;
    Button insertar, actualizarUsuario, eliminarUsuario, verUsuarios;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nombre = findViewById(R.id.nombre);
        tlf = findViewById(R.id.et_tlf);
        fecha_nacimiento = findViewById(R.id.et_fechaNacimiento);
        insertar = findViewById(R.id.btn_insertar);
        actualizarUsuario = findViewById(R.id.btn_actualizarUsuario);
        eliminarUsuario = findViewById(R.id.btn_eliminarUsuario);
        verUsuarios = findViewById(R.id.btn_verUsuarios);



        DB = new DBHelper(this);



        insertar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombreET = nombre.getText().toString();
                String telefonoET = tlf.getText().toString();
                String fechaNacimientoET = fecha_nacimiento.getText().toString();

                Boolean datosIntroducidos = DB.insertarUsuario(nombreET, telefonoET, fechaNacimientoET);
                if(datosIntroducidos==true)
                    Toast.makeText(MainActivity.this, "Usuario Introducido", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity.this, "No ha sido posible introducir el usuario", Toast.LENGTH_SHORT).show();
            }
        });



        actualizarUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombreET = nombre.getText().toString();
                String telefonoET = tlf.getText().toString();
                String fechaNacimientoET = fecha_nacimiento.getText().toString();

                Boolean datosActualizados = DB.actualizarUsuario(nombreET, telefonoET, fechaNacimientoET);
                if(datosActualizados==true)
                    Toast.makeText(MainActivity.this, "Usuario actualizado", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity.this, "No ha sido posible actualizar el usuario", Toast.LENGTH_SHORT).show();
            }
        });



        eliminarUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombreET = nombre.getText().toString();
                Boolean comprobarUsuarioEliminado = DB.eliminarUsuario(nombreET);
                if(comprobarUsuarioEliminado==true)
                    Toast.makeText(MainActivity.this, "Usuario eliminado", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity.this, "Usuario no eliminado", Toast.LENGTH_SHORT).show();
            }
        });

        verUsuarios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor cursor = DB.usuarios();
                if(cursor.getCount()==0){
                    Toast.makeText(MainActivity.this, "No existen datos", Toast.LENGTH_SHORT).show();
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while(cursor.moveToNext()){
                    buffer.append("Nombre :"+cursor.getString(0)+"\n");
                    buffer.append("Telefono :"+cursor.getString(1)+"\n");
                    buffer.append("Fecha de nacimiento :"+cursor.getString(2)+"\n\n");
                }

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setCancelable(true);
                builder.setTitle("Usuarios : ");
                builder.setMessage(buffer.toString());
                builder.show();
            }        });
    }}