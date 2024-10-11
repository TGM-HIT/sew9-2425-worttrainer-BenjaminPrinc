package at.bprinc;

import java.util.Random;

public class Worttrainer {
    private final WortListe wl;
    private int richtig = 0;
    private int falsch = 0;
    Random r = new Random();
    private String currentWord;

    /**
     * Konstruktor um ein neues Worttrainer Spiel zu erstellen
     * @param wl    Wortliste welche die Wörter und Bilder beinhält
     */
    public Worttrainer(WortListe wl) {
        this.wl = wl;
    }

    /**
     * Konstruktor wenn ein ehemaliges Spiel geladen wird
     * @param wl        Wortliste
     * @param richtig   Wieviele Fragen richtig beantwortet wurden
     * @param falsch    Wieviele Fragen falsch beantwortet wurden
     */
    public Worttrainer(WortListe wl, int richtig, int falsch) {
        this.wl = wl;
        this.richtig = richtig;
        this.falsch = falsch;
    }

    public int getFalsch() {
        return falsch;
    }

    public int getRichtig() {
        return richtig;
    }

    /**
     * Wählt zufällig das nächste Wort aus der Wortliste
     * @return  Wort aus der Wortliste
     */
    public Wort nextWort() {
        Wort wtmp = wl.getWort(r.nextInt(wl.size()));
        this.currentWord = wtmp.getWort();
        System.out.println(wtmp.getWort());
        return wtmp;
    }

    public boolean checkAnswer(String answer) {
        if (answer.equalsIgnoreCase(currentWord)) {
            this.richtig++;
            return true;
        } else {
            this.falsch++;
            return false;
        }
    }

}
