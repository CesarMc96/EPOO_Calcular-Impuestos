
package Excepciones;

public class RFCException extends Exception{
    
    public RFCException(){
        
    }
    
    public RFCException(String rfc) {
        super(rfc);
    }
}
