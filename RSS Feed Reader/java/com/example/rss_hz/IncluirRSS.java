package com.example.rss_hz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class IncluirRSS extends AppCompatActivity {

    DatabaseHelper db;

    private Button guardarRSS;
    private EditText introducirRSS;
    private EditText introducirNombreRSS;
    private EditText introducirDescripcionRSS;
    private Button seleccionarImagen;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_incluir_rss);

        guardarRSS = findViewById(R.id.btn_guardar);
        introducirRSS = findViewById(R.id.et_rss);
        introducirNombreRSS = findViewById(R.id.et_nombreRSS);
        introducirDescripcionRSS = findViewById(R.id.et_descripcionRSS);
        seleccionarImagen = findViewById(R.id.btn_imagenes);

        db = new DatabaseHelper(this);


        seleccionarImagen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(IncluirRSS.this, imagenes.class);
                startActivity(in);
            }
        });
        guardarRSS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String nombre = introducirNombreRSS.getText().toString();
                String url = introducirRSS.getText().toString();
                String descripcion = introducirDescripcionRSS.getText().toString();
                int imagen = getIntent().getIntExtra("imagen", 0);

                if(db.insertData(nombre, url, descripcion, imagen) == true ) {
                    Toast.makeText(IncluirRSS.this, "DATA INTRODUCIDA", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(IncluirRSS.this, GestorRSS.class);
                    startActivity(i);
                } else {
                    Toast.makeText(IncluirRSS.this, "DATA NO INTRODUCIDA", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


}