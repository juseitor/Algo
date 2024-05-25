package aed;

import java.util.*;

public class ListaEnlazada<T> implements Secuencia<T> {
    
    private LinkedList<T> lista;

    private class Nodo {
        // Completar
    }

    public ListaEnlazada() {
        this.lista = new LinkedList<>();
    }

    public int longitud() {
        return lista.size();
    }

    public void agregarAdelante(T elem) {
        lista.addFirst(elem);
    }

    public void agregarAtras(T elem) {
        lista.addLast(elem);
    }

    public T obtener(int i) {
        return lista.get(i);
    }

    public void eliminar(int i) {
        lista.remove(i);
    }

    public void modificarPosicion(int indice, T elem) {
        lista.set(indice,elem);
    }

    public ListaEnlazada<T> copiar() {
        ListaEnlazada<T> copiaLista = new ListaEnlazada<>();
        copiaLista.lista.addAll(lista);
        return copiaLista;
    }

    public ListaEnlazada(ListaEnlazada<T> lista) {
        this.lista = new LinkedList<>();
        for (int i = 0; i < lista.longitud(); i++) {
            this.lista.add(lista.obtener(i));
        }
    }
     
    @Override
    public String toString() {
        StringBuffer sbuffer = new StringBuffer();
        sbuffer.append("[");
        for (int i=0; i<lista.size()-1; i++){
        sbuffer.append(lista.get(i));
        sbuffer.append(", ");
        }
        sbuffer.append(lista.get(lista.size()-1));
        sbuffer.append("]");
        return sbuffer.toString();
    }

    private class ListaIterador implements Iterador<T> {
    	// Completar atributos privados

        public boolean haySiguiente() {
	        throw new UnsupportedOperationException("No implementada aun");
        }
        
        public boolean hayAnterior() {
	        throw new UnsupportedOperationException("No implementada aun");
        }

        public T siguiente() {
	        throw new UnsupportedOperationException("No implementada aun");
        }
        

        public T anterior() {
	        throw new UnsupportedOperationException("No implementada aun");
        }
    }

    public Iterador<T> iterador() {
	    throw new UnsupportedOperationException("No implementada aun");
    }

}
