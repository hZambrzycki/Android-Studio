package com.example.rss_hz;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class RSSpropias extends AppCompatActivity {
    private ArrayList<String> nombreRSSlist;
    private ArrayList<String> urlslist;
    private ArrayList<String> descripcionRSSList;
    private ArrayList<Integer> imgsRSSlist;
    ListView lvProgram;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rsspropias);
        imgsRSSlist = new ArrayList<>();
        descripcionRSSList = new ArrayList<>();
        urlslist = new ArrayList<>();
        nombreRSSlist = new ArrayList<>();

        lvProgram = findViewById(R.id.lvProgram);


        db = new DatabaseHelper(this);


        viewData();
    }

    private void viewData() {
        Cursor cursor = db.viewData();

        if(cursor.getCount() == 0) {
            Toast.makeText(this, "No hay datos", Toast.LENGTH_SHORT).show();
        } else {
            while(cursor.moveToNext()) {
                nombreRSSlist.add(cursor.getString(1));
                urlslist.add(cursor.getString(2));
                descripcionRSSList.add(cursor.getString(3));
                imgsRSSlist.add(cursor.getInt(4));
                ArrayListAdapter programAdapter = new ArrayListAdapter(this, nombreRSSlist,urlslist, descripcionRSSList, imgsRSSlist);
                lvProgram.setAdapter(programAdapter);

            }

        }
    }


}
