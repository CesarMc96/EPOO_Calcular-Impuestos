
package Modelo.Obligaciones;

import Enum.TipoRegimen;
import Objetos.Periodo;

public abstract class Impuesto implements Obligacion {
    
    private Periodo periodo;
    private TipoRegimen regimen;

    public Impuesto(Periodo periodo, TipoRegimen regimen) {
        this.periodo = periodo;
        this.regimen = regimen;
    }
    
    @Override
    public float calculoImpuestos(){
        return totalPagar() + calculaRecargos();
    }
    
}
