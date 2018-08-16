package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LengthOfLongestSubsequence {

    public static int longestSubsequenceLength(List<Integer> A) {
        if(A.size() <= 1)
            return A.size();
        int a[] = new int[A.size()];
        int b[] = new int[A.size()];
        for(int i = 0; i < a.length; i++) {
            a[i] = 1;
            b[i] = 1;
        }
        //calculating longest increasing subsequence from left to right
        for(int i = 1; i < A.size(); i++) {
            for(int j = 0; j < i; j++) {
                if(A.get(j) < A.get(i))
                    a[i] = Math.max(a[i], (a[j] + 1));
            }
        }
        // calculating longest decreasing subsequence from right to left
        for(int i = A.size() - 2; i >= 0; i--) {
            for(int j = A.size() - 1; j > i; j--) {
                if(A.get(j) < A.get(i))
                    b[i] = Math.max(b[i], (b[j] + 1));
            }
        }
//        System.out.println("b:");
//        System.out.println();
//        for(int i = 0; i <b.length ; i++) {
//            System.out.print(b[i]);
//        }
//        System.out.println();
//        System.out.println("a:");
//        for(int i = 0; i <a.length ; i++) {
//            System.out.print(a[i]);
//        }
        for(int i = 0; i < a.length; i++) {
            a[i] = a[i] + b[i] -1;
        }
//        System.out.println();
//        System.out.println("a:");
//        for(int i = 0; i <a.length ; i++) {
//            System.out.print(a[i]);
//        }
        int max = 0;
        for(int i = 0; i < a.length; i++) {
            if(max < a[i])
                max = a[i];
        }
//        System.out.println();
//        System.out.println("RESULT:");
        return max;
    }

    public static void main(String[] args) {
        //[1 11 2 10 4 5 2 1]
        List<Integer> A = new ArrayList<>();
        A.addAll(Arrays.asList(1,11, 2, 10, 4, 5, 2, 1));
        System.out.println(longestSubsequenceLength(A));
    }
}