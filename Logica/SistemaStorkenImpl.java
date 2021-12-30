package Logica;
import java.util.*;
import Dominio.*;
public class SistemaStorkenImpl implements SistemaStorken{
    
    private ListaEntregas listaEntregas;
    private List<Cliente> lClientes;
    private List<Localizacion>lLocalizaciones;

    public SistemaStorkenImpl(){
        lClientes = new LinkedList<>();
        listaEntregas = new ListaEntregas();
        lLocalizaciones = new ArrayList<>();
    }


    @Override
    public void ingresarCliente(String rut, String nombre, String apellido, double saldo, String ciudad) {
        Cliente c = new Cliente(rut, nombre, apellido, saldo, ciudad);
        lClientes.add(c);
        for(int i=0;i<lLocalizaciones.size();i++){
            Localizacion l = lLocalizaciones.get(i);
            if(l.getCiudad().equals(ciudad)){
                l.getlClientes().add(c);
            }
        }
        
    }

    @Override
    public void ingresarEntregaD(int codigo, String tipo, String rutRemitente, String rutDestinatario, double valor,
            double gramos, double grosor) {
        EntregaD eD = new EntregaD(codigo, tipo, rutRemitente, rutDestinatario, valor, gramos, grosor);
        listaEntregas.add(eD);
        for(Cliente cliente : lClientes){
            if(cliente.getRut().equals(rutRemitente) || cliente.getRut().equals(rutDestinatario)){
                cliente.getlEntregas().add(eD);
            }
        }
    }

    @Override
    public void ingresarEntregaE(int codigo, String tipo, String rutRemitente, String rutDestinatario, double valor,
            double gramos, double largo, double ancho, double profundidad) {
        EntregaE eE = new EntregaE(codigo, tipo, rutRemitente, rutDestinatario, valor, gramos, largo, ancho, profundidad);
        listaEntregas.add(eE);
        for(Cliente cliente : lClientes){
            if(cliente.getRut().equals(rutRemitente) || cliente.getRut().equals(rutDestinatario)){
                cliente.getlEntregas().add(eE);
            }
        }
    }

    @Override
    public void ingresarEntregaV(int codigo, String tipo, String rutRemitente, String rutDestinatario, double valor,
            String material, double peso) {
        EntregaV eV = new EntregaV(codigo, tipo, rutRemitente, rutDestinatario, valor, material, peso);
        listaEntregas.add(eV);
        for(Cliente cliente : lClientes){
            if(cliente.getRut().equals(rutRemitente) || cliente.getRut().equals(rutDestinatario)){
                cliente.getlEntregas().add(eV);
            }
        }
    }

    @Override
    public void ingresarLocalizacion(String ciudad) {
        Localizacion l = new Localizacion(ciudad);
        lLocalizaciones.add(l);
        
    }

    @Override
    public boolean confirmarRut(String rut) {
        for(Cliente cliente : lClientes){
            if(cliente.getRut().equals(rut)){
                return true;
            }
        }
        return false;
    }

    @Override
    public String obtenerEntregas(String rut) {
        String salida = "";
        for(Cliente cliente : lClientes){
            if(cliente.getRut().equals(rut)){
                for(int i=0;i<listaEntregas.size();i++){
                    Entrega e = listaEntregas.get(i);
                    if(rut.equals(e.getRutDestinatario())){
                        salida = salida+"Entregas recibidas: ";
                        salida = salida+"Codigo de entrega: "+e.getCodigo()+", tipo de entrega: "+e.getTipo()+", rut del que le envio la entrega: "+e.getRutRemitente();
                    }
                    if(rut.equals(e.getRutRemitente())){
                        salida = salida+"Entregas enviadas: ";
                        salida = salida+"Codigo de entrega: "+e.getCodigo()+", tipo de entrega: "+e.getTipo()+", rut al que le envio la entrega: "+e.getRutDestinatario();
                    }
                }
            }
        }
        return salida;
    }

    @Override
    public String obtenerEntregasClientes() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String obtenerEntregasLocalizacion() {
        String salida = "";    
        return salida;
    }

    @Override
    public String obtenerEntregasTipo() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void realizarEntrega(String rut) {
        
        
    }

    @Override
    public void recargarSaldo(String rut, double saldo) {
        for(Cliente cliente : lClientes){
            if(cliente.getRut().equals(rut)){
                cliente.setSaldo(cliente.getSaldo()+saldo);
                System.out.println("Su saldo ahora es de $"+cliente.getSaldo());
            }
        }
        
    }

    @Override
    public void registroGanancias() {
        
        
    }

    @Override
    public String sobrescrituraArcgEntregas() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String sobrescrituraArchClientes() {
        // TODO Auto-generated method stub
        return null;
    }

    
}
