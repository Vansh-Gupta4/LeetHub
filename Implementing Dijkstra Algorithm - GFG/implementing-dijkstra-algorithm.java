// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass
{
    public static void main(String args[]) throws IOException {

        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int V = Integer.parseInt(str[0]);
            int E = Integer.parseInt(str[1]);
    
            ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<ArrayList<ArrayList<Integer>>>();
            for(int i=0;i<V;i++)
            {
                adj.add(new ArrayList<ArrayList<Integer>>());
            }
            
            int i=0;
            while (i++<E) {
                String S[] = read.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                int w = Integer.parseInt(S[2]);
                ArrayList<Integer> t1 = new ArrayList<Integer>();
                ArrayList<Integer> t2 = new ArrayList<Integer>();
                t1.add(v);
                t1.add(w);
                t2.add(u);
                t2.add(w);
                adj.get(u).add(t1);
                adj.get(v).add(t2);
            }
            
            int S = Integer.parseInt(read.readLine());
            
            Solution ob = new Solution();
            
            int[] ptr = ob.dijkstra(V, adj, S);
            
            for(i=0; i<V; i++)
                System.out.print(ptr[i] + " ");
            System.out.println();
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution
{
    static class pair implements Comparable<pair>{
   int ver;
   int wt;
   public pair(int n,int d)
   {
       this.wt=d;
       this.ver=n;
   }
   public int compareTo(pair p)
   {
       return this.wt - p.wt;
   }
}

   //Function to find the shortest distance of all the vertices
   //from the source vertex S.
   static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
   {
       // Write your code here
       //create ans array and initised them as a infinity
       int[] ans=new int[V];
       Arrays.fill(ans,Integer.MAX_VALUE);
       
       //source shortest length always zero
       ans[S]=0;
       
       PriorityQueue<pair> pq = new PriorityQueue<>();
       
       //add first element with 0 as distance
       pq.add(new pair(S,0));
       
       while(pq.size()>0)
       {
         
           pair p = pq.poll();
         
         //get the adjucent of all the pop vertex  
           for(ArrayList<Integer> x:adj.get(p.ver))
           {
               //if newly found path is smaller thean the previous path,
               
               if( ans[p.ver] + x.get(1) < ans[x.get(0)] )
               {
                   //then update the sortest path 
                   ans[x.get(0)] = ans[p.ver]+x.get(1);
                   
                   //add that element in priority queue for next element to move shotest weightt
                   //coz its greedy approtch
        
                   pq.add(new pair(x.get(0),ans[x.get(0)]));
                   
               }
           }
       }
       //returning the final answer
       return ans;
   }
}

