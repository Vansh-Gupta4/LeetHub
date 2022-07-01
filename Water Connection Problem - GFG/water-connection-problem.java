// { Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0){
            int n = sc.nextInt();
            int p = sc.nextInt();
            ArrayList<Integer> a = new ArrayList<Integer>();
            ArrayList<Integer> b = new ArrayList<Integer>();
            ArrayList<Integer> d = new ArrayList<Integer>();
            
            for(int i=0;i<p;i++)
            {
                a.add(sc.nextInt());
                b.add(sc.nextInt());
                d.add(sc.nextInt());
            }
            
            Solution ob = new Solution();
            ArrayList<ArrayList<Integer>> ans = ob.solve(n, p, a, b, d); 
            System.out.println(ans.size());
            for (int i=0;i<ans.size();i++){ 
                System.out.println(ans.get(i).get(0)+" "+ans.get(i).get(1)+" "+ans.get(i).get(2)); 
            }
        }
    } 
} // } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    static int ans=0;
    ArrayList<ArrayList<Integer>> solve(int n, int p, ArrayList<Integer> a ,ArrayList<Integer> b ,ArrayList<Integer> d) 
    {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int i= 0;
        int[] ith_ends = new int[n+1]; 
        int[] ith_receives = new int[n+1];
        int[] dia = new int[n+1];
        
        for(i=0;i<p;i++){
            int q = a.get(i);
            int h = b.get(i);
            int t = d.get(i);
            
            ith_ends[q] = h;
            dia[q] = t;
            ith_receives[h] = q;
        }
        
        for(i=1;i<=n;i++){
            if(ith_receives[i] == 0 && ith_ends[i]!=0){
                ans = Integer.MAX_VALUE;
                int w = dfs(i,ith_ends,dia);
                
                ArrayList<Integer> tem = new ArrayList<>();
                tem.add(i);
                tem.add(w);
                tem.add(ans);
                
                res.add(tem);
            }
        }
        return res;
    }
    
    int dfs(int w, int[] ith_ends, int[]dia){
        if(ith_ends[w]==0)
            return w;
            
        ans = Math.min(ans,dia[w]);
        
        return(dfs(ith_ends[w],ith_ends,dia));
    }
}  