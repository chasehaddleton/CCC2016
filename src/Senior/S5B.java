package Senior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Chase on 2016-02-17.
 */
public class S5B implements CCCSolution {
    boolean[] cell;
    long t;
    int numCell;

    public void run() {
        readInput();
        printSolution();
    }

    @Override
    public void readInput() {
        char[] lineChAr = null;

        try (BufferedReader dataIn = new BufferedReader(new InputStreamReader(System.in))) {
            String line = dataIn.readLine();
            String[] lineAr = line.split(" ");

            numCell = Integer.parseInt(lineAr[0]);
            t = Long.parseLong(lineAr[1]);
            cell = new boolean[numCell];

            line = dataIn.readLine();
            lineChAr = line.toCharArray();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        int loopLen = lineChAr.length;

        for (int i = 0; i < loopLen; i++) {
            String state = String.valueOf(lineChAr[i]);
            cell[i] = Integer.parseInt(state) == 1;
        }
    }

    @Override
    public void printSolution() {
        boolean[] newState = new boolean[numCell];
        System.arraycopy(cell, 0, newState, 0, numCell);

        int curCell;
        long t;
        long tLoopRun = this.t;
        int cellLoopRun = numCell;
        int leftCell, rightCell;

        for (t = 0; t < tLoopRun; ++t)
            if (t % 2 != 0) {
                for (curCell = 0; curCell < cellLoopRun; ++curCell) {
                    leftCell = curCell - 1;
                    rightCell = curCell + 1;

                    if (leftCell == -1) {
                        leftCell = numCell - 1;
                    } else if (rightCell == numCell) {
                        rightCell = 0;
                    }

                    newState[curCell] = cell[leftCell] ^ cell[rightCell];
                }
            } else {
                for (curCell = 0; curCell < cellLoopRun; ++curCell) {
                    leftCell = curCell - 1;
                    rightCell = curCell + 1;

                    if (leftCell == -1) {
                        leftCell = numCell - 1;
                    } else if (rightCell == numCell) {
                        rightCell = 0;
                    }

                    cell[curCell] = newState[leftCell] ^ newState[rightCell];
                }
            }

        if (this.t % 2 == 0) {
            printArray(newState);
        } else {
            printArray(cell);
        }
    }

    void printArray(boolean[] cellAr) {
        for (boolean cell : cellAr) {
            System.out.print((cell) ? 1 : 0);
        }
    }
}
