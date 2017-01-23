
package Excepciones;

import java.io.Serializable;

public class RegimenException extends Exception implements Serializable{

    public RegimenException() {
    }

    public RegimenException(String string) {
        super(string);
    }
    
    
}
