import java.awt.*;
import javax.swing.*;

/**
 * Classe qui représente la grille de carres.
 * 
 * @version 1.0
 * @author Kohsey DUFOUR
 * @since 2023-04-28
 */
public class SquaresGrid extends JPanel {
    private int length; // Nombre de carres par ligne/colonne
    private int[][] squares; // Tableau de carres
    private int panelSize;
    private int xTheseus;
    private int yTheseus;
    private int xExit;
    private int yExit;
    private Image tileImage;
    private Image theseusImage;
    private Image minautorImage;

    /**
     * Constructeur de la classe SquaresGrid.
     * 
     * @param length   le nombre de carres par ligne/colonne.
     * @param squares  le tableau de carres.
     * @param xTheseus la position en x de Thesee.
     * @param yTheseus la position en y de Thesee.
     * @param xExit    la position en x de la sortie.
     * @param yExit    la position en y de la sortie.
     */
    public SquaresGrid(int length, int[][] squares, int xTheseus, int yTheseus, int xExit, int yExit) {
        this.length = length;
        this.squares = squares;
        this.xTheseus = xTheseus;
        this.yTheseus = yTheseus;
        this.xExit = xExit;
        this.yExit = yExit;
        // Charger l'image
        this.tileImage = Toolkit.getDefaultToolkit().getImage("tile.jpg");
        this.theseusImage = Toolkit.getDefaultToolkit().getImage("theseus.jpg");
        this.minautorImage = Toolkit.getDefaultToolkit().getImage("minotaur.jpg");
        // Configuration de la taille du panneau
        this.panelSize = (int) Math.ceil(400 / length);
        // setPreferredSize(new Dimension(panelSize, panelSize));
    }

    /**
     * Getter de la taille du panneau.
     * 
     * @return la taille du panneau.
     */
    public int getPanelSize() {
        return panelSize;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Dessin des carres + Thesee et sortie
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (xTheseus == i && yTheseus == j) {
                    // g.setColor(Color.GREEN);
                    // g.fillRect(i * panelSize, j * panelSize, panelSize, panelSize);
                    g.drawImage(theseusImage, i * panelSize, j * panelSize, panelSize, panelSize, this);
                } else if (xExit == i && yExit == j) {
                    // g.setColor(Color.RED);
                    // g.fillRect(i * panelSize, j * panelSize, panelSize, panelSize);
                    g.drawImage(minautorImage, i * panelSize, j * panelSize, panelSize, panelSize, this);
                } else if (squares[i][j] == 1) {
                    // Dessiner l'image
                    g.drawImage(tileImage, i * panelSize, j * panelSize, panelSize, panelSize, this);
                } else {
                    g.setColor(Color.WHITE);
                    g.fillRect(i * panelSize, j * panelSize, panelSize, panelSize);
                }
            }
        }
        // g.drawImage(tileImage, 250, 250, 500, 500, this);
    }

    /**
     * Getter de la longueur de la grille.
     * 
     * @return la longueur de la grille.
     */
    public int getHeight() {
        return this.length * this.panelSize;
    }

    /**
     * Getter de la largeur de la grille.
     * 
     * @return la largeur de la grille.
     */
    public int getWidth() {
        return this.length * this.panelSize;
    }

    /**
     * Setter de la position de Thesee.
     * 
     * @param x la position en x de Thesee.
     * @param y la position en y de Thesee.
     */
    public void setLocation(int x, int y) {
        super.setLocation(x, y);
    }
}