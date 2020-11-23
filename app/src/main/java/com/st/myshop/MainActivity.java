package com.st.myshop;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.st.myshop.R;

public class MainActivity extends AppCompatActivity {
    final private int REQUEST_CODE_ASK_PERMISSION=111;
    AdminSQLiteOpenHelper db;
    private EditText et_correo, et_clave;
    private Button btn_login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        solicitarPermisos();

        db= new AdminSQLiteOpenHelper(this);
        et_correo = (EditText)findViewById(R.id.txt_correo);
        et_clave = (EditText)findViewById(R.id.txt_clave);
        btn_login =(Button)findViewById(R.id.btn_login);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override



            public void onClick(View v) {
                    String email = et_correo.getText().toString();
                    String password = et_clave.getText().toString();
                    Boolean Chkemailpass = db.emailpassword(email, password);
                    if (Chkemailpass==true) {
                        Toast.makeText(getApplicationContext(), "Sesión iniciada", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(MainActivity.this, Inicio.class));
                    }
                    else {
                        Toast.makeText(getApplicationContext(), "Fallo en E-mail o Contraseña", Toast.LENGTH_SHORT).show();
                    }


            }
        });




    }
    private void solicitarPermisos(){
        int permisoLocation = ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.ACCESS_FINE_LOCATION);
        if(permisoLocation!=PackageManager.PERMISSION_GRANTED){
            if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M){
                requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION},REQUEST_CODE_ASK_PERMISSION);
            }
        }
    }

    public void CrearCuenta(View view){
        Intent crearcuenta = new Intent(this, Registrar_Usuario.class);
        startActivity(crearcuenta);

    }


}