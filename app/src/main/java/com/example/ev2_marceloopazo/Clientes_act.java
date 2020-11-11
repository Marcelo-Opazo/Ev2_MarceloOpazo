package com.example.ev2_marceloopazo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import Clases.AdminSQLiteOpenHelper;

public class Clientes_act extends AppCompatActivity {

    private EditText edC, edN, edS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clientes_act);

        edC= (EditText)findViewById(R.id.ediC); // codigo
        edN= (EditText)findViewById(R.id.ediN); //nombre
        edS= (EditText)findViewById(R.id.ediS); //Salario
    }

    //añadir Clientes
    public void AnadirCliente(View v)
    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "fichero",null,1);
        SQLiteDatabase bd = admin.getWritableDatabase(); //permito la sobrescritura en la bd

        if(!edC.getText().toString().isEmpty())
        {
            //..añade el isumo
            ContentValues registro = new ContentValues();
            registro.put("codigo",edC.getText().toString());
            registro.put("nombre",edN.getText().toString());
            registro.put("salario",edS.getText().toString());

            bd.insert("clientes",null,registro);
            bd.close();
            refresh();//metodo creado para borrar los campos

            Toast.makeText(this,"Se ha guardado un Cliente", Toast.LENGTH_LONG).show();
        }
        else
        {
            Toast.makeText(this,"Debe Ingresar un Cliente",Toast.LENGTH_LONG).show();
        }
    }
    public void MostrarCliente(View v) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "fichero", null, 1); // creo fichero
        SQLiteDatabase bd = admin.getWritableDatabase(); //permito la sobrescritura en la bd

        String codigo = edC.getText().toString();

        if (!codigo.isEmpty()) {
            //Cursor es una clase que me permite recorrer mas de una filas, todas las que recorra se guardan en el daot tipo cursor
            Cursor fila = bd.rawQuery("SELECT nombre, salario FROM clientes WHERE codigo =" + codigo, null);

            if (fila.moveToFirst()) // devuelve un resultado en caso de no encontar ninngun campo devuelve vacio
            {
                edN.setText(fila.getString(0));
                edS.setText(fila.getString(1));
            }
            else
                {
                    Toast.makeText(this, "No hay cliente con el codigo asociado", Toast.LENGTH_LONG).show();
                }
            } else {
                Toast.makeText(this, "Debes ingresar el codigo del cliente", Toast.LENGTH_SHORT).show();
            }
        }

    public void EliminarCliente(View v)
    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "fichero",null,1); // creo fichero
        SQLiteDatabase bd = admin.getWritableDatabase(); //permito la sobrescritura en la bd

        String codigo = edC.getText().toString();

        bd.delete("clientes","codigo="+codigo,null);
        bd.close();
        refresh();

        Toast.makeText(this,"Has eliminado al Cliente", Toast.LENGTH_LONG).show();
    }

    public void ActualizarCliente(View v)
    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "fichero",null,1); // creo fichero
        SQLiteDatabase bd = admin.getWritableDatabase(); //permito la sobrescritura en la bd

        String codigo = edC.getText().toString();

        ContentValues cont = new ContentValues();   //utilizo content alues para almacenar los cambios que se realizarn

        cont.put("codigo", edC.getText().toString());
        cont.put("nombre", edN.getText().toString());
        cont.put("salario", edS.getText().toString());

        if(!codigo.isEmpty())
        {
            bd.update("clientes", cont,"codigo="+ codigo,null); //Actualizo segun el codigo
            refresh();
            Toast.makeText(this,"Se ha actualizado el cliente",Toast.LENGTH_LONG).show();
        }
    }

    public void refresh()
    {
        edC.setText("");
        edN.setText("");
        edS.setText("");
    }
}