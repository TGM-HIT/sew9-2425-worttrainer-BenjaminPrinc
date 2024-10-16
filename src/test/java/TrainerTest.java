import at.bprinc.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TrainerTest {
    Wort w;

    @BeforeEach
    public void setUp() {
        w = new Wort("Hund", "https://cdn.pixabay.com/photo/2018/09/21/23/28/dog-3694266_640.jpg");
    }

    @Test
    @DisplayName("URL check true")
    public void urlTest() {
        assertTrue(Wort.checkUrl("https://cdn.pixabay.com/photo/2018/09/21/23/28/dog-3694266_640.jpg"));
    }

    @Test
    @DisplayName("URL check false")
    public void urlFailTest() {
        assertFalse(Wort.checkUrl("https://sewistgrossartig.xyz"));
    }

    @Test
    @DisplayName("Neues Wort")
    public void neuesWort() {
        assertEquals("Hund", w.getWort());
        assertEquals("https://cdn.pixabay.com/photo/2018/09/21/23/28/dog-3694266_640.jpg", w.getUrl());
    }

    @Test
    @DisplayName("Wort ändern")
    public void wortAendern() {
        assertEquals("Hund", w.getWort());
        w.setWort("Katze");
        assertEquals("Katze", w.getWort());
    }

    @Test
    @DisplayName("Antwort überprüfen")
    public void antwortPruefen() {
        Worttrainer wt = new Worttrainer(new WortListe(w));
        wt.nextWort();
        assertFalse(wt.checkAnswer("asfsa"));
        assertTrue(wt.checkAnswer("Hund"));
    }
}
