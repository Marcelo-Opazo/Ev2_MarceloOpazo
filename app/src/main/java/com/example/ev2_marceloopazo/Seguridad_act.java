package com.example.ev2_marceloopazo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.security.MessageDigest;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class Seguridad_act extends AppCompatActivity {

    private EditText ed;
    private TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seguridad_act);

        ed =(EditText)findViewById(R.id.edit);
        txt =(TextView)findViewById(R.id.text);
    }

    private SecretKeySpec generateKey(String password)throws Exception{

        MessageDigest sha= MessageDigest.getInstance("SHA-256"); //Firma hmac para verificar la integridad de dtos
        byte[] key = password.getBytes("UTF-8");// establezco cadena de bytes con standard utf-8
        key= sha.digest(key); //PAsamos la firma hmac a nuestra cadena de byte.
        SecretKeySpec secretKey = new SecretKeySpec(key,"AES");

        return secretKey;
    }

    //Metodo para encripar bajo el alogoritmo AES.
    public String Encriptar(String datos, String password)throws Exception{

        if(!ed.getText().toString().isEmpty())
        {
            //hago el encripptado de datos
            SecretKeySpec secretKey = generateKey(password);

            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE,secretKey);

            byte[] datosEncriptadosBytes = cipher.doFinal(datos.getBytes());
            String datosEncriptadosString = Base64.encodeToString(datosEncriptadosBytes,Base64.DEFAULT);
            return datosEncriptadosString;
        }
        else
        {
            Toast.makeText(this,"Debe Ingresar una Calve",Toast.LENGTH_LONG).show();
            return null;
        }
    }
    public void Encriptar(View v){
        try {
            String mensaje = Encriptar(ed.getText().toString(), txt.getText().toString());
            txt.setText(mensaje);
        }catch(Exception e) {

            e.printStackTrace();
        }
    }
}