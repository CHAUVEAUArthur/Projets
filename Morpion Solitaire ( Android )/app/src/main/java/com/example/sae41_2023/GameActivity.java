package com.example.sae41_2023;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Activité principale du jeu. Contrôle le modèle de jeu et la vue de jeu.
 */
public class GameActivity extends AppCompatActivity {

    private GameModel model;
    private GameView view;

    /**
     * Méthode appelée lors de la création de l'activité.
     * Initialise le modèle de jeu, la vue de jeu et associe un contrôleur de jeu à la vue.
     *
     * @param savedInstanceState Données précédemment sauvegardées de l'activité, si disponible.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        model = new GameModel(this);
        view = findViewById(R.id.game_view);

        view.setOnTouchListener(new GameController(this,view,model,this));

    }

    /**
     * Méthode appelée lorsque l'activité est reprise.
     * Marque le début d'une partie en mettant à jour les préférences.
     */
    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        prefs.edit().putBoolean("game_in_progress", true).apply();
    }

    /**
     * Méthode appelée lorsque l'activité est mise en pause.
     * Marque la fin d'une partie en mettant à jour les préférences.
     */
    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        prefs.edit().putBoolean("game_in_progress", false).apply();
    }

    /**
     * Méthode appelée pour sauvegarder l'état de l'activité avant sa destruction.
     * Sauvegarde le score ainsi que les positions des croix et des lignes.
     *
     * @param outState Bundle dans lequel sauvegarder l'état de l'activité.
     */
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("SCORE", model.getScore());

        /*Méthode qui marche pour la sauvegarde pour la rotation de l'écran mais qui casse la sauvegarde en mettant en pause l'application
        outState.putSerializable("CROIX_LIST", (ArrayList<Croix>)model.getCroixList());
        outState.putSerializable("LIGNE_LIST", (ArrayList<Ligne>)model.getLigneList());*/
    }

    /**
     * Méthode appelée lors de la restauration de l'état de l'activité après une destruction.
     * Restaure le score ainsi que les positions des croix et des lignes, et rafraîchit la vue.
     *
     * @param savedInstanceState Bundle contenant les données sauvegardées lors de la sauvegarde de l'état.
     */
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
            model.setScore(savedInstanceState.getInt("SCORE"));
            model.setCroixList((List<Croix>) savedInstanceState.getSerializable("CROIX_LIST"));
            model.setLigneList((List<Ligne>) savedInstanceState.getSerializable("LIGNE_LIST"));
            view.invalidate();

    }


    /**
     * Récupère la taille de la croix à partir des préférences partagées.
     * La taille de la croix est récupérée à partir de la clé de préférence "pref_key_radio_options"
     * dans les préférences partagées par défaut de l'application.
     *
     * @return La taille de la croix sous forme de chaîne de caractères.
     */
    public String getTailleCroix() {

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        return sharedPreferences.getString("pref_key_radio_options", "");
    }

    /**
     * Vérifie si l'interdiction est prolongée à partir des préférences partagées.
     * L'interdiction prolongée est récupérée à partir de la clé de préférence "interdiction"
     * dans les préférences partagées par défaut de l'application.
     *
     * @return True si l'interdiction est prolongée, False sinon.
     */
    public boolean getInterdictionProlonge() {

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        return sharedPreferences.getBoolean("interdiction", false);
    }

}