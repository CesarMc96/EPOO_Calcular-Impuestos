
package Modelo.Obligaciones;

import Enum.TipoRegimen;
import Objetos.Periodo;

public class Ieps extends Impuesto{

    private Float litrosMagna;
    private Float litrosPremium;
    private Float litrosDisel;
    
    public Ieps(Periodo periodo) {
        super(periodo, TipoRegimen.Ieps);
    }

    @Override
    public Float totalPagar() {
        Float magna = litrosMagna * (float)15.99 * (float)0.20;
        Float premuin = litrosPremium * (float)17.79 * (float)0.20;
        Float disel = litrosDisel * (float)17.05 * (float)0.20;
        return magna + premuin + disel;
    }

    public Float getLitrosMagna() {
        return litrosMagna;
    }

    public void setLitrosMagna(Float litrosMagna) {
        this.litrosMagna = litrosMagna;
    }

    public Float getLitrosPremium() {
        return litrosPremium;
    }

    public void setLitrosPremium(Float litrosPremium) {
        this.litrosPremium = litrosPremium;
    }

    public Float getLitrosDisel() {
        return litrosDisel;
    }

    public void setLitrosDisel(Float litrosDisel) {
        this.litrosDisel = litrosDisel;
    }

    
}
