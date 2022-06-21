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
            Long N = Long.parseLong(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.getSmallest(N));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution {
   static String getSmallest(Long n)
    {
        if(n<10)
          return Long.toString(n);
	    
	    long res=0;
		for (int i=9; i>1; i--)
		{
			while ((n%i)==0)
			{
				res=(res*10)+i;
				n = n/i;
			}
		}
		
        if(n==1)
        {
          res=reverse(res);
          return Long.toString(res);
        }
        return "-1";
    }
    
    public static long reverse(long num)
    {
        long rev=0;
        while(num!=0)
        {
           int last=(int)(num%10);
           rev=rev*10+last; 
           num=num/10;
        }
        return rev;
    }
    
};