package com.example.temperature2s;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText temperatureEditText;
    private Button celsiusButton, fahrenheitButton, kelvinButton;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        temperatureEditText = findViewById(R.id.temperatureEditText);
        celsiusButton = findViewById(R.id.celsiusButton);
        fahrenheitButton = findViewById(R.id.fahrenheitButton);
        kelvinButton = findViewById(R.id.kelvinButton);
        resultTextView = findViewById(R.id.resultTextView);

        celsiusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertCelsius();
            }
        });

        fahrenheitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertFahrenheit();
            }
        });

        kelvinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertKelvin();
            }
        });
    }

    private void convertCelsius() {
        double temperature = Double.parseDouble(temperatureEditText.getText().toString());

        double fahrenheit = (temperature * 9/5) + 32;
        double kelvin = temperature + 273.15;

        String result = String.format("Fahrenheit: %.2f\nKelvin: %.2f", fahrenheit, kelvin);
        resultTextView.setText(result);
    }

    private void convertFahrenheit() {
        double temperature = Double.parseDouble(temperatureEditText.getText().toString());

        double celsius = (temperature - 32) * 5/9;
        double kelvin = (temperature - 32) * 5/9 + 273.15;

        String result = String.format("Celsius: %.2f\nKelvin: %.2f", celsius, kelvin);
        resultTextView.setText(result);
    }

    private void convertKelvin() {
        double temperature = Double.parseDouble(temperatureEditText.getText().toString());

        double celsius = temperature - 273.15;
        double fahrenheit = (temperature - 273.15) * 9/5 + 32;

        String result = String.format("Celsius: %.2f\nFahrenheit: %.2f", celsius, fahrenheit);
        resultTextView.setText(result);
    }
}
