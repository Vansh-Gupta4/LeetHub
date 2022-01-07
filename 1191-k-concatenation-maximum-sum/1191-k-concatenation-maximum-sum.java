class Solution {
    public int kConcatenationMaxSum(int[] arr, int k) {
         long sum = sum(arr);
         long res = 0;
         long x = 1000000007;
         if (k == 1){
           res = kadane(arr);  
         } 
         else if(sum < 0){
              res = kadaneTwo(arr);  
        } 
         else{
              res = kadaneTwo(arr) + (k - 2)*sum;
        }
         if (res < 0){
            return 0;  
         } 
         return (int)(res % x);
    }
    public long kadaneTwo(int arr[]) {
        int narr[] = new int[arr.length * 2];
        for (int i = 0; i < arr.length; i++) {
            narr[i] = arr[i];
        }
         for (int i = 0; i < arr.length; i++){
             narr[i + arr.length] = arr[i];
         }
        return kadane(narr);
    }
    public long sum(int arr[]) {
        long s = 0;
        for (int i = 0; i < arr.length; i++){
            s += arr[i];
        }
         return s;
    }
      public long kadane (int arr[]) {
        long sum=0;
        long max=arr[0];
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            if(sum>max){
                max=sum;
            }
            if(sum<0){
                sum=0;
            }
        }
        return max;
    }
}