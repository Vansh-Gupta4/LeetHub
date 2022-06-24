// { Driver Code Starts
//Initial template for JAVA

import java.util.*;
import java.lang.*;
class GFG {
    public static void main(String[] args)
    {   Scanner sc = new Scanner(System.in);
    	int t=sc.nextInt();
    	while(t-->0)
    	{
    		String str1=sc.next();
    		String str2=sc.next();
    		int k=sc.nextInt();
            Solution ob = new Solution();
    		if (ob.areKAnagrams(str1, str2, k) == true)
    			System.out.println("1");
    		else
    			System.out.println("0");
    	}
    }
}// } Driver Code Ends


//User function template for JAVA

class Solution {
    boolean areKAnagrams(String s1, String s2, int k) {
        if(s1.length()!=s2.length()){
            return false;
        }
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<s1.length();i++){
            char ch=s1.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        for(int i=0;i<s2.length();i++){
            char ch=s2.charAt(i);
            if(map.getOrDefault(ch,0)>0){   //agar nhi h present toh 0 daal diya par fir yeh if condition nhi chalega
                map.put(ch,map.get(ch)-1);
            }
        }
        int count=0;
        for(int value:map.values()){
            count+=value;
        }
        if(count<=k){
            return true;
        }else{
            return false;
        }
    }
}