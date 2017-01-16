
package Modelo.Obligaciones;

import Enum.CedularTipos;

public class Cedular implements Obligacion{

    private CedularTipos cdt;
    private float ingresos;
    private float egresos;

    public Cedular(CedularTipos cdt, float ingresos, float egresos) {
        this.cdt = cdt;
        this.ingresos = ingresos;
        this.egresos = egresos;
    }

    public CedularTipos getCdt() {
        return cdt;
    }

    public void setCdt(CedularTipos cdt) {
        this.cdt = cdt;
    }

    public float getIngresos() {
        return ingresos;
    }

    public void setIngresos(float ingresos) {
        this.ingresos = ingresos;
    }

    public float getEgresos() {
        return egresos;
    }

    public void setEgresos(float egresos) {
        this.egresos = egresos;
    }

    @Override
    public String toString() {
        return "Cedular{" + "cdt=" + cdt + ", ingresos=" + ingresos + ", egresos=" + egresos + '}';
    }
    
    
    
    @Override
    public float calculoImpuestos() {
        return (float) ((float) (((ingresos * .16) - (egresos * .16))*.05)+((ingresos * .16) - (egresos * .16)));
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

iva 16% impeusto 5%
*/