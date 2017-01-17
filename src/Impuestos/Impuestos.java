
package Impuestos;

import Enum.CedularTipos;
import Enum.Periodicidad;
import Enum.TipoDireccion;
import Enum.TipoPeriodo;
import Enum.TipoPersona;
import static Enum.TipoPersona.Moral;
import Enum.TipoRegimen;
import Excepciones.DireccionException;
import Excepciones.IntervalosFechaException;
import Excepciones.PersonaFisicaException;
import Excepciones.RFCException;
import Excepciones.RegimenException;
import Modelo.Direccion;
import Modelo.Fisica;
import Modelo.Moral;
import Modelo.Obligaciones.Cedular;
import Modelo.Obligaciones.Ieps;
import Modelo.Obligaciones.Incorporacion;
import Modelo.Obligaciones.Obligacion;
import Objetos.Fecha;
import Objetos.HashConjunto;
import Objetos.Periodo;
import Objetos.RFC;
import java.util.ArrayList;
import java.util.HashSet;

public class Impuestos {

    public static void main(String[] args) throws DireccionException, RFCException, IntervalosFechaException, PersonaFisicaException, RegimenException {
        
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
        
        Fisica FCesar = new Fisica(new RFC("CUPU800825569", TipoPersona.Fisica), "César Alejandro ", "Montaño ", "Cortés", new Fecha(20,11,1996), "9511787630", new Fecha(15,8,2016), new Fecha(15,8,2016));
        //tf.toString();
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
//        }
//        
//        System.out.println(ob.calculoImpuestos());
        Fisica fisica = null;
        Moral moral = null;
        Fisica juan = null;
        
        try {
            RFC rfc = new RFC("RIOD810904815", TipoPersona.Fisica);        
            fisica = new Fisica(rfc, "Daniel Karim", "Ricardez", "Ortiz", new Fecha(4,9,1981), "9515693556", new Fecha(15,12,2003), new Fecha(15, 12, 2003));

            juan = new Fisica(new RFC("GABJ9403189IP", TipoPersona.Fisica), "Juan Antonio", "Gabriel", "Bolaños", new Fecha(18,3,1994), "9512515114", new Fecha(15, 8, 2016), new Fecha(1, 9, 2016));
            
            moral = new Moral(new RFC("AAA900912", TipoPersona.Moral), "Provedora Escolar", "S.C. de R.L.", fisica, "5130223", new Fecha(1,1,2000), new Fecha(1, 1, 2000), new Fecha(1, 1, 2000));
        } catch (IntervalosFechaException ex) {
            ex.printStackTrace();
        } catch (PersonaFisicaException ex) {
            ex.printStackTrace();
        } catch (RFCException ex) {
            ex.printStackTrace();
        } catch (Exception ex){
            ex.printStackTrace();
        }
        
        Direccion direccionFisica = new Direccion(TipoDireccion.Fisica, "Prolg. Almendros", "509", "1", "Las Flores", "68050", "Oaxaca de Juarez");
        Direccion direccionFiscal = new Direccion(TipoDireccion.Fiscal, "Prolg. Almendros", "509", "1", "Las Flores", "68050", "Oaxaca de Juarez");
        
        fisica.AddDireccion(direccionFisica);
        fisica.AddDireccion(direccionFiscal);
        
        moral.AddDireccion(direccionFiscal);
        moral.AddDireccion(direccionFisica);
        
        
        juan.AddDireccion(new Direccion(TipoDireccion.Fiscal, "Cui", "12", null, "Del Valle", "68150", "Xoxo"));
        
        try {
            fisica.addRegimen(TipoRegimen.Incorporacion);
            fisica.addRegimen(TipoRegimen.Ieps);
            
            moral.addRegimen(TipoRegimen.Ieps);
            
            juan.addRegimen(TipoRegimen.Intermedio);
            
            //fisica.addRegimen(Regimen.INTERMEDIO);
        } catch (RegimenException ex) {
            ex.printStackTrace();
        }
        
        juan.actualizarObligaciones();
        
        
        TipoPeriodo tp = TipoPeriodo.getPeriodo(Periodicidad.Trimestral, new Fecha(1,1,2016));

        Periodo inicial = new Periodo(tp, 2016);
 
        System.out.println(inicial);
        System.out.println(inicial.next());
        System.out.println(inicial.next().next());
        System.out.println(inicial.next().next().next());
        
        System.out.println(inicial.next().next().next().next());

    }
    
}
