package Controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import Modelo.Persona;
import java.io.Serializable;

public class BaseDatos implements Serializable{

    private ArrayList<Persona> db;

    public BaseDatos() {
        db = new ArrayList<>();
    }

    public void agregar(Persona p) {
        db.add(p);
    }

    public void guardar() {
        File file = new File("contribuyentes.dat");
        FileOutputStream output;
        try {
            output = new FileOutputStream(file);
            ObjectOutputStream writer = new ObjectOutputStream(output);

            writer.writeObject(db);

            writer.close();
            output.close();
        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        }
    }

}
