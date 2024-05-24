package aed;

public class Horario {

    private int _hrs;
    private int _mins;

    public Horario(int hora, int minutos) {
        _hrs = hora;
        _mins = minutos;
    }

    public int hora() {
        return _hrs;
    }

    public int minutos() {
        return _mins;
    }

    @Override
    public String toString() {
        StringBuffer sBuffer = new StringBuffer();
        sBuffer.append(_hrs + ":" + _mins);
        return sBuffer.toString();
    }

    @Override
    public boolean equals(Object otro) {
        boolean otroEsNull = (otro == null);
        boolean esDeOtraClase = (otro.getClass() != this.getClass());
        if (otroEsNull || esDeOtraClase){
            return false;
        }else{
            Horario otroHorario = (Horario) otro;
            return _hrs == otroHorario.hora() && _mins == otroHorario.minutos();
            // o se podria escribir así: "return  Objects.equals(this.hora(), otroHorario.hora()) && Objects.equals(this.minutos(), otroHorario.minutos());"
        }
    }

    public static void main(String[] args) {
        Horario H = new Horario(23, 50);
        System.out.println(H);
        System.out.println("Hora: " + H.hora());
        System.out.println("Minuto: " + H.minutos());
        System.out.println("resultade toString() " + H.toString());
        Horario H2 = new Horario(23, 50);
        System.out.println("resultado equals " + H.equals(H2));

    }
}
