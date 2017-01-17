
package Objetos;

import Enum.TipoPeriodo;
import java.time.DayOfWeek;

public class Periodo {
    
    private final TipoPeriodo tipoPeriodo;
    private Fecha fLimitedePago;
    private final Integer anio;

    public Periodo(TipoPeriodo tipoPeriodo, Integer anio) {
        this.tipoPeriodo = tipoPeriodo;
        this.anio = anio;
    }
    
    private Fecha fechaCero(){
        tipoPeriodo.getMesFinal();
        Fecha f = new Fecha(17,tipoPeriodo.getMesFinal() + 1, anio);
        f.aumentarDiaInhabil(DayOfWeek.SATURDAY, DayOfWeek.SUNDAY);
        return f;
    }
    
    public Fecha fechaLimite(Integer diasAdicionales){
        Fecha cero = fechaCero();
        for (int i = 0; i < diasAdicionales; i++) {
            cero.aumentarDiaInhabil(DayOfWeek.FRIDAY, DayOfWeek.SATURDAY, DayOfWeek.SUNDAY);
        }
        return cero;
    }
    
    @Override
    public String toString(){
        return tipoPeriodo.toString()+" "+ anio;
    }
    
    public Periodo next(){
        Integer ej = anio;
        TipoPeriodo tp = tipoPeriodo.next();
        if (tp == null){
            ej++;
            tp = TipoPeriodo.getPeriodo(this.tipoPeriodo.getPeriodicidad(), new Fecha(1,1,ej));
        }
        Periodo resultado = new Periodo(tp, ej);

        
        return resultado;
    }
}
