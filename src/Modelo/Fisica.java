
package Modelo;

import Enum.TipoEstadoCivil;
import Objetos.Fecha;

public class Fisica extends Persona {

    private String nombre;
    private String amaterno;
    private String apaterno;
    private Fecha fNacimiento;
    private TipoEstadoCivil tec;

    public Fisica(String nombre, String amaterno, String apaterno, Fecha fNacimiento, TipoEstadoCivil tec) {
        this.nombre = nombre;
        this.amaterno = amaterno;
        this.apaterno = apaterno;
        this.fNacimiento = fNacimiento;
        this.tec = tec;
    }

    public boolean valida() {
        return fNacimiento.edad() >= 18;
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

    public TipoEstadoCivil getTec() {
        return tec;
    }

    public void setTec(TipoEstadoCivil tec) {
        this.tec = tec;
    }

}
