package at.bprinc;

public class Wort {
    private String wort;
    private String url;

    public Wort(String wort, String url) {
        setWort(wort);
        setUrl(url);
    }

    public void setWort(String w) {
        wort = w;
    }

    public void setUrl(String u) {
        url = u;
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

    public boolean checkUrl(String u) {
        // TODO implement regex check
        return u.length()>8;
    }

    @Override
    public String toString() {
        return "Wort=" + wort + ", url=" + url;
    }
}
