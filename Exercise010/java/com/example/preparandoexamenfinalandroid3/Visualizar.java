package com.example.preparandoexamenfinalandroid3;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;

public class Visualizar extends AppCompatActivity {
private DB db;
private TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualizar);
        db = new DB(this);

        Cursor cursor = db.visualizar();
       tv = findViewById(R.id.tv_visualizar);
        while (cursor.moveToNext()) {
            tv.setText("El id es : " + String.valueOf(cursor.getInt(0)) + "\n" + " El nombre es : " + cursor.getString(1) + " \n" + "El tlf es : " + String.valueOf(cursor.getInt(2)) + " El email es : " + cursor.getString(3) + " El departamento es : " + cursor.getString(4) + " Y es encargado : " + cursor.getInt(5));

        }

    }
}