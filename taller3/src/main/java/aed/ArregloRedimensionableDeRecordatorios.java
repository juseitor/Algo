package aed;

import java.util.ArrayList;

class ArregloRedimensionableDeRecordatorios implements SecuenciaDeRecordatorios {

    private ArrayList<Recordatorio> arrayrecordatorios;

    public ArregloRedimensionableDeRecordatorios() {
        arrayrecordatorios = new ArrayList<>();
    }

    public ArregloRedimensionableDeRecordatorios(ArregloRedimensionableDeRecordatorios vector) {
        arrayrecordatorios = new ArrayList<>(vector.arrayrecordatorios);
    }

    public int longitud() {
        return arrayrecordatorios.size();
    }

    public void agregarAtras(Recordatorio i) {
        arrayrecordatorios.add(i);
    }

    public Recordatorio obtener(int i) {
        return this.arrayrecordatorios.get(i); 
    }

    public void quitarAtras() {
        arrayrecordatorios.remove(arrayrecordatorios.size() - 1);
    }

    public void modificarPosicion(int indice, Recordatorio valor) {
        this.arrayrecordatorios.set(indice, valor);
    }

    public ArregloRedimensionableDeRecordatorios copiar() {
        ArregloRedimensionableDeRecordatorios CopiaArreglo = new ArregloRedimensionableDeRecordatorios(this);
        return CopiaArreglo;
    }

}
