package com.example.memorycards;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ImageView img_1;
    private ImageView img_2;
    private ImageView img_3;
    private ImageView img_4;
    private ImageView img_5;
    private ImageView img_6;
    private ImageView img_7;
    private ImageView img_8;

    private ArrayList<Carta> listCarta = new ArrayList<>();

    private int pos1;
    private int pos2;

    private ImageView aux;
    private ImageView aux2;

    private int carta1;
    private int carta2;


    private boolean rightCouple;


    private int img_volt = 0;
    private int hide= 0;
    private int correctCards=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img_1 = findViewById(R.id.img_1);
        img_2 = findViewById(R.id.img_2);
        img_3 = findViewById(R.id.img_3);
        img_4 = findViewById(R.id.img_4);
        img_5 = findViewById(R.id.img_5);
        img_6 = findViewById(R.id.img_6);
        img_7 = findViewById(R.id.img_7);
        img_8 = findViewById(R.id.img_8);

        Carta abeja = new Carta(R.drawable.abeja, 1);
        Carta caballito = new Carta(R.drawable.caballito, 2);
        Carta elefante = new Carta(R.drawable.elefante, 3);
        Carta mono = new Carta(R.drawable.mono, 4);

        listCarta.add(abeja);
        listCarta.add(caballito);
        listCarta.add(elefante);
        listCarta.add(mono);
        listCarta.add(abeja);
        listCarta.add(caballito);
        listCarta.add(elefante);
        listCarta.add(mono);

        bocaAbajoCartas();
        voltearCartas();


    }

    public void voltearCartas() {

        img_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                putCartas(img_1, 1);
                saveDrawable(listCarta.get(0).getnImagen());
                correct();
                cleanImgs();
                noMatch();

            }
        });

        img_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                putCartas(img_2, 2);
                saveDrawable(listCarta.get(1).getnImagen());
                correct();
                cleanImgs();
                noMatch();

            }
        });

        img_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                putCartas(img_3, 3);
                saveDrawable(listCarta.get(2).getnImagen());
                correct();
                cleanImgs();
                noMatch();
            }
        });

        img_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                putCartas(img_4, 4);
                saveDrawable(listCarta.get(3).getnImagen());
                correct();
                cleanImgs();
                noMatch();
            }
        });

        img_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                putCartas(img_5, 5);
                saveDrawable(listCarta.get(4).getnImagen());
                correct();
                cleanImgs();
                noMatch();
            }
        });

        img_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                putCartas(img_6, 6);
                saveDrawable(listCarta.get(5).getnImagen());
                correct();
                cleanImgs();
                noMatch();
            }
        });

        img_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                putCartas(img_7, 7);
                saveDrawable(listCarta.get(6).getnImagen());
                correct();
                cleanImgs();
                noMatch();

            }
        });

        img_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                putCartas(img_8, 8);
                saveDrawable(listCarta.get(7).getnImagen());
                correct();
                cleanImgs();
                noMatch();
            }
        });
    }


    private void bocaAbajoCartas() {
        img_1.setImageResource(R.drawable.vacio);
        img_2.setImageResource(R.drawable.vacio);
        img_3.setImageResource(R.drawable.vacio);
        img_4.setImageResource(R.drawable.vacio);
        img_5.setImageResource(R.drawable.vacio);
        img_6.setImageResource(R.drawable.vacio);
        img_7.setImageResource(R.drawable.vacio);
        img_8.setImageResource(R.drawable.vacio);
    }

    //VERIFICAR SI LA PAREJA DE CARTAS ESTA BIEN
    private void checkCouple(int c1, int c2) {
        if (c1 == c2) {
            rightCouple = true;
        }
        if (c1 != c2) {
            rightCouple = false;
        }

    }

    private void correct(){
        if(img_volt == 2 && rightCouple){
            Toast.makeText(MainActivity.this, "CARTAS EMPAREJADAS!", Toast.LENGTH_SHORT).show();
        }else if(img_volt == 2 && !rightCouple){
            Toast.makeText(MainActivity.this, "FALLASTE!", Toast.LENGTH_SHORT).show();
        }
    }


    //GUARDAR EL NUMERO DE LA IMAGEN
    private void saveDrawable(int nImg) {
        if (img_volt == 0) {
            carta1 = nImg;
            img_volt++;
        } else if (img_volt == 1) {
            carta2 = nImg;
            img_volt++;
        }
        checkCouple(carta1, carta2);
    }

    //GUARDAR LA IMAGEN
    private void putCartas(ImageView img, int pos) {
        if (img_volt == 0) {
            Drawable dImg = getDrawable(listCarta.get(pos).getImg());
            pos1 = pos;
            img.setImageDrawable(dImg);
            aux = img;

        }
        if (img_volt == 1) {
            Drawable dImg = getDrawable(listCarta.get(pos).getImg());
            pos2 = pos;
            img.setImageDrawable(dImg);
            aux2 = img;
        }
        if (img_volt >= 2) {
            Toast.makeText(MainActivity.this, "NO PUEDES TENER MAS DE DOS LEVANTADAS", Toast.LENGTH_SHORT).show();
        }
    }


    private void cleanImgs(){
        if(rightCouple){
            switch (pos1) {
                case 0:
                    img_1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            img_1.setImageResource(android.R.color.transparent);
                            img_1.setEnabled(false);
                            hide++;
                            correctCards++;

                        }
                    });
                    break;
                case 1:
                    img_2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            img_2.setImageResource(android.R.color.transparent);
                            img_2.setEnabled(false);
                            hide++;
                            correctCards++;

                        }
                    });
                    break;
                case 2:
                    img_3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            img_3.setImageResource(android.R.color.transparent);
                            img_3.setEnabled(false);
                            hide++;
                            correctCards++;

                        }
                    });
                    break;
                case 3:
                    img_4.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            img_4.setImageResource(android.R.color.transparent);
                            img_4.setEnabled(false);
                            hide++;
                            correctCards++;

                        }
                    });
                    break;
                case 4:
                    img_5.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            img_5.setImageResource(android.R.color.transparent);
                            img_5.setEnabled(false);
                            hide++;
                            correctCards++;

                        }
                    });
                    break;
                case 5:
                    img_6.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            img_6.setImageResource(android.R.color.transparent);
                            img_6.setEnabled(false);
                            hide++;
                            correctCards++;

                        }
                    });
                    break;
                case 6:
                    img_7.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            img_7.setImageResource(android.R.color.transparent);
                            img_7.setEnabled(false);
                            hide++;
                            correctCards++;

                        }
                    });
                    break;
                case 7:
                    img_8.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            img_8.setImageResource(android.R.color.transparent);
                            img_8.setEnabled(false);
                            hide++;
                            correctCards++;
                        }
                    });
                    break;
            }
            switch (pos2){
                case 0:
                    img_1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            img_1.setImageResource(android.R.color.transparent);
                            img_1.setEnabled(false);
                            hide++;
                            correctCards++;

                        }
                    });
                    break;
                case 1:
                    img_2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            img_2.setImageResource(android.R.color.transparent);
                            img_2.setEnabled(false);
                            hide++;
                            correctCards++;

                        }
                    });
                    break;
                case 2:
                    img_3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            img_3.setImageResource(android.R.color.transparent);
                            img_3.setEnabled(false);
                            hide++;
                            correctCards++;

                        }
                    });
                    break;
                case 3:
                    img_4.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            img_4.setImageResource(android.R.color.transparent);
                            img_4.setEnabled(false);
                            hide++;
                            correctCards++;

                        }
                    });
                    break;
                case 4:
                    img_5.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            img_5.setImageResource(android.R.color.transparent);
                            img_5.setEnabled(false);
                            hide++;
                            correctCards++;

                        }
                    });
                    break;
                case 5:
                    img_6.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            img_6.setImageResource(android.R.color.transparent);
                            img_6.setEnabled(false);
                            hide++;
                            correctCards++;

                        }
                    });
                    break;
                case 6:
                    img_7.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            img_7.setImageResource(android.R.color.transparent);
                            img_7.setEnabled(false);
                            hide++;
                            correctCards++;

                        }
                    });
                    break;
                case 7:
                    img_8.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            img_8.setImageResource(android.R.color.transparent);
                            img_8.setEnabled(false);
                            hide++;
                            correctCards++;
                        }
                    });
                    break;

            }

            if(hide ==2){
                img_volt = 0;
                rightCouple = false;
                hide = 0;
            }
            if(correctCards >= 8){
                Toast.makeText(MainActivity.this, "ACERTASTE TODAS SOS RE CAPO", Toast.LENGTH_SHORT).show();
            }

        }
    }

    private void noMatch() {
        if (!rightCouple && img_volt >= 2) {
            switch (pos1) {
                case 0:
                    img_1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            img_1.setImageDrawable(getDrawable(R.drawable.vacio));
                        }
                    });
                    break;

                case 1:
                    img_2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            img_2.setImageDrawable(getDrawable(R.drawable.vacio));
                        }
                    });
                    break;
                case 2:
                    img_3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            img_3.setImageDrawable(getDrawable(R.drawable.vacio));
                        }
                    });
                    break;
                case 3:
                    img_4.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            img_4.setImageDrawable(getDrawable(R.drawable.vacio));
                        }
                    });
                    break;

                case 4:
                    img_5.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            img_5.setImageDrawable(getDrawable(R.drawable.vacio));
                        }
                    });
                    break;

                case 5:
                    img_6.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            img_6.setImageDrawable(getDrawable(R.drawable.vacio));
                        }
                    });
                    break;
                case 6:
                    img_7.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            img_7.setImageDrawable(getDrawable(R.drawable.vacio));
                        }
                    });
                    break;
                case 7:
                    img_8.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            img_8.setImageDrawable(getDrawable(R.drawable.vacio));
                        }
                    });
                    break;
            }
                switch (pos2) {
                    case 0:
                        img_1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                img_1.setImageDrawable(getDrawable(R.drawable.vacio));
                            }
                        });
                        break;

                    case 1:
                        img_2.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                img_2.setImageDrawable(getDrawable(R.drawable.vacio));
                            }
                        });
                        break;
                    case 2:
                        img_3.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                img_3.setImageDrawable(getDrawable(R.drawable.vacio));
                            }
                        });
                        break;
                    case 3:
                        img_4.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                img_4.setImageDrawable(getDrawable(R.drawable.vacio));
                            }
                        });
                        break;

                    case 4:
                        img_5.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                img_5.setImageDrawable(getDrawable(R.drawable.vacio));
                            }
                        });
                        break;

                    case 5:
                        img_6.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                img_6.setImageDrawable(getDrawable(R.drawable.vacio));
                            }
                        });
                        break;
                    case 6:
                        img_7.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                img_7.setImageDrawable(getDrawable(R.drawable.vacio));
                            }
                        });
                        break;
                    case 7:
                        img_8.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                img_8.setImageDrawable(getDrawable(R.drawable.vacio));
                            }
                        });
                        break;
                }
                        if(img_volt>= 2){
                            img_volt =0;
                            hide = 0;
                        }
        }
    }
}