import java.io.*;

/**
 * Classe Reader.
 * 
 * Cette classe permet de lire un fichier.
 * 
 * @version 1.0
 * @author Kohsey DUFOUR
 * @since 2023-04-28
 */
public class Reader {
    private int length;
    private int yTheseus;
    private int xTheseus;
    private int xExit;
    private int yExit;
    private int nbByte;
    private int gridLength;
    private int[] map;
    private int[] grid;
    private int[][] grid2D;

    /**
     * Constructeur de la classe Reader.
     * 
     * @param file le fichier à lire.
     */
    public Reader(File file) {
        try (FileInputStream f = new FileInputStream(file)) {
            try {
                this.length = f.read();
                this.yTheseus = f.read();
                this.xTheseus = f.read();
                this.yExit = f.read();
                this.xExit = f.read();

                // l'octet est separe en 8 bits et est stocke dans un tableau
                nbByte = (int) Math.ceil((this.length) * (this.length) / 8.0);

                this.map = new int[this.nbByte];

                for (int i = 0; i < this.nbByte; i++) {
                    this.map[i] = f.read();
                }

                try {
                    f.close();
                } catch (IOException ev) {
                    System.out.println(ev);
                }
            } catch (IOException ev) {
                System.out.println(ev);
            }
        } catch (IOException ev) {
            System.out.println(ev);
        }
        mapToGrid();
        this.gridLength = nbByte * 8;
    }

    /**
     * Constructeur de la classe Reader.
     * 
     * @param file le fichier à lire.
     */
    public int getLength() {
        return length;
    }

    /**
     * Constructeur de la classe Reader.
     * 
     * @param file le fichier à lire.
     */
    public int getYThesus() {
        return yTheseus;
    }

    /**
     * Constructeur de la classe Reader.
     * 
     * @param file le fichier à lire.
     */
    public int getXThesus() {
        return xTheseus;
    }

    /**
     * Constructeur de la classe Reader.
     * 
     * @param file le fichier à lire.
     */
    public int getYExit() {
        return yExit;
    }

    /**
     * Constructeur de la classe Reader.
     * 
     * @param file le fichier à lire.
     */
    public int getXExit() {
        return xExit;
    }

    /**
     * Constructeur de la classe Reader.
     * 
     * @param file le fichier à lire.
     */
    public int getNbByte() {
        return nbByte;
    }

    /**
     * Constructeur de la classe Reader.
     * 
     * @param file le fichier à lire.
     */
    public int[] getMap() {
        return map;
    }

    /**
     * Constructeur de la classe Reader.
     * 
     * @param file le fichier à lire.
     */
    public int[][] getGrid2D() {
        mapToGrid();

        return grid2D;
    }

    /**
     * Constructeur de la classe Reader.
     * 
     * @param file le fichier à lire.
     */
    public int getGridLength() {
        return gridLength;
    }

    /**
     * Constructeur de la classe Reader.
     * 
     * @param file le fichier à lire.
     */
    private void mapToGrid() {
        grid = new int[length * length * 8];
        int index = 0;
        for (int i = nbByte - 1; i >= 0; i--) {
            // System.out.println(map[i]);
            for (int j = 0; j < 8; j++) {
                grid[index] = (int) ((map[i] >> j) & 1);
                // System.out.println(grid[index]);
                index++;
            }
        }
        grid2D = new int[length][length];
        // Remplir le tableau 2D en inversant l'ordre des elements dans chaque colonne
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                grid2D[i][length - j - 1] = grid[(i * length) + j];
            }
        }
        // Inverser l'ordre des colonnes dans le tableau 2D
        for (int i = 0; i < length / 2; i++) {
            int[] temp = grid2D[i];
            grid2D[i] = grid2D[length - i - 1];
            grid2D[length - i - 1] = temp;
        }
    }

    /**
     * Constructeur de la classe Reader.
     * 
     * @param file le fichier à lire.
     */
    public void byteToBinary(int currentByte) {
        String binaryString = Integer.toBinaryString(currentByte);
        System.out.println(binaryString);
    }
}