package ba.unsa.etf.rpr;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Function;

public class Skola {
    private ArrayList<Osoba> listaOsoba = new ArrayList<>();

    public void dodajOsobu(Osoba ime) {
        listaOsoba.add(ime);
    }

    @Override
    public String toString() {
        String vracam = "";
        for (Osoba o : listaOsoba) {
            if (vracam.length() != 0)
                vracam += "\n";
            vracam += o.toString();
        }
        return vracam;
    }

    public Set<Ucenik> ucenici() {
        TreeSet<Ucenik> vracam = new TreeSet<>();
        for (Osoba o : listaOsoba) {
            if (o instanceof Ucenik)
                vracam.add((Ucenik) o);
        }
        return vracam;
    }

    public List<Osoba> filtriraj(Function<Osoba, Boolean> f) {
        ArrayList<Osoba> rez = new ArrayList<>();
        for (Osoba o : listaOsoba)
            if (f.apply(o)) rez.add(o);
        return rez;

    }

    public List<Osnovac> topOsnovac() {
        List vracam = filtriraj((Osoba o) -> {
            return (o instanceof Osnovac && ((Osnovac) o).prosjek() >= 4);
        });
        return vracam;
    }
    public List<Slavljenik> slavljenici() {
        List<Slavljenik> rez = new ArrayList<>();
        for (Osoba o : listaOsoba)
            if (o instanceof Srednjoskolac || o instanceof Ucitelj)
                rez.add((Slavljenik)o);
        return rez;
    }
}
