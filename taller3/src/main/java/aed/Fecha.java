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

    @Override
    public String toString() {
        StringBuffer sbuffer = new StringBuffer();             
        sbuffer.append(this._dia);
        sbuffer.append("/");
        sbuffer.append(this._mes);
    return sbuffer.toString();
    }

    @Override
    public boolean equals(Object otra) {
        // comparamos fecha con otra de la manera fecha.equals(otra)
        boolean oen = (otra == null); // guarda en oen si otra es null o no
        boolean cd = (this.getClass() != otra.getClass()); // guarda en cd si otra tiene otra clase o no
        if (cd || oen) {
            return false;
        }
        Fecha otraf = (Fecha) otra; // casteamos otra para que sea del tipo fecha
        return _dia == otraf.dia() && _mes == otraf.mes(); // comparamos atributos

    }

    public void incrementarDia() {
        if (_dia < diasEnMes(_mes)){
            _dia++;
        }else{
            if (_mes<12){
                _dia = 1;
                _mes++;
            }else{
                _dia = 1;
                _mes = 1;
            }
        }

    }

    private int diasEnMes(int mes) {
        int dias[] = {
                // ene, feb, mar, abr, may, jun
                31, 28, 31, 30, 31, 30,
                // jul, ago, sep, oct, nov, dic
                31, 31, 30, 31, 30, 31
        };
        return dias[mes - 1];
    }

    public static void main(String[] args) {
        Fecha miFecha = new Fecha(12, 5);
        System.out.println(miFecha);
        System.out.println("Dia: " + miFecha.dia());
        System.out.println("Mes: " + miFecha.mes());
        miFecha.incrementarDia();
        System.out.println("dia incrementado " + miFecha.toString());
        Fecha miFecha2 = new Fecha(13, 5);
        System.out.println("resultado de equals " + miFecha.equals(miFecha2));
    }
}