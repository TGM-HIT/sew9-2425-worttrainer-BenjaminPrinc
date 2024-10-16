package at.bprinc;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class Wort {
    private String wort;
    private String url;

    public Wort(String wort, String url) {
        setWort(wort);
        setUrl(url);
    }

    public void setWort(String w) throws IllegalArgumentException {
        if (checkWort(w)) {
            this.wort = w;
        } else {
            throw new IllegalArgumentException("Ungültiges Wort");
        }
    }

    public void setUrl(String u) throws IllegalArgumentException {
        if (checkUrl(u)) {
            url = u;
        } else {
            throw new IllegalArgumentException("Ungültige URL");
        }
    }

    public String getWort() {
        return wort;
    }

    public String getUrl() {
        return url;
    }

    public boolean checkWort(String w) {
        return w.length()>2;
    }

    public static boolean checkUrl(String u) {
        try {
            URL url = new URL(u);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");  // HTTP-Methode GET
            connection.setConnectTimeout(5000);  // Timeout für die Verbindung
            connection.setReadTimeout(5000);     // Timeout für das Lesen der Antwort

            int statusCode = connection.getResponseCode();

            if (statusCode == HttpURLConnection.HTTP_OK) {
                return true;
            } else {
                return false;
            }
        } catch (IOException e) {
            return false;
        }
    }

    @Override
    public String toString() {
        return "Wort=" + wort + ", url=" + url;
    }
}
