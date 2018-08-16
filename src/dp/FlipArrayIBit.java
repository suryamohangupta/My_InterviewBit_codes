package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//https://www.interviewbit.com/problems/flip-array/
public class FlipArrayIBit {

    //    Given that we have to negate some of the elements such that total resultant sum should be minimum non-negative, can this problem be reduced to a knapsack problem?
    //        Here, the elements of the knapsack would correspond to the elements negated.
    //
    //        Come on, think dynamic!
    //
    //    Let the sum of all the given elements be S.
    //    This problem can be reduced to a Knapsack problem where we have to fill a Knapsack of capacity (S/2) as fully as possible
    //  and using the minimum no. of elements. We will fill the Knapsack with the given elements.
    //   Sign of all the elements which come into the knapsack will be flipped.
    //
    //   As sum of all the elements in the Knapsack will be as close to S/2 as possible, we are indirectly calculating
    // minimum non-negative sum of all the elements after flipping the sign. Give it a thought and code your way out!

    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public static int solve(final List<Integer> A) {
        int a[] = new int[A.size()];
        int s = 0;

        for(int i = 0; i < a.length; i++) {
            a[i] = A.get(i);
            s += a[i];
        }
        // System.out.println(s/2+1);
        int dp[] = new int[s / 2 + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i = 0; i < a.length; i++) {
            for(int j = s / 2; j >= 0; j--) {
                if(j - a[i] >= 0 && dp[j - a[i]] != Integer.MAX_VALUE) {
                    // System.out.println(a[i] + " " + j);
                    dp[j] = Math.min(dp[j], dp[j - a[i]] + 1);
                }
            }
        }
        for(int i = 0; i <dp.length ; i++) {
            System.out.println(dp[i]);
        }
        System.out.println(dp.toString());
        for(int i = dp.length - 1; i >= 0; i--) {
            // System.out.println(dp[i]);
            if(dp[i] != Integer.MAX_VALUE) {
                return dp[i];
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        List<Integer> A = new ArrayList<>();
        A.add(13);
        A.add(9);
        A.add(5);
        System.out.println(solve(A));

    }
}