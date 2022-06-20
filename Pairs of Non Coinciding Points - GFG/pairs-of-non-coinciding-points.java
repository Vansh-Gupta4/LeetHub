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
            int N = Integer.parseInt(read.readLine());
            
            String S1[] = read.readLine().split(" ");
            String S2[] = read.readLine().split(" ");
            
            int[] X = new int[N];
            int[] Y = new int[N];
            
            for(int i=0; i<N; i++)
            {
                X[i] = Integer.parseInt(S1[i]);
                Y[i] = Integer.parseInt(S2[i]);
            }

            Solution ob = new Solution();
            System.out.println(ob.numOfPairs(X,Y,N));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution {
    static int numOfPairs(int[] X, int[] Y, int N) {
        HashMap<Integer,Integer> map1=new HashMap<>();
        HashMap<Integer,Integer> map2=new HashMap<>();
        HashMap<String,Integer> map3=new HashMap<>();
        
        int sum=0;
        for(int i=0;i<X.length;i++){
            int x=X[i];
            int y=Y[i];
            
            String xy=x+"*"+y;
            
            int xFreq=map1.getOrDefault(x,0);
            int yFreq=map2.getOrDefault(y,0);
            int xyFreq=map3.getOrDefault(xy,0);
            
            sum += xFreq + yFreq - 2*xyFreq;
            map1.put(x,xFreq+1);
            map2.put(y,yFreq+1);
            map3.put(xy,xyFreq+1);
        }
        return sum;
    }
};