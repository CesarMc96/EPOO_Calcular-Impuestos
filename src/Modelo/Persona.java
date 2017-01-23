
package Modelo;

import Enum.TipoDireccion;
import Enum.TipoPeriodo;
import Enum.TipoRegimen;
import Excepciones.IntervalosFechaException;
import Excepciones.RegimenException;
import Modelo.Obligaciones.Cedular;
import Modelo.Obligaciones.Hospedaje;
import Modelo.Obligaciones.Ieps;
import Modelo.Obligaciones.Impuesto;
import Modelo.Obligaciones.Incorporacion;
import Modelo.Obligaciones.Intermedio;
import Modelo.Obligaciones.Obligacion;
import Objetos.Fecha;
import Objetos.HashConjunto;
import Objetos.Periodo;
import Objetos.RFC;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public abstract class Persona implements Serializable{
    
    private final HashSet<Direccion> direcciones;
    private String telefono;
    private RFC rfc;
    private Fecha fechaInscripcion;
    private Fecha fechaInicioOperaciones;
    private final HashConjunto regimenes;
    private final ArrayList<Obligacion> obligaciones;

    public Persona(RFC rfc, String telefono, Fecha fechaInscripcion, Fecha fechaInicioOperaciones) throws IntervalosFechaException {
        this.rfc = rfc;
        this.telefono = telefono;
        this.fechaInscripcion = fechaInscripcion;
        this.fechaInicioOperaciones = fechaInicioOperaciones;
        direcciones = new HashSet<>();
        regimenes = new HashConjunto();
        obligaciones = new ArrayList<>();
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
        Integer anio = fechaInicioOperaciones.getAnio();
        for (TipoRegimen regimen : regimenes) {
            TipoPeriodo tp = TipoPeriodo.getPeriodo(regimen.getPeriodicidad(), fechaInicioOperaciones);
            Periodo periodo = new Periodo(tp, anio);  
            Integer anioActual = (new Fecha()).getAnio();
            do{
            Obligacion obligacion = null;
            switch (regimen) {
                case Incorporacion:
                    obligacion = new Incorporacion(periodo);
                    break;
                case Intermedio:
                    obligacion = new Intermedio(periodo);
                    break;
                case Cedular:
                    obligacion = new Cedular(periodo);
                    break;                
                case Ieps:
                    obligacion = new Ieps(periodo);
                    break;                
                case Hospedaje:
                    obligacion = new Hospedaje(periodo);
                    break;                
                default:
                    throw new AssertionError();
            }
            obligaciones.add(obligacion);
            periodo = periodo.next();
            }while(periodo.getAnio() <= anioActual);
        }
    }
    
    public Obligacion getObligacion(TipoRegimen regimen){
        for (Obligacion obligacion : obligaciones) {
            Impuesto impuesto = (Impuesto)obligacion;
            if (impuesto.getRegimen() == regimen){
                if (!impuesto.getObligacionCumplida()){
                    return impuesto;
                }
            }
        }
        return null;
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

    @Override
    public String toString() {
        return "Persona{" + "direcciones=" + direcciones + ", telefono=" + telefono + ", rfc=" + rfc + ", fechaInscripcion=" + fechaInscripcion + ", fechaInicioOperaciones=" + fechaInicioOperaciones + ", regimenes=" + regimenes + ", obligaciones=" + obligaciones + '}';
    }
    
    
    
}
