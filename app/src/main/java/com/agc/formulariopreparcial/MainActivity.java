package com.agc.formulariopreparcial;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.ib.custom.toast.CustomToastView;
import com.omarshehe.forminputkotlin.FormInputText;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import model.Persona;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private FormInputText nombre;
    private FormInputText apellidos;
    private FormInputText edad;
    private FormInputText email;
    private FormInputText cargo;
    private FormInputText salario;
    private Button btnregistrar;
    public static List<Persona> Lista = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombre = findViewById(R.id.Nombre);
        apellidos =findViewById(R.id.Apellido);
        edad = findViewById(R.id.Edad);
        email = findViewById(R.id.Email);
        cargo = findViewById(R.id.Cargo);
        salario = findViewById(R.id.Salario);
        btnregistrar= findViewById(R.id.btnregistrar);

        btnregistrar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
            if(v.getId()== R.id.btnregistrar) {

            String Nombre = nombre.getValue();
            String Apellido = apellidos.getValue();
            int Edad = Integer.parseInt(edad.getValue());
            String Email = email.getValue();
            String Cargo = cargo.getValue();
            int Salario = Integer.parseInt(salario.getValue());

            //variables de obtencion de datos de la funcion persona
            persona(Nombre,Apellido,Edad,Email,Cargo,Salario);


        }

    }

    //validar caracteres del email con el Pattern que viene por defecto en android
    private Boolean isValidEmail(String email){
        Pattern pattern = Patterns.EMAIL_ADDRESS;
        return  pattern.matcher(email).matches();

    }
    public void persona(String Nombre,String Apellido,int Edad,String Email,String Cargo,int Salario ){
        if(Nombre.equals("")){
            CustomToastView.makeErrorToast(this,"Error al validar el nombre",R.layout.custom_toast).show();
            return;
        }
        if(Apellido.equals("")){
            CustomToastView.makeInfoToast(this,"Error al validar el Apellido",R.layout.custom_toast).show();
            return;
        }
        if(Edad==0){
            CustomToastView.makeInfoToast(this,"Error al validar la edad ",R.layout.custom_toast).show();
            return;
        }
        if(isValidEmail(Email)== false){
            CustomToastView.makeWarningToast(this,"Error al validar el Email",R.layout.custom_toast).show();
            return;
        }
        if(Cargo.equals("")){
            CustomToastView.makeInfoToast(this,"Error al validar el cargo",R.layout.custom_toast).show();
            return;
        }
        if(Salario==0){
            CustomToastView.makeInfoToast(this,"Error al validar la salario ",R.layout.custom_toast).show();
            return;
        }
        //instanciar clase
        Persona persona= new Persona(Nombre,Apellido,Email,Cargo,Edad,Salario);
        this.Lista.add(persona);

        nombre.setValue("");
        apellidos.setValue("");
        email.setValue("");
        cargo.setValue("");
        edad.setValue("");
        salario.setValue("");


        Intent myIntent = new Intent(this, consultas.class);
        startActivity(myIntent);



    }

}