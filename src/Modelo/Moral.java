
package Modelo;

import Excepciones.IntervalosFechaException;
import Objetos.Fecha;
import Objetos.HashConjunto;
import Objetos.RFC;
import java.util.HashSet;

public class Moral extends Persona{
    private String razonSocial;
    private String tipoSociedad;
    private Fisica representanteLegal;
    private Fecha fechaCreacion;

    public Moral(String razonSocial, String tipoSociedad, Fisica representanteLegal, Fecha fechaCreacion, HashSet<Direccion> direcciones, String telefono, RFC rfc, Fecha fechaInscripcion, Fecha fechaInicioOperaciones, HashConjunto regimenes) throws IntervalosFechaException {
        super(direcciones, telefono, rfc, fechaInscripcion, fechaInicioOperaciones, regimenes);
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
    
}