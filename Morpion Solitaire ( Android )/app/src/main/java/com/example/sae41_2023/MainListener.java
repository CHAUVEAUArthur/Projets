package com.example.sae41_2023;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

/**
 * Cette classe est un écouteur d'événements de clic pour les boutons de l'activité principale.
 * Elle implémente l'interface {@code View.OnClickListener} pour réagir aux clics sur les boutons.
 */
public class MainListener implements View.OnClickListener{
    private Button playButton,quitButton;
    private MainActivity activity;
    private Intent gameIntent;

    /**
     * Constructeur de la classe MainListener.
     *
     * @param playButton Bouton pour démarrer le jeu
     * @param quitButton Bouton pour quitter l'application
     * @param main       Référence à l'activité principale
     * @param gameIntent Intent pour démarrer l'activité du jeu
     */
    public MainListener(Button playButton,Button quitButton, MainActivity main, Intent gameIntent) {
        this.playButton=playButton;
        this.quitButton=quitButton;
        this.activity=main;
        this.gameIntent=gameIntent;
    }

    /**
     * Méthode appelée lorsqu'un des boutons est cliqué.
     *
     * @param view Vue qui a reçu le clic
     */
    @Override
    public void onClick(View view){
        if (view == playButton) {
            activity.startActivity(gameIntent);
        } else if (view == quitButton) {
            activity.finish();
        }
    }
}