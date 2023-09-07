
/**
 * La classe ButtonsPanelListener gère les événements des boutons de jeu.
 * Elle contient des classes internes pour chaque bouton : Ajouter, Supprimer,
 * Placer Thesee et Placer Sortie.
 * 
 * @version 1.0
 * @author Kohsey DUFOUR
 * @since 2023-04-28
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ButtonsPanelListener {

    private JButton ajouterMurButton;
    private JButton supprimerMurButton;
    private JButton placerTheseeButton;
    private JButton placerSortieButton;
    private boolean ajouterMur = false; // Indique si on doit ajouter un mur
    private boolean supprimerMur = false; // Indique si on doit supprimer un mur
    private boolean placerThesee = false; // Indique si on doit ajouter Thesee
    private boolean placerSortie = false; // Indique si on doit ajouter la sortie

    /**
     * Constructeur de la classe ButtonsPanelListener.
     *
     * @param ajouterMurButton   Le bouton "Ajouter mur"
     * @param supprimerMurButton Le bouton "Supprimer mur"
     * @param placerTheseeButton Le bouton "Placer Thesee"
     * @param placerSortieButton Le bouton "Placer Sortie"
     */
    public ButtonsPanelListener(JButton ajouterMurButton, JButton supprimerMurButton, JButton placerTheseeButton,
            JButton placerSortieButton) {
        this.ajouterMurButton = ajouterMurButton;
        this.supprimerMurButton = supprimerMurButton;
        this.placerTheseeButton = placerTheseeButton;
        this.placerSortieButton = placerSortieButton;

        ajouterMurButton.addActionListener(new AjouterMurListener());
        supprimerMurButton.addActionListener(new SupprimerMurListener());
        placerTheseeButton.addActionListener(new PlacerTheseeListener());
        placerSortieButton.addActionListener(new PlacerSortieListener());
    }

    /**
     * La classe AjouterMurListener gère les événements du bouton "Ajouter mur".
     */
    private class AjouterMurListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            ajouterMur = !ajouterMur; // Inverser la valeur de ajouterMur
            if (ajouterMur) {
                ajouterMurButton.setText("Ajouter mur ACTIF !");
                supprimerMurButton.setEnabled(false); // Désactiver le bouton "Supprimer mur"
                placerTheseeButton.setEnabled(false); // Désactiver le bouton "Placer Thesee"
                placerSortieButton.setEnabled(false); // Désactiver le bouton "Placer Sortie"
            } else {
                ajouterMurButton.setText("Ajouter mur");
                supprimerMurButton.setEnabled(true); // Réactiver le bouton "Supprimer mur"
                placerTheseeButton.setEnabled(true); // Réactiver le bouton "Placer Thesee"
                placerSortieButton.setEnabled(true); // Réactiver le bouton "Placer Sortie"
            }
        }
    }

    /**
     * La classe SupprimerMurListener gère les événements du bouton "Supprimer mur".
     */
    private class SupprimerMurListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            supprimerMur = !supprimerMur; // Inverser la valeur de supprimerMur
            if (supprimerMur) {
                supprimerMurButton.setText("Supprimer mur ACTIF !");
                ajouterMurButton.setEnabled(false); // Désactiver le bouton "Ajouter/Supprimer mur"
                placerTheseeButton.setEnabled(false); // Désactiver le bouton "Placer Thesee"
                placerSortieButton.setEnabled(false); // Désactiver le bouton "Placer Sortie"
            } else {
                supprimerMurButton.setText("Supprimer mur");
                ajouterMurButton.setEnabled(true); // Réactiver le bouton "Ajouter/Supprimer mur"
                placerTheseeButton.setEnabled(true); // Réactiver le bouton "Placer Thesee"
                placerSortieButton.setEnabled(true); // Réactiver le bouton "Placer Sortie"
            }
        }
    }

    /*
     * La classe PlacerTheseeListener gère les événements du bouton "Placer Thesee".
     */
    private class PlacerTheseeListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            placerThesee = !placerThesee; // Inverser la valeur de placerThesee
            if (placerThesee) {
                placerTheseeButton.setText("Placer Thesee ACTIF !");
                ajouterMurButton.setEnabled(false); // Désactiver le bouton "Ajouter/Supprimer mur"
                supprimerMurButton.setEnabled(false); // Désactiver le bouton "Supprimer mur"
                placerSortieButton.setEnabled(false); // Désactiver le bouton "Placer Sortie"
            } else {
                placerTheseeButton.setText("Placer Thesee");
                ajouterMurButton.setEnabled(true); // Réactiver le bouton "Ajouter/Supprimer mur"
                supprimerMurButton.setEnabled(true); // Réactiver le bouton "Supprimer mur"
                placerSortieButton.setEnabled(true); // Réactiver le bouton "Placer Sortie"
            }
        }
    }

    /**
     * La classe PlacerSortieListener gère les événements du bouton "Placer Sortie".
     */

    private class PlacerSortieListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            placerSortie = !placerSortie; // Inverser la valeur de placerSortie
            if (placerSortie) {
                placerSortieButton.setText("Placer Sortie ACTIF !");
                ajouterMurButton.setEnabled(false); // Désactiver le bouton "Ajouter/Supprimer mur"
                supprimerMurButton.setEnabled(false); // Désactiver le bouton "Supprimer mur"
                placerTheseeButton.setEnabled(false); // Désactiver le bouton "Placer Thesee"
            } else {
                placerSortieButton.setText("Placer Sortie");
                ajouterMurButton.setEnabled(true); // Réactiver le bouton "Ajouter/Supprimer mur"
                supprimerMurButton.setEnabled(true); // Réactiver le bouton "Supprimer mur"
                placerTheseeButton.setEnabled(true); // Réactiver le bouton "Placer Thesee"
            }
        }
    }

    // Getters
    /**
     * Retourne la valeur de ajouterMur.
     *
     * @return La valeur de ajouterMur
     */
    public boolean getAjouterMur() {
        return ajouterMur;
    }

    /**
     * Retourne la valeur de supprimerMur.
     *
     * @return La valeur de supprimerMur
     */
    public boolean getSupprimerMur() {
        return supprimerMur;
    }

    /**
     * Retourne la valeur de placerThesee.
     *
     * @return La valeur de placerThesee
     */
    public boolean getPlacerThesee() {
        return placerThesee;
    }

    /**
     * Retourne la valeur de placerSortie.
     *
     * @return La valeur de placerSortie
     */
    public boolean getPlacerSortie() {
        return placerSortie;
    }
}
