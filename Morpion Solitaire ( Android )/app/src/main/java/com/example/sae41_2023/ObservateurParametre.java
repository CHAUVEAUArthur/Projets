package com.example.sae41_2023;

import android.content.SharedPreferences;
import android.util.Log;

/**
 * Cette classe est un observateur pour les changements de préférences partagées.
 * Elle implémente l'interface {@code SharedPreferences.OnSharedPreferenceChangeListener}
 * pour réagir aux changements dans les préférences partagées de l'application.
 */
public class ObservateurParametre implements SharedPreferences.OnSharedPreferenceChangeListener {

    /**
     * Méthode appelée lorsque les préférences partagées sont modifiées.
     *
     * @param prefs Instance des préférences partagées qui ont été modifiées
     * @param key   Clé de la préférence qui a été modifiée
     */
    public void onSharedPreferenceChanged(SharedPreferences prefs, String key){
        if (key.equals("pref_key_radio_options")){
            Log.v("test", "click menu taille");
        }
        else if (key.equals("interdiction")){
            Log.v("test", "click interdiction ligne");
        }
        else if (key.equals("save_button")){
            Log.v("test", "click bouton savegarder");
        }
    }
}