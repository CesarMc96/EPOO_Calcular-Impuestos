
package Excepciones;

import java.io.Serializable;

public class DireccionException extends Exception implements Serializable {

    private String mensaje;

    public DireccionException() {
    }

    public DireccionException(String string) {
        super(string);
        mensaje = string;
    }
    
    public String getMensaje(){
        return mensaje;
    }
}
