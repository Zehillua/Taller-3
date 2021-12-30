package Dominio;

public class EntregaV extends Entrega{
    
    private String material;
    private double peso;

    
    public EntregaV(int codigo, String tipo, String rutRemitente, String rutDestinatario, double valor, String material,
            double peso) {
        super(codigo, tipo, rutRemitente, rutDestinatario);
        this.material = material;
        this.peso = peso;
    }


    public String getMaterial() {
        return material;
    }


    public void setMaterial(String material) {
        this.material = material;
    }


    public double getPeso() {
        return peso;
    }


    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double valorEntrega(){
        double valor = 0;
        if(this.material.equals("Tela")){
            valor = (100*this.getPeso()*150);
        }
        if(this.material.equals("Cuero")){
            valor =(200*this.getPeso()*150);
        }
        if(this.material.equals("Plastico")){
            valor = (150*(this.getPeso()/1000)*150);
        }
        return valor;
    }
    
}
