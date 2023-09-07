import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;
import java.io.*;
import java.util.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.*;
import java.awt.*;
import java.awt.Toolkit;

/**
 * Classe MazeBuilder.
 * 
 * Cette classe permet de créer un labyrinthe.
 * @version 1.0
 * @author Kohsey DUFOUR
 * @since 2023-04-28
 */
public class MazeBuilder extends JPanel {
    private static int cellSize;
    private static int gridPosition;
    private int length;
    private String choice;
    private int[][] grid;
    private boolean addTile = false;
    private boolean removeTile = false;
    private boolean addTheseus = false;
    private int theseeX = -1;
    private int theseeY = -1;
    private boolean placerSortie = false;
    private int sortieX = -1;
    private int sortieY = -1;
    private ButtonsPanel buttonsPanel;
    private boolean jouer = false;
    private Image theseusImage;
    private Image minautorImage;

    /**
     * Constructeur de la classe MazeBuilder.
     * 
     * @param length la longueur du labyrinthe.
     * @param grid   la grille du labyrinthe.
     * @param choice le choix de l'utilisateur.
     */
    public MazeBuilder(int length, int[][] grid, String choice, int theseeX, int theseeY, int sortieX,
            int sortieY) {
        this.length = length;
        this.grid = grid;
        this.choice = choice;
        this.theseeX = theseeX;
        this.theseeY = theseeY;
        this.sortieX = sortieX;
        this.sortieY = sortieY;
        this.theseusImage = Toolkit.getDefaultToolkit().getImage("theseus.jpg");
        this.minautorImage = Toolkit.getDefaultToolkit().getImage("minotaur.jpg");

        /* BOUTONS */
        // Boutons jeux
        ButtonsPanel buttonsPanel = new ButtonsPanel(this);
        add(buttonsPanel);
        // Recupérer les boutons du panel boutonsJeu
        JButton ajouterMurButton = buttonsPanel.getAjouterMurButton();
        JButton supprimerMurButton = buttonsPanel.getSupprimerMurButton();
        JButton placerTheseeButton = buttonsPanel.getPlacerTheseeButton();
        JButton placerSortieButton = buttonsPanel.getPlacerSortieButton();
        JButton sauvegarderGrilleButton = buttonsPanel.getSauvegarderGrilleButton();

        /* ACTION LISTENERS */

        // Créer l'instance de la classe ListenerbuttonsPanel
        ButtonsPanelListener listenerBoutonsModif = new ButtonsPanelListener(ajouterMurButton, supprimerMurButton,
                placerTheseeButton, placerSortieButton);

        /* FENETRE */
        // Afficher la grille dans une fenêtre
        MazeBuilder labyrinthe = this;
        MazeBuilderWindow fenetre = new MazeBuilderWindow(labyrinthe);

        /* ECOUTEURS */
        this.cellSize = (fenetre.getHeight() - 150) / length;
        this.gridPosition = (fenetre.getWidth() / 2) - ((length * cellSize) / 2);

        // Ajouter un écouteur de clics de souris pour création du Labyrinthe
        this.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                boolean addTile = listenerBoutonsModif.getAjouterMur();
                boolean removeTile = listenerBoutonsModif.getSupprimerMur();
                boolean addTheseus = listenerBoutonsModif.getPlacerThesee();
                boolean placerSortie = listenerBoutonsModif.getPlacerSortie();
                int x = (e.getX() - gridPosition) / cellSize;
                int y = (e.getY() - 50) / cellSize;
                if (!addTile && !removeTile && !addTheseus && !placerSortie) {
                    return;
                }
                if (e.getX() < gridPosition || x >= length || e.getY() < 50 || y >= length) {
                    return;
                }
                if (addTheseus && grid[x][y] != 1 && grid[x][y] != 3) {
                    grid[x][y] = 2;
                    MazeBuilder.this.theseeX = y;
                    MazeBuilder.this.theseeY = x;

                    for (int i = 0; i < length; i++) {
                        for (int j = 0; j < length; j++) {
                            if (grid[i][j] == 2 && (i != x || j != y)) {
                                grid[i][j] = 0;
                            }
                        }
                    }
                } else if (placerSortie && grid[x][y] != 1 && grid[x][y] != 2) {
                    grid[x][y] = 3;
                    MazeBuilder.this.sortieX = y;
                    MazeBuilder.this.sortieY = x;
                    for (int i = 0; i < length; i++) {
                        for (int j = 0; j < length; j++) {
                            if (grid[i][j] == 3 && (i != x || j != y)) {
                                grid[i][j] = 0;
                            }
                        }
                    }
                } else if (addTile && grid[x][y] != 2 && grid[x][y] != 3) {
                    grid[x][y] = 1;
                } else if (removeTile && grid[x][y] != 2 && grid[x][y] != 3) {
                    grid[x][y] = 0;
                }
                repaint();
            }
        });

    }

    /**
     * Méthode qui permet de dessiner le labyrinthe.
     * 
     * @param g le graphique.
     */
    public int getTheseeX() {
        return theseeX;
    }
    /**
     * Méthode qui permet de dessiner le labyrinthe.
     * 
     * @param g le graphique.
     */
    public int getTheseeY() {
        return theseeY;
    }
/**
     * Méthode qui permet de dessiner le labyrinthe.
     * 
     * @param g le graphique.
     */
    public int getSortieX() {
        return sortieX;
    }
/**
     * Méthode qui permet de dessiner le labyrinthe.
     * 
     * @param g le graphique.
     */
    public int getSortieY() {
        return sortieY;
    }
    /**
     * Méthode qui permet de dessiner le labyrinthe.
     * 
     * @param g le graphique.
     */
    public int[][] getGrid() {
        return grid;
    }
    /**
     * Méthode qui permet de dessiner le labyrinthe.
     * 
     * @param g le graphique.
     */
    public int getLength() {
        return length;
    }
    /**
     * Méthode qui permet de dessiner le labyrinthe.
     * 
     * @param g le graphique.
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (grid[i][j] == 1) {
                    g.setColor(Color.BLACK);
                } else if (grid[i][j] == 0) {
                    g.setColor(Color.WHITE);
                }
                g.fillRect(i * cellSize + gridPosition, j * cellSize + 50, cellSize, cellSize);
                if (grid[i][j] == 2) {
                    g.drawImage(theseusImage, i * cellSize + gridPosition, j * cellSize + 50, cellSize, cellSize, this);
                    // g.setColor(new Color(0, 100, 0));
                    // g.setFont(new Font("Arial", Font.BOLD, cellSize));
                    // g.drawString("Θ", i * cellSize + gridPosition + (cellSize / 2) - (cellSize /
                    // 3), j * cellSize + 50 + (cellSize / 2) + (cellSize / 3));
                }
                if (grid[i][j] == 3) {
                    g.drawImage(minautorImage, i * cellSize + gridPosition, j * cellSize + 50, cellSize, cellSize,
                            this);
                    // g.setColor(Color.RED);
                    // g.setFont(new Font("Arial", Font.BOLD, cellSize));
                    // g.drawString("∩", i * cellSize + gridPosition + (cellSize / 2) - (cellSize /
                    // 3), j * cellSize + 50 + (cellSize / 2) + (cellSize / 3));
                }
            }
        }

        // dessin des bords
        g.setColor(Color.BLACK);
        for (int i = 0; i <= length; i++) {
            g.drawLine(gridPosition, i * cellSize + 50, length * cellSize + gridPosition, i * cellSize + 50);
            g.drawLine(i * cellSize + gridPosition, 50, i * cellSize + gridPosition, length * cellSize + 50);
        }
    }

}