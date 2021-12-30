package Logica;
import Dominio.Entrega;
public class NodoEntrega {
    
    private Entrega e;
    private NodoEntrega next;
    private NodoEntrega prev;

    public NodoEntrega(Entrega e){
        this.e = e;
        this.next = null;
        this.prev = null;
    }

    public Entrega getEntrega(){
        return e;
    }

    public NodoEntrega getNext(){
        return next;
    }

    public void setNext(NodoEntrega next){
        this.next = next;
    }

    public NodoEntrega getPrev(){
        return prev;
    }

    public void setPrev(NodoEntrega prev){
        this.prev = prev;
    } 

}
