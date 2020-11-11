package com.example.ev2_marceloopazo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

public class Info_act extends AppCompatActivity {

    private VideoView videoV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_act);

        videoV =(VideoView)findViewById(R.id.vd);

        //asigno al videovie
        String ruta = "android.resource://"+ getPackageName() +"/" + R.raw.video; //asigno el video view atrves de la ruta donde se encuentra el video y lo almaceno en mivariable
        // tipo String ruta (la R es porque nos dirigimos a al carpeta resource)

        Uri uri = Uri.parse(ruta);// le decimos al constaint donde tiene se tiene que direccionar
        videoV.setVideoURI(uri);// para hcer que nuestro video se reprodusca

        //Controles del video
        MediaController media = new MediaController(this);// ocupamos la clase media controller para asingar los controles del video y declaramos como objeto
        videoV.setMediaController(media);
    }

    public void Maps(View v)
    {
        Intent i = new Intent(this,Maps_act.class);
        startActivity(i);
    }

}