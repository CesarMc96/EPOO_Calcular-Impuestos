
package Modelo.Obligaciones;

import Enum.TipoRegimen;
import Objetos.Periodo;

public class Cedular extends Impuesto{

    public Cedular(Periodo periodo) {
        super(periodo, TipoRegimen.Cedular);
    }

    @Override
    public float calculoImpuestos() {
        //return (float) ((float) (((ingresos * .16) - (egresos * .16))*.05)+((ingresos * .16) - (egresos * .16)));
        return (float) 0.0;
    }

    @Override
    public float calculaRecargos() {
        return (float) 0.0;
    }
    
    //TOTAL
    @Override
    public float totalPagar() {
        return (float) 0.0;
    }
    
}

//numero de ingreso

/*
casa habitacion = 10 por ciento del ingreso obtenido
local comercial = 25 por ciento

iva 16%
*/