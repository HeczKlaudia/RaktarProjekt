package modell;

import java.text.Collator;
import java.time.LocalDate;
import java.util.Comparator;

class nevComparator implements Comparator<Elelmiszer> {

    @Override
    public int compare(Elelmiszer o1, Elelmiszer o2) {
        Collator coll = Collator.getInstance();
        return coll.compare(o1.getNev(), o2.getNev());
    }
    
}

class gyartoComparator implements Comparator<Elelmiszer> {

    @Override
    public int compare(Elelmiszer o1, Elelmiszer o2) {
        Collator coll = Collator.getInstance();
        return coll.compare(o1.getGyarto(), o2.getGyarto());
    }
    
}

public abstract class Elelmiszer {
    
    private String nev, gyarto;
    private LocalDate lejaratiDatum;

    public Elelmiszer(String nev, String gyarto) throws LejaratiDatumException {
        this.nev = nev;
        this.gyarto = gyarto;
        this.lejaratiDatum = lejaratiDatum.plusYears(1);
    }
    
    public Elelmiszer(String nev, String gyarto, LocalDate lejaratiDatum) throws LejaratiDatumException {
        this.nev = nev;
        this.gyarto = gyarto;
        this.lejaratiDatum = lejaratiDatum.plusDays(1);
        if (!lejaratiDatum.isAfter(LocalDate.now())) {
            System.out.println("lejárt élelmiszer");
        }
    }

    public String getNev() {
        return nev;
    }

    public String getGyarto() {
        return gyarto;
    }

    public LocalDate getLejaratiDatum() {
        return lejaratiDatum;
    }

    public static nevComparator nevRendezo() {
        return new nevComparator();
    }
    
    public static gyartoComparator gyartoRendezo() {
        return new gyartoComparator();
    }
    
    @Override
    public String toString() {
        return "Elelmiszer{" + "nev=" + nev + ", gyarto=" + gyarto + ", lejaratiDatum=" + lejaratiDatum + '}';
    }
    
}
