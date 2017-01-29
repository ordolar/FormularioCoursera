package com.example.ordolar.formulariocoursera;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class DetallesContacto extends AppCompatActivity {

    TextView msgTV;
    TextView tefnoTV;
    TextView mailTV;
    TextView descTV;
    TextView fechaTV;
    int value4,value5, value6;
    String value, value1, value2, value3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles_contacto);



        Bundle extras=getIntent().getExtras();//obtengo el intent que ha ocasionado que ésto aparezca
        value=extras.getString("nombre");
        value1=extras.getString("Telefono");
        value2=extras.getString("Email");
        value3=extras.getString("Descripcion");
        value4=extras.getInt("annio");
        value5=extras.getInt("mes");
        value6=extras.getInt("dia");

        msgTV=(TextView)findViewById(R.id.nombreTV);
        tefnoTV=(TextView)findViewById(R.id.tefnoTV);
        mailTV=(TextView)findViewById(R.id.mailTV);
        descTV=(TextView)findViewById(R.id.descTV);
        fechaTV=(TextView)findViewById(R.id.fechaTV);

        msgTV.setText("Nombre de contacto: "+value);
        tefnoTV.setText("Telefono: "+value1);
        mailTV.setText("Email: "+value2);
        descTV.setText("Descripcion: "+value3);
        fechaTV.setText("Fecha de nacimiento: "+value6+"/"+(value5+1)+"/"+value4);
    }




    public void atras(View v){
        Intent intent=new Intent(DetallesContacto.this, MainActivity.class);
        Bundle extras=new Bundle();
        extras.putString("nombre",value);
        extras.putString("Telefono",value1);
        extras.putString("Email",value2);
        extras.putString("Descripcion",value3);
        extras.putString("annio", String.valueOf(value4));
        extras.putString("mes",String.valueOf(value5));
        extras.putString("dia",String.valueOf(value6));
        intent.putExtras(extras);
        startActivity(intent);
    }
}
