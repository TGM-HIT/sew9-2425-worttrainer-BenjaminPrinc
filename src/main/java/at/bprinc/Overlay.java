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

    private int versuch = 1;

    public void setVersuch(int versuch) {
        this.versuch = versuch;
    }

    public int getVersuch() {
        return this.versuch;
    }

    /**
     * Methode welche einen Worteintrag übernimmt und das Bild sowie ein Eingabefeld anzeigt
     * @param w                         Worteintrag welcher das richtige Wort sowie die URL zum Bild enthält
     * @throws MalformedURLException    Wird geworfen, falls eine ungültige URL verwendet wird
     * @throws URISyntaxException       Wird geworfen, wenn der String keine gültige URL enthält
     */
    public String showNextWort(Wort w) throws MalformedURLException, URISyntaxException {
        System.out.println(this.versuch);
        URI uri = new URI(w.getUrl());
        ImageIcon icon = new ImageIcon(uri.toURL());
        Image image = icon.getImage();
        Image resizeImage = image.getScaledInstance(240, 240, Image.SCALE_SMOOTH);
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // Vertikale Anordnung

        if (versuch > 1) {
            JLabel versuchText = new JLabel("Vorherige Antwort war falsch. Versuch: " + versuch);
            versuchText.setAlignmentX(Component.CENTER_ALIGNMENT);
            panel.add(versuchText);
        }

        // JLabel mit dem Bild hinzufügen
        JLabel imageLabel = new JLabel(new ImageIcon(resizeImage));
        imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(imageLabel);

        panel.add(Box.createRigidArea(new Dimension(0, 15)));

        JButton speicherbtn = new JButton("Speichern");
        JButton ladenbtn = new JButton("Laden");
        speicherbtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        ladenbtn.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
        buttonPanel.add(speicherbtn);
        buttonPanel.add(Box.createRigidArea(new Dimension(10, 0)));
        buttonPanel.add(ladenbtn);

        speicherbtn.addActionListener(e -> GameController.saveGame());

        ladenbtn.addActionListener(e -> GameController.loadGame());

        panel.add(buttonPanel);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
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
        } else if (option == JOptionPane.CANCEL_OPTION) {
            //Bei Klick auf Cancel wird das Programm beendet
            System.exit(0);
        }
        return "";
    }

    public void showSuccessMessage(int[] stats) {
        JOptionPane.showMessageDialog(null, "Wort richtig erraten!\nInsgesamt richtig erraten: "+stats[0]+", falsch erraten: "+stats[1], "Worttrainer", JOptionPane.INFORMATION_MESSAGE);
    }

    public void showFailMessage(){
        JOptionPane.showMessageDialog(null, "Leider falsch!", null, JOptionPane.ERROR_MESSAGE);
    }
}
