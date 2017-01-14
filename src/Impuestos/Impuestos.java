
package Impuestos;

import Enum.Periodicidad;
import Enum.TipoDireccion;
import Enum.TipoPeriodo;
import Enum.TipoPersona;
import Enum.TipoRegimen;
import Excepciones.DireccionException;
import Excepciones.RFCException;
import Modelo.Direccion;
import Modelo.Fisica;
import Modelo.Obligaciones.Cedular;
import Modelo.Obligaciones.Ieps;
import Modelo.Obligaciones.Incorporacion;
import Modelo.Obligaciones.Obligacion;
import Objetos.Fecha;
import Objetos.HashConjunto;
import Objetos.RFC;
import java.util.ArrayList;
import java.util.HashSet;

public class Impuestos {

    public static void main(String[] args) throws DireccionException, RFCException {
        
        /*DIA 1*/
        System.out.println("Fechas-----------");
        
        Fecha f = new Fecha();
        System.out.println(f);
        System.out.println(f.fechaValida());
        f.aumentar();
        System.out.println(f);
        f.aumentar(2);
        System.out.println(f);
        f.disminuir();
        f.disminuir(3);
        System.out.println(f);
        System.out.println(f.diaSemana());
        System.out.println(f.compareTo(new Fecha(14,1,2017)));
        System.out.println(new Fecha(20,11,1996).edad());
        System.out.println("");
        
        /*DIA 2*/
        System.out.println("Dias Inhabiles--------------");

        Fecha.agregarDiaInhabil(new Fecha(16,9,2016));
        Fecha.agregarDiaInhabil(new Fecha(2,11,2016));
        Fecha.agregarDiaInhabil(new Fecha(21,11,2016));
        Fecha.agregarDiaInhabil(new Fecha(6,1,2017));
        Fecha.agregarDiaInhabil(new Fecha(6,2,2017));
        Fecha.agregarDiaInhabil(new Fecha(1,5,2017));
        Fecha.agregarDiaInhabil(new Fecha(5,5,2017));
        Fecha.agregarDiaInhabil(new Fecha(15,5,2017));
        
        System.out.println("");
        System.out.println("Direccion--------------");
        
        Direccion d = new Direccion(TipoDireccion.Fisica, "Calle seis de enero", "133", "A", "Aquiles Serdad", "71220", "Santa Lucia del Camino");
        System.out.println(d);
        
        HashSet<Direccion> direcciones = new HashSet<>();
        direcciones.add(d);
        
        Fisica tf = new Fisica("Cesar Alejandro", "Montano", "Cortes", new Fecha(20,11, 1996), direcciones, "9511787630", new RFC("CUPU800825569", TipoPersona.Fisica), new Fecha(1,1,2017), new Fecha(10,1,2017), );
//        
//        //HashSet es ArrayList pero no permite usar repetidos
//        HashSet<Fecha> fechas = new HashSet<>();
//        fechas.add(f);
//        fechas.add(f1);
//        fechas.add(f2);
//        fechas.add(f3);
//        fechas.add(f4);
//        fechas.add(f5);
//        fechas.add(f6);
//        fechas.add(f7);
        
//        for (Fecha fechaInhabile : fechas) {
//            System.out.println(fechaInhabile);
//        }

//        TipoPeriodo p = TipoPeriodo.getPeriodo(Periodicidad.Mensual, new Fecha());
//        System.out.println(p);
//        
//        System.out.println("");
        
        
        /*DIA 3*/
        
//        HashSet<TipoRegimen> regimenes = new HashSet<>();
//        regimenes.add(TipoRegimen.Cedular);
//        
//        
//        Direccion direccion1 = new Direccion(TipoDireccion.Fiscal, "Reforma", "405", "1", "centro", "68100", "santa lucia");
//        Direccion direccion2 = new Direccion(TipoDireccion.Fiscal, "Reforma", "405", "1", "centro", "68100", "santa lucia");
//        Direccion direccion3 = new Direccion(TipoDireccion.Sucursal, "Reforma", "405", "1", "centro", "68100", "santa lucia");
//        
//        HashSet<Direccion> direcciones = new HashSet<>();
//        direcciones.add(direccion1);
//        direcciones.add(direccion2);
//        
//        for(Direccion direccione : direcciones) {
//            System.out.println(direccione);
//        }
//        
//        ArrayList<Obligacion> arreglo = new ArrayList();
//        Obligacion ob = new Cedular();
//        
//        arreglo.add(ob);
//        arreglo.add(new Ieps());
//        arreglo.add(new Cedular());
//        arreglo.add(new Incorporacion());
//        
//        for(int i = 0; i < arreglo.size(); i++){
//            Obligacion obj = arreglo.get(i);
//            obj.metodoPrueba();
//        }
        
    }
    
}
