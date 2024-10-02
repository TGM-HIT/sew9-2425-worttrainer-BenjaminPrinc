package at.bprinc;

public class Worttrainer {
    private WortListe wl;
    private int richtig = 0;
    private int falsch = 0;
    private int insgesamt = 0;

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
     * @param insgesamt Wieviele Fragen insgesamt beantwortet wurden
     */
    public Worttrainer(WortListe wl, int richtig, int falsch, int insgesamt) {
        this.wl = wl;
        this.richtig = richtig;
        this.falsch = falsch;
        this.insgesamt = insgesamt;
    }


}
