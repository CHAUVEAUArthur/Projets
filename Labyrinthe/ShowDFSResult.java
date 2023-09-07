import java.awt.*;

import javax.swing.*;

/**
 * Classe permettant d'afficher le resultat d'un algorithme aleatoire.
 * 
 * @version 1.0
 * @author Kohsey DUFOUR
 * @since 2023-04-28
 */
public class ShowDFSResult extends JFrame {
    /**
     * Constructeur de la classe ShowDFSResult.
     * 
     * @param averageCount le nombre de cases visitées.
     */
    public ShowDFSResult(int averageCount) {
        super("Labyrinthe de Thesee");
        setLayout(null);
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

        JLabel titleLabel = new JLabel("Algorithme aleatoire en automatique");
        titleLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        titleLabel.setForeground(Color.BLACK);
        titleLabel.setBounds(getWidth() / 2 - 200, 100, 400, 150);
        this.add(titleLabel);

        JLabel averageCountLabel = new JLabel("Nombre moyen de pas: " + averageCount);
        averageCountLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        averageCountLabel.setForeground(Color.BLACK);
        averageCountLabel.setBounds(getWidth() / 2 - 150, 350, 300, 150);
        this.add(averageCountLabel);

        this.setVisible(true);
    }
}
