
package Modelo;

import Enum.TipoDireccion;

public class Direccion {
    private TipoDireccion tp;
    private String calle;
    private String numExterior;
    private String numInterior;
    private String colonia;
    private String codigoPostal;
    private String municipio;

    public Direccion(TipoDireccion tp, String calle, String numExterior, String numInterior, String colonia, String codigoPostal, String municipio) {
        this.tp = tp;
        this.calle = calle.toUpperCase();
        this.numExterior = numExterior;
        this.numInterior = numInterior;
        this.colonia = colonia;
        this.codigoPostal = codigoPostal;
        this.municipio = municipio;
    }
    
    public boolean validar(){
        boolean resultado = true;
        resultado = resultado && codigoPostal.matches("^[0-9] {5} S");
        return resultado;
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
