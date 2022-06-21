// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class GFG
{
    public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		    
		    int n = Integer.parseInt(br.readLine().trim());
		    String inputLine[] = br.readLine().trim().split(" ");
		    int arr[] = new int[n];
		    for(int i=0; i<n; i++){
		        arr[i] = Integer.parseInt(inputLine[i]);
		    }
		    
		    int k = Integer.parseInt(br.readLine().trim());
		    
		    Solution ob= new Solution();
		    System.out.println(ob.countKdivPairs(arr, n, k));
		}
	}
}// } Driver Code Ends


//User function Template for Java

class Solution
{
    public static long countKdivPairs(int arr[], int n, int k)
    {
        long ans=0;
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            int rem=arr[i]%k;
            if(rem==0){
                if(map.get(rem)!=null){
                    ans+=map.get(rem);
                }
            }else if(map.get(k-rem)!=null){
                ans+=map.get(k-rem);
            }
            map.put(rem,map.getOrDefault(rem,0)+1);
        }
        return ans;
    }
}