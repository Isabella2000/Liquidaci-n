package com.example.liquidacion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {
    private TextView tvNV, tvAV, tvCV, tvSV, tvDV;
    private TextView tvVD, tvDE, tvSA, tvPE, tvSB, tvSN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        tvNV= (TextView)findViewById(R.id.tvNV);
        String dato = getIntent().getStringExtra("dato");
        tvNV.setText(dato);

        tvAV= (TextView)findViewById(R.id.tvAV);
        String apellido = getIntent().getStringExtra("apellido");
        tvAV.setText(apellido);

        tvCV= (TextView)findViewById(R.id.tvCV);
        String cargo = getIntent().getStringExtra("cargo");
        tvCV.setText(cargo);

        tvSV= (TextView)findViewById(R.id.tvSV);
        String sueldo = getIntent().getStringExtra("sueldo");
        tvSV.setText(sueldo);

        tvDV= (TextView)findViewById(R.id.tvDV);
        String dias = getIntent().getStringExtra("dias");
        tvDV.setText(dias);

        tvVD= (TextView)findViewById(R.id.tvVD);
        String valorxdia = getIntent().getStringExtra("valorxdia");
        tvVD.setText(valorxdia);

        tvSB= (TextView)findViewById(R.id.tvSB);
        String sueldoBruto = getIntent().getStringExtra("sueldoBruto");
        tvSB.setText(sueldoBruto);

        tvDE= (TextView)findViewById(R.id.tvDE);
        String resultadoDescuento = getIntent().getStringExtra("resultadoDescuento");
        tvDE.setText(resultadoDescuento);

        tvSA= (TextView)findViewById(R.id.tvSA);
        String resultadoSalud = getIntent().getStringExtra("resultadoSalud");
        tvSA.setText(resultadoSalud);

        tvPE= (TextView)findViewById(R.id.tvPE);
        String resultadoPension = getIntent().getStringExtra("resultadoPension");
        tvPE.setText(resultadoPension);

        tvSN= (TextView)findViewById(R.id.tvSN);
        String sueldoDescontado = getIntent().getStringExtra("sueldoDescontado");
        tvSN.setText(sueldoDescontado);

        //tvVD= (TextView)findViewById(R.id.tvVD);
        //tvVD.setText(tvDV*tvSV);

    }

    public static double todouble(String sueldo) {
        return Double.parseDouble(sueldo);
    }

    public static int toInt(String dias) {
        return Integer.parseInt(dias);
    }


    public void regresar(View view){
        Intent i = new Intent(this, MainActivity2.class);
        startActivity(i);
    }
}