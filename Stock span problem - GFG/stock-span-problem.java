// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class gfg
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n =sc.nextInt();
            int a[] = new int[n];
            
            int i = 0;
            for(i = 0; i < n; i++)
              a[i] = sc.nextInt();
              
            int[] s = new Solution().calculateSpan(a, n);
            
            for(i = 0; i < n; i++)
            {
                System.out.print(s[i] + " ");
            }
            
            System.out.println();
        }
    }
    
    
    
}// } Driver Code Ends



class Solution
{
    //Function to calculate the span of stockâ€™s price for all n days.
    public static int[] calculateSpan(int price[], int n){
        int [] S=new int[price.length];
        Stack<Integer> st = new Stack<>();
        st.push(0);
 
        // Span value of first element is always 1
        S[0] = 1;
 
        // Calculate span values for rest of the elements
        for (int i = 1; i < n; i++) {
 
            // Pop elements from stack while stack is not
            // empty and top of stack is smaller than
            // price[i]
            while (!st.empty() && price[st.peek()] <= price[i]){
                st.pop();
            }

            if(st.empty()){
                S[i] = i+1;
            }else{
                S[i] =i - st.peek();
            }
            st.push(i);
        }
        return S;
    }
    
}