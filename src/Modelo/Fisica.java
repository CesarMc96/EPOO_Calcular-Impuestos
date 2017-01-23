
package Modelo;

import Excepciones.IntervalosFechaException;
import Excepciones.PersonaFisicaException;
import Objetos.Fecha;
import Objetos.RFC;
import java.io.Serializable;

public class Fisica extends Persona implements Serializable{

    private String nombre;
    private String amaterno;
    private String apaterno;
    private Fecha fNacimiento;

    public Fisica(RFC rfc, String nombre, String paterno, String materno, Fecha fechaNacimiento, String telefono, Fecha fechaInscripcion, Fecha fechaInicioOperaciones) throws IntervalosFechaException, PersonaFisicaException {
        super(rfc, telefono, fechaInscripcion, fechaInicioOperaciones);
        this.nombre = nombre;
        this.apaterno = paterno;
        this.amaterno = materno;
        this.fNacimiento = fechaNacimiento;
        
        if (!valido()){
            throw new PersonaFisicaException();
        }
    }
    
    
    @Override
    public boolean valido() {
        boolean resultado = super.valido();
        return resultado && fNacimiento.edad() >= 18;
    }
    
    public Integer getEdad(){
    return fNacimiento.edad();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAmaterno() {
        return amaterno;
    }

    public void setAmaterno(String amaterno) {
        this.amaterno = amaterno;
    }

    public String getApaterno() {
        return apaterno;
    }

    public void setApaterno(String apaterno) {
        this.apaterno = apaterno;
    }

    public Fecha getfNacimiento() {
        return fNacimiento;
    }

    public void setfNacimiento(Fecha fNacimiento) {
        this.fNacimiento = fNacimiento;
    }

}
