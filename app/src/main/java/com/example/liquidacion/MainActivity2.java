package com.example.liquidacion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {


    private EditText etN, etA, etC, etS, etD;
    private CheckBox cbS, cbD, cbP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        etA= (EditText)findViewById(R.id.etA);
        etN= (EditText)findViewById(R.id.etN);
        etC= (EditText)findViewById(R.id.etC);
        etS= (EditText)findViewById(R.id.etS);
        etD= (EditText)findViewById(R.id.etD);
        cbS= (CheckBox)findViewById(R.id.cbS);
        cbD= (CheckBox)findViewById(R.id.cbD);
        cbP= (CheckBox)findViewById(R.id.cbP);

    }

    public void  enviar(View view){
        String valorS = etS.getText().toString();
        String valorD = etD.getText().toString();

        int valorS2= Integer.parseInt(valorS);
        int valorD2= Integer.parseInt(valorD);

        String resultado="";
        String resultado2="";
        int mes=30;
        int valorxdia= valorS2/mes;
        int sueldoBruto=valorD2*valorxdia;
        resultado = ""+valorxdia;
        resultado2= ""+sueldoBruto;

        //Servicios
        double sueldoNeto=0;
        double subtotal=0;
        String resultadoDescuento="";
        if (cbD.isChecked()==true){
            double porcentajeDescuento=0.03d;
            double restaDescuento= sueldoBruto*porcentajeDescuento;
            double descuento= sueldoBruto-restaDescuento;
            sueldoNeto+= subtotal+porcentajeDescuento;
            resultadoDescuento=""+descuento;
        }else{
            resultadoDescuento="No";
        }

        String resultadoSalud="";
        if (cbS.isChecked()==true){
            double porcentajeSalud=0.04d;
            double restaSalud= sueldoBruto*porcentajeSalud;
            double salud= sueldoBruto-restaSalud;
            sueldoNeto+= subtotal+porcentajeSalud;
            resultadoSalud=""+salud;
        }else{
            resultadoSalud="no";
        }

        String resultadoPension="";
        if (cbP.isChecked()==true){
            double porcentajePension=0.04d;
            double restaPension= sueldoBruto*porcentajePension;
            double pension= sueldoBruto-restaPension;
            sueldoNeto+= subtotal+porcentajePension;
            resultadoPension=""+pension;
        }else{
            resultadoPension="No";
        }

        double sueldoDescontado= subtotal-sueldoNeto;

        Intent i = new Intent(this, MainActivity3.class);
        i.putExtra("dato", etN.getText().toString());
        i.putExtra("apellido", etA.getText().toString());
        i.putExtra("cargo", etC.getText().toString());
        i.putExtra("sueldo", etS.getText().toString());
        i.putExtra("dias", etD.getText().toString());
        i.putExtra("descuento", cbD.isChecked());
        i.putExtra("salud", cbS.isChecked());
        i.putExtra("pension", cbP.isChecked());
        i.putExtra("valorxdia",resultado);
        i.putExtra("sueldoBruto",resultado2);
        i.putExtra("resultadoDescuento",resultadoDescuento);
        i.putExtra("resultadoSalud",resultadoSalud);
        i.putExtra("resultadoPension",resultadoPension);
        i.putExtra("sueldoDescontado",sueldoDescontado);
        startActivity(i);
    }

    public void regresar(View view){
        Intent i = new Intent(MainActivity2.this, MainActivity.class);
        startActivity(i);
    }
}