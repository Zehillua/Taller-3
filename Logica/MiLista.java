package Logica;

import Dominio.Entrega;

public interface MiLista {

    public void add(Entrega e);

    public int size();

    public Entrega get(int i);

    public boolean isEmpty();

}
