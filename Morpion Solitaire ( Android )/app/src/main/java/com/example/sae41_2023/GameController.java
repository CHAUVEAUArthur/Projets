package com.example.sae41_2023;

import android.content.Context;
import android.view.MotionEvent;
import android.view.GestureDetector;
import android.view.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Cette classe est responsable de la gestion des événements tactiles et de la logique du jeu.
 * Elle implémente l'interface {@link View.OnTouchListener} pour écouter les événements tactiles sur la vue du jeu.
 * Elle utilise également un {@link GestureDetector} pour détecter les gestes, tels que le long appui.
 */
public class GameController implements View.OnTouchListener {

    private GameModel model;
    private GameView view;
    private float lastTouchX, lastTouchY;
    private Croix startCroix = null;
    private Croix currentCroix = null;
    private GestureDetector gestureDetector;
    private GameActivity activity;
    private boolean interdiction;

    /**
     * Constructeur de la classe GameController.
     *
     * @param context Contexte de l'application Android
     * @param view    Vue du jeu
     * @param model   Modèle du jeu
     * @param activity L'activité du jeu associée au contrôleur.
     */
    public GameController(Context context,GameView view, GameModel model,GameActivity activity) {
        this.activity=activity;
        this.model = model;
        this.view = view;
        this.view.setModel(this.model);
        gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
            @Override
            public void onLongPress(MotionEvent e) {
                resetViewToBase(view);
            }
        });
    }

    /**
     * Méthode appelée lorsqu'un événement tactile est détecté sur la vue du jeu.
     *
     * @param v     Vue qui a reçu l'événement
     * @param event Objet MotionEvent représentant l'événement tactile
     * @return true si l'événement est consommé, false sinon
     */
    @Override
    public boolean onTouch(View v, MotionEvent event) {

        gestureDetector.onTouchEvent(event);
        float currentX = event.getX();
        float currentY = event.getY();

        int gridX = (int) ((currentX - view.getOffsetX()) / view.getCellSize());
        int gridY = (int) ((currentY - view.getOffsetY()) / view.getCellSize());

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                lastTouchX = currentX;
                lastTouchY = currentY;
                startCroix = new Croix(gridX, gridY);
                break;
                case MotionEvent.ACTION_MOVE:
                    if (startCroix != null) {
                        currentCroix = new Croix(gridX, gridY);
                        view.setTemporaryLine(new Ligne(startCroix, currentCroix));
                        view.invalidate();
                    }

                    if (event.getPointerCount() ==2) {
                        float dx = currentX - lastTouchX;
                        float dy = currentY - lastTouchY;
                        view.setOffsetX(view.getOffsetX() + dx);
                        view.setOffsetY(view.getOffsetY() + dy);
                        v.invalidate();
                        lastTouchX = currentX;
                        lastTouchY = currentY;
                    }
                    break;
                    case MotionEvent.ACTION_UP:
                        if (startCroix != null && currentCroix != null) {
                            tirerTrait(startCroix, currentCroix);
                            startCroix = null;
                            currentCroix = null;
                            view.setTemporaryLine(null);
                            view.invalidate();
                        }
                    break;
        }

        return true;
    }

    /**
     * Méthode pour tirer une ligne entre plusieurs croix.
     *
     * @param start Croix de départ de la ligne
     * @param end   Croix d'arrivée de la ligne
     */
    private void tirerTrait(Croix start, Croix end) {
        Ligne newLine = new Ligne(start, end);
        if (coupCorrect(newLine)) {
            model.addLigne(newLine);
            model.scorePlusUn();
            view.invalidate();
            if (model.verifFinDePartie()) {
                view.setPartieTerminee(true);
            }
        }


    }


    /**
     * Vérifie si le coup spécifié par la ligne est valide.
     *
     * @param line La ligne représentant le coup à vérifier.
     * @return true si le coup est correct et peut être joué ; false sinon.
     */
    private boolean coupCorrect(Ligne line) {

        Croix start = line.getStart();
        Croix end = line.getEnd();

        int diffX = end.getX() - start.getX();
        int diffY = end.getY() - start.getY();
        int deltaX = Integer.signum(diffX);
        int deltaY = Integer.signum(diffY);
        int croixComptees = 0;
        List<Croix> pointsLigne = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            pointsLigne.add(new Croix(line.getStart().getX() + i * deltaX,
                    line.getStart().getY() + i * deltaY));
        }

        for (Croix point : pointsLigne) {
            if (model.isCroixMarquee(point)) {
                croixComptees++;
            }
        }

        boolean isHorizontal = diffY == 0 && (diffX == 4 || diffX == -4);
        boolean isVertical = diffX == 0 && (diffY == 4 || diffY == -4);
        boolean isDiagonal = (diffX == 4 || diffX == -4) && (diffY == 4 || diffY == -4);

        interdiction=activity.getInterdictionProlonge();

        if (isHorizontal || isVertical || isDiagonal){
            if (interdiction){
                if (model.prolongement(line, model.getLigneList()) && croixComptees == 4) {
                    for (Croix point : pointsLigne) {
                        if (!model.isCroixMarquee(point)) {
                            model.addCroix(point);
                            return true;
                        }
                    }
                }
            }else{
                if (croixComptees == 4) {
                    for (Croix point : pointsLigne) {
                        if (!model.isCroixMarquee(point)) {
                            model.addCroix(point);
                            return true;
                        }
                    }
                }
            }
            
        }

        return false;
    }

    /**
     * Méthode pour réinitialiser la vue à sa position de base.
     *
     * @param v Vue à réinitialiser
     */
    private void resetViewToBase(View v) {
        view.setOffsetX(0);
        view.setOffsetY(0);
        v.invalidate();
    }
}