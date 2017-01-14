
package Modelo.Obligaciones;

public class Cedular implements Obligacion{

    @Override
    public float calculoImpuestos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public float calculaRecargos() {
        return (float) 2.0;
    }

    @Override
    public float totalPagar() {
        return (float) 1.0;
    }
    
}

//numero de ingreso

/*
casa habitacion = 10 por ciento del ingreso obtenido
local comercial = 25 por ciento
*/