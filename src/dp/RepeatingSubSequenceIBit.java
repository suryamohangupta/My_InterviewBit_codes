package dp;

import java.util.Arrays;

public class RepeatingSubSequenceIBit {

    int MAX_CHAR = 256;

    public int anytwo(String A) {
        char[] str2 = A.toCharArray();
        if(check(str2)) {
            return 1;
        }
        else {
            return 0;
        }

    }

    public boolean isPalindrome(char str[], int l, int h) {
        while(h > l)
            if(str[l++] != str[h--])
                return false;
        return true;
    }

    public boolean check(char str[]) {
        int n = str.length;
        int freq[] = new int[MAX_CHAR];
        Arrays.fill(freq, 0);
        for(int i = 0; i < n; i++) {
            freq[str[i]]++;
            if(freq[str[i]] > 3)
                return true;
        }
        int k = 0;
        for(int i = 0; i < n; i++)
            if(freq[str[i]] > 1)
                str[k++] = str[i];
        if(k<n){
            str[k] = '\0';
        }
        System.out.println(str);
        System.out.println(k);
        if(isPalindrome(str, 0, k - 1)) {
            System.out.println("found palin");
            if(k % 2 == 1) {
                System.out.println(str[k / 2]);
                System.out.println(str[k / 2 - 1]);
                return str[k / 2] == str[k / 2 - 1];
            }
            else
                return false;
        }
        else {
            return true;
        }
    }
}
