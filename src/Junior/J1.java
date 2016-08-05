package Junior;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Chase on 2016-02-22.
 */
public class J1 {
    ArrayList<String> dataIn = new ArrayList<>();

    public void run() {
        readInput();
        printSolution();
    }

    public void readInput() {
        try (Scanner scanner = new Scanner(System.in)) {
            String line = scanner.nextLine();
            while (line != null) {
                dataIn.add(line);
            }
        }
    }

    public void printSolution() {
        int scoreCount = 0;
        for (String game : dataIn) {
            if (game.startsWith("W")) scoreCount++;
        }

        if (scoreCount > 4) {
            System.out.println(1);
        } else if (scoreCount > 2) {
            System.out.println(2);
        } else if (scoreCount > 0) {
            System.out.println(3);
        } else {
            System.out.print(-1);
        }
    }
}
