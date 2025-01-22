package com.example.sae41_2023;

/**
 * Cette classe représente une ligne entre plusieurs croix sur le plateau de jeu.
 * Chaque ligne est définie par un point de départ et un point d'arrivée, représentés par des croix.
 */
public class Ligne {
    private Croix start;
    private Croix end;

    /**
     * Constructeur de la classe Ligne.
     *
     * @param start Point de départ de la ligne
     * @param end   Point d'arrivée de la ligne
     */
    public Ligne(Croix start, Croix end) {
        this.start = start;
        this.end = end;
    }


    /**
     * Méthode pour obtenir le point de départ de la ligne.
     *
     * @return Le point de départ de la ligne
     */
    public Croix getStart() {
        return start;
    }

    /**
     * Méthode pour obtenir le point d'arrivée de la ligne.
     *
     * @return Le point d'arrivée de la ligne
     */
    public Croix getEnd() {
        return end;
    }

    /**
     * Redéfinition de la méthode equals pour comparer deux lignes.
     * Deux lignes sont considérées égales si elles ont les mêmes points de départ et d'arrivée.
     *
     * @param obj Objet à comparer avec la ligne actuelle
     * @return true si les lignes sont égales, false sinon
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Ligne ligne = (Ligne) obj;
        return start.equals(ligne.start) && end.equals(ligne.end);
    }

    /**
     * Redéfinition de la méthode hashCode pour générer le code de hachage de la ligne.
     *
     * @return Code de hachage de la ligne
     */
    @Override
    public int hashCode() {
        return start.hashCode() + end.hashCode();
    }
}
