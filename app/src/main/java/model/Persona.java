package model;

public class Persona {
    private String Nombre;
    private String Apellidos;
    private String Email;
    private String Cargo;
    private int Edad;
    private double Salario;

    public Persona(){

    }
    public Persona(String nombre, String apellidos, String email, String cargo, int edad, double salario) {
        Nombre = nombre;
        Apellidos = apellidos;
        Edad = edad;
        Email = email;
        Cargo = cargo;
        Salario = salario;
    }
    public String getNombre()
    {
        return Nombre;
    }

    public void setNombre(String nombre)
    {
        Nombre = nombre;
    }
    public String getApellidos()
    {
        return Apellidos;
    }

    public void setApellidos(String apellidos)
    {
        Apellidos = apellidos;
    }
    public String getEmail()
    {
        return Email;
    }
    public void setEmail(String email)
    {
        Email = email;
    }
    public String getCargo()
    {
        return Cargo;
    }
    public void setCargo(String cargo)
    {
        Cargo = cargo;
    }
    public int getEdad()
    {
        return Edad;
    }

    public void setEdad(int edad)
    {
        Edad = edad;
    }
    public double getSalario()
    {
        return Salario;
    }
    public void setSalario(double salario)
    {
        Salario = salario;
    }

}
