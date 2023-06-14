package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private EditText id, nombre, tlf, email;
    private RadioButton informatica, ventas, recursosHumanos;
    private RadioGroup radioGroup;
    private CheckBox cbResponsable;
    private Button Insertar, Borrar, Actualizar, InsertarManual;
    private Button visualizarID;
    private Button actualizarDatos;
    private DB db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        id = findViewById(R.id.et_id);
        nombre = findViewById(R.id.et_nombre);
        tlf = findViewById(R.id.et_tlf);
        email = findViewById(R.id.et_email);

        radioGroup = findViewById(R.id.rg_departamentos);
        informatica = findViewById(R.id.rb_informatica);
        ventas = findViewById(R.id.rb_ventas);
        recursosHumanos = findViewById(R.id.rb_recursos);

        cbResponsable = findViewById(R.id.cb_responsable);

        Insertar = findViewById(R.id.btn_Insertar);
        Borrar = findViewById(R.id.btn_Borrar);
        Actualizar = findViewById(R.id.btn_Actualizar);
        InsertarManual = findViewById(R.id.btn_InsertarManual);
        actualizarDatos = findViewById(R.id.btn_actualizarDatos);

        db = new DB(this);

        InsertarManual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int idEmpleado = Integer.parseInt(id.getText().toString());
                String nombreEmpleado = nombre.getText().toString();
                int tlfEmpleado = Integer.parseInt(tlf.getText().toString());
                String correoEmpleado = email.getText().toString();
                Boolean responsable = cbResponsable.isChecked();


                Empleado empleado = new Empleado(idEmpleado, nombreEmpleado, tlfEmpleado, correoEmpleado, null, responsable);

                switch (radioGroup.getCheckedRadioButtonId()) {
                    case R.id.rb_informatica:
                        empleado.setDepartamento(informatica.getText().toString());
                        db.Insertar(empleado);
                        break;
                    case R.id.rb_recursos:
                        empleado.setDepartamento(recursosHumanos.getText().toString());
                        db.Insertar(empleado);
                        break;
                    case R.id.rb_ventas:
                        empleado.setDepartamento(ventas.getText().toString());
                        db.Insertar(empleado);
                        break;
                }

            }
        });
        actualizarDatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String idBD = id.getText().toString();
                String nombreBD = nombre.getText().toString();
                String tlfBD = tlf.getText().toString();
                String emailBD = email.getText().toString();

                Boolean responsable = cbResponsable.isChecked();

                if (!idBD.isEmpty() && !nombreBD.isEmpty() && !tlfBD.isEmpty() && !emailBD.isEmpty()) {
                    Empleado empleado = new Empleado(Integer.parseInt(idBD), nombreBD, Integer.parseInt(tlfBD), emailBD, null, responsable);

                    switch (radioGroup.getCheckedRadioButtonId()) {
                        case R.id.rb_informatica:
                            String departamento = informatica.getText().toString();
                            empleado.setDepartamento(departamento);
                            db.ActualizarUsuario(empleado);
                            break;

                        case R.id.rb_ventas:
                            departamento = ventas.getText().toString();
                            empleado.setDepartamento(departamento);
                            db.ActualizarUsuario(empleado);
                            break;

                        case R.id.rb_recursos:
                            departamento = recursosHumanos.getText().toString();
                            empleado.setDepartamento(departamento);
                            db.ActualizarUsuario(empleado);
                            break;
                        default:
                            Toast.makeText(MainActivity.this, "TIENE QUE HABER AL MENOS UN CHECKBOX MARCADO", Toast.LENGTH_SHORT).show();
                            break;
                    }
                } else {
                    Toast.makeText(MainActivity.this, "PARA REGISTRAR DEBES INTRODUCIR TODOS LOS DATOS", Toast.LENGTH_SHORT).show();
                }
            }

        });
        Actualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor cursor = db.empleados();
                if (cursor.getCount() == 0) {
                    Toast.makeText(MainActivity.this, "No existen datos", Toast.LENGTH_SHORT).show();
                    return;
                }
                while (cursor.moveToNext()) {
                    id.setText(String.valueOf(cursor.getInt(0)));
                    nombre.setText(cursor.getString(1));
                    tlf.setText(String.valueOf(cursor.getInt(2)));
                    email.setText(cursor.getString(3));
                    switch (cursor.getString(4)) {
                        case "Departamento de Informatica":
                            informatica.setChecked(true);
                            break;
                        case "Departamento de Ventas":
                            ventas.setChecked(true);
                            break;
                        case "Departamento de Recursos Humanos":
                            recursosHumanos.setChecked(true);
                            break;
                    }
                    if (cursor.getInt(5) == 1) {
                        cbResponsable.setChecked(true);
                    }
                }
                cursor.close();
            }
        });
        visualizarID = findViewById(R.id.btn_Actualizar2);
        visualizarID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor cursor = db.empleadosID(id.getText().toString());
                if (cursor.getCount() == 0) {
                    Toast.makeText(MainActivity.this, "No existen datos", Toast.LENGTH_SHORT).show();
                    return;
                }
                while (cursor.moveToNext()) {
                    id.setText(String.valueOf(cursor.getInt(0)));
                    nombre.setText(cursor.getString(1));
                    tlf.setText(String.valueOf(cursor.getInt(2)));
                    email.setText(cursor.getString(3));
                    switch (cursor.getString(4)) {
                        case "Departamento de Informatica":
                            informatica.setChecked(true);
                            break;
                        case "Departamento de Ventas":
                            ventas.setChecked(true);
                            break;
                        case "Departamento de Recursos Humanos":
                            recursosHumanos.setChecked(true);
                            break;
                    }
                    if (cursor.getInt(5) == 1) {
                        cbResponsable.setChecked(true);
                    }
                }
                cursor.close();
            }
        });
        Borrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.EliminarUsuario(id.getText().toString());
            }
        });
    }

}