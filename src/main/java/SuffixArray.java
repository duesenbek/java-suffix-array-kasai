import java.util.*;

public class SuffixArray {
    public static int[] buildSuffixArray(String s) {
        int n = s.length();

        Integer[] helper = new Integer[n];

        for (int i = 0; i < n; i++) {
            helper[i] = i;
        }
        Arrays.sort(helper, (a, b) -> s.substring(a).compareTo(s.substring(b)));
        int[] suffixArray = new int[n];
        for (int i = 0; i < n; i++) {
            suffixArray[i] = helper[i];

        }
        return suffixArray;
    }
    public static int[] buildLCP(String s, int[] sa) {
        int n = s.length();
        int[] rank = new int[n];
        for (int i = 0; i < n; i++) {
            rank[sa[i]] = i;
        }
        int[] lcp = new int[n];
        int k = 0;
        for (int i = 0; i < n; i++) {
            int r = rank[i];
            if (r == 0) {
                k = 0;
                continue;
            }
            int j = sa[r - 1];
            while (i + k < n && j + k < n && s.charAt(i + k) == s.charAt(j + k)) {
                k++;
            }
            lcp[r] = k;
            if (k > 0) k--;
        }
        return lcp;
    }
}


