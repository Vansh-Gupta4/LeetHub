// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int m = Integer.parseInt(inputLine[1]);
            int[][] arr = new int[n][m];
            inputLine = br.readLine().trim().split(" ");
        
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    arr[i][j] = Integer.parseInt(inputLine[i * m + j]);
                }
            }
            int ans = new Solution().rowWithMax1s(arr, n, m);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    int rowWithMax1s(int arr[][], int n, int m) {
        // code here
        int Maxcount=0;
        int row=-1;
        for(int i=0;i<n;i++){
            int countOf1inEachRow=binarySearch(arr,i);
            
            if(countOf1inEachRow > Maxcount){
                Maxcount=countOf1inEachRow;
                row=i;
            }
        }
        return row;
    }
    public static int binarySearch(int[][] mat,int r){
        int lo=0;
        int hi=mat[0].length-1;
        int FirstIndexOf1=mat[0].length;
        
        while(lo<=hi){
            int mid = (lo+hi)/2;
            if(mat[r][mid]==1){
                FirstIndexOf1=mid;
                hi=mid-1;
            }else{
                lo=mid+1;
            }
        }
        int count=mat[0].length-FirstIndexOf1;
        return count;
    }
}