// { Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            String str=br.readLine();
    		String[] starr=str.split(" ");
    		
    		//input n and d
    	    int n=Integer.parseInt(starr[0]);
    		int k= Integer.parseInt(starr[1]);
            
            starr = br.readLine().trim().split(" ");
            int[] price = new int[n];
            for(int i = 0; i < n; i++)
                price[i] = Integer.parseInt(starr[i]);
            
            Solution obj = new Solution();
            int res = obj.buyMaximumProducts(n, k, price);
            
            System.out.println(res);
            
        }
    }
}
// } Driver Code Ends

class Pair{
    int first, second;
    Pair(int first,int second){
        this.first=first;
        this.second=second;
    }
}
class SortPair implements Comparator<Pair>{
    public int compare(Pair a,Pair b){
        return a.first-b.first;
    }
}
class Solution {
    public static int buyMaximumProducts(int n, int k, int[] prices) {
        Pair[] arr=new Pair[n];
        
        for(int i=0;i<n;i++){
            arr[i]=new Pair(prices[i],i+1);
        }
        
        Arrays.sort(arr, new SortPair());
        int stockCount=0;
        for(int i=0;i<n;i++){
            int price=arr[i].first;
            int stocks=arr[i].second;
            if(price*stocks<=k){
                stockCount+=stocks;
                k-=(price*stocks);
            }else{
                stockCount+=k/price;
                k-=price * (k/price);
            }
        }
        return stockCount;
    }
}
        
