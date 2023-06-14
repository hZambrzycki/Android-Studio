package com.example.imageodd4;

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
    private ImageView img_1;
    private ImageView img_2;
    private ImageView img_3;
    private ImageView img_4;

    private Button btn_send;
    private Button btn_clue;

    private EditText edt_name;


    private ArrayList<Imagenes> listImgs;

    private int indice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img_1 = findViewById(R.id.img_1);
        img_2 = findViewById(R.id.img_2);
        img_3 = findViewById(R.id.img_3);
        img_4 = findViewById(R.id.img_4);

        btn_clue = findViewById(R.id.btn_clue);
        btn_send = findViewById(R.id.btn_send);

        edt_name = findViewById(R.id.edt_name);

        listImgs = new ArrayList<>();

        Imagenes img1 = new Imagenes(R.drawable.colt,R.drawable.coltmil,R.drawable.magnum,R.drawable.tipo,2,"revolver",1);
        Imagenes img2 = new Imagenes(R.drawable.csharp,R.drawable.js,R.drawable.java,R.drawable.microsoft,4,"lenguajes",2);
        Imagenes img3 = new Imagenes(R.drawable.patata,R.drawable.canada,R.drawable.espana,R.drawable.ue,1,"paises",3);


        listImgs.add(img1);
        listImgs.add(img2);
        listImgs.add(img3);


        unableThings();
        ponerImagenes();

        img_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkImg(1);
            }
        });

        img_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkImg(2);
            }
        });

        img_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkImg(3);
            }
        });

        img_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkImg(4);
            }
        });
        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkTxt(edt_name.getText().toString());
            }
        });
        btn_clue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,Clue.class);
                i.putExtra("DESCRIPCION",listImgs.get(indice).getValor());
                startActivity(i);
            }
        });

    }

    private void checkTxt(String txt){
        if(txt.equalsIgnoreCase(listImgs.get(indice).getResTxt())){
            cambiarPregunta();
            Toast.makeText(MainActivity.this, "CORRECTO!!!!", Toast.LENGTH_SHORT).show();
            btn_clue.setEnabled(true);
        }else{
            Toast.makeText(MainActivity.this, "MAL!!!!", Toast.LENGTH_SHORT).show();
            btn_clue.setEnabled(false);
        }
    }

    private void cambiarPregunta(){
        if(indice < listImgs.size()-1){
            indice++;
            ponerImagenes();
            //VIGILA EL ESPACIO DE ABAJO, DEBIDO A QUE _ PALABRA NO FUNCIONA.
            edt_name.setText("");
            unableThings();
            enableImgs();
            btn_clue.setEnabled(false);
        }else{
            Toast.makeText(MainActivity.this, "NO MORE QUESTIONS", Toast.LENGTH_SHORT).show();
        }
    }

    private void ponerImagenes(){
        img_1.setImageResource(listImgs.get(indice).getImg1());
        img_2.setImageResource(listImgs.get(indice).getImg2());
        img_3.setImageResource(listImgs.get(indice).getImg3());
        img_4.setImageResource(listImgs.get(indice).getImg4());
    }

    private void checkImg(int resp){
        if(resp == listImgs.get(indice).getResNum()){
            Toast.makeText(MainActivity.this, "CORRECTO, AHORA ESCRIBE", Toast.LENGTH_SHORT).show();
            unableImgs();
            enableThings();
        }else{
            Toast.makeText(MainActivity.this, "MAL. . .", Toast.LENGTH_SHORT).show();
        }
    }
    private void enableThings(){
        edt_name.setEnabled(true);
        btn_send.setEnabled(true);
    }

    private void unableThings(){
        edt_name.setEnabled(false);
        btn_send.setEnabled(false);
    }

    private void unableImgs(){
        img_1.setEnabled(false);
        img_2.setEnabled(false);
        img_3.setEnabled(false);
        img_4.setEnabled(false);
    }
    private void enableImgs(){
        img_1.setEnabled(true);
        img_2.setEnabled(true);
        img_3.setEnabled(true);
        img_4.setEnabled(true);
    }
}