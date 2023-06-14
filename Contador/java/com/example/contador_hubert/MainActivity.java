package com.example.contador_hubert;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    int contador;
    private Button resta;
    private Button suma;
    private Button reset;
    private TextView tv_Vista;
    private TextView fecha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        contador = 0;
        setContentView(R.layout.activity_main);

        resta = findViewById(R.id.boton_Restar);

        resta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contador--;
                tv_Vista.setText(Integer.toString(contador));
            }
        });
        suma = findViewById(R.id.botonSumar);

        suma.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        contador++;
                                        tv_Vista.setText(Integer.toString(contador));
                                    }
                                }
        );
        reset = findViewById(R.id.boton_Reset);

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contador = 0;
                tv_Vista.setText(Integer.toString(contador));
            }
        });
        tv_Vista = findViewById(R.id.tv_Vista);

        tv_Vista.setText(Integer.toString(contador));
        //tv_Vista.setText(contador+ "");

        fecha = findViewById(R.id.fecha);
        setDate(fecha);



    }

   public void setDate(TextView view) {
       Date today = Calendar.getInstance().getTime();
       SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
       String date = formatter.format(today);
       view.setText(date);
   }
}