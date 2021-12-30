package Dominio;

import Logica.ListaEntregas;

public class Cliente{
    
    private String rut;
    private String nombre;
    private String apellido;
    private double saldo;
    private String ciudad;
    private ListaEntregas lEntregas;


    public Cliente(String rut, String nombre, String apellido, double saldo, String ciudad) {
        this.rut = rut;
        this.nombre = nombre;
        this.apellido = apellido;
        this.saldo = saldo;
        this.ciudad = ciudad;
        lEntregas = new ListaEntregas();
    }

    public String getRut() {
        return rut;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getCiudad() {
        return ciudad;
    }

    public ListaEntregas getlEntregas() {
        return lEntregas;
    }
    
}