package com.example.sae41_2023;

/**
 * La classe Croix représente une croix sur une grille avec des coordonnées X et Y.
 */
public class Croix {
    private int x;
    private int y;

    /**
     * Constructeur de la classe Croix.
     *
     * @param x La coordonnée X de la croix sur la grille.
     * @param y La coordonnée Y de la croix sur la grille.
     */
    public Croix(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Méthode pour obtenir la coordonnée X de la croix.
     *
     * @return La coordonnée X de la croix.
     */
    public int getX() {
        return x;
    }

    /**
     * Méthode pour obtenir la coordonnée Y de la croix.
     *
     * @return La coordonnée Y de la croix.
     */
    public int getY() {
        return y;
    }

    /**
     * Méthode pour vérifier si deux croix sont au même emplacement.
     *
     * @param obj L'objet à comparer avec la croix actuelle.
     * @return true si les croix ont les mêmes coordonnées, sinon false.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Croix croix = (Croix) obj;
        return x == croix.x && y == croix.y;
    }

    /**
     * Méthode pour calculer le code de hachage de la croix.
     *
     * @return Le code de hachage de la croix.
     */
    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }
}