package at.bprinc;

import java.util.ArrayList;
import java.util.List;

public class WortListe {
    private List<Wort> wortListe = new ArrayList<>();

    public WortListe(Wort w) {
        wortListe.add(w);
    }

    public void addWort(Wort w) {
        wortListe.add(w);
    }

    public Wort getWort(int index) {
        return wortListe.get(index);
    }

    public int size() {
        return wortListe.size();
    }

    public List<Wort> getWortListe() {
        return wortListe;
    }
}
