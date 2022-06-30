// { Driver Code Starts
//Initial Template for Java


import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String S = br.readLine().trim();
            int N = S.length();
            Solution ob = new Solution();
            String[] element = br.readLine().trim().split("\\s+");
		    int[] f = new int[N];
		    for(int i = 0; i < N; i++){
		        f[i] = Integer.parseInt(element[i]);
		    }
            ArrayList<String> res  = ob.huffmanCodes(S,f,N);
            for(int i = 0; i < res.size(); i++)
            {
                System.out.print(res.get(i)+" ");
            }
            System.out.println();
        }
	}
}// } Driver Code Ends


//User function Template for Java

class Node implements Comparable<Node>{
       int data;
       Node left;
       Node right;
       Node(int data){
           this.data=data;
           this.left=left;
           this.right=right;
       }
       public int compareTo(Node o){
           if(this.data == o.data){
               return 1;
           }
           return this.data-o.data;
       }
   }


class Solution {
     ArrayList<String> ans = new ArrayList<String>();

    public ArrayList<String> huffmanCodes(String S, int f[], int N){
      
       // Code here
Node root=null;
PriorityQueue<Node> pq = new PriorityQueue<>();
for(int i=0;i<N;i++){
   Node n = new Node(f[i]);
   pq.add(n);
}
while(pq.size()>1){
   Node l=pq.poll();
   Node r=pq.poll();
   root= new Node(l.data+r.data);
   root.left=l;
   root.right=r;
   pq.add(root);
   
}
root=pq.remove();
 sol(root,"");
 return ans;
   }
    public void sol(Node root,String s){
       if(root==null)
           return;
       if(root.left==null&&root.right==null){
           ans.add(s);
           return;
       }    
       if(root.left!=null)
            sol(root.left,s+"0");
       if(root.right!=null)
            sol(root.right,s+"1");
       
   }
}