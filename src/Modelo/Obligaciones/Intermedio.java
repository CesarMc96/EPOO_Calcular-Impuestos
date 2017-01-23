
package Modelo.Obligaciones;

import Enum.TipoRegimen;
import Objetos.Periodo;
import java.io.Serializable;

public class Intermedio extends General implements Serializable {
    
    public Intermedio(Periodo periodo) {
        super(periodo, TipoRegimen.Intermedio);
    }
}