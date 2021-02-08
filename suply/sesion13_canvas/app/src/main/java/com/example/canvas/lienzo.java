package com.example.canvas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class lienzo extends AppCompatActivity {
    //... atributo
    private cGrafico aGrafico;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lienzo);
        //... establecer enlaces
        ConstraintLayout lienzo= findViewById(R.id.clLienzo);
        aGrafico= new cGrafico(this, getIntent().getStringExtra("figura"));
        //... recuperar datos
        recuperarDatos();
        lienzo.addView(aGrafico);
    }
    private void recuperarDatos(){
        if(aGrafico.figura().equals("Texto"))
            aGrafico.cargarDatos(getIntent().getStringExtra("texto"), getIntent().getFloatArrayExtra("datos"));
        else
            aGrafico.cargarDatos("", getIntent().getFloatArrayExtra("datos"));
    }
    public void anterior(View view){
        Intent ant= new Intent(this, dato.class);
        startActivity(ant);
        finish();
    }
}