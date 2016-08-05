import Senior.S5C;

public class Main {
    public static void main(String[] args) {
        double start = System.nanoTime();
        S5C q5C = new S5C();
        q5C.run();
        System.out.println();
        System.out.println("S5C: " + (System.nanoTime() - start));
    } // s5.2.in S5C: 1.023889058E9, S5B: 2.37875105E9
    // s5.3.in S5B: 1.407688294E10 S5C: 1.18582888354E11
}