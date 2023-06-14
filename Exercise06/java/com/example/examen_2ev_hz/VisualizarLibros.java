package com.example.examen_2ev_hz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class VisualizarLibros extends AppCompatActivity {
    private TextView textView;
    private Button btn_guardar, btn_visualizar;
    private BBDD db;
    private ArrayList<Libro> libros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualizar_libros);

        textView = findViewById(R.id.tv_libros);
        String datos = getIntent().getStringExtra("libro");
        textView.setText(datos);

        btn_guardar = findViewById(R.id.btn_almacenar);
        btn_visualizar = findViewById(R.id.btn_visualizarGuardados);

        db = new BBDD(this);
        String data = " ";

        libros = new ArrayList<>();
        btn_guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = getIntent().getIntExtra("id", 0);
                String titulo = getIntent().getStringExtra("titulo");
                String autor = getIntent().getStringExtra("autor");

                Libro libro = new Libro(id, titulo, autor);

                db.InsertarLibro(libro);
            }
        });
        btn_visualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1 = new Intent(VisualizarLibros.this, visualizacionDeLibros.class);
                Cursor cursor = db.visualizarLibros();
                for (int i = 0; i <= cursor.getCount(); i++) {
                    while (cursor.moveToNext()) {
                        int id = cursor.getInt(i++);
                        String nombre = cursor.getString(i++);
                        String autor = cursor.getString(i++);

                        Libro libro = new Libro(id,nombre,autor);
                        libros.add(libro);
                        i1.putExtra("libro", libros.toString());
                    }
                }
                startActivity(i1);
            }
        });
    }
}