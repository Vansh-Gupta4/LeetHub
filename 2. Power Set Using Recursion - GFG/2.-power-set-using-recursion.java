// { Driver Code Starts
//Initial Template for Java


import java.util.*;
import java.io.*;
import java.lang.*;

class Driver_class
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        //testcases        
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            //input string
            String st = sc.next();
            
            //calling powerSet() function
            ArrayList<String> ans = new LexSort().powerSet(st);
            
            //sorting the result of the powerSet() function
            Collections.sort(ans);
    
            //printing the result
            for(String s: ans)
                System.out.print(s + " ");
            System.out.println();    
        }
    }
}


 // } Driver Code Ends
//User function Template for Java


class LexSort
{
    //Function to return the lexicographically sorted power-set of the string.
    static ArrayList<String> powerSet(String s)
    {
        ArrayList<String> result = new ArrayList<>();
        subsets(s, "", result);
        return result;
    }
    private static void subsets(String input, String output, ArrayList<String> result) {
        if(input.length()==0){
            result.add(output);
            return;
        }
        String out1 = output;
        String out2 = output;
        out2 += input.charAt(0);
        input = input.substring(1);

        subsets(input,out1,result);
        subsets(input,out2,result);
    }
}


 

// { Driver Code Starts.

                                // } Driver Code Ends