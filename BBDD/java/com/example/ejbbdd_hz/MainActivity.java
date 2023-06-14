package com.example.ejbbdd_hz;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ImageView iv_imagen;
    private Button bt_opciona;
    private Button bt_opcionb;
    private Button bt_opcionc;
    private TextView tv_textopregunta;
    private int indice;
    private ArrayList<Pregunta> listaPreguntas;
    private MediaPlayer mpAcierto;
    private MediaPlayer mpFallo;

    private TextView cuenta_nombre;
    private TextView cuenta_password;

    private static final String TAG = "QuizActivity";

    private Bundle datos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if (savedInstanceState != null) {

            indice = savedInstanceState.getInt("INDICE");
        } else {
            indice= 0;
        }

        tv_textopregunta = findViewById(R.id.tv_textoPregunta);
        bt_opciona = findViewById(R.id.bt_opciona);
        bt_opcionb = findViewById(R.id.bt_opcionb);
        bt_opcionc = findViewById(R.id.bt_opcionc);
        iv_imagen = findViewById(R.id.iv_imagen);
        cuenta_nombre = findViewById(R.id.tv_nombre);
        cuenta_password = findViewById(R.id.tv_password);



        listaPreguntas = new ArrayList<>();
        Pregunta preg1 = new Pregunta(R.drawable.starbucks, R.string.pregunta1,
                R.string.p1_starbucks, R.string.p1_nestle, R.string.p1_nescafe, 1);
        Pregunta preg2 = new Pregunta(R.drawable.twitter, R.string.pregunta2, R.string.p2_telegram,
                R.string.p2_telegram, R.string.p2_twitter, 3);
        Pregunta preg3 = new Pregunta(R.drawable.amazon, R.string.pregunta3,R.string.p3_ubereats,
                R.string.p3_aliexpres, R.string.p3_amazon, 3);

        listaPreguntas.add(preg1);
        listaPreguntas.add(preg2);
        listaPreguntas.add(preg3);

        actualizarControles();

        bt_opciona.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                comprobarRespuesta(1);

            }
        });

        bt_opcionb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                comprobarRespuesta(2);
            }
        });
        bt_opcionc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                comprobarRespuesta(3);
            }
        });

        iv_imagen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cambiarPregunta1();
            }
        });

        datos = getIntent().getExtras();

        String usuario = datos.getString("USUARIO");
        String password = datos.getString("PASSWORD");

        cuenta_nombre.setText(usuario);
        cuenta_password.setText(password);
    }

    //1. Se para al llegar a la última pregunta
    private void cambiarPregunta1() {

        if (indice < listaPreguntas.size() - 1) {
            indice++;
            actualizarControles();
        } else {
            Toast.makeText(getApplicationContext(),
                    R.string.ultimaPregunta, Toast.LENGTH_LONG).show();
        }


    }

    //2. Se vuelve a la primera pregunta
    private void cambiarPregunta2() {
        if (indice < listaPreguntas.size() - 1) {
            indice++;
        } else {
            indice = 0;
        }
        actualizarControles();

    }

    void comprobarRespuesta(int boton) {
        if (listaPreguntas.get(indice).getResultado() == boton) {
            if(mpAcierto == null) {
                mpAcierto = MediaPlayer.create(MainActivity.this, R.raw.correct);
            }
            mpAcierto.start();


            Toast.makeText(MainActivity.this, R.string.acierto, Toast.LENGTH_LONG).show();
        } else {
            if (mpFallo == null) {
                mpFallo = MediaPlayer.create(MainActivity.this, R.raw.error);
            }
            mpFallo.start();
            Toast.makeText(getApplicationContext(), R.string.fallado, Toast.LENGTH_LONG).show();
        }

        deshabilitarBotones();
    }

    void actualizarControles() {
        tv_textopregunta.setText(listaPreguntas.get(indice).getTexto_pregunta());
        iv_imagen.setImageResource(listaPreguntas.get(indice).getImagen());
        bt_opciona.setText(listaPreguntas.get(indice).getOpcion1());
        bt_opcionb.setText(listaPreguntas.get(indice).getOpcion2());
        bt_opcionc.setText(listaPreguntas.get(indice).getOpcion3());

        habilitarBotones();
    }

    void deshabilitarBotones() {
        bt_opciona.setEnabled(false);
        bt_opcionb.setEnabled(false);
        bt_opcionc.setEnabled(false);
    }

    void habilitarBotones() {
        bt_opciona.setEnabled(true);
        bt_opcionb.setEnabled(true);
        bt_opcionc.setEnabled(true);
    }



    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        // Always call the superclass so it can save the view hierarchy state
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt("INDICE", indice);


    }
}