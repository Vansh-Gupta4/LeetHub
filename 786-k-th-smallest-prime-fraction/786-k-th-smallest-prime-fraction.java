class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int n=arr.length;
        double lo=arr[0]/(double)arr[n-1];
        double hi=1;
        
        while(lo<hi){
            double mid=(lo+hi)/2;
            int values[]=func(arr,mid);  //return count,numerator and denominator
            if(k<values[0]){
                hi=mid;
            }else if(k>values[0]){
                lo=mid;
            }else{  //we got answer
                return new int[]{values[1],values[2]}; 
            }
        }
        return null;
    }
    public static int[] func(int[] arr, double target){
        int count=0;
        int i=0;
        int n=arr.length;
        int num=arr[0],deno=arr[n-1];
        for(int j=1;j<n;j++){
            while(arr[i]<=target*arr[j]){
                i++;
            }
            count+=i;
            if(i>0 && arr[i-1]*deno>arr[j]*num){
                num=arr[i-1];
                deno=arr[j];
            }
        }
        return new int[] {count,num,deno};
    }
}