package com.example.examen;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Puntos extends AppCompatActivity {
    private TextView tv_Puntos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puntos);
        tv_Puntos = findViewById(R.id.tvPuntos);

        int puntos = getIntent().getIntExtra("PUNTOS",0);

        tv_Puntos.setText(String.valueOf(puntos));

    }
}