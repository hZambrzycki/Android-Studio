package com.example.factorialthreats;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private EditText introducirNum;
    private TextView resultadoFact;
    private Button btn_calcFact;
    private long factorial=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        introducirNum = findViewById(R.id.editTextNumero);



        resultadoFact = findViewById(R.id.resultadoCalcFact);
        btn_calcFact = findViewById(R.id.btn_CalcularFactorial);

        btn_calcFact.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                int numero = Integer.parseInt(introducirNum.getText().toString());
              for (int i = 1; i <= numero; i++) {
                   factorial =i*factorial;
              }
                resultadoFact.setText(factorial + "");
            }
        });

    }
}