package com.example.examenhubertzambrzycki;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Resultado extends AppCompatActivity {
private TextView tv_resultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);
        tv_resultado = findViewById(R.id.tv_resultado);

        tv_resultado.setText(getIntent().getIntExtra("MENSAJE",0));
       // tv_resultado.setText(getIntent().getStringExtra("MENSAJE"));;

        //int intentos = getIntent.getIntExtra("intentos",0);
        //if(intentos<=0) {
        //tv_resultado.setText(getString(R.string.loSiento) + "" + intentos + getString(R.string.intentos);
        //else {
        // tv.setText(getString(R.string.enhorabuena) + "" + (6-intentos) + "" + getString(R.string.intentos);
        //}
    }
}