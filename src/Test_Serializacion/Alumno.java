
package Test_Serializacion;

import java.io.Serializable;

public class Alumno implements Serializable {
    private String Nombre;
    private Integer edad;
    private Float calificacion;

    public Alumno(String Nombre, Integer edad, Float calificacion) {
        this.Nombre = Nombre;
        this.edad = edad;
        this.calificacion = calificacion;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Float getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Float calificacion) {
        this.calificacion = calificacion;
    }

    @Override
    public String toString() {
        return "Alumno{" + "Nombre=" + Nombre + ", edad=" + edad + ", calificacion=" + calificacion + '}';
    }
    
    
}
