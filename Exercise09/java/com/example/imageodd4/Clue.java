package com.example.imageodd4;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Clue extends AppCompatActivity {

    private TextView tv_clue;
    private int descripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clue);

        tv_clue = findViewById(R.id.tv_clue);

        descripcion = getIntent().getIntExtra("DESCRIPCION",0);

        switch (descripcion){
            case 1:
                tv_clue.setText(R.string.revolver);

                break;

            case 2:
                tv_clue.setText(R.string.programacion);

                break;

            case 3:
                tv_clue.setText(R.string.paises);

                break;
        }

    }
}