package com.st.myshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.st.myshop.R;

public class DetalleProducto extends AppCompatActivity {
    private Button btn_puntoencuentro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_producto);
        btn_puntoencuentro = (Button) findViewById(R.id.btn_puntoencuentro);
        btn_puntoencuentro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), PuntoEncuentro.class);
                startActivity(intent);
            }
        });
    }
}