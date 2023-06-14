package com.example.factorial;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.preference.EditTextPreference;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button btn_calc;
    private EditText edt_number;
    private TextView tv_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_calc = (Button) findViewById(R.id.btn_calc);
        edt_number = (EditText) findViewById(R.id.edt_number);
        tv_result = (TextView) findViewById(R.id.tv_result);


        btn_calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int n = Integer.parseInt(edt_number.getText().toString());
                MiThread miThread = new MiThread(n);
                miThread.start();

                //calcFactorial(number);

            }
        });


    }

    class MiThread  extends Thread{
        private int n ,res; //factorial // EL NUMERO SOBRE EL QUE SE VA A CONSTRUIR EL FACTORIAL
        public MiThread(int n ){
            this.n=n;
        }
        @Override
        public void run(){
            res =calcFactorial(n);
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    tv_result.append(n +"!= " + res + "\n");
                }
            });

        }

    }


    public int calcFactorial(int n) {

        int total = 1;
        for (int i = 1; i <= n; i++) {

            total = total * i;

        }

          return total;

    }

}
