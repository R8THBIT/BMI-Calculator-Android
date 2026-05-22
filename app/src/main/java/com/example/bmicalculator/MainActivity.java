package com.example.bmicalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText etWeight, etHeight;
    private Button btnCalculate;
    private LinearLayout resultLayout;
    private TextView tvBmiScore, tvBmiStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etWeight = findViewById(R.id.etWeight);
        etHeight = findViewById(R.id.etHeight);
        btnCalculate = findViewById(R.id.btnCalculate);
        resultLayout = findViewById(R.id.resultLayout);
        tvBmiScore = findViewById(R.id.tvBmiScore);
        tvBmiStatus = findViewById(R.id.tvBmiStatus);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateBMI();
            }
        });
    }

    private void calculateBMI() {
        String weightStr = etWeight.getText().toString();
        String heightStr = etHeight.getText().toString();

        if (weightStr.isEmpty() || heightStr.isEmpty()) {
            Toast.makeText(this, "Please enter weight and height", Toast.LENGTH_SHORT).show();
            return;
        }

        float weight = Float.parseFloat(weightStr);
        float height = Float.parseFloat(heightStr);

        float bmi = weight / (height * height);

        tvBmiScore.setText(String.format("%.1f", bmi));

        if (bmi < 18.5) {
            tvBmiStatus.setText("You are underweight.");
        } else if (bmi >= 18.5 && bmi < 24.9) {
            tvBmiStatus.setText("You are a healthy weight!");
        } else if (bmi >= 25 && bmi < 29.9) {
            tvBmiStatus.setText("You are overweight.");
        } else {
            tvBmiStatus.setText("You are in the obese range.");
        }

        resultLayout.setVisibility(View.VISIBLE);
    }
}