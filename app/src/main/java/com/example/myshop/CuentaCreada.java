package com.example.myshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class CuentaCreada extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuenta_creada);
    }

    //aqui van los metodos
    //metodo botón ok
    public void cuentaCreada(View view){
        Intent cuentacreada = new Intent(this, MainActivity.class);
        startActivity(cuentacreada);
    }

}