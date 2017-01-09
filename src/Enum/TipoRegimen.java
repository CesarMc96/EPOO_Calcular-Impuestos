
package Enum;

public enum TipoRegimen {
    Cedular(2),
    Intermedio(1),
    Ieps(4),
    Hospedaje(3),
    Incorporacion(1);
    
    private TipoRegimen(int parametro){
        numerito = parametro;
    }
    
    private final int numerito;

    public int getNumerito() {
        return numerito;
    }
    
    
}

