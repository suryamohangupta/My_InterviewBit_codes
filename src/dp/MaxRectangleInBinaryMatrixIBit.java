package dp;

import dp.LargestRectAreaInHistogram;

import java.util.ArrayList;

public class MaxRectangleInBinaryMatrixIBit {

    public static int maximalRectangle(ArrayList<ArrayList<Integer>> a) {
        int m, n;
        m = a.size();
        n = a.get(0).size();
        int aux[][] = new int[m][n];
        fillAux(aux, a, m, n);
        return LargestRectAreaInHistogram.maxRectangle(m,n,aux);
    }

    private static void fillAux(int[][] aux, ArrayList<ArrayList<Integer>> a, int m, int n) {
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(a.get(i).get(j) == 1) {
                    aux[i][j] = 1;
                }
                else
                    aux[i][j] = 0;
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> a = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> a1 = new ArrayList<>();
        a1.add(0);a1.add(1);a1.add(1);a1.add(0);
        ArrayList<Integer> a2 = new ArrayList<>();
        a2.add(1);a2.add(1);a2.add(1);a2.add(1);
        ArrayList<Integer> a3 = new ArrayList<>();
        a3.add(1);a3.add(1);a3.add(1);a3.add(1);
        ArrayList<Integer> a4 = new ArrayList<>();
        a4.add(1);a4.add(1);a4.add(0);a4.add(0);
        a.add(a1);a.add(a2);
        a.add(a3);a.add(a4);
        System.out.print("Area of maximum rectangle is " +maximalRectangle(a) );
    }
}