package Dominio;

public class EntregaE extends Entrega {
    
    private double gramos;
    private double largo;
    private double ancho;
    private double profundidad;
    private double valor;

    
    public EntregaE(int codigo, String tipo, String rutRemitente, String rutDestinatario, double gramos,
            double largo, double ancho, double profundidad, double valor) {
        super(codigo, tipo, rutRemitente, rutDestinatario);
        this.gramos = gramos;
        this.largo = largo;
        this.ancho = ancho;
        this.profundidad = profundidad;
        this.valor = valor;
    }


    public double getGramos() {
        return gramos;
    }


    public void setGramos(double gramos) {
        this.gramos = gramos;
    }


    public double getLargo() {
        return largo;
    }


    public void setLargo(double largo) {
        this.largo = largo;
    }


    public double getAncho() {
        return ancho;
    }


    public void setAncho(double ancho) {
        this.ancho = ancho;
    }


    public double getProfundidad() {
        return profundidad;
    }


    public void setProfundidad(double profundidad) {
        this.profundidad = profundidad;
    }

    public double getValor(){
        return valor;
    }

    public void setValor(double valor){
        this.valor = valor;
    }

    public double valorEntrega(){
        double valor = 0;
        valor = (this.getGramos()/1000)*(this.getAncho()*this.getLargo()*this.getProfundidad())*50;
        return valor;
    }
    
    
}
