package com.st.myshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.st.myshop.R;

public class Productos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productos);
    }

    public void DetalleProducto(View view){
        Intent detalleProducto = new Intent(this, DetalleProducto.class);
        startActivity(detalleProducto);

    }
}