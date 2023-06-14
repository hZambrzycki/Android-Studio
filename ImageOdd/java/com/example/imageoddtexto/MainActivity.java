package com.example.imageoddtexto;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ImageView iv1, iv2, iv3, iv4;
    private int indice;
    private Button btn_send, btn_clue;

    private EditText edt_name;

    private ArrayList<Imagenes> listaImagenes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iv1 = findViewById(R.id.img_1);
        iv2 = findViewById(R.id.img_2);
        iv3 = findViewById(R.id.img_3);
        iv4 = findViewById(R.id.img_4);

        btn_send = findViewById(R.id.btn_send);
        btn_clue = findViewById(R.id.btn_clue);

        edt_name = findViewById(R.id.edt_name);

        listaImagenes = new ArrayList<>();

        edt_name.setEnabled(false);
        btn_clue.setEnabled(false);
        btn_send.setEnabled(false);

        Imagenes i1 = new Imagenes(R.drawable.colt, R.drawable.coltmil,R.drawable.magnum,R.drawable.tipo, 2, "revolver");
        Imagenes i2 = new Imagenes(R.drawable.java, R.drawable.js,R.drawable.csharp, R.drawable.microsoft, 4, "lenguajes");
        Imagenes i3 = new Imagenes(R.drawable.canada, R.drawable.ue,R.drawable.espana, R.drawable.patata, 3, "paises");

        listaImagenes.add(i1);
        listaImagenes.add(i2);
        listaImagenes.add(i3);

        iv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iv1.setImageResource(listaImagenes.get(indice).getImg1());
                comprobar(1);
            }
        });
        iv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iv2.setImageResource(listaImagenes.get(indice).getImg2());
                comprobar(2);
            }
        });
        iv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iv3.setImageResource(listaImagenes.get(indice).getImg3());
                comprobar(3);
            }
        });
        iv4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iv4.setImageResource(listaImagenes.get(indice).getImg4());
                comprobar(4);
            }
        });
        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                comprobarTxT(edt_name.getText().toString());
            }
        });
        btn_clue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Clue.class);
                i.putExtra("respuesta", listaImagenes.get(indice).getResTxT());
                startActivity(i);
                cambiarContenido();
                edt_name.setText("");
                edt_name.setEnabled(false);
                btn_send.setEnabled(false);
                btn_clue.setEnabled(false);
            }
        });

    }
    public void comprobar(int valor) {
        if(valor == listaImagenes.get(indice).getResNum()) {
            edt_name.setEnabled(true);
            btn_send.setEnabled(true);
            Toast.makeText(MainActivity.this, "CORRECTO", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(MainActivity.this, "INCORRECTO", Toast.LENGTH_SHORT).show();
            edt_name.setEnabled(false);
            btn_send.setEnabled(false);

        }
    }
    public void comprobarTxT(String txt) {
        if(txt.equalsIgnoreCase(listaImagenes.get(indice).getResTxT())) {
            btn_clue.setEnabled(true);
        }
    }
    public void cambiarContenido() {
        if(indice < listaImagenes.size()-1) {
            indice++;
            cambiarImagenes();
        } else {
            iv1.setVisibility(View.INVISIBLE);
            iv2.setVisibility(View.INVISIBLE);
            iv3.setVisibility(View.INVISIBLE);
            iv4.setVisibility(View.INVISIBLE);
        }
    }
    public void cambiarImagenes() {
        iv1.setImageResource(listaImagenes.get(indice).getImg1());
        iv2.setImageResource(listaImagenes.get(indice).getImg2());
        iv3.setImageResource(listaImagenes.get(indice).getImg3());
        iv4.setImageResource(listaImagenes.get(indice).getImg4());
    }
}