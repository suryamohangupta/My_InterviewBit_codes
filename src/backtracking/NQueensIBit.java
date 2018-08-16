package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class NQueensIBit {

    public static ArrayList<ArrayList<String>> solveNQueens(int a) {
        ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
        ArrayList<char[]> board = new ArrayList<>();
        for(int i = 0; i < a; i++) {
            board.add(new char[a]);
            Arrays.fill(board.get(board.size() - 1), '.');
        }
        helper(a, board, 0, res);
        return res;
    }

    private static void helper(int a, ArrayList<char[]> board, int row, ArrayList<ArrayList<String>> res) {
        if(a == row) {
            res.add(new ArrayList<>(board.stream().map(r -> String.valueOf(r)).collect(Collectors.toList())));
            return;
        }
        char[] currRow = board.get(row);
        for(int i = 0; i < a; i++) {
            currRow[i] = 'Q';
            if(isValid(board, row, i))
                helper(a, board, row + 1, res);
            currRow[i] = '.';
        }
    }

    private static boolean isValid(ArrayList<char[]> board, int row, int col) {
        int coll = col - 1, colr = col + 1;
        row--;
        while(row >= 0) {
            if(board.get(row)[col] == 'Q')
                return false;
            if(coll >= 0 && board.get(row)[coll] == 'Q')
                return false;
            if(colr < board.size() && board.get(row)[colr] == 'Q')
                return false;
            row--;
            coll--;
            colr++;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(solveNQueens(5).size());
    }

}
