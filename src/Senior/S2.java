package Senior;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Chase on 2016-02-17.
 */
public class S2 implements CCCSolution {
    Scanner scanner;
    String[] dCitizenSpeedSt, pCitizenSpeedSt;
    int[] dCitizenSpeed, pCitizenSpeed, pCitizenSpeedRev;
    int type;
    int numCitizens;

    public void run(Scanner scanner) {
        this.scanner = scanner;
        readInput();
        printSolution();
    }

    @Override
    public void readInput() {
        type = Integer.parseInt(scanner.nextLine());
        numCitizens = Integer.parseInt(scanner.nextLine());

        dCitizenSpeed = new int[numCitizens];
        pCitizenSpeed = new int[numCitizens];
        pCitizenSpeedRev = new int[numCitizens];

        String line = scanner.nextLine();
        dCitizenSpeedSt = line.split(" ");
        line = scanner.nextLine();
        pCitizenSpeedSt = line.split(" ");

        for (int i = 0; i < numCitizens; i++) {
            dCitizenSpeed[i] = Integer.parseInt(dCitizenSpeedSt[i]);
            pCitizenSpeed[i] = Integer.parseInt(pCitizenSpeedSt[i]);
        }

        Arrays.sort(dCitizenSpeed);
        Arrays.sort(pCitizenSpeed);

        if (type == 2) {
            for (int i = 0; i < numCitizens; i++) {
                pCitizenSpeedRev[i] = pCitizenSpeed[numCitizens - i - 1];
            }
        }

    }

    @Override
    public void printSolution() {
        int sum = 0;

        if (type == 2) {
            for (int i = 0; i < numCitizens; i++) {
                sum += Math.max(dCitizenSpeed[i], pCitizenSpeedRev[i]);
            }
        } else {
            for (int i = 0; i < numCitizens; i++) {
                sum += Math.max(dCitizenSpeed[i], pCitizenSpeed[i]);
            }
        }

        System.out.println(sum);
    }
}
