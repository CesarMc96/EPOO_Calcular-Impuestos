
package Modelo.Obligaciones;

import Enum.TipoRegimen;
import Objetos.Periodo;

public class Incorporacion extends Impuesto {

    public Incorporacion(Periodo periodo) {
        super(periodo, TipoRegimen.Incorporacion);
    }

    @Override
    public float calculaRecargos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public float totalPagar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

//por una tabla