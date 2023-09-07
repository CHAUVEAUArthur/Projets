import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Classe permettant d'afficher le labyrinthe.
 * 
 * @version 1.0
 * @author Kohsey DUFOUR
 * @since 2023-04-28
 */
public class ShowMaze extends JFrame implements KeyListener {
    private int xTheseus;
    private int yTheseus;
    private int xExit;
    private int yExit;
    private int length;
    private int[][] squares;
    private boolean waitShowing;

    /**
     * Constructeur de la classe ShowMaze.
     * 
     * @param length   la longueur du labyrinthe.
     * @param squares  la grille du labyrinthe.
     * @param xTheseus la position en x de Thesee.
     * @param yTheseus la position en y de Thesee.
     * @param xExit    la position en x de la sortie.
     * @param yExit    la position en y de la sortie.
     */
    public ShowMaze(int length, int[][] squares, int xTheseus, int yTheseus, int xExit, int yExit) {
        super("Labyrinthe de Thesee");
        setLayout(null);
        this.xTheseus = xTheseus;
        this.yTheseus = yTheseus;
        this.xExit = xExit;
        this.yExit = yExit;
        this.length = length;
        this.squares = squares;
        // Parametre de base pour l'affichage d'une fenetre
        // this.setResizable(false);
        int hauteurFenetreBase = 1000;
        int largeurFenetreBase = 1000;
        this.setSize(largeurFenetreBase, hauteurFenetreBase);
        this.setMinimumSize(new Dimension(largeurFenetreBase, hauteurFenetreBase));
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double largeurFenetreUtilisateur = screenSize.getWidth();
        double hauteurFenetreUtilisateur = screenSize.getHeight();
        this.setLocation((int) (largeurFenetreUtilisateur - largeurFenetreBase) / 2,
                (int) (hauteurFenetreUtilisateur - hauteurFenetreBase) / 2);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Creation des casses

        SquaresGrid grid = new SquaresGrid(this.length, this.squares, this.xTheseus, this.yTheseus, this.xExit,
                this.yExit);

        grid.setLocation((getWidth() - 400) / 2, (getHeight() - 400) / 2);

        // Ajout du panneau a la fenetre
        this.add(grid);

        // Counter affichage
        JLabel modeLabel = new JLabel("Mode Manuel");
        modeLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        modeLabel.setForeground(Color.BLACK);
        modeLabel.setBounds(getWidth() / 2 - 100, 100, 200, 30);
        this.add(modeLabel);

        this.addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent e) {
                // Change les emplacements des elements de la fenetre si fenetre
                // redimensionnee
                grid.setLocation((getWidth() - 400) / 2, (getHeight() - 400) / 2);
                modeLabel.setBounds(getWidth() / 2 - 100, 100, 200, 30);
            }
        });
        this.addKeyListener(this);
        this.waitShowing = true;

        repaint();
        this.setVisible(true);
        System.out.println("ShowMaze created");

        while (this.waitShowing) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }

    /**
     * Methode permettant de mettre a jour la position de Thesee.
     * 
     * @param xTheseusNext la position en x de Thesee.
     * @param yTheseusNext la position en y de Thesee.
     */
    public void updatePosition(int xTheseusNext, int yTheseusNext) {
        this.xTheseus = xTheseusNext;
        this.yTheseus = yTheseusNext;
        this.getContentPane().removeAll();

        SquaresGrid newGrid = new SquaresGrid(length, squares, xTheseus, yTheseus, xExit, yExit);
        this.add(newGrid, null); // Ajouter newGrid avec un layout manager null

        // Définir la taille préférée de newGrid pour que la fenêtre soit redimensionnée
        newGrid.setPreferredSize(new Dimension(400, 400));

        // Définir la position de newGrid
        newGrid.setLocation((getWidth() - 400) / 2, (getHeight() - 400) / 2);
        // Counter affichage
        JLabel modeLabel = new JLabel("Mode Manuel");
        modeLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        modeLabel.setForeground(Color.BLACK);
        modeLabel.setBounds(getWidth() / 2 - 100, 100, 200, 30);
        this.add(modeLabel);
        this.addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent e) {
                // Change les emplacements des elements de la fenetre si fenetre
                // redimensionnee
                newGrid.setLocation((getWidth() - 400) / 2, (getHeight() - 400) / 2);
                modeLabel.setBounds(getWidth() / 2 - 100, 100, 200, 30);
            }
        });

        // Redessiner la fenêtre

        this.repaint();
        this.setVisible(true);
        this.waitShowing = true;
        while (this.waitShowing) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    /**
     * Methode permettant de savoir si l'utilisateur a appuye sur la fleche droite.
     * 
     * @param e l'evenement.
     */
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            this.waitShowing = false;
            System.out.println("Right");
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

        // System.out.println("You released key char: " + e.getKeyChar());
        // System.out.println("You released key code: " + e.getKeyCode());
    }
}