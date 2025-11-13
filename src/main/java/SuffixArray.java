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
        public static  void main(String[] args){
            String s="banana$";

            int[] SuffixArray = buildSuffixArray(s);
            System.out.println(s+Arrays.toString(SuffixArray));
            }



        }


