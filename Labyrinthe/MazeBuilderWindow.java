import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.*;

/**
 * Classe MazeBuilder.
 * 
 * Cette classe permet de créer un labyrinthe.
 * 
 * @version 1.0
 * @author Kohsey DUFOUR
 * @since 2023-04-28
 */

public class MazeBuilderWindow extends JFrame {
    private int length;
    private MazeBuilder labyrinthe;

    /**
     * Constructeur de la classe MazeBuilder.
     * 
     * @param length la longueur du labyrinthe.
     * @param grid   la grille du labyrinthe.
     * @param choice le choix de l'utilisateur.
     */
    public MazeBuilderWindow(MazeBuilder labyrinthe) {
        this.labyrinthe = labyrinthe;
        int length = labyrinthe.getLength();
        setTitle("Labyrinthe");
        setSize(1280, 720);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        add(labyrinthe);
        setVisible(true);
    }

}
