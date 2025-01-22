package com.example.sae41_2023;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;


/**
 * Cette classe représente la vue du jeu.
 * Elle étend la classe {@link android.view.View} et est utilisée pour dessiner le plateau de jeu,
 * les croix, les lignes et afficher le score.
 */
public class GameView extends View {
    private Paint linePaint, crossPaint, tempLinePaint, scorePaint, finPaint;
    private Ligne temporaryLine;
    private int cellSize = 100;
    private float offsetX = 0, offsetY = 0;
    private int crossSize = 30;
    private GameModel model;
    private boolean partieTerminee = false;


    /**
     * Constructeur de la classe GameView prenant en compte uniquement le contexte.
     *
     * @param context Contexte de l'application Android
     */
    public GameView(Context context) {
        super(context);
        init();
    }

    /**
     * Constructeur de la classe GameView prenant en compte le contexte et les attributs.
     *
     * @param context Contexte de l'application Android
     * @param attrs   Attributs de la vue
     */
    public GameView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    /**
     * Méthode d'initialisation des éléments graphiques.
     * Initialise les différents objets Paint utilisés pour dessiner les éléments du jeu.
     */
    private void init() {
        linePaint = new Paint();
        linePaint.setColor(0xFFCCCCCC);

        crossPaint = new Paint();
        crossPaint.setColor(0xFF000000);
        crossPaint.setStrokeWidth(10);

        tempLinePaint = new Paint();
        tempLinePaint.setColor(Color.RED);
        tempLinePaint.setStrokeWidth(10);

        scorePaint = new Paint();
        scorePaint.setColor(Color.BLACK);
        scorePaint.setTextSize(100);

        finPaint = new Paint();
        finPaint.setColor(Color.RED);
        finPaint.setTextSize(40);
        finPaint.setTextAlign(Paint.Align.CENTER);

    }

    /**
     * Méthode pour définir si la partie est terminée.
     *
     * @param partieTerminee true si la partie est terminée, false sinon
     */
    public void setPartieTerminee(boolean partieTerminee) {
        this.partieTerminee = partieTerminee;
        invalidate();
    }

    /**
     * Méthode pour définir le modèle du jeu associé à la vue.
     *
     * @param model Modèle du jeu
     */
    public void setModel(GameModel model) {
        this.model = model;
    }

    /**
     * Méthode appelée pour dessiner les éléments sur la vue.
     *
     * @param canvas Objet Canvas sur lequel dessiner les éléments
     */
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int width = getWidth();
        int height = getHeight();

        drawGrid(canvas,width,height);

        for (Croix croix : model.getCroixList()) {
            drawCross(canvas, croix.getX(), croix.getY());
        }

        if (temporaryLine != null) {
            Croix start = temporaryLine.getStart();
            Croix end = temporaryLine.getEnd();
            canvas.drawLine(start.getX() * cellSize + offsetX, start.getY() * cellSize + offsetY,
                    end.getX() * cellSize + offsetX, end.getY() * cellSize + offsetY,
                    tempLinePaint);
        }

        for (Ligne ligne : model.getLigneList()) {
            Croix start = ligne.getStart();
            Croix end = ligne.getEnd();
            canvas.drawLine(start.getX() * cellSize + offsetX, start.getY() * cellSize + offsetY,
                    end.getX() * cellSize + offsetX, end.getY() * cellSize + offsetY,
                    tempLinePaint);
        }

        String scoreText = "Score: " + model.getScore();
        canvas.drawText(scoreText, 30, 150, scorePaint);

        if (partieTerminee) {
            canvas.drawText("Partie Terminée", getWidth() / 2, getHeight() / 2, finPaint);
        }

    }

    /**
     * Méthode pour dessiner la grille du plateau de jeu.
     *
     * @param canvas Objet Canvas sur lequel dessiner la grille
     * @param width  Largeur de la vue
     * @param height Hauteur de la vue
     */
    private void drawGrid(Canvas canvas,int width, int height){
        for (float x = offsetX % cellSize; x < width; x += cellSize) {
            canvas.drawLine(x, 0, x, height, linePaint);
        }

        for (float y = offsetY % cellSize; y < height; y += cellSize) {
            canvas.drawLine(0, y, width, y, linePaint);
        }
    }
    /**
     * Méthode pour dessiner une croix sur le plateau de jeu.
     *
     * @param canvas Objet Canvas sur lequel dessiner la croix
     * @param x      Position horizontale de la croix
     * @param y      Position verticale de la croix
     */
    private void drawCross(Canvas canvas, float x, float y) {
        canvas.drawLine(x * cellSize - crossSize / 2 + offsetX,
                y * cellSize + offsetY,
                x * cellSize + crossSize / 2 + offsetX,
                y * cellSize + offsetY, crossPaint);
        canvas.drawLine(x * cellSize + offsetX,
                y * cellSize - crossSize / 2 + offsetY,
                x * cellSize + offsetX,
                y * cellSize + crossSize / 2 + offsetY, crossPaint);
    }

    /**
     * Méthode pour définir la ligne temporaire tracée par le joueur.
     *
     * @param tempLine Ligne temporaire tracée par le joueur
     */
    public void setTemporaryLine(Ligne tempLine) {
        this.temporaryLine = tempLine;
    }

    /**
     * Méthode pour définir le décalage horizontal de la vue par rapport à l'origine.
     *
     * @param offsetX Décalage horizontal
     */
    public void setOffsetX(float offsetX) {
        this.offsetX = offsetX;
    }

    /**
     * Méthode pour définir le décalage vertical de la vue par rapport à l'origine.
     *
     * @param offsetY Décalage vertical
     */
    public void setOffsetY(float offsetY){
        this.offsetY=offsetY;
    }

    /**
     * Méthode pour obtenir le décalage horizontal de la vue par rapport à l'origine.
     *
     * @return Décalage horizontal
     */
    public float getOffsetX() {
        return offsetX;
    }

    /**
     * Méthode pour obtenir le décalage vertical de la vue par rapport à l'origine.
     *
     * @return Décalage vertical
     */
    public float getOffsetY() {
        return offsetY;
    }

    /**
     * Méthode pour obtenir la taille d'une cellule sur le plateau de jeu.
     *
     * @return Taille d'une cellule
     */
    public int getCellSize() {
        return cellSize;
    }
}