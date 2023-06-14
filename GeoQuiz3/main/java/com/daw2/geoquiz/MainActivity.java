package com.daw2.geoquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
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

    private static final String TAG = "QuizActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if (savedInstanceState != null) {
            // Restore value of members from saved state
            indice = savedInstanceState.getInt("INDICE");
        } else {
            // Probably initialize members with default values for a new instance
            indice= 0;
        }

        //Toast.makeText(MainActivity.this, "onCreate() called" , Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onCreate() called");

        tv_textopregunta = findViewById(R.id.tv_textoPregunta);
        bt_opciona = findViewById(R.id.bt_opciona);
        bt_opcionb = findViewById(R.id.bt_opcionb);
        bt_opcionc = findViewById(R.id.bt_opcionc);
        iv_imagen = findViewById(R.id.iv_imagen);

        mpAcierto = MediaPlayer.create(MainActivity.this, R.raw.correct);
        mpFallo = MediaPlayer.create(MainActivity.this, R.raw.error);

        listaPreguntas = new ArrayList<>();
        Pregunta preg1 = new Pregunta(R.drawable.madrid, R.string.pregunta1,
                R.string.p1_madrid, R.string.p1_londres, R.string.p1_paris, 1);
        Pregunta preg2 = new Pregunta(R.drawable.tamesis, R.string.pregunta2, R.string.p2_manzanares,
                R.string.p2_sena, R.string.p2_tamesis, 3);
        Pregunta preg3 = new Pregunta(R.drawable.kilimanjaro, R.string.pregunta3, R.string.p3_everest,
                R.string.p3_teide, R.string.p3_kilimanjaro, 3);

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
            mpAcierto.start();
            Toast.makeText(MainActivity.this, R.string.acierto, Toast.LENGTH_LONG).show();
        } else {
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


    protected void onStart() {
        super.onStart();
        //Toast.makeText(MainActivity.this, "onStart() called", Toast.LENGTH_SHORT).show();
        Log.d(TAG,  "onStart() called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        //Toast.makeText(MainActivity.this, "onPause() called", Toast.LENGTH_SHORT).show();
        Log.d(TAG,  "onPause() called");

    }

    @Override
    protected void onResume() {
        super.onResume();
        //Toast.makeText(MainActivity.this, "onResume() called", Toast.LENGTH_SHORT).show();
        Log.d(TAG,  "onResume() called");

    }

    @Override
    protected void onStop() {
        super.onStop();
        //Toast.makeText(MainActivity.this, "onStop() called", Toast.LENGTH_SHORT).show();
        Log.d(TAG,  "onStop() called");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //Toast.makeText(MainActivity.this, "onDestroy() called", Toast.LENGTH_SHORT).show();
        Log.d(TAG,  "onDestroy() called");
    }
}
