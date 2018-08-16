package dp;

public class LongestCommonSubSequence {
//https://www.geeksforgeeks.org/longest-common-subsequence/

//A subsequence is a sequence that appears in the same relative order, but not necessarily contiguous.
//For example, “abc”, “abg”, “bdf”, “aeg”, ‘”acefg”, .. etc are subsequences of “abcdefg”.
// So a string of length n has 2^n different possible subsequences.

    int lcs(char[] X, char[] Y, int m, int n) {
        if(m == 0 || n == 0)
            return 0;
        if(X[m - 1] == Y[n - 1])
            return 1 + lcs(X, Y, m - 1, n - 1);
        else
            return Math.max(lcs(X, Y, m, n - 1), lcs(X, Y, m - 1, n));
    }

    int lcsDP(char[] X, char[] Y, int m, int n) {
        int L[][] = new int[m + 1][n + 1];
        for(int i = 0; i <= m; i++) {
            for(int j = 0; j <= n; j++) {
                if(i == 0 || j == 0)
                    L[i][j] = 0;
                else if(X[i - 1] == Y[j - 1])
                    L[i][j] = L[i - 1][j - 1] + 1;
                else
                    L[i][j] = Math.max(L[i - 1][j], L[i][j - 1]);
            }
        }
        return L[m][n];
    }

    public static void main(String[] args) {
        LongestCommonSubSequence lcs = new LongestCommonSubSequence();
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";
        char[] X = s1.toCharArray();
        char[] Y = s2.toCharArray();
        int m = X.length;
        int n = Y.length;
        System.out.println("Length of LCS is" + " " + lcs.lcs(X, Y, m, n));
        System.out.println("Length of LCS is" + " " + lcs.lcsDP(X, Y, m, n));
    }
}
