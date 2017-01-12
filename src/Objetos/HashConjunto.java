
package Objetos;

import Enum.TipoRegimen;
import java.util.HashSet;

public class HashConjunto extends HashSet<TipoRegimen>{

    @Override
    public boolean add(TipoRegimen rgm) {
        if ((rgm == TipoRegimen.Incorporacion)&&super.contains(TipoRegimen.Intermedio)){
            return false;
        }else if ((rgm == TipoRegimen.Intermedio)&&super.contains(TipoRegimen.Incorporacion)){
            return false;
        }else{
            return super.add(rgm);
        }
    }
}
