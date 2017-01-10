
package Impuestos;

import Enum.TipoDireccion;
import Enum.TipoRegimen;
import Modelo.Direccion;
import Objetos.Fecha;
import Objetos.Regimen;
import java.util.ArrayList;
import java.util.HashSet;

public class Impuestos {

    public static void main(String[] args) {
        
        /*DIA 1*/
//        System.out.println("Fechas-----------");
//        Fecha f = new Fecha(1,3,2016);
//        System.out.println(f);
//        System.out.println(f.fechaValida());
//        f.aumentar();
//        System.out.println(f);
//        f.disminuir();
//        f.disminuir();
//        System.out.println(f);
//        f.aumentar(27);
//        System.out.println(f);
//        f.disminuir(3);
//        System.out.println(f);
//        System.out.println(f.diaSemana());
        
        Fecha f = new Fecha(20,11,1996);
        Fecha f1 = new Fecha();
        System.out.println(f);
        System.out.println(f1);
        f1.edad(f);
        System.out.println("");
        
        /*DIA 2*/
        System.out.println("Dias Inhabiles--------------");
        
        Fecha persona1 = new Fecha(20, 11, 96);
        Fecha persona2 = new Fecha(12, 05, 95);
        
        System.out.println(persona1.compareTo(persona2));
        System.out.println(persona2.compareTo(persona1));
        
        ArrayList<Fecha> fechasInhabiles = new ArrayList<>();
        
        fechasInhabiles.add(new Fecha(1,1,2017));
        fechasInhabiles.add(new Fecha(5,2,2017));
        fechasInhabiles.add(new Fecha(1,1,2017));
        
        for (Fecha fechaInhabile : fechasInhabiles) {
            System.out.println(fechaInhabile);
        }
        
        //HashSet es ArrayList pero no permite usar repetidos
        HashSet<Fecha> fechas = new HashSet<>();
        fechas.add(f);
        fechas.add(f);
        
        System.out.println("");
        
        
        /*DIA 3*/
        /*
        HashSet<TipoRegimen> regimenes = new HashSet<>();
        //regimenes.add(Regimen.Cedular);
        */
        
        Direccion direccion1 = new Direccion(TipoDireccion.Fiscal, "Reforma", "405", "1", "centro", "68100", "santa lucia");
        Direccion direccion2 = new Direccion(TipoDireccion.Fiscal, "Reforma", "405", "1", "centro", "68100", "santa lucia");
        Direccion direccion3 = new Direccion(TipoDireccion.Sucursal, "Reforma", "405", "1", "centro", "68100", "santa lucia");
        
        HashSet<Direccion> direcciones = new HashSet<>();
        direcciones.add(direccion1);
        direcciones.add(direccion2);
        
        for(Direccion direccione : direcciones) {
            System.out.println(direccione);
        }
        
        
    }
    
}
