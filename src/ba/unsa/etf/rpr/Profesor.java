package ba.unsa.etf.rpr;

public class Profesor extends Nastavnik {
    public Profesor(String ime) {
        super(ime);
    }

    @Override
    public String toString() {
        return "Profesor "+super.getImePrezime();
    }
}
