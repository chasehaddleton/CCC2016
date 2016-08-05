package Junior;

import java.util.Scanner;

/**
 * Created by Chase on 2016-02-22.
 */
public class J3 {
    Palindrome pal;

    public void run() {
        readInput();
        printSolution();
    }

    public void readInput() {
        try (Scanner scanner = new Scanner(System.in)) {
            pal = new Palindrome(scanner.nextLine());
        }
    }

    public void printSolution() {
        pal.makePalindrome();
        System.out.println(pal.toString().length());
        System.out.println(pal);
    }

    class Palindrome {
        StringBuffer palindrome;

        public Palindrome(String palindrome) {
            this.palindrome = new StringBuffer(palindrome);
        }

        public void makePalindrome() {
            if (isPalindrome()) return;

            while (!isPalindrome()) {
                palindrome.deleteCharAt(findFirstDifference(new StringBuffer(toReverse())));
            }
        }

        private int findFirstDifference(StringBuffer rev) {
            char revCh = rev.charAt(0);
            char ch = palindrome.charAt(0);
            int diffPOS = -1;

            while (revCh == ch) {
                revCh = rev.charAt(++diffPOS);
                ch = palindrome.charAt(diffPOS);
            }

            return diffPOS;
        }

        private String toReverse() {
            StringBuilder rev = new StringBuilder("");

            for (char ch : palindrome.toString().toCharArray()) {
                rev.insert(0, ch);
            }

            return rev.toString();
        }

        private boolean isPalindrome() {
            return (palindrome.toString().equals(toReverse()));
        }

        @Override
        public String toString() {
            return palindrome.toString();
        }
    }
}
