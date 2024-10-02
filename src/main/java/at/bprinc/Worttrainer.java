package at.bprinc;

import java.util.Random;

public class Worttrainer {
    private WortListe wl;
    private int richtig = 0;
    private int falsch = 0;
    private int insgesamt = 0;
    Random r = new Random();

    /**
     * Konstruktor um ein neues Worttrainer Spiel zu erstellen
     * @param wl    Wortliste welche die Wörter und Bilder beinhält
     */
    public Worttrainer(WortListe wl) {
        this.wl = wl;
        this.richtig = 0;
        this.falsch = 0;
        this.insgesamt = 0;
    }

    /**
     * Konstruktor wenn ein ehemaliges Spiel geladen wird
     * @param wl        Wortliste
     * @param richtig   Wieviele Fragen richtig beantwortet wurden
     * @param falsch    Wieviele Fragen falsch beantwortet wurden
     * @param insgesamt Wieviele Fragen insgesamt beantwortet wurden
     */
    public Worttrainer(WortListe wl, int richtig, int falsch, int insgesamt) {
        this.wl = wl;
        this.richtig = richtig;
        this.falsch = falsch;
        this.insgesamt = insgesamt;
    }

    /**
     * Wählt zufällig das nächste Wort aus der Wortliste
     * @return  Wort aus der Wortliste
     */
    public Wort nextWort() {
        insgesamt++;
        Wort wtmp = wl.getWort(r.nextInt(wl.size()));
        System.out.println(wtmp.getWort());
        return wtmp;
    }

}
