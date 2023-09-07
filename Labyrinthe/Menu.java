import java.awt.*;
import java.awt.event.*;
import java.io.File;

import javax.swing.*;

/**
 * Classe Menu.
 * 
 * Cette classe permet de créer un menu.
 * 
 * @version 1.0
 * @author Kohsey DUFOUR
 * @since 2023-04-28
 */
public class Menu extends JFrame implements ActionListener {

    private JButton bouton2;
    private JButton bouton1;

    /**
     * Méthode qui permet de créer une grille.
     * 
     * @param e l'événement.
     */
    public Menu() {
        // Paramètre de base pour l'affichage d'une fenêtre

        super("Labyrinthe de Thésée");
        int hauteurFenetreBase = 500;
        int largeurFenetreBase = 500;
        this.setSize(largeurFenetreBase, hauteurFenetreBase);
        this.setMinimumSize(new Dimension(largeurFenetreBase, hauteurFenetreBase));
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double largeurFenetreUtilisateur = screenSize.getWidth();
        double hauteurFenetreUtilisateur = screenSize.getHeight();
        this.setLocation((int) (largeurFenetreUtilisateur - largeurFenetreBase) / 2,
                (int) (hauteurFenetreUtilisateur - hauteurFenetreBase) / 2);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Création de 2 boutons pour charger ou éditer une grille
        JButton bouton1 = new JButton("Charger une grille");
        bouton1.addActionListener(this);
        bouton2 = new JButton("Créer une grille");
        // Création du panneau pour les 2 boutons
        JPanel panneauBoutons = new JPanel();
        panneauBoutons.add(bouton1);
        panneauBoutons.add(bouton2);
        panneauBoutons.setLayout(null);
        bouton1.setBounds(40, 230, 175, 40);
        bouton2.setBounds(260, 230, 175, 40);
        bouton2.addActionListener(this);

        // Ajout d'un listener pour détecter le changement de taille
        this.addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent e) {
                // Change les emplacements des éléments de la fenetre si fenetre
                // redimensionnée
                bouton1.setLocation(getWidth() / 2 - 200, getHeight() / 2);
                bouton2.setLocation(getWidth() / 2, getHeight() / 2);
            }
        });

        // Ajout du panneau à la fenetre
        this.add(panneauBoutons);

        this.setVisible(true);
        this.bouton2 = bouton2;
        this.bouton1 = bouton1;
    }

    /**
     * Méthode qui permet de créer une grille.
     * 
     * @param e l'événement.
     */
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bouton1) {
            // Non fonctionnel
            // ImportGrid impt = new ImportGrid();
            // impt.setVisible(true);
            // System.out.println(impt.getImportSelectedFile());

            // dispose();
            // Maze maze = new Maze(impt.getImportSelectedFile());

            // maze.setVisible(true);

        } else if (e.getSource() == bouton2) {
            Taille fenetre = new Taille();
            fenetre.setVisible(true);
            dispose();
        }
    }

}
