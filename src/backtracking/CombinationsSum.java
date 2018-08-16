package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class CombinationsSum {

    public static ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B) {

        ArrayList<ArrayList<Integer>> listOfLists = new ArrayList<>();
        ArrayList<Integer> chosen = new ArrayList<>();

        if(A.size() == 0)
            return listOfLists;

        // we need sorted seqn and non duplicated sequence
        Collections.sort(A);
        // removing duplicates
        ArrayList<Integer> res = removeDuplicates(A);

        // backtracking function
        combHelper(res, 0, B, 0, listOfLists, chosen);

        return listOfLists;
    }

    public static ArrayList<Integer> removeDuplicates(ArrayList<Integer> list) {
        ArrayList<Integer> res = new ArrayList<>(list.size());

        res.add(list.get(0));

        int p2 = 0;

        for(int i = 1; i < list.size(); i++) {
            if(res.get(p2) != list.get(i)) {
                res.add(list.get(i));
                p2++;
            }
        }

        return res;
    }

    public static void combHelper(ArrayList<Integer> givenList, int curSum, int desiredSum, int start, ArrayList<ArrayList<Integer>> listOfLists, ArrayList<Integer> chosen) {
        if(curSum > desiredSum)
            return;

        if(curSum == desiredSum) {
            ArrayList<Integer> newList = new ArrayList<>(chosen);
            listOfLists.add(newList);
        }
        else {
            for(int i = start; i < givenList.size(); i++) {
                chosen.add(givenList.get(i));
                combHelper(givenList, curSum + givenList.get(i), desiredSum, i, listOfLists, chosen);
                chosen.remove(chosen.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int B = 8;
        ArrayList<Integer> A = new ArrayList<>();
        A.addAll(Arrays.asList(10, 1, 2, 7, 6, 5));
        System.out.println(combinationSum(A, B));

    }
}