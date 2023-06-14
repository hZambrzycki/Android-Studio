package com.example.proyectoandroid_hz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Detalle extends AppCompatActivity {

    /*
    Etiqueta de depuraci�n
     */
    private static final String TAG = Detalle.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        // Dehabilitar titulo de la actividad
        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayShowTitleEnabled(false);


        // Recuperar url
        String urlExtra = getIntent().getStringExtra("url-extra");

        // Obtener WebView
        WebView webview = (WebView) findViewById(R.id.webview);

        // Habilitar Javascript en el renderizado
        webview.getSettings().setJavaScriptEnabled(true);

        // Transmitir localmente
        webview.setWebViewClient(new WebViewClient());

        // Cargar el contenido de la url
        webview.loadUrl(urlExtra);

    }
}