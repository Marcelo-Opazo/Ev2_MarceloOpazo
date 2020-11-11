package com.example.ev2_marceloopazo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import java.util.ArrayList;

public class Home_act extends AppCompatActivity {

    private ViewFlipper vf;
    private int[] images = {R.drawable.a,R.drawable.b,R.drawable.c};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_act);

        vf = (ViewFlipper)findViewById(R.id.slider);

        for(int i =0; i <images.length; i++)
        {
            flip_image(images[i]);
        }
    }
    public void flip_image(int i)//Slider
    {
        //vamos a dar la config del slider
        ImageView view = new ImageView(this);
        view.setBackgroundResource(i);

        vf.addView(view);// añadimos las imagene al viewflipper
        vf.setFlipInterval(2300); // su desplazamientosera de 2300 milis
        vf.setAutoStart(true); //inicia de forma automatica

        //SEntido del slider
        vf.setInAnimation(this,android.R.anim.slide_in_left);
        vf.setOutAnimation(this,android.R.anim.slide_out_right);
    }

    public void GCuentas(View v)
    {
        Intent i = new Intent(this,Clientes_act.class);
        startActivity(i);
    }
    public void CPrestamos(View v)//Listo, // Paso listas en intent.
    {
        ArrayList<String>clientes = new ArrayList<String>();
        clientes.add("AXEL");
        clientes.add("ROXANA");

        ArrayList<String>credito = new ArrayList<String>();
        credito.add("CREDITO HIPOTECARIO");
        credito.add("CREDITO AUTOMOTRIZ");

        //paso los arreglos en el intent
        Intent i = new Intent(this,Prestamos_act.class);
        i.putExtra("listaClientes",clientes);
        i.putExtra("listaCreditos",credito);
        startActivity(i);
    }
    public void Segu(View v) //listo
    {
        Intent i = new Intent(this,Seguridad_act.class);
        startActivity(i);
    }
    public void Info(View v)
    {
        Intent i = new Intent(this,Info_act.class);
        startActivity(i);
    }
}