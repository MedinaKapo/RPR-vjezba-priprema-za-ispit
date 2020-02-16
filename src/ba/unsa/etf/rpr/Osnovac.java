package ba.unsa.etf.rpr;

public class Osnovac extends Ucenik {
    public Osnovac(String ime) {
        super(ime);
    }

    @Override
    public String toString() {
        return "Učenik osnovne škole "+super.toString();
    }
}
