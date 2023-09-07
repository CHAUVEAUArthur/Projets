
/**
 * La classe BoutonsJeu permet de créer les boutons du jeu.
 * Elle contient les boutons "Ajouter", "Supprimer", "Placer Thesee", "Placer Sortie" et "Sauvegarder".
 * @version 1.0
 * @author Kohsey DUFOUR
 * @since 2023-04-28
**/

import javax.swing.*;
import java.awt.*;

public class ButtonsPanel extends JPanel {
    private JButton ajouterMurButton;
    private JButton supprimerMurButton;
    private JButton placerTheseeButton;
    private JButton placerSortieButton;
    private JButton sauvegarderGrilleButton;
    private MazeBuilder mazeBuilder;

    /**
     * Constructeur de la classe BoutonsJeu.
     */

    public ButtonsPanel(MazeBuilder mazeBuilder) {
        ajouterMurButton = new JButton("Ajouter");
        ajouterMurButton.setBackground(Color.black);
        ajouterMurButton.setForeground(Color.white);

        supprimerMurButton = new JButton("Supprimer");
        supprimerMurButton.setBackground(Color.white);
        supprimerMurButton.setForeground(Color.black);

        placerTheseeButton = new JButton("Placer Thesee");
        placerTheseeButton.setBackground(new Color(0, 100, 0));
        placerTheseeButton.setForeground(Color.white);

        placerSortieButton = new JButton("Placer Sortie");
        placerSortieButton.setBackground(Color.red);

        sauvegarderGrilleButton = new JButton("Sauvegarder");
        sauvegarderGrilleButton.setBackground(Color.blue);
        sauvegarderGrilleButton.setForeground(Color.white);
        sauvegarderGrilleButton.addActionListener(new ButtonSaveListener(mazeBuilder));

        add(ajouterMurButton);
        add(supprimerMurButton);
        add(placerTheseeButton);
        add(placerSortieButton);
        add(sauvegarderGrilleButton);
    }

    public JButton getAjouterMurButton() {
        return ajouterMurButton;
    }

    /**
     * Retourne le bouton "Supprimer".
     */
    public JButton getSupprimerMurButton() {
        return supprimerMurButton;
    }

    /**
     * Retourne le bouton "Placer Thesee".
     */
    public JButton getPlacerTheseeButton() {
        return placerTheseeButton;
    }

    /**
     * Retourne le bouton "Placer Sortie".
     */
    public JButton getPlacerSortieButton() {
        return placerSortieButton;
    }

    /**
     * Retourne le bouton "Sauvegarder".
     */
    public JButton getSauvegarderGrilleButton() {
        return sauvegarderGrilleButton;
    }
}
