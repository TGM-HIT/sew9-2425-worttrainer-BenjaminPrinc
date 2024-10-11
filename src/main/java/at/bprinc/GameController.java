package at.bprinc;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

public class GameController {
    static Worttrainer wt;
    public static void main(String[] args) {
        System.out.println("Worttrainer gestartet");
        Wort w1 = new Wort("Hund", "https://cdn.pixabay.com/photo/2018/09/21/23/28/dog-3694266_640.jpg");
        Wort w2 = new Wort("Katze", "https://as1.ftcdn.net/v2/jpg/00/80/25/64/1000_F_80256448_QhTgF4W0v1Ke1rZjSPB15iB6dU62OZHf.jpg");

        WortListe wl = new WortListe(w1);
        wl.addWort(w2);
        wt = new Worttrainer(wl);
        startGame(wt);
    }

    private static void startGame(Worttrainer wt) {
        Overlay overlay = new Overlay();
        boolean rightAnswer = false;
        try {
            while(true) {
                Wort tmp = wt.nextWort();
                do {
                    String response = overlay.showNextWort(tmp);
                    if (response != null && !response.isEmpty()) {
                        if (wt.checkAnswer(response)) {
                            rightAnswer = true;
                            overlay.showSuccessMessage(new int[]{wt.getRichtig(), wt.getFalsch()});
                        } else {
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

    }
}