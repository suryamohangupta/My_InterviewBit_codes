package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class CombinationSum2IBit {
    static ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
    public static ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> a, int b) {
        ans = new ArrayList<>();
        if(b==0) return ans;
        Collections.sort(a);
        gen(a,b,new ArrayList<Integer>(),0,-1);
        return ans;
    }
    public static void gen(ArrayList<Integer> a, int b, ArrayList<Integer> temp, int sum, int idx){
        if(sum == b){
            ans.add(new ArrayList<Integer>(temp));
            return;
        }
        else if(sum > b) return;
        int prev = -1;
        for(int i=idx+1;i<a.size();i++){
            if(prev == a.get(i)) continue;
            temp.add(a.get(i));sum+=a.get(i);
            gen(a,b,temp,sum,i);
            temp.remove(temp.size()-1);sum-=a.get(i);
            prev = a.get(i);
        }
    }

    public static void main(String[] args) {
        int B = 8;
        ArrayList<Integer> A = new ArrayList<>();
        A.addAll(Arrays.asList(10,1,2,7,6,1,5));
        System.out.println(combinationSum(A, B));

    }
}