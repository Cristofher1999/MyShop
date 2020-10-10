package com.example.myshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class CrearCuenta extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_cuenta);
    }
    //boton crear cuenta
    public void Crear_Cuenta(View view){
        Intent crearcuenta = new Intent(this, CuentaCreada.class);
        startActivity(crearcuenta);
    }
}