
package Modelo.Obligaciones;

import Enum.TipoRegimen;
import Objetos.Periodo;

public class Intermedio extends General {
    
    public Intermedio(Periodo periodo) {
        super(periodo, TipoRegimen.Intermedio);
    }
}