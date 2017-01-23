
package Excepciones;

import java.io.Serializable;

public class PersonaFisicaException extends Exception implements Serializable{

    public PersonaFisicaException() {
    }

    public PersonaFisicaException(String string) {
        super(string);
    }
    
    
}
