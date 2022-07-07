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
            StringTokenizer stt = new StringTokenizer(br.readLine());
            
            int n = Integer.parseInt(stt.nextToken());
            int k = Integer.parseInt(stt.nextToken());
            long a[] = new long[(int)(n)];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(inputLine[i]);
            }
            
            Solution obj = new Solution();
            System.out.println(obj.maximizeSum(a, n, k));
            
        }
	}
}
// } Driver Code Ends


//User function Template for Java


class Solution {

    public static long maximizeSum(long A[], int n, int K)
    {
       Arrays.sort(A);
        long count = 0, sum = 0, minPositive = Integer.MAX_VALUE;
        for (long num : A) {
            if (num < 0 && ++count <= K) {
                num = -num;
            }
            sum += num;
            minPositive = Math.min(minPositive, num);
        }
        if (count > K || (K - count) % 2 == 0) {
            return sum;
        } else {
            return sum - minPositive * 2;
        } 
    }
}