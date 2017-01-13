
package Objetos;

import Enum.Periodicidad;
import Enum.TipoPeriodo;

public class Periodo {
    
    private TipoPeriodo tipoPeriodo;
    private Periodicidad periodicidad;
    private Fecha fLimitedePago;

    public Periodo(TipoPeriodo tipoPeriodo, Periodicidad periodicidad) {
        this.tipoPeriodo = tipoPeriodo;
        this.periodicidad = periodicidad;
    }
    
    private void setFechaLimite(){
        
    }
    
}
