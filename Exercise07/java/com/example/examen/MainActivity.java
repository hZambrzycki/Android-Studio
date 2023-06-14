package com.example.examen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ImageView iv1;

    private int puntos=0;

    private Button puntuacion;

    private Button opcion_A,opcion_B,opcion_C;

    private ArrayList<Grupo> listaGrupos;

    private int indice;

    private ImageView ivNext, ivAnterior;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Grupo g1 = new Grupo(R.drawable.borntorun, R.string.john,R.string.bruce,R.string.charlie,2);
        Grupo g2 = new Grupo(R.drawable.darksideofthemoon, R.string.pink, R.string.kiss,R.string.abba,3);
        Grupo g3 = new Grupo(R.drawable.nevermind, R.string.offspring,R.string.foo,R.string.nirvana , 1);

        listaGrupos = new ArrayList<>();

        listaGrupos.add(g1);
        listaGrupos.add(g2);
        listaGrupos.add(g3);

        opcion_A = findViewById(R.id.opcion_a);
        opcion_B = findViewById(R.id.opcion_b);
        opcion_C = findViewById(R.id.opcion_c);

        iv1 = findViewById(R.id.iv1);

        establecerRecursos();

        ivNext = findViewById(R.id.iv_Siguiente);
        ivAnterior = findViewById(R.id.iv_Anterior);

        opcion_A.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Comprobar(1);
            }
        });
        opcion_B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Comprobar(2);
            }
        });
        opcion_C.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Comprobar(3);
            }
        });
        ivNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cambiarRecursosSiguiente();
            }
        });
        ivAnterior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reducirRecursos();
            }
        });
        puntuacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Puntos.class);
                i.putExtra("PUNTOS", puntos);
                startActivity(i);
            }
        });
    }
    private void cambiarRecursosSiguiente() {
        if(indice < listaGrupos.size()-1) {
            indice++;
            establecerRecursos();
        }
        if(indice == listaGrupos.size()-1) {
            Toast.makeText(this, R.string.last, Toast.LENGTH_SHORT).show();
            indice = indice -3 ;
        }

    }
    private void reducirRecursos() {
        indice--;
        if(indice > listaGrupos.size()-1 || indice < 0) {
            indice= 0;
        }
        establecerRecursos();
    }
    private void Comprobar(int valorImg) {
        if(valorImg == listaGrupos.get(indice).getOpcionCorrecta()) {
            Toast.makeText(this, R.string.correcta, Toast.LENGTH_SHORT).show();
            puntos = +10;
        } else {
            Toast.makeText(this, R.string.incorrecta, Toast.LENGTH_SHORT).show();
            puntos = -5;
        }
    }

    private void establecerRecursos() {
        iv1.setImageResource(listaGrupos.get(indice).getImagen());
        opcion_A.setText(listaGrupos.get(indice).getOpcion1());
        opcion_B.setText(listaGrupos.get(indice).getOpcion2());
        opcion_C.setText(listaGrupos.get(indice).getOpcion3());
    }
}