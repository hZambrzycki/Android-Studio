package com.example.examen_2ev_hz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class visualizacionDeLibros extends AppCompatActivity {
    private TextView visualizarBBDD;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualizacion_de_libros);

        visualizarBBDD = findViewById(R.id.tv_visualizarBBDD);

        String datos = getIntent().getStringExtra("libro");

        visualizarBBDD.setText(datos);
    }
}