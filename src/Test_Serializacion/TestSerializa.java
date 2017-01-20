
package Test_Serializacion;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class TestSerializa {
    
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        escribirObjetos();
        File file = new File("Pchon.txt");
        FileInputStream input = new FileInputStream(file);
        ObjectInputStream reader = new ObjectInputStream(input);
        
        while(input.available() > 0){
            Alumno obj = (Alumno)reader.readObject();
            System.out.println(obj);
        }
        
        input.close();
        reader.close();
    }
    
    public static void escribirObjetos() throws FileNotFoundException, IOException {
        
        Alumno Fernando = new Alumno("Fernando", 20, (float)5.95);
        
        File file = new File("Pchon.txt");
        FileOutputStream output = new FileOutputStream(file);
        ObjectOutputStream writer = new ObjectOutputStream(output);
        
        writer.writeObject(Fernando);
        
        
    }
}
