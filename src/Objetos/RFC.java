
package Objetos;

import Enum.TipoPersona;
import Excepciones.RFCException;
import java.io.Serializable;

public class RFC implements Serializable {
    
    private String RFC;
    private final TipoPersona tp;
    
    public RFC(String rfc, TipoPersona tp) throws RFCException{
        this.tp = tp;
        RFC = rfc.toUpperCase();
        if(!this.valida()){
            throw new RFCException();
        }
    }
    
    private boolean valida(){
        if (tp == TipoPersona.Fisica){
            return RFC.matches("^[A-Z]{4}(\\d{6})((\\D|\\d){3})?$");
        }else{
            return RFC.matches("^[A-Z]{3}(\\d{6})((\\D|\\d){3})?$");
        }
    }
    
    @Override
    public String toString(){
        return RFC;
    }

    public String getRFC() {
        return RFC;
    }

    public void setRFC(String RFC) {
        this.RFC = RFC;
    }

}
