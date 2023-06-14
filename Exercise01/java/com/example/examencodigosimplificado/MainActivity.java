package com.example.examencodigosimplificado;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private Button btnAyuda;

    private TextView tv_adivina;
    private ImageView iv_foto;

    private ArrayList<Palabra> listaPalabras;
    private Random rd;
    private int indice = 0;
    private int intentos;

    private String palabra = "";
    private String secreto = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnAyuda = findViewById(R.id.bt_ayuda);
        tv_adivina = findViewById(R.id.tv_adivina);
        iv_foto = findViewById(R.id.iv_foto);

        listaPalabras = new ArrayList<>();
        listaPalabras.add(new Palabra(R.string.alegria, R.drawable.alegria));
        listaPalabras.add(new Palabra(R.string.comer, R.drawable.comer));
        listaPalabras.add(new Palabra(R.string.dormir, R.drawable.dormir));
        listaPalabras.add(new Palabra(R.string.amistad, R.drawable.amistad));
        listaPalabras.add(new Palabra(R.string.jugar, R.drawable.jugar));
        listaPalabras.add(new Palabra(R.string.amor, R.drawable.amor));

        rd = new Random();

        codificar();
    }

    private void codificar() {
        indice = rd.nextInt(listaPalabras.size());

        Palabra p = listaPalabras.get(indice);

        palabra = getString(p.getPalabra()).toUpperCase();
        secreto = "";

        for (int i = 0; i < palabra.length(); i++) {
            secreto = secreto + "_ ";
        }
        intentos = 6;
        tv_adivina.setText(secreto);
        iv_foto.setImageResource(p.getImagen());
    }

    public void onClick(View view) {
        Button boton = (Button) view;

        char letra = boton.getText().toString().charAt(0);

        char [] arraySecreto = secreto.toCharArray();

        boolean encontrado = false;

        for (int i = 0; i < palabra.length(); i++) {
            if(palabra.charAt(i) == letra) {
                arraySecreto[2*i] = letra;
                encontrado = true;
            }
        }
        secreto = String.valueOf(arraySecreto);
        tv_adivina.setText(secreto);
        if (!encontrado) {
            intentos--;
            if(intentos == 0) {
                Toast.makeText(getApplicationContext(), "SIN INTENTOS", Toast.LENGTH_SHORT).show();
            }
        } else {
             if(adivinada()) {
                 Toast.makeText(MainActivity.this, "adivinada", Toast.LENGTH_SHORT).show();
             }
        }

    }
    private boolean adivinada() {
        for (int i=0; i<palabra.length(); i++) {
            if (palabra.charAt(i) != secreto.charAt(2*i)) {
                return false;
            }
        }
        return true;
    }
}