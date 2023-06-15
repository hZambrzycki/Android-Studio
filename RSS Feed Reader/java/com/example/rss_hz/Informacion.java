package com.example.rss_hz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

public class Informacion extends AppCompatActivity {
    private ViewPager viewPager;
    private AdaptadorInformacion adaptadorInformacion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacion);
        viewPager = findViewById(R.id.viewpager);
        adaptadorInformacion = new AdaptadorInformacion(this);
        viewPager.setAdapter(adaptadorInformacion);
    }
}