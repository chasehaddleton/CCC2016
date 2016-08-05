package Senior;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Chase on 2016-02-17.
 */
public class S4 implements CCCSolution {
    Scanner scanner;
    ArrayList<Integer> riceBallSize;
    int numRiceBalls;

    public void run(Scanner scanner) {
        this.scanner = scanner;
        readInput();
        printSolution();
    }

    @Override
    public void readInput() {
        numRiceBalls = Integer.parseInt(scanner.nextLine());
        riceBallSize = new ArrayList<>(numRiceBalls);

        String line = scanner.nextLine();
        String[] sizes = line.split(" ");

        for (String size : sizes) {
            riceBallSize.add(Integer.valueOf(size));
        }
    }

    @Override
    public void printSolution() {
        for (int j = 0; j < numRiceBalls; j++) {
            for (int i = 0; i < riceBallSize.size() - 1; i++) {
                for(int size: riceBallSize) {
                    System.out.print(size + " ");
                }
                System.out.println();

                if (i + 2 < riceBallSize.size() && riceBallSize.get(i).equals(riceBallSize.get(i + 2))) {
                    int size = (2 * riceBallSize.get(i)) + riceBallSize.get(i + 1);
                    riceBallSize.remove(i);
                    riceBallSize.remove(i);
                    riceBallSize.remove(i);
                    riceBallSize.add(i, size);
                } else if (riceBallSize.get(i).equals(riceBallSize.get(i + 1))) {
                    int size = 2 * riceBallSize.get(i);
                    riceBallSize.remove(i);
                    riceBallSize.remove(i);
                    riceBallSize.add(i, size);
                }
            }
        }

        int largest = riceBallSize.get(0);
        for (int size : riceBallSize) {
            if (size > largest) {
                largest = size;
            }
        }

        System.out.println(largest);
    }
}
