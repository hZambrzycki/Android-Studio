package com.example.ejbbdd_hz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Portada extends AppCompatActivity {
    private Button btn_jugar;
    private EditText et_nombre;
    private EditText et_password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_portada);

        btn_jugar = findViewById(R.id.bienvenido);
        et_nombre = findViewById(R.id.et_nombre);
        et_password = findViewById(R.id.et_password);

        btn_jugar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent jugar = new Intent(Portada.this, MainActivity.class);
                jugar.putExtra("USUARIO", et_nombre.getText().toString());
                jugar.putExtra("PASSWORD", et_password.getText().toString());
                startActivity(jugar);
            }
        });



    }
}