import java.util.Arrays;

public class main {
    public static void main(String[] args) {
        runCase("banana$");
        runCase("mississippi$");
        runCase("thequickbrownfoxjumpsoverthelazydog$");
    }

    private static void runCase(String s) {
        int[] sa = SuffixArray.buildSuffixArray(s);
        int[] lcp = SuffixArray.buildLCP(s, sa);
        System.out.println("s: " + s);
        System.out.println("sa: " + Arrays.toString(sa));
        System.out.println("lcp: " + Arrays.toString(lcp));
        System.out.println();
    }
}
