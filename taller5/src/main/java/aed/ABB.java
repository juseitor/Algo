package aed;

import java.util.*;

// Todos los tipos de datos "Comparables" tienen el método compareTo()
// elem1.compareTo(elem2) devuelve un entero. Si es mayor a 0, entonces elem1 > elem2
public class ABB<T extends Comparable<T>> implements Conjunto<T> {
    // Agregar atributos privados del Conjunto

    private Nodo _raiz;
    private int _cardinal;

    private class Nodo {
        // Agregar atributos privados del Nodo
        T dato;
        Nodo padre;
        Nodo izq;
        Nodo der;
        // Crear Constructor del nodo
        public Nodo(T valor){
            this.dato = valor;
            this.padre = null;
            this.izq = null;
            this.der = null;
        }
    }

    public ABB() {
        this._raiz = null;
        this._cardinal = 0;
    }

    public int cardinal() {
        return this._cardinal;
    }

    public T minimo(){
        if(this._raiz == null){
            return null;
        }else{
            Nodo aux = this._raiz;
            return minimoRecursivo(aux);
        }
    }

    public T minimoRecursivo(Nodo actual) {
        if (actual.izq == null){
            return actual.dato;
        }
        return minimoRecursivo(actual.izq);
    }

    public T maximo(){
        if(_raiz == null){
            return null;
        }else{
            return maximoRecursivo(_raiz);
        }
    }

    public T maximoRecursivo(Nodo actual) {
        if (actual.der == null){
            return actual.dato;
        }else{
            return maximoRecursivo(actual.der);
        }
    }

    public void insertar(T elem){
        // Nodo NuevoNodo = new Nodo();
        // NuevoNodo.valor = elem;
        // if (_cardinal == 0){
        //     NuevoNodo.padre = null;
        //     NuevoNodo.izq = null;
        //     NuevoNodo.der = null;
        //     this._raiz = NuevoNodo;
        //     _cardinal ++;
        //     _altura ++;
        // } if (_cardinal == 1){
        //     if (NuevoNodo.valor > _raiz.valor){

        //     }
        //}
        if (!pertenece(elem)){
            Nodo NuevoNodo = new Nodo(elem);
            insertarNodo(NuevoNodo);
            _cardinal ++;
        } else {
            return;
        }
    }

    public void insertarNodo(Nodo NuevoNodo) {
        Nodo actual = this._raiz;
        Nodo variante = null;
        while (actual != null) {
            variante = actual;
            if (NuevoNodo.dato.compareTo(actual.dato) > 0){
                actual = actual.der;
            } else {
                actual = actual.izq;
            }
        }
        NuevoNodo.padre = variante;
        if (variante == null) {
            this._raiz = NuevoNodo;
        } else if (NuevoNodo.dato.compareTo(variante.dato) < 0) {
            variante.izq = NuevoNodo;
        } else {
            variante.der = NuevoNodo;
        }
    }

    public boolean pertenece(T elem){
        return busquedaRecursiva(elem, _raiz);
    }

    public boolean busquedaRecursiva(T elem, Nodo actual) {
        if (actual == null){
            return false;
        }

        if (actual.dato.equals(elem)){
            return true;
        }
        // el parentesis de abajo es la unica diferencia con el punto hecho nota de abajo, y si no hago eso no funciona
        if ((actual.dato).compareTo(elem) > 0){
            return busquedaRecursiva(elem, actual.izq);
        } 
        else{
            return busquedaRecursiva(elem, actual.der);
        }
    }
//        if (actual == null) {
//            return false;
//        } if (actual.dato == elem){
//            return true;
//        }
//        if (actual.dato.compareTo(elem) > 0){
//            return busquedaRecursiva(elem, actual.izq);
//        } else {
//            return busquedaRecursiva(elem, actual.der);
//        }
//    }

    public void eliminar(T elem){
        // busqueda
        Nodo actual = this._raiz;
        while (actual != null && !actual.dato.equals(elem)) {
            if (elem.compareTo(actual.dato) > 0) {
                actual = actual.der;
            } else {
                actual = actual.izq;
            }
        }
        // ahora vamos a eliminarlo
        if (actual == null) {
            return;
        } if (actual.izq == null) {
            intercambiar(actual, actual.der);
// poner el else de la siguiente linea es crucial. sino te tira nullpointerexception
        } else if (actual.der == null) {
            intercambiar(actual, actual.izq);
        }
        else {
            Nodo sucesor = getNodo(minimoRecursivo(actual.der));
            if (sucesor.padre != actual) {
                intercambiar(sucesor, sucesor.der);
                sucesor.der = actual.der;
                sucesor.der.padre = sucesor;
            }
            intercambiar(actual, sucesor);
            sucesor.izq = actual.izq;
            sucesor.izq.padre = sucesor;
        }
        _cardinal--;
    }

    private Nodo getNodo(T elem) {
        Nodo aux = _raiz;
        if (aux == null) {
            return null;
        } else {
            while (aux.dato != elem) {
                if (elem.compareTo(aux.dato) > 0) {
                    aux = aux.der;
                } else {
                    aux = aux.izq;
                }
            }
        }
        return aux;
    }

    private void intercambiar(Nodo x, Nodo cambioNodo) {
        if (x.padre == null) {
            this._raiz = cambioNodo;
        } else if (x == x.padre.izq) {
            x.padre.izq = cambioNodo;
        } else {
            x.padre.der = cambioNodo;
        }
        if (cambioNodo != null) {
            cambioNodo.padre = x.padre;
        }
    }

    public String toString(){
        Nodo aux = _raiz;
        String res = "{";
        res = res + stringInOrder(aux);
        res = res + "}";
        return res; 
    }

    private String stringInOrder(Nodo aux) {
        if (aux == null) {
            return "";
        }
        String izquierda = stringInOrder(aux.izq);
        String derecha = stringInOrder(aux.der);
        // el isEmpty, si el string esta vacio es porque es el primer elemento, y entonces no pone coma
        return izquierda + (izquierda.isEmpty() ? "" : ",") + aux.dato.toString() + (derecha.isEmpty() ? "" : ",") + derecha;
    }

    private class ABB_Iterador implements Iterador<T> {
    //     private Nodo _actual;
    //     private Stack<Nodo> stack; //para guardar elementos

    //     public void ABB_iterador(){
    //         _actual = _raiz;
    //         stack = new Stack<Nodo>();
    //         Nodo aux = _actual;
    //         cargarDatosInOrder(aux);
    //     }

    //     private void cargarDatosInOrder(Nodo x) {
    //         if (x != null) {
    //             cargarDatosInOrder(x.der);
    //             stack.push(x);
    //             cargarDatosInOrder(x.izq);
    //         }
    //     }

    //     public boolean haySiguiente() {            
    //         return !(stack.isEmpty());
    //     }
    
    //     public T siguiente() {
    //         if (!haySiguiente()) {
    //             return null;
    //         }
    //         Nodo siguiente = stack.pop();
    //         return siguiente.dato;
    //     }
        private Nodo actual;
        private Stack<Nodo> stack; //vamos a ir guardando todos los elementos aca ya que es facil para sacarlos
        
        public ABB_Iterador(){
            actual = _raiz;
            stack = new Stack<Nodo>();
            Nodo aux = actual;
            cargarDatosInOrder(aux);
        }

        private void cargarDatosInOrder(Nodo x){
            if (x != null){
                cargarDatosInOrder(x.der);
                stack.push(x);
                cargarDatosInOrder(x.izq);
            }
        }

        public boolean haySiguiente() {        
            return !(stack.isEmpty());
        }

        public T siguiente(){ 
            if (!haySiguiente()){
                return null;
            }
            Nodo siguiente = stack.pop();
            return siguiente.dato;
        }
    }

    public Iterador<T> iterador() {
        return new ABB_Iterador();
    }

}
