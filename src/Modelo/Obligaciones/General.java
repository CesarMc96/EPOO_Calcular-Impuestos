
package Modelo.Obligaciones;

import Enum.TipoRegimen;
import Objetos.Periodo;
import java.io.Serializable;

public abstract class General extends Impuesto implements Serializable{
    
    private Float ingresos;
    private Float egresos;

    public General(Periodo periodo, TipoRegimen regimen) {
        super(periodo, regimen);
    }
    
    @Override
    public Float totalPagar() {
        Float iva = (ingresos - egresos) * (float)0.16;
        return iva;
    }    

    public Float getIngresos() {
        return ingresos;
    }

    public void setIngresos(Float ingresos) {
        this.ingresos = ingresos;
    }

    public Float getEgresos() {
        return egresos;
    }

    public void setEgresos(Float egresos) {
        this.egresos = egresos;
    }
}
