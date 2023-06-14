package com.example.ficherointernoempleado;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Context context = MainActivity.this;

    private EditText edt_Id,edt_NyA,edt_Telefono,edt_Correo;
    private RadioButton rbtn_infor,rbtn_Venta,rbtn_RH;
    private RadioGroup rd_grp;
    private CheckBox chk_Responsable;
    private Button btn_Insertar, btn_Borrar, btn_Actualizar;


    private String depa ="";
    int id,telefono;
    String nya,correo;
    Boolean responsable;

    ArrayList<String> datos = new ArrayList<>();

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
        chk_Responsable = findViewById(R.id.chk_Responsable);

        btn_Insertar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rellenarDatos();
            }
        });


    }

    private void rellenarDatos(){
        try{
//SE PUDE PONER MAIN.THIS.GETRESOURCES COMO CREAR UN OBJETO CON EL CONTEXTO
            InputStream f =  context.getResources().openRawResource(R.raw.datos);
            BufferedReader br = new BufferedReader(new InputStreamReader(f));

            String linea = br.readLine();
            while(linea != null){

                datos.add(linea);
                linea = br.readLine();

            }

        }
        catch(IOException e)
        {
            e.printStackTrace();
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

        System.out.println("yyyy "+datos.get(5));
        if(datos.get(5).equalsIgnoreCase("true")){
            chk_Responsable.setChecked(true);
        }
    }
}