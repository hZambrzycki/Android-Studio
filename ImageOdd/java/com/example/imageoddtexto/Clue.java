package com.example.imageoddtexto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class Clue extends AppCompatActivity {
    private TextView et_clue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clue);
     et_clue = findViewById(R.id.clue);
        String respuesta = getIntent().getStringExtra("respuesta");

        switch (respuesta) {
            case "revolver":
                et_clue.setText("revolver");
                Toast.makeText(getApplicationContext(), "REVOLVER", Toast.LENGTH_SHORT).show();
        break;
            case "lenguajes":
                et_clue.setText("lenguajes");
                break;
            case "paises":
                et_clue.setText("paises");
                break;
        }
    }

}