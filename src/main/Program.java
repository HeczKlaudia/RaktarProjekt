package main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import modell.Raktar;

public class Program {

    public static void main(String[] args) throws IOException {

        Raktar raktar = new Raktar();

        try {
            ObjectOutputStream objKi = new ObjectOutputStream(new FileOutputStream("raktar.bin"));
            objKi.writeObject(raktar);
            objKi.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Program.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        ObjectInputStream objBe = new ObjectInputStream(new FileInputStream("raktar.bin"));
        try {
            raktar = (Raktar)objBe.readObject();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Program.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

}
