package dp;

import java.util.ArrayList;

public class RodCuttingDpIBit {

    ArrayList<Integer> result;
    int[]              cuts;
    int[][]            parent;

    public ArrayList<Integer> rodCut(int rod, ArrayList<Integer> scores) {
        int n = scores.size() + 2;
        cuts = new int[n];
        cuts[0] = 0;
        for(int i = 0; i < scores.size(); i++) {
            cuts[i + 1] = scores.get(i);
        }
        cuts[n - 1] = rod;

        long[][] dp = new long[n][n];
        parent = new int[n][n];
        for(int len = 1; len <= n; len++) {
            for(int s = 0; s < n - len; s++) {
                int e = s + len;
                for(int k = s + 1; k < e; k++) {
                    long sum = cuts[e] - cuts[s] + dp[s][k] + dp[k][e];
                    if(dp[s][e] == 0 || sum < dp[s][e]) {
                        dp[s][e] = sum;
                        parent[s][e] = k;
                    }
                }
            }
        }

        result = new ArrayList<>();
        backTrack(0, n - 1);

        return result;
    }

    private void backTrack(int s, int e) {
        if(s + 1 >= e) {
            return;
        }

        result.add(cuts[parent[s][e]]);
        backTrack(s, parent[s][e]);
        backTrack(parent[s][e], e);
    }
}
//    We rewrite our problem as given N cut points (and you cannot make first and last cut),
//    decide order of these cuts to minimise the cost. So, we insert 0 and N at beginning and end of vector B.
//    Now, we have solve our new problem with respect to this new array(say A).
//
//        We define dp(i, j) as minimum cost for making cuts Ai, Ai+1, …, Aj.
//        Note that you are not making cuts Ai and Aj, but they decide the cost for us.
//
//            For solving dp(i, j), we iterate k from i+1 to j-1, assuming that the first cut we make in this interval is Ak.
//          The total cost required(if we make first cut at Ak) is Aj - Ai + dp(i, k) + dp(k, j).
//
//        This is our solution. We can implement this DP recursively with memoisation. Total complexity will be O(N3).
//        For actually building the solution, after calculating dp(i, j), we can store the index k which gave
// the minimum cost and then we can build the solution backwards.