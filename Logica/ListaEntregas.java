package Logica;
import Dominio.Entrega;
public class ListaEntregas implements MiLista{
    
    private NodoEntrega first;
    private int size = 0;

    public ListaEntregas(){
        first = new NodoEntrega(null);
    }

    @Override
    public void add(Entrega e) {
        NodoEntrega nuevo = new NodoEntrega(e);
        if(isEmpty()){
            first = nuevo;
            first.setNext(first);
            first.setPrev(first);
        }else{
            NodoEntrega current = first.getPrev();
            nuevo.setPrev(current);
            current.setNext(nuevo);
            first.setPrev(nuevo);
            nuevo.setNext(first);
            first = nuevo;
        }
        size++;
        
    }

    @Override
    public Entrega get(int i) {
        if(i<0 || i>size){
            throw new IndexOutOfBoundsException("Indice fuera del rango");
        }
        NodoEntrega current = first;
        while(current.getNext()!= null){
            if(i==0){
                return current.getEntrega();
            }
            i-=1;
            current = current.getNext();
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    

}
