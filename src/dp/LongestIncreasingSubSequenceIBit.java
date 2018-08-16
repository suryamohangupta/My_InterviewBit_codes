package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestIncreasingSubSequenceIBit {

    public static  int lis(final List<Integer> A) {
        int n = A.size();
        int lis[] = new int[n];
        int i, j, max = 0;
        for(i = 0; i < n; i++) {
            lis[i] = 1;
        }
        for(i = 1; i < n; i++) {
            for(j = 0; j < i; j++) {
                if(A.get(i) > A.get(j) && lis[i] < lis[j] + 1) {
                    lis[i] = lis[j] + 1;
                }
            }
        }
        for(i = 0; i < n; i++) {
            if(max < lis[i]) {
                max = lis[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        List<Integer> A = new ArrayList<>();
        //0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15
        A.addAll(Arrays.asList(0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15));
        System.out.println(lis(A));
    }
}
