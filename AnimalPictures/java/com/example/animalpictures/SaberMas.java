package com.example.animalpictures;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class SaberMas extends AppCompatActivity {

    TextView tv_descrpcion;
    int descripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saber_mas);

        tv_descrpcion=findViewById(R.id.tv_descripccion);

        descripcion=getIntent().getIntExtra("descripcion",1);
        Log.e("caso:",""+descripcion);

        switch (descripcion){
            case 0:
                tv_descrpcion.setText(R.string.dCerdo);
                break;
            case 1:
                tv_descrpcion.setText(R.string.dGato);
                break;
            case 2:
                tv_descrpcion.setText(R.string.dTigre);
                break;
            case 3:
                tv_descrpcion.setText(R.string.dPErro);
                break;



        }
    }}