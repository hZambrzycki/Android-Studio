package com.example.preferencias;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText et_nombre;
    private EditText et_email;
    private EditText et_pedido;
    private Button btn_guardar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_nombre = findViewById(R.id.edt_nombre);
        et_email = findViewById(R.id.edt_email);
        et_pedido = findViewById(R.id.edt_pedido);

        btn_guardar = findViewById(R.id.btn_guardar);


        btn_guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,Preferencias.class);
                guardarPreferencias();
                startActivity(i);
            }
        });
    }

    private void guardarPreferencias(){
        SharedPreferences preferences = getSharedPreferences("datos", Context.MODE_PRIVATE);

        String nombre = et_nombre.getText().toString();
        String email = et_email.getText().toString();
        String pedido = et_pedido.getText().toString();


        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("nombre",nombre);
        editor.putString("email",email);
        editor.putString("pedido",pedido);
        editor.commit();

        Toast.makeText(MainActivity.this, "DATOS GUARDADOS CORRECTAMENTE", Toast.LENGTH_SHORT).show();

    }
}