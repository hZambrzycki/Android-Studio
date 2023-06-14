package com.example.preferencias_hz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class Preferencias extends AppCompatActivity {
    private TextView tv_nombre;
    private TextView tv_email;
    private TextView tv_pedido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferencias);

        tv_nombre = findViewById(R.id.tv_name);
        tv_email = findViewById(R.id.tv_mail);
        tv_pedido = findViewById(R.id.tv_country);
        cargarPreferencias();

    }
    private void cargarPreferencias() {
        SharedPreferences preferences = getSharedPreferences("datos", Context.MODE_PRIVATE);

        String nombre = preferences.getString("nombre","NO EXISTE");
        String email = preferences.getString("email","NO EXISTE");
        String pedido = preferences.getString("pedido","NO EXISTE");

        tv_nombre.setText(nombre);
        tv_email.setText(email);
        tv_pedido.setText(pedido);

    }
}