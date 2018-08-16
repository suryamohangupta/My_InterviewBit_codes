package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class AllSubsetIBit {

    public static void subsetsUtil(ArrayList<Integer> arr, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> subset, int index) {
        if(index>=arr.size()) {
            return ;
        }
        for(int i = index; i < arr.size(); i++) {
            if(i>index && arr.get(i)==arr.get(i-1)) {
                continue;
            }
            subset.add(arr.get(i));
            res.add(new ArrayList<>(subset));
            subsetsUtil(arr, res, subset, i + 1);
            subset.remove(subset.size() - 1);
        }
        return;
    }

    public static ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> arr) {
        Collections.sort(arr);
        System.out.println(arr);
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> sub = new ArrayList<>();
        res.add(sub);
        int index = 0;
        subsetsUtil(arr, res, sub, index);
        return res;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();//[ 15, 20, 12, 19, 4 ]
        arr.addAll(Arrays.asList(1,2,3));
        ArrayList<ArrayList<Integer>> res = subsets(arr);
        System.out.println("result:");
        System.out.println(res);
    }
}


