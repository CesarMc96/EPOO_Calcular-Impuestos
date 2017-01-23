
package Excepciones;

import java.io.Serializable;

public class RFCException extends Exception implements Serializable{
    
    public RFCException(){
        
    }
    
    public RFCException(String rfc) {
        super(rfc);
    }
}
