package dp;

class NDigitNumbersWithDigitSumS {

    static int lookup[][] = new int[101][501];

    static int countRec(int n, int sum) {
        if(n == 0)
            return sum == 0? 1 : 0;

        if(sum == 0)
            return 1;
        int ans = 0;
        for(int i = 0; i <= 9; i++)
            if(sum - i >= 0)
                ans += countRec(n - 1, sum - i);

        return ans;
    }

    static int finalCount(int n, int sum) {
        int ans = 0;
        for(int i = 1; i <= 9; i++)
            if(sum - i >= 0)
                ans += countRec(n - 1, sum - i);

        return ans;
    }

    static int countRecDP(int n, int sum) {
        if(n == 0)
            return sum == 0? 1 : 0;
        if(lookup[n][sum] != 0)
            return lookup[n][sum];
        int ans = 0;
        for(int i = 0; i < 10; i++)
            if(sum - i >= 0)
                ans += countRecDP(n - 1, sum - i);

        return lookup[n][sum] = ans;
    }

    static int finalCountDP(int n, int sum) {
        for(int i=0;i<101;i++){
            for(int j=0;j<501;j++){
                lookup[i][j]=0;
            }
        }
        int ans = 0;
        for(int i = 1; i <= 9; i++)
            if(sum - i >= 0)
                ans += countRecDP(n - 1, sum - i);
        return ans;
    }

    public static void main(String args[]) {
        int n = 84, sum = 82;
        //System.out.println(finalCount(n, sum));
        System.out.println(finalCountDP(n,sum));
    }
}