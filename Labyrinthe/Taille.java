import java.awt.BorderLayout;

import javax.swing.*;
import java.awt.*;

import javax.swing.*;

/**
 * Taille est une classe qui permet de choisir la taille du labyrinthe
 * 
 * @version 1.0
 * @author Kohsey DUFOUR
 * @since 2023-04-28
 */
public class Taille extends JFrame {
    /**
     * Constructeur de la classe Taille.
     * Il permet de créer une fenêtre qui demande à l'utilisateur de choisir la
     * taille du labyrinthe.
     */
    public Taille() {
        JTextField tailleField = new JTextField();
        add(tailleField, BorderLayout.CENTER);
        setSize(300, 50);
        setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        int hauteurFenetreBase = 500;
        int largeurFenetreBase = 500;
        this.setSize(largeurFenetreBase, hauteurFenetreBase);
        this.setMinimumSize(new Dimension(largeurFenetreBase, hauteurFenetreBase));
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double largeurFenetreUtilisateur = screenSize.getWidth();
        double hauteurFenetreUtilisateur = screenSize.getHeight();
        this.setLocation((int) (largeurFenetreUtilisateur - largeurFenetreBase) / 2,
                (int) (hauteurFenetreUtilisateur - hauteurFenetreBase) / 2);

        JButton button = new JButton("Valider");
        add(button, BorderLayout.SOUTH);
        button.addActionListener(e -> {
            String tailleString = tailleField.getText();
            if (tailleString.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Le champ est vide !", "Erreur", JOptionPane.ERROR_MESSAGE);
            } else {
                try {
                    int tailleInt = Integer.parseInt(tailleString);

                    int[][] grid = new int[tailleInt][tailleInt];
                    for (int i = 0; i < tailleInt; i++) {
                        for (int j = 0; j < tailleInt; j++) {
                            grid[i][j] = 0;
                        }
                    }

                    MazeBuilder labyrinthe = new MazeBuilder(tailleInt, grid, "random", 0, 0, tailleInt - 1,
                            tailleInt - 1);
                    labyrinthe.setVisible(true);
                    dispose();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Le champ ne contient pas un nombre valide !", "Erreur",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}