package backtracking;

import java.util.ArrayList;

public class permutationsIBit {
    public void swap(ArrayList<Integer> A, int i, int j) {
        int temp = A.get(i);
        A.set(i, A.get(j));
        A.set(j, temp);
    }
    //both solution are correct

    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> solution = new ArrayList<ArrayList<Integer>>();
        aux2(solution, A, 0);
        //aux(solution, A, 0);
        return solution;
    }

    public void aux2(ArrayList<ArrayList<Integer>> solution, ArrayList<Integer> A, int index) {
        if (index == A.size()) {
            solution.add(new ArrayList<Integer>(A));
            return;
        }
        for (int i=index; i<A.size(); i++) {
            swap(A, i, index);
            aux(solution, A, index+1);
            swap(A, i, index);
        }
    }

    public void aux(ArrayList<ArrayList<Integer>> solution, ArrayList<Integer> A, int index) {
        if (index == A.size()) {
            solution.add(new ArrayList<Integer>(A));
            return;
        }
        aux(solution, A, index+1);
        for (int i=index+1; i<A.size(); i++) {
            swap(A, i, index);
            aux(solution, A, index+1);
            swap(A, i, index);
        }
    }
}
