package com.example.ev2_marceloopazo;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText edN, edC;
    private ProgressBar pb1;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edN = (EditText)findViewById(R.id.ed1);
        edC = (EditText)findViewById(R.id.ed2);
        pb1 = (ProgressBar)findViewById(R.id.pb);
        btn = (Button)findViewById(R.id.bt);

        //-----------------------------------------
        // acciones async

        pb1.setVisibility(View.INVISIBLE);//lo hago invisible
        btn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                new Task().execute();
            }
        });

    }

    //Actividades Async
    class Task extends AsyncTask<String, Void, Void>
    {
        @Override
        protected void onPreExecute() {             //Inicio de tarea
            if (edN.getText().toString().equals("android") | edN.getText().toString().equals("ANDROID")){

                if ((edC.getText()).toString().equals("123"))
                {

                   pb1.setVisibility(View.VISIBLE);

                }
            }
        }

        @Override
        protected Void doInBackground(String... strings) {        //DEsarroollo tarea

            if (edN.getText().toString().equals("android") | edN.getText().toString().equals("ANDROID")){

                if ((edC.getText()).toString().equals("123"))
                {

                    for (int i = 1; i <= 10; i++) //ciclo para definir cuanto dura la tarea async
                    {
                        try {
                            Thread.sleep(200);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }

                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void s) {//que pasa despues de mi tarea


            if (edN.getText().toString().equals("android") | edN.getText().toString().equals("ANDROID")) {
                if (edC.getText().toString().equals("123")) {

                    Intent i =new Intent(getBaseContext(),Home_act.class);
                    startActivity(i);
                }
                else{
                    edC.setText("Contraseña incorrecta");
                }

            } else {

                edN.setText("Usuario Incorrecto");

            }


        }
    }
}