
package Modelo.Obligaciones;

import Enum.TipoRegimen;
import Objetos.Fecha;
import Objetos.Periodo;

public abstract class Impuesto implements Obligacion {
    
    private Periodo periodo;
    private TipoRegimen regimen;
    private Boolean obligacionCumplida;

    public Impuesto(Periodo periodo, TipoRegimen regimen) {
        this.periodo = periodo;
        this.regimen = regimen;
        obligacionCumplida = false;   
    }
    
    @Override
    public Float calculoImpuestos(){
        return totalPagar() + calculaRecargos();
    }
    
    @Override
    public Float calculaRecargos() {
        if (getPeriodo().getfLimitedePago().compareTo(new Fecha()) <= 0){
            return (float)0.0;
        }else{
            return totalPagar()*(float)0.03;
        }
    }    
    
    @Override
    public String toString(){
        return getRegimen().toString()+" "+getPeriodo().toString();
    }

    public Periodo getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Periodo periodo) {
        this.periodo = periodo;
    }

    public TipoRegimen getRegimen() {
        return regimen;
    }

    public void setRegimen(TipoRegimen regimen) {
        this.regimen = regimen;
    }

    public Boolean getObligacionCumplida() {
        return obligacionCumplida;
    }

    public void setObligacionCumplida(Boolean obligacionCumplida) {
        this.obligacionCumplida = obligacionCumplida;
    }
    
    
}
