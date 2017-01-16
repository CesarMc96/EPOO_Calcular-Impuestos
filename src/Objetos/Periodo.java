
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
    
    private void setFechaLimite(Integer diasAdicionales){
        Fecha cero = fechaCero();
        
    }
    
    private Fecha fechaCero(){
        tipoPeriodo.getMesFinal();
        Fecha f = new Fecha(17,tipoPeriodo.getMesFinal() + 1, anio);
        f.aumentarDiaInhabil(DayOfWeek.FRIDAY);
        return f;
    }
}

//fecha cero = 17 del siguiente mes
