package at.bprinc;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class JsonImpl implements SaveLoad{

    @Override
    public void speichern(Worttrainer wt) {
        JSONArray jsonWortliste = new JSONArray();
        for (Wort w : wt.getWl().getWortListe()) {
            JSONObject jsonWort = new JSONObject();
            jsonWort.put("wort", w.getWort());
            jsonWort.put("url", w.getUrl());
            jsonWortliste.put(jsonWort);
        }

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("wortliste", jsonWortliste);
        jsonObject.put("richtig", wt.getRichtig());
        jsonObject.put("falsch", wt.getFalsch());
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("save.json"))) {
            bw.write(jsonObject.toString(4));
        } catch (IOException ioe) {
            System.err.println("Fehler bei speichern: "+ioe.getMessage());
        }
    }

    @Override
    public Worttrainer laden() {
        //TODO Implementation
        return new Worttrainer(new WortListe(new Wort("WIP", "https://todo.com")));
    }
}
