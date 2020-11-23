package com.st.myshop;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.st.myshop.R;

public class Registrar_Usuario extends AppCompatActivity {
    AdminSQLiteOpenHelper db;
    private EditText et_correonuevo, et_nuevouser, et_nuevapass, et_confirpass;
    private Button btn_registrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar__usuario);
        db = new AdminSQLiteOpenHelper(this);
        et_correonuevo = (EditText)findViewById(R.id.txt_nuevocorreo);
        et_nuevouser = (EditText)findViewById(R.id.txt_nuevouser);
        et_nuevapass = (EditText)findViewById(R.id.txt_nuevapasswd);
        et_confirpass = (EditText)findViewById(R.id.txt_confirmpasswd);
        btn_registrar = (Button)findViewById(R.id.btn_createuser);

        btn_registrar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String s1 = et_correonuevo.getText().toString();
                String s2 = et_nuevouser.getText().toString();
                String s3 = et_nuevapass.getText().toString();
                String s4 = et_confirpass.getText().toString();
                if (s1.equals("")||s2.equals("")||s3.equals("")||s4.equals("")){
                    Toast.makeText(getApplicationContext(), "Quedan campos vacíos",Toast.LENGTH_SHORT).show();
                }
                else{
                    if (s3.equals(s4)){
                      boolean checkmail = db.checkmail(s1);
                      if(checkmail==true){
                          Boolean insert = db.insert(s1,s2,s3);
                          if (insert==true){
                              Toast.makeText(getApplicationContext(), "Registro Exitoso", Toast.LENGTH_SHORT).show();
                          }
                      }
                      else{
                          Toast.makeText(getApplicationContext(), "Tu email ya tiene cuenta registrada", Toast.LENGTH_SHORT).show();
                      }
                    }
                    else{
                        Toast.makeText(getApplicationContext(), "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}