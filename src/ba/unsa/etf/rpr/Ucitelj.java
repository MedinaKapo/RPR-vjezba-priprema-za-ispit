package ba.unsa.etf.rpr;

public class Ucitelj extends Nastavnik implements  Slavljenik{
    public Ucitelj(String ime) {
        super(ime);
    }

    @Override
    public String toString() {
        return "Učitelj "+super.getImePrezime();
    }
}
