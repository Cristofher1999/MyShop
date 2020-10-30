package com.example.myshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prueba_sensor);

        }
    public void MainActivity(View view){
        Intent mainact = new Intent(this, PruebaSensor.class);
        startActivity(mainact);
    }
}