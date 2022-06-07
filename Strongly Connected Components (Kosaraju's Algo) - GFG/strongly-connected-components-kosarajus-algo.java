// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Gfg
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            // arraylist of arraylist to represent graph
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            int V = Integer.parseInt(sc.next());
            int E = Integer.parseInt(sc.next());
            
            for(int i =0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
                
            for(int i = 1; i <= E; i++)
            {    int u = Integer.parseInt(sc.next());
                 int v = Integer.parseInt(sc.next());
                 
                 // adding directed edgese between 
                 // vertex 'u' and 'v'
                 adj.get(u).add(v);
            }
            
            Solution ob = new Solution();
            System.out.println(ob.kosaraju(V, adj));
		}
    }
}
// } Driver Code Ends


//User function Template for Java


class Solution
{
    //Function to find number of strongly connected components in the graph.
    public int kosaraju(int n, ArrayList<ArrayList<Integer>> adj)
    {
     int vis[] = new int[n];
        Stack<Integer> st = new Stack<Integer>();
        for(int i = 0;i<n;i++) {   //topo sort
            if(vis[i] == 0) {
                dfs(i, st, adj, vis);
            }
        }
        //tanspose
        ArrayList<ArrayList<Integer> > transpose = new ArrayList<ArrayList<Integer> >();

        for (int i = 0; i < n; i++)
            transpose.add(new ArrayList<Integer>());

        for(int i = 0;i<n;i++) {
            vis[i] = 0;
            for(Integer it: adj.get(i)) {
                transpose.get(it).add(i);
            }
        }
        int count=0;
        //dfs traversal
        while(st.size() > 0) {
            int node = st.peek();
            st.pop();
            if(vis[node] == 0) {
    
                revDfs(node, transpose, vis);
                count++;
            }
        }
        return count;
    }
    private void dfs(int node, Stack<Integer> st, ArrayList<ArrayList<Integer>> adj, int vis[]) {
        vis[node] = 1;
        for(Integer it : adj.get(node)) {
            if(vis[it] == 0) {
                dfs(it, st, adj, vis);
            }
        }
        st.push(node);
    }
    private void revDfs(int node, ArrayList<ArrayList<Integer>> transpose, int vis[]) {
        vis[node] = 1;
  
        for(Integer it : transpose.get(node)) {
            if(vis[it] == 0) {
                revDfs(it, transpose, vis);
            }
        }
    }
}
