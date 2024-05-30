package aed;

import java.util.*;

public class ListaEnlazada<T> implements Secuencia<T> {
    
    private LinkedList<T> lista;
//    private Nodo primerNodo;
//    private Nodo ultimoNodo;
//    private int longitud;
//
//    private class Nodo {
//        T valor;
//        Nodo siguiente;
//        Nodo anterior;
//    }

    public ListaEnlazada() {
        this.lista = new LinkedList<>();
//    primerNodo = null;
//    ultimoNodo = null;
//    longitud = 0;
    }

    public int longitud() {
        return lista.size();
//        return longitud;
    }

    public void agregarAdelante(T elem) {
        lista.addFirst(elem);
//        Nodo NuevoNodo = new Nodo();
//        NuevoNodo.valor = elem;
//        if (longitud == 0){
//            NuevoNodo.siguiente = null;
//            NuevoNodo.anterior = primerNodo;
//            ultimoNodo = NuevoNodo;
//        }if (longitud == 1){
//            NuevoNodo.siguiente = ultimoNodo;
//            NuevoNodo.anterior = null;
//            primerNodo = NuevoNodo;
//        }else{
//            NuevoNodo.siguiente = primerNodo;
//            NuevoNodo.anterior = null;
//            primerNodo = NuevoNodo;
//        }
//        longitud ++;
    }

    public void agregarAtras(T elem) {
        lista.addLast(elem);
//        Nodo nuevoNodo = new Nodo();
//        nuevoNodo.valor = elem;
//        nuevoNodo.siguiente = null;
//        nuevoNodo.anterior = ultimoNodo;
//        if (ultimoNodo == null) {
//            primerNodo = nuevoNodo;
//            ultimoNodo = nuevoNodo; // Añadimos esta línea para asegurarnos de que ultimoNodo también se actualice
//        } else {
//            ultimoNodo.siguiente = nuevoNodo;
//            ultimoNodo = nuevoNodo; // Solo actualizamos ultimoNodo
//        }
//        longitud++;
    }

    public T obtener(int i) {
        return lista.get(i);
//        Nodo actual = primerNodo;
//        for (int j=0; j<i; j++){
//            actual = actual.siguiente;
//        }
//        return actual.valor;
    }

    public void eliminar(int i) {
        lista.remove(i);
//        Nodo nodoAEliminar = null;
//        if (i == 0) { // Eliminar el primer nodo
//            nodoAEliminar = primerNodo;
//            primerNodo = nodoAEliminar.siguiente;
//            if (primerNodo != null) {
//                primerNodo.anterior = null;
//            } else { // Si la lista solo tenía un elemento
//                ultimoNodo = null;
//            }
//        } else if (i == longitud - 1) { // Eliminar el último nodo
//            nodoAEliminar = ultimoNodo;
//            ultimoNodo = nodoAEliminar.anterior;
//            if (ultimoNodo != null) {
//                ultimoNodo.siguiente = null;
//            } else { // Si la lista solo tenía un elemento
//                primerNodo = null;
//            }
//        } else { // Eliminar un nodo en medio de la lista
//            Nodo nodoActual = primerNodo;
//            for (int j = 0; j < i; j++) {
//               nodoActual = nodoActual.siguiente;
//            }
//        nodoAEliminar = nodoActual;
//        nodoActual.anterior.siguiente = nodoActual.siguiente;
//        nodoActual.siguiente.anterior = nodoActual.anterior;
//        }
//        longitud--;
    }
    
    public void modificarPosicion(int indice, T elem) {
        lista.set(indice, elem);
    }

    public ListaEnlazada<T> copiar() {
        ListaEnlazada<T> copiaLista = new ListaEnlazada<>();
        copiaLista.lista.addAll(this.lista);
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

        private int posicion;

        public boolean haySiguiente() {
	        return posicion != lista.size();
        }
        
        public boolean hayAnterior() {
	        return posicion != 0;
        }

        public T siguiente() {
	        int dedito = posicion;
            posicion++;
            return obtener(dedito);
        }
        

        public T anterior() {
	        int dedito = posicion - 1;
            posicion --;
            return obtener(dedito);
        }
    }

    public Iterador<T> iterador() {
	    ListaIterador nuevo = new ListaIterador();
        nuevo.posicion = 0;
        return nuevo;
    }
}
