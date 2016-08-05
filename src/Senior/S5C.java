package Senior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Chase on 2016-02-17.
 */
public class S5C implements CCCSolution {
    BigInteger cell;
    long t;
    int numCell;

    public void run() {
        readInput();
        printSolution();
    }

    @Override
    public void readInput() {
        try (BufferedReader dataIn = new BufferedReader(new InputStreamReader(System.in))) {
            String line = dataIn.readLine();
            String[] lineAr = line.split(" ");

            numCell = Integer.parseInt(lineAr[0]);
            t = Long.parseLong(lineAr[1]);

            line = dataIn.readLine();
            cell = new BigInteger(line);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void printSolution() {
        for (int t = 0; t < this.t; t++) {
            evolve();
        }
        for (char cell: this.cell.toString().toCharArray()) {
            System.out.print(cell);
        }
    }

    final BigInteger two = new BigInteger("2");

    void evolve() {
        BigInteger msbMask = new BigInteger(cell.toString());

        boolean msb = cell.and(msbMask).compareTo(BigInteger.ZERO) == 1;
        boolean msbp = cell.and(msbMask.shiftRight(1)).compareTo(BigInteger.ZERO) == 1;
        boolean ones = cell.and(BigInteger.ONE).compareTo(BigInteger.ZERO) == 1;
        boolean twos = cell.and(two).compareTo(BigInteger.ZERO) == 1;

        cell = cell.shiftLeft(1).xor(cell.shiftRight(1)).and(msbMask);

        if (msb ^ twos) {
            cell.add(BigInteger.ONE);
        }

        if (msbp ^ ones) {
            cell = cell.and(msbMask);
        }
    }
}
