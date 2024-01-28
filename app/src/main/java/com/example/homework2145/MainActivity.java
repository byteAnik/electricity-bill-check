package com.example.homework2145;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText edNumber;
    Button buttonCal;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edNumber=findViewById(R.id.edNumber);
        buttonCal=findViewById(R.id.buttonCal);
        tvResult=findViewById(R.id.tvResult);
        buttonCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sUnit=edNumber.getText().toString();
                if (sUnit.length()>0){
                    float units =Float.parseFloat(sUnit);
                    float bill=0;

                    if (units<=50) bill=(float) (units*0.50);
                    else if (units<=150) bill=(float) (25+(units-50)*0.75);
                    else if (units<=250) bill=(float) (25+75+(units-150)*1.20);
                    else bill =(float) (25+75+120+(units-250)*1.50);
                    bill=(float) (bill+bill*0.20);
                    tvResult.setText("Total current bill="+bill+"Taka");


                }else{
                    edNumber.setError("Please enter a units.");
                }


            }
        });

    }
}