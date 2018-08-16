package dp;

class KnapsackProblemDP {

    //https://stackoverflow.com/questions/27013060/knapsack-algorithm-optimized-for-weight-instead-of-values#
    static int knapSackWithValues(int W, int wt[], int val[], int n) {
        int i, w;
        int K[][] = new int[n + 1][W + 1];
        // Build table K[][] in bottom up manner
        for(i = 0; i <= n; i++) {
            for(w = 0; w <= W; w++) {
                if(i == 0 || w == 0)
                    K[i][w] = 0;
                else if(wt[i - 1] <= w)
                    K[i][w] = Math.max(val[i - 1] + K[i - 1][w - wt[i - 1]], K[i - 1][w]);
                else
                    K[i][w] = K[i - 1][w];
            }
        }
        return K[n][W];
    }

    //use val same as weight to optimize for weight : that is fill the knapsack closest wight possible
    static int knapSack(int W, int wt[], int n , Value value) {
        int i, w;
        int K[][] = new int[n + 1][W + 1];
        // Build table K[][] in bottom up manner
        for(i = 0; i <= n; i++) {
            for(w = 0; w <= W; w++) {
                if(i == 0 || w == 0)
                    K[i][w] = 0;
                else if(wt[i - 1] <= w){
                    K[i][w] = Math.max(wt[i - 1] + K[i - 1][w - wt[i - 1]], K[i - 1][w]);
                    value.val++;
                }
                else
                    K[i][w] = K[i - 1][w];
            }
        }
        return K[n][W];
    }

    public static void main(String args[]) {
        int val[] = new int[]{ 60, 100, 120 };
        int wt[] = new int[]{ 10, 20, 30 };
        int W = 45;
        int n = val.length;
        Value value = new Value();
        value.val = 0;
        //System.out.println(knapSackWithValues(W, wt, val, n));
        System.out.println(knapSack(W, wt, n,value));
        System.out.println(value.val);
    }
}
class Value {
    int val;
}
//https://www.geeksforgeeks.org/knapsack-problem/