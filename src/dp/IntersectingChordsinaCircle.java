package dp;

public class IntersectingChordsinaCircle {

    public int chordCnt(int n) {
        long dp[] = new long[n + 1];
        // if(n%2!=0) return 0;
        if(n == 0 || n == 1)
            return 1;
        else if(n == 2)
            return 2;
        else if(n > 2) {
            dp[0] = 1;
            dp[1] = 1;
            dp[2] = 2;
            for(int i = 3; i <= n; i++) {
                dp[i] = 0;
                for(int k = 0; k < i; k++) {
                    dp[i] = (dp[i] + dp[i - k - 1] * dp[k]) % 1000000007;
                }
            }
            return (int)dp[n] % 1000000007;
        }
        return 0;
    }
}
//https://www.geeksforgeeks.org/count-ways-divide-circle-using-n-non-intersecting-chords/
//https://github.com/shreya367/InterviewBit/blob/master/DynamicProgramming/Intersecting%20Chords%20in%20a%20Circle
