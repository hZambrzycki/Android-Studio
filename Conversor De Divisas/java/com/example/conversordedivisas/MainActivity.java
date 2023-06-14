package com.example.conversordedivisas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //  Declarar los controles (vistas) con los que va a trabajar la aplicacion.
    private Button btn_JPY;
    private Button btn_USD;
    private Button btn_GBT;
    private EditText et_euros;
    private TextView tv_resultado;


    //Constantes
    private final double EUROS_LIBRAS = 0.86;
    private final double EUROS_YENES = 128.5;
    private final double EUROS_DOLAR = 1.17;
    //El método onCreate se llama cuando se crea la actividad.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //La primera sentencia llama al onCreate de la clase padre
        super.onCreate(savedInstanceState);
        //setContentView infla un layout. Que significa que crea todos los objetos
        // del activitymain.xml
        setContentView(R.layout.activity_main);

        //Se enlaza el objeto que hemos declarado con el especificado en el activity_main.xml
        //e inflado en el setContentView.
        btn_USD = findViewById(R.id.btn_USD);
        btn_JPY = findViewById(R.id.btn_JPY);
        btn_GBT = findViewById(R.id.btn_GBP);
        et_euros = findViewById(R.id.et_euros);
        tv_resultado = findViewById(R.id.tv_resultado);

        //Escuchadores y manejadores de eventos.

        btn_GBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Que vamos a hacer cuando se produzca un click de raton
              double euros = Double.parseDouble(et_euros.getText().toString());
            }
        });
    }
}