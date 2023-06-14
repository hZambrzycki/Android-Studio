package com.example.examenhubertzambrzycki;

import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.ActionProvider;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.net.URI;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z;

    private ImageView imagen;

    private Button ayuda;

    private TextView palabra;

    private Drawable alegria;
    private Drawable amistad;
    private Drawable amor;
    private Drawable comer;
    private Drawable dormir;
    private Drawable jugar;

    private ArrayList<Palabra> listaPalabras;
    private Random rd;
    private int indice = 0;
    private int intentos;

    private MediaPlayer mpAcierto;
    private MediaPlayer mpFallo;

    //palabra con guiones
    private String secreto = "";

    //palabra para adivinar
    private String palabraReal = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imagen = findViewById(R.id.iv_foto);

        palabra = findViewById(R.id.tv_adivina);

        ayuda = findViewById(R.id.bt_ayuda);


        listaPalabras = new ArrayList<>();

        listaPalabras.add(new Palabra(R.string.alegria, R.drawable.alegria));
        listaPalabras.add(new Palabra(R.string.comer, R.drawable.comer));
        listaPalabras.add(new Palabra(R.string.dormir, R.drawable.dormir));
        listaPalabras.add(new Palabra(R.string.amistad, R.drawable.amistad));
        listaPalabras.add(new Palabra(R.string.jugar, R.drawable.jugar));
        listaPalabras.add(new Palabra(R.string.amor, R.drawable.amor));

        rd = new Random();


        reset();

    //    mpAcierto = MediaPlayer.create(MainActivity.this, R.raw.correct);
    //    mpFallo = MediaPlayer.create(MainActivity.this, R.raw.error);


        //letras
        a = findViewById(R.id.a);
        b = findViewById(R.id.b);
        c = findViewById(R.id.c);
        d = findViewById(R.id.d);
        e = findViewById(R.id.e);
        f = findViewById(R.id.f);
        g = findViewById(R.id.g);
        h = findViewById(R.id.h);
        i = findViewById(R.id.i);
        j = findViewById(R.id.j);
        k = findViewById(R.id.k);
        l = findViewById(R.id.l);
        m = findViewById(R.id.m);
        n = findViewById(R.id.n);
        o = findViewById(R.id.o);
        p = findViewById(R.id.p);
        q = findViewById(R.id.q);
        r = findViewById(R.id.r);
        s = findViewById(R.id.s);
        t = findViewById(R.id.t);
        u = findViewById(R.id.u);
        v = findViewById(R.id.v);
        w = findViewById(R.id.w);
        x = findViewById(R.id.x);
        y = findViewById(R.id.y);
        z = findViewById(R.id.z);

        //imagenes

        comer = getResources().getDrawable(R.drawable.comer);
        alegria = getResources().getDrawable(R.drawable.alegria);
        amistad = getResources().getDrawable(R.drawable.amistad);
        amor = getResources().getDrawable(R.drawable.amor);
        dormir = getResources().getDrawable(R.drawable.dormir);
        jugar = getResources().getDrawable(R.drawable.jugar);

        ayuda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                openWebPage("https://es.wikipedia.org/wiki/Ahorcado");

            }
        });

    }
    public void openWebPage(String url) {
        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
            startActivity(intent);

    }
    //El metodo por el cual entran todos los botones.
    public void onClick(View view) {
        Button button = (Button) view;

        //String letra = button.getText().toString();

        //Leemos la letra
        char letra = button.getText().toString().charAt(0);

        //Actualizamos le letra en la palabracon guiones

        char[] arraySecreto = secreto.toCharArray();

        boolean encontrado = false;
        for (int i = 0; i < palabraReal.length(); i++) {
            if (palabraReal.charAt(i) == letra) {
                //Debido a la letra y el espacio
                arraySecreto[2 * i] = letra;
                encontrado = true;
            }
        }
        secreto = String.valueOf(arraySecreto);
        palabra.setText(secreto);

        if (!encontrado) {
          //  mpFallo.start();
            Toast.makeText(MainActivity.this, R.string.letraIncorrecta,
                    Toast.LENGTH_LONG).show();
            intentos--;
            //Si intentos es igual a 0 > hemos perdido y enviamos la info a una actividad externa llamada resultao
            if (intentos == 0) {
                mostrarResultado(R.string.loSiento);
            }
        } else {
          //  mpAcierto.start();
            //Si hemos adivinado la palabra entonces Mandamos la informacion a otra actividad que se llame resultao
            if (adivinada()) {
                mostrarResultado(R.string.enhorabuena);
            }


        }
    }
     ///Inicializar la palabra con la que se va a trabajar
    private void reset() {
        //desde el 0 hasta el tamaño de la lista.
        indice = rd.nextInt(listaPalabras.size());

        Palabra pa = listaPalabras.get(indice);

        //palabra a adivinar;
        palabraReal = getResources().getString(pa.getPalabra()).toUpperCase();
        secreto = "";

        //Rellenamos con guiones

        for(int i = 0; i < palabraReal.length(); i++) {
            //if(palabraReal.charAt(i))
            secreto = secreto + "_ ";

        }
        //Colocamos la imagen y la palabra
        palabra.setText(secreto);
        imagen.setImageResource(pa.getImagen());
        intentos = 6;
    }

    private void mostrarResultado(int mensaje) {
          Intent i = new Intent(MainActivity.this, Resultado.class);
          i.putExtra("MENSAJE",mensaje);
          //i.putExtra("intentos", intentos);
          startActivity(i);
          reset();
    }
    //Comprueba si se ha adivinado la palabra.
    private boolean adivinada() {
        for(int i=0; i < palabraReal.length(); i++) {
            if(palabraReal.charAt(i) !=  secreto.charAt(2*i)) {
                return false;
            }
        }
        return true;
    }
}