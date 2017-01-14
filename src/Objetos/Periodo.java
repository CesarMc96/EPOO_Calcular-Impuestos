
package Objetos;

import Enum.Periodicidad;
import Enum.TipoPeriodo;

public class Periodo {
    
    private TipoPeriodo tipoPeriodo;
    private Fecha fLimitedePago;
    private Integer anio;

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
        f.aumentarDiaInhabil(dias semana);
        return f;
    }
}

//fecha cero = 17 del siguiente mes
