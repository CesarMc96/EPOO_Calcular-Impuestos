
package Modelo.Obligaciones;

import Enum.TipoRegimen;
import Objetos.Periodo;

public abstract class Impuesto implements Obligacion {
    
    private Periodo periodo;
    private TipoRegimen regimen;
    
    @Override
    public float calculoImpuestos(){
        return totalPagar() + calculaRecargos();
    }
    
}
