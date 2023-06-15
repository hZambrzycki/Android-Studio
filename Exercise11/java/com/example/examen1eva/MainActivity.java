package com.example.examen1eva;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button bt_ayuda;
    private ArrayList<Palabra> listaPalabras;
    private Random rd;
    private int indice =0;
    private int intentos;
    private String secreto=""; //Palabra que hay que adivinar oculta con guiones
    private String palabra=""; // Palabra que hay que adivinar
    private TextView tv_adivina;
    private ImageView iv_foto;
    private MediaPlayer mpAcierto;
    private MediaPlayer mpFallo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt_ayuda = findViewById(R.id.bt_ayuda);
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
        reset();

        mpAcierto = MediaPlayer.create(MainActivity.this, R.raw.correct);
        mpFallo = MediaPlayer.create(MainActivity.this, R.raw.error);


        bt_ayuda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri webpage = Uri.parse("https://es.wikipedia.org/wiki/Ahorcado");
                Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
                startActivity(intent);

            }
        });

    }

    //El método al que acceden todos los botones
    public void onClick(View view) {
        Button boton = (Button) view;
        //Leemos la letra
        char letra = boton.getText().toString().charAt(0);

        //Actualizamos la letra en la palabra con guiones
        char [] arraySecreto = secreto.toCharArray();
        boolean encontrado = false;
        for (int i=0; i< palabra.length(); i++) {
            if (palabra.charAt(i) == letra) {
                arraySecreto[2*i] = letra;
                encontrado=true;
            }
        }
        secreto = String.valueOf(arraySecreto);
        tv_adivina.setText(secreto);

        if (!encontrado) {
            mpFallo.start();
            Toast.makeText(MainActivity.this, R.string.letraIncorrecta,
                    Toast.LENGTH_SHORT).show();
            intentos --;
            //Si intentos es igual a 0-> Hemos perdido y enviamos la información
            //a otra actividad llamada resultado
            if (intentos == 0) {
                mostrarResultado();
            }
        }
        else {
            mpAcierto.start();
            //Si hemos adivinado la palabra -> Mandamos la información a una actividad
            // que se llama resultado
            if (adivinada()) {
                mostrarResultado();
            }
        }

    }

    //Inicializar la palabra con la que se va a trabajar
    private void reset() {
        indice = rd.nextInt(listaPalabras.size());
        Palabra p = listaPalabras.get(indice);
        //Obtenemos la palabra que hay que adivinar
        palabra = getString(p.getPalabra()).toUpperCase();
        secreto="";
        // Rellenamos con guiones la palabra oculta
        for (int i=0; i<palabra.length(); i++) {
            secreto = secreto + "_ ";
        }
        intentos = 6;
        //Colocamos la imagen y la palabra encriptada con guiones en la interfaz
        tv_adivina.setText(secreto);
        iv_foto.setImageResource(p.getImagen());
    }

    private void mostrarResultado() {
        Intent i = new Intent(MainActivity.this, Resultado.class);
        i.putExtra("INTENTOS", intentos);
        startActivity(i);
        reset();
        
    }
    //Comprueba si se ha adivinado la palabra
    private boolean adivinada() {
        for (int i=0; i<palabra.length(); i++) {
            if (palabra.charAt(i) != secreto.charAt(2*i)) {
                return false;
            }
        }
        return true;
    }
}