package com.example.sae41_2023;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.widget.Toolbar;

/**
 * Cette classe représente l'activité principale de l'application.
 * Elle est responsable de l'affichage de l'écran d'accueil et de la gestion des boutons pour démarrer le jeu ou quitter l'application.
 */
public class MainActivity extends AppCompatActivity {

    private Intent gameIntent;
    private Button startButton;
    private Button quitButton;

    /**
     * Méthode appelée lors de la création de l'activité.
     *
     * @param savedInstanceState État de l'activité sauvegardé précédemment, le cas échéant
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        gameIntent = new Intent(MainActivity.this, GameActivity.class);

        startButton = findViewById(R.id.start_button);
        quitButton = findViewById(R.id.quit_button);

        MainListener listener = new MainListener(startButton,quitButton,this,gameIntent);

        startButton.setOnClickListener(listener);
        quitButton.setOnClickListener(listener);


    }

    /**
     * Méthode appelée lorsqu'un élément du menu est sélectionné.
     *
     * @param item Élément de menu sélectionné
     * @return true si le traitement de l'élément est effectué avec succès, sinon false
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if (id == R.id.option){
            Intent intention = new Intent(this, SettingsActivity.class);
            this.startActivity(intention);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * Méthode appelée pour créer le menu dans la barre d'outils.
     *
     * @param menu Menu dans lequel ajouter les éléments
     * @return true si le menu est créé avec succès, sinon false
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        this.getMenuInflater().inflate(R.menu.menu_parametre, menu);
        return true;
    }

}