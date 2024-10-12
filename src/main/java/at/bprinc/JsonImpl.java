package at.bprinc;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;

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
        Worttrainer loadedWt = null;
        try(BufferedReader br = new BufferedReader(new FileReader("save.json"))) {
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }

            JSONObject jsonObject = new JSONObject(sb.toString());
            JSONArray jsonWortliste = jsonObject.getJSONArray("wortliste");
            WortListe loadedWl = null;
            for (int i = 0; i < jsonWortliste.length(); i++) {
                JSONObject jsonWort = jsonWortliste.getJSONObject(i);
                Wort wtmp = new Wort(jsonWort.getString("wort"), jsonWort.getString("url"));
                if (loadedWl == null) {
                    loadedWl = new WortListe(wtmp);
                } else {
                    loadedWl.addWort(wtmp);
                }
            }

            loadedWt = new Worttrainer(loadedWl, jsonObject.getInt("richtig"), jsonObject.getInt("falsch"));
        }catch (IOException ioe) {
            System.err.println("Fehler beim laden: "+ioe.getMessage());
        }

        return loadedWt;
    }
}
