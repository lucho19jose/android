package com.example.canvas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class dato extends AppCompatActivity {
    //... atributos
    private Spinner aFigura;
    private EditText aX0, aY0, aX1, aY1, aX2, aY2, aTexto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dato);
        //... establecer enlace
        aFigura= findViewById(R.id.spFigura);
        aX0= findViewById(R.id.etPunto1x); aY0= findViewById(R.id.etPunto1y);
        aX1= findViewById(R.id.etPunto2x); aY1= findViewById(R.id.etPunto2y);
        aX2= findViewById(R.id.etPunto3x); aY2= findViewById(R.id.etPunto3y);
        aTexto= findViewById(R.id.etTexto);
        //... cargar estados
        cargarEstados();
    }
    private void cargarEstados() {
        ArrayAdapter<String> fg = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item);
        fg.add("Linea"); fg.add("Rectangulo"); fg.add("Rectangulo Relleno");
        fg.add("Arco"); fg.add("Arco Relleno");
        fg.add("Circulo"); fg.add("Circulo Relleno");
        fg.add("Triangulo"); fg.add("Texto");
        fg.add("Mueve la pelota");
        aFigura.setAdapter(fg);
    }
    public void siguiente(View view){
        //... recuperar Spinner
        String figura= aFigura.getSelectedItem().toString();
        //... abrir siguiente ventana
        Intent sig;
        if(figura.equals("Mueve la pelota"))
            sig= new Intent(this, lienzo.class);
        else
            sig= new Intent(this, lienzo.class);
        //... lanzar datos a siguiente ventana
        sig.putExtra("figura", figura);
        //... pasar datos
        if(figura.equals("Linea") || figura.equals("Rectangulo") || figura.equals("Rectangulo Relleno")){
            float[] datos= new float[]{Float.parseFloat(aX0.getText().toString()), Float.parseFloat(aY0.getText().toString()),
                    Float.parseFloat(aX1.getText().toString()), Float.parseFloat(aY1.getText().toString())};
            sig.putExtra("datos", datos);
        }
        if(figura.equals("Arco") || figura.equals("Arco Relleno")){
            float[] datos= new float[]{Float.parseFloat(aX0.getText().toString()), Float.parseFloat(aY0.getText().toString()),
                    Float.parseFloat(aX1.getText().toString()), Float.parseFloat(aY1.getText().toString())};
            sig.putExtra("datos", datos);
        }
        if(figura.equals("Circulo") || figura.equals("Circulo Relleno")){
            float[] datos= new float[]{Float.parseFloat(aX0.getText().toString()), Float.parseFloat(aY0.getText().toString()),
                    Float.parseFloat(aX1.getText().toString())};
            sig.putExtra("datos", datos);
        }
        if(figura.equals("Triangulo")){
            float[] datos= new float[]{Float.parseFloat(aX0.getText().toString()), Float.parseFloat(aY0.getText().toString()),
                    Float.parseFloat(aX1.getText().toString()), Float.parseFloat(aY1.getText().toString()),
                    Float.parseFloat(aX1.getText().toString()), Float.parseFloat(aY1.getText().toString()),
                    Float.parseFloat(aX2.getText().toString()), Float.parseFloat(aY2.getText().toString()),
                    Float.parseFloat(aX2.getText().toString()), Float.parseFloat(aY2.getText().toString()),
                    Float.parseFloat(aX0.getText().toString()), Float.parseFloat(aY0.getText().toString()) };
            sig.putExtra("datos", datos);
        }
        if(figura.equals("Texto")){
            sig.putExtra("texto", aTexto.getText().toString());
            float[] datos= new float[]{Float.parseFloat(aX0.getText().toString()), Float.parseFloat(aY0.getText().toString())};
            sig.putExtra("datos", datos);
        }
        if(figura.equals("Mueve la pelota")){
            float[] datos= new float[]{Float.parseFloat(aX0.getText().toString()), Float.parseFloat(aY0.getText().toString())};
            sig.putExtra("datos", datos);
        }
        startActivity(sig);
        finish();
    }
    public void salir(View view){ finish(); }
}