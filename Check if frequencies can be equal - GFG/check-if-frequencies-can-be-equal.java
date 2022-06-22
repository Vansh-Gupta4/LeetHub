// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            
            String input[] = read.readLine().split(" ");
            String a = input[0];
            
            Solution ob = new Solution();
            if(ob.sameFreq(a)){
                System.out.println(1);
            }
            else{
                System.out.println(0);
            }
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution {
    static final int M = 26;
    boolean sameFreq(String str) {
         int l = str.length();
 

        int[] freq = new int[M];
 
        for (int i = 0; i < l; i++)
            freq[getIdx(str.charAt(i))]++;
 
        // if all frequencies are same, then return true
        if (allSame(freq, M))
            return true;
 
        /*  Try decreasing frequency of all character
            by one and then check all equality of all
            non-zero frequencies */
        for (char c = 'a'; c <= 'z'; c++) {
            int i = getIdx(c);
 
            // Check character only if it occurs in str
            if (freq[i] > 0) {
                freq[i]--;
 
                if (allSame(freq, M))
                    return true;
                freq[i]++;
            }
        }
 
        return false;
    }

 
    // Utility method to get index of character ch
    // in lower alphabet characters
    static int getIdx(char ch)
    {
        return (ch - 'a');
    }
 
    // Returns true if all non-zero elements
    // values are same
    static boolean allSame(int freq[], int N)
    {
        int same = 0;
 
        // get first non-zero element
        int i;
        for (i = 0; i < N; i++) {
            if (freq[i] > 0) {
                same = freq[i];
                break;
            }
        }
 
        // check equality of each element with
        // variable same
        for (int j = i + 1; j < N; j++)
            if (freq[j] > 0 && freq[j] != same)
                return false;
 
        return true;
    }
}