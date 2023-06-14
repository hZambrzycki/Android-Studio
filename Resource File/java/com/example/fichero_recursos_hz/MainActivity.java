package com.example.fichero_recursos_hz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextView tv_nombre;
    private TextView tv_apellido;
    private TextView tv_pedido;
    private Context context = MainActivity.this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_nombre = findViewById(R.id.tv2);
        tv_apellido = findViewById(R.id.tv3);
        tv_pedido = findViewById(R.id.tv1);

        ArrayList<String> datos = new ArrayList();
        try {
            InputStream f = context.getResources().openRawResource(R.raw.datos);
            BufferedReader br = new BufferedReader(new InputStreamReader(f));
            String linea = br.readLine();
            while (linea != null) {
                datos.add(linea);
                linea = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        tv_nombre.append(" " + datos.get(0));
        tv_apellido.append(" " + datos.get(1));
        tv_pedido.append(" " + datos.get(2));
    }

}