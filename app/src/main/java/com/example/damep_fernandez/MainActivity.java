package com.example.damep_fernandez;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {


    private EditText documentoEditText;
    private EditText contrasenaEditText;
    private Button loginButton;
    private Button createAccountButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Inicializar los elementos de la UI
        documentoEditText = findViewById(R.id.documentoEditText);
        contrasenaEditText = findViewById(R.id.contrasenaEditText);
        loginButton = findViewById(R.id.Ingresarbtn);
        createAccountButton = findViewById(R.id.crearbtn);


        // Agregar TextWatchers para habilitar el botón cuando ambos campos están llenos
        documentoEditText.addTextChangedListener(textWatcher);
        contrasenaEditText.addTextChangedListener(textWatcher);


        // Acción para el botón Ingresar
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Se envió sus datos", Toast.LENGTH_SHORT).show();
            }
        });


        // Acción para el botón Crear Cuenta
        createAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Crear cuenta presionado", Toast.LENGTH_SHORT).show();
            }
        });
    }


    private TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {}


        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            loginButton.setEnabled(!documentoEditText.getText().toString().trim().isEmpty() &&
                    !contrasenaEditText.getText().toString().trim().isEmpty());
        }


        @Override
        public void afterTextChanged(Editable s) {}
    };
}



