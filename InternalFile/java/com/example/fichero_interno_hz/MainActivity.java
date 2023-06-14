package com.example.fichero_interno_hz;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {
    private EditText edt_bitacora;
    private Button btn_guardar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt_bitacora = findViewById(R.id.et_texto);
        btn_guardar = findViewById(R.id.btn_guardar);

        String files [] = fileList();

        btn_guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Guardar();
            }
        });

        if(Existe(files,"datos.txt")){
            try {
                InputStreamReader arch = new InputStreamReader(openFileInput("datos.txt"));
                BufferedReader leerArch = new BufferedReader(arch);
                String lineaDeTexto = leerArch.readLine();
                String textoPlano= "";

                while(lineaDeTexto!=null){
                    textoPlano += lineaDeTexto+"\n";
                    lineaDeTexto = leerArch.readLine();
                }
                leerArch.close();
                arch.close();
                edt_bitacora.setText(textoPlano);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    private boolean Existe(String[] files, String nFile) {
        for (int i = 0; i < files.length; i++){
            if(nFile.equals(files[i])){
                return true;
            }
        }
        return false;
    }
    public void Guardar() {
        try {
            OutputStreamWriter archEscrito = new OutputStreamWriter(openFileOutput("datos.txt", Activity.MODE_PRIVATE));
            archEscrito.write(edt_bitacora.getText().toString());
            archEscrito.flush();
            archEscrito.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Toast.makeText(MainActivity.this, "DATOS GUARDADOS CORRECTAMENTE", Toast.LENGTH_SHORT).show();

    }

}