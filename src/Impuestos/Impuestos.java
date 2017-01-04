
package Impuestos;

import Objetos.Fecha;

public class Impuestos {

    public static void main(String[] args) {
        
        Fecha f = new Fecha();
        System.out.println(f);
        System.out.println(f.fechaValida());
//        f.aumentar();
//        System.out.println(f);
//        f.disminuir();
//        System.out.println(f);
//        f.aumentar(30);
//        System.out.println(f);
//        f.disminuir(5);
//        System.out.println(f);
        System.out.println(f.diaSemana());
            
    }
    
}
