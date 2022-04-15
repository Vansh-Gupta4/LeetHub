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
            int n = Integer.parseInt(br.readLine().trim());
            long a[] = new long[(int)(n)];
            // long getAnswer[] = new long[(int)(n)];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(inputLine[i]);
            }
            int k = Integer.parseInt(br.readLine().trim());
            
            Compute obj = new Compute();
            long answer[] = obj.printFirstNegativeInteger(a, n, k);
            int sz = answer.length;
            
            StringBuilder output = new StringBuilder();
            for(int i=0;i<sz;i++)
                output.append(answer[i]+" ");
            System.out.println(output);
            
        }
	}
}

// } Driver Code Ends


//User function Template for Java


class Compute {
    
   public long[] printFirstNegativeInteger(long A[], int N, int K)
   {
       Queue<Long> que = new LinkedList<>();
       List<Long> list = new ArrayList<>();
       for(int i=0;i<K-1;i++){
           if(A[i]<0) que.add(A[i]);
       }
       int l=0,u=K-1;
       while(u<N){
           if(A[u]<0) que.add(A[u]);
           //System.out.println(que.peek());
           if(que.peek()!=null && A[l] == que.peek()){
              // System.out.println(A[l]);
               list.add(que.peek());
               que.remove();
           }
           else if(que.peek()==null){long zero=0; list.add(zero);}
           else list.add(que.peek());
           
           l++;u++;
       }
       int size = list.size();
      long []ans =new long[size];
      for(int i=0;i<size;i++) ans[i]=list.get(i);
       //ans[0]=0;
       return ans;
   }
}