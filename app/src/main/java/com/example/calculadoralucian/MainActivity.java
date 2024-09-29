package com.example.calculadoralucian;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView tvResult, tvError;
    private StringBuilder currentInput;
    private Operations operations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicializar los elementos
        tvResult = findViewById(R.id.tvResult);
        tvError = findViewById(R.id.tvError);
        currentInput = new StringBuilder();
        operations = new Operations();

        // Asignar listener a todos los botones
        setButtonListeners();
    }

    private void setButtonListeners() {
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = v.getId();

                if (id == R.id.button0 || id == R.id.button1 || id == R.id.button2 ||
                        id == R.id.button3 || id == R.id.button4 || id == R.id.button5 ||
                        id == R.id.button6 || id == R.id.button7 || id == R.id.button8 ||
                        id == R.id.button9) {

                    // Capturar los botones numéricos
                    Button button = (Button) v;
                    currentInput.append(button.getText().toString());
                    tvResult.setText(currentInput.toString());

                } else if (id == R.id.buttonPlus) {
                    // Capturar botón de suma
                    currentInput.append("+");
                    tvResult.setText(currentInput.toString());

                } else if (id == R.id.buttonMinus) {
                    // Capturar botón de resta
                    currentInput.append("-");
                    tvResult.setText(currentInput.toString());

                } else if (id == R.id.buttonEquals) {
                    // Capturar botón de igual y realizar la operación
                    String result = operations.doOperation(currentInput.toString());
                    if (result.equals("ERROR")) {
                        tvError.setVisibility(View.VISIBLE);
                    } else {
                        tvResult.setText(result);
                    }
                    currentInput.setLength(0); // Limpiar input
                }

                tvError.setVisibility(View.GONE); // Ocultar error al pulsar cualquier botón
            }
        };

        // Asignar el listener a cada botón
        findViewById(R.id.button0).setOnClickListener(listener);
        findViewById(R.id.button1).setOnClickListener(listener);
        findViewById(R.id.button2).setOnClickListener(listener);
        findViewById(R.id.button3).setOnClickListener(listener);
        findViewById(R.id.button4).setOnClickListener(listener);
        findViewById(R.id.button5).setOnClickListener(listener);
        findViewById(R.id.button6).setOnClickListener(listener);
        findViewById(R.id.button7).setOnClickListener(listener);
        findViewById(R.id.button8).setOnClickListener(listener);
        findViewById(R.id.button9).setOnClickListener(listener);
        findViewById(R.id.buttonPlus).setOnClickListener(listener);
        findViewById(R.id.buttonMinus).setOnClickListener(listener);
        findViewById(R.id.buttonEquals).setOnClickListener(listener);
    }
}
