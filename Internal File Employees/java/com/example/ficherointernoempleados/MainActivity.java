package com.example.ficherointernoempleados;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private EditText edt_Id,edt_NyA,edt_Telefono,edt_Correo;
    private RadioButton rbtn_infor,rbtn_Venta,rbtn_RH;
    private RadioGroup rd_grp;
    private CheckBox chk_Responsable;
    private Button btn_Insertar, btn_Borrar, btn_Actualizar;

    private ArrayList<String>datos = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt_Id = findViewById(R.id.edt_Id);
        edt_NyA = findViewById(R.id.edt_NyA);
        edt_Telefono = findViewById(R.id.edt_Telefono);
        edt_Correo = findViewById(R.id.edt_Correo);

        rd_grp = findViewById(R.id.rd_grp);
        rbtn_infor = findViewById(R.id.rbtn_Infor);
        rbtn_Venta = findViewById(R.id.rbtn_Venta);
        rbtn_RH = findViewById(R.id.rbtn_RH);

        btn_Insertar = findViewById(R.id.btn_Insertar);
        btn_Actualizar = findViewById(R.id.btn_Actualizar);
        chk_Responsable = findViewById(R.id.chk_Responsable);



        btn_Insertar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                guardar();
            }
        });

        btn_Actualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                leer();
            }
        });
    }


    private void leer(){
        try {
            InputStreamReader leer = new InputStreamReader(openFileInput("empleados.txt"));
            BufferedReader bf = new BufferedReader(leer);
            String linea = bf.readLine();
            while (linea!=null){
                datos.add(linea);
                linea = bf.readLine();
            }

            edt_Id.setText(datos.get(0));
            edt_NyA.setText(datos.get(1));
            edt_Telefono.setText(datos.get(2));
            edt_Correo.setText(datos.get(3));

            switch(datos.get(4)){
                case "Dpto Infor":
                    rbtn_infor.setChecked(true);
                    break;
                case "Dpto Venta":
                    rbtn_Venta.setChecked(true);
                    break;
                case "Dpto RH":
                    rbtn_RH.setChecked(true);
                    break;
            }
            if(datos.get(5).equalsIgnoreCase("true")){
                chk_Responsable.setChecked(true);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void guardar(){
        try{
            OutputStreamWriter escribir = new OutputStreamWriter(openFileOutput("empleados.txt", Activity.MODE_PRIVATE));
            escribir.write(edt_Id.getText().toString()+"\n");
            escribir.write(edt_NyA.getText().toString()+"\n");
            escribir.write(edt_Telefono.getText().toString()+"\n");
            escribir.write(edt_Correo.getText().toString()+"\n");



            switch(rd_grp.getCheckedRadioButtonId()){
                case R.id.rbtn_Infor:
                    escribir.write(rbtn_infor.getText().toString()+"\n");
                break;

                case R.id.rbtn_Venta:
                    escribir.write(rbtn_Venta.getText().toString()+"\n");
                break;

                case R.id.rbtn_RH:
                    escribir.write(rbtn_RH.getText().toString()+"\n");
                break;
            }

            Boolean resp = chk_Responsable.isChecked();
            escribir.write(resp+"\n");


            escribir.flush();
            escribir.close();
            Toast.makeText(MainActivity.this, "GUARDADO", Toast.LENGTH_SHORT).show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}