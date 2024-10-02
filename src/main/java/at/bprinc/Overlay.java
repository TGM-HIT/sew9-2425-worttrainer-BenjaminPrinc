package at.bprinc;

import javax.swing.*;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * Klasse welche für die grafische Oberfläche des Programmes verantwortlich ist
 * @author Benjamin Princ
 * @version 02-10-2024
 */
public class Overlay {
    /**
     * Methode welche einen Worteintrag übernimmt und das Bild sowie ein Eingabefeld anzeigt
     * @param w                         Worteintrag welcher das richtige Wort sowie die URL zum Bild enthält
     * @throws MalformedURLException    Wird geworfen, falls eine ungültige URL verwendet wird
     * @throws URISyntaxException       Wird geworfen, wenn der String keine gültige URL enthält
     */
    public String showNextWort(Wort w) throws MalformedURLException, URISyntaxException {
        URI uri = new URI(w.getUrl());
        ImageIcon icon = new ImageIcon(uri.toURL());
        Image image = icon.getImage();
        Image resizeImage = image.getScaledInstance(240, 240, Image.SCALE_SMOOTH);
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // Vertikale Anordnung

        // JLabel mit dem Bild hinzufügen
        JLabel imageLabel = new JLabel(new ImageIcon(resizeImage));
        panel.add(imageLabel);

        // Leeres Textfeld für den Input hinzufügen
        JTextField textField = new JTextField(10); // 10 Spalten, kann angepasst werden
        panel.add(textField);

        // JOptionPane anzeigen
        int option = JOptionPane.showConfirmDialog(null, panel, "Worttrainer", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        // Überprüfen, ob "OK" gedrückt wurde und Eingabe abrufen
        if (option == JOptionPane.OK_OPTION) {
            String input = textField.getText();
            System.out.println("Eingegebener Text: " + input);
            return input;
        }
        return "";
    }
}
