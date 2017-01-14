
package Modelo;

import Excepciones.IntervalosFechaException;
import Excepciones.PersonaFisicaException;
import Objetos.Fecha;
import Objetos.HashConjunto;
import Objetos.RFC;
import java.util.HashSet;

public class Fisica extends Persona {

    private String nombre;
    private String amaterno;
    private String apaterno;
    private Fecha fNacimiento;

    @Override
    public boolean valido() {
        boolean resultado = super.valido();
        return resultado && fNacimiento.edad() >= 18;
    }

    public Fisica(String nombre, String apaterno, String amaterno, Fecha fNacimiento, HashSet<Direccion> direcciones, String telefono, RFC rfc, Fecha fechaInscripcion, Fecha fechaInicioOperaciones, HashConjunto regimenes) throws IntervalosFechaException, PersonaFisicaException {
        super(direcciones, telefono, rfc, fechaInscripcion, fechaInicioOperaciones, regimenes);
        this.nombre = nombre;
        this.amaterno = amaterno;
        this.apaterno = apaterno;
        this.fNacimiento = fNacimiento;
        
        if(!valido()){
            throw new PersonaFisicaException();
        }
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
