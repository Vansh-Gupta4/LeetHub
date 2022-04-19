// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class GFG
{
    public static void main(String args[])
    {
        //Taking input using class Scanner 
        Scanner sc = new Scanner(System.in);
        
        //Taking the number of testcases
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            //taking the range
            int n = sc.nextInt();
            
            //creating an ArrayList
            ArrayList<String> res = new ArrayList<String>();
            
            //calling the generate method of class solve
            //and storing the result in an ArrayList
            res = new solve().generate(n);
            
            //printing all the elements of the ArrayList
            for(int i = 0;i<res.size();i++)
                System.out.print(res.get(i) + " ");
            System.out.println();
        }
    }
}// } Driver Code Ends




class solve{
    
    //Function to generate binary numbers from 1 to N using a queue.
    static ArrayList<String> generate(int n){
        // Create an empty queue of strings
        Queue<String> q = new LinkedList<String>();
        ArrayList<String> al = new ArrayList<String>(); 
        // Enqueue the first binary number
        q.add("1");
 
        while (n-- > 0) {
            // print the front of queue
            String s1 = q.peek();
            q.remove();
            // System.out.println(s1);
            al.add(s1);
            // Store s1 before changing it
            String s2 = s1;
 
            // Append "0" to s1 and enqueue it
            q.add(s1 + "0");
 
            // Append "1" to s2 and enqueue it. Note that s2
            // contains the previous front
            q.add(s2 + "1");
        }
        return al;
    }
    
}
