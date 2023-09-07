/**
 * ImportGrid est une classe qui permet d'importer une grille depuis un fichier
 * @version 1.0
 * @author Kohsey DUFOUR
 * @since 2023-04-28
 */

import javax.swing.JFileChooser;
import java.io.File;

public class ImportGrid {
    private File selectedFile;

    /**
     * Constructeur de la classe ImportGrid.
     * Il permet d'ouvrir une fenêtre de sélection de fichier et de récupérer le fichier sélectionné.
     */
    public ImportGrid() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Importer une grid");

        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            this.selectedFile = fileChooser.getSelectedFile();
            
        }
    }

    /**
     * Méthode qui permet de récupérer le fichier sélectionné.
     * @return le fichier sélectionné.
     */
    public File getImportSelectedFile() {
        return selectedFile;
    }
}