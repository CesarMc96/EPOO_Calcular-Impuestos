
package Modelo.Obligaciones;

import Enum.TipoRegimen;
import Objetos.Periodo;

public class Hospedaje extends General{

    public Hospedaje(Periodo periodo) {
        super(periodo, TipoRegimen.Hospedaje);
    }

    @Override
    public Float totalPagar() {
        Float impuesto = getIngresos() * (float)0.02;
        return super.totalPagar() + impuesto;
    }
    
}
