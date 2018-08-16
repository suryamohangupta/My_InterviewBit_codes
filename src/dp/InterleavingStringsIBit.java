package dp;

public class InterleavingStringsIBit {

    public static void main(String[] args) {
        String A= "Baaa";
        String B = "ert";
        String C = "Baaaert";
        System.out.println(isInterleave(A,B,C));
    }
    public static int isInterleave(String A, String B, String C) {
        if(IsInterleaved(A, B, C)) {
            return 1;
        }
        else {
            return 0;
        }
    }

    //inter[i][j] will be true if C[0..i+j-1]
    // is an interleaving of A[0..i-1] and B[0..j-1].
    public static boolean IsInterleaved(String A, String B, String C) {
        int m = A.length();
        int n = B.length();
        boolean inter[][] = new boolean[m + 1][n + 1];
        //Arrays.fill(inter, false);//
        if(m + n != C.length()) {
            return false;
        }
        for(int i = 0; i <= m; ++i) {
            for(int j = 0; j <= n; ++j) {
                if(i == 0 && j == 0) {
                    inter[i][j] = true;
                }
                else if(i == 0){
                    if(B.charAt(j-1) == C.charAt(j - 1)){
                        inter[i][j] = inter[i][j - 1];
                    }else{
                        inter[i][j] = false;
                    }
                }
                else if(j == 0){
                    if(A.charAt(i-1) == C.charAt(i - 1)){
                        inter[i][j] = inter[i-1][j];
                    }else{
                        inter[i][j] = false;
                    }
                }
                else if(A.charAt(i-1) == C.charAt(i + j - 1) && B.charAt(j-1) != C.charAt(i + j - 1)) {
                    inter[i][j] = inter[i - 1][j];
                }
                else if(A.charAt(i-1) != C.charAt(i + j - 1) && B.charAt(j-1) == C.charAt(i + j - 1)) {
                    inter[i][j] = inter[i][j - 1];
                }
                else if(A.charAt(i-1) == C.charAt(i + j - 1) && B.charAt(j-1) == C.charAt(i + j - 1)) {
                    inter[i][j] = (inter[i - 1][j] || inter[i][j - 1]);
                }
            }
        }
        return inter[m][n];
    }
}
