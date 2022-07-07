// { Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);
        
        return a;
    }
    
    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
    
    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n; 
            n = Integer.parseInt(br.readLine());
            
            
            int[] arr = IntArray.input(br, n);
            
            Solution obj = new Solution();
            int res = obj.findMaxProduct(n, arr);
            
            System.out.println(res);
            
        }
    }
}
// } Driver Code Ends


class Solution {
    public static int findMaxProduct(int n, int[] arr) {
       int mod=1000000007;
       if(n==1) return arr[0];
       long max = 1;
       int max_negative = Integer.MIN_VALUE;
       int count_neg = 0;
       int count_zero = 0;
       for(int i = 0;i<n;i++){
           if(arr[i]==0){
               count_zero++;
               continue;
           }
           else if(arr[i]<0){
               max_negative = Math.max(max_negative,arr[i]);
               count_neg++;
           }
           max =(max*arr[i])%mod;
       }
       if(count_zero==n) return 0;
       if(count_neg==1 && count_zero+count_neg==n) return 0;
       if(count_neg%2==1) max = max/max_negative;
       return (int)max;
   }
}
        
