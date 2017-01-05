
package Impuestos;

import Objetos.Fecha;
import java.util.ArrayList;
import java.util.HashSet;

public class Impuestos {

    public static void main(String[] args) {
        
        /*DIA 1*/
        Fecha f = new Fecha(1,3,2016);
        System.out.println(f);
        System.out.println(f.fechaValida());
        f.aumentar();
        System.out.println(f);
//        f.disminuir();
//        f.disminuir();
//        System.out.println(f);
//        f.aumentar(27);
//        System.out.println(f);
        f.disminuir(3);
        System.out.println(f);
        System.out.println(f.diaSemana());
        
        /*DIA 2*/
        Fecha persona1 = new Fecha(20, 11, 96);
        Fecha persona2 = new Fecha(12, 05, 95);
        
        System.out.println(persona1.compareTo(persona2));
        System.err.println(persona2.compareTo(persona1));
        
        ArrayList<Fecha> fechasInhabiles = new ArrayList<>();
        
        fechasInhabiles.add(new Fecha(1,1,2017));
        fechasInhabiles.add(new Fecha(5,2,2017));
        fechasInhabiles.add(new Fecha(1,1,2017));
        
        for (Fecha fechaInhabile : fechasInhabiles) {
            System.out.println(fechaInhabile);
        }
        
        //HashSet esArrayList pero no permite usar repetidos
        HashSet<Fecha> fechas = new HashSet<>();
        
    }
    
}
