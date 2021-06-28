package com.example.crickettemperature;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    EditText etNumber;
    TextView tvResults;
    Button btnCalculate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNumber = findViewById(R.id.etNumber);
        tvResults = findViewById(R.id.tvResults);
        tvResults.setVisibility(View.GONE);
        btnCalculate = findViewById(R.id.btnCalculate);
        DecimalFormat formatter;

        formatter = new DecimalFormat("#0.00");

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(etNumber.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this,"Please enter data!!", Toast.LENGTH_SHORT).show();
                }
                else{
                    int chirps = Integer.parseInt(etNumber.getText().toString().trim());
                    double tempC = (chirps / 3.0) + 4;
                    double tempF = chirps + 40;
                    String results = "The approximate temperature outside is " + "\n" + formatter.format(tempC) + " degrees Celsius" + "\n" + formatter.format(tempF) + " degrees Fahrenheit";
                    tvResults.setText(results);
                    tvResults.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}