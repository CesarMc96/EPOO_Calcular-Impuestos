
package Modelo;

import Excepciones.IntervalosFechaException;
import Objetos.Fecha;
import Objetos.RFC;
import java.io.Serializable;

public class Moral extends Persona implements Serializable{
    private String razonSocial;
    private String tipoSociedad;
    private Fisica representanteLegal;
    private Fecha fechaCreacion;

    public Moral(RFC rfc, String razonSocial, String tipoSociedad, Fisica representanteLegal, String telefono, Fecha fechaInscripcion, Fecha fechaInicioOperaciones, Fecha fechaCreacion) throws IntervalosFechaException {
        super(rfc, telefono, fechaInscripcion, fechaInicioOperaciones);
        this.razonSocial = razonSocial;
        this.tipoSociedad = tipoSociedad;
        this.representanteLegal = representanteLegal;
        this.fechaCreacion = fechaCreacion;
    }


    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getTipoSociedad() {
        return tipoSociedad;
    }

    public void setTipoSociedad(String tipoSociedad) {
        this.tipoSociedad = tipoSociedad;
    }

    public Fisica getRepresentanteLegal() {
        return representanteLegal;
    }

    public void setRepresentanteLegal(Fisica representanteLegal) {
        this.representanteLegal = representanteLegal;
    }

    public Fecha getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Fecha fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    @Override
    public String toString() {
        return "Moral{" + "razonSocial=" + razonSocial + ", tipoSociedad=" + tipoSociedad + ", representanteLegal=" + representanteLegal + ", fechaCreacion=" + fechaCreacion + '}';
    }
    
}