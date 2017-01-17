
package Modelo.Obligaciones;

public class Intermedio implements Obligacion{
    
    @Override
    public float calculoImpuestos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public float calculaRecargos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public float totalPagar() {
        //return ingresoTotal() - dineroGastado();
        return (float) 0.00;
    }
}
// total de ingreso menos el total gastado * 0.35