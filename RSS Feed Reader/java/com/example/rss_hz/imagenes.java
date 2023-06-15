package com.example.rss_hz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;


public class imagenes extends AppCompatActivity {
    private Rect rect;
    private ImageView iv1, iv2, iv3, iv4, iv5, iv6, iv7, iv8, iv9, iv10, iv11, iv12;
    private int valorImagen;
    private Button imagenGuardada, mas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imagenes);
        mas = findViewById(R.id.btn_moreImgs);
        iv1 = findViewById(R.id.iv1);
        iv2 = findViewById(R.id.iv2);
        iv3 = findViewById(R.id.iv3);
        iv4 = findViewById(R.id.iv4);
        iv5 = findViewById(R.id.iv5);
        iv6 = findViewById(R.id.iv6);
        iv7 = findViewById(R.id.iv7);
        iv8 = findViewById(R.id.iv8);
        iv9 = findViewById(R.id.iv9);
        iv10 = findViewById(R.id.iv10);
        iv11 = findViewById(R.id.iv11);
        iv12 = findViewById(R.id.iv12);

        iv1.setTag(R.drawable.angularjs);
        iv2.setTag(R.drawable.android);
        iv3.setTag(R.drawable.bootstrap);
        iv4.setTag(R.drawable.c);
        iv5.setTag(R.drawable.codeigniter);
        iv6.setTag(R.drawable.confidencial);
        iv7.setTag(R.drawable.cplusplus);
        iv8.setTag(R.drawable.github);
        iv9.setTag(R.drawable.css3);
        iv10.setTag(R.drawable.jquery);
        iv11.setTag(R.drawable.nodejs);
        iv12.setTag(R.drawable.java);


        imagenGuardada = findViewById(R.id.btn_imagenElegida3);

        mas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), imagenes2.class);
                startActivity(i);
            }
        });
        imagenGuardada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (valorImagen == 1) {
                    Toast.makeText(imagenes.this, "angularjs", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(imagenes.this, IncluirRSS.class);
                    i.putExtra("imagen", R.drawable.angularjs);
                    startActivity(i);
                } else if (valorImagen == 2) {
                    Toast.makeText(imagenes.this, "Android", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(imagenes.this, IncluirRSS.class);
                    i.putExtra("imagen", R.drawable.android);
                    startActivity(i);
                } else if (valorImagen == 3) {
                    Toast.makeText(imagenes.this, "bootstrap", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(imagenes.this, IncluirRSS.class);
                    i.putExtra("imagen", R.drawable.bootstrap);
                    startActivity(i);
                } else if (valorImagen == 4) {
                    Toast.makeText(imagenes.this, "c", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(imagenes.this, IncluirRSS.class);
                    i.putExtra("imagen", R.drawable.c);
                    startActivity(i);
                } else if (valorImagen == 5) {
                    Toast.makeText(imagenes.this, "codeigniter", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(imagenes.this, IncluirRSS.class);
                    i.putExtra("imagen", R.drawable.codeigniter);
                    startActivity(i);
                } else if (valorImagen == 6) {
                    Toast.makeText(imagenes.this, "confidencial", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(imagenes.this, IncluirRSS.class);
                    i.putExtra("imagen", R.drawable.confidencial);
                    startActivity(i);
                } else if (valorImagen == 7) {
                    Toast.makeText(imagenes.this, "cplusplus", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(imagenes.this, IncluirRSS.class);
                    i.putExtra("imagen", R.drawable.cplusplus);
                    startActivity(i);
                } else if (valorImagen == 8) {
                    Toast.makeText(imagenes.this, "github", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(imagenes.this, IncluirRSS.class);
                    i.putExtra("imagen", R.drawable.github);
                    startActivity(i);
                } else if (valorImagen == 9) {
                    Toast.makeText(imagenes.this, "css3", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(imagenes.this, IncluirRSS.class);
                    i.putExtra("imagen", R.drawable.css3);
                    startActivity(i);
                } else if (valorImagen == 10) {
                    Toast.makeText(imagenes.this, "jquery", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(imagenes.this, IncluirRSS.class);
                    i.putExtra("imagen", R.drawable.jquery);
                    startActivity(i);
                } else if (valorImagen == 11) {
                    Toast.makeText(imagenes.this, "nodejs", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(imagenes.this, IncluirRSS.class);
                    i.putExtra("imagen", R.drawable.nodejs);
                    startActivity(i);
                } else if (valorImagen == 12) {
                    Toast.makeText(imagenes.this, "java", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(imagenes.this, IncluirRSS.class);
                    i.putExtra("imagen", R.drawable.java);
                    startActivity(i);
                }
            }
        });

        iv1.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    valorImagen = 1;
                    iv1.setColorFilter(Color.argb(50, 0, 0, 0));
                    rect = new Rect(v.getLeft(), v.getTop(), v.getRight(), v.getBottom());
                }
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    iv1.setColorFilter(Color.argb(0, 0, 0, 0));
                    rect = new Rect(v.getLeft(), v.getTop(), v.getRight(), v.getBottom());
                }
                if (event.getAction() == MotionEvent.ACTION_MOVE) {
                    if (!rect.contains(v.getLeft() + (int) event.getX(), v.getTop() + (int) event.getY())) {
                        iv1.setColorFilter(Color.argb(0, 0, 0, 0));
                    }
                }
                return false;
            }
        });
        iv2.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    valorImagen = 2;
                    iv2.setColorFilter(Color.argb(50, 0, 0, 0));
                    rect = new Rect(v.getLeft(), v.getTop(), v.getRight(), v.getBottom());
                }
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    iv2.setColorFilter(Color.argb(0, 0, 0, 0));
                }
                if (event.getAction() == MotionEvent.ACTION_MOVE) {
                    if (!rect.contains(v.getLeft() + (int) event.getX(), v.getTop() + (int) event.getY())) {
                        iv2.setColorFilter(Color.argb(0, 0, 0, 0));
                    }
                }
                return false;
            }
        });
        iv3.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    valorImagen = 3;
                    iv3.setColorFilter(Color.argb(50, 0, 0, 0));
                    rect = new Rect(v.getLeft(), v.getTop(), v.getRight(), v.getBottom());
                }
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    iv3.setColorFilter(Color.argb(0, 0, 0, 0));
                }
                if (event.getAction() == MotionEvent.ACTION_MOVE) {
                    if (!rect.contains(v.getLeft() + (int) event.getX(), v.getTop() + (int) event.getY())) {
                        iv3.setColorFilter(Color.argb(0, 0, 0, 0));
                    }
                }
                return false;
            }
        });
        iv4.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    valorImagen = 4;
                    iv4.setColorFilter(Color.argb(50, 0, 0, 0));
                    rect = new Rect(v.getLeft(), v.getTop(), v.getRight(), v.getBottom());
                }
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    iv4.setColorFilter(Color.argb(0, 0, 0, 0));
                }
                if (event.getAction() == MotionEvent.ACTION_MOVE) {
                    if (!rect.contains(v.getLeft() + (int) event.getX(), v.getTop() + (int) event.getY())) {
                        iv4.setColorFilter(Color.argb(0, 0, 0, 0));
                    }
                }
                return false;
            }
        });
        iv5.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    valorImagen = 5;
                    iv5.setColorFilter(Color.argb(50, 0, 0, 0));
                    rect = new Rect(v.getLeft(), v.getTop(), v.getRight(), v.getBottom());
                }
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    iv5.setColorFilter(Color.argb(0, 0, 0, 0));
                }
                if (event.getAction() == MotionEvent.ACTION_MOVE) {
                    if (!rect.contains(v.getLeft() + (int) event.getX(), v.getTop() + (int) event.getY())) {
                        iv5.setColorFilter(Color.argb(0, 0, 0, 0));
                    }
                }
                return false;
            }
        });
        iv6.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    valorImagen = 6;
                    iv6.setColorFilter(Color.argb(50, 0, 0, 0));
                    rect = new Rect(v.getLeft(), v.getTop(), v.getRight(), v.getBottom());
                }
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    iv6.setColorFilter(Color.argb(0, 0, 0, 0));
                }
                if (event.getAction() == MotionEvent.ACTION_MOVE) {
                    if (!rect.contains(v.getLeft() + (int) event.getX(), v.getTop() + (int) event.getY())) {
                        iv6.setColorFilter(Color.argb(0, 0, 0, 0));
                    }
                }
                return false;
            }
        });
        iv7.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    valorImagen = 7;
                    iv7.setColorFilter(Color.argb(50, 0, 0, 0));
                    rect = new Rect(v.getLeft(), v.getTop(), v.getRight(), v.getBottom());
                }
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    iv7.setColorFilter(Color.argb(0, 0, 0, 0));
                }
                if (event.getAction() == MotionEvent.ACTION_MOVE) {
                    if (!rect.contains(v.getLeft() + (int) event.getX(), v.getTop() + (int) event.getY())) {
                        iv7.setColorFilter(Color.argb(0, 0, 0, 0));
                    }
                }
                return false;
            }
        });
        iv8.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    valorImagen = 8;
                    iv8.setColorFilter(Color.argb(50, 0, 0, 0));
                    rect = new Rect(v.getLeft(), v.getTop(), v.getRight(), v.getBottom());
                }
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    iv8.setColorFilter(Color.argb(0, 0, 0, 0));
                }
                if (event.getAction() == MotionEvent.ACTION_MOVE) {
                    if (!rect.contains(v.getLeft() + (int) event.getX(), v.getTop() + (int) event.getY())) {
                        iv8.setColorFilter(Color.argb(0, 0, 0, 0));
                    }
                }
                return false;
            }
        });
        iv9.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    valorImagen = 9;
                    iv9.setColorFilter(Color.argb(50, 0, 0, 0));
                    rect = new Rect(v.getLeft(), v.getTop(), v.getRight(), v.getBottom());
                }
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    iv9.setColorFilter(Color.argb(0, 0, 0, 0));
                }
                if (event.getAction() == MotionEvent.ACTION_MOVE) {
                    if (!rect.contains(v.getLeft() + (int) event.getX(), v.getTop() + (int) event.getY())) {
                        iv9.setColorFilter(Color.argb(0, 0, 0, 0));
                    }
                }
                return false;
            }
        });
        iv10.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    valorImagen = 10;
                    iv10.setColorFilter(Color.argb(50, 0, 0, 0));
                    rect = new Rect(v.getLeft(), v.getTop(), v.getRight(), v.getBottom());
                }
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    iv10.setColorFilter(Color.argb(0, 0, 0, 0));
                }
                if (event.getAction() == MotionEvent.ACTION_MOVE) {
                    if (!rect.contains(v.getLeft() + (int) event.getX(), v.getTop() + (int) event.getY())) {
                        iv10.setColorFilter(Color.argb(0, 0, 0, 0));
                    }
                }
                return false;
            }
        });
        iv11.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    valorImagen = 11;
                    iv11.setColorFilter(Color.argb(50, 0, 0, 0));
                    rect = new Rect(v.getLeft(), v.getTop(), v.getRight(), v.getBottom());
                }
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    iv11.setColorFilter(Color.argb(0, 0, 0, 0));
                }
                if (event.getAction() == MotionEvent.ACTION_MOVE) {
                    if (!rect.contains(v.getLeft() + (int) event.getX(), v.getTop() + (int) event.getY())) {
                        iv11.setColorFilter(Color.argb(0, 0, 0, 0));
                    }
                }
                return false;
            }
        });
        iv12.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    valorImagen = 12;
                    iv12.setColorFilter(Color.argb(50, 0, 0, 0));
                    rect = new Rect(v.getLeft(), v.getTop(), v.getRight(), v.getBottom());
                }
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    iv12.setColorFilter(Color.argb(0, 0, 0, 0));
                }
                if (event.getAction() == MotionEvent.ACTION_MOVE) {
                    if (!rect.contains(v.getLeft() + (int) event.getX(), v.getTop() + (int) event.getY())) {
                        iv12.setColorFilter(Color.argb(0, 0, 0, 0));
                    }
                }
                return false;
            }
        });


    }
}