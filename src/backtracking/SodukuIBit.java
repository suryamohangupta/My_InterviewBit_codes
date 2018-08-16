package backtracking;

import java.util.ArrayList;
import java.util.Arrays;

public class SodukuIBit {
    static class RowAndCol{
        int row;
        int col;
    }
    static int n = 9;
    static Character unassigned  = Character.valueOf('0');

    public static boolean solveSudoku(ArrayList<ArrayList<Character>> a) {
        RowAndCol rowAndCol = new RowAndCol();

        if(!findUnassignedlocation(a,rowAndCol)){
            return true;
        }
        for(int num = 1; num <= n ; num++) {
            Character char6 = Character.forDigit(num,10);
            if(isSafe(a,char6,rowAndCol.row,rowAndCol.col)){
                ArrayList<Character> rowList = a.get(rowAndCol.row);
                rowList.set(rowAndCol.col,char6);
                a.set(rowAndCol.row,rowList);

                if (solveSudoku(a))
                    return true;

                ArrayList<Character> rowList2 = a.get(rowAndCol.row);
                rowList2.set(rowAndCol.col,unassigned);
                a.set(rowAndCol.row,rowList2);
            }
        }
        return false;
    }
    public static  boolean findUnassignedlocation(ArrayList<ArrayList<Character>> a,RowAndCol rowAndCol){
        for(int row = 0; row < n ; row++) {
            for(int col = 0; col < n ; col++) {
                if(a.get(row).get(col).equals(unassigned)){
                    rowAndCol.row = row;
                    rowAndCol.col = col;
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean UsedInRow(ArrayList<ArrayList<Character>> a, int row, Character char6){
        for(int col = 0; col < n ; col++) {
            if(a.get(row).get(col).equals(char6)){
                return true;
            }
        }
        return false;
    }

    public static boolean UsedInCol(ArrayList<ArrayList<Character>> a, int col, Character char6){
        for(int row = 0; row < n ; row++) {
            if(a.get(row).get(col).equals(char6)){
                return true;
            }
        }
        return false;
    }

    public static boolean UsedIn3x3Box(ArrayList<ArrayList<Character>> a, int row,int col, Character char6){
        for(int i = 0; i < 3 ; i++) {
            for(int j = 0; j < 3 ; j++) {
                if(a.get(row + i).get(col + j).equals(char6)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isSafe(ArrayList<ArrayList<Character>> a,Character char6,int row, int col){
        return !UsedInRow(a,row,char6) && !UsedInCol(a,col,char6) && !UsedIn3x3Box(a,row - row % 3,col -col % 3,char6);
    }

    public static void main(String[] args) {
//        int grid[N][N] = {{3, 0, 6, 5, 0, 8, 4, 0, 0},
//            {5, 2, 0, 0, 0, 0, 0, 0, 0},
//            {0, 8, 7, 0, 0, 0, 0, 3, 1},
//            {0, 0, 3, 0, 1, 0, 0, 8, 0},
//            {9, 0, 0, 8, 6, 3, 0, 0, 5},
//            {0, 5, 0, 0, 9, 0, 6, 0, 0},
//            {1, 3, 0, 0, 0, 0, 2, 5, 0},
//            {0, 0, 0, 0, 0, 0, 0, 7, 4},
//            {0, 0, 5, 2, 0, 6, 3, 0, 0}};
        ArrayList<ArrayList<Character>> a  =new ArrayList<>();
        ArrayList<Character> r1 = new ArrayList<>();
        ArrayList<Character> r2 = new ArrayList<>();
        ArrayList<Character> r3 = new ArrayList<>();
        ArrayList<Character> r4 = new ArrayList<>();
        ArrayList<Character> r5 = new ArrayList<>();
        ArrayList<Character> r6 = new ArrayList<>();
        ArrayList<Character> r7 = new ArrayList<>();
        ArrayList<Character> r8 = new ArrayList<>();
        ArrayList<Character> r9 = new ArrayList<>();
        r1.addAll(Arrays.asList('3', '0', '6', '5', '0', '8', '4', '0', '0'));
        r2.addAll(Arrays.asList('5', '2', '0', '0', '0', '0', '0', '0', '0'));
        r3.addAll(Arrays.asList('0', '8', '7', '0', '0', '0', '0', '3', '1'));
        r4.addAll(Arrays.asList('0', '0', '3', '0', '1', '0', '0', '8', '0'));
        r5.addAll(Arrays.asList('9', '0', '0', '8', '6', '3', '0', '0', '5'));
        r6.addAll(Arrays.asList('0', '5', '0', '0', '9', '0', '6', '0', '0'));
        r7.addAll(Arrays.asList('1', '3', '0', '0', '0', '0', '2', '5', '0'));
        r8.addAll(Arrays.asList('0', '0', '0', '0', '0', '0', '0', '7', '4'));
        r9.addAll(Arrays.asList('0', '0', '5', '2', '0', '6', '3', '0', '0'));
        a.add(r1);a.add(r2);a.add(r3);a.add(r4);a.add(r5);a.add(r6);a.add(r7);a.add(r8);a.add(r9);
        System.out.println(solveSudoku(a));
        System.out.println(a);

    }


}
