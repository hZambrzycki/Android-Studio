package com.example.myapplication;

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
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Context context = MainActivity.this;
    private EditText et_id, et_name, et_tlf, et_email;
    private RadioGroup radioGroup;
    private RadioButton rb_info, rb_sales, rb_rrhh;
    private CheckBox cb_bol;
    private Button btn_reset, btn_loadData, btn_loadInternalData, btn_insertData;
    private ArrayList<String> data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       et_id = findViewById(R.id.et_id);
       et_name = findViewById(R.id.et_name);
       et_tlf = findViewById(R.id.et_phone);
       et_email = findViewById(R.id.et_mail);

       radioGroup = findViewById(R.id.rg_departamentos);
       
       rb_info = findViewById(R.id.rb_informatica);
       rb_rrhh = findViewById(R.id.rb_recursos);
       rb_sales = findViewById(R.id.rb_ventas);
       
       cb_bol = findViewById(R.id.cb_responsable);
       
       btn_reset = findViewById(R.id.btn_reinciarTextos);
       btn_insertData = findViewById(R.id.btn_InsertarInternos);
       btn_loadData = findViewById(R.id.btn_cargarDatos);
       btn_loadInternalData = findViewById(R.id.btn_cargarDatosInternos);
        data = new ArrayList<>();
       btn_reset.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               et_id.setText(" ");
               et_email.setText(" ");
               et_tlf.setText(" ");
               et_name.setText(" ");
               rb_info.setChecked(false);
               rb_rrhh.setChecked(false);
               rb_sales.setChecked(false);
               cb_bol.setChecked(false);
           }
       });
       btn_loadData.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               cargarDatosRaw();
           }
       });
       btn_insertData.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               guardarDatos();
           }
       });
       btn_loadInternalData.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               cargarDatosInternos();
           }
       });
    }



    private void guardarDatos() {
        try {
            OutputStreamWriter archivo = new OutputStreamWriter(openFileOutput("archivo.txt", MODE_PRIVATE));
            archivo.write(et_id.getText().toString());
            archivo.write("\n");
            archivo.write(et_name.getText().toString());
            archivo.write(("\n"));
            archivo.write(et_tlf.getText().toString());
            archivo.write("\n");
            archivo.write(et_email.getText().toString());
            archivo.write("\n");
            switch(radioGroup.getCheckedRadioButtonId()) {
                case R.id.rb_informatica:
                    archivo.write(rb_info.getText().toString());
                    archivo.write("\n");
                    break;
                case R.id.rb_ventas:
                    archivo.write(rb_sales.getText().toString());
                    archivo.write("\n");
                    break;
                case R.id.rb_recursos:
                    archivo.write(rb_rrhh.getText().toString());
                    archivo.write("\n");
                    break;
            }
            if(cb_bol.isChecked()) {
                archivo.write("true");
                archivo.write("\n");
            }
            archivo.flush();
            archivo.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void cargarDatosInternos() {
        try {
            InputStreamReader i = new InputStreamReader(openFileInput("archivo.txt"));
            BufferedReader br = new BufferedReader(i);
            try {
                String datos = br.readLine();
                while(datos!= null) {
                    data.add(datos);
                    datos = br.readLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            et_id.setText(data.get(0));
            et_name.setText(data.get(1));
            et_tlf.setText(data.get(2));
            et_email.setText(data.get(3));
            switch(data.get(4)) {
                case "Departamento de Informatica":
                    rb_info.setChecked(true);
                    break;
                case "Departamento de Ventas":
                    rb_sales.setChecked(true);
                    break;
                case "Departamento de Recursos Humanos":
                    rb_rrhh.setChecked(true);
                    break;
            }
            if(data.get(5).equalsIgnoreCase("true")) {
                cb_bol.setChecked(true);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    private void cargarDatosRaw() {
        InputStream f = context.getResources().openRawResource(R.raw.fichero);
        BufferedReader br = new BufferedReader((new InputStreamReader(f)));
        try {
            String datos = br.readLine();
            while(datos!= null) {
                data.add(datos);
                datos = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        et_id.setText(data.get(0));
        et_name.setText(data.get(1));
        et_tlf.setText(data.get(2));
        et_email.setText(data.get(3));
        switch(data.get(4)) {
            case "Departamento de Informatica":
                rb_info.setChecked(true);
                break;
            case "Departamento de Ventas":
                rb_sales.setChecked(true);
                break;
            case "Departamento de Recursos Humanos":
                rb_rrhh.setChecked(true);
                break;
        }
        if(data.get(5).equalsIgnoreCase("true")) {
            cb_bol.setChecked(true);
        }
    }
}