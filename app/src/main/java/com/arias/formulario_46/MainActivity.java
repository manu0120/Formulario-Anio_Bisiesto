package com.arias.formulario_46;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    //Añadimos los atributos de los tipos de controles introducidos:

    //botones
    public Button aleatorioBoton;
    public Button comprobarBoton;
    //TextView
    public TextView aleatorioTexto;
    public TextView bisiesto;
    public TextView comprobarTexto;
    //RadioButton
    public RadioButton bisiestoSi;
    public RadioButton bisiestoNo;
    //switch
    public Switch swFondoAmarillo;
    //ConstraintLayout
    public ConstraintLayout layout;

    //otros atributos
    public int numAleatorio=0;
    public boolean esBisiesto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //asignar a cada variable el control diseñado anteriormente (en el layout)
        aleatorioBoton=(Button) findViewById(R.id.btnAleatorio);
        comprobarBoton=(Button) findViewById(R.id.btnComprobar);

        aleatorioTexto=(TextView) findViewById(R.id.tvNumAleatorio);
        comprobarTexto=(TextView) findViewById(R.id.tvResultado);
        bisiesto=(TextView) findViewById(R.id.tvBisiesto);

        bisiestoSi=(RadioButton) findViewById(R.id.rbOption1);
        bisiestoNo=(RadioButton) findViewById(R.id.rbOption2);

        swFondoAmarillo =(Switch) findViewById(R.id.swFondo);

        layout=(ConstraintLayout) findViewById(R.id.layout);
    }

    public void generarNumAleatorio(View view){
        Random ran=new Random();
        numAleatorio=ran.nextInt(600)+1900;
//        numAleatorio= (int) (Math.random()*(2500-1900));
//        System.out.println(numAleatorio);
        aleatorioTexto.setText(" "+numAleatorio);
    }

    public void comprobarBisiesto(View view) {
        //comprobamos primeramente si el numero es bisiesto o no
        if ( ( ( numAleatorio % 4 == 0 ) && ( numAleatorio % 100 != 0 ) ) || ( numAleatorio % 400 == 0 ) ) {
            esBisiesto=true;
//            System.out.println( "El año " + numAleatorio + " es bisiesto.");
        }else {
            esBisiesto=false;
//            System.out.println( "El año " + numAleatorio + " no es bisiesto.");
        }

        //comprobamos que radiobutton está marcado
        if (!bisiestoSi.isChecked() && !bisiestoNo.isChecked()){
//            comprobarTexto.setText("Debes marcar alguna de las opciones");
            Toast.makeText(MainActivity.this, "Debes marcar unas de las opciones", Toast.LENGTH_LONG).show();
        }
        if (bisiestoSi.isChecked()){
            if (esBisiesto){
                comprobarTexto.setText("Correcto!");
                comprobarTexto.setTextColor(Color.GREEN);
            }else{
                comprobarTexto.setText("Error!");
                comprobarTexto.setTextColor(Color.RED);
            }
        }
        if (bisiestoNo.isChecked()){
            if (esBisiesto){
                comprobarTexto.setText("Error!");
                comprobarTexto.setTextColor(Color.RED);
            }else{
                comprobarTexto.setText("Correcto!");
                comprobarTexto.setTextColor(Color.GREEN);
            }
        }
    }

    public void switchBackground(View view) {
        if(swFondoAmarillo.isChecked()){
            layout.setBackgroundColor(Color.YELLOW);
        }else{
            layout.setBackgroundColor(Color.WHITE);
        }
    }
}