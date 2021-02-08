package com.example.canvas;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class cGrafico extends View {
    //... atributos
    private String aFigura, aTexto= "";
    private float[] aPuntos;
    //... constructor
    protected cGrafico(Context context, String pFigura){
        super(context);
        aFigura= pFigura;
    }
    protected cGrafico(Context context, String pFigura, float[] pPuntos){
        //... este constructo es para mueve la pelota
        super(context);
        aFigura= pFigura;
        aPuntos= pPuntos;
    }
    public void onDraw(Canvas canvas){
        canvas.drawRGB(255, 255, 255);
        Paint pintar= new Paint();
        //... dibujar figuras
        if(aFigura.equals("Linea")){ dibujarLinea(pintar, canvas); }
        if(aFigura.equals("Rectangulo")){ dibujarRectangulo(pintar, canvas); }
        if(aFigura.equals("Rectangulo Relleno")){ dibujarRectanguloR(pintar, canvas); }
        if(aFigura.equals("Arco")){ dibujarArco(pintar, canvas); }
        if(aFigura.equals("Arco Relleno")){ dibujarArcoR(pintar, canvas); }
        if(aFigura.equals("Circulo")){ dibujarCirculo(pintar, canvas); }
        if(aFigura.equals("Circulo Relleno")){ dibujarCirculoR(pintar, canvas); }
        if(aFigura.equals("Triangulo")){ dibujarTriangulo(pintar, canvas); }
        if(aFigura.equals("Texto")){ dibujarTexto(pintar, canvas); }
        if(aFigura.equals("Mueve la pelota")){ dibujarJuego(pintar, canvas); }
    }
    //... metodos privados
    private void dibujarLinea(Paint pPintar, Canvas pCanvas){
        pPintar.setStrokeWidth(5);
        pPintar.setColor(Color.BLUE);
        pCanvas.drawLine(aPuntos[0], aPuntos[1], aPuntos[2], aPuntos[3], pPintar);
    }
    private void dibujarRectangulo(Paint pPintar, Canvas pCanvas){
        pPintar.setStyle(Paint.Style.STROKE);
        pPintar.setStrokeWidth(5);
        pPintar.setColor(Color.GREEN);
        pCanvas.drawRect(aPuntos[0],aPuntos[1],aPuntos[2]-aPuntos[0],aPuntos[3]-aPuntos[1], pPintar);
    }
    private void dibujarRectanguloR(Paint pPintar, Canvas pCanvas){
        pPintar.setStrokeWidth(5);
        pPintar.setColor(Color.RED);
        pCanvas.drawRect(aPuntos[0],aPuntos[1],aPuntos[2]-aPuntos[0],aPuntos[3]-aPuntos[1], pPintar);
    }
    private void dibujarArco(Paint pPintar, Canvas pCanvas){
        pPintar.setStyle(Paint.Style.STROKE);
        pPintar.setStrokeWidth(5);
        pPintar.setColor(Color.CYAN);
        pCanvas.drawArc(aPuntos[0],aPuntos[1],aPuntos[2]-aPuntos[0],aPuntos[3]-aPuntos[1],0,270,false,pPintar);
    }
    private void dibujarArcoR(Paint pPintar, Canvas pCanvas){
        pPintar.setStrokeWidth(5);
        pPintar.setColor(Color.MAGENTA);
        pCanvas.drawArc(aPuntos[0],aPuntos[1],aPuntos[2]-aPuntos[0],aPuntos[3]-aPuntos[1],0,270,false,pPintar);
    }
    private void dibujarCirculo(Paint pPintar, Canvas pCanvas){
        pPintar.setStyle(Paint.Style.STROKE);
        pPintar.setStrokeWidth(5);
        pPintar.setColor(Color.GRAY);
        pCanvas.drawCircle(aPuntos[0], aPuntos[1],aPuntos[2],pPintar);
    }
    private void dibujarCirculoR(Paint pPintar, Canvas pCanvas){
        pPintar.setStrokeWidth(5);
        pPintar.setColor(Color.YELLOW);
        pCanvas.drawCircle(aPuntos[0], aPuntos[1],aPuntos[2],pPintar);
    }
    private void dibujarTriangulo(Paint pPintar, Canvas pCanvas){
        pPintar.setStyle(Paint.Style.STROKE);
        pPintar.setStrokeWidth(5);
        pPintar.setColor(Color.BLACK);
        pCanvas.drawLines(aPuntos, pPintar);
    }
    private void dibujarTexto(Paint pPintar, Canvas pCanvas){
        pPintar.setTextSize(50);
        pPintar.setARGB(255, 255, 0, 255);
        pCanvas.drawText(aTexto, aPuntos[0], aPuntos[1], pPintar);
    }
    private void dibujarJuego(Paint pPintar, Canvas pCanvas){
        pPintar.setStyle(Paint.Style.STROKE);
        pPintar.setStrokeWidth(4);
        pPintar.setARGB(255, 255, 0, 0);
        pCanvas.drawCircle(aPuntos[0],aPuntos[1], 20, pPintar);
    }
    //... metodo modificador
    public void cargarDatos(String pTexto, float[] pPuntos){
        aTexto= pTexto;
        aPuntos= pPuntos;
    }
    public void coordenada(int pCodX, int pCordY){
        aPuntos[0]= pCodX; aPuntos[1]= pCordY;
    }
    //... selectores
    public String figura(){ return aFigura; }
}