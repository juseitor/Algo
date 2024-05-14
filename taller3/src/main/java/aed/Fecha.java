package aed;

public class Fecha {

    private int _dia;
    private int _mes;

    public Fecha(int dia, int mes) {
        this._dia = dia;    
        this._mes = mes;
    }

    public Fecha(Fecha fecha) {
        this._dia = fecha.dia();
        this._mes = fecha.mes();
    }

    public Integer dia() {
        return _dia;
    }

    public Integer mes() {
        return _mes;
    }

    // public Integer dia() {
    //     throw new UnsupportedOperationException("No implementada aun");
    // }

    // public Integer mes() {
    //     throw new UnsupportedOperationException("No implementada aun");
    // }

    @Override
    public String toString() {
        StringBuffer sbuffer = new StringBuffer();

        sbuffer.append(this._dia);
        sbuffer.append("/");
        sbuffer.append(this._mes);

    return sbuffer.toString();
    }

    // @Override
    // public boolean equals(Object otra) {
    //     throw new UnsupportedOperationException("No implementada aun");
    // }

    // public void incrementarDia() {
    //     throw new UnsupportedOperationException("No implementada aun");
    // }

    // private int diasEnMes(int mes) {
    //     int dias[] = {
    //             // ene, feb, mar, abr, may, jun
    //             31, 28, 31, 30, 31, 30,
    //             // jul, ago, sep, oct, nov, dic
    //             31, 31, 30, 31, 30, 31
    //     };
    //     return dias[mes - 1];
    // }

    public static void main(String[] args) {
        Fecha miFecha = new Fecha(12, 5);
        System.out.println(miFecha);
        // System.out.println("Dia: " + miFecha.dia());
        // System.out.println("Mes " + miFecha.mes());
    }
}