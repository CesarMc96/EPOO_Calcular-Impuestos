
package Modelo;

import Objetos.Fecha;
import Objetos.RFC;
import java.util.HashSet;
import Objetos.Regimen;

public abstract class Persona {
    
    private HashSet<Direccion> direcciones;
    private String telefono;
    private RFC rfc;
    private Fecha fechaInscripcion;
    private Fecha fechaInicioOperaciones;
    private Regimen regimen;
}
