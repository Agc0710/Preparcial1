package com.agc.formulariopreparcial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import id.ionbit.ionalert.IonAlert;
import model.Persona;

public class consultas extends AppCompatActivity implements View.OnClickListener{

    private Button btnpersonajoven;
    private Button btnpersonamayor;
    private Button btncargo;
    private Button btnsalario;
    private Button btnsalarioalto;
    private Button btnpromedio;
    private Button btnatras;
    public static List<Persona> Lista = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultas);


        btnpersonajoven = findViewById(R.id.btnpersonajoven);
        btnpersonamayor = findViewById(R.id.btnmayoredad);
        btncargo = findViewById(R.id.btncargo);
        btnsalario = findViewById(R.id.btnsalariobajo);
        btnsalarioalto = findViewById(R.id.btnsalarioalto);
        btnpromedio = findViewById(R.id.btnPromedio);
        btnatras = findViewById(R.id.btnatrás);


        btnpersonajoven.setOnClickListener(this);
        btnpersonamayor.setOnClickListener(this);
        btncargo.setOnClickListener(this);
        btnsalario.setOnClickListener(this);
        btnsalarioalto.setOnClickListener(this);
        btnpromedio.setOnClickListener(this);
        btnatras.setOnClickListener(this);
        MainActivity Main = new MainActivity();
        Lista = Main.Lista;

    }

    @Override
    public void onClick(View v) {
        if(v.getId()== R.id.btnpersonajoven){
            personajoven();

        }
        else if (v.getId()== R.id.btnmayoredad){
            personamayor();
        }
        else if(v.getId()== R.id.btnsalariobajo){
            salarioMenor();
        }
        else if (v.getId()== R.id.btnsalarioalto){
            salarioMayor();
        }
        else if (v.getId()== R.id.btnPromedio){
            Promediosalario();
        }
        if(v.getId()== R.id.btnatrás){
            Intent myIntent = new Intent(this, MainActivity.class);
            startActivity(myIntent);

        }


    }

    private void personajoven() {
        int joven = 999999999;
        String Fullname= "";
        for(int j= 0; j<this.Lista.size();j++){
            if (this.Lista.get(j).getEdad()<joven){
                joven= this.Lista.get(j).getEdad();
                Fullname=this.Lista.get(j).getNombre() + " " + Lista.get(j).getApellidos();
            }

        }
        new IonAlert(this).setTitleText("La persona más joven es: " + Fullname).show();
    }
    private void personamayor() {
        int mayor = 0;
        String Fullname= "";
        for(int j= 0; j<this.Lista.size();j++){
            if (this.Lista.get(j).getEdad()>mayor){
                mayor= this.Lista.get(j).getEdad();
                Fullname=this.Lista.get(j).getNombre() + " " + Lista.get(j).getApellidos();
            }

        }
        new IonAlert(this).setTitleText("La persona mayor es:" + Fullname).show();
    }
    private void salarioMenor() {
        int Smenor = 999999999;
        String Fullname = "";
        int salarioM = 0;

        for (int j = 0; j < this.Lista.size(); j++) {
            if (this.Lista.get(j).getSalario() < Smenor) {

                Smenor = (int) this.Lista.get(j).getSalario();
                Fullname = this.Lista.get(j).getNombre() + " " + Lista.get(j).getApellidos();
                salarioM = (int) this.Lista.get(j).getSalario();
            }

        }
        new IonAlert(this).setTitleText("La persona menor es: " + Fullname + "Salario: " + salarioM).show();

    }

        private void salarioMayor(){
        int Smayor = 0;
        String Fullname= " ";
        int salarioM= 0;

        for(int j= 0; j<this.Lista.size();j++){
            if (this.Lista.get(j).getSalario()>Smayor){

                Smayor= (int) this.Lista.get(j).getSalario();
                Fullname=this.Lista.get(j).getNombre() + " " + Lista.get(j).getApellidos();
                salarioM = (int) this.Lista.get(j).getSalario();
            }

        }
        new IonAlert(this).setTitleText("La persona mas alto es:" + Fullname + " Salario: "+ salarioM).show();

    }
    private void Promediosalario(){
        int sumaSalario= 0;
        double promedioS = 0.0;
        for (int j= 0; j<this.Lista.size();j++){

            sumaSalario= (int) (sumaSalario + this.Lista.get(j).getSalario());
        }
        promedioS= (sumaSalario/this.Lista.size());
        new IonAlert(this).setTitleText("El promedio del salario mas alto y mas bajo  es: " + promedioS ).show();

    }




}