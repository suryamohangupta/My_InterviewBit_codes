package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class MaxProductSubarray {

    static int maxSubarrayProduct(List<Integer> arr) {
        int n = arr.size();
        if(n==1 && arr.get(0)==0) return 0;
        int max_ending_here = 1;
        int min_ending_here = 1;
        int max_so_far = 1;
        for(int i = 0; i < n; i++) {
            if(arr.get(i) > 0) {
                max_ending_here = max_ending_here * arr.get(i);
                min_ending_here = Math.min(min_ending_here * arr.get(i), 1);
            }
            else if(arr.get(i) == 0) {
                max_ending_here = 1;
                min_ending_here = 1;
            }
            else {
                int temp = max_ending_here;
                max_ending_here = Math.max(min_ending_here * arr.get(i), 1);
                min_ending_here = temp * arr.get(i);
            }
            if(max_so_far < max_ending_here)
                max_so_far = max_ending_here;
        }
        return max_so_far;
    }

    private static boolean checkForAllNegative(List<Integer> arr) {
        for(int i = 0; i <arr.size() ; i++) {
            if(arr.get(i) > 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {

        List<Integer> arrl = new ArrayList<>();
        arrl.addAll(Arrays.asList( -4, 0, -5, 0));

        System.out.println("Maximum Sub array product is " + maxSubarrayProduct(arrl));
    }
}