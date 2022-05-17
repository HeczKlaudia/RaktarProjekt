package modell;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Raktar implements Iterable<Elelmiszer>, Serializable {
    
    private ArrayList<Elelmiszer> elelmiszerek;

    public Raktar() {
        this.elelmiszerek = new ArrayList<>();
        
        try {
            Konzerv k1 = new Konzerv("pörkölt", "Uncle Bens");
            Konzerv k2 = new Konzerv("löncshús konzerv", "löncshús", "gyártó");
            Konzerv k3 = new Konzerv("löncshús konzerv2", "löncshús2", "gyártó2", LocalDate.MIN);
            
            elelmiszerek.add(k1);
            elelmiszerek.add(k2);
            elelmiszerek.add(k3);
            
        } catch (LejaratiDatumException ex) {
            Logger.getLogger(Raktar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void felvesz(Elelmiszer elelmiszer) {
        elelmiszerek.add(elelmiszer);
    }

    @Override
    public Iterator<Elelmiszer> iterator() {
        return Collections.unmodifiableList(elelmiszerek).iterator();
    }
    
    public List<Elelmiszer> rendezNevSzerint() {
        Collections.sort(elelmiszerek, Elelmiszer.nevRendezo());
        return Collections.unmodifiableList(elelmiszerek);
    }
    
    public List<Elelmiszer> rendezGyartoSzerint() {
        Collections.sort(elelmiszerek, Elelmiszer.gyartoRendezo());
        return Collections.unmodifiableList(elelmiszerek);
    }
    
}
