// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG
{
    public static void main (String[] args)
    {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for(int i=0;i<t;i++){
		    String s = in.next();
		    if (new Sol().isPossible (s) == 1)
		        System.out.println ("Yes");
		    else
		        System.out.println ("No");
		}
	}
}

// Contributed By: Pranay Bansal

// } Driver Code Ends


class Sol
{
    int isPossible (String s){
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<s.length();i++){  //first windom ka freq map
            char ch=s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        int odd=0;
        for(char ch:map.keySet()){
            if(map.get(ch)%2==1){
                odd++;
            }
        }
        if(odd>1){
            return 0;
        }else{
            return 1;
        }
    }
}