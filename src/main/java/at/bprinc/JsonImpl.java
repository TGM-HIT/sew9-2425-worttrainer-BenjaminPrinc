package at.bprinc;

import org.json.JSONObject;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class JsonImpl implements SaveLoad{

    @Override
    public void speichern(Worttrainer wt) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("wortliste", wt.getWl());
        jsonObject.put("richtig", wt.getRichtig());
        jsonObject.put("falsch", wt.getFalsch());
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("save.json"))) {
            bw.write(jsonObject.toString());
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
