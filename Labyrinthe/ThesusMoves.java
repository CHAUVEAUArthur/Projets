/**
 * ThesusMoves est la classe qui gère les mouvements de Thesus
 * 
 * @version 1.0
 * @author Kohsey DUFOUR
 * @since 2023-04-28
 */
public class ThesusMoves {

    private int[][] grid;
    private int length;
    private int xThesus;
    private int yThesus;
    private int xExit;
    private int yExit;
    private int countMove;

    /**
     * Constructeur de la classe ThesusMoves.
     * 
     * @param reader le lecteur de fichier.
     */
    public ThesusMoves(Reader reader) {
        this.grid = reader.getGrid2D();
        this.length = reader.getLength();
        this.xThesus = reader.getXThesus();
        this.yThesus = reader.getYThesus(); // corriger la ligne en utilisant getYThesus()
        this.xExit = reader.getXExit();
        this.yExit = reader.getYExit(); // corriger la ligne en utilisant getYExit()
        this.countMove = 0;
    }

    // Vérifier si Thesus est à la même position que la sortie

    /**
     * Vérifier si Thesus est à la même position que la sortie
     * 
     * @return true si Thesus est à la même position que la sortie, false sinon.
     */
    public boolean isAtExit() {
        return xThesus == xExit && yThesus == yExit;
    }

    // Avancer Thesus d'une case s'il n'y a pas de mur
    /**
     * Avancer Thesus d'une case s'il n'y a pas de mur
     * 
     * @param dx le déplacement en x.
     * @param dy le déplacement en y.
     * @return true si Thesus a pu avancer, false sinon.
     */
    public boolean moveThesus(int dx, int dy) {
        int nextX = xThesus + dx;
        int nextY = yThesus + dy;

        // Vérifier si la position suivante est en dehors de la grille
        if (nextX < 0 || nextX >= length || nextY < 0 || nextY >= length) {
            return false;
        } else if (grid[nextX][nextY] == 1) {// Vérifier si la position suivante est un mur
            return false;
        } else {
            // Avancer Thesus
            this.xThesus = nextX;
            this.yThesus = nextY;
            this.countMove++;
            return true;
        }
    }

    /**
     * Récupérer la position en x de Thesus
     * 
     * @return la position en x de Thesus.
     */
    public int getXThesus() {
        return xThesus;
    }

    /**
     * Récupérer la position en y de Thesus
     * 
     * @return la position en y de Thesus.
     */
    public int getYThesus() {
        return yThesus;
    }

    /**
     * Récupérer le nombre de mouvements de Thesus
     * 
     * @return le nombre de mouvements de Thesus.
     */
    public int getCount() {
        return countMove;
    }
}