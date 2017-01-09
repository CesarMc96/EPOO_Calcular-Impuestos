
package Modelo;

import Enum.TipoRegimen;
import Objetos.Fecha;
import Objetos.RFC;
import java.util.HashSet;

public abstract class Persona {
    
    private HashSet<Direccion> direcciones;
    private String telefono;
    private RFC rfc;
    private Fecha fechaInscripcion;
    private Fecha fechaInicioOperaciones;
    private HashSet<TipoRegimen> regimenes;
    
    
}
