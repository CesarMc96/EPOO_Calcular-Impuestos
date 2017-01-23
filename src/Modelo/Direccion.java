
package Modelo;

import Enum.TipoDireccion;
import Excepciones.DireccionException;
import java.io.Serializable;
import java.util.Objects;

public class Direccion implements Serializable{
    private TipoDireccion tp;
    private String calle;
    private String numExterior;
    private String numInterior;
    private String colonia;
    private String codigoPostal;
    private String municipio;

    public Direccion(TipoDireccion tp, String calle, String numExterior, String numInterior, String colonia, String codigoPostal, String municipio) throws DireccionException {
        this.tp = tp;
        this.calle = calle.toUpperCase();
        this.numExterior = numExterior;
        this.numInterior = numInterior;
        this.colonia = colonia;
        this.codigoPostal = codigoPostal;
        this.municipio = municipio;
        validar();
    }
    
    public void validar() throws DireccionException{
        if (!codigoPostal.matches("^[0-9]{5}$")) {
            throw new DireccionException("CP incorrecto");
        } else if (!calle.matches("^[A-Z .]*$")) {
            throw new DireccionException("Calle con caracteres invalidos");
        }
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 19 * hash + Objects.hashCode(this.tp);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Direccion other = (Direccion) obj;
        if (!Objects.equals(this.calle, other.calle)) {
            return false;
        }
        if (!Objects.equals(this.numExterior, other.numExterior)) {
            return false;
        }
        if (!Objects.equals(this.numInterior, other.numInterior)) {
            return false;
        }
        if (!Objects.equals(this.colonia, other.colonia)) {
            return false;
        }
        if (!Objects.equals(this.codigoPostal, other.codigoPostal)) {
            return false;
        }
        if (!Objects.equals(this.municipio, other.municipio)) {
            return false;
        }
        if (this.tp != other.tp) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TipoDireccion: " + tp + " " + calle + " numero " + numExterior + " interior " + numInterior + " colonia " + colonia + " codigo postal " + codigoPostal + " municipio " + municipio;
    }

    public TipoDireccion getTp() {
        return tp;
    }

    public void setTp(TipoDireccion tp) {
        this.tp = tp;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumExterior() {
        return numExterior;
    }

    public void setNumExterior(String numExterior) {
        this.numExterior = numExterior;
    }

    public String getNumInterior() {
        return numInterior;
    }

    public void setNumInterior(String numInterior) {
        this.numInterior = numInterior;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }
    
}
