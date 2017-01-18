
package Enum;

public enum TipoRegimen {
    Cedular(Periodicidad.Bimestral),
    Intermedio(Periodicidad.Mensual),
    Ieps(Periodicidad.Mensual),
    Hospedaje(Periodicidad.Trimestral),
    Incorporacion(Periodicidad.Bimestral);
    
    private TipoRegimen(Periodicidad periodicidad){
        this.periodicidad = periodicidad;
    }
    
    private final Periodicidad periodicidad;

    public Periodicidad getPeriodicidad() {
        return periodicidad;
    }
    
    
}

