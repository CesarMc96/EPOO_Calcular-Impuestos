
package Excepciones;

import java.io.Serializable;

public class IntervalosFechaException extends Exception implements Serializable {

    public IntervalosFechaException() {
    }

    public IntervalosFechaException(String string) {
        super(string);
    }
    
}
