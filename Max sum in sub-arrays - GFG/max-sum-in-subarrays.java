// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            long n = Long.parseLong(br.readLine().trim());
            long a[] = new long[(int)(n)];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(inputLine[i]);
            }
            
            Solution obj = new Solution();
            System.out.println(obj.pairWithMaxSum(a, n));
            
        }
	}
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    
    public static long pairWithMaxSum(long arr[], long N){
if (N < 2)
    return -1;
 
// Find two consecutive elements with maximum
// sum.
long res = arr[0] + arr[1];
for (int i=1; i<N-1; i++)
    res = Math.max(res, arr[i] + arr[i+1]);
 
return res;
    }
}