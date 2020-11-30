package com.st.myshop;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.st.myshop.Producto;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class AdminProductos extends AppCompatActivity {
    EditText txtRun, txtNom, txtNum, txtCiudad;
    Button btnIn, btnElim, btnBusc, btnAct;

    FirebaseDatabase FBData;
    DatabaseReference DBReference,DBMostrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_productos);
        txtRun = (EditText) findViewById(R.id.txtRu);
        txtNom = (EditText) findViewById(R.id.txtNo);
        txtCiudad = (EditText) findViewById(R.id.txtCi);
        txtNum = (EditText) findViewById(R.id.txtNu);

        btnIn = (Button) findViewById(R.id.button_ING);
        btnIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ID = txtRun.getText().toString().trim().toUpperCase();
                String NOMBRE = txtNom.getText().toString().trim().toUpperCase();
                String TIPO = txtCiudad.getText().toString().trim().toUpperCase();
                String PRECIO = txtNum.getText().toString().trim().toUpperCase();
                if(ID.equals("")||NOMBRE.equals("")||TIPO.equals("")||PRECIO.equals(""))
                {
                    validar();
                }
                else {
                    Producto P = new Producto();
                    P.setRun(ID);
                    P.setTipo(TIPO);
                    P.setNombre(NOMBRE);
                    P.setPrecio(PRECIO);
                    DBReference.child("Producto").child(P.getID()).setValue(P);
                    Toast.makeText(AdminProductos.this, "GUARDANDO PRODUCTO!!!!!", Toast.LENGTH_LONG).show();
                    limpiar();
                }
            }
        });


        btnElim = (Button) findViewById(R.id.button_ELIM);
        btnElim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ID = txtRun.getText().toString().trim().toUpperCase();
                if(ID.equals(""))
                {
                    validar();
                }
                else {
                    DBReference.child("Producto").child(ID).removeValue();
                    Toast.makeText(AdminProductos.this, "ELIMINANDO PRODUCTO!!!!!", Toast.LENGTH_LONG).show();
                    limpiar();
                }
            }
        });

        btnBusc = (Button) findViewById(R.id.button_Cons);
        btnBusc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final int[] cont = {0};
                DatabaseReference bbdd = FirebaseDatabase.getInstance().getReference("Producto");
                /*DBMostrar = FirebaseDatabase.getInstance().getReference().child("Persona");
                DBMostrar.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if(snapshot.exists()) {
                            Toast.makeText(MainActivity.this, "ACA", Toast.LENGTH_LONG).show();
                            String RUN = txtRun.getText().toString().trim().toUpperCase();
                            for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                                Persona miP = snapshot.getValue(Persona.class);
                                if (miP.getRun().equals(RUN)) {
                                    txtNom.setText(miP.getNombre());
                                    txtCiudad.setText(miP.getCiudad());
                                    txtNum.setText(miP.getNUmero());
                                    break;
                                }
                            }
                        }

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

                */
                String ID = txtRun.getText().toString().trim().toUpperCase();
                Query q=bbdd.orderByChild("id").equalTo(ID);

                /*
                q.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        int cont=0;
                        for(DataSnapshot datasnapshot: dataSnapshot.getChildren()){
                            cont++;
                            Toast.makeText(MainActivity.this, "He encontrado "+cont, Toast.LENGTH_LONG).show();

                            Persona td =dataSnapshot.getValue(Persona.class);


                            System.out.println(td.getRun());



                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
                */
                q.addChildEventListener(new ChildEventListener() {
                    @Override
                    public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String previousChildName) {

                        for(DataSnapshot datasnapshot: dataSnapshot.getChildren()){
                            cont[0]++;
                            System.out.println(dataSnapshot.getValue());

                            Producto miP = dataSnapshot.getValue(Producto.class);
                            txtNom.setText(miP.getNombre().toString());
                            txtCiudad.setText(miP.getTipo().toString());
                            txtNum.setText(miP.getPrecio().toString());
                            Toast.makeText(AdminProductos.this, "PRODUCTO ENCONTRADO!!! ", Toast.LENGTH_LONG).show();
                            break;
                        }
                    }

                    @Override
                    public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

                    }

                    @Override
                    public void onChildRemoved(@NonNull DataSnapshot snapshot) {

                    }

                    @Override
                    public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

                if(cont[0] ==0)
                {
                    Toast.makeText(AdminProductos.this, "NO EXISTE ESE PRODUCTO!!! ", Toast.LENGTH_LONG).show();
                }
            }




        });


        btnAct = (Button) findViewById(R.id.button_UPD);
        btnAct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(AdminProductos.this, "ACTUALIZANDO PRODUCTO!!!!!", Toast.LENGTH_LONG).show();
            }
        });

        iniciar_firebase();

    } // FIN ONCREATE

    private void iniciar_firebase() {
        FirebaseApp.initializeApp(this);
        this.FBData = FirebaseDatabase.getInstance();
        this.DBReference = this.FBData.getReference();
    }

    private void limpiar() {
        this.txtRun.setText("");
        this.txtNom.setText("");
        this.txtCiudad.setText("");
        this.txtNum.setText("");
    }

    private void validar() {
        if(txtRun.getText().toString().equals(""))
        {
            txtRun.setError("Escriba ID");
        }
        if(txtNom.getText().toString().equals(""))
        {
            txtNom.setError("Escriba Nombre");
        }
        if(txtCiudad.getText().toString().equals(""))
        {
            txtCiudad.setError("Escriba Tipo");
        }
        if(txtNum.getText().toString().equals(""))
        {
            txtNum.setError("Escriba Precio");
        }

    }


}