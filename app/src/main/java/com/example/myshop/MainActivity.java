package com.example.myshop;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText et_correo, et_clave;
    private Button btn_login, btn_signup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_correo = (EditText)findViewById(R.id.txt_correo);
        et_clave = (EditText)findViewById(R.id.txt_clave);
        btn_login =(Button)findViewById(R.id.btn_login);
        btn_signup =(Button)findViewById(R.id.btn_signup);




    }
    public void CrearCuenta(View view){
        Intent crearcuenta = new Intent(this, Registrar_Usuario.class);
        startActivity(crearcuenta);

    }
}