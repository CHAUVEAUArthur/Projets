package com.example.sae41_2023;

import java.util.ArrayList;
import java.util.List;

/**
 * Cette classe représente le modèle du jeu.
 * Elle gère les données du jeu telles que les croix, les lignes et le score.
 */
public class GameModel {
    private int score = 0;
    private List<Croix> croixList;
    private List<Ligne> ligneList;
    private int x, y;
    private GameActivity activity;
    private String tailleCroix;

    /**
     * Constructeur de la classe GameModel.
     * Initialise les listes de croix et de lignes, puis initialise le plateau de base.
     */
    public GameModel(GameActivity activity) {
        this.activity=activity;
        croixList = new ArrayList<>();
        ligneList = new ArrayList<>();
        initPlateauDeBase();
    }

    /**
     * Méthode pour ajouter une croix à la liste des croix sur le plateau.
     *
     * @param croix Croix à ajouter
     */
    public void addCroix(Croix croix) {
        croixList.add(croix);
    }

    /**
     * Méthode pour ajouter une ligne à la liste des lignes tracées sur le plateau.
     * Ajoute également la croix de fin de ligne à la liste des croix sur le plateau.
     *
     * @param ligne Ligne à ajouter
     */
    public void addLigne(Ligne ligne) {
        ligneList.add(ligne);
        addCroix(ligne.getEnd());
    }

    /**
     * Méthode pour obtenir le score du joueur.
     *
     * @return Le score du joueur
     */
    public int getScore() {
        return score;
    }

    /**
     * Méthode pour incrémenter le score du joueur de un.
     */
    public void scorePlusUn() {
        score++;
    }

    /**
     * Méthode pour obtenir la liste des croix sur le plateau.
     *
     * @return La liste des croix sur le plateau
     */
    public List<Croix> getCroixList() {
        return croixList;
    }

    /**
     * Méthode pour obtenir la liste des lignes tracées sur le plateau.
     *
     * @return La liste des lignes tracées sur le plateau
     */
    public List<Ligne> getLigneList() {
        return ligneList;
    }

    /**
     * Méthode pour vérifier si une croix est marquée sur le plateau.
     *
     * @param croix Croix à vérifier
     * @return true si la croix est marquée, false sinon
     */
    public boolean isCroixMarquee(Croix croix) {
        for (Croix c : croixList) {
            if (c.getX() == croix.getX() && c.getY() == croix.getY()) {
                return true;
            }
        }
        return false;
    }

    /**
     * Méthode pour initialiser le plateau de jeu avec les croix de base.
     * Dessine les croix verticales et horizontales sur le plateau.
     */
    private void initPlateauDeBase() {
        tailleCroix=activity.getTailleCroix();
        if(tailleCroix.equals("36")) {
            drawCrossY36(x, y);
            drawCrossX36(x, y);
        }
        else if (tailleCroix.equals("24")) {
            drawCrossY24(x, y);
            drawCrossX24(x, y);
        }

    }

    /**
     * Méthode pour dessiner les croix verticales pour une croix de 36 sur le plateau.
     *
     * @param x Position en abscisse
     * @param y Position en ordonnée
     */
    private void drawCrossY36(int x, int y){
        for (x = 0; x <= 10; x++){
            if (x == 1){
                for (y = 9; y <= 12; y++) {
                    addCroix(new Croix(x, y));
                }
            }
            if (x == 4){
                for (y = 6; y <= 9; y++){
                    addCroix(new Croix(x,y));
                }
                for (y = 12; y <= 15; y++){
                    addCroix(new Croix(x,y));
                }
            }
            if (x == 7) {
                for (y = 6; y <= 9; y++) {
                    addCroix(new Croix(x, y));
                }
                for (y = 12; y <= 15; y++) {
                    addCroix(new Croix(x, y));
                }
            }
            if (x == 10) {
                for (y = 9; y <= 12; y++) {
                    addCroix(new Croix(x, y));
                }
            }
        }
    }

    /**
     * Méthode pour dessiner les croix horizontales pour une croix de 36 sur le plateau.
     *
     * @param x Position en abscisse
     * @param y Position en ordonnée
     */
    private void drawCrossX36(int x, int y){
        for (y = 6; y <= 15; y++){
            if (y == 6){
                for (x = 4; x <= 7; x++) {
                    addCroix(new Croix(x, y));
                }
            }
            if (y == 9){
                for (x = 1; x <= 4; x++) {
                    addCroix(new Croix(x, y));
                }
                for (x = 7; x <= 10; x++) {
                    addCroix(new Croix(x, y));
                }
            }
            if (y == 12){
                for (x = 1; x <= 4; x++) {
                    addCroix(new Croix(x, y));
                }
                for (x = 7; x <= 10; x++) {
                    addCroix(new Croix(x, y));
                }
            }
            if (y == 15){
                for (x = 4; x <= 7; x++) {
                    addCroix(new Croix(x, y));
                }
            }
        }
    }

    /**
     * Méthode pour dessiner les croix verticales pour une croix de 24 sur le plateau.
     *
     * @param x Position en abscisse
     * @param y Position en ordonnée
     */
    private void drawCrossY24(int x, int y){
        for (x = 3; x <= 11; x++){
            if (x == 3){
                for (y = 10; y <= 12; y++) {
                    addCroix(new Croix(x, y));
                }
            }
            if (x == 5){
                for (y = 8; y <= 10; y++){
                    addCroix(new Croix(x,y));
                }
                for (y = 12; y <= 14; y++){
                    addCroix(new Croix(x,y));
                }
            }
            if (x == 7) {
                for (y = 8; y <= 10; y++) {
                    addCroix(new Croix(x, y));
                }
                for (y = 12; y <= 14; y++) {
                    addCroix(new Croix(x, y));
                }
            }
            if (x == 9) {
                for (y = 10; y <= 12; y++) {
                    addCroix(new Croix(x, y));
                }
            }
        }
    }

    /**
     * Méthode pour dessiner les croix horizontales pour une croix de 24 sur le plateau.
     *
     * @param x Position en abscisse
     * @param y Position en ordonnée
     */
    private void drawCrossX24(int x, int y){
        for (y = 8; y <= 14; y++){
            if (y == 8){
                for (x = 5; x <= 7; x++) {
                    addCroix(new Croix(x, y));
                }
            }
            if (y == 10){
                for (x = 3; x <= 5; x++) {
                    addCroix(new Croix(x, y));
                }
                for (x = 7; x <= 9; x++) {
                    addCroix(new Croix(x, y));
                }
            }
            if (y == 12){
                for (x = 3; x <= 5; x++) {
                    addCroix(new Croix(x, y));
                }
                for (x = 7; x <= 9; x++) {
                    addCroix(new Croix(x, y));
                }
            }
            if (y == 14){
                for (x = 5; x <= 7; x++) {
                    addCroix(new Croix(x, y));
                }
            }
        }
    }

    /**
     * Méthode pour vérifier si la partie est terminée.
     * Vérifie si un coup valide est possible à partir de chaque croix.
     *
     * @return true si la partie est terminée, false sinon
     */
    public boolean verifFinDePartie() {
        for (Croix croix : croixList) {
            for (int dx = -1; dx <= 1; dx++) {
                for (int dy = -1; dy <= 1; dy++) {
                    if (dx == 0 && dy == 0) continue;
                    if (coupPotentielValide(croix, dx, dy)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    /**
     * Méthode pour vérifier si un coup potentiel est valide dans une direction donnée à partir d'une croix.
     *
     * @param croix Croix de départ
     * @param dx    Déplacement horizontal
     * @param dy    Déplacement vertical
     * @return true si un coup valide est trouvé dans la direction spécifiée, false sinon
     */
    private boolean coupPotentielValide(Croix croix, int dx, int dy) {

        int croixComptees = 0;
        Croix pointActuel = croix;


        for (int i = 1; i <= 4; i++) {
            Croix pointSuivant = new Croix(pointActuel.getX() + i * dx, pointActuel.getY() + i * dy);
            if (isCroixMarquee(pointSuivant)) {
                croixComptees++;
            } else {

                for (int j = i + 1; j <= 4; j++) {
                    Croix pointVerification = new Croix(pointActuel.getX() + j * dx, pointActuel.getY() + j * dy);
                    if (isCroixMarquee(pointVerification)) {
                        croixComptees++;
                    } else {
                        return false;
                    }
                }
                if (croixComptees == 3) {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * Méthode pour définir le score du joueur.
     *
     * @param s Le score à définir
     */
    public void setScore(int s) {
        this.score = s;
    }


    /**
     * Méthode pour définir la liste des croix sur le plateau.
     *
     * @param cL La liste des croix à définir
     */
    public void setCroixList(List<Croix> cL) {
        this.croixList = cL;
    }

    /**
     * Méthode pour définir la liste des lignes tracées sur le plateau.
     *
     * @param lL La liste des lignes à définir
     */
    public void setLigneList(List<Ligne> lL) {
        this.ligneList = lL;
    }

    /**
     * Représente les différentes directions possibles d'une ligne.
     * Les directions peuvent être horizontale, verticale, diagonale ou aucune.
     */
    public enum Direction {
        HORIZONTAL, VERTICAL, DIAGONAL, NONE
    }

    /**
     * Détermine la direction d'une ligne donnée en fonction de ses points de début et de fin.
     * La direction peut être verticale, horizontale, diagonale ou aucune si la ligne est invalide.
     *
     * @param ligne La ligne pour laquelle la direction doit être déterminée.
     * @return La direction de la ligne en paramètre.
     */
    public static Direction determinerDirection(Ligne ligne) {
        int diffX = ligne.getEnd().getX() - ligne.getStart().getX();
        int diffY = ligne.getEnd().getY() - ligne.getStart().getY();
    
        if (diffX == 0) {
            return Direction.VERTICAL;
        } else if (diffY == 0) {
            return Direction.HORIZONTAL;
        } else if (Math.abs(diffX) == Math.abs(diffY)) {
            if ((diffX == 4 || diffX == -4) && (diffY == 4 || diffY == -4)) {
                return Direction.DIAGONAL;
            }
        }
        return Direction.NONE;
    }

    /**
     * Vérifie si le début ou la fin de la nouvelle ligne correspond à l'une des extrémités
     * d'une ligne existante dans la liste des lignes existantes, et si la direction de la
     * nouvelle ligne est identique ou non à la direction de la ligne existante.
     *
     * @param nouvelleLigne La nouvelle ligne à comparer.
     * @param lignesExistantes La liste des lignes existantes à comparer.
     * @return {@code true} si le début ou la fin de la nouvelle ligne correspond à
     *         l'une des extrémités d'une ligne existante et que la direction est différente;
     *         {@code false} sinon.
     */
    public boolean prolongement(Ligne nouvelleLigne, List<Ligne> lignesExistantes) {
        for (Ligne ligneExistante : lignesExistantes) {
            if (nouvelleLigne.getStart().equals(ligneExistante.getStart()) ||
                nouvelleLigne.getStart().equals(ligneExistante.getEnd()) ||
                nouvelleLigne.getEnd().equals(ligneExistante.getStart()) ||
                nouvelleLigne.getEnd().equals(ligneExistante.getEnd())) {
                Direction directionNouvelleLigne = determinerDirection(nouvelleLigne);
                Direction directionLigneExistante = determinerDirection(ligneExistante);
                
                if (directionNouvelleLigne != directionLigneExistante) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

}

