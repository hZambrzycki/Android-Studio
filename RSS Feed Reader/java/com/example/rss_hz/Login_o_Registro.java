package com.example.rss_hz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login_o_Registro extends AppCompatActivity {
    EditText usuario, password, repassword;
    Button registrarse, logearse;
    DB_Logeo DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_oregistro);

        usuario = findViewById(R.id.et_nombreUsuario1);
        password = findViewById(R.id.et_password1);
        repassword = findViewById(R.id.repassword);
        registrarse = findViewById(R.id.btnsignup);
        logearse = findViewById(R.id.btnsignin);
        DB = new DB_Logeo(this);

        registrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = usuario.getText().toString();
                String pass = password.getText().toString();
                String repass = repassword.getText().toString();

                if (user.equals("") || pass.equals("") || repass.equals(""))
                    Toast.makeText(Login_o_Registro.this, R.string.rellenarCampos, Toast.LENGTH_SHORT).show();
                else {
                    if (pass.equals(repass)) {
                        Boolean checkuser = DB.checkusername(user);
                        if (checkuser == false) {
                            Boolean insert = DB.insertData(user, pass);
                            if (insert == true) {
                                Toast.makeText(Login_o_Registro.this, R.string.RegistroCompletado, Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), Login.class);
                                startActivity(intent);
                            } else {
                                Toast.makeText(Login_o_Registro.this, R.string.RegistroFallado, Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(Login_o_Registro.this, R.string.usuarioExistente, Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(Login_o_Registro.this, R.string.passNoCoincide, Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        logearse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Login.class);
                startActivity(intent);
            }
        });
    }
}
