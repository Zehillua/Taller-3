package Dominio;

public class Entrega {
    
    private int codigo;
    private String tipo;
    private String rutRemitente;
    private String rutDestinatario;

    public Entrega(int codigo, String tipo, String rutRemitente, String rutDestinatario) {
        this.codigo = codigo;
        this.tipo = tipo;
        this.rutRemitente = rutRemitente;
        this.rutDestinatario = rutDestinatario;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getRutRemitente() {
        return rutRemitente;
    }

    public void setRutRemitente(String rutRemitente) {
        this.rutRemitente = rutRemitente;
    }

    public String getRutDestinatario() {
        return rutDestinatario;
    }

    public void setRutDestinatario(String rutDestinatario) {
        this.rutDestinatario = rutDestinatario;
    }
    
    
}
