package Senior;

import java.util.Scanner;

/**
 * Created by Chase on 2016-02-17.
 */
public class S5 implements CCCSolution {
    Scanner scanner;
    Cell[] cell;
    long t;
    int numCell;

    public void run(Scanner scanner) {
        this.scanner = scanner;
        readInput();
        printSolution();
    }

    @Override
    public void readInput() {
        String line = scanner.nextLine();
        String[] lineAr = line.split(" ");

        numCell = Integer.parseInt(lineAr[0]);
        t = Long.parseLong(lineAr[1]);
        cell = new Cell[numCell];

        line = scanner.nextLine();
        char[] lineChAr = line.toCharArray();

        for (int i = 0; i < numCell; i++) {
            String state = String.valueOf(lineChAr[i]);
            cell[i] = new Cell(Integer.parseInt(state));
        }
    }

    class Cell {
        private int condition;

        public Cell(int condition) {
            this.condition = condition;
        }

        public int getCondition() {
            return condition;
        }

        public void setCondition(int condition) {
            this.condition = condition;
        }

        @Override
        public String toString() {
            return "" + condition;
        }
    }

    @Override
    public void printSolution() {
        Cell[] newState = new Cell[numCell];
        System.arraycopy(cell, 0, newState, 0, numCell);

        int curCell;
        long i;
        long tLoopRun = t -1;
        int cellLoopRun = numCell - 1;

        for (i = 0; i < tLoopRun; ++i) {
            for (curCell = 0; curCell < cellLoopRun; ++curCell) {
                int leftCell = curCell - 1;
                int rightCell = curCell + 1;

                if (leftCell < 0) {
                    leftCell = numCell - 1;
                }

                if (rightCell > numCell) {
                    rightCell = 0;
                }

                // Verify if either of the origState's neighbours are alive
                if ((cell[leftCell].getCondition() == 1 && cell[rightCell].getCondition() == 0)
                        || (cell[leftCell].getCondition() == 0 && cell[rightCell].getCondition() == 1)) {
                    newState[curCell].setCondition(1);
                } else if ((cell[leftCell].getCondition() == 1 && cell[rightCell].getCondition() == 1)
                        || (cell[leftCell].getCondition() == 0 && cell[rightCell].getCondition() == 0)) {
                    newState[curCell].setCondition(0);
                }
            }

            System.arraycopy(newState, 0, cell, 0, numCell);

            System.out.println("After gen " + i);
            printArray(cell);
        }

        printArray(cell);
    }

    void printArray(Cell[] cellAr) {
        for (Cell cell : cellAr) {
            System.out.print(cell);
        }
        System.out.println();
    }
}
