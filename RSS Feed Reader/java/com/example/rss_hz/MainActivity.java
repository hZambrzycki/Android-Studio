package com.example.rss_hz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity  {
    private Button btn_porDefecto;
    private Button btn_RSSpropias;
    private Button btn_Info;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_porDefecto = findViewById(R.id.btn_predeterminadas);
        btn_RSSpropias = findViewById(R.id.btn_RSSusuario);
        btn_Info = findViewById(R.id.btn_info);

        btn_RSSpropias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), GestorRSS.class);
                startActivity(i);
            }
        });
        btn_porDefecto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent i = new Intent(getApplicationContext(), Inicio.class);
                startActivity(i);
            }
        });
        btn_Info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Informacion.class);
                startActivity(i);
            }
        });

    }
}