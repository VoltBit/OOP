package gameoflife;

import java.util.ArrayList;

/**
 * The Generator is a Singleton classes that implements a Strategy design pattern in order
 * to properly compute future generations of a given field.
 * @author Dumitru Mihai-Valentin - 325 CB
 */
final class Generator {   
    /* For boundless fields */
    static ArrayList<Cell> nextGen = new ArrayList<>();
    
    /* For bounded fields */
    static boolean[] bufferCurrent;
    static boolean[] bufferTop;
    
    /* This class must not be instantiated */
    private Generator() {}
   
    
    /**
     * Based on the given {@code gameField}, the generator chooses a strategy to properly 
     * compute the next generation.
     * @param gameField field on which to work
     */
    static void generateNext(GameField gameField) {
        if (gameField instanceof BoundedField) {
            BoundedField bf = (BoundedField) gameField;
            bufferCurrent = new boolean[bf.width];
            bufferTop = new boolean[bf.width];
            boundedNext(bf);
        } else if (gameField instanceof BoundlessField) {
            nextGen.clear();
            boundlessNext((BoundlessField) gameField);
        } else throw new RuntimeException("Field type not supported!");
    }
    
    /* Computes the next generation of a bounded field */
    private static void boundedNext(BoundedField gameField) {
        int neighbourSum;
        boolean[] temp; // nedeed to interchange the buffers and aovid reallocation
        
        /* Clear both buffers to treat them as rows of death neighbours */
        for (int i = 0; i < gameField.width; ++i) {
            bufferCurrent[i] = bufferTop[i] = false;
        }

        for (int i = 0; i < gameField.height; ++i) {
            for (int j = 0; j < gameField.width; ++j) {
                neighbourSum = 0;

                /* Previous column */
                if (j != 0) {
                    neighbourSum += (bufferTop[j-1] ? 1 : 0) + (bufferCurrent[j-1] ? 1 : 0);
                    if (i != gameField.height - 1) {
                        neighbourSum += gameField.currentGen[i+1][j-1] ? 1 : 0;
                    }
                }

                /* Current column */
                neighbourSum += bufferTop[j] ? 1 : 0;
                if (i != gameField.height - 1) {
                    neighbourSum += gameField.currentGen[i+1][j] ? 1 : 0;
                }

                /* Next column */
                if (j != gameField.width - 1) {
                    neighbourSum += (bufferTop[j+1] ? 1 : 0) + (gameField.currentGen[i][j+1] ? 1 : 0);
                    if (i != gameField.height - 1) {
                        neighbourSum += gameField.currentGen[i+1][j+1] ? 1 : 0;
                    }
                }

                bufferCurrent[j] = gameField.currentGen[i][j];

                switch (neighbourSum) {
                    case 2:
                    break;
                    case 3:
                        gameField.currentGen[i][j] = true;
                    break;
                    default:
                        gameField.currentGen[i][j] = false;
                }
            }
            /* 
             * Move on to the next row, by replacing the top buffer with the previous values of
             * the current row. Swapping them instead of just having bufferTop take the value of
             * bufferCurrent helps avoid unnecesary reallocation of bufferCurrent.
             * Here, only the memory area is needed, not the values at it.
            */
            temp = bufferCurrent;
            bufferCurrent = bufferTop;
            bufferTop = temp;
        }
    }
    
    
   /* Verifies if two cells are adjacent */
    private static boolean neighbouringCells(Cell a, Cell b) {
        if (a.equals(b)) {
            return false;
        }
        
        return (b.y >= a.y-1 && b.y <= a.y+1 && b.x >= a.x-1 && b.x <= a.x+1);
    }
    
    /**
     * The function returns the number of living neighbours a cell has and it also populates
     * the livingNeighbours boolean matrix, by marking as true the living neighbours
     */
    private static int getNeighbourState(BoundlessField gameField, Cell living, boolean[][] livingNeighbours) {
        int sz = gameField.cells.size();  /* Number of living cells in the living generation */
        Cell temp;              /* Potential neighbour */
        int neighbourCount = 0; /* Number of living neighbours the current cell has */
        int y;  /* line in the neighbours matrix */
        int x;  /* column in the neighbours matrix */
        
        for (int i = 0; i < sz; ++i) {
            temp = gameField.cells.get(i);
            if (neighbouringCells(living, temp)) {
                y = -(living.y - temp.y) + 1;
                x = -(living.x - temp.x) + 1;
                livingNeighbours[y][x] = true;
                ++neighbourCount;
            }
        }
        /* Don't count the cell itself as a dead neighbour */
        livingNeighbours[1][1] = true;
        return neighbourCount;
    }
    
    /**
     * Check the current living cell's dead neighbours to see if any of them get resurrected
     * in the next generation.
     */
    private static void processAdjacentResurrections(BoundlessField gameField, Cell living, boolean[][] livingNeighbours) {
        int sz = gameField.cells.size();  /* Number of living cells in the living generation */
        int neighbourCount; /* Number of living neighbours of a dead cell */
        Cell dead;          /* Current dead cell */
        Cell temp;              /* Potential neighbour */
        
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                if (!livingNeighbours[i][j]) {
                    neighbourCount = 0;
                    dead = new Cell(living.y+i-1, living.x+j-1);
                    
                    /* Skip next steps if this dead cell has already been resurrected */
                    if (nextGen.contains(dead)) {
                        continue;
                    }
                    
                    for (int c = 0; c < sz; ++c) {
                        temp = gameField.cells.get(c);
                        if (neighbouringCells(dead, temp)) {
                            ++neighbourCount;
                        }
                    }
                    
                    /* Decide if the cell gets resurrected */
                    if (neighbourCount == 3) {
                        nextGen.add(dead);
                    }
                }
            }
        }
    }
    
    /* Computes the next generation of a boundless field */
    private static void boundlessNext(BoundlessField gameField) {
        int sz = gameField.cells.size();  /* Number of living cells in the living generation */
        int neighbourCount;     /* Number of living neighbours a cell has */
        Cell living;            /* Current living cell */
        Cell temp;              /* Currently processed neighbour */
        ArrayList<Cell> aux;    /* Used when interchaning "cells" and "nextGen" */
        boolean[][] livingNeighbours = new boolean[3][3]; /* flase for adjacent dead cells */
        
        /* The next generation starts from no living cells */
        nextGen.clear();
        for (int i = 0; i < sz; ++i) {
            living = gameField.cells.get(i);
            neighbourCount = 0;
            
            /* Initialize all the cell's neighbors as dead */
            for (int k = 0; k < 3; ++k) {
                for (int h = 0; h < 3; ++h) {
                    livingNeighbours[k][h] = false;
                }
            }
            
            /* Decide if the cell makes it to the new generation */
            neighbourCount = getNeighbourState(gameField, living, livingNeighbours);
            if (neighbourCount == 2 || neighbourCount == 3) {
                nextGen.add(living);
            }
            
            /**
             * For every dead neighbor of the living cell, search to see if it has exactly
             * three living neighbors in order to revive it.
             */
            processAdjacentResurrections(gameField, living, livingNeighbours);
        }
        /* Change the internal state to reflect the new generation */
        aux = nextGen;
        nextGen = gameField.cells;
        gameField.cells = aux;
    }
}
