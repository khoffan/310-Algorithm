import java.io.*;
import java.util.*;
import java.lang.reflect.Array;

public class CryptArithmetic {
    private static ArrayList<Character> letters = new ArrayList<>();
    private static String s1, s2, sumStr;
    private static boolean[] isUsed = new boolean[10];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first string: ");
        s1 = sc.nextLine().trim().toLowerCase();

        System.out.print("Enter second string: ");
        s2 = sc.nextLine().trim().toLowerCase();

        System.out.print("Enter string sum: ");
        sumStr = sc.nextLine().trim().toLowerCase();

        System.out.println("\nCalculating \"" + s1 + "\" + \"" + s2 +
                "\" == \"" + sumStr + "\"");

        long start = System.currentTimeMillis();

        addLetters(s1, letters);
        addLetters(s2, letters);
        addLetters(sumStr, letters);

        int[] digits = new int[letters.size()];

        if (matchWithLetters(digits, 0)) {
            System.out.println("No solution found");
        }

        long now = System.currentTimeMillis();
        System.out.println("Elapsed time: " + ((now - start) / 1000.0) + " secs");
    } /* main */

    public static void addLetters(String s, ArrayList<Character> letters) {
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!letters.contains(ch))
                letters.add(ch);
        }
    }

    private static boolean matchWithLetters(int[] digits, int pos) {
        if (pos == letters.size()) {
            if (sumWorks(digits)) {
                System.out.println("Solution: " + Arrays.toString(digits));
                return true;
            }
            return false;
        }
        for (int i = 0; i <= 9; i++) {
            if (!isUsed[i]) {
                // assign the digit to the current letter
                digits[pos] = i;
                isUsed[i] = true;
                // move to the next letter
                if (matchWithLetters(digits, pos + 1)) {
                    return true;
                }
                // backtrack: restore the digit as unused
                isUsed[i] = false;
            }
        }
        return false;
    } /* matchWithLetters */

    private static boolean sumWorks(int[] digits) {
        // pair letters with permuted digits
        TreeMap<Character, Integer> letterVals = new TreeMap<Character, Integer>();
        for (int j = 0; j < letters.size(); j++)
            letterVals.put(letters.get(j), digits[j]);

        // use map to convert strings to numbers
        int no1 = evalNumber(s1, letterVals);
        int no2 = evalNumber(s2, letterVals);
        int sum = evalNumber(sumStr, letterVals);

        // check if the calculation works
        boolean hasSolution = false;
        if (sum == no1 + no2) {
            hasSolution = true;
            System.out.println("\n" + s1 + "(" + no1 + ") + " + s2 + "(" + no2 +
                    ") == " + sumStr + "(" + sum + ")");
            listMap(letterVals);
        }

        return hasSolution;
    } /* sumWorks */

    private static int evalNumber(String s, TreeMap<Character, Integer> letterVals) {
        int val = 0;
        for (int i = 0; i < s.length(); i++)
            val = (10 * val) + letterVals.get(s.charAt(i));
        return val;
    } /* evalNumber */

    private static void listMap(TreeMap<Character, Integer> letterVals) {
        for (Map.Entry<Character, Integer> entry : letterVals.entrySet()) {
            char key = entry.getKey();
            int value = entry.getValue();
            System.out.print("  " + key + ":" + value + ";");
        }
        System.out.println();
    }

} // end of Cryptarithmetic class
