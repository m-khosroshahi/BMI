package com.example.milad.bmi;

import android.graphics.Color;
import android.icu.text.DecimalFormat;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

EditText edt1,edt2;
TextView txt3,txt4;
Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt1 = (EditText) findViewById(R.id.edt1);
        edt2 = (EditText) findViewById(R.id.edt2);
        txt3 = (TextView) findViewById(R.id.txt3);
        txt4 = (TextView) findViewById(R.id.txt4);
        btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                bmi(edt1,edt2,txt3,txt4);
            }
        });


    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void bmi(EditText edt1, EditText edt2, TextView txt3, TextView txt4) {

        if (edt1.getText().toString().isEmpty()|| edt2.getText().toString().isEmpty())
        {
            Toast.makeText(this, "مشخصاتو کامل وارد کن... لطفا!", Toast.LENGTH_LONG).show();
        }
        else
        {
            Double w = Double.parseDouble(edt1.getText().toString());
            Double l = Double.parseDouble(edt2.getText().toString());
            Double x = (l/100);
            Double p = Math.pow(x,2);
            Double bmi = (w/p);
            DecimalFormat dec = new DecimalFormat("0.0");
            txt3.setText(" BMI : "+dec.format(bmi));
            txt3.setVisibility(View.VISIBLE);
            if (bmi <18.5)
            {
                Double k = 18.5 - bmi;
                txt4.setText(dec.format(k)+" کیلو کمبود وزن داری !!");
                txt4.setTextColor(Color.WHITE);
                txt4.setVisibility(View.VISIBLE);

            }
            if (bmi >=18.5 && bmi<= 24.9 )
            {

                txt4.setText("وزنت طبیعیه");
                txt4.setTextColor(Color.WHITE);
                txt4.setVisibility(View.VISIBLE);

            }
            if (bmi >24.9)
            {
                Double k = bmi - 24.9;
                dec.format(k);
                txt4.setText(dec.format(k)+" کیلو اضافه وزن داری !!");
                txt4.setTextColor(Color.WHITE);
                txt4.setVisibility(View.VISIBLE);

            }
        }


    }
}
