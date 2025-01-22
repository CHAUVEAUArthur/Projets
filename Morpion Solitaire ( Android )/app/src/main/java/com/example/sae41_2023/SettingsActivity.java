package com.example.sae41_2023;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;

/**
 * Cette classe représente l'activité des paramètres de l'application.
 * Elle étend la classe {@code PreferenceActivity} pour afficher les préférences définies dans le fichier XML preferences.xml.
 */
public class SettingsActivity extends PreferenceActivity {

    /**
     * Méthode appelée lors de la création de l'activité des paramètres.
     *
     * @param savedInstanceState État de l'activité sauvegardé précédemment, le cas échéant
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.addPreferencesFromResource(R.xml.preferences);

        ObservateurParametre observateurParametre = new ObservateurParametre();
        PreferenceManager.setDefaultValues(this, R.xml.preferences, false);
        this.getPreferenceScreen().getSharedPreferences().registerOnSharedPreferenceChangeListener(observateurParametre);

    }
}