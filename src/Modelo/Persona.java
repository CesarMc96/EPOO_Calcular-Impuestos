
package Modelo;

import Enum.TipoDireccion;
import Enum.TipoRegimen;
import Excepciones.IntervalosFechaException;
import Excepciones.RegimenException;
import Modelo.Obligaciones.Obligacion;
import Objetos.Fecha;
import Objetos.HashConjunto;
import Objetos.RFC;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public abstract class Persona {
    
    private HashSet<Direccion> direcciones;
    private String telefono;
    private RFC rfc;
    private Fecha fechaInscripcion;
    private Fecha fechaInicioOperaciones;
    private HashConjunto regimenes;

    public Persona(RFC rfc, String telefono, Fecha fechaInscripcion, Fecha fechaInicioOperaciones) throws IntervalosFechaException {
        this.rfc = rfc;
        this.telefono = telefono;
        this.fechaInscripcion = fechaInscripcion;
        this.fechaInicioOperaciones = fechaInicioOperaciones;
        direcciones = new HashSet<>();
        regimenes = new HashConjunto();
    }
    
    public boolean valido(){
        return fechaInscripcion.compareTo(fechaInicioOperaciones) <= 0;
    }
    
    public boolean AddDireccion(Direccion d){
        return direcciones.add(d);
    }
    
    public boolean isDireccion(TipoDireccion td){
        return direcciones.stream().filter(obj -> obj.getTp() == td).count() > 0;
    }

    public Direccion getDireccion(TipoDireccion td){
        Direccion direccionRetorno = null;
        
        for (Direccion direccion1 : direcciones) {
             if (direccion1.getTp()== td ){
                 direccionRetorno = direccion1;
             }
        }
        return direccionRetorno;
    }
    
    public void actualizarObligaciones(){
        for(TipoRegimen regimen: regimenes){
            
        }
    }
    
    public void addRegimen(TipoRegimen tp) throws RegimenException{
        if(!regimenes.add(tp)){
            throw new RegimenException();
        }
    }
    
    public List<Direccion> getDirecciones(){
        return new ArrayList<>(direcciones);
    }
    
    public List<TipoRegimen> getRemimenes(){
        return new ArrayList<>(regimenes);
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
