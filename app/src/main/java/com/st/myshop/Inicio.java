package com.st.myshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.st.myshop.R;

public class Inicio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
    }


    public void Productos(View view) {
        Intent productos = new Intent(this, Productos.class);
        startActivity(productos);

    }

    public void AdminProductos(View view) {
        Intent adminprod = new Intent(this, AdminProductos.class);
        startActivity(adminprod);
    }
}