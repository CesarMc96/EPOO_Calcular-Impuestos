
package Excepciones;

public class DireccionException extends Exception {

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
