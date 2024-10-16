package at.bprinc;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

public class GameController {
    static Worttrainer wt;
    public static void main(String[] args) {
        System.out.println("Worttrainer gestartet");
        Wort w1 = new Wort("Hund", "https://cdn.pixabay.com/photo/2018/09/21/23/28/dog-3694266_640.jpg");
        Wort w2 = new Wort("Katze", "https://as1.ftcdn.net/v2/jpg/00/80/25/64/1000_F_80256448_QhTgF4W0v1Ke1rZjSPB15iB6dU62OZHf.jpg");
        Wort w3 = new Wort("Apfel", "https://www.gruene-kueche.de/wp-content/uploads/56634773_apfel-klein.jpg");
        Wort w4 = new Wort("Birne", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQDIcKuSyi0H0k7Dm4hlUSJDi3nPmZBb6suNA&s");

        WortListe wl = new WortListe(w1);
        wl.addWort(w2);
        wl.addWort(w3);
        wl.addWort(w4);
        wt = new Worttrainer(wl);
        startGame(wt);
    }

    private static void startGame(Worttrainer wt) {
        Overlay overlay = new Overlay();
        boolean rightAnswer = false;
        try {
            while(true) {
                Wort tmp = wt.nextWort();
                overlay.setVersuch(1);
                rightAnswer = false;
                do {
                    String response = overlay.showNextWort(tmp);
                    if (response != null && !response.isEmpty()) {
                        if (wt.checkAnswer(response)) {
                            rightAnswer = true;
                            overlay.showSuccessMessage(new int[]{wt.getRichtig(), wt.getFalsch()});
                        } else {
                            overlay.setVersuch(overlay.getVersuch() + 1);
                            overlay.showFailMessage();
                        }
                    }
                } while (!rightAnswer);
            }
        }catch (MalformedURLException mue) {
            System.err.println(mue);
        } catch (URISyntaxException use) {
            System.err.println(use);
        }
    }

    public static void saveGame() {
        SaveLoad sv = new JsonImpl();
        sv.speichern(wt);
        System.out.println("Erfolgreich gespeichert!");
    }

    public static void loadGame() {
        SaveLoad sv = new JsonImpl();
        Worttrainer wtloaded = sv.laden();
        if (wtloaded != null) {
            wt.setWl(wtloaded.getWl());
            wt.setRichtig(wtloaded.getRichtig());
            wt.setFalsch(wtloaded.getFalsch());
            System.out.println("Erfolgreich geladen!");
        }
    }
}