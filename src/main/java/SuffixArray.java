import java.util.*;

/**
 * Utility methods to build a suffix array and its LCP array.
 *
 * Notes on complexity:
 * - buildSuffixArray uses a naive comparator over suffix strings: O(n^2 log n) time in practice
 *   (sorting n items with O(n) compare). Space: O(n) for indices + O(n) for result.
 * - buildLCP implements Kasai's algorithm: O(n) time, O(n) extra space for rank and lcp.
 */
public class SuffixArray {
    /**
     * Builds the suffix array of s by sorting suffix starting indices
     * using Java's String comparator on substrings (simple but not linear).
     * 
     * Time complexity: O(n^2 log n) due to sorting n suffixes with O(n) compare.
     * Space complexity: O(n) for indices + O(n) for result.
     */
    public static int[] buildSuffixArray(String s) {
        int n = s.length();

        Integer[] helper = new Integer[n];

        for (int i = 0; i < n; i++) {
            helper[i] = i;
        }
        // Sort indices by their corresponding suffixes. This is easy to code but not optimal
        // for very large inputs because String.compareTo inspects characters.
        Arrays.sort(helper, (a, b) -> s.substring(a).compareTo(s.substring(b)));
        int[] suffixArray = new int[n];
        for (int i = 0; i < n; i++) {
            suffixArray[i] = helper[i];

        }
        return suffixArray;
    }
    /**
     * Kasai's algorithm for building the LCP array in O(n) time.
     * lcp[i] = LCP between suffixes starting at sa[i] and sa[i-1], with lcp[0] = 0.
     */
    public static int[] buildLCP(String s, int[] sa) {
        int n = s.length();
        // rank[pos] = position of suffix starting at pos in the suffix array
        int[] rank = new int[n];
        for (int i = 0; i < n; i++) {
            rank[sa[i]] = i;
        }
        int[] lcp = new int[n]; // lcp[0] stays 0 by convention
        int k = 0;              // length of current LCP; we reuse k and decrement by one each step
        // Scan suffixes in text order; each character is compared at most twice overall
        for (int i = 0; i < n; i++) {
            int r = rank[i];
            if (r == 0) {
                k = 0;
                continue;
            }
            int j = sa[r - 1];
            // Extend k while current pair of suffixes match
            while (i + k < n && j + k < n && s.charAt(i + k) == s.charAt(j + k)) {
                k++;
            }
            lcp[r] = k;
            if (k > 0) k--;
        }
        return lcp;
    }
}


