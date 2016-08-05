package Senior;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Chase on 2016-02-17.
 */
public class S3 implements CCCSolution {
    Scanner scanner;
    int[] phoResturants;
    Roads[] roads;
    int numRes;
    Restaurant[] res;

    public void run(Scanner scanner) {
        this.scanner = scanner;
        readInput();
        printSolution();
    }

    @Override
    public void readInput() {
        String line = scanner.nextLine();
        String[] lineAr = line.split(" ");

        int n = Integer.parseInt(lineAr[0]);
        int m = Integer.parseInt(lineAr[1]);

        phoResturants = new int[m];
        roads = new Roads[n -1];
        numRes = n;
        res = new Restaurant[numRes];

        line = scanner.nextLine();
        lineAr = line.split(" ");

        for(int i = 0; i < m; i++) {
            res[Integer.parseInt(lineAr[i])].setPho(true);
        }

        for (int i = 0; i < n - 1; i++) {
            roads[i] = new Roads(scanner.nextLine());
        }

        for (int i = 0; i < n - 1; i ++) {
            res[roads[i].getA()].setConnected(roads[i].getB());
            res[roads[i].getB()].setConnected(roads[i].getA());
        }
    }

    private class Roads {
        final int a;
        final int b;

        public Roads(String line) {
            String[] lineAr = line.split(" ");
            a = Integer.parseInt(lineAr[0]);
            b = Integer.parseInt(lineAr[1]);
        }

        public int getA() {
            return a;
        }

        public int getB() {
            return b;
        }
    }

    private class Restaurant{
        private ArrayList<Integer> connected = new ArrayList<>();
        private boolean isPho = false;

        public boolean isPho() {
            return isPho;
        }

        public void setPho(boolean pho) {
            isPho = pho;
        }

        public void setConnected(int connection) {
            connected.add(connection);
        }

        public boolean isConnected(Integer res) {
            return connected.indexOf(res) != -1;
        }

        public int numConnections() {
            return connected.size();
        }
    }

    @Override
    public void printSolution() {
        int leastCon = 0;

        for (int i = 0; i < numRes; i++) {
            if (res[i].numConnections() < res[leastCon].numConnections()) {
                leastCon = i;
            }
        }

        for (int i = 0; i < numRes; i++) {

        }
    }
}
