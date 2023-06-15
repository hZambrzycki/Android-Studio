package com.example.examen1eva;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Resultado extends AppCompatActivity {

    private TextView tv_resultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        tv_resultado = (TextView) findViewById(R.id.tv_resultado);

        int intentos = getIntent().getIntExtra("INTENTOS",0);
        if (intentos <= 0) {
            tv_resultado.setText(R.string.loSiento);
        }
        else {
            tv_resultado.setText(getString(R.string.enhorabuena) +
                    " " + (6 -intentos) + " " + getString(R.string.intentos));
        }
    }
}