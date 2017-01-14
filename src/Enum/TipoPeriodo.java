
package Enum;

import Objetos.Fecha;

public enum TipoPeriodo {
    
    Enero(Periodicidad.Mensual,1,1), 
    Febrero(Periodicidad.Mensual,2,2),
    Marzo(Periodicidad.Mensual,3,3),
    Abril(Periodicidad.Mensual,4,4),
    Mayo(Periodicidad.Mensual,5,5),
    Junio(Periodicidad.Mensual,6,6),
    Julio(Periodicidad.Mensual,7,7),
    Agosto(Periodicidad.Mensual,8,8),
    Septiembre(Periodicidad.Mensual,9,9),
    Octubre(Periodicidad.Mensual,10,10),
    Noviembre(Periodicidad.Mensual,11,11),
    Diciembre(Periodicidad.Mensual,12,12),
    Enero_Febrero(Periodicidad.Bimestral, 1, 2),
    Marzo_Abril(Periodicidad.Bimestral, 3, 4),
    Mayo_Junio(Periodicidad.Bimestral, 5, 6),
    Julio_Agosto(Periodicidad.Bimestral, 7, 8),
    Septiembre_Octubre(Periodicidad.Bimestral, 9, 10),
    Noviembre_Diciembre(Periodicidad.Bimestral, 11, 12),
    Enero_Febrero_Marzo(Periodicidad.Trimestral, 1,3),
    Abril_Mayo_Junio(Periodicidad.Trimestral, 4,6),
    Julio_Agosto_Septiembre(Periodicidad.Trimestral,5,9),
    Octubre_Noviembre_Diciembre(Periodicidad.Trimestral, 10, 12);
    
    private Periodicidad periodicidad;
    private Integer mesInicial;
    private Integer mesFinal;

    private TipoPeriodo(Periodicidad periodicidad, Integer mesInicial, Integer mesFinal) {
        this.periodicidad = periodicidad;
        this.mesInicial = mesInicial;
        this.mesFinal = mesFinal;
    }
    
    public static TipoPeriodo getPeriodo(Periodicidad p, Fecha f){
        TipoPeriodo resultado = null;
        TipoPeriodo tp[] = TipoPeriodo.values();
        for(TipoPeriodo tipoperiodo : tp){
            if(tipoperiodo.getPeriodicidad() == p){
                if(tipoperiodo.getMesInicial() <= f.getMes() && tipoperiodo.getMesFinal() >= f.getMes()){
                    return resultado = tipoperiodo;
                }
            }
        }
        return resultado;
    }

    public Periodicidad getPeriodicidad() {
        return periodicidad;
    }

    public void setPeriodicidad(Periodicidad periodicidad) {
        this.periodicidad = periodicidad;
    }

    public Integer getMesInicial() {
        return mesInicial;
    }

    public void setMesInicial(Integer mesInicial) {
        this.mesInicial = mesInicial;
    }

    public Integer getMesFinal() {
        return mesFinal;
    }

    public void setMesFinal(Integer mesFinal) {
        this.mesFinal = mesFinal;
    }
}
            
