package com.example.ordolar.formulariocoursera;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    EditText nombre, telefono, email, descripcion;
    Button btn;
    DatePicker datepickerDP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombre = (EditText) findViewById(R.id.input_name);
        telefono = (EditText) findViewById(R.id.input_telefono);
        email = (EditText) findViewById(R.id.input_email);
        descripcion = (EditText) findViewById(R.id.input_descripcion);
        btn=(Button) findViewById(R.id.btn_signup);
        datepickerDP= (DatePicker) findViewById(R.id.datepickerDP);

        Bundle extras=getIntent().getExtras();
        if (extras!=null){
            nombre.setText(extras.getString("nombre",""));
            datepickerDP.updateDate(extras.getInt("annio"),extras.getInt("mes"),extras.getInt("dia"));
            telefono.setText(extras.getString("Telefono",""));
            email.setText(extras.getString("Email",""));
            descripcion.setText(extras.getString("Descripcion",""));



        }

    }

    public void siguiente(View v){
       // Log.d("FECHA",datepickerDP.getYear()+"/"+datepickerDP.getMonth()+"/"+datepickerDP.getDayOfMonth()+"");
        Intent intent=new Intent(MainActivity.this, DetallesContacto.class);

        Bundle extras=new Bundle();

        extras.putString("nombre",nombre.getText().toString());
        extras.putInt("annio",datepickerDP.getYear());
        extras.putInt("mes",datepickerDP.getMonth());
        extras.putInt("dia",datepickerDP.getDayOfMonth());
        extras.putString("Telefono",telefono.getText().toString());
        extras.putString("Email",email.getText().toString());
        extras.putString("Descripcion",descripcion.getText().toString());

        intent.putExtras(extras);
        startActivity(intent);



    }
}
