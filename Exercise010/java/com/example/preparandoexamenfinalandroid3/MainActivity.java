package com.example.preparandoexamenfinalandroid3;

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
        Actualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Visualizar.class);
                startActivity(i);
            }
        });
        Borrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.Eliminar();
            }
        });

    }

}