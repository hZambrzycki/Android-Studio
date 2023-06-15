package com.example.rss_hz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GestorRSS extends AppCompatActivity {
    private Button introducirRSS, consultarRSS, volverMenu;
    DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestor_rss);
        introducirRSS = findViewById(R.id.btn_incluirRSS);
        consultarRSS = findViewById(R.id.btn_consultarRSS);
        volverMenu = findViewById(R.id.btn_VolverMenu);

        volverMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(GestorRSS.this, MainActivity.class);
                startActivity(i);
            }
        });
        db = new DatabaseHelper(this);
        consultarRSS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(GestorRSS.this, RSSpropias.class);
                startActivity(i);
            }
        });
        introducirRSS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(GestorRSS.this, IncluirRSS.class);
                startActivity(i);
            }
        });
    }
}