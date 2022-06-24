// { Driver Code Starts
//Initial Template for Java


import java.io.*;
import java.util.*;
class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String S = read.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.longestSubstrDistinctChars(S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int longestSubstrDistinctChars(String S){
       int length = 0;
    HashMap < Character, Integer > map = new HashMap < Character, Integer > ();
    int left = 0,right=0;
    int n=S.length();
    while (right<n){ 
        char rightCh=S.charAt(right);
        if (map.containsKey(rightCh)){ 
            left=Math.max(left,map.get(rightCh) + 1);
        }
        map.put(rightCh,right);
        length = Math.max(length, right - left + 1);
        right++;
    }
    return length;
    }
}