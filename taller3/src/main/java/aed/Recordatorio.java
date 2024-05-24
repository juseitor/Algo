package aed;

import java.util.Objects;

public class Recordatorio {

    private String _men;
    private Fecha _fe;
    private Horario _h;

    public Recordatorio(String mensaje, Fecha fecha, Horario horario) {
        _men = mensaje;
        _fe = new Fecha(fecha.dia(),fecha.mes());
        _h = new Horario(horario.hora(), horario.minutos());
    }

    public Horario horario() {
        Horario H = new Horario(this._h.hora(), this._h.minutos());
        return H;
    } // asi devolvemos una copia de horario llamando a los atributos, y evitamos aliasing

    public Fecha fecha() {
        Fecha F = new Fecha(this._fe.dia(), this._fe.mes());
        return F;
    }

    public String mensaje() {
        return _men;
    }

    @Override
    public String toString() {
        StringBuffer sbuffer = new StringBuffer();
        sbuffer.append(_men + " @ " + _fe + " " + _h);
        return sbuffer.toString();
    }

    @Override
    public boolean equals(Object otro) {
        boolean OtroEsNull = (otro == null);
        boolean EsDeDistintaClase = (otro.getClass() != this.getClass());
        if (this == otro) {
            return true;
        } if (OtroEsNull || EsDeDistintaClase){
            return false;
        }else{
            Recordatorio otroRecordatorio = (Recordatorio) otro;
            return Objects.equals(_men, otroRecordatorio._men) &&
                Objects.equals(_h, otroRecordatorio._h) &&
                Objects.equals(_fe  , otroRecordatorio._fe);
        }
    }
    public static void main(String[] args) {
        Fecha fecha1        = new Fecha(1, 2);
        Horario horario1    = new Horario(3, 4);
            Recordatorio recordatorio1  = new Recordatorio("Cock",fecha1 ,horario1);
        System.out.println("Mensaje: "  + recordatorio1.mensaje());
        System.out.println("Fecha "     + recordatorio1.fecha());
        System.out.println("Hora: "     + recordatorio1.horario());
        System.out.println(recordatorio1.toString());
        Fecha fecha2        = new Fecha(1, 2);
        Horario horario2    = new Horario(3, 4);
            Recordatorio recordatorio2  = new Recordatorio("Cock",fecha2 ,horario2);
        System.out.println("Mensaje: "  + recordatorio2.mensaje());
        System.out.println("Fecha "     + recordatorio2.fecha());
        System.out.println("Hora: "     + recordatorio2.horario());
        System.out.println(recordatorio2.toString());
        System.out.println("resultado de Equals: " + recordatorio1.equals(recordatorio2));
        }
    }

