package aed;

public class Agenda {

    private Fecha fechaHoy;
    private ArregloRedimensionableDeRecordatorios arrayrecordatorios;

    public Agenda(Fecha fechaActual) {
        this.fechaHoy     = new Fecha(fechaActual.dia(), fechaActual.mes());
        this.arrayrecordatorios  = new ArregloRedimensionableDeRecordatorios();
    }

    public void agregarRecordatorio(Recordatorio recordatorio) {
        arrayrecordatorios.agregarAtras(recordatorio);
    }

    @Override
    public String toString() {
        StringBuffer sbuffer = new StringBuffer();
        sbuffer.append(fechaHoy.toString() + "\n=====\n");
        int i = 0;
        while (i < arrayrecordatorios.longitud()) {
            if (arrayrecordatorios.obtener(i).fecha().equals(fechaHoy)) {
                sbuffer.append(arrayrecordatorios.obtener(i).toString() + "\n");
            }
            i++;
        }
        return sbuffer.toString();
    }

    public void incrementarDia() {
        fechaHoy.incrementarDia();
    }

    public Fecha fechaActual() {
        Fecha FechaActual = new Fecha(fechaHoy.dia(), fechaHoy.mes());
        return FechaActual;
    }

}
