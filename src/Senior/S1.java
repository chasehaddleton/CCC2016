package Senior;

import java.util.Scanner;

/**
 * Created by Chase on 2016-02-17.
 */
public class S1 implements CCCSolution {
    Scanner scanner;
    String base, comparison;

    public void run(Scanner scanner) {
        this.scanner = scanner;
        readInput();
        printSolution();
    }

    @Override
    public void readInput() {
        base = scanner.nextLine();
        comparison = scanner.nextLine();
    }

    @Override
    public void printSolution() {
        if (base.length() != comparison.length()) {
            System.out.println("N");
            return;
        }

        int astCount = 0;
        char[] baseAr = base.toCharArray();
        StringBuffer compB = new StringBuffer(comparison);

        for (int i = 0; i < base.length(); i++) {
            int index = compB.indexOf(String.valueOf(baseAr[i]));
            if (index >= 0) {
                compB.deleteCharAt(index);
            }
        }

        for (char ch : compB.toString().toCharArray()) {
            if (ch == '*') {
                ++astCount;
            }
        }

        if (compB.length() == 0 || compB.length() == astCount) {
            System.out.println("A");
        } else {
            System.out.println("N");
        }
    }
}
