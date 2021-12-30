package Dominio;

public class EntregaD extends Entrega{

    private double gramos;
    private double grosor;
    private double valor;

    
    public EntregaD(int codigo, String tipo, String rutRemitente, String rutDestinatario, double valor, double gramos,
            double grosor) {
        super(codigo, tipo, rutRemitente, rutDestinatario);
        this.gramos = gramos;
        this.grosor = grosor;
        this.valor = valor;
    }


    public double getGramos() {
        return gramos;
    }


    public void setGramos(double gramos) {
        this.gramos = gramos;
    }


    public double getGrosor() {
        return grosor;
    }


    public void setGrosor(double grosor) {
        this.grosor = grosor;
    }
    
    public double getValor(){
        return valor;
    }

    public void setValor(double valor){
        this.valor = valor;
    }

    public double valorEntrega(){
        double valor = 0;
        valor = (this.getGramos()/1000)*this.getGrosor()*100;
        return valor;
    }
    

}
