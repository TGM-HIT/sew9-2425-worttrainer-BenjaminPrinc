package at.bprinc;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

public class GameController {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Wort w1 = new Wort("Hund", "https://cdn.pixabay.com/photo/2018/09/21/23/28/dog-3694266_640.jpg");
        Wort w2 = new Wort("Katze", "https://as1.ftcdn.net/v2/jpg/00/80/25/64/1000_F_80256448_QhTgF4W0v1Ke1rZjSPB15iB6dU62OZHf.jpg");

        WortListe wl = new WortListe(w1);
        wl.addWort(w2);
        Worttrainer wt = new Worttrainer(wl);
        startGame(wt);
    }

    private static void startGame(Worttrainer wt) {
        Overlay overlay = new Overlay();
        try {
            overlay.showNextWort(wt.nextWort());
        }catch (MalformedURLException mue) {
            System.err.println(mue);
        } catch (URISyntaxException use) {
            System.err.println(use);
        }
    }
}