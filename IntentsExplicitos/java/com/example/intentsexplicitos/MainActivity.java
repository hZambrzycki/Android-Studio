package com.example.intentsexplicitos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    static final int REQUEST_IMAGE_CAPTURE = 1;

    private Button btn_web;
    private Button btn_llamarTlf;
    private Button btn_accederUbi;
    private Button btn_tomarFoto;
    private Button btn_calendario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        btn_web = findViewById(R.id.btn_accederWeb);
        btn_llamarTlf = findViewById(R.id.btn_LlamarTlf);
        btn_accederUbi = findViewById(R.id.btn_AccederAUbi);
        btn_tomarFoto = findViewById(R.id.btn_TomarFoto);
        btn_calendario = findViewById(R.id.btn_Calendario);

        double latitud = 40.42201028500664;
        double longitud = -3.7065621182145523;
        String localizacion = "Sol";

        btn_web.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openWebPage("https://www.google.es/");
            }
        });
        btn_llamarTlf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialPhoneNumber("647945740");
            }
        });
        btn_accederUbi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showMap(Uri.parse("geo:<" + latitud + ">,<" + longitud + ">?q=<" + latitud + ">,<" + longitud + ">(" +localizacion+")"));
            }
        });

        btn_tomarFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              capturePhoto();
            }
        });
        btn_calendario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addEvent("CUMPLEAÑOS", "PLAZA MAYOR", 10, 22);
            }
        });
    }
    public void openWebPage(String url) {
        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
    public void dialPhoneNumber(String phoneNumber) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + phoneNumber));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
    public void showMap(Uri geoLocation) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(geoLocation);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
    public void capturePhoto() {
        Intent intent = new Intent(MediaStore.INTENT_ACTION_STILL_IMAGE_CAMERA);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent, REQUEST_IMAGE_CAPTURE);
        }
    }
    public void addEvent(String title, String location, long begin, long end) {
        Intent intent = new Intent(Intent.ACTION_INSERT)
                .setData(CalendarContract.Events.CONTENT_URI)
                .putExtra(CalendarContract.Events.TITLE, title)
                .putExtra(CalendarContract.Events.EVENT_LOCATION, location)
                .putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, begin)
                .putExtra(CalendarContract.EXTRA_EVENT_END_TIME, end);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}