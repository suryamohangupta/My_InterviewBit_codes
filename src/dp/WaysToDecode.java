package dp;

public class WaysToDecode {

    public static int numDecodings(String A) {
//        if(A == "0")
//            return 0;
        char digits[] = A.toCharArray();
        if(digits[0] == '0') return 0;
        int n = A.length();

        int count[] = new int[n + 1];
        count[0] = 1;
        count[1] = 1;
        for(int i = 2; i <= n; i++) {
            count[i] = 0;
            if(digits[i - 1] > '0')
                count[i] = count[i - 1];
            if(digits[i - 2] == '1' || (digits[i - 2] == '2' && digits[i - 1] < '7'))
                count[i] += count[i - 2];
        }
        return count[n];
    }

    public static int numDecodingsRecur(String A) {
        char digits[] = A.toCharArray();
        int n = A.length();
        return countDecodingRecurImpl(digits, n);
    }

    static int countDecodingRecurImpl(char[] digits, int n) {
        if(n == 0 || n == 1)
            return 1;
        int count = 0;
        if(digits[n - 1] > '0')
            count = countDecodingRecurImpl(digits, n - 1);
        if(digits[n - 2] == '1' || (digits[n - 2] == '2' && digits[n - 1] < '7'))
            count += countDecodingRecurImpl(digits, n - 2);

        return count;
    }

    public static void main(String[] args) {
        String ss = "0";
        System.out.println(numDecodings(ss));
        System.out.println(numDecodingsRecur(ss));
    }
}
//https://www.geeksforgeeks.org/count-possible-decodings-given-digit-sequence/
