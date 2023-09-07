//import java.awt.event.KeyEvent;
import java.io.*;
//import java.lang.Thread;
import java.util.Random;

import java.util.Random;

/** 
 * Maze class est la classe principale du projet. Elle permet de lancer le jeu.
 * @version 1.0
 * @author Kohsey DUFOUR
 * @since 2023-04-28
 */
public class Maze {
    /**
     * Méthode principale du projet.
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        File file = new File("predefined_grids/test.lab");
        Reader reader = new Reader(file);
        int[][] grid = reader.getGrid2D();

        // Choix de l'algorithme
        int algorithmChoice = 0;
        // Choix de l'auto
        boolean auto = false;
        // Random algorithm

        if (algorithmChoice == 0) {
            if (!auto) {
                ThesusMoves thesusMoves = new ThesusMoves(reader);
                System.out.println("ShowMaze is running");
                ShowMaze showMaze = new ShowMaze(reader.getLength(), reader.getGrid2D(), reader.getXThesus(),
                        reader.getYThesus(), reader.getXExit(), reader.getYExit());
                showMaze.setVisible(true);
                System.out.println("ShowMaze is running 2");
                while (thesusMoves.isAtExit() == false) {
                    // Thread.sleep(10);
                    Random random = new Random();
                    int randomMove = random.nextInt(2) * 2 - 1;
                    boolean thesusMove;
                    if (new Random().nextBoolean()) {
                        thesusMove = thesusMoves.moveThesus((int) randomMove, 0);
                    } else {
                        thesusMove = thesusMoves.moveThesus(0, (int) randomMove);
                    }
                    System.out.println(thesusMoves.getCount());

                    if (thesusMove == true) {
                        showMaze.updatePosition(thesusMoves.getXThesus(), thesusMoves.getYThesus());
                    }
                }
            } else {
                int sumCount = 0;
                for (int i = 0; i < 100; i++) {
                    ThesusMoves thesusMoves = new ThesusMoves(reader);
                    while (thesusMoves.isAtExit() == false) {

                        // Thread.sleep(10);
                        Random random = new Random();
                        int randomMove = random.nextInt(2) * 2 - 1;
                        boolean thesusMove;
                        if (new Random().nextBoolean()) {
                            thesusMove = thesusMoves.moveThesus((int) randomMove, 0);
                        } else {
                            thesusMove = thesusMoves.moveThesus(0, (int) randomMove);
                        }

                    }
                    sumCount += thesusMoves.getCount();

                }
                int averageCount = sumCount / 100;
                ShowDFSResult showDFSResult = new ShowDFSResult(averageCount);
            }

        } else {
            if (!auto) {
                ShowMaze showMaze = new ShowMaze(reader.getLength(), reader.getGrid2D(), reader.getXThesus(),
                        reader.getYThesus(), reader.getXExit(), reader.getYExit());
                
                ThesusMoves thesusMoves = new ThesusMoves(reader);
                // Depth-first search algorithm
                // depthFirstSearch(grid, reader.getXThesus(), reader.getYThesus(),
                // reader.getXExit(), reader.getYExit());
                int numRows = grid.length;
                int numCols = grid[0].length;
                boolean[][] visited = new boolean[numRows][numCols];
                int[][] stack = new int[numRows * numCols][2];
                int top = -1;

                // push le point de départ sur la pile
                stack[++top] = new int[] { reader.getXThesus(), reader.getYThesus() };

                // la position de départ est visitée
                visited[reader.getXThesus()][reader.getYThesus()] = true;

                while (top >= 0) {
                    // pop le sommet de la pile
                    int[] currentPos = stack[top--];
                    int currentX = currentPos[0];
                    int currentY = currentPos[1];

                    // vériie si la position actuelle est la position de sortie
                    if (currentX == reader.getXExit() && currentY == reader.getYExit()) {
                        // on a trouvé la sortie
                        break;
                    }

                    // explore les voisins de la position actuelle
                    int[][] neighbors = new int[][] { { currentX - 1, currentY }, { currentX + 1, currentY },
                            { currentX, currentY - 1 }, { currentX, currentY + 1 } };
                    for (int[] neighbor : neighbors) {
                        int neighborX = neighbor[0];
                        int neighborY = neighbor[1];

                        // vérifie que le voisin est dans la grille et n'a pas été visité
                        if (neighborX >= 0 && neighborX < numRows && neighborY >= 0 && neighborY < numCols
                                && !visited[neighborX][neighborY] && grid[neighborX][neighborY] != 1) {
                            // push le voisin sur la pile
                            stack[++top] = neighbor;
                            visited[neighborX][neighborY] = true;
                            System.out.println(neighborX + ", " + neighborY);
                            thesusMoves.moveThesus(neighborX - currentX, neighborY - currentY);
                            // System.out.println(thesusMoves.getCount());
                            // Thread.sleep(1000);
                            showMaze.updatePosition(neighborX, neighborY);

                        }
                    }
                }
            } else {
                ThesusMoves thesusMoves = new ThesusMoves(reader);
                // Depth-first search algorithm
                // depthFirstSearch(grid, reader.getXThesus(), reader.getYThesus(),
                // reader.getXExit(), reader.getYExit());
                int numRows = grid.length;
                int numCols = grid[0].length;
                boolean[][] visited = new boolean[numRows][numCols];
                int[][] stack = new int[numRows * numCols][2];
                int top = -1;

                // push le point de départ sur la pile
                stack[++top] = new int[] { reader.getXThesus(), reader.getYThesus() };

                // la position de départ est visitée
                visited[reader.getXThesus()][reader.getYThesus()] = true;

                while (top >= 0) {
                    // pop le sommet de la pile
                    int[] currentPos = stack[top--];
                    int currentX = currentPos[0];
                    int currentY = currentPos[1];

                    // vérifie si la position actuelle est la position de sortie
                    if (currentX == reader.getXExit() && currentY == reader.getYExit()) {
                        // on a trouvé la sortie
                        break;
                    }

                    // explore les voisins de la position actuelle
                    int[][] neighbors = new int[][] { { currentX - 1, currentY }, { currentX + 1, currentY },
                            { currentX, currentY - 1 }, { currentX, currentY + 1 } };
                    for (int[] neighbor : neighbors) {
                        int neighborX = neighbor[0];
                        int neighborY = neighbor[1];

                        // vérifie que le voisin est dans la grille et n'a pas été visité
                        if (neighborX >= 0 && neighborX < numRows && neighborY >= 0 && neighborY < numCols
                                && !visited[neighborX][neighborY] && grid[neighborX][neighborY] != 1) {
                            // push le voisin sur la pile
                            stack[++top] = neighbor;
                            visited[neighborX][neighborY] = true;
                            System.out.println(neighborX + ", " + neighborY);
                            thesusMoves.moveThesus(neighborX - currentX, neighborY - currentY);
                            // System.out.println(thesusMoves.getCount());
                            // Thread.sleep(1000);

                        }
                    }
                }
                int count = thesusMoves.getCount();
                ShowDFSResult showDFSResult = new ShowDFSResult(count);
            }
        }
    }
}