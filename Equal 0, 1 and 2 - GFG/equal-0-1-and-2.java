// { Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            String str = read.readLine().trim();
            Solution obj = new Solution();
            System.out.println(obj.getSubstringWithEqual012(str));
        }
    }
}// } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    long getSubstringWithEqual012(String str) { 
        long count=0;
        HashMap<String,Integer> map=new HashMap<>();
        int c0=0;
        int c1=0;
        int c2=0;
        String key = (c1-c0) + "#" + (c2-c1);
        map.put(key,1);
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='0'){
                c0++;
            }else if(str.charAt(i)=='1'){
                c1++;
            }else{
                c2++;
            }
            key = (c1-c0) + "#" + (c2-c1);
            if(map.containsKey(key)){
                count+=map.get(key);
                map.put(key,map.get(key)+1);
            }else{
                map.put(key,1);
            }
        }
        return count;
    }
} 