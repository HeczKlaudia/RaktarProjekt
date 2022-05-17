package modell;

import java.io.File;
import java.time.LocalDate;

public class Konzerv extends Elelmiszer {

    private String leiras;
    private File ajanlas;

    public Konzerv(String nev, String gyarto) throws LejaratiDatumException {
        super(nev, gyarto);
    }

    public Konzerv(String leiras, String nev, String gyarto) throws LejaratiDatumException {
        super(nev, gyarto);
        this.leiras = leiras;
    }

    public Konzerv(String leiras, String nev, String gyarto, LocalDate lejaratiDatum) throws LejaratiDatumException {
        super(nev, gyarto, lejaratiDatum);
        this.leiras = leiras;
    }

    void receptMutat() {
        if (ajanlas.exists()) {

        } else {

        }
    }

    @Override
    public String toString() {
        return "Konzerv{" + "leiras=" + leiras + '}';
    }

}
