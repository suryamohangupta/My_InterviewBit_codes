package backtracking;

import java.util.ArrayList;

class CombinationsIBit {

    static void combinationUtil(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> arr, ArrayList<Integer> data, int n, int r, int index, int i) {
        if(index == r) {
            res.add(new ArrayList<>(data));
            return;
        }
        if(i >= n)
            return;

        data.add(arr.get(i));
        combinationUtil(res, arr, data, n, r, index + 1, i + 1);
        data.remove(data.size()-1);
        combinationUtil(res, arr, data, n, r, index, i + 1);
    }

    static void getAllCombination(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> arr, int n, int r) {
        ArrayList<Integer> data = new ArrayList<>();
        combinationUtil(res, arr, data, n, r, 0, 0);
    }

    public static ArrayList<ArrayList<Integer>> combine(int n, int r) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i = 1; i <= n; i++) {
            arr.add(i);
        }
        getAllCombination(res, arr, n, r);
        System.out.println(res);
        return res;
    }

    /*Driver function to check for above function*/
    public static void main(String[] args) {
        combine(5, 3);
    }
}
