package Logica;

public interface SistemaStorken {
    
    public void ingresarLocalizacion(String ciudad);

    public void ingresarCliente(String rut, String nombre, String apellido, double saldo, String ciudad);

    public void ingresarEntregaD(int codigo, String tipo, String rutRemitente, String rutDestinatario, double valor, double gramos,
    double grosor);

    public void ingresarEntregaE(int codigo, String tipo, String rutRemitente, String rutDestinatario, double valor, double gramos,
    double largo, double ancho, double profundidad);

    public void ingresarEntregaV(int codigo, String tipo, String rutRemitente, String rutDestinatario, double valor, String material,
    double peso);

    public boolean confirmarRut(String rut);

    public void realizarEntrega(String rut);

    public void recargarSaldo(String rut, double saldo);

    public String obtenerEntregas(String rut);

    public String obtenerEntregasTipo();

    public String obtenerEntregasLocalizacion();

    public String obtenerEntregasClientes();

    public void registroGanancias();

    public String sobrescrituraArchClientes();

    public String sobrescrituraArcgEntregas();

}
