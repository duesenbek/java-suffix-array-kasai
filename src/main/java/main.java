import java.util.Arrays;

/**
 * Entry point to demonstrate suffix array construction and Kasai's LCP.
 * Prints the input string, its suffix array, and the LCP array.
 */
public class main {
    /**
     * Runs three sample cases (short, medium, long) to observe behavior across sizes.
     * The terminal '$' sentinel helps ensure suffixes are unique and lexicographic order is well-defined.
     */
    public static void main(String[] args) {
        runCase("banana$");
        runCase("mississippi$");
        runCase("thequickbrownfoxjumpsoverthelazydog$");
    }

    /**
     * Builds the suffix array and LCP via Kasai for the given string and prints them.
     */
    private static void runCase(String s) {
        int[] sa = SuffixArray.buildSuffixArray(s);
        int[] lcp = SuffixArray.buildLCP(s, sa);
        System.out.println("s: " + s);
        System.out.println("sa: " + Arrays.toString(sa));
        System.out.println("lcp: " + Arrays.toString(lcp));
        System.out.println();
    }
}
