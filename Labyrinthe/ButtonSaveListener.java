
/**
 * Cette classe implémente l'interface ActionListener pour gérer la sauvegarde de la grille de labyrinthe dans un fichier.
 * @version 1.0
 * @author Kohsey DUFOUR
 * @since 2023-04-28
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

public class ButtonSaveListener implements ActionListener {
    private MazeBuilder labyrinthe;

    /**
     * Constructeur de la classe ButtonSaveListener.
     * 
     * @param labyrinthe l'objet MazeBuilder à partir duquel on sauvegardera la
     *                   grille de labyrinthe.
     */
    public ButtonSaveListener(MazeBuilder labyrinthe) {
        this.labyrinthe = labyrinthe;
    }

    /**
     * Méthode appelée lorsque l'utilisateur clique sur le bouton de sauvegarde.
     * Elle sauvegarde la grille de labyrinthe dans un fichier en utilisant un objet
     * DataOutputStream.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        int length = labyrinthe.getLength();
        int theseeX = labyrinthe.getTheseeX();
        int theseeY = labyrinthe.getTheseeY();
        int sortieX = labyrinthe.getSortieX();
        int sortieY = labyrinthe.getSortieY();
        int[][] grid = labyrinthe.getGrid();
        if (theseeX != -1 && theseeY != -1 && sortieX != -1 && sortieY != -1) {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Sauvegarder la grille");
            int returnValue = fileChooser.showSaveDialog(null);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                try {
                    FileOutputStream fileOut = new FileOutputStream(selectedFile);
                    DataOutputStream dataOut = new DataOutputStream(fileOut);
                    dataOut.writeByte(length);
                    dataOut.writeByte(theseeX);
                    dataOut.writeByte(theseeY);
                    dataOut.writeByte(sortieX);
                    dataOut.writeByte(sortieY);
                    byte currentByte = 0;
                    int bitCount = 0;
                    for (int j = 0; j < length; j++) {
                        for (int i = 0; i < length; i++) {
                            if (grid[j][i] == 1) {
                                currentByte |= (1 << (7 - bitCount)); // écrire 1
                            } else {
                                currentByte &= ~(1 << (7 - bitCount)); // écrire 0
                            }
                            bitCount++;
                            if (bitCount == 8) { // si on a atteint 8 bits, écrire le byte
                                dataOut.writeByte(currentByte);
                                currentByte = 0;
                                bitCount = 0;
                            }
                        }
                    }
                    if (bitCount > 0) { // écrire le dernier byte incomplet
                        dataOut.writeByte(currentByte);
                    }
                    fileOut.close();

                    System.out.println("Sauvegarde effectuée");

                } catch (Exception ex) {
                    ex.printStackTrace();

                }

            }
        } else {
            JOptionPane.showMessageDialog(null,
                    "Veuillez placer Thésée et la sortie avant de sauvegarder.",
                    "Erreur",
                    JOptionPane.ERROR_MESSAGE);
        }

    }

}