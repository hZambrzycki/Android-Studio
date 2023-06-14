package com.example.animalpictures;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ImageView img1;
    ImageView img2;
    ImageView img3;
    ImageView img4;

    int valorImg1;
    int valorImg2;
    int valorImg3;
    int valorImg4;

    int vecesComprobar=0;
    int vecesMas=0;

    Button btn_comprobar;
    Button btn_mas;

    ArrayList<Animal> listaAnimales;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img1=findViewById(R.id.img1);
        img2=findViewById(R.id.img2);
        img3=findViewById(R.id.img3);
        img4=findViewById(R.id.img4);

        btn_comprobar=findViewById(R.id.btn_comprobar);
        btn_mas=findViewById(R.id.btn_mas);

        btn_mas.setEnabled(false);

        listaAnimales = new ArrayList<>();

        Animal a1= new Animal(R.drawable.cerdo1,R.drawable.cerdo2,R.drawable.cerdo3,R.drawable.cerdo4,R.string.dCerdo,0);
        Animal a2= new Animal(R.drawable.gatitos1,R.drawable.gatitos2,R.drawable.gatitos3,R.drawable.gatitos4,R.string.dGato,1);
        Animal a3= new Animal(R.drawable.tigre1,R.drawable.tigre2,R.drawable.tigre3,R.drawable.tigre4,R.string.dTigre,2);
        Animal a4 =new Animal(R.drawable.perro1,R.drawable.perro2,R.drawable.perro3,R.drawable.perro4,R.string.dPErro,3);

        listaAnimales.add(a1);
        listaAnimales.add(a2);
        listaAnimales.add(a3);
        listaAnimales.add(a4);

        valorImg1=1;
        valorImg2=2;
        valorImg3=3;
        valorImg4=0;

        img1.setImageResource(R.drawable.gatitos1);
        img2.setImageResource(R.drawable.tigre2);
        img3.setImageResource(R.drawable.perro3);
        img4.setImageResource(R.drawable.cerdo4);

        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (valorImg1==3){
                    valorImg1=0;
                } else {
                    valorImg1++;
                }
                img1.setImageResource(listaAnimales.get(valorImg1).getImg1());
            }
        });
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (valorImg2==3){
                    valorImg2=0;
                } else {
                    valorImg2++;
                }
                img2.setImageResource(listaAnimales.get(valorImg2).getImg2());
            }
        });
        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (valorImg3==3){
                    valorImg3=0;
                } else {
                    valorImg3++;
                }
                img3.setImageResource(listaAnimales.get(valorImg3).getImg3());
            }
        });
        img4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (valorImg4==3){
                    valorImg4=0;
                } else {
                    valorImg4++;
                }
                img4.setImageResource(listaAnimales.get(valorImg4).getImg4());
            }
        });
        btn_comprobar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vecesComprobar++;
                if (comprobar()){
                    Toast.makeText(getApplicationContext(),listaAnimales.get(valorImg1).getMensajeAcertado(),Toast.LENGTH_LONG).show();
                    habilitarBotonMas();
                } else{
                    Toast.makeText(getApplicationContext(),R.string.otraVez,Toast.LENGTH_LONG).show();
                    desHabilitarBotonMas();
                }
            }
        });
        btn_mas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vecesMas++;
                desHabilitarBotonMas();
                Intent i1=new Intent(getApplicationContext(),SaberMas.class);
                i1.putExtra("descripcion",listaAnimales.get(valorImg1).getValor());
                startActivity(i1);
            }
        });
    }
    private void desHabilitarBotonMas() {
        btn_mas.setEnabled(false);
    }
    private void habilitarBotonMas() {
        btn_mas.setEnabled(true);
    }
    private boolean comprobar (){
        if (valorImg1==valorImg2&&valorImg1==valorImg3&&valorImg1==valorImg4){
            return true;
        } else{
            return false;
        }
    }
}