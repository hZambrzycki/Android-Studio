package com.example.examen_2ev_hz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RadioButton rb1, rb2, rb3;
    private RadioGroup radioGroup;
    private Context context = MainActivity.this;
    private ArrayList<String> datos;
    private ArrayList<Libro> libros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup = findViewById(R.id.radioGroup);

        rb1 = findViewById(R.id.rb_1);
        rb2 = findViewById(R.id.rb_2);
        rb3 = findViewById(R.id.rb_3);

        datos = new ArrayList<>();
        libros =new ArrayList<>();

        visualizarLibrosArchivo();
    }

    private void visualizarLibrosArchivo() {
        InputStream f = context.getResources().openRawResource(R.raw.libros);
        BufferedReader br = new BufferedReader(new InputStreamReader(f));
        try {
            String datosArchivo = br.readLine();
            while (datosArchivo != null) {
                datos.add(datosArchivo);
                datosArchivo = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Libro libro1 = new Libro(Integer.parseInt(datos.get(0)), datos.get(1), datos.get(2));
        Libro libro2 = new Libro(Integer.parseInt(datos.get(3)), datos.get(4), datos.get(5));
        Libro libro3 = new Libro(Integer.parseInt(datos.get(6)), datos.get(7), datos.get(8));
        Libro libro4 = new Libro(Integer.parseInt(datos.get(9)), datos.get(10), datos.get(11));


        libros.add(libro1);
        libros.add(libro2);
        libros.add(libro3);
        libros.add(libro4);

        for (int i = 1; i < libros.size()-1; i++) {
            rb1.setText(libros.get(i++).getNombre());
            rb2.setText(libros.get(i++).getNombre());
            rb3.setText(libros.get(i++).getNombre());
        }

        rb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, VisualizarLibros.class);
                i.putExtra("libro", libro2.toString());
                i.putExtra("id", libro2.getId());
                i.putExtra("titulo", libro2.getNombre());
                i.putExtra("autor", libro2.getAutor());
                startActivity(i);
            }
        });
        rb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, VisualizarLibros.class);
                i.putExtra("libro", libro3.toString());
                i.putExtra("id", libro3.getId());
                i.putExtra("titulo", libro3.getNombre());
                i.putExtra("autor", libro3.getAutor());
                startActivity(i);
            }
        });
        rb3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, VisualizarLibros.class);
                i.putExtra("libro", libro4.toString());
                i.putExtra("id", libro4.getId());
                i.putExtra("titulo", libro4.getNombre());
                i.putExtra("autor", libro4.getAutor());
                startActivity(i);
            }
        });
    }


}