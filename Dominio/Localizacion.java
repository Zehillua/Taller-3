package Dominio;
import java.util.*;
import Logica.ListaEntregas;
public class Localizacion {
    
    private String ciudad;
    private List<Cliente>lClientes;
    private ListaEntregas lEntregas;


    public Localizacion(String ciudad) {
        this.ciudad = ciudad;
        lClientes = new LinkedList<>();
    }

    public String getCiudad() {
        return ciudad;
    }

    public List<Cliente> getlClientes() {
        return lClientes;
    }

    public ListaEntregas getlEntregas() {
        return lEntregas;
    }
    
}
