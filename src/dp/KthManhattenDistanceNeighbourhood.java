package dp;

import java.util.ArrayList;

public class KthManhattenDistanceNeighbourhood {
//https://www.geeksforgeeks.org/sum-manhattan-distances-pairs-points/
    public ArrayList<ArrayList<Integer>> solve(int A, ArrayList<ArrayList<Integer>> B) {
        int m = B.get(0).size(), n = B.size();
        int[][] dp = new int[n][m];

        for(int i = 0; i < n; i++)
            for(int j = 0; j < m; j++)
                dp[i][j] = B.get(i).get(j);
        for(int k = 1; k <= A; k++) {
            int[][] tdp = new int[n][m];
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    int max = dp[i][j];
                    if(i > 0 && max < dp[i - 1][j])
                        max = dp[i - 1][j];
                    if(i < n - 1 && max < dp[i + 1][j])
                        max = dp[i + 1][j];
                    if(j > 0 && max < dp[i][j - 1])
                        max = dp[i][j - 1];
                    if(j < m - 1 && max < dp[i][j + 1])
                        max = dp[i][j + 1];
                    tdp[i][j] = max;
                }
            }
            dp = tdp;
        }

        ArrayList<ArrayList<Integer>> r = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            ArrayList<Integer> t = new ArrayList<>();
            for(int j = 0; j < m; j++)
                t.add(dp[i][j]);
            r.add(t);
        }
        return r;
    }
}
