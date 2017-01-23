package Controller;

import Enum.TipoPersona;
import Excepciones.IntervalosFechaException;
import Excepciones.PersonaFisicaException;
import Excepciones.RFCException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import Modelo.Persona;
import Modelo.Fisica;
import Objetos.Fecha;
import Objetos.RFC;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;

public class BaseDatos implements Serializable{
    
    public static void escribirUsuarios (ArrayList<Persona> arreglo) throws FileNotFoundException, IOException{
        
        File file = new File("contribuyentes.dat");
        FileOutputStream output = new FileOutputStream(file);
        ObjectOutputStream writer = new ObjectOutputStream(output);
        
        writer.writeObject(arreglo);
        
        writer.close();
        output.close();
    }

    public static ArrayList<Persona> cargarUsuarios() throws FileNotFoundException, IOException, ClassNotFoundException{
        
        File file = new File("contribuyentes.dat");
        FileInputStream input = new FileInputStream(file);
        ObjectInputStream reader = new ObjectInputStream(input);
        
        ArrayList<Persona> retorno = (ArrayList<Persona>)reader.readObject();
     
        return retorno;
    }

    public static void crearUsuariosIniciales() throws FileNotFoundException, IOException, IntervalosFechaException, PersonaFisicaException, RFCException {
        
        ArrayList<Persona> UIniciales = new ArrayList<>();
        Fisica juan = new Fisica(new RFC("GABJ9403189IP", TipoPersona.Fisica), "Juan Antonio", "Gabriel", "Bolaños", new Fecha(18,3,1994), "9512515114", new Fecha(15, 8, 2016), new Fecha(1, 12, 2017));
        
        File file = new File("contribuyentes.dat");
        FileOutputStream output = new FileOutputStream(file);
        ObjectOutputStream writer = new ObjectOutputStream(output);
               
        writer.writeObject(UIniciales);
        
        writer.close();
        output.close();
    }
}
