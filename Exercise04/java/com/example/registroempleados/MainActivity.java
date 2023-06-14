package com.example.registroempleados;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
        private EditText edt_Id,edt_NyA,edt_Telefono,edt_Correo;
        private RadioButton rbtn_infor,rbtn_Venta,rbtn_RH;
        private RadioGroup rd_grp;
        private CheckBox chk_Responsable;
        private Button btn_Insertar, btn_Borrar, btn_Actualizar;
        private DB db;


        private ArrayList<Empleado>listEmpleado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        edt_Id = findViewById(R.id.edt_Id);
        edt_NyA = findViewById(R.id.edt_NyA);
        edt_Telefono = findViewById(R.id.edt_Telefono);
        edt_Correo = findViewById(R.id.edt_Correo);

        rbtn_infor = findViewById(R.id.rbtn_Infor);
        rbtn_Venta = findViewById(R.id.rbtn_Venta);
        rbtn_RH = findViewById(R.id.rbtn_RH);
        rd_grp = findViewById(R.id.rd_grp);

        chk_Responsable = findViewById(R.id.chk_Responsable);

        btn_Insertar = findViewById(R.id.btn_Insertar);
        btn_Borrar = findViewById(R.id.btn_Borrar);
        btn_Actualizar = findViewById(R.id.btn_Actualizar);

        db = new DB(this);

        /*
        VISUALIZAR DATOS

         */
        listEmpleado = new ArrayList<>();

        listEmpleado = db.recuperarEmpleados();
        for (int i = 0; i < listEmpleado.size(); i++) {
            System.out.println(listEmpleado.get(i)+"\n");
        }



        btn_Insertar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = edt_Id.getText().toString();
                String nya = edt_NyA.getText().toString();
                String telefono = edt_Telefono.getText().toString();
                String correo = edt_Correo.getText().toString();

                Boolean responsable = chk_Responsable.isChecked();


                if (!id.isEmpty() && !nya.isEmpty() && !telefono.isEmpty() && !correo.isEmpty()) {
                    Empleado empleado = new Empleado(Integer.parseInt(id), nya, Integer.parseInt(telefono), correo, null, responsable);

                    switch (rd_grp.getCheckedRadioButtonId()) {
                        case R.id.rbtn_Infor:
                            String informatica = rbtn_infor.getText().toString();
                            empleado.setDepartamento(informatica);
                            db.Insertar(empleado);
                            Toast.makeText(MainActivity.this, "EMPLEADO DE INFORMATICA REGISTRADO", Toast.LENGTH_SHORT).show();
                            vaciarDatos();
                            break;

                        case R.id.rbtn_Venta:
                            String venta = rbtn_Venta.getText().toString();
                            empleado.setDepartamento(venta);
                            db.Insertar(empleado);
                            Toast.makeText(MainActivity.this, "EMPLEADO DE VENTA REGISTRADO", Toast.LENGTH_SHORT).show();
                            vaciarDatos();
                            break;

                        case R.id.rbtn_RH:
                            String rh = rbtn_RH.getText().toString();
                            empleado.setDepartamento(rh);
                            db.Insertar(empleado);
                            Toast.makeText(MainActivity.this, "EMPLEADO DE RH REGISTRADO", Toast.LENGTH_SHORT).show();
                            vaciarDatos();
                            break;
                        default:
                            Toast.makeText(MainActivity.this, "TIENE QUE HABER AL MENOS UN CHECKBOX MARCADO", Toast.LENGTH_SHORT).show();
                            break;
                    }
/*
                if(rbtn_infor.isChecked()){
                    String informatica = rbtn_infor.getText().toString();
                    db.Insertar(id,nya,telefono,correo,informatica,responsable);
                    Toast.makeText(MainActivity.this,"EMPLEADO DE INFORMATICA REGISTRADO", Toast.LENGTH_SHORT).show();
                }else if(rbtn_Venta.isChecked()){
                    String venta = rbtn_Venta.getText().toString();
                    db.Insertar(id,nya,telefono,correo,venta,responsable);
                    Toast.makeText(MainActivity.this,"EMPLEADO DE VENTA REGISTRADO", Toast.LENGTH_SHORT).show();
                }else if(rbtn_RH.isChecked()){
                    String rh = rbtn_RH.getText().toString();
                    db.Insertar(id,nya,telefono,correo,rh,responsable);
                    Toast.makeText(MainActivity.this,"EMPLEADO DE RH REGISTRADO", Toast.LENGTH_SHORT).show();
                }
*/
                }else{
                    Toast.makeText(MainActivity.this, "PARA REGISTRAR DEBES INTRODUCIR TODOS LOS DATOS", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btn_Borrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String idd = edt_Id.getText().toString();
                if(!idd.isEmpty()){
                    int id = Integer.parseInt(edt_Id.getText().toString());
                    db.eliminar(id);
                    Toast.makeText(MainActivity.this, "BORRADO COMPLETADO", Toast.LENGTH_SHORT).show();
                }else
                {
                    Toast.makeText(MainActivity.this, "DEBE INTRODUCIR EL ID", Toast.LENGTH_SHORT).show();
                }

            }
        });

        btn_Actualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = edt_Id.getText().toString();
                String nya = edt_NyA.getText().toString();
                String telefono = edt_Telefono.getText().toString();
                String correo = edt_Correo.getText().toString();
                Boolean responsable = chk_Responsable.isChecked();



                if (!id.isEmpty() && !nya.isEmpty() && !telefono.isEmpty() && !correo.isEmpty()){
                    int idInt = Integer.parseInt(id);
                    int telefonoInt = Integer.parseInt(telefono);
                    Empleado empleado = new Empleado(idInt, nya, telefonoInt, correo, null, responsable);
                    switch (rd_grp.getCheckedRadioButtonId()) {
                        case R.id.rbtn_Infor:
                            String informatica = rbtn_infor.getText().toString();
                            empleado.setDepartamento(informatica);
                            db.actualizar(empleado);
                            Toast.makeText(MainActivity.this, "INFORMATICO ACTUALIZADO ", Toast.LENGTH_SHORT).show();
                            vaciarDatos();
                            break;

                        case R.id.rbtn_Venta:
                            String venta = rbtn_Venta.getText().toString();
                            empleado.setDepartamento(venta);
                            db.actualizar(empleado);
                            Toast.makeText(MainActivity.this, "VENTA ACTUALIZADO ", Toast.LENGTH_SHORT).show();
                            vaciarDatos();
                            break;

                        case R.id.rbtn_RH:
                            String rh = rbtn_RH.getText().toString();
                            empleado.setDepartamento(rh);
                            db.actualizar(empleado);
                            Toast.makeText(MainActivity.this, "RH ACTUALIZADO ", Toast.LENGTH_SHORT).show();

                            vaciarDatos();
                            break;

                        default:
                            Toast.makeText(MainActivity.this, "DEBE MARCAR UN CHECKBOX", Toast.LENGTH_SHORT).show();
                            break;
                    }
                }else{
                    Toast.makeText(MainActivity.this, "PARA ACTUALIZAR DEBE INTRODUCIR TODOS LOS DATOS", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    public void vaciarDatos(){
        edt_Id.setText("");
        edt_NyA.setText("");
        edt_Correo.setText("");
        edt_Telefono.setText("");
        rd_grp.clearCheck();
        chk_Responsable.setChecked(false);
    }
}