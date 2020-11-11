package com.example.ev2_marceloopazo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

import Clases.Clientes;
import Clases.Creditos;

public class Prestamos_act extends AppCompatActivity {


    private Spinner spinC, SpinCre;
    private TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prestamos_act);

        spinC=(Spinner)findViewById(R.id.spinClientes);
        SpinCre=(Spinner)findViewById(R.id.spinCredito);

        txt=(TextView)findViewById(R.id.text);

        //recibo arreglo.
        ArrayList<String>listaClientes = (ArrayList<String>)getIntent().getSerializableExtra("listaClientes");
        ArrayList<String>listaCreditos = (ArrayList<String>)getIntent().getSerializableExtra("listaCreditos");

        ArrayAdapter<String> cliente = new ArrayAdapter(this,android.R.layout.simple_list_item_1,listaClientes);
        ArrayAdapter<String> credito = new ArrayAdapter(this,android.R.layout.simple_list_item_1,listaCreditos);
        spinC.setAdapter(cliente);
        SpinCre.setAdapter(credito);
    } // traigo de menu y asigno a spinner listas,

    public void CalcularPrestamo(View v)
    {
        Creditos cre = new Creditos();
        Clientes cli = new Clientes();

        String clientes = spinC.getSelectedItem().toString();
        String creditos = SpinCre.getSelectedItem().toString();

        int cAxel = Integer.parseInt(cli.getAxel());
        int cRoxana = Integer.parseInt(cli.getRoxana());//Recibo clientes y los convierto a entero

        int crHip = Integer.parseInt(cre.getcH());
        int crAut = Integer.parseInt(cre.getcA());



        if (clientes.equals("AXEL") && creditos.equals("CREDITO AUTOMOTRIZ"))
        {
            int res1 = cAxel + crAut;
            txt.setText("El monto total de su prestamo es:" + res1);
        }
        else if(clientes.equals("AXEL") && creditos.equals("CREDITO HIPOTECARIO") )
        {
            int res2 = cAxel + crHip;
            txt.setText("El monto total de su prestamo es:" + res2);
        }

        if(clientes.equals("ROXANA") && creditos.equals("CREDITO AUTOMOTRIZ"))
        {
            int res3 =cRoxana + crAut;
            txt.setText("El monto total de su prestamo es:" + res3);
        }
        else if(clientes.equals("ROXANA") && creditos.equals("CREDITO HIPOTECARIO"))
        {
            int res4 = cRoxana + crHip;
            txt.setText("El monto total de su prestamo es:" + res4);
        }

    }


    public void CalcularCuota(View v)
    {
        Creditos cre = new Creditos();
        Clientes cli = new Clientes();

        String clientes = spinC.getSelectedItem().toString();
        String creditos = SpinCre.getSelectedItem().toString();

        int cAxel = Integer.parseInt(cli.getAxel());
        int cRoxana = Integer.parseInt(cli.getRoxana());//Recibo clientes y los convierto a entero

        int crHip = Integer.parseInt(cre.getcH());
        int crAut = Integer.parseInt(cre.getcA());



        if (clientes.equals("AXEL") && creditos.equals("CREDITO AUTOMOTRIZ"))
        {
            int res1 = cAxel + crAut;
            int cuotA = res1 / 8;
            txt.setText("El monto de cada cuota es:" + cuotA);
        }
        else if(clientes.equals("AXEL") && creditos.equals("CREDITO HIPOTECARIO") )
        {
            int res2 = cAxel + crHip;
            int cuot = res2 / 12;
            txt.setText("El monto de cada cuota es:" + cuot);
        }

        if(clientes.equals("ROXANA") && creditos.equals("CREDITO AUTOMOTRIZ"))
        {
            int res3 =cRoxana + crAut;
            int cuotA2 = res3 / 8;
            txt.setText("El monto de cada cuota es:" + cuotA2);
        }
        else if(clientes.equals("ROXANA") && creditos.equals("CREDITO HIPOTECARIO"))
        {
            int res4 = cRoxana + crHip;
            int cuot2 = res4 / 12;
            txt.setText("El monto de cada cuota es:" + cuot2);
        }

    }

}