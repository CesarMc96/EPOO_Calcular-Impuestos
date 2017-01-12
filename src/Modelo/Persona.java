
package Modelo;

import Enum.TipoDireccion;
import Objetos.Fecha;
import Objetos.HashConjunto;
import Objetos.RFC;
import java.util.HashSet;
import java.util.List;

public abstract class Persona {
    
    private HashSet<Direccion> direcciones;
    private String telefono;
    private RFC rfc;
    private Fecha fechaInscripcion;
    private Fecha fechaInicioOperaciones;
    private HashConjunto regimenes;
    
    public boolean AddDireccion(Direccion d){
        return direcciones.add(d);
    }
    
    public boolean isDireccion(TipoDireccion td){
        return false;
    }

    public Direccion getDireccion(TipoDireccion td){
        return null;
    }
    
    public List<Direccion> getDirecciones(){
        return null;
    }
    
    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public RFC getRfc() {
        return rfc;
    }

    public void setRfc(RFC rfc) {
        this.rfc = rfc;
    }

    public Fecha getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(Fecha fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }

    public Fecha getFechaInicioOperaciones() {
        return fechaInicioOperaciones;
    }

    public void setFechaInicioOperaciones(Fecha fechaInicioOperaciones) {
        this.fechaInicioOperaciones = fechaInicioOperaciones;
    }
    
    
}
