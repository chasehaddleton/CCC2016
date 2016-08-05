package Junior;

import java.util.Scanner;

/**
 * Created by Chase on 2016-02-22.
 */
public class J2 {
    final int GRID_SIZE = 4;
    int[][] dataIn = new int[GRID_SIZE][GRID_SIZE];

    public void run() {
        readInput();
        printSolution();
    }

    public void readInput() {
        try (Scanner scanner = new Scanner(System.in)) {
            for (int i = 0; i < GRID_SIZE; i++) {
                for (int j = 0; j < GRID_SIZE; j++) {
                    dataIn[i][j] = scanner.nextInt();
                }
            }
        }
    }

    public void printSolution() {
        int[][] sum = new int[2][4];

        for (int i = 0; i < GRID_SIZE; i++) {
            sum[1][i] = sumColumn(i);
            sum[2][i] = sumRow(i);
        }

        int magicSum = sum[0][0];
        boolean isMagic = true;

        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                if (sum[i][j] != magicSum) isMagic = false;
            }
        }

        System.out.println((isMagic) ? "magic" : "not magic");
    }

    private int sumColumn(int colNum) {
        int sum = 0;
        for (int i = 0; i < GRID_SIZE; i++) {
            sum += dataIn[i][colNum];
        }

        return sum;
    }

    private int sumRow(int rowNum) {
        int sum = 0;
        for (int i = 0; i < GRID_SIZE; i++) {
            sum += dataIn[rowNum][i];
        }

        return sum;
    }
}
