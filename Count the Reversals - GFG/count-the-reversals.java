// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            String s = sc.next ();
    		System.out.println (new Sol().countRev (s));
        }
        
    }
}
// Contributed By: Pranay Bansal
// } Driver Code Ends


//User function Template for Java

class Sol
{
    int countRev (String expr)
    {
         int len = expr.length();
        if (len % 2 != 0)
            return -1;
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < len; i++) { //remove balanced part
            char c = expr.charAt(i);
            if (c == '}' && !s.empty()) {
                if (s.peek() == '{')
                    s.pop();
                else
                    s.push(c);
            }
            else
                s.push(c);
        }
 
        int reduced_len = s.size();
        int n = 0;
        while (!s.empty() && s.peek() == '{') {
            s.pop();
            n++;
        }
 
        return (reduced_len / 2 + n % 2);  
    }
}